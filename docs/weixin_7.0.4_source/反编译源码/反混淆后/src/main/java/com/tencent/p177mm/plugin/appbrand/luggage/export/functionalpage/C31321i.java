package com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.appbrand.game.page.C42448a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10448l;
import com.tencent.p177mm.plugin.appbrand.menu.C42636n;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.page.C27221aj;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.i */
public final class C31321i extends C27242w implements C38436m {
    private String hsV;
    private volatile C10448l ikr;
    private String ikx;

    /* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.i$1 */
    class C313221 implements Runnable {
        C313221() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132133);
            C31321i.this.onReady();
            C31321i.this.getContentView().setVisibility(4);
            C5222ae.m7954hz(C31321i.this.mContext);
            AppMethodBeat.m2505o(132133);
        }
    }

    public final C10448l aCc() {
        AppMethodBeat.m2504i(132134);
        C10448l c10448l = new C10448l(this);
        this.ikr = c10448l;
        AppMethodBeat.m2505o(132134);
        return c10448l;
    }

    public final C10448l aHR() {
        return this.ikr;
    }

    public final String getURL() {
        return this.hsV;
    }

    public final String aBm() {
        return this.ikx;
    }

    @SuppressLint({"MissingSuperCall"})
    /* renamed from: AA */
    public final boolean mo44893AA(String str) {
        AppMethodBeat.m2504i(132135);
        this.hsV = C8874h.m15847bO(str);
        this.ikx = str;
        C5004al.m7441d(new C313221());
        AppMethodBeat.m2505o(132135);
        return true;
    }

    public final void aIb() {
    }

    /* renamed from: aL */
    public final void mo44911aL(List<C42636n> list) {
    }

    public final void onCreate() {
    }

    /* renamed from: cF */
    public final C27221aj mo44915cF(Context context) {
        AppMethodBeat.m2504i(132137);
        C42448a c42448a = new C42448a();
        AppMethodBeat.m2505o(132137);
        return c42448a;
    }

    /* renamed from: xN */
    public final void mo44924xN() {
        AppMethodBeat.m2504i(132138);
        try {
            super.mo44924xN();
            AppMethodBeat.m2505o(132138);
        } catch (NullPointerException e) {
            AppMethodBeat.m2505o(132138);
        }
    }

    /* renamed from: a */
    public final int mo51254a(C6747i c6747i, int i) {
        return i;
    }

    /* renamed from: M */
    public final void mo6107M(int i, String str) {
        AppMethodBeat.m2504i(132136);
        ((C27187j) super.getRuntime()).ikA.mo53934a(this, i, str);
        AppMethodBeat.m2505o(132136);
    }

    /* renamed from: xL */
    public final /* synthetic */ C25697b mo44922xL() {
        AppMethodBeat.m2504i(132140);
        C27187j c27187j = (C27187j) super.getRuntime();
        AppMethodBeat.m2505o(132140);
        return c27187j;
    }
}
