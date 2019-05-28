package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class f implements a {
    static {
        AppMethodBeat.i(16135);
        b.a(new f(), "//recovery");
        AppMethodBeat.o(16135);
    }

    public static void init() {
    }

    /* JADX WARNING: Missing block: B:12:0x0035, code skipped:
            if (r5.equals("testpush") != false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr, String str) {
        boolean z = false;
        AppMethodBeat.i(16134);
        if (ab.getLogLevel() > 1) {
            AppMethodBeat.o(16134);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(16134);
            return true;
        } else {
            String str2 = strArr[1];
            switch (str2.hashCode()) {
                case -1421107579:
                    if (str2.equals("testmmonline")) {
                        z = true;
                        break;
                    }
                case -1145939284:
                    break;
                case -877169230:
                    if (str2.equals("testmm")) {
                        z = true;
                        break;
                    }
                case 107332:
                    if (str2.equals("log")) {
                        z = true;
                        break;
                    }
                default:
                    z = true;
                    break;
            }
            nv nvVar;
            switch (z) {
                case false:
                    WatchDogPushReceiver.aku();
                    break;
                case true:
                    nvVar = new nv();
                    nvVar.cKm.action = 1;
                    com.tencent.mm.sdk.b.a.xxA.m(nvVar);
                    break;
                case true:
                    nvVar = new nv();
                    nvVar.cKm.action = 3;
                    com.tencent.mm.sdk.b.a.xxA.m(nvVar);
                    break;
                case true:
                    nvVar = new nv();
                    nvVar.cKm.action = 2;
                    com.tencent.mm.sdk.b.a.xxA.m(nvVar);
                    break;
            }
            AppMethodBeat.o(16134);
            return true;
        }
    }
}
