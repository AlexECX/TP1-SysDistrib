package com.test_module.cmodule2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.test_module.aiguilleur.IAiguilleurServer;
import com.test_module.cmodule2.CalculatorImp;

/**
 * CalcServer
 */
public class CalcServer {

    public static void main(String[] args) {
        try {
            CalculatorImp calculator = new CalculatorImp();
            IAiguilleurServer server = (IAiguilleurServer) Naming.lookup("//localhost:8888/AiguilleurServerImp");
            server.registerCalculator(calculator);
            System.out.println("Calculator ready");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } 
    }

}