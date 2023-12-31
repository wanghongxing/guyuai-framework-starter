package com.guyuai.module.member.api.address;

import com.guyuai.module.member.api.address.dto.AddressRespDTO;
import com.guyuai.module.member.convert.address.AddressConvert;
import com.guyuai.module.member.service.address.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 用户收件地址 API 实现类
 *
 * @author 谷雨源码
 */
@Service
@Validated
public class AddressApiImpl implements AddressApi {

    @Resource
    private AddressService addressService;

    @Override
    public AddressRespDTO getAddress(Long id, Long userId) {
        return AddressConvert.INSTANCE.convert02(addressService.getAddress(userId, id));
    }

}
