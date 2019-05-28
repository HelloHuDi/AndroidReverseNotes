package com.tencent.p177mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C19682k;
import com.tencent.p177mm.protocal.protobuf.axt;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.i */
public final class C19858i extends C7563j<C27420j> {
    public static final String ihX = C7563j.m13217a(C27420j.gSs, "LaunchWxaWidgetRespData");

    /* renamed from: b */
    public final /* synthetic */ boolean mo16762b(C4925c c4925c, boolean z, String[] strArr) {
        AppMethodBeat.m2504i(70656);
        boolean a = m30738a((C27420j) c4925c, z, strArr);
        AppMethodBeat.m2505o(70656);
        return a;
    }

    /* renamed from: b */
    public final /* synthetic */ boolean mo10102b(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(70657);
        boolean a = mo35082a((C27420j) c4925c, strArr);
        AppMethodBeat.m2505o(70657);
        return a;
    }

    static {
        AppMethodBeat.m2504i(70660);
        AppMethodBeat.m2505o(70660);
    }

    public C19858i(C4927e c4927e) {
        super(c4927e, C27420j.gSs, "LaunchWxaWidgetRespData", C27420j.diI);
    }

    /* renamed from: a */
    public final C27420j mo35081a(String str, int i, int i2, axt axt) {
        AppMethodBeat.m2504i(70651);
        if (C5046bo.isNullOrNil(str) || axt == null) {
            AppMethodBeat.m2505o(70651);
            return null;
        }
        int i3;
        C27420j c27420j = new C27420j();
        c27420j.field_appIdHash = str.hashCode();
        c27420j.field_appId = str;
        c27420j.field_pkgType = i;
        c27420j.field_widgetType = i2;
        int i4 = !mo35082a(c27420j, "appId", "pkgType", "widgetType") ? 1 : 0;
        if (C19682k.m30480a(c27420j.field_launchAction, axt.wBP)) {
            i3 = 0;
        } else {
            c27420j.field_launchAction = axt.wBP;
            i3 = 1;
        }
        if (!C19682k.m30480a(c27420j.field_jsApiInfo, axt.wBJ)) {
            c27420j.field_jsApiInfo = axt.wBJ;
            i3 = 1;
        }
        if (!C19682k.m30480a(c27420j.field_versionInfo, axt.wBQ)) {
            c27420j.field_versionInfo = axt.wBQ;
            i3 = 1;
        }
        if (!C19682k.m30480a(c27420j.field_widgetSetting, axt.wBR)) {
            c27420j.field_widgetSetting = axt.wBR;
            i3 = 1;
        }
        if (i3 != 0) {
            if (i4 != 0) {
                m30737a(c27420j, false);
            } else {
                m30738a(c27420j, false, "appId", "pkgType", "widgetType");
            }
        }
        if (i3 != 0) {
            mo35082a(c27420j, "appId", "pkgType", "widgetType");
        }
        AppMethodBeat.m2505o(70651);
        return c27420j;
    }

    /* renamed from: L */
    public final C27420j mo35080L(String str, int i, int i2) {
        AppMethodBeat.m2504i(70652);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(70652);
            return null;
        }
        C27420j c27420j = new C27420j();
        c27420j.field_appIdHash = str.hashCode();
        c27420j.field_appId = str;
        c27420j.field_pkgType = i;
        c27420j.field_widgetType = i2;
        if (mo35082a(c27420j, "appId", "pkgType", "widgetType")) {
            AppMethodBeat.m2505o(70652);
            return c27420j;
        }
        AppMethodBeat.m2505o(70652);
        return null;
    }

    /* renamed from: a */
    public final boolean mo35082a(C27420j c27420j, String... strArr) {
        AppMethodBeat.m2504i(70653);
        if (!C5046bo.m7510Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    c27420j.field_appIdHash = c27420j.field_appId.hashCode();
                    break;
                }
            }
        }
        boolean b = super.mo10102b((C4925c) c27420j, strArr);
        AppMethodBeat.m2505o(70653);
        return b;
    }

    /* renamed from: a */
    private boolean m30737a(C27420j c27420j, boolean z) {
        AppMethodBeat.m2504i(70654);
        c27420j.field_appIdHash = c27420j.field_appId.hashCode();
        super.mo16759a((C4925c) c27420j, z);
        boolean a = mo35082a(c27420j, "appId");
        AppMethodBeat.m2505o(70654);
        return a;
    }

    /* renamed from: a */
    private boolean m30738a(C27420j c27420j, boolean z, String... strArr) {
        AppMethodBeat.m2504i(70655);
        if (!C5046bo.m7510Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    c27420j.field_appIdHash = c27420j.field_appId.hashCode();
                    break;
                }
            }
        }
        boolean b = super.mo16762b(c27420j, z, strArr);
        AppMethodBeat.m2505o(70655);
        return b;
    }
}
