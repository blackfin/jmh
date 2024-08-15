

package org.sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import java.util.concurrent.TimeUnit;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MyBenchmark {
	
	 static final int LOWER_BOUND = 1;
     static final int UPPER_BOUND = 100;
     static final int ARRAY_SIZE = 10;
	 
	 static final int[] data = initializeInstanceVariable();
	 
	 static int[] initializeInstanceVariable() {
		 //int[] init = new int[ARRAY_SIZE];
		 int[] init = new int[]{1,2,3,4,5,5,6,7,3};
		 return init;
	 }
		 
	 
    @Benchmark
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testMethod(Blackhole blackhole) {
       stat(data);
    }

    static void stat(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> stat = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            stat.put(Math.abs(nums[i]), stat.getOrDefault(Math.abs(nums[i]), 0) + 1);
        }
        for (int number : stat.keySet()) {
            if (stat.get(number) != 1) {
                result.add(number);
            }
        }
        //result.forEach(System.out::println);
    }

    static void fast(int[] nums) {

    }

    static void std(int[] nums) {

    }

}
