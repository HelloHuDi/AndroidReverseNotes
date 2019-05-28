package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.a;

public final class e extends h implements d {
    int fromScene = 0;

    public e(Context context, a aVar) {
        super(context, aVar);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(24222);
        this.pKs = aVar;
        this.pJZ.clear();
        this.pJZ.addAll(aVar.pJZ);
        notifyDataSetChanged();
        AppMethodBeat.o(24222);
    }

    public final void d(b bVar) {
        bVar.dataType = 0;
        bVar.fromScene = this.fromScene;
        bVar.cvx = ((f) this.pKs).cvx;
        bVar.cKa = ((f) this.pKs).cKa;
    }

    public final void a(int i, i iVar) {
        AppMethodBeat.i(24223);
        ceP();
        AppMethodBeat.o(24223);
    }
}
