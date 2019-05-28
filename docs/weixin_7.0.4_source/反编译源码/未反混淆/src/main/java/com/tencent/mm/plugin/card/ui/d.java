package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;

public final class d implements a {
    private c kiD;

    public d(c cVar) {
        this.kiD = cVar;
    }

    public final void onCreate() {
        AppMethodBeat.i(88251);
        if (this.kiD != null) {
            am.baW().c(this.kiD);
        }
        AppMethodBeat.o(88251);
    }

    public final void onDestroy() {
        AppMethodBeat.i(88252);
        if (this.kiD != null) {
            am.baW().d(this.kiD);
            this.kiD.release();
            this.kiD = null;
        }
        AppMethodBeat.o(88252);
    }

    public final void ZZ() {
        AppMethodBeat.i(88253);
        if (this.kiD != null) {
            this.kiD.a(null, null);
        }
        AppMethodBeat.o(88253);
    }

    public final /* synthetic */ b sM(int i) {
        AppMethodBeat.i(88254);
        if (this.kiD != null) {
            CardInfo cardInfo = (CardInfo) this.kiD.getItem(i);
            AppMethodBeat.o(88254);
            return cardInfo;
        }
        AppMethodBeat.o(88254);
        return null;
    }
}
