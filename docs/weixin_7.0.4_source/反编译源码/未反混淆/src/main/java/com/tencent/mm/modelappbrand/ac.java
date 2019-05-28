package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ac implements ab {
    private f fpV;
    protected Map<String, m> fpW = new HashMap();

    public ac(f fVar) {
        AppMethodBeat.i(70643);
        this.fpV = fVar;
        AppMethodBeat.o(70643);
    }

    public ac(ab abVar) {
        AppMethodBeat.i(70644);
        if (abVar == null) {
            AppMethodBeat.o(70644);
            return;
        }
        this.fpV = abVar.abN();
        a(abVar);
        AppMethodBeat.o(70644);
    }

    private void a(ab abVar) {
        AppMethodBeat.i(70645);
        for (m a : abVar.abO()) {
            a(a);
        }
        AppMethodBeat.o(70645);
    }

    public final f abN() {
        return this.fpV;
    }

    public final <T> T px(String str) {
        AppMethodBeat.i(70646);
        Object obj = this.fpW.get(str);
        AppMethodBeat.o(70646);
        return obj;
    }

    public final void a(m mVar) {
        AppMethodBeat.i(70647);
        this.fpW.put(mVar.getName(), mVar);
        AppMethodBeat.o(70647);
    }

    public final List<m> abO() {
        AppMethodBeat.i(70648);
        ArrayList arrayList = new ArrayList(this.fpW.values());
        AppMethodBeat.o(70648);
        return arrayList;
    }
}
