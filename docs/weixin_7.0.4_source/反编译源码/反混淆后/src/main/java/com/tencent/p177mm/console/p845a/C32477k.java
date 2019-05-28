package com.tencent.p177mm.console.p845a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.console.a.k */
public final class C32477k implements C44041a {
    static {
        AppMethodBeat.m2504i(16145);
        C44042b.m79163a(new C32477k(), "//warpgate");
        AppMethodBeat.m2505o(16145);
    }

    public static void init() {
    }

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(16144);
        if (C4990ab.getLogLevel() > 1) {
            AppMethodBeat.m2505o(16144);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.m2505o(16144);
            return true;
        } else {
            String str2 = strArr[1];
            boolean z = true;
            switch (str2.hashCode()) {
                case 3551:
                    if (str2.equals("on")) {
                        z = false;
                        break;
                    }
                    break;
                case 109935:
                    if (str2.equals("off")) {
                        z = true;
                        break;
                    }
                    break;
                case 3540994:
                    if (str2.equals("stop")) {
                        z = true;
                        break;
                    }
                    break;
                case 109757538:
                    if (str2.equals("start")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    C1947ae.gjo = true;
                    C1947ae.gjn = true;
                    break;
                case true:
                    C1947ae.gjo = false;
                    C1947ae.gjn = false;
                    break;
                case true:
                    int i = 8888;
                    if (strArr.length >= 3) {
                        i = C5046bo.getInt(strArr[2], 8888);
                    }
                    try {
                        Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("startServer", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i)});
                        Toast.makeText(C4996ah.getContext(), "start server on ".concat(String.valueOf(i)), 1).show();
                        break;
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.WarpgateCommand", e, "", new Object[0]);
                        break;
                    }
                case true:
                    try {
                        Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("stopServer", new Class[0]).invoke(null, new Object[0]);
                        Toast.makeText(C4996ah.getContext(), "stop server", 1).show();
                        break;
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.WarpgateCommand", e2, "", new Object[0]);
                        break;
                    }
            }
            AppMethodBeat.m2505o(16144);
            return true;
        }
    }
}
