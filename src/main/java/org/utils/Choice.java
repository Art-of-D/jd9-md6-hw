package org.utils;

import org.selection_classes.*;

import java.util.Scanner;

public class Choice {
    public void giveChoice() throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Please do your choice:\n 1) Create a new client (enter 1)\n 2) Get a name by id (enter 2)" +
                "\n 3) Set name by id (enter 3)\n 4) Delete a client by id\n 5) Get a list of client\n enter 0 to exit");
        Integer choice = in.nextInt();
        switch (choice) {
            case (1):
                System.out.println("Please enter name of a new client!");
                in.nextLine();
                String str = in.nextLine();
                if (str.length() < 2 && str.length() > 1000){
                System.out.println(new ClientService().create(str));
                break;
                } throw new Exception ("Please enter valid name, bigger than 2 and smaller than 1000");
            case (2):
                System.out.println("Please enter id to see the client`s name!");
                in.nextLine();
                long byId = in.nextLong();
                System.out.println(new ClientService().getById(byId));
                break;
            case (3):
                System.out.println("Please enter client`s id that you want to change!");
                long newId = in.nextLong();
                System.out.println("Please enter a new name!");
                in.nextLine();
                String newName = in.nextLine();
                if (newName.length() < 2 && newName.length() > 1000){
                    new ClientService().setName(newId, newName);
                    break;
                } throw new Exception ("Please enter valid name, bigger than 2 and smaller than 1000");
            case (4):
                System.out.println("Please enter client`s id that you want to delete!");
                in.nextLine();
                long dropId = in.nextLong();
                new ClientService().deleteById(dropId);
                break;
            case (5):
                System.out.println("Client:");
                for (Client client: new ClientService().listAll()){
                    System.out.println("id - " + client.getId() + ", name - " + client.getName());
                };
                break;
            case(0):
                break;
            default:
                System.out.println("Please choose something!");
        }
    }
}
