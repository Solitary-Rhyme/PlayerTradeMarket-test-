package util;

public class WebUtils {

    public static Integer toInteger(String text, Integer defaultValue){
        if(text == null || text == ""){
            return defaultValue;
        }

        Integer number = 0;
        try{
            number = Integer.parseInt(text);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return number;
    }
}
