package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class p implements Comparable<p> {
    public final int a;
    public final int b;
    public final int c;

    public /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.i(98254);
        int a = a((p) obj);
        AppMethodBeat.o(98254);
        return a;
    }

    public p(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public int a(p pVar) {
        return this.a - pVar.a;
    }
}
