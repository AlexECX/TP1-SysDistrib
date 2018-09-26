package com.test_module.aiguilleur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.test_module.aiguilleur.AiguilleurServerImp;

/**
 * AiguilleurServer
 */
public class AiguilleurServer {

    public static void main(String[] args) {
        try {
            startRegistry(8123);
            AiguilleurServerImp server = new AiguilleurServerImp();
            Naming.rebind("//localhost:8123/AiguilleurServerImp", server);
            System.out.println("AiguilleurServer ready");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

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