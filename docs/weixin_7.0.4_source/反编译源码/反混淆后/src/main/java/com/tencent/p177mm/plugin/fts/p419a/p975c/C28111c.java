package com.tencent.p177mm.plugin.fts.p419a.p975c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import java.util.Comparator;

/* renamed from: com.tencent.mm.plugin.fts.a.c.c */
public final class C28111c implements Comparator<C45966l> {
    public static final C28111c mEW = new C28111c();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.m2504i(114292);
        C45966l c45966l = (C45966l) obj;
        C45966l c45966l2 = (C45966l) obj2;
        int i = c45966l.mDw - c45966l2.mDw;
        if (i != 0) {
            AppMethodBeat.m2505o(114292);
            return i;
        }
        i = c45966l.mEE - c45966l2.mEE;
        if (i != 0) {
            AppMethodBeat.m2505o(114292);
            return i;
        }
        i = c45966l.mEF.compareTo(c45966l2.mEF);
        AppMethodBeat.m2505o(114292);
        return i;
    }

    static {
        AppMethodBeat.m2504i(114293);
        AppMethodBeat.m2505o(114293);
    }
}
