package com.mshri.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Workout {
    private String activity;
    private Slot slot;
    private Integer vacant;
    private Integer capacity;
}
