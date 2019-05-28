package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.dynamic.f.d;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Collection;

public final class g {
    private static com.tencent.mm.network.n.a hlG = new com.tencent.mm.network.n.a() {
        public final void gl(int i) {
            AppMethodBeat.i(10692);
            Bundle bundle = new Bundle();
            bundle.putInt("status", i);
            for (String a : i.azC().azD()) {
                f.a(a, bundle, a.class, null);
            }
            AppMethodBeat.o(10692);
        }
    };

    static final class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(10693);
            Collection<c> values = d.azy().hlx.values();
            if (values == null || values.isEmpty()) {
                AppMethodBeat.o(10693);
                return;
            }
            d dVar = new d();
            String str = dVar.name;
            String jSONObject = dVar.toJSONObject().toString();
            for (c cVar2 : values) {
                if (cVar2 != null) {
                    cVar2.bJ(str, jSONObject);
                }
            }
            AppMethodBeat.o(10693);
        }
    }

    static {
        AppMethodBeat.i(10696);
        AppMethodBeat.o(10696);
    }

    public static void initialize() {
        AppMethodBeat.i(10694);
        if (ah.bqo()) {
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().a(hlG);
            AppMethodBeat.o(10694);
            return;
        }
        AppMethodBeat.o(10694);
    }

    public static void release() {
        AppMethodBeat.i(10695);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().b(hlG);
        AppMethodBeat.o(10695);
    }
}
