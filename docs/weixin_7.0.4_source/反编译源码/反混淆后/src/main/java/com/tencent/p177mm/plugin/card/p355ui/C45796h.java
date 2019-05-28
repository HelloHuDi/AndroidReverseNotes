package com.tencent.p177mm.plugin.card.p355ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.base.C20128a;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.CardInfo;

/* renamed from: com.tencent.mm.plugin.card.ui.h */
public final class C45796h implements C20128a {
    private C38771g kmg;

    public C45796h(C38771g c38771g) {
        this.kmg = c38771g;
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(88551);
        this.kmg.notifyDataSetChanged();
        AppMethodBeat.m2505o(88551);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(88552);
        if (this.kmg != null) {
            C38771g c38771g = this.kmg;
            c38771g.kgW.release();
            c38771g.kgW = null;
            c38771g.khh.clear();
            c38771g.mContext = null;
            c38771g.kme = null;
            this.kmg = null;
        }
        AppMethodBeat.m2505o(88552);
    }

    /* renamed from: ZZ */
    public final void mo35378ZZ() {
        AppMethodBeat.m2504i(88553);
        if (this.kmg != null) {
            this.kmg.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(88553);
    }

    /* renamed from: sM */
    public final /* synthetic */ C42837b mo35381sM(int i) {
        AppMethodBeat.m2504i(88554);
        if (this.kmg != null) {
            CardInfo sY = this.kmg.mo61647sY(i);
            AppMethodBeat.m2505o(88554);
            return sY;
        }
        AppMethodBeat.m2505o(88554);
        return null;
    }
}
