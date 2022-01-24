package com.mshri.app.utils;

import com.mshri.app.entity.Center;
import com.mshri.app.entity.Slot;

import java.util.List;

public class HelperUtils {
    private HelperUtils()
    {}

    public static Boolean validateWorkoutForCenter(Center center, String activity, Slot slot, Integer capacity) {
        System.out.printf("Validating workout  in center");
        return checkWorkoutTime(slot,center.getSlotList()) && chekcAvailableActivity(activity,center.getActivities());
    }

    private static boolean chekcAvailableActivity(String activity, List<String> activities) {
        System.out.printf("Checking workout activity avaibility in center");
        if(activities.contains(activity)){
            System.out.printf("Avtivity- %s avaialable\n",activity);
            return true;
        }
        else {
            System.out.printf("ERROR Avtivity- %s is not avaialable\n",activity);
            return false;
        }
    }

    private static boolean checkWorkoutTime(Slot slot, List<Slot> slotList) {
        System.out.printf("Checking workout slot avaibility in center timings");
        Boolean isSlotaAvailable=false;
        for(Slot centerSlot:slotList)
        {
            if(slot.getStartTime()>=centerSlot.getStartTime() && slot.getStopTime()<= centerSlot.getStopTime())
            {
                isSlotaAvailable=true;
                break;
            }
        }

        System.out.printf("slot available- %s \n",isSlotaAvailable.toString());
        return isSlotaAvailable;
    }

}
