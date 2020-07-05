package meteo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebInterfaceConnection {
    private URL url;
    private HttpURLConnection con;
    public WebInterfaceConnection() throws IOException {
        url = new URL("http://192.168.1.1");
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4=");
        System.out.println(con.getHeaderFields());
    }
    private String Get(){
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();

        } catch (Exception e) {
            return "Нет данных";
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new WebInterfaceConnection().Get());
    }
}
