package com.tencent.p177mm.console.p845a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.console.a.c */
public final class C37661c implements C44041a {
    static {
        AppMethodBeat.m2504i(16129);
        C44042b.m79163a(new C37661c(), "//fav");
        AppMethodBeat.m2505o(16129);
    }

    public static void init() {
    }

    /* JADX WARNING: Missing block: B:12:0x0034, code skipped:
            if (r3.equals("resendfavitem") != false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        boolean z = false;
        AppMethodBeat.m2504i(16128);
        if (C4990ab.getLogLevel() > 1) {
            AppMethodBeat.m2505o(16128);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.m2505o(16128);
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
            C4883b c37721gh;
            switch (z) {
                case false:
                    c37721gh = new C37721gh();
                    c37721gh.cAH.type = 39;
                    c37721gh.cAH.cAQ = strArr[2];
                    c37721gh.cAH.cAR = strArr[3];
                    C4879a.xxA.mo10048a(c37721gh, Looper.getMainLooper());
                    break;
                case true:
                    c37721gh = new C37721gh();
                    c37721gh.cAH.type = 38;
                    c37721gh.cAH.cAQ = strArr[2];
                    C4879a.xxA.mo10048a(c37721gh, Looper.getMainLooper());
                    break;
            }
            AppMethodBeat.m2505o(16128);
            return true;
        }
    }
}
