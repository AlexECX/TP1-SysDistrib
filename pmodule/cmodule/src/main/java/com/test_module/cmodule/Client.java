package com.test_module.cmodule;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Client
 */
public interface Client extends Remote {

    public void notifyClient(double answ) throws RemoteException;

    public void setOperation(Operation op) throws RemoteException;

    public Operation getOperation() throws RemoteException;
}