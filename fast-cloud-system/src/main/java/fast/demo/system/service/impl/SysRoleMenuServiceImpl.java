package fast.demo.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fast.demo.framework.common.service.impl.BaseServiceImpl;
import fast.demo.system.dao.SysRoleMenuDao;
import fast.demo.system.entity.SysRoleMenuEntity;
import fast.demo.system.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 角色与菜单对应关系
 *
 * @author 阿沐 babamu@126.com
 */
@Service
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
        // 数据库菜单ID列表
        List<Long> dbMenuIdList = getMenuIdList(roleId);

        // 需要新增的菜单ID
        Collection<Long> insertMenuIdList = CollUtil.subtract(menuIdList, dbMenuIdList);
        if (CollUtil.isNotEmpty(insertMenuIdList)) {
            List<SysRoleMenuEntity> menuList = insertMenuIdList.stream().map(menuId -> {
                SysRoleMenuEntity entity = new SysRoleMenuEntity();
                entity.setMenuId(menuId);
                entity.setRoleId(roleId);
                return entity;
            }).collect(Collectors.toList());

            // 批量新增
            saveBatch(menuList);
        }

        // 需要删除的菜单ID
        Collection<Long> deleteMenuIdList = CollUtil.subtract(dbMenuIdList, menuIdList);
        if (CollUtil.isNotEmpty(deleteMenuIdList)) {
            remove(new QueryWrapper<SysRoleMenuEntity>().eq("role_id", roleId).in("menu_id", deleteMenuIdList));
        }
    }

    @Override
    public List<Long> getMenuIdList(Long roleId) {
        return baseMapper.getMenuIdList(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByRoleIdList(List<Long> roleIdList) {
        remove(new QueryWrapper<SysRoleMenuEntity>().in("role_id", roleIdList));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByMenuId(Long menuId) {
        remove(new QueryWrapper<SysRoleMenuEntity>().eq("menu_id", menuId));
    }

}