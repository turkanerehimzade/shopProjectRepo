package org.example.enums;

import lombok.Getter;

@Getter
public enum MeishetDest {

    QAB_DESTI(1),QAZAN_DESTI(2);
    private final int value;
     MeishetDest(int value){
        this.value=value;
    }

    public static MeishetDest getByValue(int value) {
        for (MeishetDest meishetDest : values()) {
            if (meishetDest.getValue() == value) {
                return meishetDest;
            }
        }
        return null;
    }

}
