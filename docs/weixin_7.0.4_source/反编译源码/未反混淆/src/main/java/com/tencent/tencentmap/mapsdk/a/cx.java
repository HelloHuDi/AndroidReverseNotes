package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cx {
    private String a;
    private String b;

    public cx(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String toString() {
        AppMethodBeat.i(100977);
        String str = this.a + "_" + this.b;
        AppMethodBeat.o(100977);
        return str;
    }
}
