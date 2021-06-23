import java.util.Scanner;
public class BlackJack{
    Scanner scan=new Scanner(System.in);
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see....");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        int card1=drawRandomCard();
        int card2=drawRandomCard();

        System.out.println("\nYou get a :"+ cardString(card1) +"\nand a :"+ cardString(card2));

        int total =Math.min(card1,10)+Math.min(card2,10);
        System.out.println("Your total is:"+total);

        int dealerCard1=drawRandomCard();
        int dealerCard2=drawRandomCard();
        System.out.println("\nThe dealer shows: "+ cardString(dealerCard1) +"\nand has a card facing down: "+ faceDown());

        int dealerTotal=Math.min(dealerCard1,10)+Math.min(dealerCard2,10);
        System.out.println("\nThe dealer's total is hidden");

        while (true){
            String option =hitOrStay();
            if(option.equals("stay")){
                break;
            }
            int newCard=drawRandomCard();
            total+=Math.min(newCard,10);
            System.out.println("\nYou get a: " +cardString(newCard));
            System.out.println("your total is : "+total);

            if(total>21){
                System.out.println("Bust!Player loses");
                System.exit(0);
            }


        }

        System.out.println("\nDealer's turn");
        System.out.println("\nThe dealer's cards are :"+ cardString(dealerCard1)+" \nand a :"+ cardString(dealerCard2));

        while(dealerTotal<17){
            int newCard=drawRandomCard();
            dealerTotal+=Math.min(newCard,10);
            System.out.println("\nDealer gets a: "+cardString(newCard));
            System.out.println("Dealer's total is: "+dealerTotal);
        }

        if(dealerTotal>21){
            System.out.println("Bust! Dealer loses.");
            System.exit(0);
        }

        if(total>dealertotal){
            System.out.println("Player wins!");
        }else{
            System.out.println("Dealer wins!");
        }


    }

    public static int drawRandomCard(){
        double randomNumber=Math.random()*13;
        randomNumber+=1;
        return (int)randomNumber;

    }

    public static String cardString(int cardNumber){
        switch(cardNumber){
            case 1:return "card";
            case 2:return "playing";
            case 3:return "king";
            case 4:return "queen";
            case 5:return "jack";
            case 6:return "spade";
            case 7:return "heart";
            case 8:return "diamond";
            case 9:return "club";
            case 10:return "face";
            case 11:return "court";
            case 12:return "bridge";
            case 13:return "poker";
            default:return "";
        }
    }

    public static String faceDown(){
        return "facedown";
    }

    public static String hitOrStay(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Would you like to hit or stay?");
        String response=scan.nextLine();
        while(!(response.equalsIgnoreCase("hit")|| response.equalsIgnoreCase("stay"))){
            System.out.println("Please write hit or stay");
            response=scan.nextLine();
        }
        return response;
    }

}
