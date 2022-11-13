package fast.demo.system.dao;

import fast.demo.framework.common.dao.BaseDao;
import fast.demo.system.entity.SysUserPostEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户岗位关系
 *
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface SysUserPostDao extends BaseDao<SysUserPostEntity> {

    /**
     * 岗位ID列表
     *
     * @param userId 用户ID
     */
    List<Long> getPostIdList(@Param("userId") Long userId);
}