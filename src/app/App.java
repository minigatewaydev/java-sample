package app;

import com.google.gson.Gson;

import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.net.URLEncoder;

import core.RestApiSender;
import models.*;

public class App {

    private static final String baseUrl = "http://162.253.16.28:5010/api/send";
    private static RestApiSender api;

    public static void main(String[] args) throws Exception {
        api = new RestApiSender();

        System.out.println("===============================");
        System.out.println("    Java MiniGateway Sample");
        System.out.println("===============================");

        /*
         * TODO: change according to your own data for username & password. If you set
         * 'dlrMask' to 1, please specify the 'dlrUrl'
         */
        MtRequest request = new MtRequest();
        request.username = "YOUR_USERNAME";
        request.password = "YOUR_PASSWORD";
        request.from = "Java Sample";
        request.to = "60123456789";
        request.text = "Java sample using HTTP GET & POST";
        request.coding = "1";
        request.dlrMask = "0";
        request.dlrUrl = "YOUR_DLR_URL";
        request.responseType = "json";

        /*
         * TODO: Change this between 1 - 2 to switch result 1 = Send using POST 2 = Send
         * using GET
         */
        var type = 1;

        switch (type) {
        case 1:
            sendSmsUsingPost(request);
            break;
        case 2:
            sendSmsUsingGet(request);
            break;
        }
    }

    private static void sendSmsUsingPost(MtRequest request) throws IOException {

        System.out.println("Executing POST request..");

        StopWatch sw = StopWatch.createStarted();

        var jsonReqString = new Gson().toJson(request, MtRequest.class);
        var response = api.sendPostRequest(baseUrl, jsonReqString);
        sw.stop();

        if ("json".equals(request.responseType.toLowerCase())) {

            // For future usage
            var obj = new Gson().fromJson(response.responseContentString, MtResponse.class);
        }

        System.out.println("Finished. Time taken: " + sw.getTime());
        System.out.println(
                "Response = StatusCode: " + response.statusCode + ", Content: " + response.responseContentString);
    }

    private static void sendSmsUsingGet(MtRequest request) throws IOException {

        System.out.println("Executing GET request..");
        StopWatch sw = StopWatch.createStarted();

        var url = baseUrl + "?" + MtRequest.GW_USERNAME + "=" + request.username + "&" + MtRequest.GW_PASSWORD + "="
                + request.password + "&" + MtRequest.GW_FROM + "=" + URLEncoder.encode(request.from, "UTF-8") + "&"
                + MtRequest.GW_TO + "=" + URLEncoder.encode(request.to, "UTF-8") + "&" + MtRequest.GW_TEXT + "="
                + URLEncoder.encode(request.text, "UTF-8") + "&" + MtRequest.GW_CODING + "=" + request.coding + "&"
                + MtRequest.GW_DLR_MASK + "=" + request.dlrMask + "&" + MtRequest.GW_DLR_URL + "=" + request.dlrUrl
                + "&" + MtRequest.GW_RESP_TYPE + "=" + request.responseType;

        var response = api.sendGetRequest(url);
        sw.stop();

        if ("json".equals(request.responseType.toLowerCase())) {

            // For future usage
            var obj = new Gson().fromJson(response.responseContentString, MtResponse.class);
        }

        System.out.println("Finished. Time taken: " + sw.getTime());
        System.out.println(
                "Response = StatusCode: " + response.statusCode + ", Content: " + response.responseContentString);
    }
}