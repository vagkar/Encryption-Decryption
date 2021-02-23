package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String algo = "shift";
        String targetOperation = "enc";
        String msg = "";
        int key = 0;

        FileWriter fileWriter = null;

        for (int i = 0; i < args.length; i++) {

            switch (args[i]) {
                case "-mode":
                    targetOperation = args[i + 1];
                    break;

                case "-data":
                    msg = args[i + 1];
                    msg = msg.replace("\"", "");
                    break;

                case "-in":
                    if (msg.equals("")) {
                        try {
                            Scanner scanner = new Scanner(new File(args[i + 1]));
                            while (scanner.hasNextLine()){
                                msg += scanner.nextLine();
                            }
                            scanner.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                case "-out":
                    try {
                        fileWriter = new FileWriter(new File(args[i + 1]));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;

                case "-alg":
                    algo = args[i + 1];
                    break;
            }
        }

        if ("shift".equals(algo)) {
            Shift algorithm = new Shift();
            if (targetOperation.equals("enc")) {
                if (fileWriter != null) {
                    try {
                        fileWriter.write(algorithm.encryption(msg, key));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.print(algorithm.encryption(msg, key));
                }
            } else if (targetOperation.equals("dec")) {
                if (fileWriter != null) {
                    try {
                        fileWriter.write(algorithm.decryption(msg, key));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.print(algorithm.decryption(msg, key));
                }
            }
        } else {
            Unicode algorithm = new Unicode();
            if (targetOperation.equals("enc")) {
                if (fileWriter != null) {
                    try {
                        fileWriter.write(algorithm.encryption(msg, key));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.print(algorithm.encryption(msg, key));
                }
            } else if (targetOperation.equals("dec")) {
                if (fileWriter != null) {
                    try {
                        fileWriter.write(algorithm.decryption(msg, key));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.print(algorithm.decryption(msg, key));
                }
            }
        }

        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
