package com.mycompany.clickcounter;

import java.io.*;

public class HighScore {

    private static final String FILENAME = "highScore.txt";

    static {
        // Program kapatıldığında shutdown hook'un çalışmasını sağlar
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            deleteHighScoreFile();
            int highScore = getHighScore();
            saveHighScore(highScore);
        }));
    }

    public static int getHighScore() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            int highScore = Integer.parseInt(reader.readLine());
            reader.close();
            return highScore;
        } catch (IOException e) {
            return 0;
        }
    }

    public static void saveHighScore(int highScore) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
            writer.write(String.valueOf(highScore));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteHighScoreFile() {
        File file = new File(FILENAME);
        if (file.exists()) {
            file.delete();
        }
    }
}
