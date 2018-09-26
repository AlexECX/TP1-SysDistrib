package com.test_module.cmodule2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.test_module.cmodule.Client;
import com.test_module.cmodule.Operation;

/**
 * CalculatorImp
 */
public class CalculatorImp extends UnicastRemoteObject implements Calculator {

    private static final long serialVersionUID = 7582696699760168117L;

    public CalculatorImp() throws RemoteException {
    }

    public void compute(Client client) throws RemoteException, CalculatorException {
        Operation operation = client.getOperation();
        String op = operation.op;
        double x = operation.x;
        double y = operation.y;

        System.out.println("calculating " + op + "(" + x + ", " + y + ")");
        double result;

        if (op.equals("add")) {
            result = this.add(x, y);
        } else if (op.equals("sub")) {
            result = this.sub(x, y);
        } else if (op.equals("mul")) {
            result = this.mul(x, y);
        } else if (op.equals("div")) {
            result = this.div(x, y);
        } else {
            throw new CalculatorException("The " + op + " method is not implemented");
        }

        client.notifyClient(result);
    }

    private double add(double x, double y) throws RemoteException {
        return x + y;
    }

    private double sub(double x, double y) throws RemoteException {
        return x - y;
    }

    private double mul(double x, double y) throws RemoteException {
        return x * y;
    }

    private double div(double x, double y) throws RemoteException {
        return x / y;
    }

}