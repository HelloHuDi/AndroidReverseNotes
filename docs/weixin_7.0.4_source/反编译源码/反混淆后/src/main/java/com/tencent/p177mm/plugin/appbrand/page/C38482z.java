package com.tencent.p177mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.page.z */
public final class C38482z extends C19640n {
    private C44709u hTn;
    private String mUrl;

    public C38482z(Context context, C38470q c38470q) {
        super(context, c38470q);
    }

    /* Access modifiers changed, original: protected|final */
    public final View aAQ() {
        AppMethodBeat.m2504i(87304);
        if (this.hTn == null) {
            this.hTn = getContainer().getPageViewPrivate();
            this.hTn.mo71765k((C19640n) this);
        }
        View contentView = this.hTn.getContentView();
        AppMethodBeat.m2505o(87304);
        return contentView;
    }

    public final void loadUrl(String str) {
        AppMethodBeat.m2504i(87305);
        if (this.mUrl != null) {
            AppMethodBeat.m2505o(87305);
            return;
        }
        this.mUrl = str;
        this.hTn.mo44893AA(str);
        AppMethodBeat.m2505o(87305);
    }

    /* renamed from: Ay */
    public final boolean mo21657Ay(String str) {
        AppMethodBeat.m2504i(87306);
        boolean equals = C8874h.m15847bO(this.mUrl).equals(C8874h.m15847bO(str));
        AppMethodBeat.m2505o(87306);
        return equals;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aAR() {
        AppMethodBeat.m2504i(87307);
        super.aAR();
        this.hTn.onDestroy();
        AppMethodBeat.m2505o(87307);
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(87308);
        super.cleanup();
        this.hTn.cleanup();
        AppMethodBeat.m2505o(87308);
    }

    public final void aAS() {
        AppMethodBeat.m2504i(87309);
        super.aAS();
        this.hTn.mo71772wU();
        AppMethodBeat.m2505o(87309);
    }

    public final void aAT() {
        AppMethodBeat.m2504i(87310);
        super.aAT();
        this.hTn.mo71773wW();
        AppMethodBeat.m2505o(87310);
    }

    /* renamed from: b */
    public final void mo21662b(String str, String str2, int[] iArr) {
        AppMethodBeat.m2504i(87311);
        if (C19640n.m30441f(iArr, this.hTn.hashCode())) {
            this.hTn.mo51255h(str, str2, 0);
            AppMethodBeat.m2505o(87311);
            return;
        }
        AppMethodBeat.m2505o(87311);
    }

    public final C44709u getCurrentPageView() {
        return this.hTn;
    }

    public final String getCurrentUrl() {
        return this.mUrl;
    }
}
