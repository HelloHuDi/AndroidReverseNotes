package com.tencent.p177mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.modelappbrand.C26439v;
import com.tencent.p177mm.p230g.p232b.p233a.C26273ad;
import com.tencent.p177mm.plugin.websearch.api.WidgetData;
import com.tencent.p177mm.plugin.websearch.widget.p577a.C4534a;
import com.tencent.p177mm.plugin.websearch.widget.p577a.C7614b;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.storage.C5141c;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.websearch.widget.e */
public final class C40204e {
    private static final C40204e udn = new C40204e();
    /* renamed from: RP */
    boolean f16196RP;
    Set<WidgetData> udo = new HashSet();
    C7614b udp;

    /* renamed from: com.tencent.mm.plugin.websearch.widget.e$1 */
    class C402051 implements Runnable {
        C402051() {
        }

        public final void run() {
            AppMethodBeat.m2504i(91444);
            C42142a c42142a = C32718b.eGM;
            C5141c ll = C42142a.m74295ll("100458");
            if (ll == null) {
                C4990ab.m7416i("WidgetSafeModeProxyImpl", "ABTEST_LAYERID_SEARCH_WIDGET_SAFE_MODE_SWITCH item is null");
                AppMethodBeat.m2505o(91444);
                return;
            }
            C40204e c40204e = C40204e.this;
            boolean z = ll.isValid() && "1".equals(ll.dru().get("isOpen"));
            c40204e.f16196RP = z;
            AppMethodBeat.m2505o(91444);
        }
    }

    static {
        AppMethodBeat.m2504i(91449);
        AppMethodBeat.m2505o(91449);
    }

    public static C40204e cVQ() {
        AppMethodBeat.m2504i(91445);
        if (C4996ah.bqo()) {
            C40204e c40204e = udn;
            AppMethodBeat.m2505o(91445);
            return c40204e;
        }
        RuntimeException runtimeException = new RuntimeException("can not call this out of mm process");
        AppMethodBeat.m2505o(91445);
        throw runtimeException;
    }

    public C40204e() {
        AppMethodBeat.m2504i(91446);
        C1720g.m3537RQ();
        this.udp = new C7614b(C1720g.m3536RP().eJN);
        cVE();
        AppMethodBeat.m2505o(91446);
    }

    /* Access modifiers changed, original: final */
    public final void cVE() {
        AppMethodBeat.m2504i(91447);
        C7305d.post(new C402051(), "WidgetSafeModeProxyImpl");
        AppMethodBeat.m2505o(91447);
    }

    /* renamed from: b */
    public final void mo63554b(WidgetData widgetData, String str) {
        AppMethodBeat.m2504i(91448);
        if (this.udo.contains(widgetData)) {
            C18652u.m29151i("WidgetSafeModeProxyImpl", "widget js error appid %s, err %s", widgetData.ubs.fpS, str);
            C26439v.m42099kT(31);
            C26273ad eZ = new C26273ad().mo43951eZ(widgetData.ubs.fpS);
            eZ.cYw = (long) widgetData.ubs.fmr;
            eZ.cYs = 20;
            eZ.cYt = System.currentTimeMillis();
            eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).mo43953fb(str).ajK();
            C4534a c4534a = new C4534a();
            c4534a.field_appid = widgetData.ubs.fpS;
            if (this.udp.mo10102b((C4925c) c4534a, new String[0])) {
                c4534a.field_pkgVersion = widgetData.ubs.version;
                c4534a.field_jsExceptionCount++;
                this.udp.mo10103c(c4534a, new String[0]);
                AppMethodBeat.m2505o(91448);
                return;
            }
            c4534a.field_pkgVersion = widgetData.ubs.version;
            c4534a.field_jsExceptionCount = 1;
            c4534a.field_beginTimestamp = System.currentTimeMillis();
            this.udp.mo10101b((C4925c) c4534a);
        }
        AppMethodBeat.m2505o(91448);
    }
}
