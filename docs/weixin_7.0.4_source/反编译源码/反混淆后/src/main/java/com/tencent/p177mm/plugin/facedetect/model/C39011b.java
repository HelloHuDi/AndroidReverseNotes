package com.tencent.p177mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.facedetect.model.b */
public final class C39011b {
    /* renamed from: ik */
    static boolean m66285ik(long j) {
        AppMethodBeat.m2504i(160);
        if (System.currentTimeMillis() - j > 200) {
            AppMethodBeat.m2505o(160);
            return true;
        }
        AppMethodBeat.m2505o(160);
        return false;
    }
}
