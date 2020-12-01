package com.funcs.nodemonitor.comon.dto;

import lombok.Data;

import javax.swing.*;
import java.io.Serializable;

@Data
public class ServerUpdateDto {
    private String serverName;
    private String serverLocation;
    private String serverDescribe;
    private String password;
}
