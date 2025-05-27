package package1;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class process extends Likes {
    private static final Scanner sc=new Scanner(System.in);
    public static ArrayList<user> user_list=new ArrayList<>();
    public static ArrayList<post> post_list=new ArrayList<>();
    public static user current_user;
    public static post current_viewing_post;

    public static boolean Login(String name, String password){
        if(user_list==null) {
            System.out.println("No user exists");
            return false;
        }
        for(user u:user_list){
            if(Objects.equals(u.name, name) && Objects.equals(u.password, password)) {
                current_user = u;
                System.out.println("Login Successful");
                return true;
            }
        }
        System.out.println("User not found. plz sign up");
        return false;
    }

    public static void Signup(String name, String password, String email){
        if(!user_list.isEmpty()) {
            for (user u : user_list) {
                if (Objects.equals(u.e_mail_id, email) || Objects.equals(u.name, name)) {
                    System.out.println("email-id/user name is exists");
                    return;
                }
            }
        }
        user newUser=new user();
        newUser.name=name;
        newUser.password=password;
        newUser.e_mail_id=email;
        user_list.add(newUser);
        System.out.println("Sign Up Successful. login now! ");
    }

    public static boolean showHeading(){
        if(post_list==null|| post_list.isEmpty()) {
            System.out.println("no post yet created");
            return false;
        }
        System.out.println("headers are:");
        for(post p:post_list)
            System.out.print(p.header + ", ");
        return true;
    }

    public static void createPost(String header, String content){
        post newPost=new post();
        newPost.header=header;
        newPost.content=content;
        newPost.user_name=current_user.name;
        System.out.println("1.) no comments allowed \n2.) allowed comments \n3.) limited comments");
        int input=sc.nextInt();
        if(input==2)
            newPost.comment_limit=Integer.MAX_VALUE;
        else if(input==3){
            System.out.println("limit value ");
            newPost.comment_limit= sc.nextInt();
        }
        post_list.add(newPost);
        current_user.post.add(newPost);
        System.out.println("post created Successful");
    }


    public static void printPost(String header){
        if(post_list==null) {
            System.out.println("no post yet created");
        }
        for(post p:post_list) {
            if(Objects.equals(p.header, header)) {
                current_viewing_post=p;
                System.out.println("   " + p.header + " \n" + p.content);
                System.out.println("likes: " + p.likes + "     dislikes: " + p.dislikes);
                System.out.println("\ncomments: ");
                if(p.comments_list.isEmpty())
                    System.out.println("comments are not added");
                else {
                    for (String c : p.comments_list)
                        System.out.println(" -> " + c);
                }
            }
        }
    }

    public static void addComment(){
        if(current_viewing_post.comment_limit ==0){
            System.out.println("\ncomments are turned off");
            return;
        }
        else if(current_viewing_post.comment_limit <= current_viewing_post.comments_list.size()) {
            System.out.println("comments limit exceeds");
            return;
        }
        System.out.println("add comment (yes-> 1 / no-> 2)\n");
        switch (sc.nextInt()) {
            case 1: {
                sc.nextLine();
                current_viewing_post.comments_list.add(sc.nextLine());
                System.out.println("comment added successful");
                break;
            }
            case 2: {
                System.out.println("no comments added");
                break;
            }
        }
    }

    public static void likes(){
        Likes.likes(current_viewing_post, current_user);
        System.out.println("\n");
    }


    public static void editContent(){
        if(post_list.isEmpty()){
            System.out.println("no post created yet");
        }

        for(post p:post_list){
            if(Objects.equals(p.user_name, current_user.name)){
                Likes.editPost(p);
                System.out.println("post edited successful");
            }
        }
    }
}
