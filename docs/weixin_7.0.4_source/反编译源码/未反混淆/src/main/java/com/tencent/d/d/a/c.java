package com.tencent.d.d.a;

import android.text.TextUtils;
import com.tencent.d.d.b.d.a;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c implements b {
    private final List<a> Atc = new ArrayList();

    public c() {
        AppMethodBeat.i(114503);
        AppMethodBeat.o(114503);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(114504);
        if (aVar.uid != 0) {
            AppMethodBeat.o(114504);
        } else if (TextUtils.isEmpty(aVar.Atk) || !"u:r:zygote:s0".equals(aVar.Atk)) {
            AppMethodBeat.o(114504);
        } else if (TextUtils.isEmpty(aVar.name) || "zygote".equals(aVar.name) || "zygote64".equals(aVar.name)) {
            AppMethodBeat.o(114504);
        } else {
            new StringBuilder("JavaProcessAnalyzer match : ").append(aVar.toString());
            h.dQG();
            this.Atc.add(aVar);
            AppMethodBeat.o(114504);
        }
    }

    public final boolean dQl() {
        AppMethodBeat.i(114505);
        if (this.Atc.size() > 0) {
            AppMethodBeat.o(114505);
            return true;
        }
        AppMethodBeat.o(114505);
        return false;
    }
}
