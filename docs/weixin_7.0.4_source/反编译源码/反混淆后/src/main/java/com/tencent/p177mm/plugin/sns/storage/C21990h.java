package com.tencent.p177mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.model.C13373af;

/* renamed from: com.tencent.mm.plugin.sns.storage.h */
public final class C21990h {
    /* renamed from: YS */
    public static C46236n m33615YS(String str) {
        AppMethodBeat.m2504i(37835);
        C46236n kD;
        if (C35002v.m57481WT(str)) {
            kD = C13373af.cnF().mo62941kD(C35002v.m57483Zm(str));
            AppMethodBeat.m2505o(37835);
            return kD;
        }
        C43570e ku = C13373af.cnI().mo69174ku(C35002v.m57483Zm(str));
        if (ku != null) {
            kD = ku.cqB();
            AppMethodBeat.m2505o(37835);
            return kD;
        }
        AppMethodBeat.m2505o(37835);
        return null;
    }

    /* renamed from: a */
    public static boolean m33617a(String str, C46236n c46236n) {
        AppMethodBeat.m2504i(37836);
        boolean b;
        if (C35002v.m57481WT(str)) {
            b = C13373af.cnF().mo62930b(C35002v.m57483Zm(str), c46236n);
            AppMethodBeat.m2505o(37836);
            return b;
        }
        b = C13373af.cnI().mo69172b(C35002v.m57483Zm(str), c46236n.crd());
        AppMethodBeat.m2505o(37836);
        return b;
    }

    /* renamed from: YT */
    public static C46236n m33616YT(String str) {
        AppMethodBeat.m2504i(37837);
        C46236n DK;
        if (C35002v.m57481WT(str)) {
            DK = C13373af.cnF().mo62914DK(C35002v.m57484Zn(str));
            AppMethodBeat.m2505o(37837);
            return DK;
        }
        C43570e DG = C13373af.cnI().mo69170DG(C35002v.m57484Zn(str));
        if (DG != null) {
            DK = DG.cqB();
            AppMethodBeat.m2505o(37837);
            return DK;
        }
        AppMethodBeat.m2505o(37837);
        return null;
    }
}
