/*THIS JAVA APPLICATION WAS CREATED BY DIMITRIS KOPSIDAS
AM:175008 EMAIL:jimkopsidas@hotmail.com DISCORD:Kops#6752*/

package sindopoly;
import java.util.concurrent.TimeUnit;
/*
 * @author JIM
 */
public class Game {
    
    private int playercount;
    private int namesarraysize;
    private int tempnum=1;
    
    //CONSTRUCTOR
    public Game(int playercount,int namesarraysize){
        this.playercount=playercount;
        this.namesarraysize=namesarraysize;
       
    }
    public void askplayercount(){  
        int temp;
        System.out.println("Choose number of players between 1 and 6:");
        temp=In.Int();
        while(temp<1||temp>6){
            if(temp<1||temp>6){
                System.out.println("You chose poorly.Try again");
                temp=In.Int();
            }
        }
        System.out.println("Starting game with "+temp+" players");
        setplayercount(temp);
        setnamesarraysize(temp-1);
    }
    public String askplayername(){     
        String tempname;
        System.out.println("Give me the name of player "+tempnum);
        tempname=In.String();
        tempnum++;
        return tempname;        
    }
    public void printnamesarray(String array[]){
        for (int i=0;i<array.length;i++){
            System.out.println("Player "+(i+1)+"'s name is"+array[i]);
        }
    }
    public int diceroll(){
        int result;
        System.out.println("Ρίξε το ζάρι...");
        result=(int)(Math.random()*6+1);
        //start of delay in millisecs
        try{
            Thread.sleep(1500);
        } 
        catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
        //end of delay in millisecs
        System.out.println("Έριξες "+result+"!");
        return result;
    }
    public void payup(Player opponent,Player owner,Tile Tile[],int j){
        int pay=0;
        int brother=Tile[j].getbrother();
        int sister=Tile[j].getsister();
        
        //check if property has upgrades
        if(Tile[j].getupgrades()==0){
            if(Tile[j].getowner()==Tile[brother].getowner()&&Tile[j].getowner()==Tile[sister].getowner())//if three in color group and owned by the same player
                pay=Tile[j].getcost0()*2;
            else if(Tile[j].getowner()==Tile[brother].getowner())//if two in color group and owned by the same player
                pay=Tile[j].getcost0()*2;
            else
                pay=Tile[j].getcost0();
        }else{
            if(Tile[j].getupgrades()==1)
                pay=Tile[j].getcost1();
            if(Tile[j].getupgrades()==2)
                pay=Tile[j].getcost2();
            if(Tile[j].getupgrades()==3)
                pay=Tile[j].getcost3();
            if(Tile[j].getupgrades()==4)
                pay=Tile[j].getcost4();
            if(Tile[j].getupgrades()==5)
                pay=Tile[j].getcosthotel();
        }
        System.out.println("Player "+opponent.getname()+" has to pay "+Tile[Tile[j].getowner()].getname()+" "+pay+"$");
        opponent.setmoney(opponent.getmoney()-pay);//substract the pay sum from the opponent
        owner.setmoney(owner.getmoney()+pay);//and add it to the owner
    }
    public void buy(Player player,Tile tile[],Player Team[],int j){
        System.out.println("Θες να αγοράσεις την ιδιοκτησία "+tile[j].getname()+" για "+tile[j].getcosttobuy()+"$?");
        String answer=In.String();
        if(answer=="ΝΑΙ"|answer=="ναι"|answer=="Ναι"){
            player.setmoney(player.getmoney()-tile[j].getcosttobuy());//substract the cost to buy from the player's money
            tile[j].setowner(player.getid());//set the owner of property to the one that bought it
        }else{
            System.out.println("Θέλει κάποιος άλλος παίκτης να αγοράσει αυτή την ιδιοκτησία?");
            String answer2=In.String();
            if(answer=="ΝΑΙ"|answer=="ναι"|answer=="Ναι"){
                System.out.println("Η ιδιοκτησία αυτή μπαίνει σε δημοπρασία.Δημοπρατείστε την μεταξύ σας και γράψτε παρακάτω τον αριθμό του/της αγοραστή/τρια της");
                int buyer=In.Int();
                while(buyer<1||buyer>playercount){
                    System.out.println("Μου έδωσες λάθος αγοραστή/τρια.Δοκίμασε ξανα.");
                    buyer=In.Int();
                }
                buyer=buyer-1;//convert player number to array nubmer eg player 1 for users=player 0 for console
                Team[buyer].setmoney(Team[buyer].getmoney()-tile[j].getcosttobuy());//from the Team array of player change the money of the buyer
                tile[j].setowner(buyer);
            }else if(answer=="Οχι"|answer=="ΟΧΙ"|answer=="οχι"){
                System.out.println("Η ιδιοκτησία δεν αγοράστηκε.");
            }
        }
    }
    public void upgrade(Player owner,Tile tile[],int j){
        int cost;
        int upgradecost=tile[j].getupgrades();//calculate how much the upgrade will cost according to number of previous upgrades
        if(tile[j].getupgrades()<4)
            upgradecost=tile[j].gethouseprice();
        else if(tile[j].getupgrades()>4)//max upgrades
            upgradecost=0;
        System.out.println("Θες να αναβαθμίσεις την ιδιοκτησία σου");
        String answer=In.String();
        String answer2;
        if(answer=="ΝΑΙ"|answer=="ναι"|answer=="Ναι"){
            if(upgradecost!=0){//if not hotel already placed
                System.out.println("Η αναβάθμιση θα σου κοστίσει "+upgradecost+".Είσαι σίγουρος/η πως θες να την αναβαθμίσεις?");
                answer2=In.String();
                if(answer2=="ΝΑΙ"|answer2=="ναι"|answer2=="Ναι"){
                    tile[j].setupgrades(tile[j].getupgrades()+1);//set upgrade
                    owner.setmoney(owner.getmoney()-upgradecost);//substract the money cost
                    if(tile[j].getupgrades()<5)
                        System.out.println("Η ιδιοκτησία αναβαθμίστηκε σε "+tile[j].getupgrades()+" σπίτια");
                    else if(tile[j].getupgrades()==5)
                        System.out.println("Η ιδιοκτησία αναβαθμίστηκε πλήρως σε 1 ξενοδοχείο");
                }
            }else if(upgradecost==0){
                System.out.println("Η ιδιοκτησία είναι πλήρως αναβαθμισμένη δεν μπορείς να την αναβαθμίσεις περισσότερο");
            }
        
        }else if(answer=="Οχι"|answer=="ΟΧΙ"|answer=="οχι"){
            System.out.println("Η ιδιοκτησία δεν αναβαθμίστηκε καθόλου");
        }
    }
    public void station(Player player[],Tile tile[],int j){
        int ownerid=tile[j].getowner();
        int cost=0;
        int sameowner=0;
        if(tile[5].getowner()==j){//count how many stations are owned by the same person
            sameowner=sameowner+1;
        }
        if(tile[15].getowner()==j){
            sameowner=sameowner+1;
        }
        if(tile[25].getowner()==j){
            sameowner=sameowner+1;
        }
        if(tile[35].getowner()==j){
            sameowner=sameowner+1;
        }
        if(sameowner==1)
            cost=25;
        if(sameowner==2)
            cost=50;
        if(sameowner==3)
            cost=100;
        if(sameowner==4)
            cost=200;
        player[j].setmoney(player[j].getmoney()-cost);//substract from the opponent
        player[ownerid].setmoney(player[ownerid].getmoney()+cost);//add to the owner
    }
    public void utilities(Player player[],Tile tile[],int j,int tilenum){
        int totaldice;
        int dice1,dice2;
        int ownernum=tile[tilenum].getowner();
        int multiplier;
        int totalcost;
        System.out.println("Ρίξε τα ζάρια για να δεις πόσο πρέπει να πληρώσεις τον/την ιδιοκτήτη/ρια");
        dice1=diceroll();
        dice2=diceroll();
        totaldice=dice1+dice2;
        if(tile[12].getowner()==ownernum&&tile[28].getowner()==ownernum){//if both utilities are owned by the owner of the one that an opponent landed on
            multiplier=10;
        }else
            multiplier=4;
        totalcost=totaldice*multiplier;
        System.out.println("Το συνολικό κόστος είναι "+totalcost+"$");
        player[j].setmoney(player[j].getmoney()-totalcost);//substract the cost from the opponent who landed on the tile
        player[ownernum].setmoney(player[ownernum].getmoney()+totalcost);//add the cost to the owner of the tile
        
    }
    public void chest(Player player[],Card cards[],int j){
        int rand=(int)(Math.random()*23);//choose a random card 
        int cost=cards[rand].getcost();
        int move=cards[rand].getmoveto();
        String call=cards[rand].getcall();
        
        System.out.println(call);
        if(move!=-1){//if the card moves you somewhere
            player[j].setposition(move);
        }
        player[j].setmoney(player[j].getmoney()+cost);  
    }
    public void chance(Player player[],Card cards[],int j){
        int rand=(int)(Math.random()*47+24);//choose a random card 
        int cost=cards[rand].getcost();
        int move=cards[rand].getmoveto();
        String call=cards[rand].getcall();
        
        System.out.println(call);
        if(move!=-1){//if the card moves you somewhere
            player[j].setposition(move);
        }
        player[j].setmoney(player[j].getmoney()+cost);  
    }

    //SETTERS
    public void setplayercount(int playercount){
        this.playercount=playercount;
    }
    public void setnamesarraysize(int namesarraysize){
        this.namesarraysize=namesarraysize;
    }
    
    
    //GETTERS
    public int getplayercount(){
        return playercount;
    }
    public int getnamesarraysize(){
        return namesarraysize;
    } 
}
