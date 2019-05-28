package com.tencent.p177mm.plugin.appbrand.dynamic.p891e;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p1101b.C40954d;
import com.tencent.p177mm.plugin.appbrand.p297h.C17090c;
import com.tencent.p177mm.plugin.appbrand.p297h.C26902r;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.e.a */
public final class C10209a implements C40954d {
    public C17090c hoa = new C17090c();

    public C10209a(Object obj) {
        AppMethodBeat.m2504i(10902);
        this.hoa.addJavascriptInterface(obj, "WeixinJSCore");
        AppMethodBeat.m2505o(10902);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(10903);
        if (this.hoa != null) {
            this.hoa.evaluateJavascript(str, valueCallback);
        }
        AppMethodBeat.m2505o(10903);
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(10904);
        if (this.hoa != null) {
            this.hoa.destroy();
        }
        AppMethodBeat.m2505o(10904);
    }

    public final void pause() {
        AppMethodBeat.m2504i(10905);
        if (this.hoa != null) {
            ((C26902r) this.hoa.mo14970af(C26902r.class)).pause();
        }
        AppMethodBeat.m2505o(10905);
    }

    public final void resume() {
        AppMethodBeat.m2504i(10906);
        if (this.hoa != null) {
            ((C26902r) this.hoa.mo14970af(C26902r.class)).resume();
        }
        AppMethodBeat.m2505o(10906);
    }
}
