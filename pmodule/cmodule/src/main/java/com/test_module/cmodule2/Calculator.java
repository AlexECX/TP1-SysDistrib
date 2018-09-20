package com.test_module.cmodule2;
import java.rmi.*;
/**
 * Calculator
 */
public interface Calculator extends Remote {

    public double add(double x, double y) throws RemoteException;

    public double sub(double x, double y) throws RemoteException;

    public double mul(double x, double y) throws RemoteException;

    public double div(double x, double y) throws RemoteException;

    
}