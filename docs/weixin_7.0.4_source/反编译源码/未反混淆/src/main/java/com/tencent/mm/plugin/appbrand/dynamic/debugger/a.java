package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.console.b;
import java.util.ArrayList;

public final class a {
    private static com.tencent.mm.z.c.e.a hmG = new com.tencent.mm.z.c.e.a() {
        public final void I(String str, int i) {
            AppMethodBeat.i(10803);
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putInt("status", i);
            f.a("com.tencent.mm", bundle, a.class, null);
            AppMethodBeat.o(10803);
        }
    };

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(10804);
            Bundle bundle = (Bundle) obj;
            b.I(bundle.getString("id"), bundle.getInt("status"));
            AppMethodBeat.o(10804);
        }
    }

    static {
        AppMethodBeat.i(10806);
        AppMethodBeat.o(10806);
    }

    public static void c(String str, ArrayList<LogInfo> arrayList) {
        AppMethodBeat.i(10805);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putParcelableArrayList("logList", arrayList);
        com.tencent.mm.ipcinvoker.d.c.PT().k(b.jpG.getClass().getName(), bundle);
        AppMethodBeat.o(10805);
    }

    public static com.tencent.mm.z.c.e.a azQ() {
        return hmG;
    }
}
