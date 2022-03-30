package plus.axz.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import plus.axz.model.common.dtos.ResponseResult;
import plus.axz.model.wemedia.WmUser;

/**
 * @author xiaoxiang
 * @date 2022年03月25日
 * @particulars
 */
@FeignClient("xiao-wemedia")
public interface WemediaFeign {
    @PostMapping("/api/v1/user/save")
    public ResponseResult save(@RequestBody WmUser wmUser);

    @GetMapping("/api/v1/user/findByName/{name}")
    public WmUser findByName(@PathVariable("name") String name);
}
