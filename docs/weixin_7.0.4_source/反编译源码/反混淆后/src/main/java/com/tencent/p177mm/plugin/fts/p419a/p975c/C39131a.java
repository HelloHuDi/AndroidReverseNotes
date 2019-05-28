package com.tencent.p177mm.plugin.fts.p419a.p975c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import java.util.Comparator;

/* renamed from: com.tencent.mm.plugin.fts.a.c.a */
public final class C39131a implements Comparator<C45966l> {
    public static final C39131a mEU = new C39131a();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.m2504i(114288);
        C45966l c45966l = (C45966l) obj;
        C45966l c45966l2 = (C45966l) obj2;
        int i = c45966l2.mDW - c45966l.mDW;
        if (i != 0) {
            AppMethodBeat.m2505o(114288);
            return i;
        }
        if (c45966l2.mDW >= 50 && c45966l.mDW >= 50) {
            i = C3161d.m5416f(C34202c.mCv, c45966l.mDw, c45966l2.mDw);
            if (i != 0) {
                AppMethodBeat.m2505o(114288);
                return i;
            }
        }
        i = c45966l2.mEN - c45966l.mEN;
        if (i != 0) {
            AppMethodBeat.m2505o(114288);
            return i;
        } else if (c45966l2.timestamp > c45966l.timestamp) {
            AppMethodBeat.m2505o(114288);
            return 1;
        } else if (c45966l2.timestamp < c45966l.timestamp) {
            AppMethodBeat.m2505o(114288);
            return -1;
        } else {
            AppMethodBeat.m2505o(114288);
            return 0;
        }
    }

    static {
        AppMethodBeat.m2504i(114289);
        AppMethodBeat.m2505o(114289);
    }
}
