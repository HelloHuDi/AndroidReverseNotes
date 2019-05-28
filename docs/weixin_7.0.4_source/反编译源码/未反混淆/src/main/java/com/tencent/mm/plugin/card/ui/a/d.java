package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public final class d extends a {
    public d(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean bdU() {
        return false;
    }

    public final boolean bdW() {
        return false;
    }

    public final boolean bdX() {
        AppMethodBeat.i(88713);
        if (this.kaS.aZW().vSl != null && this.kok && bdy() && bdz()) {
            AppMethodBeat.o(88713);
            return true;
        }
        AppMethodBeat.o(88713);
        return false;
    }
}
