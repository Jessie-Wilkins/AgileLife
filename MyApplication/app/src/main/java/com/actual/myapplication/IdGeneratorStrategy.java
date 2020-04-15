package com.actual.myapplication;

interface IdGeneratorStrategy {
    
    public long generateId();

    public void resetId();
}
