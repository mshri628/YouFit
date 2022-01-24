package com.mshri.app.service.implementation;

import com.mshri.app.entity.Center;
import com.mshri.app.entity.Slot;
import com.mshri.app.entity.Workout;
import com.mshri.app.service.interfaces.ICenterService;
import com.mshri.app.service.interfaces.IWorkoutService;
import com.mshri.app.utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WorkoutService implements IWorkoutService {

    @Autowired
    private ICenterService centerService;

    @Override
    public void addWorkoutToCenter(String centerName, String activity, Slot slot, Integer capacity) {
        //check if center exists
        System.out.printf("Invoked addWorkoutToCenter for center %s activity %s\n",centerName,activity);
        Map<String, Center> centerListMap = centerService.getCenterList();
        if(centerListMap.get(centerName)!=null)
        {
            Center center = centerListMap.get(centerName);
            if(Boolean.TRUE.equals(HelperUtils.validateWorkoutForCenter(center,activity,slot,capacity)))
            {
                //add workout to center with vacancy as initial capacity
                Workout workout = new Workout(activity,slot,capacity,capacity);
                centerService.addWorkoutToCenter(centerName,workout);

            }
        }
    }



}
