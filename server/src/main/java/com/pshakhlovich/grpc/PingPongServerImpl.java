package com.pshakhlovich.grpc;

import com.pshakhlovich.grpc.PingPongServiceGrpc.PingPongServiceImplBase;
import io.grpc.stub.StreamObserver;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class PingPongServerImpl extends PingPongServiceImplBase {

    @Override
    public void pingPong(PingRequest request, StreamObserver<PongResponse> responseObserver) {
        LocalDateTime messageTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(request.getTimestamp()),
                        TimeZone.getDefault().toZoneId());

        System.out.println("Received message: " + request.getMessage() + " at " + messageTime);
        var response = PongResponse.newBuilder()
                .setMessage("Pong")
                .setTimestamp(System.currentTimeMillis())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
