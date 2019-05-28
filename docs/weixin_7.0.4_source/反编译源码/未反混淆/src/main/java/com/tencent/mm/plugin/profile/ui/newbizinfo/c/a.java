package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.s;
import java.util.List;

public final class a {
    public static int pqF = 0;
    public static int pqG = 1;
    public static int pqH = 2;

    private static void a(String str, int i, int i2, int i3, long j, long j2, int i4, int i5, int i6, int i7, String str2, String str3, String str4) {
        AppMethodBeat.i(23949);
        ab.d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s decryptUserName:%s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str2, str3, str4);
        h.pYm.e(10298, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str2, str3, str4, Integer.valueOf(s.getSessionId()));
        AppMethodBeat.o(23949);
    }

    public static void a(String str, int i, int i2, long j, int i3) {
        AppMethodBeat.i(23950);
        a(str, i, Bl(i2), 1, j, 0, i3, 0, 0, 0, "", "", "");
        AppMethodBeat.o(23950);
    }

    public static void a(String str, int i, int i2, long j, long j2, int i3, int i4, int i5, int i6, String str2, String str3, String str4) {
        AppMethodBeat.i(23951);
        a(str, i, Bl(i2), 2, j, j2, i3, i4, i5, i6, str2, str3, str4);
        AppMethodBeat.o(23951);
    }

    public static void a(String str, int i, int i2, long j, int i3, int i4, int i5, int i6, String str2, String str3, String str4) {
        AppMethodBeat.i(23952);
        a(str, i, Bl(i2), 3, j, 0, i3, i4, i5, i6, str2, str3, str4);
        AppMethodBeat.o(23952);
    }

    private static int Bl(int i) {
        if (i == 0) {
            return pqG;
        }
        if (i == 1) {
            return pqH;
        }
        return pqF;
    }

    public static String cE(List<b> list) {
        AppMethodBeat.i(23953);
        String str;
        if (list == null) {
            str = "";
            AppMethodBeat.o(23953);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (b bVar : list) {
            stringBuilder.append(bVar.pqz + "#" + bVar.pqA + "#" + bVar.pqB + ";");
        }
        stringBuilder.append("]");
        str = stringBuilder.toString();
        AppMethodBeat.o(23953);
        return str;
    }

    public static String cF(List<e> list) {
        AppMethodBeat.i(23954);
        String str;
        if (list == null) {
            str = "";
            AppMethodBeat.o(23954);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (e eVar : list) {
            stringBuilder.append(eVar.id + "#" + eVar.key + ";");
        }
        stringBuilder.append("]");
        str = stringBuilder.toString();
        AppMethodBeat.o(23954);
        return str;
    }
}
