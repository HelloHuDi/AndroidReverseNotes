package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.a;
import com.tencent.map.lib.b;
import com.tencent.map.lib.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class jg implements a {
    private gx a;
    private hf b;
    private b c;

    public jg(iz izVar, String str) {
        AppMethodBeat.i(100032);
        this.a = new ji(izVar.i(), str);
        this.b = new jf(izVar);
        this.c = new jh(izVar.i(), str);
        AppMethodBeat.o(100032);
    }

    public gx a() {
        return this.a;
    }

    public hf b() {
        return this.b;
    }

    public b c() {
        return this.c;
    }

    public c d() {
        return null;
    }
}
