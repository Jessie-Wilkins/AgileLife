package com.actual.myapplication;

/**
 * The Interface that serves as the template for concrete strategies
 * @since 2020-04
 */
interface IdGeneratorStrategy {
    
    int generateId();

    void resetId();
}
