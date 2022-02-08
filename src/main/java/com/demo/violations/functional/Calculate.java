package com.demo.violations.functional;

import com.demo.violations.data.StatisticByPerson;
import com.demo.violations.data.StatisticsTotal;
import com.demo.violations.data.Type;
import com.demo.violations.data.Violation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculate {


    public List<StatisticByPerson> countByPersonAllData(Collection<Violation> listOfViolation) {
        double total = 1;
        double countAll = 0;
        double average = 0;
        Map<String, List<Violation>> collectedMapPerson = collectAllByPerson(listOfViolation);

        List<Violation> tempCollection;
        List<StatisticByPerson> statisticByPeople = new ArrayList<>();

        for (String s : collectedMapPerson.keySet()) {
            tempCollection = collectedMapPerson.get(s);
            total = tempCollection.size();
            for (Violation violation : tempCollection) {
                countAll = countAll + violation.getFine_amount();
            }
            average = countAll / total;
            StatisticByPerson statisticByPerson = new StatisticByPerson(tempCollection.get(0).getFirst_name(), tempCollection.get(0).getLast_name(), (int) total, countAll, average);
         statisticByPeople.add(statisticByPerson);

        }
        return statisticByPeople;
    }

    public List<StatisticsTotal> sortedAllViolationsByType(List<Violation> violationList) {
        List<StatisticsTotal> sorted = new ArrayList<>();
        sorted.add(countStatistic(violationList, Type.SPEEDING));
        sorted.add(countStatistic(violationList, Type.TRAFFIC_LIGHT));
        sorted.add(countStatistic(violationList, Type.TRAFFIC_SING));
        sorted.add(countStatistic(violationList, Type.MARKING_UP));
        sorted.add(countStatistic(violationList, Type.PARKING));
        return sorted.stream().sorted(Comparator.comparingDouble(StatisticsTotal::getTotalByType)).collect(Collectors.toList());
    }

    private Map<String, List<Violation>> collectAllByPerson(Collection<Violation> listOfViolation) {
        Map<String, List<Violation>> resultByPerson = listOfViolation.stream()
                .map(violation -> violation.getFirst_name() + " " + violation.getLast_name())
                .distinct()
                .collect(Collectors.toMap(x -> x, y -> new ArrayList<Violation>()));
        for (String s : resultByPerson.keySet()) {
            List<Violation> collectedByPerson = listOfViolation.stream()
                    .filter(violation -> s.equals(violation.getFirst_name() + " " + violation.getLast_name()))
                    .collect(Collectors.toList());
            resultByPerson.put(s, collectedByPerson);
        }
        return resultByPerson;
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


