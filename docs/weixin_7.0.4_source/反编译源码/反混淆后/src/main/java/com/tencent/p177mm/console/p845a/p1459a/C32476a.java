package com.tencent.p177mm.console.p845a.p1459a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.hardcoder.C34331a;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.console.a.a.a */
public final class C32476a implements C44041a {
    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(16152);
        if (strArr.length <= 1) {
            AppMethodBeat.m2505o(16152);
            return false;
        }
        if (C5046bo.getInt(strArr[1], 0) > 0) {
            C34331a.nqe = true;
        } else {
            C34331a.nqe = false;
        }
        AppMethodBeat.m2505o(16152);
        return true;
    }
}
