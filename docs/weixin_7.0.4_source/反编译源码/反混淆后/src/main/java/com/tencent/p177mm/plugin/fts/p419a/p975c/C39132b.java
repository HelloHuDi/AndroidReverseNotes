package com.tencent.p177mm.plugin.fts.p419a.p975c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
import com.tencent.p177mm.plugin.fts.p419a.C34205g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Comparator;

/* renamed from: com.tencent.mm.plugin.fts.a.c.b */
public final class C39132b implements Comparator<C45966l> {
    public static final C39132b mEV = new C39132b();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.m2504i(114290);
        C45966l c45966l = (C45966l) obj;
        C45966l c45966l2 = (C45966l) obj2;
        int i = c45966l2.mDW - c45966l.mDW;
        if (i != 0) {
            AppMethodBeat.m2505o(114290);
            return i;
        }
        i = C3161d.m5408a(C34202c.mCq, c45966l.type, c45966l2.type);
        if (i != 0) {
            AppMethodBeat.m2505o(114290);
            return i;
        }
        i = C3161d.m5416f(C34202c.mCv, c45966l.mDw, c45966l2.mDw);
        if (i != 0) {
            AppMethodBeat.m2505o(114290);
            return i;
        }
        i = c45966l.mEE - c45966l2.mEE;
        if (i != 0) {
            AppMethodBeat.m2505o(114290);
            return i;
        } else if (c45966l.mDw == 11 || c45966l.mDw == 17 || c45966l.mDw == 18) {
            if (C5046bo.isNullOrNil(c45966l.mEM)) {
                c45966l.mEM = C3161d.m5402MZ(c45966l.mDx);
                c45966l.mEM = c45966l.mEM.toLowerCase();
                if (!C34205g.m56098u(c45966l.mEM.charAt(0))) {
                    c45966l.mEM = "~" + c45966l.mEM;
                }
            }
            if (C5046bo.isNullOrNil(c45966l2.mEM)) {
                c45966l2.mEM = C3161d.m5402MZ(c45966l2.mDx);
                c45966l2.mEM = c45966l2.mEM.toLowerCase();
                if (!C34205g.m56098u(c45966l2.mEM.charAt(0))) {
                    c45966l2.mEM = "~" + c45966l2.mEM;
                }
            }
            i = c45966l.mEM.compareToIgnoreCase(c45966l2.mEM);
            AppMethodBeat.m2505o(114290);
            return i;
        } else {
            i = C5046bo.m7532bc(c45966l.mEF, "").compareToIgnoreCase(c45966l2.mEF);
            AppMethodBeat.m2505o(114290);
            return i;
        }
    }

    static {
        AppMethodBeat.m2504i(114291);
        AppMethodBeat.m2505o(114291);
    }
}
