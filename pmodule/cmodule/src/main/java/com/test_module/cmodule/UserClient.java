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
            Calculator calc = server.getCalculator();
            while (calc == null) {
                Thread.sleep(100);
                calc = server.getCalculator();
            }
            String x = calc.add();
            System.out.println(x);

            Calculator calc2 = server.getCalculator();
            if (calc2 == null) {
                System.out.println("calc2 == null");
            }
            server.registerCalculator(calc);
            calc2 = server.getCalculator();
            if (calc2 != null) {
                System.out.println("calc2 != null");
            }
            x = calc.add();
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