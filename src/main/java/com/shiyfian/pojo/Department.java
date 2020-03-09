package com.shiyfian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//部门表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer DID;
    private String DName;
}
