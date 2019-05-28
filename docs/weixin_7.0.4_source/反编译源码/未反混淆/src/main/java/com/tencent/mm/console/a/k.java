package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class k implements a {
    static {
        AppMethodBeat.i(16145);
        b.a(new k(), "//warpgate");
        AppMethodBeat.o(16145);
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(16144);
        if (ab.getLogLevel() > 1) {
            AppMethodBeat.o(16144);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(16144);
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
                    ae.gjo = true;
                    ae.gjn = true;
                    break;
                case true:
                    ae.gjo = false;
                    ae.gjn = false;
                    break;
                case true:
                    int i = 8888;
                    if (strArr.length >= 3) {
                        i = bo.getInt(strArr[2], 8888);
                    }
                    try {
                        Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("startServer", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i)});
                        Toast.makeText(ah.getContext(), "start server on ".concat(String.valueOf(i)), 1).show();
                        break;
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.WarpgateCommand", e, "", new Object[0]);
                        break;
                    }
                case true:
                    try {
                        Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("stopServer", new Class[0]).invoke(null, new Object[0]);
                        Toast.makeText(ah.getContext(), "stop server", 1).show();
                        break;
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.WarpgateCommand", e2, "", new Object[0]);
                        break;
                    }
            }
            AppMethodBeat.o(16144);
            return true;
        }
    }
}
