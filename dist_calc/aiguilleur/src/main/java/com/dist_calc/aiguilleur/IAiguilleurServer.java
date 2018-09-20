package com.dist_calc.aiguilleur;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.dist_calc.calc.Calculator;
import com.dist_calc.calc.CalculatorImp;

/**
 * IAiguilleurServer
 */
public interface IAiguilleurServer extends Remote {

    public void registerCalculator(CalculatorImp calc) throws RemoteException;

    public Calculator getCalculator() throws RemoteException;
}