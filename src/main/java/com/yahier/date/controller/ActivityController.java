package com.yahier.date.controller;

import com.yahier.date.pojo.BaseResp;
import com.yahier.date.pojo.Fail;
import com.yahier.date.pojo.Success;
import com.yahier.date.repository.ActivityRepository;
import com.yahier.date.table.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public List<Activity> list() {
        List<Activity> list = activityRepository.findAll();
        System.out.println("size:" + list.size());
        return list;
    }

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResp add(Activity activity) {
        String verifyResult = DataUtils.verify(activity);
        if (verifyResult == null) {
            activityRepository.save(activity);
            return new Success();
        } else {
            return new Fail(verifyResult);
        }
    }

    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public BaseResp delete(long id) {
        boolean isExist = activityRepository.existsById(id);
        if (!isExist) {
            return new Fail();
        }

        activityRepository.deleteById(id);
        return new Success();
    }


    @RequestMapping(value = "/clear", produces = {"application/json;charset=UTF-8"})
    public BaseResp clear() {
        activityRepository.deleteAll();
        return new Success();
    }

}
