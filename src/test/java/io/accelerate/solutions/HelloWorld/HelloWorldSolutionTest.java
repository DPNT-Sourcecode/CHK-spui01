package io.accelerate.solutions.HelloWorld;

import org.junit.jupiter.api.Test;

import io.accelerate.solutions.HLO.HelloSolution;

import org.junit.jupiter.api.BeforeEach;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class HelloWorldSolutionTest {
    private HelloSolution helloWorld;

    @BeforeEach
    public void setUp(){
        helloWorld = new HelloSolution();
    }

    @Test
    public void messageOutput(){
        assertThat(helloWorld.hello("John"), equalTo("Hello, John!"));
    }
}

