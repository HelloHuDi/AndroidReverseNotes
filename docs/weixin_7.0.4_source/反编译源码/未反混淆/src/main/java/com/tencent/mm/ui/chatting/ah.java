package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ah {

    public enum a {
        del,
        trans,
        fav;

        static {
            AppMethodBeat.o(30959);
        }
    }

    void a(a aVar);

    void b(a aVar);

    void dCI();

    boolean dCJ();
}
