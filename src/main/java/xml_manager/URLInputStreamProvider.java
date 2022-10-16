package xml_manager;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.lang.System.exit;

public class URLInputStreamProvider {
    public static InputStream provide(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            InputStream is = http.getInputStream();

            return is;
        }
        catch (Exception e) {
            e.printStackTrace();
            exit(-5);
        }
        return null;
    }
}
