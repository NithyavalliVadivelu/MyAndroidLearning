package com.example.myandroidlearning;

import dagger.Component;

@Component(modules=SamplePresenter.class)
public interface SampleComponent {
    SamplePresenter getSample();
    void inject(SampleBindViewModel sampleBindViewModel);

}
