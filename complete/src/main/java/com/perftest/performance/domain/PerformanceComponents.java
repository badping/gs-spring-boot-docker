package com.perftest.performance.domain;

import java.util.Objects;
import java.util.Random;

public class PerformanceComponents {

    public PerformanceComponents(Random random) {
        this.it1 = random.nextInt();
        this.it2 = random.nextInt();
        this.it3 = random.nextInt();
        this.it4 = random.nextInt();
        this.it5 = random.nextInt();
        this.it6 = random.nextInt();
        this.it7 = random.nextInt();
        this.it8 = random.nextInt();
        this.stg1 = it1.toString();
        this.stg2 = it2.toString();;
        this.stg3 = it3.toString();;
        this.stg4 = it4.toString();;
        this.stg5 = it5.toString();;
        this.stg6 = it6.toString();;
        this.stg7 = it7.toString();;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerformanceComponents that = (PerformanceComponents) o;
        return Objects.equals(stg1, that.stg1) &&
                Objects.equals(stg2, that.stg2) &&
                Objects.equals(stg3, that.stg3) &&
                Objects.equals(stg4, that.stg4) &&
                Objects.equals(stg5, that.stg5) &&
                Objects.equals(stg6, that.stg6) &&
                Objects.equals(stg7, that.stg7) &&
                Objects.equals(it1, that.it1) &&
                Objects.equals(it2, that.it2) &&
                Objects.equals(it3, that.it3) &&
                Objects.equals(it4, that.it4) &&
                Objects.equals(it5, that.it5) &&
                Objects.equals(it6, that.it6) &&
                Objects.equals(it7, that.it7) &&
                Objects.equals(it8, that.it8);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stg1, stg2, stg3, stg4, stg5, stg6, stg7, it1, it2, it3, it4, it5, it6, it7, it8);
    }

    private String stg7;
    private Integer it1;
    private Integer it2;
    private Integer it3;
    private Integer it4;
    private Integer it5;
    private Integer it6;
    private Integer it7;
    private Integer it8;
    private String stg1;
    private String stg2;
    private String stg3;
    private String stg4;
    private String stg5;
    private String stg6;
}
