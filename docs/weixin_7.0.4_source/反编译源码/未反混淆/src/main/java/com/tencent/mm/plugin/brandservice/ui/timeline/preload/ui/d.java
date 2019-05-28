package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static Map<String, Bundle> jUF = new HashMap();

    static {
        AppMethodBeat.i(14424);
        AppMethodBeat.o(14424);
    }

    public static Bundle FZ(String str) {
        AppMethodBeat.i(14421);
        String Ga = Ga(str);
        if (jUF.containsKey(Ga)) {
            Bundle bundle = (Bundle) jUF.get(Ga);
            AppMethodBeat.o(14421);
            return bundle;
        }
        AppMethodBeat.o(14421);
        return null;
    }

    public static void m(String str, Bundle bundle) {
        AppMethodBeat.i(14422);
        if (str == null) {
            AppMethodBeat.o(14422);
            return;
        }
        jUF.put(Ga(str), bundle);
        AppMethodBeat.o(14422);
    }

    private static String Ga(String str) {
        AppMethodBeat.i(14423);
        int indexOf = str.indexOf("?");
        if (indexOf < 0) {
            AppMethodBeat.o(14423);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.o(14423);
        return str;
    }
}
