package com.mshri.app.service;

import com.mshri.app.entity.Slot;
import com.mshri.app.service.interfaces.ICenterService;
import com.mshri.app.service.interfaces.IUserService;
import com.mshri.app.service.interfaces.IWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    private IUserService userService;

    @Autowired
    private ICenterService centerService;

    @Autowired
    private IWorkoutService workoutService;

    public  void runApp()
    {
        System.out.println("YOU FIT APP STARTED");

        //ASSUPTIONS
        //"addded validation in user service add user method to check if a user  already exists similarly will do in all service";
        //"added activities as string however it will be enum in real case";
        //"added souts for debugging";

        userService.addUser("Mohit");
        userService.addUser("Mohit");

        //centerService.addCenter("Bellandur");
        centerService.addCenter("Kormangla");
        centerService.getCenterInfo();
        Slot slot1 = new Slot(6,9);
        Slot slot2 = new Slot(18,21);
        List<Slot> slotList = new ArrayList<>();
        slotList.add(slot1);slotList.add(slot2);
        centerService.addCenterTimings("Kormangla",slotList);
        centerService.getCenterInfo();
        List<String> activityList = new ArrayList<>(Arrays.asList("Weights", "Cardio", "Yoga", "Swimming"));
        centerService.addCenterActivities("Kormangla",activityList);
        centerService.getCenterInfo();
        workoutService.addWorkoutToCenter("Kormangla","Aerobics",slot1,100);
        workoutService.addWorkoutToCenter("Kormangla","Yoga",slot1,100);
        centerService.getCenterInfo();

    }
}
