package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class f extends a {
    public f(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean bdS() {
        AppMethodBeat.i(88721);
        if (this.kaS.isNormal() && super.bdS() && (this.kaS.aZQ() || !bo.isNullOrNil(this.kaS.aZW().code))) {
            AppMethodBeat.o(88721);
            return true;
        }
        AppMethodBeat.o(88721);
        return false;
    }

    public final boolean bdT() {
        return true;
    }

    public final boolean bdW() {
        AppMethodBeat.i(88722);
        if (this.kaS.isNormal() && super.bdW()) {
            AppMethodBeat.o(88722);
            return true;
        }
        AppMethodBeat.o(88722);
        return false;
    }

    public final boolean bdR() {
        return this.kok;
    }
}
