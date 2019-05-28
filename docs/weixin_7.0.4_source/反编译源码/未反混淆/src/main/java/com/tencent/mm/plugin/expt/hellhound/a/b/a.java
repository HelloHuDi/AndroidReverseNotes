package com.tencent.mm.plugin.expt.hellhound.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static a lMU;
    private List<Object> mq;

    public static a bqG() {
        AppMethodBeat.i(73460);
        if (lMU == null) {
            synchronized (a.class) {
                try {
                    if (lMU == null) {
                        lMU = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(73460);
                    }
                }
            }
        }
        a aVar = lMU;
        AppMethodBeat.o(73460);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(73461);
        if (b.bqo()) {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.v("mmkv_key_session_page", new byte[0]);
        }
        this.mq = new ArrayList();
        AppMethodBeat.o(73461);
    }
}
