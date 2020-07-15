/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;

/**
 *
 * @author Luis Puentes
 */
public class BowlingScore {
    
    public static void main(String[] args) {
        
        System.out.println("******** WELCOME ********");
        System.out.println("This is the Score Bowling Game");
        System.out.println("");
        
        HashMap<String, BowlingPlayer> mapNamePlayers = new HashMap<>();
        
        String errors = "";
        String text = Utility.readTextFile();
        String[] textLines = text.split("\n");
        //Set Player and Score in a Map
        for(String textLine : textLines){
            String textInput[] = textLine.split(" ");
            String playerName = textInput[0];
            Integer playerScore;
            if(Utility.isValidNumber(textInput[1])){
                playerScore = Integer.parseInt(textInput[1]);
            }else{
                if(errors.isEmpty()) errors = "*** Error. The following rows were added with 0 (zero) value for having a bad input format: \n";
                errors += "*** " + textLine + "\n";
                playerScore = 0;
            }
            
            if(!mapNamePlayers.containsKey(playerName)){
                mapNamePlayers.put(playerName, new BowlingPlayer(playerName));
            }

            mapNamePlayers.get(playerName).getListScore().add(playerScore);
            
        }
        
        System.out.println("Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10");
        for(BowlingPlayer bowlPlayer : mapNamePlayers.values()){
            bowlPlayer.printPoints();
            bowlPlayer.printTotals();
            
            System.out.println(bowlPlayer.getName());
            System.out.print("Pinfalls");
            for(String pinfall : bowlPlayer.getListPinfallsOutput()){
                System.out.print("\t" + pinfall);
            }
            System.out.println();
            System.out.print("Score");
            for(String scoreOutput : bowlPlayer.getListScoreOutput()){
                System.out.print("\t\t" + scoreOutput);
            }
            System.out.println();
            
        }
        
        System.out.println();
        System.out.println(errors);
        
    }
}
