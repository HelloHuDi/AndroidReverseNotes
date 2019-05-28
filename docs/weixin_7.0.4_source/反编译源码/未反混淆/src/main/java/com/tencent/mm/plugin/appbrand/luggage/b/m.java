package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.LinkedList;
import java.util.List;

public final class m implements b {
    private List<b> ikl = new LinkedList();

    public m(i iVar) {
        AppMethodBeat.i(86994);
        this.ikl.add(new o(iVar));
        this.ikl.add(new j(iVar));
        AppMethodBeat.o(86994);
    }

    public final boolean a(c cVar, String str) {
        AppMethodBeat.i(86995);
        if (cVar == null || str == null || str.length() == 0) {
            AppMethodBeat.o(86995);
            return false;
        }
        for (b a : this.ikl) {
            if (a.a(cVar, str)) {
                AppMethodBeat.o(86995);
                return true;
            }
        }
        AppMethodBeat.o(86995);
        return false;
    }

    public final String b(c cVar, String str) {
        AppMethodBeat.i(86996);
        if (cVar == null || str == null || str.length() == 0) {
            AppMethodBeat.o(86996);
            return str;
        }
        for (b bVar : this.ikl) {
            if (bVar.a(cVar, str)) {
                str = bVar.b(cVar, str);
                AppMethodBeat.o(86996);
                return str;
            }
        }
        AppMethodBeat.o(86996);
        return str;
    }
}
