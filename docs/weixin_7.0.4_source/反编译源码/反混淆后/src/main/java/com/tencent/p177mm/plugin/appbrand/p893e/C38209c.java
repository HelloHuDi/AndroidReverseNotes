package com.tencent.p177mm.plugin.appbrand.p893e;

import com.tencent.luggage.p817i.p818a.C17823c;
import com.tencent.luggage.p817i.p818a.C45125d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p318a.C45623a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b.C27116c;

/* renamed from: com.tencent.mm.plugin.appbrand.e.c */
public final class C38209c implements C45125d<C24693g> {
    public static C38209c hpL;

    /* renamed from: bS */
    public final /* synthetic */ C17823c mo60948bS(String str) {
        AppMethodBeat.m2504i(117338);
        Object obj = -1;
        switch (str.hashCode()) {
            case 107868:
                if (str.equals("map")) {
                    obj = 1;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    obj = null;
                    break;
                }
                break;
        }
        C17823c c27116c;
        switch (obj) {
            case null:
                c27116c = new C27116c();
                AppMethodBeat.m2505o(117338);
                return c27116c;
            case 1:
                c27116c = new C45623a();
                AppMethodBeat.m2505o(117338);
                return c27116c;
            default:
                AppMethodBeat.m2505o(117338);
                return null;
        }
    }
}
