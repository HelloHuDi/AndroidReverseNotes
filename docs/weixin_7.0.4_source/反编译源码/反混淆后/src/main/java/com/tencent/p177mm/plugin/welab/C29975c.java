package com.tencent.p177mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32685cq;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C14715d;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C29973b;
import com.tencent.p177mm.plugin.welab.p1331d.p1332a.C23169a;

/* renamed from: com.tencent.mm.plugin.welab.c */
public final class C29975c implements C14715d {
    /* renamed from: a */
    public final void mo26983a(String str, C29973b c29973b) {
        AppMethodBeat.m2504i(80537);
        C29974a.ddj().uLR.put(str, c29973b);
        AppMethodBeat.m2505o(80537);
    }

    /* renamed from: a */
    public final void mo26982a(C29973b c29973b) {
        AppMethodBeat.m2504i(80538);
        C29974a.ddj().uLS = c29973b;
        AppMethodBeat.m2505o(80538);
    }

    public final C32685cq agJ(String str) {
        AppMethodBeat.m2504i(80539);
        C23169a agI = C29974a.ddj().agI(str);
        AppMethodBeat.m2505o(80539);
        return agI;
    }
}
