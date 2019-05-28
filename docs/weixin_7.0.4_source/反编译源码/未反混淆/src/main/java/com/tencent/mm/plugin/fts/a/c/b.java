package com.tencent.mm.plugin.fts.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Comparator;

public final class b implements Comparator<l> {
    public static final b mEV = new b();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.i(114290);
        l lVar = (l) obj;
        l lVar2 = (l) obj2;
        int i = lVar2.mDW - lVar.mDW;
        if (i != 0) {
            AppMethodBeat.o(114290);
            return i;
        }
        i = d.a(c.mCq, lVar.type, lVar2.type);
        if (i != 0) {
            AppMethodBeat.o(114290);
            return i;
        }
        i = d.f(c.mCv, lVar.mDw, lVar2.mDw);
        if (i != 0) {
            AppMethodBeat.o(114290);
            return i;
        }
        i = lVar.mEE - lVar2.mEE;
        if (i != 0) {
            AppMethodBeat.o(114290);
            return i;
        } else if (lVar.mDw == 11 || lVar.mDw == 17 || lVar.mDw == 18) {
            if (bo.isNullOrNil(lVar.mEM)) {
                lVar.mEM = d.MZ(lVar.mDx);
                lVar.mEM = lVar.mEM.toLowerCase();
                if (!g.u(lVar.mEM.charAt(0))) {
                    lVar.mEM = "~" + lVar.mEM;
                }
            }
            if (bo.isNullOrNil(lVar2.mEM)) {
                lVar2.mEM = d.MZ(lVar2.mDx);
                lVar2.mEM = lVar2.mEM.toLowerCase();
                if (!g.u(lVar2.mEM.charAt(0))) {
                    lVar2.mEM = "~" + lVar2.mEM;
                }
            }
            i = lVar.mEM.compareToIgnoreCase(lVar2.mEM);
            AppMethodBeat.o(114290);
            return i;
        } else {
            i = bo.bc(lVar.mEF, "").compareToIgnoreCase(lVar2.mEF);
            AppMethodBeat.o(114290);
            return i;
        }
    }

    static {
        AppMethodBeat.i(114291);
        AppMethodBeat.o(114291);
    }
}
