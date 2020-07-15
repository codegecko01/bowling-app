
import java.util.ArrayList;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Puentes
 */
public class BowlingPlayer implements Player{
    private String name;
    private ArrayList<Integer> listScore = new ArrayList<>();
    private ArrayList<String> listPinfallsOutput = new ArrayList<>();
    private ArrayList<String> listScoreOutput = new ArrayList<>();
    //private final Pattern numberPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    private final Pattern numberPattern = Pattern.compile("^(?:[0-9]|0[0-9]|10)$");

    public BowlingPlayer(String name){
        this.setName(name);
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the listScore
     */
    public ArrayList<Integer> getListScore() {
        return listScore;
    }

    /**
     * @param listScore the listScore to set
     */
    public void setListScore(ArrayList<Integer> listScore) {
        this.listScore = listScore;
    }

    /**
     * @return the listScoreOutput
     */
    public ArrayList<String> getListScoreOutput() {
        return listScoreOutput;
    }

    /**
     * @param listScoreOutput the listScoreOutput to set
     */
    public void setListScoreOutput(ArrayList<String> listScoreOutput) {
        this.listScoreOutput = listScoreOutput;
    }

    /**
     * @return the listPinfallsOutput
     */
    public ArrayList<String> getListPinfallsOutput() {
        return listPinfallsOutput;
    }

    /**
     * @param listPinfallsOutput the listPinfalls to set
     */
    public void setListPinfalls(ArrayList<String> listPinfallsOutput) {
        this.listPinfallsOutput = listPinfallsOutput;
    }
    
    @Override
    public void printPoints(){
        this.getListScore().trimToSize();
        for(int i = 0; i < this.getListScore().size(); i++){
            Integer score = this.getListScore().get(i);
            if(score == 10){
                if(i < this.getListScore().size() - 3) this.getListPinfallsOutput().add("");
                this.getListPinfallsOutput().add("X");
            }else{
                this.getListPinfallsOutput().add(score.toString());
                i++;
                if(i < this.getListScore().size()){
                    Integer nextScore = this.getListScore().get(i);
                    if(score + nextScore == 10){
                        this.getListPinfallsOutput().add("/");
                    }else{
                        this.getListPinfallsOutput().add(nextScore.toString());
                    }
                }
            }
        }
        
        this.getListPinfallsOutput().trimToSize();
    }
    
    
    @Override
    public void printTotals(){
        Integer total = 0;
        Integer totalFrame = 0;
        
        for(int i = 0; i < this.getListScore().size(); i++){
            Integer score = this.getListScore().get(i);
            
            if(i >= this.getListScore().size() - 3){
                totalFrame += score;
                score = this.getListScore().get(i + 1);
                totalFrame += score;

                score = this.getListScore().get(i + 2);
                totalFrame += score;

                total += totalFrame;
                this.getListScoreOutput().add(total.toString());
                totalFrame = 0;
                break;
            }else{
                if(score < 10){
                    totalFrame += score;

                    i++;

                    score = this.getListScore().get(i);
                    totalFrame += score;

                    if(totalFrame == 10){
                        score = this.getListScore().get(i + 1);
                        totalFrame += score;
                    }

                    total += totalFrame;
                    this.getListScoreOutput().add(total.toString());
                    totalFrame = 0;

                }else if(score == 10){
                    totalFrame += score;

                    score = this.getListScore().get(i + 1);
                    totalFrame += score;

                    score = this.getListScore().get(i + 2);
                    totalFrame += score;

                    total += totalFrame;
                    this.getListScoreOutput().add(total.toString());
                    totalFrame = 0;
                }
            }
        }
        
        
        this.getListScoreOutput().trimToSize();
    }
    
}
