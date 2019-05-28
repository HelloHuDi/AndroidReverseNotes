package com.tencent.p177mm.plugin.websearch.widget.p1323c.p1324a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C1598o;
import com.tencent.p177mm.plugin.websearch.api.C22759r;
import com.tencent.p177mm.plugin.websearch.api.WidgetData;
import com.tencent.p177mm.plugin.websearch.widget.p1323c.C46407c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.websearch.widget.c.a.b */
public final class C40201b {
    private static List<C43854a> udy;

    static {
        AppMethodBeat.m2504i(91464);
        ArrayList arrayList = new ArrayList();
        udy = arrayList;
        arrayList.add(new C29758c());
        udy.add(new C22769d());
        AppMethodBeat.m2505o(91464);
    }

    /* renamed from: a */
    public static boolean m68948a(String str, C22759r c22759r, String str2, WidgetData widgetData) {
        AppMethodBeat.m2504i(91463);
        C4990ab.m7417i("OpenAppHandler", "handle url %s", str);
        for (C43854a c43854a : udy) {
            if (c43854a != null && c43854a.adV(str)) {
                if (!c43854a.mo38361lO(widgetData.ubs.ubC)) {
                    C46407c.m87353c(widgetData.ubs.fpS, "openApp", str);
                    c22759r.mo38348g(str2, str, "", -1);
                    AppMethodBeat.m2505o(91463);
                    return true;
                } else if (c43854a.adW(str)) {
                    C1598o c1598o;
                    if (c43854a instanceof C22769d) {
                        c1598o = new C1598o();
                        c1598o.cWq = 2;
                        c1598o = c1598o.mo5042eK(str).mo5041eJ(widgetData.query).mo5038Fp().mo5039eH(widgetData.ubs.hlm);
                        c1598o.cWt = (long) widgetData.ubs.fmr;
                        c1598o.mo5040eI(widgetData.ubv).ajK();
                    } else if (c43854a instanceof C29758c) {
                        c1598o = new C1598o();
                        c1598o.cWq = 3;
                        c1598o = c1598o.mo5042eK(str).mo5041eJ(widgetData.query).mo5038Fp().mo5039eH(widgetData.ubs.hlm);
                        c1598o.cWt = (long) widgetData.ubs.fmr;
                        c1598o.mo5040eI(widgetData.ubv).ajK();
                    }
                    AppMethodBeat.m2505o(91463);
                    return true;
                }
            }
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("open_target_weapp://")) {
            if (C46407c.m87352H(widgetData.ubs.ubC, 2)) {
                int i;
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("path");
                String queryParameter2 = parse.getQueryParameter("origin_id");
                String queryParameter3 = parse.getQueryParameter("debug_mode");
                if (TextUtils.isEmpty(queryParameter3)) {
                    i = -1;
                } else {
                    i = C5046bo.ank(queryParameter3);
                }
                c22759r.mo38348g(str2, queryParameter, queryParameter2 + "@app", i);
                AppMethodBeat.m2505o(91463);
                return false;
            }
            C46407c.m87353c(widgetData.ubs.fpS, "openApp", str);
        }
        c22759r.mo38348g(str2, str, "", -1);
        AppMethodBeat.m2505o(91463);
        return false;
    }
}
