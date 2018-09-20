package com.test_module.cmodule2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * CalculatorImp
 */
public class CalculatorImp extends UnicastRemoteObject implements Calculator{

    // private static final long serialVersionUID = 2909975573919816401L;

    private static final long serialVersionUID = 7582696699760168117L;

    public CalculatorImp() throws RemoteException {
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