package com.tencent.p177mm.plugin.appbrand.p884c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.c.c */
public final class C19128c {
    public HashMap<String, C19127a> hez = new HashMap();

    public C19128c() {
        AppMethodBeat.m2504i(129824);
        AppMethodBeat.m2505o(129824);
    }

    /* renamed from: a */
    public final void mo34339a(C19127a c19127a) {
        AppMethodBeat.m2504i(129825);
        if (c19127a == null || C5046bo.isNullOrNil(c19127a.czD)) {
            C4990ab.m7412e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
            AppMethodBeat.m2505o(129825);
            return;
        }
        C4990ab.m7417i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", c19127a.czD, c19127a.heo);
        this.hez.put(c19127a.czD, c19127a);
        AppMethodBeat.m2505o(129825);
    }

    /* renamed from: yE */
    public final C19127a mo34340yE(String str) {
        AppMethodBeat.m2504i(129826);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
            AppMethodBeat.m2505o(129826);
            return null;
        }
        C19127a c19127a = (C19127a) this.hez.get(str);
        AppMethodBeat.m2505o(129826);
        return c19127a;
    }
}
