package com.pshakhlovich.grpc;

import io.grpc.ManagedChannelBuilder;

public class ClientMain {
    public static void main(String[] args) {
        var managedChannel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        var pingPongClient = new PingPongClient(managedChannel);

        for (int i = 0; i < 10; i++) {
            pingPongClient.sendMessage();
        }
    }
}