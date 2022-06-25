package plus.axz.search.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoxiang
 * @date 2022年06月25日
 * @particulars
 */
public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
        root.var = ' ';
    }
    /**
     * 插入trie树
     * @param word
     */
    public void insert(String word){
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!ws.children.keySet().contains(c)){
                ws.children.put(c,new TrieNode(c));
            }
            ws = ws.children.get(c);
        }
        ws.isWord = true;
    }

    /**
     * 查询trie树
     * @param prefix
     * @return
     */
    public List<String> startWith(String prefix){
        List<String> match = new ArrayList<>();
        TrieNode ws = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!ws.children.keySet().contains(c)) return match;
            ws = ws.children.get(c);
            if(!ws.containLongTail){
                for (char cc : ws.children.keySet()){
                    match.add(prefix+cc);
                }
            }else{
                //包含长尾词 从map中取
            }
        }
        return match;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("萧肖");
        t.insert("萧小");
        t.insert("xiao小");
        List<String> ret = t.startWith("萧");/*匹配萧*/
        System.out.println(ret);
    }
}
