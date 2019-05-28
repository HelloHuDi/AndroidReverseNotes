package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class ar {
    public String a;
    public boolean b;
    public long c;
    public long d;
    public Map<String, String> e;
    boolean f;

    public ar(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        AppMethodBeat.i(98501);
        this.a = str;
        this.b = z;
        this.c = j;
        this.d = j2;
        if (map != null) {
            this.e = new HashMap();
            this.e.putAll(map);
        }
        this.f = z2;
        AppMethodBeat.o(98501);
    }
}
