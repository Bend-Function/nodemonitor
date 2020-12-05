package com.funcs.nodemonitor.comon.dto;

import lombok.Data;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ServerUpdateDto {
    private String serverName;
    private String serverLocation;
    private String serverDescribe;
    private String password;

    public List<String> CheckNull() {

        List<String> nullParams = new ArrayList<>();
        if (this.serverName == null){
            nullParams.add("serverName");
        }
        if (this.serverDescribe == null){
            nullParams.add("serverDescribe");
        }
        if (this.serverLocation == null){
            nullParams.add("serverLocation");
        }
        return nullParams;
    }
}
