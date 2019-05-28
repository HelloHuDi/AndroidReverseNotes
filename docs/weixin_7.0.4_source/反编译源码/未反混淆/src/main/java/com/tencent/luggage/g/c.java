package com.tencent.luggage.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class c {
    public static <L extends List<T>, T> L c(L l, List<T> list) {
        AppMethodBeat.i(90873);
        if (list != null) {
            l.addAll(list);
        }
        AppMethodBeat.o(90873);
        return l;
    }

    public static <T> List<T> C(List<T> list) {
        AppMethodBeat.i(90874);
        if (list == null) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(90874);
            return emptyList;
        }
        AppMethodBeat.o(90874);
        return list;
    }
}
