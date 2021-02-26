package com.lxl.service.impl;

import com.github.benmanes.caffeine.cache.Cache;
import com.lxl.entity.UserInfo;
import com.lxl.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@CacheConfig(cacheNames = "caffeineCacheManager")
public class UserInfoServiceImpl implements UserInfoService {

    /**
     * 模拟数据库存储数据
     */
    private HashMap<Integer,UserInfo> userInfoMap = new HashMap<>();


    @Override
    @CachePut(key = "#userInfo.id")
    public void addUserInfo(UserInfo userInfo) {
        log.info("add");
        userInfoMap.put(userInfo.getId(),userInfo);
    }

    @Override
    @Cacheable(key = "#id")
    public UserInfo getByName(Integer id) {
        log.info("get");
        return userInfoMap.get(id);
    }

    @Override
    @Cacheable(key = "#userInfo.id")
    public UserInfo updateUserInfo(UserInfo userInfo) {
        log.info("update");
        UserInfo oldUserInfo=userInfoMap.get(userInfo.getId());
        if(oldUserInfo==null){
            return null;
        }
        userInfoMap.put(userInfo.getId(),userInfo);
        return userInfo;
    }

    @Override
    @CacheEvict(key = "#id")
    public void deleteById(Integer id) {

        log.info("delete");
        userInfoMap.remove(id);

    }
}
