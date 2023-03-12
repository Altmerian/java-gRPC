package com.pshakhlovich.grpc;

import com.pshakhlovich.grpc.PingPongServiceGrpc.PingPongServiceBlockingStub;
import io.grpc.Channel;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class PingPongClient {

    private final PingPongServiceBlockingStub pingPongServiceBlockingStub;

    public PingPongClient(Channel channel) {
        this.pingPongServiceBlockingStub = PingPongServiceGrpc.newBlockingStub(channel);
    }

    public void sendMessage() {
        String message = "Ping";
        System.out.println("Sending message: " + message);

        PingRequest request = PingRequest.newBuilder()
                .setMessage(message)
                .setTimestamp(System.currentTimeMillis())
                .build();

        PongResponse response = pingPongServiceBlockingStub.pingPong(request);
        LocalDateTime responseTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(response.getTimestamp()),
                        TimeZone.getDefault().toZoneId());

        String responseMessageFormatted =
                String.format("Received response: '%s' at '%s'",
                        response.getMessage(),
                        responseTime);
        System.out.println(responseMessageFormatted);
    }
}
