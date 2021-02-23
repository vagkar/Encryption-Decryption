package encryptdecrypt;

public class Shift implements Algo{
    @Override
    public String encryption(String msg, int key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String encMsg = "";
        for (int i = 0; i < msg.length(); i++) {
            boolean lowerAlphabet = msg.charAt(i) >= 'a' && msg.charAt(i) <= 'z';
            boolean upperAlphabet = msg.charAt(i) >= 'A' && msg.charAt(i) <= 'Z';
            if (lowerAlphabet || upperAlphabet) {
                if (upperAlphabet) {
                    encMsg += Character.toString(alphabet.charAt((alphabet.indexOf(msg.charAt(i) + 32) + key) % alphabet.length())).toUpperCase();
                } else {
                    encMsg += Character.toString(alphabet.charAt((alphabet.indexOf(msg.charAt(i)) + key) % alphabet.length()));
                }

            } else {
                encMsg += Character.toString(msg.charAt(i));
            }
        }
        return encMsg;
    }

    @Override
    public  String decryption(String msg, int key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String decMsg = "";
        for (int i = 0; i < msg.length(); i++) {
            boolean lowerAlphabet = msg.charAt(i) >= 'a' && msg.charAt(i) <= 'z';
            boolean upperAlphabet = msg.charAt(i) >= 'A' && msg.charAt(i) <= 'Z';
            if (lowerAlphabet || upperAlphabet) {
                if (upperAlphabet) {
                    int index = (alphabet.indexOf(msg.charAt(i) + 32) - key) % alphabet.length();
                    if (index < 0) {
                        index += alphabet.length();
                    }
                    decMsg += Character.toString(alphabet.charAt(index)).toUpperCase();
                } else {
                    int index = (alphabet.indexOf(msg.charAt(i)) - key) % alphabet.length();
                    if (index < 0) {
                        index += alphabet.length();
                    }
                    decMsg += Character.toString(alphabet.charAt(index));
                }

            } else {
                decMsg += Character.toString(msg.charAt(i));
            }
        }
        return decMsg;
    }
}
