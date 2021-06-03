import org.junit.jupiter.api.Test;

public class Helpers {

    @Test
    public String cutString(String result) {
        int startIndex = 15;
        int stopIndex = result.length();
        StringBuilder croppedString = new StringBuilder(result);
        croppedString.delete(startIndex, stopIndex);
        return result = croppedString.toString();
    }
}
