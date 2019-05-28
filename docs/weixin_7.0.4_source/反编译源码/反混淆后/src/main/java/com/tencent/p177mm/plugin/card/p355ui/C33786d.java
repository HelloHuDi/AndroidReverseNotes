package com.tencent.p177mm.plugin.card.p355ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.base.C20128a;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.CardInfo;

/* renamed from: com.tencent.mm.plugin.card.ui.d */
public final class C33786d implements C20128a {
    private C11334c kiD;

    public C33786d(C11334c c11334c) {
        this.kiD = c11334c;
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(88251);
        if (this.kiD != null) {
            C42852am.baW().mo10116c(this.kiD);
        }
        AppMethodBeat.m2505o(88251);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(88252);
        if (this.kiD != null) {
            C42852am.baW().mo10117d(this.kiD);
            this.kiD.release();
            this.kiD = null;
        }
        AppMethodBeat.m2505o(88252);
    }

    /* renamed from: ZZ */
    public final void mo35378ZZ() {
        AppMethodBeat.m2504i(88253);
        if (this.kiD != null) {
            this.kiD.mo5248a(null, null);
        }
        AppMethodBeat.m2505o(88253);
    }

    /* renamed from: sM */
    public final /* synthetic */ C42837b mo35381sM(int i) {
        AppMethodBeat.m2504i(88254);
        if (this.kiD != null) {
            CardInfo cardInfo = (CardInfo) this.kiD.getItem(i);
            AppMethodBeat.m2505o(88254);
            return cardInfo;
        }
        AppMethodBeat.m2505o(88254);
        return null;
    }
}
