package fast.demo.system.controller;

import fast.demo.framework.common.page.PageResult;
import fast.demo.framework.common.query.Query;
import fast.demo.framework.common.utils.Result;
import fast.demo.system.convert.SysOauthClientConvert;
import fast.demo.system.entity.SysOauthClientEntity;
import fast.demo.system.service.SysOauthClientService;
import fast.demo.system.vo.SysOauthClientVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 客户端管理
 *
 * @author 阿沐 babamu@126.com
 */
@RestController
@RequestMapping("client")
@Tag(name = "客户端管理")
@AllArgsConstructor
public class SysOauthClientController {
    private final SysOauthClientService sysOauthClientService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:client:page')")
    public Result<PageResult<SysOauthClientVO>> page(@Valid Query query) {
        PageResult<SysOauthClientVO> page = sysOauthClientService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('sys:client:info')")
    public Result<SysOauthClientVO> get(@PathVariable("id") Long id) {
        SysOauthClientEntity entity = sysOauthClientService.getById(id);

        return Result.ok(SysOauthClientConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('sys:client:save')")
    public Result<String> save(@RequestBody SysOauthClientVO vo) {
        sysOauthClientService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('sys:client:update')")
    public Result<String> update(@RequestBody @Valid SysOauthClientVO vo) {
        sysOauthClientService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('sys:client:delete')")
    public Result<String> delete(@RequestBody List<Long> idList) {
        sysOauthClientService.delete(idList);

        return Result.ok();
    }
}
