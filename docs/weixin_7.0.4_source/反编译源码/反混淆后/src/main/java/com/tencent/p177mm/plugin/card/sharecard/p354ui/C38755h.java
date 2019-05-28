package com.tencent.p177mm.plugin.card.sharecard.p354ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.base.C20128a;
import com.tencent.p177mm.plugin.card.base.C42837b;

/* renamed from: com.tencent.mm.plugin.card.sharecard.ui.h */
public final class C38755h implements C20128a {
    private C38754g khi;

    public C38755h(C38754g c38754g) {
        this.khi = c38754g;
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(88162);
        this.khi.notifyDataSetChanged();
        AppMethodBeat.m2505o(88162);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(88163);
        if (this.khi != null) {
            C38754g c38754g = this.khi;
            c38754g.kgW.release();
            c38754g.kgW = null;
            c38754g.khh.clear();
            c38754g.mContext = null;
            this.khi = null;
        }
        AppMethodBeat.m2505o(88163);
    }

    /* renamed from: ZZ */
    public final void mo35378ZZ() {
        AppMethodBeat.m2504i(88164);
        if (this.khi != null) {
            this.khi.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(88164);
    }

    /* renamed from: sM */
    public final C42837b mo35381sM(int i) {
        AppMethodBeat.m2504i(88165);
        if (this.khi != null) {
            C42837b sM = this.khi.mo61628sM(i);
            AppMethodBeat.m2505o(88165);
            return sM;
        }
        AppMethodBeat.m2505o(88165);
        return null;
    }
}
