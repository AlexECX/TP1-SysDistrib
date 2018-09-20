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

    public static String PORT;
    public static String ADDR;

    public static void main(String[] args) {
        try {
            CalculatorImp calculator = new CalculatorImp();
            IAiguilleurServer server = (IAiguilleurServer)Naming.lookup("//localhost:8888/AiguilleurServerImp");
            server.registerCalculator(calculator);
            System.out.println("enter waiting");
            while (true) {
                Thread.sleep(100);
            }
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		} catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        // InputStreamReader is = new InputStreamReader(System.in);
        // BufferedReader br = new BufferedReader(is);
        // System.out.println("Enter the RMIregistry port number:");
        // try {
        //     ADDR = "//localhost:";
        //     PORT = (br.readLine()).trim();
        //     startRegistry(Integer.parseInt(PORT));
        //     CalculatorImp calculator = new CalculatorImp();
        //     Naming.rebind(ADDR + PORT + "/CalculatorImp", calculator);
        //     System.out.println("Calculator ready");
        // } catch (Exception e1) {
        //     e1.printStackTrace();
        // }

    }

    // This method starts a RMI registry on the local host, if
    // it does not already exists at the specified port number.
    private static void startRegistry(int RMIPortNum) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(RMIPortNum);
            registry.list();
            // This call will throw an exception
            // if the registry does not already exist
        } catch (RemoteException e) {
            // No valid registry at that port.
            Registry registry = LocateRegistry.createRegistry(RMIPortNum);
        }
    } // end startRegistry
}