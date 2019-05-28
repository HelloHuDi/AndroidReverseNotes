package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class z extends ak implements Cloneable {
    private static Map<Integer, byte[]> b;
    public Map<Integer, byte[]> a = null;

    public final void a(aj ajVar) {
        AppMethodBeat.i(100571);
        ajVar.a(this.a, 0);
        AppMethodBeat.o(100571);
    }

    public final void a(ai aiVar) {
        AppMethodBeat.i(100572);
        if (b == null) {
            b = new HashMap();
            Integer valueOf = Integer.valueOf(0);
            byte[] bArr = new byte[1];
            bArr[0] = (byte) 0;
            b.put(valueOf, bArr);
        }
        this.a = (Map) aiVar.a(b, 0, true);
        AppMethodBeat.o(100572);
    }
}
