package com.test_module.aiguilleur;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.test_module.cmodule2.Calculator;
import com.test_module.cmodule2.CalculatorException;

/**
 * Aiguilleur
 */
public interface Aiguilleur extends Remote {

    public void registerCalculator(Calculator calc) throws RemoteException;

    public void unregisterCalculator(Calculator calc) throws RemoteException;

    public double compute(String op, double x, double y)
            throws RemoteException, AiguilleurException, CalculatorException;

}