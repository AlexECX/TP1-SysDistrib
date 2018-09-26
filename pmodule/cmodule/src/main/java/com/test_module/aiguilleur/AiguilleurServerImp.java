package com.test_module.aiguilleur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;

import com.test_module.cmodule2.CalculatorImp;
import com.test_module.cmodule.Client;
import com.test_module.cmodule2.Calculator;
import com.test_module.cmodule2.CalculatorException;

/**
 * AiguilleurServerImp
 */
public class AiguilleurServerImp extends UnicastRemoteObject implements Aiguilleur {

    private static final long serialVersionUID = 7904298767131555500L;

    private Vector<Calculator> calc_vec;

    private List<Calculator> available_calc;

    private synchronized Calculator getCalculator() throws RemoteException, AiguilleurException {
        Calculator mycalc = null;
        while (mycalc == null) {
            try {
                mycalc = available_calc.remove(0);
            } catch (IndexOutOfBoundsException e) {
                throw new AiguilleurException("No Calculator available");
            }
        }
        return mycalc;
    }

    public AiguilleurServerImp() throws RemoteException {
        calc_vec = new Vector<Calculator>();
        ArrayList<Calculator> arr = new ArrayList<Calculator>();
        available_calc = Collections.synchronizedList(arr);
    }

    public synchronized void registerCalculator(Calculator calc) throws RemoteException {
        if (!(calc_vec.contains(calc))) {
            calc_vec.addElement(calc);
            available_calc.add(calc);
            System.out.println("registered Calculator");
        }
    }

    public synchronized void unregisterCalculator(Calculator calc) throws RemoteException {
        if (calc_vec.contains(calc)) {
            available_calc.remove(calc);
            calc_vec.remove(calc);
            System.out.println("unregistered Calculator");
        }
    }

    public synchronized void compute(Client client)
            throws RemoteException, AiguilleurException, CalculatorException {
        
        boolean success = false;
        while (!success) {
            try {
                Calculator calc = this.getCalculator();
                calc.compute(client);
                available_calc.add(calc);
                success = true;
            } catch (RemoteException e) {
                success = false;
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e1) {
                    // pass
                }
            }
        }

    }

}