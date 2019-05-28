package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.luggage.g.h;
import com.tencent.luggage.sdk.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.page.a;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.ae;
import java.util.List;

public final class i extends w implements m {
    private String hsV;
    private volatile l ikr;
    private String ikx;

    public final l aCc() {
        AppMethodBeat.i(132134);
        l lVar = new l(this);
        this.ikr = lVar;
        AppMethodBeat.o(132134);
        return lVar;
    }

    public final l aHR() {
        return this.ikr;
    }

    public final String getURL() {
        return this.hsV;
    }

    public final String aBm() {
        return this.ikx;
    }

    @SuppressLint({"MissingSuperCall"})
    public final boolean AA(String str) {
        AppMethodBeat.i(132135);
        this.hsV = h.bO(str);
        this.ikx = str;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132133);
                i.this.onReady();
                i.this.getContentView().setVisibility(4);
                ae.hz(i.this.mContext);
                AppMethodBeat.o(132133);
            }
        });
        AppMethodBeat.o(132135);
        return true;
    }

    public final void aIb() {
    }

    public final void aL(List<n> list) {
    }

    public final void onCreate() {
    }

    public final aj cF(Context context) {
        AppMethodBeat.i(132137);
        a aVar = new a();
        AppMethodBeat.o(132137);
        return aVar;
    }

    public final void xN() {
        AppMethodBeat.i(132138);
        try {
            super.xN();
            AppMethodBeat.o(132138);
        } catch (NullPointerException e) {
            AppMethodBeat.o(132138);
        }
    }

    public final int a(com.tencent.mm.plugin.appbrand.h.i iVar, int i) {
        return i;
    }

    public final void M(int i, String str) {
        AppMethodBeat.i(132136);
        ((j) super.getRuntime()).ikA.a(this, i, str);
        AppMethodBeat.o(132136);
    }

    public final /* synthetic */ b xL() {
        AppMethodBeat.i(132140);
        j jVar = (j) super.getRuntime();
        AppMethodBeat.o(132140);
        return jVar;
    }
}
