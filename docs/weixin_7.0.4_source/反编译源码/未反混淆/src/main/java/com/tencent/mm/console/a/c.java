package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class c implements a {
    static {
        AppMethodBeat.i(16129);
        b.a(new c(), "//fav");
        AppMethodBeat.o(16129);
    }

    public static void init() {
    }

    /* JADX WARNING: Missing block: B:12:0x0034, code skipped:
            if (r3.equals("resendfavitem") != false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr, String str) {
        boolean z = false;
        AppMethodBeat.i(16128);
        if (ab.getLogLevel() > 1) {
            AppMethodBeat.o(16128);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(16128);
            return true;
        } else {
            String str2 = strArr[1];
            switch (str2.hashCode()) {
                case -1938535405:
                    break;
                case -1648140403:
                    if (str2.equals("uploadfavitem")) {
                        z = true;
                        break;
                    }
                default:
                    z = true;
                    break;
            }
            com.tencent.mm.sdk.b.b ghVar;
            switch (z) {
                case false:
                    ghVar = new gh();
                    ghVar.cAH.type = 39;
                    ghVar.cAH.cAQ = strArr[2];
                    ghVar.cAH.cAR = strArr[3];
                    com.tencent.mm.sdk.b.a.xxA.a(ghVar, Looper.getMainLooper());
                    break;
                case true:
                    ghVar = new gh();
                    ghVar.cAH.type = 38;
                    ghVar.cAH.cAQ = strArr[2];
                    com.tencent.mm.sdk.b.a.xxA.a(ghVar, Looper.getMainLooper());
                    break;
            }
            AppMethodBeat.o(16128);
            return true;
        }
    }
}
