import java.util.Random;
import java.util.Scanner;
/**
 * This program is to create a game of Pig which is a simple, two-player (between the user and the computer) game. If the player rolls a 1, then the player gets no new points and it becomes the other player’s turn.  If the player rolls 2 through 6, then he or she can either: – ROLL AGAIN or – HOLD.
 * @author Deepali Juneja
 * @version 12 February 2020
 */
public class H4P2{
    public static Random r;
    public static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int user_tot_score=0,comp_tot_score=0; //total score of user and computer
        r = new Random();

        System.out.println("Hello!Welcome to the Pig game!");// this statement prints the welcome message

        while(true)
        {

            user_tot_score=usersTurn(user_tot_score);

            comp_tot_score=computersTurn(comp_tot_score);

        }
    }

    /**
     * This method has conditions for the user's turn.
     */
    public static int usersTurn(int user_tot_score) {
        char ch;
        int rand=0,user_temp_tot=0,user_turn_score=0;
        while(true)
        {

            rand=rollDie();
            if(rand==1)
            {
                System.out.println("Your roll is : "+rand);
                user_temp_tot=0;// this resturns the total score of the user after his/her turn
                user_turn_score=0;
                break;
            }
            System.out.println("\nYour roll is: "+rand);
            user_turn_score+=rand;

            user_temp_tot=user_tot_score+user_turn_score;

            System.out.println("Your score for this turn is"+user_turn_score+" and your full score is "+user_tot_score);
            System.out.println("If you choose to hold, you will have "+user_temp_tot+" points");
            System.out.println("Please enter 'R' to roll again, 'H' to hold.");
            ch = sc.next(".").charAt(0);
            if(ch=='r'||ch=='R')
                continue;
            else
            {
                if(user_temp_tot>=100)
                {
                    System.out.println("The user won!");
                    user_tot_score=user_temp_tot;
                    System.out.println("Score of the user"+user_tot_score);
                    System.exit(0);
                }
                user_tot_score=user_temp_tot;
                System.out.println("Your score: "+user_tot_score);
                user_turn_score=0;
                user_temp_tot=0;
                break;
            }
        }
        return user_tot_score;
    }

    /**
     * This method plays the computer's turn
     */
    public static int computersTurn(int comp_tot_score)
    {
        int rand1,com_turn_score=0,com_temp_tot=0;
        System.out.println("\nTime for the computer to play now.\n");
        while(true)
        {
            rand1=rollDie();
            System.out.println("The computer got: "+rand1);
            if(rand1==1)
            {
                System.out.println("The computer lost!");
                System.out.println("The score of the computer is:"+comp_tot_score);
                com_turn_score=0;// this returns the total score of the computer
                com_temp_tot=0;
                break;
            }
            com_turn_score+=rand1;
            com_temp_tot=comp_tot_score+com_turn_score;
            if(com_temp_tot>=100)
            {
                System.out.println("The computer won!");
                comp_tot_score=com_temp_tot;
                System.out.println("The score of the computer is: "+comp_tot_score);
                System.exit(0);
            }
            if(com_turn_score>=20 ) //the computer plays its die until it reaches a score of 20 or rolls a 1.
            {
                comp_tot_score+=com_turn_score;
                System.out.println("The computer holds.");
                System.out.println("The score of the computer is: "+comp_tot_score);

                com_turn_score=0;
                break;
            }
            else
            {
                continue;
            }

        }
        return comp_tot_score;

    }

    public static int rollDie()// this final method generates a no. from 1 to 6 like a dice does.
    {
        int die = r.nextInt(6) + 1;
        return die;
    }

}
