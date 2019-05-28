package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z extends n {
    private u hTn;
    private String mUrl;

    public z(Context context, q qVar) {
        super(context, qVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final View aAQ() {
        AppMethodBeat.i(87304);
        if (this.hTn == null) {
            this.hTn = getContainer().getPageViewPrivate();
            this.hTn.k((n) this);
        }
        View contentView = this.hTn.getContentView();
        AppMethodBeat.o(87304);
        return contentView;
    }

    public final void loadUrl(String str) {
        AppMethodBeat.i(87305);
        if (this.mUrl != null) {
            AppMethodBeat.o(87305);
            return;
        }
        this.mUrl = str;
        this.hTn.AA(str);
        AppMethodBeat.o(87305);
    }

    public final boolean Ay(String str) {
        AppMethodBeat.i(87306);
        boolean equals = h.bO(this.mUrl).equals(h.bO(str));
        AppMethodBeat.o(87306);
        return equals;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aAR() {
        AppMethodBeat.i(87307);
        super.aAR();
        this.hTn.onDestroy();
        AppMethodBeat.o(87307);
    }

    public final void cleanup() {
        AppMethodBeat.i(87308);
        super.cleanup();
        this.hTn.cleanup();
        AppMethodBeat.o(87308);
    }

    public final void aAS() {
        AppMethodBeat.i(87309);
        super.aAS();
        this.hTn.wU();
        AppMethodBeat.o(87309);
    }

    public final void aAT() {
        AppMethodBeat.i(87310);
        super.aAT();
        this.hTn.wW();
        AppMethodBeat.o(87310);
    }

    public final void b(String str, String str2, int[] iArr) {
        AppMethodBeat.i(87311);
        if (n.f(iArr, this.hTn.hashCode())) {
            this.hTn.h(str, str2, 0);
            AppMethodBeat.o(87311);
            return;
        }
        AppMethodBeat.o(87311);
    }

    public final u getCurrentPageView() {
        return this.hTn;
    }

    public final String getCurrentUrl() {
        return this.mUrl;
    }
}
