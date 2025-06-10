import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.wordle.core.IWordReader;

import java.io.IOException;

public class FileWordReaderTest {

    @Test
    public void test_canReadWordsFromFile() throws IOException {
        String[] wordsInFile = {"water", "otter",
                "hound","pizza","eagle","fruit","paper"};

        IWordReader wordReader = new FileWordReader("words.txt");
        String[] wordsReadFromFile = wordReader.readWords();
        Assertions.assertEquals(wordsInFile.length, wordsReadFromFile.length);

        String randomWord = wordReader.getRandomWord();
        Assertions.assertNotNull(randomWord);

    }
}
