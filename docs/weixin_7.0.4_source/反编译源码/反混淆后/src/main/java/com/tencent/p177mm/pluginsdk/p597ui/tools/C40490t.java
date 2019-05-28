package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.t */
public final class C40490t {
    private static List<C23347a> vvP = new ArrayList();

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.t$a */
    public interface C23347a {
        void dbp();

        void dbq();

        /* renamed from: ft */
        void mo27351ft(Context context);

        String getName();
    }

    static {
        AppMethodBeat.m2504i(79959);
        AppMethodBeat.m2505o(79959);
    }

    /* renamed from: a */
    public static void m69623a(C23347a c23347a) {
        AppMethodBeat.m2504i(79957);
        if (c23347a != null) {
            C4990ab.m7410d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + c23347a.getName());
            if (!vvP.contains(c23347a)) {
                vvP.add(c23347a);
            }
        }
        AppMethodBeat.m2505o(79957);
    }

    public static List<C23347a> dlE() {
        return vvP;
    }

    public static void clear() {
        AppMethodBeat.m2504i(79958);
        C4990ab.m7410d("MicroMsg.WebViewPluginCenter", "clear");
        vvP.clear();
        AppMethodBeat.m2505o(79958);
    }
}
