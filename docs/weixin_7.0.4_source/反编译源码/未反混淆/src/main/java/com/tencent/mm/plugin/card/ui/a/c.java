package com.tencent.mm.plugin.card.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public final class c extends a {
    public c(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean bdU() {
        return false;
    }

    public final boolean bdZ() {
        return false;
    }

    public final boolean bea() {
        return false;
    }

    public final boolean bdR() {
        return this.kok;
    }

    public final boolean bdV() {
        AppMethodBeat.i(88712);
        if (this.kok && super.bdV()) {
            AppMethodBeat.o(88712);
            return true;
        }
        AppMethodBeat.o(88712);
        return false;
    }
}
