package com.test_module.cmodule2;
import java.rmi.*;

import com.test_module.cmodule.Client;
/**
 * Calculator
 */
public interface Calculator extends Remote {

    public void compute(Client client)
                    throws RemoteException, CalculatorException;

    // public double add(double x, double y) throws RemoteException;

    // public double sub(double x, double y) throws RemoteException;

    // public double mul(double x, double y) throws RemoteException;

    // public double div(double x, double y) throws RemoteException;

    
}