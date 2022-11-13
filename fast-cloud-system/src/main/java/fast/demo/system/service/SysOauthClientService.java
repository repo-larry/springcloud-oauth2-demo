package fast.demo.system.service;

import fast.demo.framework.common.page.PageResult;
import fast.demo.framework.common.query.Query;
import fast.demo.framework.common.service.BaseService;
import fast.demo.system.entity.SysOauthClientEntity;
import fast.demo.system.vo.SysOauthClientVO;

import java.util.List;

/**
 * 客户端管理
 *
 * @author 阿沐 babamu@126.com
 */
public interface SysOauthClientService extends BaseService<SysOauthClientEntity> {

    PageResult<SysOauthClientVO> page(Query query);

    void save(SysOauthClientVO vo);

    void update(SysOauthClientVO vo);

    void delete(List<Long> idList);
}
