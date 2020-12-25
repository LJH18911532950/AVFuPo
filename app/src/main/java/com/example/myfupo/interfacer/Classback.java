package com.example.myfupo.interfacer;

public interface Classback<T> {
    void onSecc(T t);
    void onFrom(String msg);
}
