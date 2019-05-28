package com.tencent.p177mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.l */
public final class C38601l implements C10379b, C10380c {
    final WeakReference<C44709u> jdm;

    public C38601l(C44709u c44709u) {
        AppMethodBeat.m2504i(123674);
        this.jdm = new WeakReference(c44709u);
        c44709u.mo53827a((C10379b) this);
        c44709u.mo53828a((C10380c) this);
        AppMethodBeat.m2505o(123674);
    }

    /* renamed from: wW */
    public final void mo21857wW() {
        AppMethodBeat.m2504i(123675);
        C44709u c44709u = (C44709u) this.jdm.get();
        if (c44709u != null) {
            C42743o.m75756v(c44709u);
        }
        AppMethodBeat.m2505o(123675);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(123676);
        C44709u c44709u = (C44709u) this.jdm.get();
        if (c44709u != null) {
            if (c44709u.mContext instanceof C2559ad) {
                ((C2559ad) c44709u.mContext).aqX();
            }
            C42743o.m75756v(c44709u);
            C42743o.m75757w(c44709u);
            C38600e.m65413t(c44709u);
            c44709u.mo53832b((C10379b) this);
            c44709u.mo53833b((C10380c) this);
            if (c44709u.aJz() != null) {
                C19875h.aQx().mo35112b(c44709u.aJz());
            }
        }
        AppMethodBeat.m2505o(123676);
    }
}
