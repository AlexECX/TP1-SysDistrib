package com.test_module.cmodule;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * ClientImp
 */
public class ClientImp extends UnicastRemoteObject implements Client {

    private static final long serialVersionUID = -7030621699803991064L;

    private Operation myOp;

    public ClientImp(Operation op) throws RemoteException{
        this.myOp = op;
    }
    

    public void notifyClient(double answ) throws RemoteException {
        System.out.println("Answer is " + answ);
    }

    public Operation getOperation() throws RemoteException {
        return this.myOp;
	}

    public void setOperation(Operation op) throws RemoteException {
        this.myOp = op;
    }

    
}