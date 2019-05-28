package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;

public final class h implements a {
    private g khi;

    public h(g gVar) {
        this.khi = gVar;
    }

    public final void onCreate() {
        AppMethodBeat.i(88162);
        this.khi.notifyDataSetChanged();
        AppMethodBeat.o(88162);
    }

    public final void onDestroy() {
        AppMethodBeat.i(88163);
        if (this.khi != null) {
            g gVar = this.khi;
            gVar.kgW.release();
            gVar.kgW = null;
            gVar.khh.clear();
            gVar.mContext = null;
            this.khi = null;
        }
        AppMethodBeat.o(88163);
    }

    public final void ZZ() {
        AppMethodBeat.i(88164);
        if (this.khi != null) {
            this.khi.notifyDataSetChanged();
        }
        AppMethodBeat.o(88164);
    }

    public final b sM(int i) {
        AppMethodBeat.i(88165);
        if (this.khi != null) {
            b sM = this.khi.sM(i);
            AppMethodBeat.o(88165);
            return sM;
        }
        AppMethodBeat.o(88165);
        return null;
    }
}
