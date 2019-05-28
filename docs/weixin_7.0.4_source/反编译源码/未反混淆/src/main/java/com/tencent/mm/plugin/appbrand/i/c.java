package com.tencent.mm.plugin.appbrand.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class c implements a {
    public final String g(Map<String, String> map, String str) {
        AppMethodBeat.i(132274);
        String str2;
        if (map == null || map.isEmpty()) {
            ab.w("MicroMsg.WxaSysTemplateMsgDigestHandler", "values map is null or nil");
            str2 = "";
            AppMethodBeat.o(132274);
            return str2;
        }
        str2 = bo.nullAsNil((String) map.get(str + ".title"));
        AppMethodBeat.o(132274);
        return str2;
    }
}
