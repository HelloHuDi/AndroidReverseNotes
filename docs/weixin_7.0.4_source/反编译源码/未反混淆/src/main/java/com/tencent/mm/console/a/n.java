package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.t;

public final class n implements a {
    static {
        AppMethodBeat.i(16151);
        b.a(new n(), "//cleanwx", "//showfile", "//hidefile");
        AppMethodBeat.o(16151);
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(16150);
        String str2 = strArr[0];
        int i = -1;
        switch (str2.hashCode()) {
            case -1470593122:
                if (str2.equals("//hidefile")) {
                    i = 2;
                    break;
                }
                break;
            case -35508263:
                if (str2.equals("//showfile")) {
                    boolean i2 = true;
                    break;
                }
                break;
            case 2113467658:
                if (str2.equals("//cleanwx")) {
                    i2 = 0;
                    break;
                }
                break;
        }
        switch (i2) {
            case 0:
                com.tencent.mm.sdk.b.a.xxA.m(new bp());
                t.makeText(context, "clean wx file index now.", 0).show();
                AppMethodBeat.o(16150);
                return true;
            case 1:
                try {
                    g.RP().Ry().set(ac.a.USERINFO_CALC_WX_SCAN_SHOW_FILE_INT, Integer.valueOf(1));
                    t.makeText(context, "show file now.", 0).show();
                } catch (Exception e) {
                }
                AppMethodBeat.o(16150);
                return true;
            case 2:
                try {
                    g.RP().Ry().set(ac.a.USERINFO_CALC_WX_SCAN_SHOW_FILE_INT, Integer.valueOf(0));
                    t.makeText(context, "hide file now.", 0).show();
                } catch (Exception e2) {
                }
                AppMethodBeat.o(16150);
                return true;
            default:
                AppMethodBeat.o(16150);
                return false;
        }
    }
}
