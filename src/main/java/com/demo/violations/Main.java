package com.demo.violations;

import com.demo.violations.data.StatisticByPerson;
import com.demo.violations.data.StatisticsTotal;
import com.demo.violations.data.Type;
import com.demo.violations.data.Violation;
import com.demo.violations.functional.Calculate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Violation violation = new Violation(new Date(2021, 11, 22), "Ivan", "Ivanov", Type.SPEEDING, 340);
        Violation second = new Violation(new Date(2021, 12, 3), "Name", "Second", Type.PARKING, 140);
        Violation third = new Violation(new Date(2021, 10, 7), "Vasya", "Vasiliev", Type.TRAFFIC_SING, 225);
        Violation fourth = new Violation(new Date(2021, 1, 16), "Kolya", "Petrov", Type.SPEEDING, 510);
        Violation fifth = new Violation(new Date(2021, 17, 31), "Fedya", "Fedorov", Type.SPEEDING, 110);
        Violation sixth = new Violation(new Date(2021, 17, 31), "Fedya", "Fedorov", Type.MARKING_UP, 550);
        Violation seventh = new Violation(new Date(2021, 17, 31), "Fedya", "Fedorov", Type.TRAFFIC_LIGHT, 310);
        Violation oneMore = new Violation(new Date(2021, 17, 31), "Name", "Second", Type.PARKING, 310);
        List<Violation> dataBaseViolations = new ArrayList<>();
        dataBaseViolations.add(violation);
        dataBaseViolations.add(second);
        dataBaseViolations.add(third);
        dataBaseViolations.add(fourth);
        dataBaseViolations.add(fifth);
        dataBaseViolations.add(sixth);
        dataBaseViolations.add(seventh);
        dataBaseViolations.add(oneMore);
        for (StatisticByPerson countByPersonAllDatum : new Calculate().countByPersonAllData(dataBaseViolations)) {
            System.out.println(countByPersonAllDatum);
        }




    }
}
