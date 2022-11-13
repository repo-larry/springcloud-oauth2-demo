package fast.demo.system.service;

import fast.demo.framework.common.page.PageResult;
import fast.demo.framework.common.service.BaseService;
import fast.demo.system.entity.SysPostEntity;
import fast.demo.system.query.SysPostQuery;
import fast.demo.system.vo.SysPostVO;

import java.util.List;

/**
 * 岗位管理
 *
 * @author 阿沐 babamu@126.com
 */
public interface SysPostService extends BaseService<SysPostEntity> {

    PageResult<SysPostVO> page(SysPostQuery query);

    List<SysPostVO> getList();

    void save(SysPostVO vo);

    void update(SysPostVO vo);

    void delete(List<Long> idList);
}