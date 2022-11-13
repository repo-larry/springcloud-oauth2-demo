package fast.demo.system.dao;

import fast.demo.framework.common.dao.BaseDao;
import fast.demo.system.entity.SysPostEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 岗位管理
 *
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface SysPostDao extends BaseDao<SysPostEntity> {

}