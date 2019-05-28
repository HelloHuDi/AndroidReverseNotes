package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzzi {
    private static volatile boolean zzbrm = false;
    private static final Class<?> zzbrn = zztd();
    static final zzzi zzbro = new zzzi(true);
    private final Map<Object, Object> zzbrp;

    static {
        AppMethodBeat.i(3568);
        AppMethodBeat.o(3568);
    }

    zzzi() {
        AppMethodBeat.i(3566);
        this.zzbrp = new HashMap();
        AppMethodBeat.o(3566);
    }

    private zzzi(boolean z) {
        AppMethodBeat.i(3567);
        this.zzbrp = Collections.emptyMap();
        AppMethodBeat.o(3567);
    }

    private static Class<?> zztd() {
        AppMethodBeat.i(3564);
        try {
            Class cls = Class.forName("com.google.protobuf.Extension");
            AppMethodBeat.o(3564);
            return cls;
        } catch (ClassNotFoundException e) {
            AppMethodBeat.o(3564);
            return null;
        }
    }

    public static zzzi zzte() {
        AppMethodBeat.i(3565);
        zzzi zztc = zzzh.zztc();
        AppMethodBeat.o(3565);
        return zztc;
    }
}
