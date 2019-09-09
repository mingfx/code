package com.ming.code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExcutorsTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> future1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                try {
                    list.add(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return 1;
            }
        });
        Future<Integer> future2 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                try {
                    list.add(2);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return 1;
            }
        });
        Future<Integer> future3 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                try {
                    list.add(3);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return 1;
            }
        });
        executorService.shutdown();
        System.out.println(list.size());
    }
}
