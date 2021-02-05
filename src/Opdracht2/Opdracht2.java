package Opdracht2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Opdracht2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] tests = new int[] {100, 500, 1000, 5000, 10000, 50000};

        String filePath = "Homo_sapiens.gene_info";

        LinkedList<LinkedList<Gene>> linkedLists;
        ArrayList<ArrayList<Gene>> arrayLists;
        long startTime, totalTime;

        try{
            for (int j = 0; j < tests.length; j++) {
                startTime = System.currentTimeMillis();
                linkedLists = readFileLinked(filePath, tests[j]);
                totalTime = System.currentTimeMillis() - startTime;

                System.out.println(String.format("(LinkedList) added %s items in %s milliseconds.", tests[j], totalTime));
                int getTest = random.nextInt(linkedLists.get(1).size());
                startTime = System.currentTimeMillis();
                linkedLists.get(0).get(getTest);
                totalTime = System.currentTimeMillis() - startTime;
                System.out.println(String.format("Got from %s items %s milliseconds", tests[j], totalTime));
            }
            for (int k = 0; k < tests.length; k++) {
                arrayLists = new ArrayList<>();
                for (int i = 1; i < 23; i++) {
                    arrayLists.add(new ArrayList<>());
                }

                startTime = System.currentTimeMillis();
                arrayLists = readFileArray(filePath, tests[k]);
                totalTime = System.currentTimeMillis() - startTime;
                System.out.println(String.format("(ArrayList) added %s items in %s milliseconds.", tests[k], totalTime));

                int getTest = random.nextInt(arrayLists.get(1).size());
                startTime = System.currentTimeMillis();
                arrayLists.get(0).get(getTest);
                totalTime = System.currentTimeMillis() - startTime;
                System.out.println(String.format("Got from %s items %s milliseconds", tests[k], totalTime));

            }
        } catch (IOException ioException){
            ioException.printStackTrace();
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }



    }



    public static LinkedList<LinkedList<Gene>> readFileLinked(String filepath, int maxlines) throws IOException {
        LinkedList<LinkedList<Gene>> list = new LinkedList<>();
        String line;
        String[] lineContent;
        int c = 0;

        for (int i = 1; i < 23; i++) {
            list.add(new LinkedList<>());
        }

        BufferedReader inFile = new BufferedReader(new FileReader(filepath));
        String header = inFile.readLine();
        while (c < maxlines && (line = inFile.readLine()) != null) {
            lineContent = line.strip().split("\t");
            if (lineContent[6].matches("[0-9]+")){
                list.get(Integer.parseInt(lineContent[6])-1).add(new Gene(
                        lineContent[1],
                        lineContent[2],
                        lineContent[4],
                        lineContent[6],
                        lineContent[3],
                        lineContent[8],
                        lineContent[9]
                ));
                c ++;
            }

        }
        return list;
    }

    public static ArrayList<ArrayList<Gene>> readFileArray(String filepath, int maxlines) throws IOException {
        ArrayList<ArrayList<Gene>> list = new ArrayList<>();
        String line;
        String[] lineContent;
        int c = 0;

        for (int i = 1; i < 23; i++) {
            list.add(new ArrayList<>());
        }

        BufferedReader inFile = new BufferedReader(new FileReader(filepath));
        String header = inFile.readLine();
        while (c < maxlines && (line = inFile.readLine()) != null) {
            lineContent = line.strip().split("\t");
            if (lineContent[6].matches("[0-9]+")){
                list.get(Integer.parseInt(lineContent[6])-1).add(new Gene(
                        lineContent[1],
                        lineContent[2],
                        lineContent[4],
                        lineContent[6],
                        lineContent[3],
                        lineContent[8],
                        lineContent[9]
                ));
                c ++;
            }
        }
        return list;
    }
}
