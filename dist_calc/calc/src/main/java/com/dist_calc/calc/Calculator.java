package com.dist_calc.calc;
import java.rmi.*;
/**
 * Calculator
 */
public interface Calculator extends Remote {

    public String add() throws RemoteException;

    public void sub() throws RemoteException;

    
}