package io.accelerate.solutions.HLO;

import io.accelerate.runner.SolutionNotImplementedException;

public class HelloSolution {
    public String hello(String friendName) {
        //Hello, John!
        String message = "Hello, "+ friendName+"!";

        return message;
    }
}
