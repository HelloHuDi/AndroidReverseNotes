package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    AUTO(0),
    MIC(1),
    CAMCORDER(5),
    VOICE_RECOGNITION(6),
    VOICE_COMMUNICATION(7),
    UNPROCESSED(9);
    
    public int ilf;

    static {
        AppMethodBeat.o(117483);
    }

    private b(int i) {
        this.ilf = i;
    }

    public static b a(String str, b bVar) {
        AppMethodBeat.i(117482);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(117482);
            return bVar;
        }
        b valueOf = valueOf(str);
        if (valueOf != null) {
            AppMethodBeat.o(117482);
            return valueOf;
        }
        AppMethodBeat.o(117482);
        return bVar;
    }
}
