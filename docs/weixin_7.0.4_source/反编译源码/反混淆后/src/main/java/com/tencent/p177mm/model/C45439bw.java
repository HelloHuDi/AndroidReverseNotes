package com.tencent.p177mm.model;

import com.tencent.map.lib.p822gl.JNI;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;

@Deprecated
/* renamed from: com.tencent.mm.model.bw */
public class C45439bw {
    static {
        AppMethodBeat.m2504i(16350);
        C1449k.m3079a(JNI.LIB_NAME, C45439bw.class.getClassLoader());
        AppMethodBeat.m2505o(16350);
    }

    /* renamed from: a */
    public final synchronized boolean mo73244a(String str, C1816at c1816at) {
        AppMethodBeat.m2504i(16348);
        C7485q mF = C7485q.m12929mF(str);
        if (mF == null) {
            mF = C7485q.m12927a(str, new C7485q(c1816at.getClass()));
        }
        mF.mo16671a(c1816at);
        AppMethodBeat.m2505o(16348);
        return true;
    }

    /* renamed from: oJ */
    public static C1816at m83697oJ(String str) {
        AppMethodBeat.m2504i(16349);
        C7485q mF = C7485q.m12929mF(str);
        if (mF == null) {
            AppMethodBeat.m2505o(16349);
            return null;
        }
        C1816at Yw = mF.mo16670Yw();
        AppMethodBeat.m2505o(16349);
        return Yw;
    }
}
