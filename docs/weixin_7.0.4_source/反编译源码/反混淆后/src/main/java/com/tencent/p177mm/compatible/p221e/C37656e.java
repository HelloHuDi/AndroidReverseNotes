package com.tencent.p177mm.compatible.p221e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;

/* renamed from: com.tencent.mm.compatible.e.e */
final class C37656e implements C32469a {
    C37656e() {
    }

    /* renamed from: b */
    public static C32470a m63679b(Looper looper) {
        AppMethodBeat.m2504i(92927);
        C32470a c32470a = new C32470a();
        try {
            c32470a.erH = C41939u.m74076c(looper);
            c32470a.rotate = 0;
            if (c32470a.erH == null) {
                AppMethodBeat.m2505o(92927);
                return null;
            }
            AppMethodBeat.m2505o(92927);
            return c32470a;
        } catch (Exception e) {
            AppMethodBeat.m2505o(92927);
            return null;
        }
    }
}
