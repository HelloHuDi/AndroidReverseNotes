package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import java.util.Map;

public final class a implements n {
    public final b a(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
        b bVar = null;
        AppMethodBeat.i(118139);
        if (str != null && str.equals("abtest")) {
            e bg = d.bg(Integer.valueOf(-1879048184));
            if (bg != null) {
                bVar = bg.b(aVar);
            }
        }
        AppMethodBeat.o(118139);
        return bVar;
    }
}
