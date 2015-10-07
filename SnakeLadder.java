/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakeladder;
import java.util.*; 
import java.lang.*; 
import java.io.*; 

/**
 *
 * @author Naman
 */
 // make it aligned with the inputs here 
public class SnakeLadder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int i,j,k,snakes=0,player=0; 
       // int [] board=new int[100];
        Scanner sc=new Scanner(System.in); 
        System.out.println("Welcome to Snake and Ladder game !!"); 
        
        System.out.println("Enter no of snakes");
        snakes=sc.nextInt(); 
        int pos[][]=new int[snakes][2]; 
        sc.nextLine(); 
        System.out.println("Enter the positions");
        
        for(i=0;i<snakes;i++){
            System.out.println("Enter for snake"+(i+1));
            String line=sc.nextLine();
            String []vector=line.split(",");
         //   System.out.println(line); 
            pos[i][0]=Integer.parseInt(vector[0]); 
            pos[i][1]=Integer.parseInt(vector[1]); 
        }
        
        // ladders entry 
        int ladders; 
        System.out.println("Enter no of ladders");
        ladders=sc.nextInt(); 
        int posL[][]=new int[ladders][2]; 
        sc.nextLine(); 
        System.out.println("Enter the positions");
        
        for(i=0;i<ladders;i++){
            System.out.println("Enter for ladder"+(i+1));
            String line=sc.nextLine();
            String []vector=line.split(","); 
            posL[i][0]=Integer.parseInt(vector[0]); 
            posL[i][1]=Integer.parseInt(vector[1]); 
        }
        //sc.nextLine(); 
        // Players Entry over here
        int index=1; 
        System.out.println("Enter no of players");
        player=sc.nextInt(); 
        String names[]=new String[player]; 
        int position[]=new int[player]; 
        System.out.println("Enter the player names for "+player+" players");
        sc.nextLine();
        for(i=0;i<player;i++){
            System.out.println("Enter for name for"+" player"+(i+1));
            names[i]=sc.nextLine(); 
            position[i]=0; 
        }
        
        System.out.println("Game Start !!");
        boolean winner=false;
        boolean valid=false; 
        while(!winner){
            
            for(i=0;i<player;i++){
                // enter 1st player position 
                System.out.println("Enter "+names[i]+" player's dice no");
                valid=false; 
                while(!valid){
                 index=sc.nextInt(); 
                if(index>6 || index<0){
                    System.out.println("Enter valid input between 1 and 6");
                    valid=false; 
                }else{
                    valid=true; 
                }   
                }
                evaluatePos(index,position,i,pos,snakes,ladders,posL);
                if(position[i]==100){
                    System.out.println("Congratulations player "+names[i]+" wins :)");
                    System.exit(0); 
                }else{
                    // print the positions of all players
                        System.out.println("The positons : "); 

                    for(j=0;j<player;j++){
                        System.out.println(names[j]+" ->"+position[j]); 
                    }
                }
            }
            
            
        }
    }

    public static void evaluatePos(int index, int[] position,int player,int [][]pos,int snakes,int ladders,int [][]posL) {
        
            // after getting the index here
            int nextPos; 
            int prePos,i; 
            nextPos=index+position[player]; 
            if(nextPos>100){
                System.out.println("This case is not valid , try in another turn !!");
                return; 
            }
            // check if any snake lies over that path 
            for(i=0;i<ladders;i++){
                
                if(posL[i][0]==nextPos){
                    nextPos=posL[i][1]; 
                }
            }
            
            for(i=0;i<snakes;i++){
                
                if(pos[i][0]==nextPos){
                    nextPos=pos[i][1]; 
                }
            }
            // check for the ladders over the path 
            
            position[player]=nextPos; 
    }

    private static void checkSnake() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void printPos() {
        
    }
}
