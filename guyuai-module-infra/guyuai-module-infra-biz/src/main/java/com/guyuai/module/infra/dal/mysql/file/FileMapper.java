package com.guyuai.module.infra.dal.mysql.file;

import com.guyuai.framework.common.pojo.PageResult;
import com.guyuai.framework.mybatis.core.mapper.BaseMapperX;
import com.guyuai.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.guyuai.module.infra.controller.admin.file.vo.file.FilePageReqVO;
import com.guyuai.module.infra.dal.dataobject.file.FileDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件操作 Mapper
 *
 * @author 谷雨源码
 */
@Mapper
public interface FileMapper extends BaseMapperX<FileDO> {

    default PageResult<FileDO> selectPage(FilePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FileDO>()
                .likeIfPresent(FileDO::getPath, reqVO.getPath())
                .likeIfPresent(FileDO::getType, reqVO.getType())
                .betweenIfPresent(FileDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FileDO::getId));
    }

}
