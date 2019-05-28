package com.tencent.mm.plugin.appbrand.dynamic;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class i {
    private static final i hlI = new i();
    private Map<String, String> hlH = new HashMap();

    static {
        AppMethodBeat.i(10702);
        AppMethodBeat.o(10702);
    }

    public static i azC() {
        return hlI;
    }

    public i() {
        AppMethodBeat.i(10697);
        AppMethodBeat.o(10697);
    }

    public final void bK(String str, String str2) {
        AppMethodBeat.i(10698);
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(10698);
            return;
        }
        this.hlH.put(str, str2);
        AppMethodBeat.o(10698);
    }

    public final String zV(String str) {
        AppMethodBeat.i(10699);
        String str2 = (String) this.hlH.get(str);
        AppMethodBeat.o(10699);
        return str2;
    }

    public final void zW(String str) {
        AppMethodBeat.i(10700);
        this.hlH.remove(str);
        AppMethodBeat.o(10700);
    }

    public final Collection<String> azD() {
        AppMethodBeat.i(10701);
        Collection values = this.hlH.values();
        AppMethodBeat.o(10701);
        return values;
    }
}
