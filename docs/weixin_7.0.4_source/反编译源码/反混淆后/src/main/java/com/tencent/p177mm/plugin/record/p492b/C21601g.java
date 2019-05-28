package com.tencent.p177mm.plugin.record.p492b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C43438b;
import com.tencent.p177mm.sdk.p600b.C4879a;

/* renamed from: com.tencent.mm.plugin.record.b.g */
public final class C21601g {
    /* renamed from: a */
    public static String m33077a(C43438b c43438b) {
        AppMethodBeat.m2504i(24163);
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 2;
        c37721gh.cAH.cAJ = c43438b.cAv;
        C4879a.xxA.mo10055m(c37721gh);
        String str = c37721gh.cAI.path;
        AppMethodBeat.m2505o(24163);
        return str;
    }

    /* renamed from: b */
    public static String m33078b(C43438b c43438b) {
        AppMethodBeat.m2504i(24164);
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 2;
        c37721gh.cAH.cAJ = c43438b.cAv;
        C4879a.xxA.mo10055m(c37721gh);
        String str = c37721gh.cAI.thumbPath;
        AppMethodBeat.m2505o(24164);
        return str;
    }

    /* renamed from: c */
    public static boolean m33079c(C43438b c43438b) {
        AppMethodBeat.m2504i(24165);
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 14;
        c37721gh.cAH.cAJ = c43438b.cAv;
        C4879a.xxA.mo10055m(c37721gh);
        if (c37721gh.cAI.ret == 1) {
            AppMethodBeat.m2505o(24165);
            return true;
        }
        AppMethodBeat.m2505o(24165);
        return false;
    }

    /* renamed from: jD */
    public static C27966g m33080jD(long j) {
        AppMethodBeat.m2504i(24166);
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
        AppMethodBeat.m2505o(24166);
        return iE;
    }
}
