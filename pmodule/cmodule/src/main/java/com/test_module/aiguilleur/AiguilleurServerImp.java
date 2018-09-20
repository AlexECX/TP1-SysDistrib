package com.test_module.aiguilleur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import com.test_module.cmodule2.CalculatorImp;
import com.test_module.cmodule2.Calculator;

/**
 * AiguilleurServerImp
 */
public class AiguilleurServerImp extends UnicastRemoteObject implements IAiguilleurServer {

    private static final long serialVersionUID = 7904298767131555500L;

    private Vector<Calculator> calc_vec;

    private Vector<Calculator> calc_in_use;

    public AiguilleurServerImp() throws RemoteException {
        calc_vec = new Vector<Calculator>();
        calc_in_use = new Vector<Calculator>();
    }

    public synchronized void registerCalculator(Calculator calc) throws RemoteException {
        if (!(calc_vec.contains(calc))) {
            calc_vec.addElement(calc);
            System.out.println("registered Calculator");
        }
    }

    public synchronized Calculator getCalculator() throws RemoteException {
        System.out.println("getCalculator");
        Calculator mycalc;
        try {
            mycalc = calc_vec.remove(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            mycalc = null;
        }
        
        return mycalc;
    }

    public synchronized boolean isRegistered(Calculator calc) throws RemoteException {
        return calc_vec.contains(calc);
    }

}