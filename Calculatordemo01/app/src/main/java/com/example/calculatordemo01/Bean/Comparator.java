package com.example.calculatordemo01.Bean;

public interface Comparator <T>{
    public abstract boolean equals(Object obj);
    public abstract int compare(T obj1, T obj2);
}
