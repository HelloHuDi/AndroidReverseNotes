package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v */
public final class C46234v {
    public String hcx;
    public String qPj;
    public String qTL;
    public int qXp;
    public boolean qXq;
    public int qXr;
    public Map<String, String> qXs = new HashMap();
    public String uin;

    public C46234v() {
        AppMethodBeat.m2504i(36943);
        AppMethodBeat.m2505o(36943);
    }

    /* renamed from: YI */
    public final String mo74248YI(String str) {
        AppMethodBeat.m2504i(36944);
        String str2 = (String) this.qXs.get(str);
        AppMethodBeat.m2505o(36944);
        return str2;
    }
}
