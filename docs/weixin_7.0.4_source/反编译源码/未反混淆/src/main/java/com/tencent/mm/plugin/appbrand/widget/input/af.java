package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface af {

    public enum a {
        COMPLETE,
        CONFIRM,
        CHANGED;

        static {
            AppMethodBeat.o(77440);
        }
    }

    void a(String str, int i, a aVar);
}
