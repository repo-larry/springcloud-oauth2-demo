package fast.demo.system.service;

import fast.demo.framework.common.page.PageResult;
import fast.demo.framework.common.service.BaseService;
import fast.demo.system.entity.SysUserEntity;
import fast.demo.system.query.SysUserQuery;
import fast.demo.system.vo.SysUserVO;

import java.util.List;

/**
 * 用户管理
 *
 * @author 阿沐 babamu@126.com
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    PageResult<SysUserVO> page(SysUserQuery query);

    void save(SysUserVO vo);

    void update(SysUserVO vo);

    void delete(List<Long> idList);

    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);

}
