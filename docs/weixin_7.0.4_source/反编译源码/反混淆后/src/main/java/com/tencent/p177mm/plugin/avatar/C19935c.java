package com.tencent.p177mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C6616b;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p182ah.C17884o;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.avatar.c */
public final class C19935c extends C7485q implements C6616b {
    private static C19935c jqC;

    private C19935c() {
        super(C17884o.class);
    }

    public static synchronized C19935c aSm() {
        C19935c c19935c;
        synchronized (C19935c.class) {
            AppMethodBeat.m2504i(79053);
            if (jqC == null) {
                jqC = new C19935c();
            }
            c19935c = jqC;
            AppMethodBeat.m2505o(79053);
        }
        return c19935c;
    }

    public final List<String> collectStoragePaths() {
        AppMethodBeat.m2504i(79054);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"avatar/"});
        AppMethodBeat.m2505o(79054);
        return linkedList;
    }

    public static String aSn() {
        AppMethodBeat.m2504i(79055);
        String str = C1720g.m3536RP().cachePath + "avatar/";
        AppMethodBeat.m2505o(79055);
        return str;
    }
}
