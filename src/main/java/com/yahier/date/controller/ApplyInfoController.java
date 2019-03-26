package com.yahier.date.controller;

import com.yahier.date.pojo.BaseResp;
import com.yahier.date.pojo.Fail;
import com.yahier.date.pojo.Success;
import com.yahier.date.pojo.TestItem;
import com.yahier.date.repository.ApplyInfoRepository;
import com.yahier.date.table.ApplyInfo;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apply")
public class ApplyInfoController {

    @Autowired
    private ApplyInfoRepository applyInfoRepository;

    public String name;

    /**
     * 报名
     */
    @RequestMapping(value = "/join", produces = {"application/json;charset=UTF-8"})
    public BaseResp join(ApplyInfo applyInfo) {

        System.out.println("name:" + name);
        String verifyErrorResult = DataUtils.verify(applyInfo);
        if (verifyErrorResult != null) {
            return new Fail(verifyErrorResult);
        } else {
            applyInfoRepository.save(applyInfo);
            return new Success();
        }
    }

    /**
     * 报名 这样才接收到了 原生的 json字符串
     */
    @RequestMapping(value = "/join2", produces = {"application/json;charset=UTF-8"})
    public BaseResp join2(@RequestBody JSONObject jsonParam) {
        System.out.println("json2" + jsonParam.toJSONString());
        return new Success();
    }

    /**
     * 退出
     */
    @RequestMapping(value = "/quit", produces = {"application/json;charset=UTF-8"})
    public BaseResp quit(Long id) {
        boolean isExist = applyInfoRepository.existsById(id);
        if (!isExist) {
            return new Fail();
        } else {
            applyInfoRepository.deleteById(id);
            return new Success();
        }
    }

    /**
     * 查询全部报名信息
     */
    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public List<ApplyInfo> list() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return applyInfoRepository.findAll();
    }

    /**
     * 查询一场活动的报名信息
     */
    @RequestMapping(value = "/listForActivity", produces = {"application/json;charset=UTF-8"})
    public List<ApplyInfo> listForActivity(Long activityId) {
        return applyInfoRepository.listForActivity(activityId);
    }

    /**
     * 查询用户的报名信息
     */
    @RequestMapping(value = "/listForUser", produces = {"application/json;charset=UTF-8"})
    public List<ApplyInfo> listForUser(Long userId) {
        return applyInfoRepository.listForUser(userId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
