package com.tencent.luggage.p147g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.luggage.g.c */
public final class C37400c {
    /* renamed from: c */
    public static <L extends List<T>, T> L m63005c(L l, List<T> list) {
        AppMethodBeat.m2504i(90873);
        if (list != null) {
            l.addAll(list);
        }
        AppMethodBeat.m2505o(90873);
        return l;
    }

    /* renamed from: C */
    public static <T> List<T> m63004C(List<T> list) {
        AppMethodBeat.m2504i(90874);
        if (list == null) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(90874);
            return emptyList;
        }
        AppMethodBeat.m2505o(90874);
        return list;
    }
}
