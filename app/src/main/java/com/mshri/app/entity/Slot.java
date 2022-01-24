package com.mshri.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Slot {
    private Integer startTime;
    private Integer stopTime;

}
