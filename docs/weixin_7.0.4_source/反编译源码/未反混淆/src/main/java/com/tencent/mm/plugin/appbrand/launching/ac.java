package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.sdk.e.j;

public class ac extends j<ab> {
    public static final String[] fjY = new String[]{j.a(ab.gSs, "LaunchWxaAppPBTable")};

    static {
        AppMethodBeat.i(94159);
        AppMethodBeat.o(94159);
    }

    public final boolean b(String str, axr axr) {
        AppMethodBeat.i(94158);
        if (TextUtils.isEmpty(str) || axr == null) {
            AppMethodBeat.o(94158);
            return false;
        }
        ab abVar = new ab();
        abVar.field_appId = str;
        abVar.field_launchPB = axr;
        boolean a = super.a(abVar);
        AppMethodBeat.o(94158);
        return a;
    }
}
