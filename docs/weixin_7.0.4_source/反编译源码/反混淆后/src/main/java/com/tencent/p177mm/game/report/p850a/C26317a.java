package com.tencent.p177mm.game.report.p850a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.game.report.a.a */
public final class C26317a implements C9541b {
    /* renamed from: a */
    public final String mo20807a(C11745a c11745a, String str) {
        AppMethodBeat.m2504i(59592);
        String a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54613a(c11745a, str);
        if (!a.equals(str)) {
            C37860c.eBG.mo60581g(2, c11745a.name(), C26317a.m41868kX(a));
        }
        C4990ab.m7417i("MicroMsg.GameExptManager", "key: %s, result: %s", c11745a.name(), a);
        AppMethodBeat.m2505o(59592);
        return a;
    }

    /* renamed from: a */
    public final boolean mo20808a(C11745a c11745a) {
        AppMethodBeat.m2504i(59593);
        boolean a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(c11745a, false);
        C37860c.eBG.mo60581g(2, c11745a.name(), String.valueOf(a));
        C4990ab.m7417i("MicroMsg.GameExptManager", "key: %s, result: %b", c11745a.name(), Boolean.valueOf(a));
        AppMethodBeat.m2505o(59593);
        return a;
    }

    /* renamed from: kX */
    private static String m41868kX(String str) {
        AppMethodBeat.m2504i(59594);
        try {
            str = URLEncoder.encode(str, "UTF-8");
            AppMethodBeat.m2505o(59594);
        } catch (Exception e) {
            AppMethodBeat.m2505o(59594);
        }
        return str;
    }
}
