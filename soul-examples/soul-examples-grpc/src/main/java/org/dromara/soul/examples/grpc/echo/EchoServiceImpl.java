/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.soul.examples.grpc.echo;

import echo.EchoRequest;
import echo.EchoResponse;
import echo.EchoServiceGrpc;
import echo.Trace;
import io.grpc.stub.StreamObserver;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.dromara.soul.client.grpc.common.annotation.SoulGrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author zhanglei
 */
@Service
public class EchoServiceImpl extends EchoServiceGrpc.EchoServiceImplBase {

    @Override
    @SoulGrpcClient(path = "/echo")
    public void echo(EchoRequest request, StreamObserver<EchoResponse> responseObserver) {
        System.out.println("Received: " + request.getMessage());
        EchoResponse.Builder response = EchoResponse.newBuilder()
                .setMessage("ReceivedHELLO")
                .addTraces(Trace.newBuilder().setHost(getHostname()).build());
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    private String getHostname() {
        try {
            return InetAddress.getLocalHost().getHostName() + "(" + InetAddress.getLocalHost().getHostAddress() + ")";
        } catch (UnknownHostException e) {
            return "<Unknown hostname>";
        }
    }
}
