package com.guyuai.module.system.api.user;

import com.guyuai.module.system.api.user.dto.AdminUserRespDTO;
import com.guyuai.module.system.convert.user.UserConvert;
import com.guyuai.module.system.dal.dataobject.user.AdminUserDO;
import com.guyuai.module.system.service.user.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Admin 用户 API 实现类
 *
 * @author 谷雨源码
 */
@Service
public class AdminUserApiImpl implements AdminUserApi {

    @Resource
    private AdminUserService userService;

    @Override
    public AdminUserRespDTO getUser(Long id) {
        AdminUserDO user = userService.getUser(id);
        return UserConvert.INSTANCE.convert4(user);
    }

    @Override
    public List<AdminUserRespDTO> getUserList(Collection<Long> ids) {
        List<AdminUserDO> users = userService.getUserList(ids);
        return UserConvert.INSTANCE.convertList4(users);
    }

    @Override
    public List<AdminUserRespDTO> getUserListByDeptIds(Collection<Long> deptIds) {
        List<AdminUserDO> users = userService.getUserListByDeptIds(deptIds);
        return UserConvert.INSTANCE.convertList4(users);
    }

    @Override
    public List<AdminUserRespDTO> getUsersByPostIds(Collection<Long> postIds) {
        List<AdminUserDO> users = userService.getUserListByPostIds(postIds);
        return UserConvert.INSTANCE.convertList4(users);
    }

    @Override
    public void validateUserList(Collection<Long> ids) {
        userService.validateUserList(ids);
    }

}
