package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum f {
    ;
    
    public Map<String, a> iBf;

    public static final class a {
        public long iBh;
        public long iBi;

        private a() {
            this.iBh = -1;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private f(String str) {
        AppMethodBeat.i(132612);
        this.iBf = new HashMap();
        AppMethodBeat.o(132612);
    }

    static {
        AppMethodBeat.o(132613);
    }
}
