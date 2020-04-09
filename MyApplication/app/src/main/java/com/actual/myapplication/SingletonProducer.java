package com.actual.myapplication;

public class SingletonProducer {

    private boolean object_not_existent = true;

    private Object singleton_object;

    protected SingletonProducer() {

    }

    public Object initiateSingleton() {
        if(object_not_existent) {
            object_not_existent=false;
            initiateObject();
            return singleton_object;
        }
        else {
            return singleton_object;
        }
    }

    private void initiateObject() {
        singleton_object = new Object();
    }
}
