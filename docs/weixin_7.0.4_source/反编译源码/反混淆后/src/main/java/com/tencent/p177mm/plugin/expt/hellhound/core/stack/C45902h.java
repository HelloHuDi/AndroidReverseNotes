package com.tencent.p177mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.chm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.stack.h */
public final class C45902h {
    /* renamed from: a */
    public static boolean m85094a(chm chm, chm chm2) {
        AppMethodBeat.m2504i(73386);
        if (chm == null || chm2 == null) {
            AppMethodBeat.m2505o(73386);
            return false;
        } else if (TextUtils.isEmpty(chm.activityName) || TextUtils.isEmpty(chm2.activityName)) {
            AppMethodBeat.m2505o(73386);
            return false;
        } else {
            boolean l = C45902h.m85095l(chm.activityName, chm.wkp, chm2.activityName, chm2.wkp);
            AppMethodBeat.m2505o(73386);
            return l;
        }
    }

    /* renamed from: l */
    public static boolean m85095l(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(73387);
        C4990ab.m7410d("TokenWrapper", "habbyge-mali, TokenWrapper.equals: " + str + "=" + str2 + "/" + str3 + "=" + str4);
        boolean equals = str.equals(str3);
        AppMethodBeat.m2505o(73387);
        return equals;
    }
}
