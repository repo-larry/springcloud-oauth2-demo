package fast.demo.system.service;

import fast.demo.framework.common.page.PageResult;
import fast.demo.framework.common.service.BaseService;
import fast.demo.system.entity.SysRoleEntity;
import fast.demo.system.query.SysRoleQuery;
import fast.demo.system.vo.SysRoleVO;

import java.util.List;

/**
 * 角色
 *
 * @author 阿沐 babamu@126.com
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {

    PageResult<SysRoleVO> page(SysRoleQuery query);

    List<SysRoleVO> getList(SysRoleQuery query);

    void save(SysRoleVO vo);

    void update(SysRoleVO vo);

    void delete(List<Long> idList);
}
