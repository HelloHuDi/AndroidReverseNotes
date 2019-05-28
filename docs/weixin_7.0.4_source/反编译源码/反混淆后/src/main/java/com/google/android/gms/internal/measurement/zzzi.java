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
        AppMethodBeat.m2504i(3568);
        AppMethodBeat.m2505o(3568);
    }

    zzzi() {
        AppMethodBeat.m2504i(3566);
        this.zzbrp = new HashMap();
        AppMethodBeat.m2505o(3566);
    }

    private zzzi(boolean z) {
        AppMethodBeat.m2504i(3567);
        this.zzbrp = Collections.emptyMap();
        AppMethodBeat.m2505o(3567);
    }

    private static Class<?> zztd() {
        AppMethodBeat.m2504i(3564);
        try {
            Class cls = Class.forName("com.google.protobuf.Extension");
            AppMethodBeat.m2505o(3564);
            return cls;
        } catch (ClassNotFoundException e) {
            AppMethodBeat.m2505o(3564);
            return null;
        }
    }

    public static zzzi zzte() {
        AppMethodBeat.m2504i(3565);
        zzzi zztc = zzzh.zztc();
        AppMethodBeat.m2505o(3565);
        return zztc;
    }
}
