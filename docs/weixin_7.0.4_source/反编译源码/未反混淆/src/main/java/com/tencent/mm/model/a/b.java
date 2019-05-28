package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b {
    public String eyp;
    public String fnS;
    public String fnT;
    public String fnU;
    public HashMap<String, e> fnV = new HashMap();

    public b() {
        AppMethodBeat.i(118140);
        AppMethodBeat.o(118140);
    }

    public final e oP(String str) {
        AppMethodBeat.i(118141);
        if (this.fnV == null || !this.fnV.containsKey(str)) {
            AppMethodBeat.o(118141);
            return null;
        }
        e eVar = (e) this.fnV.get(str);
        AppMethodBeat.o(118141);
        return eVar;
    }
}
