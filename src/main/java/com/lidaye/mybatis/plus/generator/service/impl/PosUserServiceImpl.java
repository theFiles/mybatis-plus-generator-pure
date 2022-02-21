package com.lidaye.mybatis.plus.generator.service.impl;

import com.lidaye.mybatis.plus.generator.entity.PosUser;
import com.lidaye.mybatis.plus.generator.mapper.PosUserMapper;
import com.lidaye.mybatis.plus.generator.service.PosUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表,1,uploadImg-userPhoto-YES 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2022-02-21
 */
@Service
public class PosUserServiceImpl extends ServiceImpl<PosUserMapper, PosUser> implements PosUserService {

    /**
     * 增删改查和mybatis-plus的一样
     * 假装测试过
     */
    private void test() {
        // 查
        PosUser user = this.getById(27);
        // 删
        this.removeById(27);
        // 改
        this.updateById(user);
        // 增
        this.save(user);
    }
}
