package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p484c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C12865b;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b.C39530e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C30309s;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.c.a */
public final class C3642a {
    public static int pqF = 0;
    public static int pqG = 1;
    public static int pqH = 2;

    /* renamed from: a */
    private static void m5973a(String str, int i, int i2, int i3, long j, long j2, int i4, int i5, int i6, int i7, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(23949);
        C4990ab.m7411d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s decryptUserName:%s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str2, str3, str4);
        C7060h.pYm.mo8381e(10298, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str2, str3, str4, Integer.valueOf(C30309s.getSessionId()));
        AppMethodBeat.m2505o(23949);
    }

    /* renamed from: a */
    public static void m5974a(String str, int i, int i2, long j, int i3) {
        AppMethodBeat.m2504i(23950);
        C3642a.m5973a(str, i, C3642a.m5972Bl(i2), 1, j, 0, i3, 0, 0, 0, "", "", "");
        AppMethodBeat.m2505o(23950);
    }

    /* renamed from: a */
    public static void m5976a(String str, int i, int i2, long j, long j2, int i3, int i4, int i5, int i6, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(23951);
        C3642a.m5973a(str, i, C3642a.m5972Bl(i2), 2, j, j2, i3, i4, i5, i6, str2, str3, str4);
        AppMethodBeat.m2505o(23951);
    }

    /* renamed from: a */
    public static void m5975a(String str, int i, int i2, long j, int i3, int i4, int i5, int i6, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(23952);
        C3642a.m5973a(str, i, C3642a.m5972Bl(i2), 3, j, 0, i3, i4, i5, i6, str2, str3, str4);
        AppMethodBeat.m2505o(23952);
    }

    /* renamed from: Bl */
    private static int m5972Bl(int i) {
        if (i == 0) {
            return pqG;
        }
        if (i == 1) {
            return pqH;
        }
        return pqF;
    }

    /* renamed from: cE */
    public static String m5977cE(List<C12865b> list) {
        AppMethodBeat.m2504i(23953);
        String str;
        if (list == null) {
            str = "";
            AppMethodBeat.m2505o(23953);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (C12865b c12865b : list) {
            stringBuilder.append(c12865b.pqz + "#" + c12865b.pqA + "#" + c12865b.pqB + ";");
        }
        stringBuilder.append("]");
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(23953);
        return str;
    }

    /* renamed from: cF */
    public static String m5978cF(List<C39530e> list) {
        AppMethodBeat.m2504i(23954);
        String str;
        if (list == null) {
            str = "";
            AppMethodBeat.m2505o(23954);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (C39530e c39530e : list) {
            stringBuilder.append(c39530e.f16178id + "#" + c39530e.key + ";");
        }
        stringBuilder.append("]");
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(23954);
        return str;
    }
}
