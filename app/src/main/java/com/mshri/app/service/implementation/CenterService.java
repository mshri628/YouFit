package com.mshri.app.service.implementation;

import com.mshri.app.entity.Center;
import com.mshri.app.entity.Slot;
import com.mshri.app.entity.Workout;
import com.mshri.app.service.interfaces.ICenterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CenterService implements ICenterService {

    private Map<String, Center> centerListMap = new HashMap<>();
    @Override
    public void addCenter(String name) {
        System.out.printf("method addCenter called for %s\n",name);
        Center center = new Center(name,new ArrayList<Slot>(),new ArrayList<>(),new ArrayList<Workout>());
        centerListMap.put(name,center);
        System.out.printf("ADDED CENTER SUCESSFULLY num  center %d\n",centerListMap.size());

    }

    @Override
    public void addCenterTimings(String centerName, List<Slot> slotList) {
        System.out.printf("method addCenterTimings called for %s\n",centerName);
        Center center = centerListMap.get(centerName);
        List<Slot> centerSlotList= center.getSlotList();
        centerSlotList.addAll(slotList);
        center.setSlotList(centerSlotList);
        System.out.printf("ADDED TIMINGS SUCESSFULLY num timing for center %d\n",centerSlotList.size());
    }

    @Override
    public void addCenterActivities(String centerName, List<String> activities) {
        System.out.printf("method addCenterActivities called for %s\n",centerName);
        Center center = centerListMap.get(centerName);
        List<String> centerActivityList= center.getActivities();
        centerActivityList.addAll(activities);
        center.setActivities(centerActivityList);
        System.out.printf("ADDED ACTIVITIES SUCESSFULLY num activity for center %d\n",centerActivityList.size());

    }

    @Override
    public Map<String, Center> getCenterList() {
        return centerListMap;
    }

    @Override
    public void getCenterInfo() {
        System.out.printf("************Total centers=%d***********\n",centerListMap.size());
        for(Center c:centerListMap.values())
        {
            System.out.println(c.toString());
        }
    }

    @Override
    public void addWorkoutToCenter(String centerName, Workout workout) {
        Center c= centerListMap.get(centerName);
        List<Workout> workoutList = c.getWorkoutList();
        workoutList.add(workout);
        c.setWorkoutList(workoutList);
        centerListMap.put(centerName,c);
        System.out.printf("Sucessfully added workout to center-%s\n",centerName);
    }
}
