package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;

public final class l {
    public HashMap<String, a> upC = new HashMap();
    public HashMap<String, a> upD = new HashMap();
    private HashSet<Integer> upE = new HashSet();

    public static class a {
        public String desc;
        public String link;
        public String rid;
        public String title;
    }

    public l() {
        AppMethodBeat.i(7031);
        AppMethodBeat.o(7031);
    }

    public final void bE(int i, String str) {
        AppMethodBeat.i(7032);
        if (bo.getBoolean(str, false)) {
            this.upE.add(Integer.valueOf(i));
            AppMethodBeat.o(7032);
            return;
        }
        this.upE.remove(Integer.valueOf(i));
        AppMethodBeat.o(7032);
    }

    public final boolean IS(int i) {
        AppMethodBeat.i(7033);
        boolean remove = this.upE.remove(Integer.valueOf(i));
        AppMethodBeat.o(7033);
        return remove;
    }
}
