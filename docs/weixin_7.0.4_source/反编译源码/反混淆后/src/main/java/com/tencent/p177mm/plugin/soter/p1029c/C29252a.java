package com.tencent.p177mm.plugin.soter.p1029c;

import android.app.Activity;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.soter.p528d.C39856k;
import com.tencent.p177mm.plugin.soter.p528d.C46263j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.soter.core.C40997a;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.soter.c.a */
public enum C29252a {
    ;

    private C29252a(String str) {
    }

    static {
        AppMethodBeat.m2505o(73863);
    }

    /* renamed from: a */
    public static C46260c m46445a(Activity activity, C46263j c46263j, C39856k c39856k, Handler handler) {
        AppMethodBeat.m2504i(73862);
        if ((c46263j.rOi & 1) == 0 || !C40997a.m71097iP(C4996ah.getContext())) {
            C4990ab.m7413e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", Byte.valueOf(c46263j.rOi));
            AppMethodBeat.m2505o(73862);
            return null;
        }
        C43614b c43614b = new C43614b(new WeakReference(activity), c46263j, c39856k, handler);
        AppMethodBeat.m2505o(73862);
        return c43614b;
    }
}
