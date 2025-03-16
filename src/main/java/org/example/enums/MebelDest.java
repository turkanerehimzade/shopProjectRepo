package org.example.enums;

import lombok.Getter;

@Getter
public enum MebelDest {
    YATAQ_DESTI(1),QONAQ_DESTI(0);
    private final int value;
    MebelDest(int value){
        this.value=value;
    }

    public static MebelDest getByValue(int value) {
        for (MebelDest mebelDest : values()) {
            if (mebelDest.getValue()==value) {
                return mebelDest;
            }
        }
        return null;
    }

}
