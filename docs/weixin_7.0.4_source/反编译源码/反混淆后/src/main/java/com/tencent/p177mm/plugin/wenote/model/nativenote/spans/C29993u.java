package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.u */
public final class C29993u {
    public static final C46459j uSA = new C46459j();
    public static final C29990c uSB = new C29990c();
    public static final C29991l uSC = new C29991l();
    public static final C40386h uSD = new C40386h();
    public static final ArrayList<C23185t> uSE;
    public static final C36861b uSz = new C36861b();

    static {
        AppMethodBeat.m2504i(26975);
        ArrayList arrayList = new ArrayList();
        uSE = arrayList;
        arrayList.add(uSz);
        uSE.add(uSB);
        uSE.add(uSC);
        uSE.add(uSA);
        AppMethodBeat.m2505o(26975);
    }

    /* renamed from: a */
    public static void m47470a(WXRTEditText wXRTEditText, C23185t... c23185tArr) {
        AppMethodBeat.m2504i(26973);
        C29993u.m47469a(wXRTEditText, uSD, c23185tArr);
        C29993u.m47469a(wXRTEditText, uSB, c23185tArr);
        C29993u.m47469a(wXRTEditText, uSC, c23185tArr);
        C29993u.m47469a(wXRTEditText, uSA, c23185tArr);
        AppMethodBeat.m2505o(26973);
    }

    /* renamed from: a */
    private static void m47469a(WXRTEditText wXRTEditText, C24931o c24931o, C23185t... c23185tArr) {
        AppMethodBeat.m2504i(26974);
        for (C23185t c23185t : c23185tArr) {
            if (c24931o == c23185t) {
                AppMethodBeat.m2505o(26974);
                return;
            }
        }
        c24931o.mo41817a(wXRTEditText, null, null);
        AppMethodBeat.m2505o(26974);
    }
}
