package com.guyuai.module.member.dal.mysql.address;

import com.guyuai.framework.mybatis.core.mapper.BaseMapperX;
import com.guyuai.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.guyuai.module.member.dal.dataobject.address.AddressDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper extends BaseMapperX<AddressDO> {

    default AddressDO selectByIdAndUserId(Long id, Long userId) {
        return selectOne(AddressDO::getId, id, AddressDO::getUserId, userId);
    }

    default List<AddressDO> selectListByUserIdAndDefaulted(Long userId, Boolean defaulted) {
        return selectList(new LambdaQueryWrapperX<AddressDO>().eq(AddressDO::getUserId, userId)
                .eqIfPresent(AddressDO::getDefaulted, defaulted));
    }

}
