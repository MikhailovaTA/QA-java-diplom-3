import com.codeborne.selenide.Configuration;

public class Utils {
    public static void await() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setFireFox(){
        Configuration.browser="firefox";
    }
}
