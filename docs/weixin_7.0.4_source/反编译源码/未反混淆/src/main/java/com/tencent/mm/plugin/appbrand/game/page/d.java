package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.sdk.platformtools.ab;

@SuppressLint({"ViewConstructor"})
public final class d extends n {
    private f hsH;
    private String mURL;

    public d(Context context, e eVar) {
        super(context, eVar);
        AppMethodBeat.i(130218);
        ab.i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
        AppMethodBeat.o(130218);
    }

    public final View aAQ() {
        AppMethodBeat.i(130219);
        f fVar = new f(getContext(), getContainer().getRuntime());
        this.hsH = fVar;
        WAGamePageViewContainerLayout wAGamePageViewContainerLayout = fVar.hsL;
        AppMethodBeat.o(130219);
        return wAGamePageViewContainerLayout;
    }

    public final void loadUrl(String str) {
        AppMethodBeat.i(130220);
        this.mURL = str;
        this.hsH.AA(str);
        AppMethodBeat.o(130220);
    }

    public final boolean Ay(String str) {
        return true;
    }

    public final void b(String str, String str2, int[] iArr) {
        AppMethodBeat.i(130221);
        this.hsH.h(str, str2, 0);
        AppMethodBeat.o(130221);
    }

    public final f getCurrentPageView() {
        return this.hsH;
    }

    public final String getCurrentUrl() {
        return this.mURL;
    }

    public final void cleanup() {
        AppMethodBeat.i(130222);
        super.cleanup();
        this.hsH.cleanup();
        AppMethodBeat.o(130222);
    }

    public final void aAR() {
        AppMethodBeat.i(130223);
        super.aAR();
        this.hsH.onDestroy();
        AppMethodBeat.o(130223);
    }

    public final void aAS() {
        AppMethodBeat.i(130224);
        super.aAS();
        this.hsH.wU();
        AppMethodBeat.o(130224);
    }

    public final void aAT() {
        AppMethodBeat.i(130225);
        super.aAT();
        this.hsH.wW();
        AppMethodBeat.o(130225);
    }
}
