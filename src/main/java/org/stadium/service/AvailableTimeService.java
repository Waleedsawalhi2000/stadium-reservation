package org.stadium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stadium.repository.AvailableTimeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AvailableTimeService {
    @Autowired
    private AvailableTimeRepository repository;


    public List<Integer> getAvailableTime(final Integer stadiumId,
                                          final Integer value,
                                          final LocalDate date) {
        final List<Integer> baseList = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23));
        final List<Integer> resultList = repository.getAvailableTime(stadiumId, date);
        final List<Integer> finalResult = new ArrayList<>();
        for (int i = 0; i <= resultList.size() - value; i++) {
            if (baseList.containsAll(resultList.subList(i, i + value))){
             finalResult.add(resultList.get(i));
            }
        }
        return finalResult;
    }
}
