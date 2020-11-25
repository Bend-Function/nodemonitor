package com.funcs.nodemonitor.comon.dto;

import lombok.Data;

import javax.swing.*;
import java.io.Serializable;

@Data
public class UpdateDto implements Serializable {

    private int serverId;
    private float cpu;
    private float memory;
    private float netOut;
    private float netIn;
    private float ping;
    private String pwd;

}
