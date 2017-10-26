package com.kdotj.demo.imageloadingdemo;

import com.kdotj.demo.imageloadingdemo.data.ImageRepoFactoryTest;
import com.kdotj.demo.imageloadingdemo.ui.details.DetailsModelTest;
import com.kdotj.demo.imageloadingdemo.ui.main.MainActivityModelTest;
import com.kdotj.demo.imageloadingdemo.ui.options.OptionsModelTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Created by kyle.jablonski on 10/26/17.
 */

@RunWith(Suite.class)
@SuiteClasses({
    ImageRepoFactoryTest.class,
    DetailsModelTest.class,
    MainActivityModelTest.class,
    OptionsModelTest.class
})
public class AppUnitTestSuite {

}
