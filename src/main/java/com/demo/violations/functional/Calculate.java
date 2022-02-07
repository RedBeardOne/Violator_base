package com.demo.violations.functional;

import com.demo.violations.data.StatisticsTotal;
import com.demo.violations.data.Type;
import com.demo.violations.data.Violation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Calculate {



    public List<StatisticsTotal> list(List<Violation> violationList) {
        List<StatisticsTotal> sorted = new ArrayList<>();
        sorted.add(countStatistic(violationList, Type.SPEEDING));
        sorted.add(countStatistic(violationList, Type.TRAFFIC_LIGHT));
        sorted.add(countStatistic(violationList, Type.TRAFFIC_SING));
        sorted.add(countStatistic(violationList, Type.MARKING_UP));
        sorted.add(countStatistic(violationList, Type.PARKING));
        return sorted.stream().sorted(Comparator.comparingDouble(StatisticsTotal::getTotalByType)).collect(Collectors.toList());
    }

    private StatisticsTotal countStatistic(List<Violation> violationList, Type type) {
        double sum = 0;
        for (Violation violation : violationList) {
            if (type.equals(violation.getType())) {
                sum = sum + violation.getFine_amount();
            }
        }
        return new StatisticsTotal(type, sum);
    }
}


