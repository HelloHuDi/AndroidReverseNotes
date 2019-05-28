package com.tencent.p177mm.plugin.card.p355ui.p1244a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.card.ui.a.h */
public final class C44841h extends C44725a {
    public C44841h(MMActivity mMActivity) {
        super(mMActivity);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bdD() {
        AppMethodBeat.m2504i(88723);
        super.bdD();
        AppMethodBeat.m2505o(88723);
    }

    public final boolean bdN() {
        AppMethodBeat.m2504i(88724);
        ArrayList GD = C42856b.m76074GD(this.kaS.baa());
        if ((!this.kjF.kcf || this.kjF.emC == 4) && !TextUtils.isEmpty(this.kaS.bab())) {
            AppMethodBeat.m2505o(88724);
            return true;
        } else if ((!this.kjF.kcf || GD == null || GD.size() <= 0) && (TextUtils.isEmpty(this.kaS.bab()) || !bdO())) {
            AppMethodBeat.m2505o(88724);
            return false;
        } else {
            AppMethodBeat.m2505o(88724);
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
        AppMethodBeat.m2504i(88726);
        if (super.beb()) {
            AppMethodBeat.m2505o(88726);
            return true;
        } else if (bec()) {
            AppMethodBeat.m2505o(88726);
            return true;
        } else if (this.kaS.aZC() && this.kok) {
            AppMethodBeat.m2505o(88726);
            return true;
        } else {
            AppMethodBeat.m2505o(88726);
            return false;
        }
    }

    public final boolean bdR() {
        return this.kok;
    }

    public final boolean bdV() {
        AppMethodBeat.m2504i(88725);
        if (this.kok && super.bdV()) {
            AppMethodBeat.m2505o(88725);
            return true;
        }
        AppMethodBeat.m2505o(88725);
        return false;
    }

    public final boolean bec() {
        AppMethodBeat.m2504i(88727);
        if (this.kok || this.kaS.aZV().vUt != 1) {
            AppMethodBeat.m2505o(88727);
            return false;
        }
        AppMethodBeat.m2505o(88727);
        return true;
    }
}
