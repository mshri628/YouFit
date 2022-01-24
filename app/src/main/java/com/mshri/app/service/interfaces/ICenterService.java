package com.mshri.app.service.interfaces;

import com.mshri.app.entity.Center;
import com.mshri.app.entity.Slot;
import com.mshri.app.entity.Workout;

import java.util.List;
import java.util.Map;

public interface ICenterService {
    public void addCenter(String name);
    public void addCenterTimings(String centerName, List<Slot> slotList);
    public void addCenterActivities(String centerName,List<String> activities);
    public Map<String, Center> getCenterList();
    public void getCenterInfo();
    public void addWorkoutToCenter(String centerName, Workout workout);

}
