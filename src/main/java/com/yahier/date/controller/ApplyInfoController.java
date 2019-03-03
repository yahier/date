package com.yahier.date.controller;

import com.yahier.date.pojo.BaseResp;
import com.yahier.date.pojo.Fail;
import com.yahier.date.pojo.Success;
import com.yahier.date.repository.ApplyInfoRepository;
import com.yahier.date.table.ApplyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apply")
public class ApplyInfoController {

    @Autowired
    private ApplyInfoRepository applyRepository;

    /**
     * 报名
     */
    @RequestMapping(value = "/join", produces = {"application/json;charset=UTF-8"})
    public BaseResp join(ApplyInfo applyInfo) {
        String verifyResult = DataUtils.verify(applyInfo);
        if (verifyResult != null) {
            return new Fail(verifyResult);
        } else {
            applyRepository.save(applyInfo);
            return new Success();
        }
    }

    /**
     * 退出
     */
    @RequestMapping(value = "/quit", produces = {"application/json;charset=UTF-8"})
    public BaseResp quit(Long id) {
        boolean isExist = applyRepository.existsById(id);
        if (!isExist) {
            return new Fail();
        } else {
            applyRepository.deleteById(id);
            return new Success();
        }
    }

    /**
     * 查询一场活动的报名信息 todo接口查询语句需要验证
     */
    @RequestMapping(value = "/listForActivity", produces = {"application/json;charset=UTF-8"})
    public List<ApplyInfo> listForActivity(Long activityId) {
        return applyRepository.listForActivity(activityId);
    }

    /**
     * 查询用户的报名信息
     */
    @RequestMapping(value = "/listForUser", produces = {"application/json;charset=UTF-8"})
    public List<ApplyInfo> listForUser(Long userId) {
        return applyRepository.listForUser(userId);
    }

}
