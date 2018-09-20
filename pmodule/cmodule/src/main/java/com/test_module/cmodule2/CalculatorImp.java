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

    public String add() throws RemoteException{
        String str = "add";
        return str;
    }

    public void sub() throws RemoteException {
        System.out.println("sub");
    }

    
}