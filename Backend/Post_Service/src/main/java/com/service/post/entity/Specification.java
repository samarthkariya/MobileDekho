package com.service.post.entity;

import lombok.Data;

@Data
public class Specification {

    private String model;
    private String display;
    private String processor;
    private String operatingSystem;
    private boolean waterProof;
    private String rearCamera;
    private String frontCamera;
    private String resolution;
    private int ram;
    private int storage;
    private int battery;
    private Double price;
    private String quickCharging;

}
