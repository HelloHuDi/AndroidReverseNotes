package com.tencent.p177mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C6616b;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p1526as.C37472a;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.emoji.e */
public final class C20371e extends C7485q implements C6616b {
    private static C20371e kRr;

    private C20371e() {
        super(C37472a.class);
    }

    public static synchronized C20371e bjc() {
        C20371e c20371e;
        synchronized (C20371e.class) {
            AppMethodBeat.m2504i(62315);
            if (kRr == null) {
                kRr = new C20371e();
            }
            c20371e = kRr;
            AppMethodBeat.m2505o(62315);
        }
        return c20371e;
    }

    public final List<String> collectStoragePaths() {
        AppMethodBeat.m2504i(62316);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"emoji/"});
        AppMethodBeat.m2505o(62316);
        return linkedList;
    }

    public static String bjd() {
        AppMethodBeat.m2504i(62317);
        String str = C1720g.m3536RP().eJM + "emoji/";
        AppMethodBeat.m2505o(62317);
        return str;
    }
}
