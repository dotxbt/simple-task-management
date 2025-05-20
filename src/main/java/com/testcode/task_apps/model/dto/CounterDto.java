package com.testcode.task_apps.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Data
public class CounterDto {
    final List<Integer> data;

    public int[] getArrayOfInt() {
        return data.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
