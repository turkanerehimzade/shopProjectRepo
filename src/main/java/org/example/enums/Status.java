package org.example.enums;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE(1),DEACTIVE(2);
    private final int value;
    Status(int value){
        this.value=value;
    }

    public static Status getByValue(int value) {
        for (Status status : values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        return null;
    }
}
