package com.tencent.p177mm.audio.mix.p831d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1458g.C32318b;
import com.tencent.p177mm.audio.mix.p832f.C45172d;

/* renamed from: com.tencent.mm.audio.mix.d.f */
public final class C45167f {
    /* renamed from: a */
    public static C17959k m83175a(C45172d c45172d, C32318b c32318b, boolean z) {
        C17959k c32315d;
        AppMethodBeat.m2504i(137073);
        if (c32318b.mo53051Ev().ckA) {
            c32315d = new C32315d(c45172d, c32318b);
        } else {
            c32315d = new C17957e(c45172d, c32318b);
        }
        c32315d.init();
        if (z) {
            c32315d.mo20514Dw();
        }
        AppMethodBeat.m2505o(137073);
        return c32315d;
    }
}
