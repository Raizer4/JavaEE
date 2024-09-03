package by.javaguru.http;

public class HttpServerRunner {

    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(8882,100);
        httpServer.run();
    }

}
