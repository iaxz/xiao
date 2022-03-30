package plus.axz.admin.controller.v1;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plus.axz.admin.service.BadgeService;
import plus.axz.api.admin.BadgeControllerApi;
import plus.axz.model.admin.dtos.BadgeDto;
import plus.axz.model.admin.pojos.Badge;
import plus.axz.model.common.dtos.ResponseResult;
import plus.axz.model.common.enums.ResultEnum;

import java.util.List;

/**
 * @author xiaoxiang
 * @date 2022年03月29日
 * @particulars
 */
@RestController/*两个注解的意思：1(Controller)加到spingboot容器管理,2(ResponseBody)将方法的返回值转成json并响应回去*/
@RequestMapping("/api/v1/badge")/*请求映射*/
public class BadgeController implements BadgeControllerApi {
    @Autowired
    private BadgeService badgeService;

    @Override
    @PostMapping("/list")
    public ResponseResult findByNameAndPage(@RequestBody BadgeDto dto) {
        return badgeService.findByNameAndPage(dto);
    }

    @Override
    @PostMapping("/save")
    public ResponseResult save(@RequestBody Badge badge) {
        return badgeService.insert(badge);
    }

    @Override
    @PostMapping("/update")
    public ResponseResult update(@RequestBody Badge badge) {
        return badgeService.update(badge);
    }

    @Override
    @DeleteMapping("/del/{id}")
    public ResponseResult deleteById(@PathVariable("id") Integer id) {
        return badgeService.deleteById(id);
    }

    @Override
    @GetMapping("/badges")
    public ResponseResult findAll() {
        List<Badge> list = badgeService.list();
        return ResponseResult.okResult(list);
    }

    @Override
    @GetMapping("/findBadgeName/{search}")
    public ResponseResult findBadgeName(@PathVariable("search") String search) {
        List<Badge> list = badgeService.list(Wrappers.<Badge>lambdaQuery().eq(Badge::getBadge_name, search));
        if (list == null && !list.isEmpty()) {
            return ResponseResult.okResult(list.get(0));
        }
        return ResponseResult.errorResult(ResultEnum.PARAM_INVALID,"搜索失败");
    }
}
