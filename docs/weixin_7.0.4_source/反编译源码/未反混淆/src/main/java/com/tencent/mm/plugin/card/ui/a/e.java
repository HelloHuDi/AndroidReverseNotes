package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;

public final class e extends a {
    public e(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean bdM() {
        AppMethodBeat.i(88714);
        if (!this.kaS.aZD() || l.to(this.kjF.emC) || !this.kaS.isNormal() || this.kok) {
            AppMethodBeat.o(88714);
            return true;
        }
        AppMethodBeat.o(88714);
        return false;
    }

    public final boolean bdQ() {
        AppMethodBeat.i(88715);
        if (!this.kaS.aZD() || l.to(this.kjF.emC) || !this.kaS.isNormal() || this.kok) {
            AppMethodBeat.o(88715);
            return false;
        }
        AppMethodBeat.o(88715);
        return true;
    }

    public final boolean bdU() {
        AppMethodBeat.i(88716);
        if (super.bdU() || (this.kaS.isNormal() && !this.kok && (bdB() || bdC()))) {
            AppMethodBeat.o(88716);
            return true;
        }
        AppMethodBeat.o(88716);
        return false;
    }

    public final boolean bed() {
        AppMethodBeat.i(88717);
        if (!this.kaS.aZD() || this.kaS.aZV().vUo == null || !this.kaS.isNormal() || this.kok || bdB() || bdC()) {
            AppMethodBeat.o(88717);
            return false;
        }
        AppMethodBeat.o(88717);
        return true;
    }

    public final boolean bdZ() {
        AppMethodBeat.i(88718);
        if (this.kaS.isNormal() && super.bdZ() && !bdT()) {
            AppMethodBeat.o(88718);
            return true;
        }
        AppMethodBeat.o(88718);
        return false;
    }

    public final boolean bdE() {
        AppMethodBeat.i(88719);
        if (!super.bdE() || !this.kaS.isNormal() || this.kok || bdB() || bdC()) {
            AppMethodBeat.o(88719);
            return false;
        }
        AppMethodBeat.o(88719);
        return true;
    }

    public final boolean bdT() {
        AppMethodBeat.i(88720);
        if (this.kaS.aZV() == null || !this.kaS.aZV().vUC) {
            AppMethodBeat.o(88720);
            return false;
        }
        AppMethodBeat.o(88720);
        return true;
    }

    public final boolean bdR() {
        return this.kok;
    }
}
