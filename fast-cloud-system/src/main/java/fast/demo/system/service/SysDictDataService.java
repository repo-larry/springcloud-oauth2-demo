package fast.demo.system.service;

import fast.demo.framework.common.page.PageResult;
import fast.demo.framework.common.service.BaseService;
import fast.demo.system.entity.SysDictDataEntity;
import fast.demo.system.query.SysDictDataQuery;
import fast.demo.system.vo.SysDictDataVO;

import java.util.List;

/**
 * 数据字典
 *
 * @author 阿沐 babamu@126.com
 */
public interface SysDictDataService extends BaseService<SysDictDataEntity> {

    PageResult<SysDictDataVO> page(SysDictDataQuery query);

    void save(SysDictDataVO vo);

    void update(SysDictDataVO vo);

    void delete(List<Long> idList);

}