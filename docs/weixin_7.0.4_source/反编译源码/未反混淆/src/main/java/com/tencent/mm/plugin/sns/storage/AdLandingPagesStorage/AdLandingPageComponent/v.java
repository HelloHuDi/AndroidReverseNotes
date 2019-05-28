package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class v {
    public String hcx;
    public String qPj;
    public String qTL;
    public int qXp;
    public boolean qXq;
    public int qXr;
    public Map<String, String> qXs = new HashMap();
    public String uin;

    public v() {
        AppMethodBeat.i(36943);
        AppMethodBeat.o(36943);
    }

    public final String YI(String str) {
        AppMethodBeat.i(36944);
        String str2 = (String) this.qXs.get(str);
        AppMethodBeat.o(36944);
        return str2;
    }
}
