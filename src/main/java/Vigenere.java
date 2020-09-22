import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        String newmsg = "";
        int len = message.length();
        int p = 0;

        while (p < len) {
            for (int k = 0; k < key.length();) {
                char key_ch = key.charAt(k);
                int keynum = key_ch;

                for (int i = 0; i < len; i++) {
                    char ch = message.charAt(i);

                    if (i < 65 || (i > 90 && i < 97) || i > 122) {
                        newmsg += ch;
                        p++;
                    } else {
                        while (keynum >= 26) {
                            keynum -= 26;
                        }
                        if (ch >= 65 && ch <= (90-keynum)) {
                            ch += keynum;
                            newmsg += ch;
                            k++;
                            p++;
                        } else if (ch >= (90-keynum+1) && ch <= 90) {
                            ch -= (26-keynum);
                            newmsg += ch;
                            k++;
                            p++;
                        } else if (ch >= 97 && ch <= (122-keynum)) {
                            ch += keynum;
                            newmsg += ch;
                            k++;
                            p++;
                        } else if (ch >= (122-keynum+1) && ch <= 122) {
                            ch -= (26-keynum);
                            newmsg += ch;
                            k++;
                            p++;
                        }
                    }
                }
            }
        }

        
        return newmsg;
    }

    public static String decryptVigenere(String message, String key) {
        String newmsg = "";
        int len = message.length();
        int p = 0;

        while (p < len) {
            for (int k = 0; k < key.length();) {
                char key_ch = key.charAt(k);
                int keynum = key_ch;

                for (int i = 0; i < len; i++) {
                    char ch = message.charAt(i);

                    if (i < 65 || (i > 90 && i < 97) || i > 122) {
                        newmsg += ch;
                        p++;
                    } else {
                        while (keynum >= 26) {
                            keynum -= 26;
                        }
                        if (ch >= (65+keynum) && ch <= 90) {
                            ch -= keynum;
                            newmsg += ch;
                            k++;
                            p++;
                        } else if (ch >= 65 && ch <= (65+keynum-1)) {
                            ch += (26-keynum);
                            newmsg += ch;
                            k++;
                            p++;
                        } else if (ch >= (97+keynum) && ch <= 122) {
                            ch -= keynum;
                            newmsg += ch;
                            k++;
                            p++;
                        } else if (ch >= 97 && ch <= (97+keynum-1)) {
                            ch += (26-keynum);
                            newmsg += ch;
                            k++;
                            p++;
                        }
                    }
                }
            }
        }

        
        return newmsg;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
