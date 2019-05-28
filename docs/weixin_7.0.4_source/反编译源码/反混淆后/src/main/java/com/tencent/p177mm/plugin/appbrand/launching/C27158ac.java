package com.tencent.p177mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.axr;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.ac */
public class C27158ac extends C7563j<C10580ab> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C10580ab.gSs, "LaunchWxaAppPBTable")};

    static {
        AppMethodBeat.m2504i(94159);
        AppMethodBeat.m2505o(94159);
    }

    /* renamed from: b */
    public final boolean mo44832b(String str, axr axr) {
        AppMethodBeat.m2504i(94158);
        if (TextUtils.isEmpty(str) || axr == null) {
            AppMethodBeat.m2505o(94158);
            return false;
        }
        C10580ab c10580ab = new C10580ab();
        c10580ab.field_appId = str;
        c10580ab.field_launchPB = axr;
        boolean a = super.mo10099a(c10580ab);
        AppMethodBeat.m2505o(94158);
        return a;
    }
}
