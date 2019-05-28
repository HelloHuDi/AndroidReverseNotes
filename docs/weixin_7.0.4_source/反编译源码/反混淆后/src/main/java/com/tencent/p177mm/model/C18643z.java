package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.storage.C5140bq;

/* renamed from: com.tencent.mm.model.z */
public final class C18643z {
    /* renamed from: nY */
    public static C26432y m29128nY(String str) {
        AppMethodBeat.m2504i(77806);
        C26432y c26432y = new C26432y("@black.android", null, str, null, true, true);
        AppMethodBeat.m2505o(77806);
        return c26432y;
    }

    /* renamed from: nZ */
    public static C26432y m29129nZ(String str) {
        AppMethodBeat.m2504i(77807);
        C5140bq RA = ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15356RA("@t.qq.com");
        if (RA == null) {
            AppMethodBeat.m2505o(77807);
            return null;
        }
        C26432y c26432y = new C26432y("@t.qq.com", null, str, null, RA.isEnable(), RA.dum());
        AppMethodBeat.m2505o(77807);
        return c26432y;
    }

    /* renamed from: af */
    private static String m29126af(String str, String str2) {
        AppMethodBeat.m2504i(77808);
        String str3 = "";
        if (str != null) {
            str3 = str3 + str.replace("@", "");
        }
        if (str2 != null) {
            str3 = str3 + str2;
        }
        AppMethodBeat.m2505o(77808);
        return str3;
    }

    /* renamed from: ag */
    public static C26432y m29127ag(String str, String str2) {
        AppMethodBeat.m2504i(77809);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(77809);
            return null;
        }
        C5140bq RA = ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15356RA(str);
        if (RA == null || !RA.dun()) {
            AppMethodBeat.m2505o(77809);
            return null;
        }
        C26432y c26432y = new C26432y("@domain.android", RA.name, C18643z.m29126af(RA.xZV.apT(""), str2), RA.xZV.apT(""), RA.isEnable(), true);
        AppMethodBeat.m2505o(77809);
        return c26432y;
    }
}
