package com.test_module.cmodule;

import java.io.Serializable;

/**
 * Operation
 */
public class Operation implements Serializable{

    private static final long serialVersionUID = 2082910114996354691L;

    public String op;
    public double x;
    public double y;

    public Operation(String op, double x, double y){
        this.op = op;
        this.x = x;
        this.y = y;
    }
}