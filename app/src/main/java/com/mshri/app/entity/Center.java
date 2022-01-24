package com.mshri.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Center {
    private String name;
    private List<Slot> slotList;
    private List<String> activities;
    private List<Workout> workoutList;
}
