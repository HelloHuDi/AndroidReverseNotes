package com.tencent.p177mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.m */
public final class C33639m extends C7563j<C33638l> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C33638l.fjX, "WxaWidgetInfo")};
    public static final String[] fjZ = new String[0];

    static {
        AppMethodBeat.m2504i(70664);
        AppMethodBeat.m2505o(70664);
    }

    public C33639m(C4927e c4927e) {
        super(c4927e, C33638l.fjX, "WxaWidgetInfo", fjZ);
    }

    /* renamed from: Ev */
    public final C33638l mo54196Ev(String str) {
        AppMethodBeat.m2504i(70663);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(70663);
            return null;
        }
        C33638l c33638l = new C33638l();
        c33638l.field_appId = str;
        c33638l.field_appIdHash = str.hashCode();
        if (mo10102b((C4925c) c33638l, "appIdHash")) {
            AppMethodBeat.m2505o(70663);
            return c33638l;
        }
        AppMethodBeat.m2505o(70663);
        return null;
    }
}
