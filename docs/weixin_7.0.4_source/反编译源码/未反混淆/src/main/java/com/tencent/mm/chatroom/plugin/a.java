package com.tencent.mm.chatroom.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.b;
import com.tencent.mm.model.q;

public final class a extends q {
    private static a ehI;

    public a() {
        super(b.class);
    }

    public static synchronized a JA() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(103960);
            if (ehI == null) {
                ehI = new a();
            }
            aVar = ehI;
            AppMethodBeat.o(103960);
        }
        return aVar;
    }
}
