package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;

public final class h implements a {
    private g kmg;

    public h(g gVar) {
        this.kmg = gVar;
    }

    public final void onCreate() {
        AppMethodBeat.i(88551);
        this.kmg.notifyDataSetChanged();
        AppMethodBeat.o(88551);
    }

    public final void onDestroy() {
        AppMethodBeat.i(88552);
        if (this.kmg != null) {
            g gVar = this.kmg;
            gVar.kgW.release();
            gVar.kgW = null;
            gVar.khh.clear();
            gVar.mContext = null;
            gVar.kme = null;
            this.kmg = null;
        }
        AppMethodBeat.o(88552);
    }

    public final void ZZ() {
        AppMethodBeat.i(88553);
        if (this.kmg != null) {
            this.kmg.notifyDataSetChanged();
        }
        AppMethodBeat.o(88553);
    }

    public final /* synthetic */ b sM(int i) {
        AppMethodBeat.i(88554);
        if (this.kmg != null) {
            CardInfo sY = this.kmg.sY(i);
            AppMethodBeat.o(88554);
            return sY;
        }
        AppMethodBeat.o(88554);
        return null;
    }
}
