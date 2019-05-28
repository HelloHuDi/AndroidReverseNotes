package com.tencent.p177mm.sdk.p1574f;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Locale;

/* renamed from: com.tencent.mm.sdk.f.a */
public final class C40612a {
    /* renamed from: a */
    public static void m70043a(String str, Context context) {
        AppMethodBeat.m2504i(65356);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(65356);
            return;
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", C5730e.asY(str)));
        C4990ab.m7417i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", str);
        AppMethodBeat.m2505o(65356);
    }

    /* renamed from: RL */
    public static String m70042RL(String str) {
        AppMethodBeat.m2504i(65357);
        String str2 = C6457e.euR + String.format(Locale.US, "%s%d.%s", new Object[]{"mmexport", Long.valueOf(System.currentTimeMillis()), str});
        AppMethodBeat.m2505o(65357);
        return str2;
    }

    public static String dlz() {
        AppMethodBeat.m2504i(65358);
        String str = C6457e.euR;
        str = str.substring(str.indexOf("tencent/MicroMsg"));
        AppMethodBeat.m2505o(65358);
        return str;
    }
}
