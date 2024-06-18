import java.util.Random;

public class User {
    private String mail;
    private String mdp;
    private char role;


    public User(String mail, String mdp, char role){
        this.mail = mail;
        this.mdp = mdp;
        this.role = role;
    }

    public static String crypteMDP(String mdp){
        String res = "";
        for(char cha : mdp.toCharArray()){
            cha = (char)(cha*2);
            res+=cha;
            Random r = new Random();
            res+=(char)(r.nextInt(26) + 'a');
        }
        return res;
    }
    public static String decrypteMDP(String mdp){
        String res = "";
        for(int i = 0; i<mdp.length()-1; i+=2){
            char cha = mdp.charAt(i);
            cha = (char)(cha/2);
            res+=cha;  
        }
        return res;
    }


    public char getRole(){
        return role;
    }
}
