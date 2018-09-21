package com.test_module.cmodule;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.test_module.aiguilleur.AiguilleurException;
import com.test_module.aiguilleur.IAiguilleurServer;
import com.test_module.cmodule2.Calculator;
import com.test_module.cmodule2.CalculatorException;

/**
 * UserClient
 */
public class UserClient {

    public static void main(String[] args) {
        System.out.println("UserClient launched");

        try {
            IAiguilleurServer server = (IAiguilleurServer) Naming.lookup("//localhost:8888/AiguilleurServerImp");
            double x;
            x = server.compute("add", 2.0, 2.0);
            System.out.println(x);
            x = server.compute("sub", 2.0, 2.0);
            System.out.println(x);
            x = server.compute("mul", 2.0, 2.0);
            System.out.println(x);
            x = server.compute("div", 2.0, 2.0);
            System.out.println(x);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (AiguilleurException e) {
            e.printStackTrace();
        } catch (CalculatorException e) {
            e.printStackTrace();
        }

    }
}