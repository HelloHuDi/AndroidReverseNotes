package com.tencent.mm.plugin.sns.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class a implements c {
    private Map<Integer, com.tencent.mm.plugin.sns.a.a.a> qCV = new HashMap();

    public a() {
        AppMethodBeat.i(35688);
        AppMethodBeat.o(35688);
    }

    public final void a(com.tencent.mm.plugin.sns.a.a.a aVar) {
        AppMethodBeat.i(35689);
        this.qCV.put(Integer.valueOf(aVar.cez()), aVar);
        AppMethodBeat.o(35689);
    }

    public final void a(int i, int i2, Object... objArr) {
        AppMethodBeat.i(35690);
        com.tencent.mm.plugin.sns.a.a.a aVar = (com.tencent.mm.plugin.sns.a.a.a) this.qCV.get(Integer.valueOf(i));
        if (aVar == null) {
            ab.w("SnsAdReportService", "can not find %s implementation for kv %d", com.tencent.mm.plugin.sns.a.a.a.class, Integer.valueOf(i));
            AppMethodBeat.o(35690);
            return;
        }
        aVar.e(i2, objArr);
        AppMethodBeat.o(35690);
    }

    public final void e(int i, Object... objArr) {
        AppMethodBeat.i(35691);
        com.tencent.mm.plugin.sns.a.a.a aVar = (com.tencent.mm.plugin.sns.a.a.a) this.qCV.get(Integer.valueOf(i));
        if (aVar == null) {
            ab.w("SnsAdReportService", "can not find %s implementation for kv %d", com.tencent.mm.plugin.sns.a.a.a.class, Integer.valueOf(i));
            AppMethodBeat.o(35691);
            return;
        }
        aVar.t(objArr);
        AppMethodBeat.o(35691);
    }
}
