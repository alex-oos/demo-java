package cc.blog.alex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author Alex
 * @since 2024/4/17 下午3:40
 * <p></p>
 */
public class sada {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        clientDemo();
    }

    public static void clientDemo() throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        String accessKey = "CAKBVTIMXGV6Q1TGAJE";
        String secretKey = "hCwhmyKFrDYs9xr1lFjfbqXlUU1WRHPTC4qpUUmH";

        // Replace this URL with the corresponding URL of the Matrix interface
        String url = "http://production-matrix.api.xiaomi.net/api/v1/tools/search-ip?ip=10.106.203.189";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");

        String authHeader = generateAuthorizationHeader(accessKey, secretKey, connection);
        connection.setRequestProperty("Authorization", authHeader);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("HTTP request failed: " + responseCode);
        }
    }

    public static String generateAuthorizationHeader(String accessKey, String secretKey, HttpURLConnection connection)
            throws NoSuchAlgorithmException, InvalidKeyException {

        String verb = connection.getRequestMethod();
        String contentType = connection.getRequestProperty("Content-Type");
        String contentMd5 = ""; // For GET requests, Content-MD5 header is usually empty
        String date = ""; // Date header is not used in this example

        String stringToSign = verb + "\n" + contentMd5 + "\n" + contentType + "\n" + date + "\n"
                + connection.getURL().getPath();
        String signature = calculateHmac256(secretKey, stringToSign);

        return "MI-HMAC-SHA256 AccessKey=" + accessKey + ", Signature=" + signature;
    }

    public static String calculateHmac256(String secretKey, String data) throws NoSuchAlgorithmException, InvalidKeyException {

        String algorithm = "HmacSHA256";
        Mac mac = Mac.getInstance(algorithm);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), algorithm);
        mac.init(secretKeySpec);
        byte[] hashBytes = mac.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

}
