package encryptdecrypt;

public interface Algo {
    public String encryption(String msg, int key);

    public String decryption(String msg, int key);
}
