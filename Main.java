package package1;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

            boolean loginSuccessStatus=false;
            while(true) {
                System.out.println("login \nsign up");
                int input=sc.nextInt();
                switch (input) {
                    case 1: {

                        System.out.println("username ");
                        sc.nextLine();
                        System.out.println("password ");
                        loginSuccessStatus=process.Login(sc.nextLine(), sc.next());
                        break;
                    }
                    case 2: {
                        System.out.println("username ");
                        sc.nextLine();
                        System.out.println("password ");
                        System.out.println("e-mail id ");
                        process.Signup(sc.nextLine(), sc.next(), sc.next());
                        break;
                    }
                }
                outer:while (loginSuccessStatus) {
                    System.out.println("\n1.) view post \n2.) create post \n3.) edit post \n4.) logout");
                    int input1 = sc.nextInt();
                    switch (input1) {
                        case 1: {
                            boolean post_availability=process.showHeading();
                            if(post_availability) {
                                sc.nextLine();
                                String head = sc.nextLine();
                                process.printPost(head);
                                // likes added not completed yet
                                process.likes();
                                process.addComment();
                            }
                            break;
                        }
                        case 2: {
                            sc.nextLine();
                            System.out.println("header ");
                            String header = sc.nextLine();
                            System.out.println("content ");
                            process.createPost(header, sc.nextLine());
                            break;
                        }
                        case 3:{
                            process.editContent();
                            break;
                        }
                        case 4: {
                            loginSuccessStatus=false;
                            System.out.println("Logout Successful");
                            break outer;
                        }
                    }
                }
            }
        }
    }