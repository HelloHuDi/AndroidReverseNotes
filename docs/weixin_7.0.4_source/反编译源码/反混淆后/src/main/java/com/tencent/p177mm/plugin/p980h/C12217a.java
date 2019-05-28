package com.tencent.p177mm.plugin.p980h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C6616b;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p707ba.C41787r;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.h.a */
public final class C12217a extends C7485q implements C6616b {
    private static C12217a kJF;

    private C12217a() {
        super(C41787r.class);
    }

    public static synchronized C12217a bic() {
        C12217a c12217a;
        synchronized (C12217a.class) {
            AppMethodBeat.m2504i(79089);
            if (kJF == null) {
                kJF = new C12217a();
            }
            c12217a = kJF;
            AppMethodBeat.m2505o(79089);
        }
        return c12217a;
    }

    public final List<String> collectStoragePaths() {
        AppMethodBeat.m2504i(79090);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"package/"});
        AppMethodBeat.m2505o(79090);
        return linkedList;
    }

    /* renamed from: Yd */
    public static String m20142Yd() {
        AppMethodBeat.m2504i(79091);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("package/").toString();
        AppMethodBeat.m2505o(79091);
        return stringBuilder2;
    }
}
