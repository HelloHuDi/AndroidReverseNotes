package com.tinkerboots.sdk.p688a.p1120b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitUtils;
import com.tinkerboots.sdk.p688a.p689c.C6084a;

/* renamed from: com.tinkerboots.sdk.a.b.a */
public class C36621a {
    public final C6084a AUa;

    /* renamed from: com.tinkerboots.sdk.a.b.a$a */
    static class C16441a {
        C6084a AUa;

        C16441a() {
        }
    }

    private C36621a(C6084a c6084a) {
        this.AUa = c6084a;
    }

    public static C36621a dWl() {
        AppMethodBeat.m2504i(BitUtils.BIT_TURN_ZERO_3);
        C16441a c16441a = new C16441a();
        c16441a.AUa = new C6084a();
        if (c16441a.AUa == null) {
            RuntimeException runtimeException = new RuntimeException("You need init conditions property");
            AppMethodBeat.m2505o(BitUtils.BIT_TURN_ZERO_3);
            throw runtimeException;
        }
        C36621a c36621a = new C36621a(c16441a.AUa);
        AppMethodBeat.m2505o(BitUtils.BIT_TURN_ZERO_3);
        return c36621a;
    }

    /* renamed from: iP */
    public final C6084a mo58436iP(String str, String str2) {
        AppMethodBeat.m2504i(65532);
        C6084a iQ = this.AUa.mo13444iQ(str, str2);
        AppMethodBeat.m2505o(65532);
        return iQ;
    }
}
