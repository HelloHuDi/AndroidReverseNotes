package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.launching.n.b;
import com.tencent.mm.plugin.appbrand.launching.n.c;
import com.tencent.mm.sdk.g.d;

public abstract class u implements n {
    public volatile c ihx;
    private volatile b ihy;
    final y ihz;

    public abstract String aHu();

    public abstract void prepare();

    u(y yVar) {
        this.ihz = yVar;
    }

    /* Access modifiers changed, original: final */
    public final void e(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (this.ihx != null) {
            this.ihx.b(wxaPkgWrappingInfo);
        }
    }

    /* Access modifiers changed, original: final */
    public final void c(WxaPkgLoadProgress wxaPkgLoadProgress) {
        b bVar = this.ihy;
        if (bVar != null) {
            bVar.a(wxaPkgLoadProgress);
        }
    }

    /* Access modifiers changed, original: final */
    public final void aHs() {
        if (this.ihx != null) {
            this.ihx.aHm();
        }
    }

    /* Access modifiers changed, original: final */
    public final void aHt() {
        if (this.ihx != null) {
            this.ihx.aHo();
        }
    }

    /* Access modifiers changed, original: final */
    public final void f(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (this.ihx != null) {
            this.ihx.c(wxaPkgWrappingInfo);
        }
    }

    public final void a(c cVar) {
        this.ihx = cVar;
    }

    public final void a(b bVar) {
        this.ihy = bVar;
    }

    public final void prepareAsync() {
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(131885);
                u.this.prepare();
                AppMethodBeat.o(131885);
            }
        }, "AppBrandLaunchPrepareJob#" + aHu());
    }
}
