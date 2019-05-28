package com.tencent.mm.w.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class b extends a {
    public b(Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i) {
        super(context, bVar, i);
    }

    public final int getType() {
        return 33;
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        return null;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        return null;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, l lVar, e.a aVar) {
        AppMethodBeat.i(124493);
        c cVar = new c(i2);
        cVar.hpS = lVar;
        cVar.mDz = aVar.mDz;
        cVar.ej(lVar.type, lVar.mDw);
        AppMethodBeat.o(124493);
        return cVar;
    }
}
