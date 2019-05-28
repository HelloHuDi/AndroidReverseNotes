package com.tencent.p177mm.plugin.appbrand.p896i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e.C12516a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.i.c */
public final class C38239c implements C12516a {
    /* renamed from: g */
    public final String mo24443g(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(132274);
        String str2;
        if (map == null || map.isEmpty()) {
            C4990ab.m7420w("MicroMsg.WxaSysTemplateMsgDigestHandler", "values map is null or nil");
            str2 = "";
            AppMethodBeat.m2505o(132274);
            return str2;
        }
        str2 = C5046bo.nullAsNil((String) map.get(str + ".title"));
        AppMethodBeat.m2505o(132274);
        return str2;
    }
}
