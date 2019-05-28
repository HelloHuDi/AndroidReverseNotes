package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import android.support.annotation.Keep;

public class WssConfig {
    @Keep
    int bz_type;
    @Keep
    int handshake_timeout;
    @Keep
    int pong_timeout;
    @Keep
    boolean skip_domain_check;
    @Keep
    boolean tcp_no_delay;

    public WssConfig() {
        this.pong_timeout = -1;
        this.handshake_timeout = -1;
        this.tcp_no_delay = false;
        this.skip_domain_check = false;
        this.bz_type = 0;
    }

    public WssConfig(int i, int i2, boolean z, boolean z2, int i3) {
        this.pong_timeout = i;
        this.handshake_timeout = i2;
        this.tcp_no_delay = z;
        this.skip_domain_check = z2;
        this.bz_type = i3;
    }
}
