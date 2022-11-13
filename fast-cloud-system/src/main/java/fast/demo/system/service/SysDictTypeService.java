package fast.demo.system.service;

import fast.demo.framework.common.page.PageResult;
import fast.demo.framework.common.service.BaseService;
import fast.demo.system.entity.SysDictTypeEntity;
import fast.demo.system.query.SysDictTypeQuery;
import fast.demo.system.vo.SysDictTypeVO;
import fast.demo.system.vo.SysDictVO;

import java.util.List;

/**
 * 数据字典
 *
 * @author 阿沐 babamu@126.com
 */
public interface SysDictTypeService extends BaseService<SysDictTypeEntity> {

    PageResult<SysDictTypeVO> page(SysDictTypeQuery query);

    void save(SysDictTypeVO vo);

    void update(SysDictTypeVO vo);

    void delete(List<Long> idList);

    /**
     * 获取全部字典列表
     */
    List<SysDictVO> getDictList();

}