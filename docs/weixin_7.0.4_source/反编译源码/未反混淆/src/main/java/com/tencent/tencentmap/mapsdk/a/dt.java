package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dt {
    public byte[] a;
    public String b = "GBK";

    public String toString() {
        AppMethodBeat.i(101110);
        String str;
        try {
            str = new String(this.a, this.b);
            AppMethodBeat.o(101110);
            return str;
        } catch (Exception e) {
            str = "";
            AppMethodBeat.o(101110);
            return str;
        }
    }
}
