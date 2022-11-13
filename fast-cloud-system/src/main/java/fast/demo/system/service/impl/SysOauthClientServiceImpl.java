package fast.demo.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import fast.demo.framework.common.page.PageResult;
import fast.demo.framework.common.query.Query;
import fast.demo.framework.common.service.impl.BaseServiceImpl;
import fast.demo.system.convert.SysOauthClientConvert;
import fast.demo.system.dao.SysOauthClientDao;
import fast.demo.system.entity.SysOauthClientEntity;
import fast.demo.system.service.SysOauthClientService;
import fast.demo.system.vo.SysOauthClientVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户端管理
 *
 * @author 阿沐 babamu@126.com
 */
@Service
public class SysOauthClientServiceImpl extends BaseServiceImpl<SysOauthClientDao, SysOauthClientEntity>
        implements SysOauthClientService {

    @Override
    public PageResult<SysOauthClientVO> page(Query query) {
        IPage<SysOauthClientEntity> page = baseMapper.selectPage(getPage(query), Wrappers.emptyWrapper());

        return new PageResult<>(SysOauthClientConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public void save(SysOauthClientVO vo) {
        SysOauthClientEntity entity = SysOauthClientConvert.INSTANCE.convert(vo);
        //entity.setAuthorizedGrantTypes(JsonUtils.toJsonString(vo.getAuthorizedGrantTypes()));

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysOauthClientVO vo) {
        SysOauthClientEntity entity = SysOauthClientConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }
}
