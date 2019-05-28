package com.tinkerboots.sdk.p688a.p689c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tinkerboots.sdk.a.c.a */
public final class C6084a {
    public final Map<String, String> AUb = new HashMap();

    public C6084a() {
        AppMethodBeat.m2504i(BitUtils.BIT_TURN_ZERO_2);
        AppMethodBeat.m2505o(BitUtils.BIT_TURN_ZERO_2);
    }

    /* renamed from: iQ */
    public final C6084a mo13444iQ(String str, String str2) {
        AppMethodBeat.m2504i(BitUtils.BIT_TURN_ZERO_1);
        this.AUb.put(str, str2);
        AppMethodBeat.m2505o(BitUtils.BIT_TURN_ZERO_1);
        return this;
    }
}
