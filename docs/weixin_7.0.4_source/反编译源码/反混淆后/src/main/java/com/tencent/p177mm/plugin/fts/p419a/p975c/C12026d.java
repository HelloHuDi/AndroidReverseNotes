package com.tencent.p177mm.plugin.fts.p419a.p975c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import java.util.Comparator;

/* renamed from: com.tencent.mm.plugin.fts.a.c.d */
public final class C12026d implements Comparator<C45966l> {
    public static final C12026d mEX = new C12026d();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        C45966l c45966l = (C45966l) obj;
        C45966l c45966l2 = (C45966l) obj2;
        if (c45966l.timestamp > c45966l2.timestamp) {
            return -1;
        }
        if (c45966l.timestamp < c45966l2.timestamp) {
            return 1;
        }
        if (c45966l.mDw < c45966l2.mDw) {
            return 1;
        }
        if (c45966l.mDw <= c45966l2.mDw) {
            return 0;
        }
        return -1;
    }

    static {
        AppMethodBeat.m2504i(114294);
        AppMethodBeat.m2505o(114294);
    }
}
