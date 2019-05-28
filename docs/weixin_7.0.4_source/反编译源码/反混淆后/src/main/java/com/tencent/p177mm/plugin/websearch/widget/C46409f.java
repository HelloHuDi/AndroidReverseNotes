package com.tencent.p177mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p232b.p233a.C37828cn;
import com.tencent.p177mm.plugin.websearch.api.C43852n;
import com.tencent.p177mm.plugin.websearch.api.WidgetData;

/* renamed from: com.tencent.mm.plugin.websearch.widget.f */
public final class C46409f {
    /* renamed from: a */
    public static void m87355a(int i, WidgetData widgetData, WidgetData widgetData2) {
        AppMethodBeat.m2504i(91450);
        String str = "";
        switch (i) {
            case 1:
            case 3:
                str = widgetData.ubs.fpS;
                break;
            case 2:
                str = widgetData2.ubs.fpS;
                break;
        }
        C37828cn c37828cn = new C37828cn();
        C37828cn hr = c37828cn.mo60541hr(str);
        hr.dha = (long) i;
        hr.dhb = System.currentTimeMillis() / 1000;
        hr.dhd = (long) widgetData.ubs.fmr;
        hr.mo60542hs(widgetData.ubs.ubB).mo60543ht(String.format("%s-%s-%s", new Object[]{widgetData.ubs.hlm, Integer.valueOf(widgetData.ubs.fmr), Long.valueOf(System.currentTimeMillis() / 1000)}));
        ((C43852n) C1720g.m3528K(C43852n.class)).mo47995bw(14688, c37828cn.mo4982Fj());
        AppMethodBeat.m2505o(91450);
    }
}
