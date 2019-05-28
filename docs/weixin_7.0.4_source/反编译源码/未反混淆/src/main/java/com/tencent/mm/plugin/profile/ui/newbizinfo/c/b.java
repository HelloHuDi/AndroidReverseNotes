package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    public static final String pqI = j.fwo;

    public static void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(23955);
        ab.d("MicroMsg.Kv10809", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", str, str2, str3, str4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(126), str5, str6, str7);
        h.pYm.e(10809, str, str2, str3, str4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(126), str5, str6, str7);
        AppMethodBeat.o(23955);
    }

    public static String fa(int i, int i2) {
        AppMethodBeat.i(23956);
        String str;
        if (i < 0) {
            str = "";
            AppMethodBeat.o(23956);
            return str;
        } else if (i2 < 0) {
            str = String.valueOf(i);
            AppMethodBeat.o(23956);
            return str;
        } else {
            str = i + "-" + i2;
            AppMethodBeat.o(23956);
            return str;
        }
    }
}
