package com.example.myandroidlearning;

import javax.inject.Inject;

public class Sample2 {
Child1 child;

    @Inject
    public Sample2() {
    }

    public Sample2(Child1 child) {
        this.child = child;
    }
}
