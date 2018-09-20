package com.dist_calc.aiguilleur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.dist_calc.calc.CalculatorImp;
import com.dist_calc.calc.Calculator;

/**
 * AiguilleurServerImp
 */
public class AiguilleurServerImp extends UnicastRemoteObject implements IAiguilleurServer {

    private static final long serialVersionUID = 7904298767131555500L;

    private CalculatorImp calculator;

    public AiguilleurServerImp() throws RemoteException {
        calculator = new CalculatorImp();
    }

    public void registerCalculator(CalculatorImp calc) throws RemoteException {
        calculator = calc;
    }

    public Calculator getCalculator() throws RemoteException {
        System.out.println("getCalculator");
        Calculator mycalc = calculator;
        return mycalc;
    }

}