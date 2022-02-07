package com.demo.violations.data;

import lombok.*;

import javax.xml.crypto.Data;


@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Violation {
    private Data date;
    private String first_name;
    private String last_name;
    private Type type;
    private double fine_amount;
}
