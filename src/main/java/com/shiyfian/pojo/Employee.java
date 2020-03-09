package com.shiyfian.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//员工表
@Data
@NoArgsConstructor
public class Employee {
    private Integer EID;
    private String EName;
    private String EEmail;
    private Integer ESex;//0女 1男
    private Department department;
    private Date date;

    public Employee(Integer EID, String EName, String EEmail, Integer ESex, Department department) {
        this.EID = EID;
        this.EName = EName;
        this.EEmail = EEmail;
        this.ESex = ESex;
        this.department = department;
        //默认创建日期
        this.date = new Date();
    }
}
