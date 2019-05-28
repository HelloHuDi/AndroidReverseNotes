package com.tinkerboots.sdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitUtils;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public final Map<String, String> AUb = new HashMap();

    public a() {
        AppMethodBeat.i(BitUtils.BIT_TURN_ZERO_2);
        AppMethodBeat.o(BitUtils.BIT_TURN_ZERO_2);
    }

    public final a iQ(String str, String str2) {
        AppMethodBeat.i(BitUtils.BIT_TURN_ZERO_1);
        this.AUb.put(str, str2);
        AppMethodBeat.o(BitUtils.BIT_TURN_ZERO_1);
        return this;
    }
}
