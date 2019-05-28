package com.tencent.p177mm.p181af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

/* renamed from: com.tencent.mm.af.n */
public final class C32222n {
    public int fjt;
    public int fju;

    /* renamed from: mj */
    public static final C32222n m52572mj(String str) {
        AppMethodBeat.m2504i(16198);
        C32222n c32222n = new C32222n();
        C8910b X = C8910b.m16058X(str, null);
        if (X != null) {
            Map map = X.fjf;
            if (map != null) {
                c32222n.fjt = C5046bo.getInt((String) map.get(".msg.appmsg.xmlfulllen"), 0);
                c32222n.fju = C5046bo.getInt((String) map.get(".msg.appmsg.realinnertype"), 0);
            }
        }
        AppMethodBeat.m2505o(16198);
        return c32222n;
    }
}
