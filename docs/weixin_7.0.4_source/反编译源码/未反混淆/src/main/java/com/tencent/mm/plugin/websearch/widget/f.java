package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.n;

public final class f {
    public static void a(int i, WidgetData widgetData, WidgetData widgetData2) {
        AppMethodBeat.i(91450);
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
        cn cnVar = new cn();
        cn hr = cnVar.hr(str);
        hr.dha = (long) i;
        hr.dhb = System.currentTimeMillis() / 1000;
        hr.dhd = (long) widgetData.ubs.fmr;
        hr.hs(widgetData.ubs.ubB).ht(String.format("%s-%s-%s", new Object[]{widgetData.ubs.hlm, Integer.valueOf(widgetData.ubs.fmr), Long.valueOf(System.currentTimeMillis() / 1000)}));
        ((n) g.K(n.class)).bw(14688, cnVar.Fj());
        AppMethodBeat.o(91450);
    }
}
