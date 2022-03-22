package com.assignment.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by sabbir on 3/16/22.
 */
public class SolutionServiceImpl implements SolutionServiceIF {

    private static final Integer LOW_LINE_LIMIT = 1;
    private static final Integer MAX_LINE_LIMIT = 229;

    private static final Integer LEFT_CHAR_LIMIT = 97; // letter 'a'
    private static final Integer RIGHT_CHAR_LIMIT = 122; // letter 'z'
    private static final Integer TARGET_LINE_LENGTH = 100;

    public String generateFile(Integer lineLimit) {
        if (lineLimit < LOW_LINE_LIMIT || lineLimit > MAX_LINE_LIMIT) {
            return "Invalid Input";
        }

        StringBuilder lineBuilder = new StringBuilder();
        for(int i = 0; i < lineLimit; i++) {
            lineBuilder.append(generateRandomCharacters()).append("\n");
        }
        return createFileWithRecord(lineBuilder.toString());
    }

    private String generateRandomCharacters() {
        Random random = new Random();
        return random.ints(LEFT_CHAR_LIMIT, RIGHT_CHAR_LIMIT + 1)
                .limit(TARGET_LINE_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private String createFileWithRecord(String fileContent) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("new_file.txt"));
            writer.write(fileContent);
            writer.close();
            return "Success";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed";
        }
    }
}
