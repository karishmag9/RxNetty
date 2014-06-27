/*
 * Copyright 2014 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.reactivex.netty.servo.udp;

import io.reactivex.netty.protocol.udp.server.UdpServerMetricsEvent;
import io.reactivex.netty.server.ServerMetricsEvent;
import io.reactivex.netty.servo.tcp.TcpServerListener;

import java.util.concurrent.TimeUnit;

/**
 * @author Nitesh Kant
 */
public class UdpServerListener extends TcpServerListener<UdpServerMetricsEvent<?>> {

    protected UdpServerListener(String monitorId) {
        super(monitorId);
    }

    @Override
    public void onEvent(UdpServerMetricsEvent<?> event, long duration, TimeUnit timeUnit, Throwable throwable,
                        Object value) {
        if (event.getType() instanceof ServerMetricsEvent.EventType) {
            super.onEvent(event, duration, timeUnit, throwable, value);
        }
    }

    public static UdpServerListener newUdpListener(String monitorId) {
        return new UdpServerListener(monitorId);
    }
}