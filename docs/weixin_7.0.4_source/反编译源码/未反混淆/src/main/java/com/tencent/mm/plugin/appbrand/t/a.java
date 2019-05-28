package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.d.d;

public interface a {

    public enum b {
        CLIENT,
        SERVER;

        static {
            AppMethodBeat.o(73206);
        }
    }

    public enum a {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED;

        static {
            AppMethodBeat.o(73203);
        }
    }

    void b(d dVar);
}
