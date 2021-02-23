package encryptdecrypt;

public class Unicode implements Algo{
    @Override
    public String encryption(String msg, int key) {
        String encMsg = "";
        for (int i = 0; i < msg.length(); i++) {
            encMsg += Character.toString(msg.charAt(i) + key);
        }
        return encMsg;
    }

    @Override
    public  String decryption(String msg, int key) {
        String decMsg = "";
        for (int i = 0; i < msg.length(); i++) {
            decMsg += Character.toString(msg.charAt(i) - key);
        }
        return decMsg;
    }
}
