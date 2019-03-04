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
import java.util.Optional;

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

    @RequestMapping(value = "/get", produces = {"application/json;charset=UTF-8"})
    public Object get(Long id) {
        if (id == null) {
            return new Fail("id参数不对");
        }
        Optional<Activity> optional = activityRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return new Fail("活动不存在");
        }

    }


    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResp add(Activity activity) {
        String verifyErrorResult = DataUtils.verify(activity);
        if (verifyErrorResult == null) {
            activityRepository.save(activity);
            return new Success();
        } else {
            return new Fail(verifyErrorResult);
        }
    }

    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public BaseResp delete(long id) {
        boolean isExist = activityRepository.existsById(id);
        if (!isExist) {
            return new Fail();
        } else {
            activityRepository.deleteById(id);
            return new Success();
        }
    }


    @RequestMapping(value = "/clear", produces = {"application/json;charset=UTF-8"})
    public BaseResp clear() {
        activityRepository.deleteAll();
        return new Success();
    }

}
