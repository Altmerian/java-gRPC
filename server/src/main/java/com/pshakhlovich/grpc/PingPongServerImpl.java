package com.pshakhlovich.grpc;

import com.pshakhlovich.grpc.PingPongServiceGrpc.PingPongServiceImplBase;
import io.grpc.stub.StreamObserver;

public class PingPongServerImpl extends PingPongServiceImplBase {

    @Override
    public void pingPong(PingRequest request, StreamObserver<PongResponse> responseObserver) {
        super.pingPong(request, responseObserver);
    }
}
