import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.wordle.core.*;
import org.wordle.core.impl.FileWordReader;

import java.io.IOException;
import java.util.regex.Pattern;

public class FileWordReaderTest {
    private IWordReader wordReader = null;
    private String[] wordsReadFromFile = null;
    private final Pattern allowedPattern = Pattern.compile("\\b[a-zA-Z]{5}\\b");


    @Test
    public void test_canReadWordsFromFile()  {
        String[] wordsInFile = {"water", "otter",
                "hound","pizza","eagle","fruit","paper"};
        wordReader = new FileWordReader("words.txt", allowedPattern);
        wordsReadFromFile = wordReader.readWords();
        Assertions.assertEquals(wordsInFile.length, wordsReadFromFile.length);
        String randomWord = wordReader.getRandomWord();
        Assertions.assertNotNull(randomWord);

    }

    @Test
    public void test_canOnlyReadValidWords(){
        String[] validWordsInFile = {"otter","hound","paper"};
        wordReader = new FileWordReader("filewithinvalidwords.txt", allowedPattern);
        wordsReadFromFile = wordReader.readWords();
        Assertions.assertEquals(validWordsInFile.length, wordsReadFromFile.length);
        Assertions.assertEquals(validWordsInFile[0], wordsReadFromFile[0]);
        Assertions.assertEquals(validWordsInFile[1], wordsReadFromFile[1]);
        Assertions.assertEquals(validWordsInFile[2], wordsReadFromFile[2]);




    }
}
