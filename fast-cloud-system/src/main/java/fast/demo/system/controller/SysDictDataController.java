package fast.demo.system.controller;

import fast.demo.framework.common.page.PageResult;
import fast.demo.framework.common.utils.Result;
import fast.demo.system.convert.SysDictDataConvert;
import fast.demo.system.entity.SysDictDataEntity;
import fast.demo.system.query.SysDictDataQuery;
import fast.demo.system.service.SysDictDataService;
import fast.demo.system.vo.SysDictDataVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 字典数据
 *
 * @author 阿沐 babamu@126.com
 */
@RestController
@RequestMapping("dict/data")
@Tag(name = "字典数据")
@AllArgsConstructor
public class SysDictDataController {
    private final SysDictDataService sysDictDataService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:dict:page')")
    public Result<PageResult<SysDictDataVO>> page(@Valid SysDictDataQuery query) {
        PageResult<SysDictDataVO> page = sysDictDataService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('sys:dict:info')")
    public Result<SysDictDataVO> get(@PathVariable("id") Long id) {
        SysDictDataEntity entity = sysDictDataService.getById(id);

        return Result.ok(SysDictDataConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('sys:dict:save')")
    public Result<String> save(@RequestBody @Valid SysDictDataVO vo) {
        sysDictDataService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('sys:dict:update')")
    public Result<String> update(@RequestBody @Valid SysDictDataVO vo) {
        sysDictDataService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('sys:dict:delete')")
    public Result<String> delete(@RequestBody List<Long> idList) {
        sysDictDataService.delete(idList);

        return Result.ok();
    }

}