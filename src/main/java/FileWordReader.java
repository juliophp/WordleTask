import org.wordle.core.IWordReader;

public class FileWordReader implements IWordReader {
    public FileWordReader(String fileName) {
    }

    @Override
    public String[] readWords() {
        return new String[0];
    }

    @Override
    public String getRandomWord() {
        return "";
    }
}
