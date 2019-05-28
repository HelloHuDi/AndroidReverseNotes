package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.k;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class i extends j<j> {
    public static final String ihX = j.a(j.gSs, "LaunchWxaWidgetRespData");

    public final /* synthetic */ boolean b(c cVar, boolean z, String[] strArr) {
        AppMethodBeat.i(70656);
        boolean a = a((j) cVar, z, strArr);
        AppMethodBeat.o(70656);
        return a;
    }

    public final /* synthetic */ boolean b(c cVar, String[] strArr) {
        AppMethodBeat.i(70657);
        boolean a = a((j) cVar, strArr);
        AppMethodBeat.o(70657);
        return a;
    }

    static {
        AppMethodBeat.i(70660);
        AppMethodBeat.o(70660);
    }

    public i(e eVar) {
        super(eVar, j.gSs, "LaunchWxaWidgetRespData", j.diI);
    }

    public final j a(String str, int i, int i2, axt axt) {
        AppMethodBeat.i(70651);
        if (bo.isNullOrNil(str) || axt == null) {
            AppMethodBeat.o(70651);
            return null;
        }
        int i3;
        j jVar = new j();
        jVar.field_appIdHash = str.hashCode();
        jVar.field_appId = str;
        jVar.field_pkgType = i;
        jVar.field_widgetType = i2;
        int i4 = !a(jVar, "appId", "pkgType", "widgetType") ? 1 : 0;
        if (k.a(jVar.field_launchAction, axt.wBP)) {
            i3 = 0;
        } else {
            jVar.field_launchAction = axt.wBP;
            i3 = 1;
        }
        if (!k.a(jVar.field_jsApiInfo, axt.wBJ)) {
            jVar.field_jsApiInfo = axt.wBJ;
            i3 = 1;
        }
        if (!k.a(jVar.field_versionInfo, axt.wBQ)) {
            jVar.field_versionInfo = axt.wBQ;
            i3 = 1;
        }
        if (!k.a(jVar.field_widgetSetting, axt.wBR)) {
            jVar.field_widgetSetting = axt.wBR;
            i3 = 1;
        }
        if (i3 != 0) {
            if (i4 != 0) {
                a(jVar, false);
            } else {
                a(jVar, false, "appId", "pkgType", "widgetType");
            }
        }
        if (i3 != 0) {
            a(jVar, "appId", "pkgType", "widgetType");
        }
        AppMethodBeat.o(70651);
        return jVar;
    }

    public final j L(String str, int i, int i2) {
        AppMethodBeat.i(70652);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(70652);
            return null;
        }
        j jVar = new j();
        jVar.field_appIdHash = str.hashCode();
        jVar.field_appId = str;
        jVar.field_pkgType = i;
        jVar.field_widgetType = i2;
        if (a(jVar, "appId", "pkgType", "widgetType")) {
            AppMethodBeat.o(70652);
            return jVar;
        }
        AppMethodBeat.o(70652);
        return null;
    }

    public final boolean a(j jVar, String... strArr) {
        AppMethodBeat.i(70653);
        if (!bo.Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    jVar.field_appIdHash = jVar.field_appId.hashCode();
                    break;
                }
            }
        }
        boolean b = super.b((c) jVar, strArr);
        AppMethodBeat.o(70653);
        return b;
    }

    private boolean a(j jVar, boolean z) {
        AppMethodBeat.i(70654);
        jVar.field_appIdHash = jVar.field_appId.hashCode();
        super.a((c) jVar, z);
        boolean a = a(jVar, "appId");
        AppMethodBeat.o(70654);
        return a;
    }

    private boolean a(j jVar, boolean z, String... strArr) {
        AppMethodBeat.i(70655);
        if (!bo.Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    jVar.field_appIdHash = jVar.field_appId.hashCode();
                    break;
                }
            }
        }
        boolean b = super.b(jVar, z, strArr);
        AppMethodBeat.o(70655);
        return b;
    }
}
