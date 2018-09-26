package com.test_module.cmodule;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.test_module.aiguilleur.AiguilleurException;
import com.test_module.aiguilleur.Aiguilleur;
import com.test_module.cmodule2.CalculatorException;
import com.test_module.cmodule.Operation;

/**
 * UserClient
 */
public class UserClient {

    public static void main(String[] args) {
        System.out.println("UserClient launched");

        try {
            Aiguilleur server = (Aiguilleur) 
                        Naming.lookup("//localhost:8123/AiguilleurServerImp");
            Client client = new ClientImp(new Operation("add", 3.0, 2.0));
            server.compute(client);
            client.setOperation(new Operation("sub", 3.0, 2.0));
            server.compute(client);
            client.setOperation(new Operation("mul", 3.0, 2.0));
            server.compute(client);
            client.setOperation(new Operation("div", 3.0, 2.0));
            server.compute(client);

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