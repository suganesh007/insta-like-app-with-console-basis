package package1;

import java.util.Scanner;

public class Likes {
    private static final Scanner sc=new Scanner(System.in);
    /// post and user are objects
    protected static void likes(post post, user user){
        System.out.println("1.) likes \n2.) dislike\n3.) skip");
        Scanner scanner=new Scanner(System.in);
        int input=scanner.nextInt();
        if(input==1 && !post.liked_user_list.contains(user.name)){
            post.liked_user_list.add(user.name);
            post.likes++;
            boolean flag=post.disliked_user_list.remove(user.name);
            if(flag)
                post.dislikes--;
            System.out.println("liked successful");
        }
        else if(input==1){
            post.liked_user_list.remove(user.name);
            post.likes--;
            System.out.println("liked successful");
        }
        else if(input==2 && !post.disliked_user_list.contains(user.name)){
            post.disliked_user_list.add(user.name);
            post.dislikes++;
            boolean flag=post.liked_user_list.remove(user.name);
            if(flag)
                post.likes--;
            System.out.println("disliked successful");
        }
        else if(input==2){
            post.disliked_user_list.remove(user.name);
            post.dislikes--;
            System.out.println("disliked successful");
        }



    }

    protected static void editPost(post post){
        System.out.println("edit post \n skip");
        int input=sc.nextInt();
        if(input==1){
            // head
            editHeader(post);
            // content
            editContent(post);
            // comments check
            editComment(post);


        }
    }


    public static void editHeader(post post){
        System.out.print("header: edit=1 , skip=2 or any number = ");
        int head=sc.nextInt();
        if (head == 1) {
            System.out.print("write head: ");
            sc.nextLine();
            post.header=sc.nextLine();
        }
    }

    public static void editContent(post post){
        System.out.print("content: edit=1 , skip=2 or any number = ");
        int con=sc.nextInt();
        if (con == 1) {
            System.out.print("write content: ");
            sc.nextLine();
            post.content=sc.nextLine();
        }

    }

    public static void editComment(post post){
        System.out.print("comments: edit=1 , skip=2 or any number = ");
        int com=sc.nextInt();
        if (com == 1) {
            System.out.println("no comments allowed \n allowed comments \nlimited comments");
            int input=sc.nextInt();
            if(input==1){
                post.comment_limit=0;
                post.comments_list=null;
            }
            if(input==2)
                post.comment_limit=Integer.MAX_VALUE;
            else if(input==3){
                System.out.println("limit value ");
                post.comment_limit= sc.nextInt();
            }
            else {
                editComment(post);
            }
        }

    }
}
