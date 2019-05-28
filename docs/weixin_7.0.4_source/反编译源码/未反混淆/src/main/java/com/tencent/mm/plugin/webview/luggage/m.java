package com.tencent.mm.plugin.webview.luggage;

import android.os.Looper;
import com.tencent.luggage.d.k;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.plugin.webview.luggage.permission.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;

public final class m {
    private static HashMap<String, Integer> ujr = new HashMap();

    static {
        AppMethodBeat.i(6218);
        AppMethodBeat.o(6218);
    }

    public static int a(k kVar, LuggageGetA8Key luggageGetA8Key) {
        AppMethodBeat.i(6216);
        int intValue = com.tencent.luggage.d.m.a(ah.getContext(), kVar).intValue();
        b.a(kVar.hashCode(), luggageGetA8Key);
        AppMethodBeat.o(6216);
        return intValue;
    }

    public static void remove(int i) {
        AppMethodBeat.i(6217);
        final k b = com.tencent.luggage.d.m.b(Integer.valueOf(i));
        if (b != null) {
            b.IG(b.hashCode());
            if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                try {
                    b.destroy();
                    AppMethodBeat.o(6217);
                    return;
                } catch (Exception e) {
                    d.printErrStackTrace("MicroMsg.LuggageWebCoreStash", e, "", new Object[0]);
                    AppMethodBeat.o(6217);
                    return;
                }
            }
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6215);
                    try {
                        b.destroy();
                        AppMethodBeat.o(6215);
                    } catch (Exception e) {
                        d.printErrStackTrace("MicroMsg.LuggageWebCoreStash", e, "", new Object[0]);
                        AppMethodBeat.o(6215);
                    }
                }
            });
        }
        AppMethodBeat.o(6217);
    }
}
