package com.tencent.p177mm.plugin.account.bind.p271ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C9399ki;
import com.tencent.p177mm.plugin.account.bind.p271ui.C26580f.C26579a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.e */
public final class C18815e extends C4884c<C9399ki> implements C26579a {
    private C9399ki gua;

    public C18815e() {
        AppMethodBeat.m2504i(13746);
        this.xxI = C9399ki.class.getName().hashCode();
        AppMethodBeat.m2505o(13746);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(13749);
        C9399ki c9399ki = (C9399ki) c4883b;
        if (c9399ki instanceof C9399ki) {
            this.gua = c9399ki;
            new C26580f(this.gua.cFO.czX, this).apv();
            AppMethodBeat.m2505o(13749);
        } else {
            AppMethodBeat.m2505o(13749);
        }
        return false;
    }

    /* renamed from: cL */
    public final boolean mo34066cL(int i, int i2) {
        AppMethodBeat.m2504i(13747);
        if (this.gua == null) {
            AppMethodBeat.m2505o(13747);
            return false;
        } else if (this.gua.cFO.cFQ == null) {
            this.gua = null;
            AppMethodBeat.m2505o(13747);
            return false;
        } else if (i == 0 && i2 == 0) {
            this.gua.cFP.cvi = true;
            this.gua.cFO.cFQ.run();
            this.gua = null;
            AppMethodBeat.m2505o(13747);
            return true;
        } else {
            this.gua.cFP.cvi = false;
            this.gua.cFO.cFQ.run();
            this.gua = null;
            AppMethodBeat.m2505o(13747);
            return false;
        }
    }

    public final void apu() {
        AppMethodBeat.m2504i(13748);
        if (!(this.gua == null || this.gua.cFO.cFQ == null)) {
            this.gua.cFP.cvi = false;
            this.gua.cFO.cFQ.run();
            this.gua = null;
        }
        AppMethodBeat.m2505o(13748);
    }
}
