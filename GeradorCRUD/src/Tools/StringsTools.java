package Tools;

/**
 *
 * @author JoaoAN
 */
public class StringsTools {

    public String capitalize(String x) {
        String res = "";
        for (int i = 0; i < x.length(); i++) {
            if (i == 0) {
                res = res + x.toUpperCase().charAt(i);
            } else{
                res = res + x.toLowerCase().charAt(i);
            }
        }
        return res;
    }
    
    public String firstLetterToLowerCase(String x) {
        String res = "";
        for (int i = 0; i < x.length(); i++) {
            if (i == 0) {
                res = res + x.toLowerCase().charAt(i);
            } else{
                res = res + x.charAt(i);
            }
        }
        return res;
    }
}
