package com.tencent.p177mm.plugin.card.p355ui.p1244a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.card.ui.a.f */
public final class C38765f extends C44725a {
    public C38765f(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean bdS() {
        AppMethodBeat.m2504i(88721);
        if (this.kaS.isNormal() && super.bdS() && (this.kaS.aZQ() || !C5046bo.isNullOrNil(this.kaS.aZW().code))) {
            AppMethodBeat.m2505o(88721);
            return true;
        }
        AppMethodBeat.m2505o(88721);
        return false;
    }

    public final boolean bdT() {
        return true;
    }

    public final boolean bdW() {
        AppMethodBeat.m2504i(88722);
        if (this.kaS.isNormal() && super.bdW()) {
            AppMethodBeat.m2505o(88722);
            return true;
        }
        AppMethodBeat.m2505o(88722);
        return false;
    }

    public final boolean bdR() {
        return this.kok;
    }
}
