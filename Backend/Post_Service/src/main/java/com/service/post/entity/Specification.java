package com.service.post.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specification {

    private String model;
    private Display display;
    private CoreComponent component;
    private String operatingSystem;
    private boolean waterProof;
    private Camera camera;
    private Storage storage;
    private Battery battery;
    private Double price;
    private String quickCharging;

    @Data
    public class Battery {
        private String batteryType;
        private String chargingSpeed;
        private String milliAH;

    }

    @Data
    public class Display {
        private String size;
        private String dType;
        private String refreshRate;
        private String resolution;
        private String aspectRatio;
    }

    @Data
    public class CoreComponent {
        private String cpu;
        private String processor;
        private int ram;
    }

    @Data
    public class Storage {
        private String storageType;
        private String internalMemory;
        private String extended;
    }

    @Data
    public class Camera {
        private String setup;
        private String rearCamera;
        private String frontCamera;
        private String resolution;
    }
}
