package com.demo.violations.data;

public enum Type {
    SPEEDING(1), TRAFFIC_LIGHT(2), TRAFFIC_SING(3), MARKING_UP(4), PARKING(5);

private int value;

    Type(int value) {
        this.value =value;
    }
}
