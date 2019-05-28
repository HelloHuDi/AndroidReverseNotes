package com.tencent.p177mm.plugin.fts.p419a.p975c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import java.util.Comparator;

/* renamed from: com.tencent.mm.plugin.fts.a.c.e */
public final class C28112e implements Comparator<C45966l> {
    public static final C28112e mEY = new C28112e();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        C45966l c45966l = (C45966l) obj;
        C45966l c45966l2 = (C45966l) obj2;
        if (c45966l2.timestamp < c45966l.timestamp) {
            return -1;
        }
        return c45966l2.timestamp == c45966l.timestamp ? 0 : 1;
    }

    static {
        AppMethodBeat.m2504i(114295);
        AppMethodBeat.m2505o(114295);
    }
}
