package com.perftest.performance.service;

import com.perftest.performance.domain.PerformanceComponents;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static java.lang.String.valueOf;
import static java.lang.System.currentTimeMillis;

public class PerformanceService {

    public String measureCpuBasedPerformance(){
        StringJoiner result = new StringJoiner(",").add("cpu");
        for(int it = 0 ; it < 10; it++) {
            long start = currentTimeMillis();
            double total = new Random().nextFloat();
            for (int i = 0; i < 100000000; i++) {
                double res = 13434 * Math.sin(Math.cos(Math.sin(Math.cos(total * total))));
                res = Math.pow(res * 345234, res * 34059345);
                total = total * res;
            }
            result.add(valueOf(currentTimeMillis() - start));
        }
        return result.toString();
    }

    public String measureMemoryBasedPerformance(){
        StringJoiner result = new StringJoiner(",").add("memory");
        Random random = new Random();
        for(int it = 0; it < 10 ; it++) {
            long start = currentTimeMillis();
            Set<Object> list = new HashSet<Object>();
            for (int i = 0; i < 1000000; i++) {
                list.add(new PerformanceComponents(random));
            }
            list.clear();
            result.add(valueOf(currentTimeMillis() - start));
        }
        return result.toString();
    }

    public String measureLocalFileSystemBasedPerformance(){
        long start = currentTimeMillis();
        writeFilesToDisk("/tmp/");
        return "tmp," + (currentTimeMillis() - start);
    }

    public String measureK8sPvcBasedPerformance(){
        long start = currentTimeMillis();
        writeFilesToDisk("/perform/");
        return "pvc," + (currentTimeMillis() - start);
    }

    private void writeFilesToDisk(String directory) {
        String question = "Kubernetes (k8s) is an open-source system for automating deployment, scaling, and management of containerized applications.";
        StringJoiner join = new StringJoiner(question);
        for (int i = 0; i < 10000; i++) {
            join.add(question);
        }
        try {
            for (int it = 0; it < 100; it++) {
                String fileName = "performance_" + UUID.randomUUID().toString() + ".txt";
                Path p = Paths.get(directory + fileName);
                Files.createFile(p);
                for (int i = 0; i < 10; i++) {
                    Files.write(p, join.toString().getBytes(), StandardOpenOption.APPEND);
                }
                Files.delete(p);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
