package lessons28;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        String alphabetString = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
        char[] alphabetChar = alphabetString.toCharArray();
        int alphabetCharLength = alphabetChar.length;
        String alphabetStringRevers = "";
        for (int i = alphabetChar.length - 1; i >= 0; i--) {
            alphabetStringRevers = alphabetStringRevers + alphabetChar[i];
        }

        System.out.println(alphabetCharLength);
        int key = 1;
        HashMap<Character, Character> mapAlphabet = new HashMap<Character, Character>();
        for (int i = 0; i < alphabetChar.length; i++) {
            char a = alphabetChar[i];
            char b = alphabetChar[(i + key) % alphabetCharLength];
            mapAlphabet.put(a, b);
        }
        String inTxt = "C:\\Users\\shdin\\Desktop\\Курс javaRush\\JavaRushTasks\\1.JavaSyntax\\src\\lessons28\\in.txt";
        String outTxt = "C:\\Users\\shdin\\Desktop\\Курс javaRush\\JavaRushTasks\\1.JavaSyntax\\src\\lessons28\\out.txt";

        try (Scanner console = new Scanner(System.in);
             FileReader in = new FileReader(inTxt);
             FileWriter out = new FileWriter(outTxt);
             BufferedReader reader = new BufferedReader(in);
             BufferedWriter writer = new BufferedWriter(out)) {
            while (reader.ready()) {
                char ch = (char) reader.read();
                writer.append(mapAlphabet.getOrDefault(ch, ch));
//                if (mapAlphabet.containsKey(ch)) {
//                    writer.append(mapAlphabet.get(ch));
//                }else{
//                    writer.append(ch);
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

