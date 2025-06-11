import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.wordle.config.AppConfig;

public class ConfigTest {

    private static AppConfig configInstance;

    public ConfigTest() {
        configInstance = AppConfig.getInstance();
    }

    @Test
    public void test_canReadConfigFromFile() {
        Assertions.assertEquals(5, configInstance.getNumberOfGuessesAllowedInGame());
        Assertions.assertEquals(5, configInstance.getNumberOfLettersAllowedInGuessWord());
        Assertions.assertEquals("src/words.txt", configInstance.getFilePathToReadWords());
    }
}
