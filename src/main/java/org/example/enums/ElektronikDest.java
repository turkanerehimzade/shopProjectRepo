package org.example.enums;

import lombok.Getter;

@Getter
public enum ElektronikDest {
    PALTARYUYAN(1),SOYUDUCU(2);
    private final int value;
    ElektronikDest(int value){
        this.value=value;
    }

    public static ElektronikDest getByValue(int value) {
        for (ElektronikDest elektronikDest : values()) {
            if (elektronikDest.getValue() == value) {
                return elektronikDest;
            }
        }
        return null;
    }

}
