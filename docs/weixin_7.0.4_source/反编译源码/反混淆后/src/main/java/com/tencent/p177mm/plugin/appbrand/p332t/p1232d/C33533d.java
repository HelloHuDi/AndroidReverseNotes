package com.tencent.p177mm.plugin.appbrand.p332t.p1232d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.appbrand.t.d.d */
public interface C33533d {

    /* renamed from: com.tencent.mm.plugin.appbrand.t.d.d$a */
    public enum C33534a {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING;

        static {
            AppMethodBeat.m2505o(73261);
        }
    }

    ByteBuffer aOq();

    boolean aOr();

    boolean aOs();

    C33534a aOt();

    /* renamed from: e */
    void mo54014e(C33533d c33533d);
}
