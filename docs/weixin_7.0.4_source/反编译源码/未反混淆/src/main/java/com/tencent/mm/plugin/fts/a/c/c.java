package com.tencent.mm.plugin.fts.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.Comparator;

public final class c implements Comparator<l> {
    public static final c mEW = new c();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.i(114292);
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        int i = lVar.mDw - lVar2.mDw;
        if (i != 0) {
            AppMethodBeat.o(114292);
            return i;
        }
        i = lVar.mEE - lVar2.mEE;
        if (i != 0) {
            AppMethodBeat.o(114292);
            return i;
        }
        i = lVar.mEF.compareTo(lVar2.mEF);
        AppMethodBeat.o(114292);
        return i;
    }

    static {
        AppMethodBeat.i(114293);
        AppMethodBeat.o(114293);
    }
}
