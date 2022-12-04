import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        readFile();
    }

    // Faz a leitura do arquivo que contém as palavras
    private static void readFile() {
        String path = "/Users/arleysantana/Desktop/words.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader((path)))) {
            String line = bufferedReader.readLine();

            ArrayList<String> wordList = new ArrayList<>();

            while (line != null) {
                wordList.add(line);
                line = bufferedReader.readLine();
            }

            // Escreve no arquivo de saida
            writeFile(wordList);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Escreve no arquivo de saida
    public static void writeFile(ArrayList<String> wordList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/arleysantana/Desktop/words2.txt", true))) {
            for (int j = 0; j < wordList.size(); j++) {
                bw.write("INSERT INTO word_table (id, word) VALUES (" + (j+1) + "," + "\"" + wordList.get(j) + "\"" + ");");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}