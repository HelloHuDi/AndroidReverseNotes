package com.tencent.mm.plugin.fts.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.Comparator;

public final class d implements Comparator<l> {
    public static final d mEX = new d();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        if (lVar.timestamp > lVar2.timestamp) {
            return -1;
        }
        if (lVar.timestamp < lVar2.timestamp) {
            return 1;
        }
        if (lVar.mDw < lVar2.mDw) {
            return 1;
        }
        if (lVar.mDw <= lVar2.mDw) {
            return 0;
        }
        return -1;
    }

    static {
        AppMethodBeat.i(114294);
        AppMethodBeat.o(114294);
    }
}
