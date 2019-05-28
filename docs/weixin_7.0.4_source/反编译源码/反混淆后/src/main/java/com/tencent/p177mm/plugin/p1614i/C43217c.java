package com.tencent.p177mm.plugin.p1614i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C6616b;
import com.tencent.p177mm.kernel.p241b.C6617c;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.i.c */
public final class C43217c implements C6616b, C6617c {
    private static C43217c nuF;

    private C43217c() {
    }

    public static synchronized C43217c bGE() {
        C43217c c43217c;
        synchronized (C43217c.class) {
            AppMethodBeat.m2504i(79097);
            if (nuF == null) {
                nuF = new C43217c();
            }
            c43217c = nuF;
            AppMethodBeat.m2505o(79097);
        }
        return c43217c;
    }

    public final List<String> collectStoragePaths() {
        AppMethodBeat.m2504i(79098);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"image/", "image2/", "sfs", "bizimg/"});
        AppMethodBeat.m2505o(79098);
        return linkedList;
    }

    /* renamed from: XW */
    public static String m76863XW() {
        AppMethodBeat.m2504i(79099);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("image/").toString();
        AppMethodBeat.m2505o(79099);
        return stringBuilder2;
    }

    /* renamed from: XX */
    public static String m76864XX() {
        AppMethodBeat.m2504i(79100);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("image2/").toString();
        AppMethodBeat.m2505o(79100);
        return stringBuilder2;
    }

    public static String bGF() {
        AppMethodBeat.m2504i(79101);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("bizimg/").toString();
        AppMethodBeat.m2505o(79101);
        return stringBuilder2;
    }
}
