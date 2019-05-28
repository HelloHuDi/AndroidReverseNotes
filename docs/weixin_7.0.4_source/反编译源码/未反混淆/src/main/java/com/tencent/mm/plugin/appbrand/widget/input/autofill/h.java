package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;

interface h {

    public enum a {
        CANCEL,
        DELETE,
        SELECT;

        static {
            AppMethodBeat.o(123934);
        }
    }

    void a(String str, a aVar);
}
