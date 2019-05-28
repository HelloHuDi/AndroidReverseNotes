package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.C10100y;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C10598b;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C19576c;
import com.tencent.p177mm.sdk.p604g.C7305d;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.u */
public abstract class C42620u implements C19574n {
    public volatile C19576c ihx;
    private volatile C10598b ihy;
    final C10100y ihz;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.u$1 */
    class C271801 implements Runnable {
        C271801() {
        }

        public final void run() {
            AppMethodBeat.m2504i(131885);
            C42620u.this.prepare();
            AppMethodBeat.m2505o(131885);
        }
    }

    public abstract String aHu();

    public abstract void prepare();

    C42620u(C10100y c10100y) {
        this.ihz = c10100y;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo68061e(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (this.ihx != null) {
            this.ihx.mo6283b(wxaPkgWrappingInfo);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo68060c(WxaPkgLoadProgress wxaPkgLoadProgress) {
        C10598b c10598b = this.ihy;
        if (c10598b != null) {
            c10598b.mo22111a(wxaPkgLoadProgress);
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
    /* renamed from: f */
    public final void mo68062f(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (this.ihx != null) {
            this.ihx.mo34787c(wxaPkgWrappingInfo);
        }
    }

    /* renamed from: a */
    public final void mo34782a(C19576c c19576c) {
        this.ihx = c19576c;
    }

    /* renamed from: a */
    public final void mo34781a(C10598b c10598b) {
        this.ihy = c10598b;
    }

    public final void prepareAsync() {
        C7305d.post(new C271801(), "AppBrandLaunchPrepareJob#" + aHu());
    }
}
