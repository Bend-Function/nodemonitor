package com.funcs.nodemonitor.comon.dto;

import lombok.Data;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class InfoUpdateDto implements Serializable {

    private int serverId;
    private float cpu;
    private float memory;
    private float netOut;
    private float netIn;
    private float ping;
    private String pwd;

    private boolean isEqual(float a, float b) {
        if (Float.isNaN(a) || Float.isNaN(b) || Float.isInfinite(a) || Float.isInfinite(b)) {
            return false;
        }
        return (a - b) < 0.001d;
    }


    public List<String> CheckNull() {
        List<String> nullParams = new ArrayList<>();
        float zero = (float) 0.0;

        if (isEqual(this.cpu, zero)) {
            nullParams.add("cpu");
        }
        if (isEqual(this.memory, zero)) {
            nullParams.add("memory");
        }
        if (isEqual(this.netIn, zero)) {
            nullParams.add("neiIn");
        }
        if (isEqual(this.netOut, zero)) {
            nullParams.add("netOut");
        }
        if (isEqual(this.ping, zero)){
            nullParams.add("ping");
        }

        return nullParams;
    }

}
