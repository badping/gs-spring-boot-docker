package com.perftest.performance;

import com.perftest.performance.service.PerformanceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
    private PerformanceService performanceService = new PerformanceService();

    @RequestMapping("/")
    public String availableCommands() {
        return "Use /cpu /memory /tmp";
    }

    @RequestMapping("/cpu")
    public String testCpu() {
        return performanceService.measureCpuBasedPerformance();
    }


    @RequestMapping("/memory")
    public String testMemory() {
        return performanceService.measureMemoryBasedPerformance();
    }

    @RequestMapping("/tmp")
    public String testLocalFileSystem() {
        return performanceService.measureLocalFileSystemBasedPerformance();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
