package com.guyuai.module.system.dal.mysql.permission;

import com.guyuai.framework.mybatis.core.mapper.BaseMapperX;
import com.guyuai.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.guyuai.module.system.controller.admin.permission.vo.menu.MenuListReqVO;
import com.guyuai.module.system.dal.dataobject.permission.MenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapperX<MenuDO> {

    default MenuDO selectByParentIdAndName(Long parentId, String name) {
        return selectOne(MenuDO::getParentId, parentId, MenuDO::getName, name);
    }

    default Long selectCountByParentId(Long parentId) {
        return selectCount(MenuDO::getParentId, parentId);
    }

    default List<MenuDO> selectList(MenuListReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MenuDO>()
                .likeIfPresent(MenuDO::getName, reqVO.getName())
                .eqIfPresent(MenuDO::getStatus, reqVO.getStatus()));
    }

}
