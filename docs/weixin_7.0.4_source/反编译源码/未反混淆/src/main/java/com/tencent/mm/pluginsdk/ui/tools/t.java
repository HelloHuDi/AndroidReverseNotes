package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class t {
    private static List<a> vvP = new ArrayList();

    public interface a {
        void dbp();

        void dbq();

        void ft(Context context);

        String getName();
    }

    static {
        AppMethodBeat.i(79959);
        AppMethodBeat.o(79959);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(79957);
        if (aVar != null) {
            ab.d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + aVar.getName());
            if (!vvP.contains(aVar)) {
                vvP.add(aVar);
            }
        }
        AppMethodBeat.o(79957);
    }

    public static List<a> dlE() {
        return vvP;
    }

    public static void clear() {
        AppMethodBeat.i(79958);
        ab.d("MicroMsg.WebViewPluginCenter", "clear");
        vvP.clear();
        AppMethodBeat.o(79958);
    }
}
