package fast.demo.system.convert;

import fast.demo.system.entity.SysOauthClientEntity;
import fast.demo.system.vo.SysOauthClientVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SysOauthClientConvert {
    SysOauthClientConvert INSTANCE = Mappers.getMapper(SysOauthClientConvert.class);

    SysOauthClientVO convert(SysOauthClientEntity entity);

    SysOauthClientEntity convert(SysOauthClientVO vo);

    List<SysOauthClientVO> convertList(List<SysOauthClientEntity> list);

}
