package com.pshakhlovich.grpc;

import io.grpc.ServerBuilder;

import java.io.IOException;

public class PingPongServer {

    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException, InterruptedException {
        var server = ServerBuilder.forPort(SERVER_PORT)
                .addService(new PingPongServerImpl())
                .build()
                .start();
        System.out.println("PingPong server has started on port " + SERVER_PORT);
        server.awaitTermination();
    }
}