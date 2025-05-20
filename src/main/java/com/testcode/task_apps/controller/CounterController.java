package com.testcode.task_apps.controller;

import com.testcode.task_apps.model.dto.CounterDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/counter")
public class CounterController {

    @PostMapping("/using-collection")
    public int getCounterUsingCollection(@RequestBody CounterDto data) {
        return counterIntegerUsingCollection(data.getData());
    }

    @PostMapping("/without-collection")
    public int getCounterWithoutCollection(@RequestBody CounterDto data) {
        return counterInteger(data.getArrayOfInt());
    }


    private int counterIntegerUsingCollection(List<Integer> data) {
       return data.stream().filter(number -> number % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    private int counterInteger(int[] data) {
        int result = 0;
        for (int item : data) {
            if (item % 2 == 0) {
                result += item;
            }
        }
        return result;
    }
}
