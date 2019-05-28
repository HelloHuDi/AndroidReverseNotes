package com.tencent.d.d.a;

import com.tencent.d.d.b.d.a;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class g implements b {
    private final List<a> Atc = new ArrayList();
    private final Pattern yNM = Pattern.compile("^/system/xbin/ku\\.sud$|^daemonsu:|^k_worker/[1-9]\\d*:[1-9]\\d*$|^kr_worker/[1-9]\\d*:[1-9]\\d*$|^km_worker/[1-9]\\d*:[1-9]\\d*$|^tworker/[1-9]\\d*:[1-9]\\d*$|^tu_worker/[1-9]\\d*:[1-9]\\d*$|^tq_worker/[1-9]\\d*:[1-9]\\d*$|^kworker/[1-9]\\d{2}$|^permmgrd$|^360sguard$|^/data/data/[\\w\\-\\.]+/");

    public g() {
        AppMethodBeat.i(114512);
        AppMethodBeat.o(114512);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(114513);
        if (aVar.uid != 0) {
            AppMethodBeat.o(114513);
        } else if (aVar.Atj != 1) {
            AppMethodBeat.o(114513);
        } else {
            this.Atc.add(aVar);
            AppMethodBeat.o(114513);
        }
    }

    public final boolean dQl() {
        AppMethodBeat.i(114514);
        for (a aVar : this.Atc) {
            new StringBuilder("SingleProcessAnalyzer : ").append(aVar.toString());
            h.dQH();
            if (aVar.name != null && this.yNM.matcher(aVar.name).find()) {
                new StringBuilder("SingleProcessAnalyzer match : ").append(aVar.toString());
                h.dQG();
                AppMethodBeat.o(114514);
                return true;
            }
        }
        AppMethodBeat.o(114514);
        return false;
    }
}
