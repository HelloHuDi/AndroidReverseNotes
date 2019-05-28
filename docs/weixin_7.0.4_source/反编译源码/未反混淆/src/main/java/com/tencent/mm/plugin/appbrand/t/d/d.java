package com.tencent.mm.plugin.appbrand.t.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public interface d {

    public enum a {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING;

        static {
            AppMethodBeat.o(73261);
        }
    }

    ByteBuffer aOq();

    boolean aOr();

    boolean aOs();

    a aOt();

    void e(d dVar);
}
