package package1;

import java.util.ArrayList;

public class post {
    String user_name;
    String header;
    String content;
    int likes=0;
    int dislikes=0;
    ArrayList<String> liked_user_list;
    ArrayList<String> disliked_user_list;
    int comment_limit=0;
    ArrayList<String> comments_list;

    public post(){
        liked_user_list=new ArrayList<>();
        disliked_user_list=new ArrayList<>();
        comments_list=new ArrayList<>();
    }
}
