package com.tencent.p177mm.plugin.webview.luggage.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.webview.luggage.permission.b */
public final class C40250b {
    private static ConcurrentHashMap<Integer, LuggageGetA8Key> ult = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(6489);
        AppMethodBeat.m2505o(6489);
    }

    /* renamed from: a */
    public static void m69031a(int i, LuggageGetA8Key luggageGetA8Key) {
        AppMethodBeat.m2504i(6487);
        ult.put(Integer.valueOf(i), luggageGetA8Key);
        AppMethodBeat.m2505o(6487);
    }

    /* renamed from: IG */
    public static LuggageGetA8Key m69030IG(int i) {
        AppMethodBeat.m2504i(6488);
        LuggageGetA8Key luggageGetA8Key = (LuggageGetA8Key) ult.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(6488);
        return luggageGetA8Key;
    }
}
