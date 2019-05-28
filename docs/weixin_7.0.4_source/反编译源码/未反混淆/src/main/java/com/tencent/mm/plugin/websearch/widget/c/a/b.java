package com.tencent.mm.plugin.websearch.widget.c.a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.o;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.widget.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private static List<a> udy;

    static {
        AppMethodBeat.i(91464);
        ArrayList arrayList = new ArrayList();
        udy = arrayList;
        arrayList.add(new c());
        udy.add(new d());
        AppMethodBeat.o(91464);
    }

    public static boolean a(String str, r rVar, String str2, WidgetData widgetData) {
        AppMethodBeat.i(91463);
        ab.i("OpenAppHandler", "handle url %s", str);
        for (a aVar : udy) {
            if (aVar != null && aVar.adV(str)) {
                if (!aVar.lO(widgetData.ubs.ubC)) {
                    c.c(widgetData.ubs.fpS, "openApp", str);
                    rVar.g(str2, str, "", -1);
                    AppMethodBeat.o(91463);
                    return true;
                } else if (aVar.adW(str)) {
                    o oVar;
                    if (aVar instanceof d) {
                        oVar = new o();
                        oVar.cWq = 2;
                        oVar = oVar.eK(str).eJ(widgetData.query).Fp().eH(widgetData.ubs.hlm);
                        oVar.cWt = (long) widgetData.ubs.fmr;
                        oVar.eI(widgetData.ubv).ajK();
                    } else if (aVar instanceof c) {
                        oVar = new o();
                        oVar.cWq = 3;
                        oVar = oVar.eK(str).eJ(widgetData.query).Fp().eH(widgetData.ubs.hlm);
                        oVar.cWt = (long) widgetData.ubs.fmr;
                        oVar.eI(widgetData.ubv).ajK();
                    }
                    AppMethodBeat.o(91463);
                    return true;
                }
            }
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("open_target_weapp://")) {
            if (c.H(widgetData.ubs.ubC, 2)) {
                int i;
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("path");
                String queryParameter2 = parse.getQueryParameter("origin_id");
                String queryParameter3 = parse.getQueryParameter("debug_mode");
                if (TextUtils.isEmpty(queryParameter3)) {
                    i = -1;
                } else {
                    i = bo.ank(queryParameter3);
                }
                rVar.g(str2, queryParameter, queryParameter2 + "@app", i);
                AppMethodBeat.o(91463);
                return false;
            }
            c.c(widgetData.ubs.fpS, "openApp", str);
        }
        rVar.g(str2, str, "", -1);
        AppMethodBeat.o(91463);
        return false;
    }
}
