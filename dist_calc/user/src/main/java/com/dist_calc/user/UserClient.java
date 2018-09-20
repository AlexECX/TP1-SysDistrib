package com.dist_calc.user;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.dist_calc.calc.Calculator;
import com.dist_calc.aiguilleur.IAiguilleurServer;

/**
 * UserClient
 */
public class UserClient {
    
    public static void main(String[] args) {
        System.out.println("UserClient");

        try {
            IAiguilleurServer server = (IAiguilleurServer)Naming.lookup("//localhost:8888/AiguilleurServerImp");
            Calculator calc = server.getCalculator();
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