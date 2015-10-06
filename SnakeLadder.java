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
public class SnakeLadder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int i,j,k,snakes=0,player=0; 
        int [] board=new int[100];
        Scanner sc=new Scanner(System.in); 
        System.out.println("Welcome to Snake and Ladder game !!"); 
        
        System.out.println("Enter no of snakes");
        snakes=sc.nextInt(); 
        int pos[][]=new int[snakes][2]; 
        
        System.out.println("Enter the positions");
        
        for(i=0;i<snakes;i++){
            System.out.println("Enter for snake"+(i+1));
            pos[i][0]=sc.nextInt(); 
            pos[i][1]=sc.nextInt(); 
        }
        
        // ladders entry 
        int ladders; 
        System.out.println("Enter no of ladders");
        ladders=sc.nextInt(); 
        int posL[][]=new int[ladders][2]; 
        
        System.out.println("Enter the positions");
        
        for(i=0;i<ladders;i++){
            System.out.println("Enter for ladder"+(i+1));
            posL[i][0]=sc.nextInt(); 
            posL[i][1]=sc.nextInt(); 
        }
        
        // Players Entry over here
        int index; 
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
        while(!winner){
            
            for(i=0;i<player;i++){
                // enter 1st player position 
                System.out.println("Enter "+i+" player's dice no");
                index=sc.nextInt(); 
                evaluatePos(index,position,i,pos,snakes,ladders,posL);
                if(position[i]==100){
                    System.out.println("Congratulations player "+player+" wins :)");
                    System.exit(0); 
                }else{
                    // print the positions of all players
                        System.out.println("The positons : "); 

                    for(i=0;i<player;i++){
                        System.out.println("Player"+i+" ->"+position[i]); 
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
            
            // check if any snake lies over that path 
            for(i=0;i<snakes;i++){
                
                if(pos[i][0]==nextPos){
                    nextPos=pos[i][1]; 
                }
            }
            // check for the ladders over the path 
            for(i=0;i<ladders;i++){
                
                if(posL[i][0]==nextPos){
                    nextPos=pos[i][1]; 
                }
            }
            position[player]=nextPos; 
    }

    private static void checkSnake() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void printPos() {
        
    }
}
