package com.demo.violations.data;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class StatisticByPerson {
    private String first_name;
    private String last_name;
    private int total;
    private double totalFine;
    private double averageFine;
}
