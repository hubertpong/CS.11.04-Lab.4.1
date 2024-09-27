public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (i+1 == s.length() && c=='('){
                return false;
            }
            else if (c=='('){
                count++;
            }
            else if (c == ')'){
                if (count <= 0){
                    return false;
                }
                count--;
            }
        }
        return true;
    }

    // 2. reverseInteger
    public static String reverseInteger(int a) {
        String intString = Integer.toString(a);
        String reversed = "";
        for(int i = intString.length() -1; i>=0; i-- ){
            reversed += intString.charAt(i);
        }
        return reversed;
    }

    // 3. encryptThis
    public static String encryptThis(String hubert) {
        String[] words = hubert.split(" ");
        StringBuilder hide = new StringBuilder();

        for(String word : words ){
            char firstChar = word.charAt(0);
            String hideWord = (int) firstChar + "";

            if (word.length()>2){
                hideWord += word.charAt(word.length()-1);
                hideWord += word.substring(2, word.length()-1);
                hideWord += word.charAt(1);
            }
            else if(word.length()==2){
                hideWord += word.charAt(1);
            }
            hide.append(hideWord).append(" ");
        }
        return hide.toString().trim();
    }

    // 4. decipherThis
    public static String decipherThis(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder numPart = new StringBuilder();
            int i = 0;

            while (i < word.length() && Character.isDigit(word.charAt(i))) {
                numPart.append(word.charAt(i));
                i++;
            }

            String rest = word.substring(i);

            String firstLetter = getLetterFromNumber(numPart.toString());
            StringBuilder sb = new StringBuilder(firstLetter);

            if (rest.length() > 1) {
                sb.append(rest.charAt(rest.length() - 1))
                        .append(rest.substring(1, rest.length() - 1))
                        .append(rest.charAt(0));
            } else {
                sb.append(rest);
            }

            result.append(sb).append(" ");
        }

        return result.toString().trim();
    }

    public static String getLetterFromNumber(String numStr) {
        int number = Integer.parseInt(numStr);
        char letter = (char) number;
        return Character.toString(letter);
    }
}