package com.service.post.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("specification")
public class Specification {

    @Id
    private String specId;
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
