package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

@Getter
@Setter
public class Sell implements Serializable {
    public static final Long serialVersionUID=1L;
    private LocalDateTime localDateTime;
    private Object tip;
    private String marka;
    private int qiymet;

    public Sell(LocalDateTime localDateTime, Object tip, String marka, int qiymet) {
        this.localDateTime = localDateTime;
        this.tip = tip;
        this.marka = marka;
        this.qiymet = qiymet;
    }

    @Override
    public String toString() {
        return "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~]\n"+
                "Satish zamani:"+localDateTime+"\n"+
                "Mehsulun tipi:"+tip+"\n"+
                "Mehsulun markasi:"+marka+"\n"+
                "Mehsulun satish qiymeti:"+qiymet+"\n"+
                "[~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~";
    }
}
