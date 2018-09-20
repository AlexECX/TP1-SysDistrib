package com.test_module.cmodule2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * CalculatorImp
 */
public class CalculatorImp extends UnicastRemoteObject implements Calculator{

    private static final long serialVersionUID = 7582696699760168117L;

    public CalculatorImp() throws RemoteException {
    }

    public double compute(String op, double x, double y) 
                    throws RemoteException, CalculatorException {
        if (op.equals("add")) {
           return this.add(x,y);
        } else if (op.equals("sub")) {
            return this.sub(x,y);
        } else if (op.equals("mul")) {
            return this.mul(x,y);
        } else if (op.equals("div")) {
            return this.div(x,y);
        } else {
            throw new CalculatorException(
                "The " + op + " method is not implemented"
                );
        }
    }

    public double add(double x, double y) throws RemoteException {
        return x + y;
    }

    public double sub(double x, double y) throws RemoteException {
        return x - y;
    }

    public double mul(double x, double y) throws RemoteException {
        return x * y;
    }

    public double div(double x, double y) throws RemoteException {
        return x / y;
    }

    
}