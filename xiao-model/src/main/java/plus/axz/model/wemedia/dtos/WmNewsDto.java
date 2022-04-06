package plus.axz.model.wemedia.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author xiaoxiang
 * @date 2022年04月04日
 * @particulars 保存、修改文章，保存草稿
 */
@Data
public class WmNewsDto {
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * tag标签id
     */
    private Integer Tag;
    /**
     * 文章分类标签
     */
    private String labels;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 文章封面类型  0 无图 1 单图 3 多图 -1 自动
     */
    private Short type;
    /**
     * 是否上架 0 下架 1 上架
     */
    private Short enable;
    /**
     * 提交时间
     */
    private Date submitedTime;
    /**
     * 状态    提交为1  草稿为0
     */
    private Short status;
    /**
     * 拒绝理由
     */
    private String reason;
    /**
     * 封面图片列表    多张图以逗号隔开
     */
    private List<String> images;
}
