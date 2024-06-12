package org.example.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.Status;

import java.io.Serializable;

@Getter
@Setter
@Data
public class Eshya implements Serializable {
    public static final Long serialVersionUID=1L;
    private String unikalNomre;
    private String marka;
    private int say;
    private int qiymet;
    private Status status=Status.getByValue(1);


    public Eshya(String unikalNomre, String marka, int say,int qiymet,Status status) {
        this.unikalNomre = unikalNomre;
        this.marka = marka;
        this.say = say;
        this.qiymet=qiymet;
        this.status=status;
    }

    public Eshya(){

    }

    @Override
    public String toString() {
        return "unikalNomre='" + unikalNomre + "' ,"+
               "marka='" + marka + "' ,"+
                "say=" + say+" ,"+
                "qiymet="+qiymet+" ,"+
                "status="+status+" ,";
    }
}
