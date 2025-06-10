package org.wordle.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

public class FileWordReader implements IWordReader {
    private final String[] wordList;
    private  final Random random = new Random();

    public FileWordReader(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        Function<String, Stream<String>> linesToWordStreamMapper =
                line -> Arrays.stream(line.split(","));
        wordList = lines.stream().flatMap(linesToWordStreamMapper).toArray(String[]::new);
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
