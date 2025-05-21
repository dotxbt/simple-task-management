package com.testcode.task_apps.controller;

import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dto.CounterDto;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/counter")
public class CounterController {

    @PostMapping("/using-collection")
    public ResponseData<Map<String, Integer>>  getCounterUsingCollection(@RequestBody CounterDto data) {
        Map<String, Integer> resData = new HashMap<>();
        resData.put("result",  counterIntegerUsingCollection(data.getData()));
        return ResponseData.<Map<String, Integer>> builder()
                .data(resData).build();
    }

    @PostMapping("/without-collection")
    public ResponseData<Map<String, Integer>> getCounterWithoutCollection(@RequestBody CounterDto data) {
       Map<String, Integer> resData = new HashMap<>();
        resData.put("result",  counterInteger(data.getArrayOfInt()));

        return ResponseData.<Map<String, Integer>> builder()
                .data(resData).build();
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
