package com.test_module.aiguilleur;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.test_module.cmodule2.Calculator;
import com.test_module.cmodule2.CalculatorImp;

/**
 * IAiguilleurServer
 */
public interface IAiguilleurServer extends Remote {

    public void registerCalculator(Calculator calc) throws RemoteException;

    public Calculator getCalculator() throws RemoteException;

    public boolean isRegistered(Calculator calc) throws RemoteException;
}