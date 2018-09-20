package com.test_module.cmodule;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.test_module.cmodule2.Calculator;

/**
 * UserClient
 */
public class UserClient {

    public static void main(String[] args) {
        System.out.println("UserClient");

        try {
            Calculator calc = (Calculator) Naming.lookup("//localhost:8888/CalculatorImp");
            String x = calc.add();
            System.out.println(x);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}