package com.tencent.mm.plugin.base.model;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class c {
    public static String decrypt(String str) {
        AppMethodBeat.i(79081);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(79081);
            return null;
        }
        String aw = bo.aw(ah.getContext(), Process.myPid());
        ab.i("MicroMsg.ShortcutUtil", "process name: %s", aw);
        if (str.startsWith("shortcut_") && str.length() > 9) {
            aw = str.substring(9);
            if (aw != null && aw.length() > 0) {
                str = b.da(new String(b.Fu(aw)), q.LK());
                AppMethodBeat.o(79081);
                return str;
            }
        }
        AppMethodBeat.o(79081);
        return str;
    }

    public static String db(String str, String str2) {
        AppMethodBeat.i(79082);
        String x = g.x((g.x(str.getBytes()) + b.da(str2, str)).getBytes());
        AppMethodBeat.o(79082);
        return x;
    }

    public static String Fv(String str) {
        AppMethodBeat.i(79083);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(79083);
            return null;
        }
        String aw = bo.aw(ah.getContext(), Process.myPid());
        ab.i("MicroMsg.ShortcutUtil", "process name: %s", aw);
        aw = b.da(str, q.LK());
        if (bo.isNullOrNil(aw)) {
            AppMethodBeat.o(79083);
            return null;
        }
        String str2 = "shortcut_" + b.V(aw.getBytes());
        AppMethodBeat.o(79083);
        return str2;
    }
}
