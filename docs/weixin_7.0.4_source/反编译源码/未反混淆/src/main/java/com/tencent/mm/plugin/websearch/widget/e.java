package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ad;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.widget.a.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.c;
import java.util.HashSet;
import java.util.Set;

public final class e {
    private static final e udn = new e();
    boolean RP;
    Set<WidgetData> udo = new HashSet();
    b udp;

    static {
        AppMethodBeat.i(91449);
        AppMethodBeat.o(91449);
    }

    public static e cVQ() {
        AppMethodBeat.i(91445);
        if (ah.bqo()) {
            e eVar = udn;
            AppMethodBeat.o(91445);
            return eVar;
        }
        RuntimeException runtimeException = new RuntimeException("can not call this out of mm process");
        AppMethodBeat.o(91445);
        throw runtimeException;
    }

    public e() {
        AppMethodBeat.i(91446);
        g.RQ();
        this.udp = new b(g.RP().eJN);
        cVE();
        AppMethodBeat.o(91446);
    }

    /* Access modifiers changed, original: final */
    public final void cVE() {
        AppMethodBeat.i(91447);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(91444);
                a aVar = a.b.eGM;
                c ll = a.ll("100458");
                if (ll == null) {
                    ab.i("WidgetSafeModeProxyImpl", "ABTEST_LAYERID_SEARCH_WIDGET_SAFE_MODE_SWITCH item is null");
                    AppMethodBeat.o(91444);
                    return;
                }
                e eVar = e.this;
                boolean z = ll.isValid() && "1".equals(ll.dru().get("isOpen"));
                eVar.RP = z;
                AppMethodBeat.o(91444);
            }
        }, "WidgetSafeModeProxyImpl");
        AppMethodBeat.o(91447);
    }

    public final void b(WidgetData widgetData, String str) {
        AppMethodBeat.i(91448);
        if (this.udo.contains(widgetData)) {
            u.i("WidgetSafeModeProxyImpl", "widget js error appid %s, err %s", widgetData.ubs.fpS, str);
            v.kT(31);
            ad eZ = new ad().eZ(widgetData.ubs.fpS);
            eZ.cYw = (long) widgetData.ubs.fmr;
            eZ.cYs = 20;
            eZ.cYt = System.currentTimeMillis();
            eZ.fa(at.gB(ah.getContext())).fb(str).ajK();
            com.tencent.mm.plugin.websearch.widget.a.a aVar = new com.tencent.mm.plugin.websearch.widget.a.a();
            aVar.field_appid = widgetData.ubs.fpS;
            if (this.udp.b((com.tencent.mm.sdk.e.c) aVar, new String[0])) {
                aVar.field_pkgVersion = widgetData.ubs.version;
                aVar.field_jsExceptionCount++;
                this.udp.c(aVar, new String[0]);
                AppMethodBeat.o(91448);
                return;
            }
            aVar.field_pkgVersion = widgetData.ubs.version;
            aVar.field_jsExceptionCount = 1;
            aVar.field_beginTimestamp = System.currentTimeMillis();
            this.udp.b((com.tencent.mm.sdk.e.c) aVar);
        }
        AppMethodBeat.o(91448);
    }
}
