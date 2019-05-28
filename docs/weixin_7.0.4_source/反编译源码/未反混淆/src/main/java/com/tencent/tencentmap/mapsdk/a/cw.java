package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class cw {
    private String a;
    private String b;
    private int c;
    private List<cy> d;

    public cw(String str, String str2, List<cy> list, int i) {
        this.a = str;
        this.b = str2;
        this.d = list;
        this.c = i;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final List<cy> c() {
        return this.d;
    }

    public final int d() {
        return this.c;
    }

    public final String toString() {
        AppMethodBeat.i(100976);
        String str;
        if (this.a == null || this.d == null || this.d.size() <= this.c) {
            str = "";
            AppMethodBeat.o(100976);
            return str;
        }
        str = this.a + "_" + ((cy) this.d.get(this.c)).a();
        AppMethodBeat.o(100976);
        return str;
    }
}
