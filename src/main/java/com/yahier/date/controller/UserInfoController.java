package com.yahier.date.controller;

import com.yahier.date.pojo.BaseResp;
import com.yahier.date.pojo.Fail;
import com.yahier.date.pojo.Success;
import com.yahier.date.repository.UserInfoRepository;
import com.yahier.date.table.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public List<UserInfo> list() {
        List<UserInfo> list = userInfoRepository.findAll();
        System.out.println("size:" + list.size());
        return list;
    }

    @RequestMapping(value = "/clear", produces = {"application/json;charset=UTF-8"})
    public BaseResp clear() {
        userInfoRepository.deleteAll();
        return new Success();
    }

    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    public BaseResp update(long id, UserInfo userInfoNew) {
        System.out.println("update id:" + id);
        Optional<UserInfo> optional = userInfoRepository.findById(id);
        if (!optional.isPresent()) {
            return new Fail();
        }

        userInfoRepository.save(userInfoNew);
        return new Success();
    }

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResp add(UserInfo userInfo) {
        if (userInfo != null) {
            System.out.println("name:" + userInfo.getName());
            String result = DataUtils.verify(userInfo);
            if (result == null) {
                userInfoRepository.save(userInfo);
                return new Success();
            } else {
                return new Fail(result);
            }
        }

        return new Fail();
    }


}
