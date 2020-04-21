package com.actual.myapplication;

interface IdGeneratorStrategy {
    
    public int generateId();

    public void resetId();
}
