package org.wordle.core.impl;

import org.wordle.core.IWordReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileWordReader implements IWordReader {
    private String[] wordList;
    private  final Random random = new Random();
    Logger LOGGER = Logger.getLogger(FileWordReader.class.getName());

    public FileWordReader(String fileName, Pattern wordValidationPattern) {
        try(InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)){
            if (input == null) { throw new IOException("Sorry, unable to find file " + fileName);}
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            Function<String, Stream<String>> linesToWordStreamMapper = line -> Arrays.stream(line.split(","));
            wordList = reader.lines().flatMap(linesToWordStreamMapper)
                    .map(String::trim)
                    .filter(word -> wordValidationPattern.matcher(word).matches())
                    .toArray(String[]::new);

        }catch (Exception e){
            LOGGER.severe("Error: " + e.getMessage());
        }
    }

    @Override
    public String[] readWords() {
        return wordList;
    }

    @Override
    public String getRandomWord() {
        int randomIndex = random.nextInt(wordList.length);
        return wordList[randomIndex];
    }
}
