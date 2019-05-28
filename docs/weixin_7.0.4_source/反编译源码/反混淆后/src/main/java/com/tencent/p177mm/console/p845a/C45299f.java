package com.tencent.p177mm.console.p845a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelstat.WatchDogPushReceiver;
import com.tencent.p177mm.p230g.p231a.C42032nv;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.console.a.f */
public final class C45299f implements C44041a {
    static {
        AppMethodBeat.m2504i(16135);
        C44042b.m79163a(new C45299f(), "//recovery");
        AppMethodBeat.m2505o(16135);
    }

    public static void init() {
    }

    /* JADX WARNING: Missing block: B:12:0x0035, code skipped:
            if (r5.equals("testpush") != false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        boolean z = false;
        AppMethodBeat.m2504i(16134);
        if (C4990ab.getLogLevel() > 1) {
            AppMethodBeat.m2505o(16134);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.m2505o(16134);
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
            C42032nv c42032nv;
            switch (z) {
                case false:
                    WatchDogPushReceiver.aku();
                    break;
                case true:
                    c42032nv = new C42032nv();
                    c42032nv.cKm.action = 1;
                    C4879a.xxA.mo10055m(c42032nv);
                    break;
                case true:
                    c42032nv = new C42032nv();
                    c42032nv.cKm.action = 3;
                    C4879a.xxA.mo10055m(c42032nv);
                    break;
                case true:
                    c42032nv = new C42032nv();
                    c42032nv.cKm.action = 2;
                    C4879a.xxA.mo10055m(c42032nv);
                    break;
            }
            AppMethodBeat.m2505o(16134);
            return true;
        }
    }
}
