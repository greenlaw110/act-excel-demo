package com.greenlaw110;

import act.data.annotation.Data;
import act.util.SimpleBean;

@Data
public class Employee implements SimpleBean {

    public int employeeNo;
    public String firstName;
    public String lastName;
    public String email;

}
