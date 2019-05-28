package com.tencent.p177mm.plugin.webview.luggage;

import android.os.Looper;
import com.tencent.luggage.p146d.C17820m;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.permission.C40250b;
import com.tencent.p177mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.luggage.m */
public final class C22868m {
    private static HashMap<String, Integer> ujr = new HashMap();

    static {
        AppMethodBeat.m2504i(6218);
        AppMethodBeat.m2505o(6218);
    }

    /* renamed from: a */
    public static int m34710a(C32186k c32186k, LuggageGetA8Key luggageGetA8Key) {
        AppMethodBeat.m2504i(6216);
        int intValue = C17820m.m27870a(C4996ah.getContext(), c32186k).intValue();
        C40250b.m69031a(c32186k.hashCode(), luggageGetA8Key);
        AppMethodBeat.m2505o(6216);
        return intValue;
    }

    public static void remove(int i) {
        AppMethodBeat.m2504i(6217);
        final C32186k b = C17820m.m27872b(Integer.valueOf(i));
        if (b != null) {
            C40250b.m69030IG(b.hashCode());
            if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                try {
                    b.destroy();
                    AppMethodBeat.m2505o(6217);
                    return;
                } catch (Exception e) {
                    C45124d.printErrStackTrace("MicroMsg.LuggageWebCoreStash", e, "", new Object[0]);
                    AppMethodBeat.m2505o(6217);
                    return;
                }
            }
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(6215);
                    try {
                        b.destroy();
                        AppMethodBeat.m2505o(6215);
                    } catch (Exception e) {
                        C45124d.printErrStackTrace("MicroMsg.LuggageWebCoreStash", e, "", new Object[0]);
                        AppMethodBeat.m2505o(6215);
                    }
                }
            });
        }
        AppMethodBeat.m2505o(6217);
    }
}
