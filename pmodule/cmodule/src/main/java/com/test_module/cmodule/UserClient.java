package com.test_module.cmodule;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.test_module.aiguilleur.IAiguilleurServer;
import com.test_module.cmodule2.Calculator;

/**
 * UserClient
 */
public class UserClient {

    public static void main(String[] args) {
        System.out.println("UserClient");

        try {
            IAiguilleurServer server = (IAiguilleurServer) Naming.lookup("//localhost:8888/AiguilleurServerImp");
            double x;
            for (int i = 0; i < 1000; i++) {
                x = server.compute("add", 2.0, 2.0);
                System.out.println(x);
            }
            

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