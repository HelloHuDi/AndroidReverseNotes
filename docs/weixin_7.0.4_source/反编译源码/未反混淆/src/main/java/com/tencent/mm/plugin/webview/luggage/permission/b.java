package com.tencent.mm.plugin.webview.luggage.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static ConcurrentHashMap<Integer, LuggageGetA8Key> ult = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(6489);
        AppMethodBeat.o(6489);
    }

    public static void a(int i, LuggageGetA8Key luggageGetA8Key) {
        AppMethodBeat.i(6487);
        ult.put(Integer.valueOf(i), luggageGetA8Key);
        AppMethodBeat.o(6487);
    }

    public static LuggageGetA8Key IG(int i) {
        AppMethodBeat.i(6488);
        LuggageGetA8Key luggageGetA8Key = (LuggageGetA8Key) ult.remove(Integer.valueOf(i));
        AppMethodBeat.o(6488);
        return luggageGetA8Key;
    }
}
