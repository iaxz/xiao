package plus.axz.api.behavior;

import io.swagger.annotations.ApiOperation;
import plus.axz.model.behavior.dtos.LikesBehaviorDto;
import plus.axz.model.behavior.pojos.LikesBehavior;
import plus.axz.model.common.dtos.ResponseResult;

/**
 * @author xiaoxiang
 * @date 2022年06月21日
 * @particulars
 */
public interface LikesBehaviorControllerApi {
    @ApiOperation("保存点赞行为")
    ResponseResult like(LikesBehaviorDto dto);

    // 点赞远程接口
    @ApiOperation("根据行为实体id和文章id查询点赞行为")
    public LikesBehavior findLikeByArticleIdAndEntryId(Long articleId, Integer entryId, Short type);/*type点赞文章内容的类型*/
}
