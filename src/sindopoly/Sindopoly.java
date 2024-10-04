/*THIS JAVA APPLICATION WAS CREATED BY DIMITRIS KOPSIDAS
AM:175008 EMAIL:jimkopsidas@hotmail.com DISCORD:Kops#6752*/

package sindopoly;

/*
 * @author JIM
 */
public class Sindopoly {
    //MAIN
    public static void main(String[] args) {
        
        
//game creation starts
        Game Sindos=new Game(0,0);
        //call askplayercount to ask the gamemaster for number of players
        Sindos.askplayercount();
        //create a String array to store player names
        String names[]=new String[Sindos.getplayercount()];
        //create an array of Player objects
        Player Team[]=new Player[Sindos.getplayercount()]; 
        //call askplayername to ask the gamemaster the name of each player and store in names[]
        for(int i=0;i<Sindos.getplayercount();i++){
            names[i]=Sindos.askplayername();
            //create Player objects and give them default numbers 
            Team[i]=new Player(i,names[i],0,0);//should be (names[i],1500,0).For debug purposes set to 0
        }
            //create the playing board
        Tile Tiles[] = new Tile[40];
        Tiles[0] = new Tile("ΑΦΕΤΗΡΙΑ",0,0,0,0,0,0,0,0,0,-2,0,-1,-1);
        Tiles[1] = new Tile("ΓΥΜΝΑΣΤΗΡΙΟ",1,50,60,2,10,30,90,160,250,-1,1,3,-1);
        Tiles[2] = new Tile("ΑΠΟΦΑΣΗ",2,0,0,0,0,0,0,0,0,-2,0,-1,-1);
        Tiles[3] = new Tile("ΒΙΒΙΛΙΟΘΗΚΗ",3,50,60,4,20,60,180,320,450,-1,1,1,-1);
        Tiles[4] = new Tile("ΕΝΟΙΚΙΟ",4,0,0,0,0,0,0,0,0,-2,0,-1,-1);
        Tiles[5] = new Tile("ΚΙΟΣΚΙ ΣΕΥΠ",5,0,200,0,0,0,0,0,0,-1,0,-1,-1);
        Tiles[6] = new Tile("ΣΤΑΣΗ ΔΙΠΑΕ",6,50,100,6,30,90,270,400,550,-1,2,8,9);
        Tiles[7] = new Tile("ΕΝΤΟΛΗ",7,0,0,0,0,0,0,0,0,-2,0,-1,-1);
        Tiles[8] = new Tile("ΣΤΑΣΗ ΙΘΑΚΗ",8,50,100,6,30,90,270,400,550,-1,2,9,6);
        Tiles[9] = new Tile("ΣΤΑΣΗ ΤΕΡΜΑΤΙΚΟΥ",9,50,120,8,40,100,300,450,600,-1,2,6,8);
        Tiles[10] = new Tile("ΦΥΛΑΚΗ",10,0,0,0,0,0,0,0,0,-2,0,-1,-1);
        Tiles[11] = new Tile("ΣΠΛΑΣ",11,100,140,10,50,150,450,620,750,-1,3,13,14);
        Tiles[12] = new Tile("ΚΥΛΙΚΕΙΟ",12,0,150,0,0,0,0,0,0,-1,0,28,-1);
        Tiles[13] = new Tile("ΠΟΔΗΛΑΤΟ",13,100,140,10,50,150,450,620,750,-1,3,14,11);
        Tiles[14] = new Tile("ΜΙΚΕΛ",14,100,160,12,60,180,500,700,900,-1,3,11,13);
        Tiles[15] = new Tile("ΚΙΟΣΚΙ ΔΙΟΙΚΗΣΗΣ",15,0,200,0,0,0,0,0,0,-1,0,-1,-1);
        Tiles[16] = new Tile("ΒΙΒΙΛΙΟΘΗΚΟΝΟΜΙΑΣ",16,100,180,14,70,200,550,750,950,-1,4,18,19);
        Tiles[17] = new Tile("ΑΠΟΦΑΣΗ",17,0,0,0,0,0,0,0,0,-2,0,-1,-1);
        Tiles[18] = new Tile("ΠΡΟΣΧΟΛΙΚΩΝ",18,100,180,14,70,200,550,750,950,-1,4,19,16);
        Tiles[19] = new Tile("ΤΕΧΝΟΛΟΓΙΑΣ ΤΡΟΦΙΜΩΝ",19,100,200,16,80,220,600,800,1000,-1,4,16,18);
        Tiles[20] = new Tile("ΕΛΕΥΘΕΡΗ ΣΤΑΘΜΕΥΣΗ",20,0,0,0,0,0,0,0,0,-2,0,-1,-1);
        Tiles[21] = new Tile("ΠΕΡΙΒΑΛΛΟΝΤΟΣ",21,150,220,18,90,250,700,875,1050,-1,5,23,24);
        Tiles[22] = new Tile("ΕΝΤΟΛΗ",22,0,0,0,0,0,0,0,0,-2,0,-1,-1);
        Tiles[23] = new Tile("ΓΕΩΠΟΝΙΑΣ",23,150,220,18,90,250,700,875,1050,-1,5,24,21);
        Tiles[24] = new Tile("ΔΙΑΤΡΟΦΗΣ/ΔΙΑΙΤΟΛΟΓΙΑΣ",24,150,240,20,100,300,750,925,1100,-1,5,21,23);
        Tiles[25] = new Tile("ΚΙΟΣΚΙ ΕΞΟΔΟΥ",25,0,200,0,0,0,0,0,0,-1,0,-1,-1);
        Tiles[26] = new Tile("ΜΑΙΕΥΤΙΚΗΣ",26,150,260,22,110,330,800,975,1150,-1,6,27,29);
        Tiles[27] = new Tile("ΝΟΣΗΛΕΥΤΙΚΗΣ",27,150,260,22,110,330,800,975,1150,-1,6,29,26);
        Tiles[28] = new Tile("ΛΕΣΧΗ",28,0,150,0,0,0,0,0,0,-1,0,12,-1);
        Tiles[29] = new Tile("ΒΙΟΪΑΤΡΙΚΩΝ",29,150,280,24,120,360,850,1025,1200,-1,6,26,27);
        Tiles[30] = new Tile("ΠΗΓΑΙΝΕ ΣΤΗ ΦΥΛΑΚΗ",30,0,0,0,0,0,0,0,0,-2,0,-1,-1);
        Tiles[31] = new Tile("ΤΟΥΡΙΣΜΟΥ",31,200,300,26,130,390,900,1100,1275,-1,7,32,34);
        Tiles[32] = new Tile("ΔΙΟΙΚΗΣΗΣ",32,200,300,26,130,390,900,1100,1275,-1,7,34,31);
        Tiles[33] = new Tile("ΑΠΟΦΑΣΗ",33,0,0,0,0,0,0,0,0,-2,0,-1,-1);
        Tiles[34] = new Tile("ΛΟΓΙΣΤΙΚΗΣ",34,200,320,28,150,450,1000,1200,1400,-1,7,31,32);
        Tiles[35] = new Tile("ΚΙΟΣΚΙ ΠΛΗΡΟΦΟΡΙΚΗΣ",35,0,200,0,0,0,0,0,0,-1,0,-1,-1);
        Tiles[36] = new Tile("ΕΝΤΟΛΗ",36,0,0,0,0,0,0,0,0,-2,0,-1,-1);
        Tiles[37] = new Tile("ΠΛΗΡΟΦΟΡΙΚΗΣ",37,200,350,35,175,500,1100,1300,1500,-1,8,39,-1);
        Tiles[38] = new Tile("ΕΝΟΙΚΙΟ",38,0,0,0,0,0,0,0,0,-2,0,-1,-1);
        Tiles[39] = new Tile("ΗΛΕΚΤΡΟΝΙΚΗΣ",39,200,400,50,200,600,1400,1700,2000,-1,8,37,-1);
        
        Card Cards[]=new Card[47];
        Cards[0] = new Card(0,0,8,"Ο φίλος σου που έχει αμάξι έφυγε πιο νωρίς σήμερα. Πάνε στην στάση ΙΘΑΚΗ να πάρεις το 52.");
        Cards[1] = new Card(1,0,11,"Ακυρώθηκε το εργαστήριο σου και δεν έχεις τι να κάνεις. Πάνε στο ΣΠΛΑΣ.");
        Cards[2] = new Card(2,0,39,"Πήγαινε στο ΤΜΗΜΑ ΗΛΕΚΤΡΟΝΙΚΗΣ.");
        Cards[3] = new Card(3,0,12,"Έχεις 3 ώρες κενό μέχρι το επόμενο μάθημα. Πάνε στο ΚΥΛΙΚΕΙΟ.");
        Cards[4] = new Card(4,0,3,"Πήγες να κάνεις Αλληλεπίδραση αλλά άργησες και δεν είχε θέση να κάτσεις. Πάνε στην ΒΙΒΛΙΟΘΗΚΗ.");
        Cards[5] = new Card(5,0,1,"Έχεις 3 ώρες κενό μέχρι το επόμενο μάθημα. Πάνε στο ΓΥΜΝΑΣΤΗΡΙΟ.");
        Cards[6] = new Card(6,0,10,"Σε έπιασαν για αντιγραφή σε δια ζώσης μάθημα. Πάνε στη ΦΥΛΑΚΗ.");
        Cards[7] = new Card(7,0,12,"Ήρθες χωρίς μάσκα για μάθημα. Πάνε στο ΚΥΛΙΚΕΙΟ.");
        Cards[8] = new Card(8,0,3,"Κόπηκες στην πρόοδο των Ηλεκτρονικών Κυκλωμάτων. Πάνε στην ΒΙΒΛΙΟΘΗΚΗ.");
        Cards[9] = new Card(9,0,5,"Χώρισες με την κοπέλα σου και θες να κάνεις γνωριμίες. Πάνε στο ΚΙΟΣΚΙ ΣΕΥΠ.");
        Cards[10] = new Card(10,0,35,"Χώρισες με το αγόρι σου και θες να κάνεις γνωριμίες. Πάνε στο ΚΙΟΣΚΙ ΠΛΗΡΟΦΟΡΙΚΗΣ.");
        Cards[11] = new Card(11,0,10,"Σε πέταξε έξω από την αίθουσα ο κ. Μπάμνιος επειδή μιλούσες στο μάθημα. Πάνε στην ΦΥΛΑΚΗ.");
        Cards[12] = new Card(12,0,9,"Η στάση του ΔΙΠΑΕ είναι γεμάτη. Περπάτα μέχρι την ΣΤΑΣΗ ΤΕΡΜΑΤΙΚΟΥ μπας και καταφέρεις να μπεις μέσα στο 52.");
        Cards[13] = new Card(13,0,19,"Πήγαινε στο ΤΜΗΜΑ ΤΕΧΝΟΛΟΓΙΑΣ ΤΡΟΦΙΜΩΝ.");
        Cards[14] = new Card(14,0,14,"Έκανες μάθημα με τον κ. Γουλιάνα. Δεν άκουσες τίποτα από την φασαρία αλλά γνώρισες νέους συμφοιτητές. Πάνε στο ΜΙΚΕΛ.");
        Cards[15] = new Card(15,0,0,"Πήγαινε στην ΑΦΕΤΗΡΙΑ.");
        Cards[16] = new Card(16,0,23,"Πήγαινε στο ΤΜΗΜΑ ΓΕΩΠΟΝΙΑΣ.");
        Cards[17] = new Card(17,0,37,"Πήγαινε στο ΤΜΗΜΑ ΠΛΗΡΟΦΟΡΙΚΗΣ.");
        Cards[18] = new Card(18,-10,-1,"Έφαγες χαλασμένες κονσέρβες στη λέσχη και έπαθες τροφική δηλητηρίαση. Πλήρωσε $10 για τα φάρμακα.");
        Cards[19] = new Card(19,-10,-1,"Σε δάγκωσε ένα από τα σκυλιά της γραμματείας. Πλήρωσε $10 για τον αντιτετανικό ορό.");
        Cards[20] = new Card(20,-15,-1,"Έληξε η κάρτα ΟΑΣΘ. Πλήρωσε $15.");
        Cards[21] = new Card(21,-50,-1,"Κόπηκες για πολλοστή φορά στο εργαστήριο των Αισθητηρίων και πρέπει να πληρώσεις κάποιον να σου περάσει το μάθημα. Πλήρωσε $50.");
        Cards[22] = new Card(22,-50,-1,"Κόπηκες στην Ηλεκτρονική Φυσική για 4η φορά. Πλήρωσε $50 κάποιον να σου περάσει το μάθημα.");
        Cards[23] = new Card(23,-5,-1,"Συμφοιτητής σου σε πηγαινοφέρνει Σίνδο-Θεσσαλονίκη με το αμάξι. Πλήρωσε $5 για να τον κεράσεις καφέ.");
        Cards[24] = new Card(24,10,-1,"Κέρδισες το 2ο βραβείο ομορφιάς. Παίρνεις $10.");
        Cards[25] = new Card(25,50,-1,"Από τους τόκους των χρημάτων σου λαμβάνεις $50.");
        Cards[26] = new Card(26,100,-1,"Έμαθες HTML με τον κ. Τεκτονίδη και πουλάς ιστοσελίδες part-time. Πάρε $100.");
        Cards[27] = new Card(27,5,-1,"Βρήκες ένα τάληρο στο πάτωμα. Πάρε $5.");
        Cards[28] = new Card(28,50,-1,"Έμαθες καλά Assembly και πέρασες τους συμφοιτητές σου στις διαδικτυακές εξετάσεις. Πάρε $50."); 
        Cards[29] = new Card(29,50,-1,"Έμαθες καλά Java και πέρασες τους συμφοιτητές σου στις διαδικτυακές εξετάσεις. Πάρε $50.");
        Cards[30] = new Card(30,50,-1,"Έμαθες καλά SQL και πέρασες τους συμφοιτητές σου στις διαδικτυακές εξετάσεις. Πάρε $50.");
        Cards[31] = new Card(31,10,-1,"Οι φίλοι σου σε πληρώνουν χαρτζιλίκι που τους πηγαινοφέρνεις με το αμάξι Σίνδο-Θεσσαλονίκη. Πάρε $10.");
        Cards[32] = new Card(32,20,-1,"Πήγες στη γιαγιά σου και σε χαρτζιλίκωσε. Πάρε $20.");
        Cards[33] = new Card(33,200,-1,"Δούλεψες σεζόν και τα τσέπωσες. Πάρε $200.");
        Cards[34] = new Card(34,50,-1,"Πούλησες τα παλιά σου συγγράματα. Πάρε $50.");
        Cards[35] = new Card(35,200,-1,"Βρήκες ενα κορόιδο να αγοράσει το potato pc σου. Πάρε $200.");
        Cards[36] = new Card(36,50,-1,"Έκανες καλή επένδυση στο Bitcoin. Πάρε $50.");
        Cards[37] = new Card(37,10,-1,"Πέρασες επιτέλους τη Σύνθεση Ηλεκτρονικών Κυκλωμάτων και χάρηκαν οι γονείς σου. Πάρε $10.");
        Cards[38] = new Card(38,10,-1,"Πέρασες την Ηλεκτρονική Φυσική με την τέταρτη προσπάθεια και χάρηκαν οι γονείς σου. Πάρε $10.");
        Cards[39] = new Card(39,10,-1,"Έπαιξες ΣΚΡΑΤΣ για πρώτη φορά και νίκησες. Πάρε $10.");
        Cards[40] = new Card(40,50,-1,"Έχεις γενέθλια.Η γιαγιά σου σου δίνει $50");
        Cards[41] = new Card(41,100,-1,"Κληρονομείς 100€.");
        Cards[42] = new Card(42,-20,-1,"Τελείωσε η καραντίνα και πρέπει να αγοράσεις εξαρτήματα για εργαστήριο ηλεκτρονικών. Πλήρωσε $20.");
        Cards[43] = new Card(43,-100,-1,"Σε έπιασαν με πλαστό πιστοποιητικό στην είσοδο. Πλήρωσε $100.");
        Cards[44] = new Card(44,-50,-1,"Κόλλησες κορονοιό.Πλήρωσε $50 για τα φαρμακα.");
        Cards[45] = new Card(45,-5,-1,"Αγόρασες κινέζικα καλώδια για το εργαστήριο στις Ηλεκτρονικές Διατάξεις και χάλασαν. Πλήρωσε $5 για καινούργια.");
        Cards[46] = new Card(46,-30,-1,"Ευθυγραμίστηκαν οι πλανήτες και μπήκε ελεγκτής στο 52. Πλήρωσε $30.");
        Cards[47] = new Card(47,-20,-1,"Σου τελειώνουν τα καύσιμα. Πλήρωσε $20 για να γεμίσεις το ντεπόζιτο.");


//game creation ends 
        
        
        
        
        
        //debug
        Team[1].setmoney(1000);
        Team[0].setmoney(2000);
        
            
            
        int round=Sindos.getplayercount();  
        int numberofbankrupts=0;
        
//starter dice roll starts
        //each player throws the dice.The player with the highest diceroll starts the game          
        int starter=0,j,dicenow,dicebefore;
        System.out.println("Everyone throw the dice to decide who plays first");
        System.out.println("Player 1 rolls the dice");
        dicebefore=Sindos.diceroll();//roll for player 1 and then check if the other players get a higher result than them
        for(j=1;j<round;j++){
            System.out.println("Player "+(j+1)+" rolls the dice");
            dicenow=Sindos.diceroll();
            if(dicenow>dicebefore){
                dicebefore=dicenow;
                starter=j;
            }
        }
        System.out.println("Ο/η παίκτης/ρια "+Team[starter].getname()+" ξεκινάει το παιχνίδι!");
        Player tempplayer; //make the winner of the starter diceroll the first player on the Team[j] array 
        tempplayer=Team[0];//so that when the loop below starts that player will be the first one to play
        Team[0]=Team[starter];
        Team[starter]=tempplayer;
//starter dice roll ends
        
        
        
        
       
        
//rounds start
        //checks that there are at least two players that have money>0.If there is only one player with money the game ends and announces the winner
        while(numberofbankrupts<(Sindos.getplayercount()-1)){
            //while there are at least 2 players left with money then it continues the game
            
            
            
            
            
            
            
            for(j=0;j<round;j++){
                System.out.println(Team[j].getname()+" is playing");
                
                if(Team[j].getmoney()==0){//if the player doesnt have money count him as bankrupt and skip his round
                    if(Team[j].gethasmoney()==true)//if it is the first time he is found bankrupt count him just once
                        numberofbankrupts++;
                    Team[j].sethasmoney(false);//this line stops the number of bankrupts from incrementing each round and does it only one time
                    System.out.println(Team[j].getname()+" doesnt have any money left so their round is skipped");
                }else{//player has money so his round starts
                    
                    //calculations for positions start here
                    int dice1,dice2,dicetotal;
                    int extra1,extra2;
                    boolean dicetojail=false;
                    
                    //throw two dice
                    dice1=Sindos.diceroll();
                    dice2=Sindos.diceroll();
                    if(dice1==dice2){//if you get the same number two times you roll again
                        System.out.println("You rolled the same number twice!Roll again!");
                        extra1=Sindos.diceroll();
                        extra2=Sindos.diceroll();
                        dicetotal=dice1+dice2+extra1+extra2;
                        if(extra1==extra2){//if you get the same number two times the second time you go to jail
                            dicetojail=true;
                            dicetotal=0;
                            System.out.println("Ωχ έτυχες τον ίδιο αριθμό για δεύτερη φορά.Πρέπει να πας στην φυλακή!");
                        }
                    }else{//normal outcome
                        dicetotal=dice1+dice2;
                    }
                    if(dicetojail==true){//sent to jail
                        Team[j].setposition(10);
                    }else{
                        Team[j].setposition(Team[j].getposition()+dicetotal);
                    }     
                    
                    if(Team[j].getposition()>39){//fix for position overflow eg. player passes over start which is position 0
                        Team[j].setposition(Team[j].getposition()-40);
                    }
                    System.out.println(Team[j].getname()+" moves to tile "+Team[j].getposition());//max is 39
                    
                    
                    
                    
                    
                    
                    
                    
                    int tilenumber=Team[j].getposition();
                    int tileownernum=Tiles[tilenumber].getowner();
                    
                    
                    
                    //below follow all the checks for all the tiles 
                    if(Team[j].getposition()==2||Team[j].getposition()==17||Team[j].getposition()==33){//community chest
                        Sindos.chest(Team,Cards,j);
                    }else if(Team[j].getposition()==7||Team[j].getposition()==22||Team[j].getposition()==36){//chance 
                        Sindos.chance(Team,Cards,j);
                    }else if(Team[j].getposition()==30){//go to jail
                        Team[j].setposition(10);
                    }else if(Team[j].getposition()==5||Team[j].getposition()==15||Team[j].getposition()==25||Team[j].getposition()==35){//stations
                        if(Tiles[tilenumber].getowner()==-1){//if the station doesnt belong to anyone
                            //Sindos.payup();
                        }else if(Tiles[tilenumber].getowner()>-1&&Tiles[tilenumber].getowner()!=Team[j].getid()){//if the station is owned by someone else
                            //Sindos.station();
                        }     
                    }else if(Team[j].getposition()==12||Team[j].getposition()==28){
                        if(Tiles[tilenumber].getowner()==-1){
                            //Sindos.buy();
                        }else{
                            Sindos.utilities(Team, Tiles, j, tilenumber);}
                    }else if(Tiles[Team[j].getposition()].getowner()==-1){//if the tile the player landed on is not bought
                        //Sindos.buy();
                    }else if(Tiles[Team[j].getposition()].getowner()==Team[j].getid()){//if the tile the player landed on is owned by himself
                        //Sindos.upgrade();
                    }else if(Tiles[Team[j].getposition()].getowner()>-1){//if the tile the player landed on is owned by someone else
                        //Sindos.payup();
                    }
                } 
            }
        }
//rounds end
        
        
        
        
        
        
        
        
        
        
        
        
        //checks who won
        for(int k=0;k<round;k++){
            if(Team[k].getmoney()>0){
                System.out.println("PLAYER "+Team[k].getname()+" WON WITH A SCORE OF "+Team[k].getmoney());
            }
        }
    }
}
