package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h extends a {
    public h(MMActivity mMActivity) {
        super(mMActivity);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bdD() {
        AppMethodBeat.i(88723);
        super.bdD();
        AppMethodBeat.o(88723);
    }

    public final boolean bdN() {
        AppMethodBeat.i(88724);
        ArrayList GD = b.GD(this.kaS.baa());
        if ((!this.kjF.kcf || this.kjF.emC == 4) && !TextUtils.isEmpty(this.kaS.bab())) {
            AppMethodBeat.o(88724);
            return true;
        } else if ((!this.kjF.kcf || GD == null || GD.size() <= 0) && (TextUtils.isEmpty(this.kaS.bab()) || !bdO())) {
            AppMethodBeat.o(88724);
            return false;
        } else {
            AppMethodBeat.o(88724);
            return true;
        }
    }

    public final boolean bdO() {
        return this.kjF.emC == 3;
    }

    public final boolean bdP() {
        return false;
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

    public final boolean bdS() {
        return false;
    }

    public final boolean beb() {
        AppMethodBeat.i(88726);
        if (super.beb()) {
            AppMethodBeat.o(88726);
            return true;
        } else if (bec()) {
            AppMethodBeat.o(88726);
            return true;
        } else if (this.kaS.aZC() && this.kok) {
            AppMethodBeat.o(88726);
            return true;
        } else {
            AppMethodBeat.o(88726);
            return false;
        }
    }

    public final boolean bdR() {
        return this.kok;
    }

    public final boolean bdV() {
        AppMethodBeat.i(88725);
        if (this.kok && super.bdV()) {
            AppMethodBeat.o(88725);
            return true;
        }
        AppMethodBeat.o(88725);
        return false;
    }

    public final boolean bec() {
        AppMethodBeat.i(88727);
        if (this.kok || this.kaS.aZV().vUt != 1) {
            AppMethodBeat.o(88727);
            return false;
        }
        AppMethodBeat.o(88727);
        return true;
    }
}
