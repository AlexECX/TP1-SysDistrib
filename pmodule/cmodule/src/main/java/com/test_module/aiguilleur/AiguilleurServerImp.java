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
import com.test_module.cmodule2.Calculator;

/**
 * AiguilleurServerImp
 */
public class AiguilleurServerImp extends UnicastRemoteObject 
                                 implements IAiguilleurServer {

    private static final long serialVersionUID = 7904298767131555500L;

    private Vector<Calculator> calc_vec;

    private List<Calculator> available_calc;

    private synchronized Calculator getCalculator() 
                                   throws RemoteException, AiguilleurException {
        System.out.println("getCalculator");
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

    public synchronized void registerCalculator(Calculator calc) 
                                throws RemoteException {
        if (!(calc_vec.contains(calc))) {
            calc_vec.addElement(calc);
            available_calc.add(calc);
            System.out.println("registered Calculator");
        }
    }

    public synchronized void unregisterCalculator(Calculator calc)
                                throws RemoteException {
        if (calc_vec.contains(calc)) {
            available_calc.remove(calc);
            calc_vec.remove(calc);
            System.out.println("unregistered Calculator");
        }                          
    }

    public synchronized double compute(String op, double x, double y) 
                                throws RemoteException, AiguilleurException {
        boolean success = false;
        double result = -1;
        while (!success) {
            try {
                Calculator calc = this.getCalculator();
                result = calc.compute(op, x, y);

                // if (op.equals("add")) {
                //     result = calc.add(x,y);
                // } else if (op.equals("sub")) {
                //     result = calc.sub(x,y);
                // } else if (op.equals("mul")) {
                //     result = calc.mul(x,y);
                // } else if (op.equals("div")) {
                //     result = calc.div(x,y);
                // } else {
                //     throw new AiguilleurException(
                //         "The " + op + " method is not implemented"
                //         );
                // }
                available_calc.add(calc);
                success = true;
            } catch (RemoteException e) {
                success = false;
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e1) {
                   //pass
                }
            }
        }
        return result;

    }

}