package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a {

    public enum a {
        OK,
        FAIL,
        WAIT_FOR_WIFI,
        CANCEL;

        static {
            AppMethodBeat.o(35545);
        }
    }

    public interface b {
        void a(a aVar, long j);
    }

    public interface c {
        void biB();
    }
}
