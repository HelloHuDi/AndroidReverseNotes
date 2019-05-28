package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.da;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private da kVn = new da();
    public final Map<String, Integer> kVo = new HashMap();

    public e() {
        AppMethodBeat.i(53045);
        AppMethodBeat.o(53045);
    }

    public final void g(String str, int i, int i2, String str2) {
        AppMethodBeat.i(53046);
        this.kVn.cwf.cwg = str;
        this.kVn.cwf.status = i;
        this.kVn.cwf.progress = i2;
        this.kVn.cwf.cwh = str2;
        a.xxA.m(this.kVn);
        if (i != 6) {
            this.kVo.remove(str);
            AppMethodBeat.o(53046);
        } else if (i2 < 0 || i2 >= 100) {
            this.kVo.remove(str);
            AppMethodBeat.o(53046);
        } else {
            this.kVo.put(str, Integer.valueOf(i2));
            AppMethodBeat.o(53046);
        }
    }
}
