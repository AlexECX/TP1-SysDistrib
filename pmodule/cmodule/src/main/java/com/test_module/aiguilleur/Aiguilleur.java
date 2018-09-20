package com.test_module.aiguilleur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.test_module.aiguilleur.AiguilleurServerImp;
import com.test_module.cmodule2.Calculator;
/**
 * Aiguilleur
 */
public class Aiguilleur {

    public static void main(String[] args) {
        try {
            //System.setSecurityManager(new RMISecurityManager()); depreciated?
            startRegistry(8888);
            AiguilleurServerImp server = new AiguilleurServerImp();
            Naming.rebind("//localhost:8888/AiguilleurServerImp", server);
            System.out.println("Naming rebind");
        } catch (MalformedURLException e) {
            System.out.println("malformed");
            e.printStackTrace();
        } catch (RemoteException e) {
            System.out.println("remote");
            e.printStackTrace();
        } 
        System.out.println("end");
            
    }

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