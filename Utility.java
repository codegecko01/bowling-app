
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
public class Utility {
    private static final String TXT_FILE_NAME = "TableScore.txt";
    private static final String NUMBER_REGEX = "^(?:[0-9]|0[0-9]|10)$";
    
    public static String readTextFile() {
        File textFile = new File(TXT_FILE_NAME);
        FileReader fr = null;
        BufferedReader bfr = null;
        StringBuffer buffer = new StringBuffer();
        
        try{
            fr = new FileReader(textFile);
            bfr = new BufferedReader(fr);    
            
            String linea;
            while((linea = bfr.readLine()) != null){
                buffer.append(linea).append("\n");
            }
            fr.close();
            bfr.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(fr != null) fr.close();
                if(bfr != null) bfr.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        return buffer.toString();
    }
    
    public static boolean isValidNumber(String number){
        return Pattern.matches(NUMBER_REGEX, number);
    }
}
