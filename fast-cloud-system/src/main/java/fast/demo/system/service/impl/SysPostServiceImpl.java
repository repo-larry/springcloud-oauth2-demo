package fast.demo.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import fast.demo.framework.common.page.PageResult;
import fast.demo.framework.common.service.impl.BaseServiceImpl;
import fast.demo.system.convert.SysPostConvert;
import fast.demo.system.dao.SysPostDao;
import fast.demo.system.entity.SysPostEntity;
import fast.demo.system.query.SysPostQuery;
import fast.demo.system.service.SysPostService;
import fast.demo.system.service.SysUserPostService;
import fast.demo.system.vo.SysPostVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 岗位管理
 *
 * @author 阿沐 babamu@126.com
 */
@Service
@AllArgsConstructor
public class SysPostServiceImpl extends BaseServiceImpl<SysPostDao, SysPostEntity> implements SysPostService {
    private final SysUserPostService sysUserPostService;

    @Override
    public PageResult<SysPostVO> page(SysPostQuery query) {
        IPage<SysPostEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysPostConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<SysPostVO> getList() {
        SysPostQuery query = new SysPostQuery();
        //正常岗位列表
        query.setStatus(1);
        List<SysPostEntity> entityList = baseMapper.selectList(getWrapper(query));

        return SysPostConvert.INSTANCE.convertList(entityList);
    }

    private QueryWrapper<SysPostEntity> getWrapper(SysPostQuery query) {
        QueryWrapper<SysPostEntity> wrapper = new QueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getPostCode()), "post_code", query.getPostCode());
        wrapper.like(StrUtil.isNotBlank(query.getPostName()), "post_name", query.getPostName());
        wrapper.eq(query.getStatus() != null, "status", query.getStatus());
        wrapper.orderByAsc("sort");

        return wrapper;
    }

    @Override
    public void save(SysPostVO vo) {
        SysPostEntity entity = SysPostConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysPostVO vo) {
        SysPostEntity entity = SysPostConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        // 删除岗位
        removeByIds(idList);

        // 删除岗位用户关系
        sysUserPostService.deleteByPostIdList(idList);
    }

}