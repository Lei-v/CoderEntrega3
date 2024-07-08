package Entrega4.managers;

import Entrega4.entities.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ClientManager  {
   public void create (String name, Integer docnumer)
       EntityManager manager = null;
       EntityTransaction transaction;
       try {
           manager = manager.get();
           transaction = manager.getTransaction();
           transaction.begin();
           Client client = new Client();
           client.setName(name);
           client.setDocnumber(docnumber);
           manager.persist(client);
transaction.commit();
       } catch (Exception e){
System.out.println(e);
   }  finally {
manager.closeEntity(manager);
}
    public class Client readone (Integer id){
   EntityManager manager = null;
   EntityTransaction transaction1;
   try {
manager = manager.get();
Client client = manager.find(Client.class,id);
return client;
} catch (Exception e){
       System.out.println(e);
   }  finally {
       manager.closeEntity(manager);
return client;
      }
}
