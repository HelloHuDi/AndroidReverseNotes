package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ff extends fj {
    int b;

    public final /* synthetic */ ey a() {
        AppMethodBeat.i(98883);
        ff b = b();
        AppMethodBeat.o(98883);
        return b;
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(98884);
        ff b = b();
        AppMethodBeat.o(98884);
        return b;
    }

    public final void a(int i) {
        AppMethodBeat.i(98875);
        if (this.e != null) {
            fg fgVar = this.e[0];
            this.f.remove(Integer.valueOf(fgVar.b()));
            this.f.put(Integer.valueOf(i), fgVar);
        }
        this.b = i;
        AppMethodBeat.o(98875);
    }

    private ff(ex exVar, int i) {
        super(exVar);
        AppMethodBeat.i(98876);
        a(i);
        AppMethodBeat.o(98876);
    }

    public static ff a(ex exVar, int i, double... dArr) {
        AppMethodBeat.i(98877);
        ff ffVar = new ff(exVar, i);
        ffVar.a(dArr);
        AppMethodBeat.o(98877);
        return ffVar;
    }

    public static ff a(ex exVar, int i, fi fiVar, Object... objArr) {
        AppMethodBeat.i(98878);
        ff ffVar = new ff(exVar, i);
        ffVar.a(objArr);
        ffVar.a(fiVar);
        AppMethodBeat.o(98878);
        return ffVar;
    }

    public final void a(double... dArr) {
        AppMethodBeat.i(98879);
        if (this.e == null || this.e.length == 0) {
            a(fg.a(this.b, dArr));
            AppMethodBeat.o(98879);
            return;
        }
        super.a(dArr);
        AppMethodBeat.o(98879);
    }

    public final void a(Object... objArr) {
        AppMethodBeat.i(98880);
        if (this.e == null || this.e.length == 0) {
            a(fg.a(this.b, null, objArr));
            AppMethodBeat.o(98880);
            return;
        }
        super.a(objArr);
        AppMethodBeat.o(98880);
    }

    public final ff b() {
        AppMethodBeat.i(98881);
        ff ffVar = (ff) super.a();
        AppMethodBeat.o(98881);
        return ffVar;
    }

    public final String toString() {
        AppMethodBeat.i(98882);
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.g;
        if (this.e != null) {
            for (fg fgVar : this.e) {
                str = str + "\n    " + fgVar.toString();
            }
        }
        AppMethodBeat.o(98882);
        return str;
    }
}
