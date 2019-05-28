package com.tencent.d.d.a;

import com.tencent.d.d.b.d.a;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class d implements b {
    private final HashSet<Integer> Atd = new HashSet();
    private final List<a> Ate = new ArrayList();

    public d() {
        AppMethodBeat.i(114506);
        AppMethodBeat.o(114506);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(114507);
        if (aVar.uid != 0) {
            AppMethodBeat.o(114507);
        } else if (aVar.Atj != 1 || "/sbin/adbd".equals(aVar.name)) {
            if (aVar.Atj > 1 && "sh".equals(aVar.name) && "/system/bin/sh".equals(aVar.name)) {
                new StringBuilder("ProcessRelationAnalyzer child : ").append(aVar.toString());
                h.dQH();
                this.Ate.add(aVar);
            }
            AppMethodBeat.o(114507);
        } else {
            new StringBuilder("ProcessRelationAnalyzer parent : ").append(aVar.toString());
            h.dQH();
            this.Atd.add(Integer.valueOf(aVar.pid));
            AppMethodBeat.o(114507);
        }
    }

    public final boolean dQl() {
        AppMethodBeat.i(114508);
        for (a aVar : this.Ate) {
            if (this.Atd.contains(Integer.valueOf(aVar.Atj))) {
                new StringBuilder("ProcessRelationAnalyzer match : ").append(aVar.toString());
                h.dQG();
                AppMethodBeat.o(114508);
                return true;
            }
        }
        AppMethodBeat.o(114508);
        return false;
    }
}
