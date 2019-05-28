package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p484c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p184aj.C37455j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.c.b */
public final class C34738b {
    public static final String pqI = C37455j.fwo;

    /* renamed from: b */
    public static void m57053b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.m2504i(23955);
        C4990ab.m7411d("MicroMsg.Kv10809", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", str, str2, str3, str4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(126), str5, str6, str7);
        C7060h.pYm.mo8381e(10809, str, str2, str3, str4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(126), str5, str6, str7);
        AppMethodBeat.m2505o(23955);
    }

    /* renamed from: fa */
    public static String m57054fa(int i, int i2) {
        AppMethodBeat.m2504i(23956);
        String str;
        if (i < 0) {
            str = "";
            AppMethodBeat.m2505o(23956);
            return str;
        } else if (i2 < 0) {
            str = String.valueOf(i);
            AppMethodBeat.m2505o(23956);
            return str;
        } else {
            str = i + "-" + i2;
            AppMethodBeat.m2505o(23956);
            return str;
        }
    }
}
