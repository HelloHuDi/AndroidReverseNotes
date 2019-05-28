package com.tencent.mm.plugin.fts.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.Comparator;

public final class e implements Comparator<l> {
    public static final e mEY = new e();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        if (lVar2.timestamp < lVar.timestamp) {
            return -1;
        }
        return lVar2.timestamp == lVar.timestamp ? 0 : 1;
    }

    static {
        AppMethodBeat.i(114295);
        AppMethodBeat.o(114295);
    }
}
