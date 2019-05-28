package com.tencent.mm.plugin.fts.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.Comparator;

public final class a implements Comparator<l> {
    public static final a mEU = new a();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.i(114288);
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        int i = lVar2.mDW - lVar.mDW;
        if (i != 0) {
            AppMethodBeat.o(114288);
            return i;
        }
        if (lVar2.mDW >= 50 && lVar.mDW >= 50) {
            i = d.f(c.mCv, lVar.mDw, lVar2.mDw);
            if (i != 0) {
                AppMethodBeat.o(114288);
                return i;
            }
        }
        i = lVar2.mEN - lVar.mEN;
        if (i != 0) {
            AppMethodBeat.o(114288);
            return i;
        } else if (lVar2.timestamp > lVar.timestamp) {
            AppMethodBeat.o(114288);
            return 1;
        } else if (lVar2.timestamp < lVar.timestamp) {
            AppMethodBeat.o(114288);
            return -1;
        } else {
            AppMethodBeat.o(114288);
            return 0;
        }
    }

    static {
        AppMethodBeat.i(114289);
        AppMethodBeat.o(114289);
    }
}
