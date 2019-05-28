package com.tencent.p177mm.plugin.card.p355ui.p1244a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.p931d.C38736l;

/* renamed from: com.tencent.mm.plugin.card.ui.a.e */
public final class C27617e extends C44725a {
    public C27617e(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean bdM() {
        AppMethodBeat.m2504i(88714);
        if (!this.kaS.aZD() || C38736l.m65736to(this.kjF.emC) || !this.kaS.isNormal() || this.kok) {
            AppMethodBeat.m2505o(88714);
            return true;
        }
        AppMethodBeat.m2505o(88714);
        return false;
    }

    public final boolean bdQ() {
        AppMethodBeat.m2504i(88715);
        if (!this.kaS.aZD() || C38736l.m65736to(this.kjF.emC) || !this.kaS.isNormal() || this.kok) {
            AppMethodBeat.m2505o(88715);
            return false;
        }
        AppMethodBeat.m2505o(88715);
        return true;
    }

    public final boolean bdU() {
        AppMethodBeat.m2504i(88716);
        if (super.bdU() || (this.kaS.isNormal() && !this.kok && (bdB() || bdC()))) {
            AppMethodBeat.m2505o(88716);
            return true;
        }
        AppMethodBeat.m2505o(88716);
        return false;
    }

    public final boolean bed() {
        AppMethodBeat.m2504i(88717);
        if (!this.kaS.aZD() || this.kaS.aZV().vUo == null || !this.kaS.isNormal() || this.kok || bdB() || bdC()) {
            AppMethodBeat.m2505o(88717);
            return false;
        }
        AppMethodBeat.m2505o(88717);
        return true;
    }

    public final boolean bdZ() {
        AppMethodBeat.m2504i(88718);
        if (this.kaS.isNormal() && super.bdZ() && !bdT()) {
            AppMethodBeat.m2505o(88718);
            return true;
        }
        AppMethodBeat.m2505o(88718);
        return false;
    }

    public final boolean bdE() {
        AppMethodBeat.m2504i(88719);
        if (!super.bdE() || !this.kaS.isNormal() || this.kok || bdB() || bdC()) {
            AppMethodBeat.m2505o(88719);
            return false;
        }
        AppMethodBeat.m2505o(88719);
        return true;
    }

    public final boolean bdT() {
        AppMethodBeat.m2504i(88720);
        if (this.kaS.aZV() == null || !this.kaS.aZV().vUC) {
            AppMethodBeat.m2505o(88720);
            return false;
        }
        AppMethodBeat.m2505o(88720);
        return true;
    }

    public final boolean bdR() {
        return this.kok;
    }
}
