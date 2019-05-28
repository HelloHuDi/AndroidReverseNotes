package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.sdk.platformtools.ab;

public final class h {
    public static boolean a(chm chm, chm chm2) {
        AppMethodBeat.i(73386);
        if (chm == null || chm2 == null) {
            AppMethodBeat.o(73386);
            return false;
        } else if (TextUtils.isEmpty(chm.activityName) || TextUtils.isEmpty(chm2.activityName)) {
            AppMethodBeat.o(73386);
            return false;
        } else {
            boolean l = l(chm.activityName, chm.wkp, chm2.activityName, chm2.wkp);
            AppMethodBeat.o(73386);
            return l;
        }
    }

    public static boolean l(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(73387);
        ab.d("TokenWrapper", "habbyge-mali, TokenWrapper.equals: " + str + "=" + str2 + "/" + str3 + "=" + str4);
        boolean equals = str.equals(str3);
        AppMethodBeat.o(73387);
        return equals;
    }
}
