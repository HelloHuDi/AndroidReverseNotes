package com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10448l;
import com.tencent.p177mm.plugin.appbrand.p297h.C26903t;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.d */
public final class C33443d extends C19722s implements C38436m {
    private volatile C10448l ikr;

    public final C10448l aCc() {
        AppMethodBeat.m2504i(132118);
        C10448l c10448l = new C10448l(this);
        this.ikr = c10448l;
        AppMethodBeat.m2505o(132118);
        return c10448l;
    }

    public final C10448l aHR() {
        return this.ikr;
    }

    public final C6747i aua() {
        AppMethodBeat.m2504i(132119);
        C4996ah.getContext();
        C6747i oU = C26903t.m42837oU(WxaCommLibRuntimeReader.avQ().gVu);
        AppMethodBeat.m2505o(132119);
        return oU;
    }

    /* renamed from: wO */
    public final void mo34953wO() {
    }

    /* renamed from: a */
    public final int mo51254a(C6747i c6747i, int i) {
        return i;
    }

    /* renamed from: M */
    public final void mo6107M(int i, String str) {
        AppMethodBeat.m2504i(132120);
        ((C27187j) super.getRuntime()).ikA.mo53934a(this, i, str);
        AppMethodBeat.m2505o(132120);
    }

    /* renamed from: xL */
    public final /* synthetic */ C25697b mo34954xL() {
        AppMethodBeat.m2504i(132122);
        C27187j c27187j = (C27187j) super.getRuntime();
        AppMethodBeat.m2505o(132122);
        return c27187j;
    }
}
