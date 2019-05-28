package com.tencent.map.lib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.HashMap;

public final class c<T, K> {
    private HashMap<T, K> a;
    private int b = 0;
    private int c = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;

    public final synchronized void a(T t, K k) {
        AppMethodBeat.i(98246);
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(t, k);
        AppMethodBeat.o(98246);
    }

    public final synchronized K a(T t) {
        K k;
        AppMethodBeat.i(98247);
        if (this.a == null) {
            k = null;
            AppMethodBeat.o(98247);
        } else {
            k = this.a.get(t);
            AppMethodBeat.o(98247);
        }
        return k;
    }
}
