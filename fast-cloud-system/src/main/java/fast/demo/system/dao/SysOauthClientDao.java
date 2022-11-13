package fast.demo.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fast.demo.framework.common.dao.BaseDao;
import fast.demo.system.entity.SysOauthClientEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户端管理
 *
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface SysOauthClientDao extends BaseDao<SysOauthClientEntity> {

    default SysOauthClientEntity getByClientId(String clientId) {
        return this.selectOne(new QueryWrapper<SysOauthClientEntity>().eq("client_id", clientId));
    }
}
