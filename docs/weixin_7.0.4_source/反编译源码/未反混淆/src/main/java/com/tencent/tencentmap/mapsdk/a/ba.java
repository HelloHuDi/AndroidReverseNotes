package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class ba {
    private cc a = null;

    public ba(cc ccVar) {
        this.a = ccVar;
    }

    public void a() {
        if (this.a != null) {
            this.a = null;
        }
    }

    public final dj a(dk dkVar) {
        AppMethodBeat.i(100727);
        if (this.a == null) {
            AppMethodBeat.o(100727);
            return null;
        }
        dj a = this.a.a(dkVar, this);
        AppMethodBeat.o(100727);
        return a;
    }

    public final void a(String str) {
        AppMethodBeat.i(100728);
        if (this.a == null) {
            AppMethodBeat.o(100728);
            return;
        }
        this.a.a(str);
        AppMethodBeat.o(100728);
    }

    public final void a(String str, int i) {
        AppMethodBeat.i(100729);
        if (this.a == null) {
            AppMethodBeat.o(100729);
            return;
        }
        this.a.a(str, i);
        AppMethodBeat.o(100729);
    }

    public final void a(String str, List<db> list) {
        AppMethodBeat.i(100730);
        if (this.a == null) {
            AppMethodBeat.o(100730);
            return;
        }
        this.a.a(str, (List) list);
        AppMethodBeat.o(100730);
    }

    public final void b(String str, int i) {
        AppMethodBeat.i(100731);
        if (this.a == null) {
            AppMethodBeat.o(100731);
            return;
        }
        this.a.b(str, i);
        AppMethodBeat.o(100731);
    }

    public final void a(String str, float f) {
        AppMethodBeat.i(100732);
        if (this.a == null) {
            AppMethodBeat.o(100732);
            return;
        }
        this.a.a(str, f);
        AppMethodBeat.o(100732);
    }

    public final void a(String str, boolean z) {
        AppMethodBeat.i(100733);
        if (this.a == null) {
            AppMethodBeat.o(100733);
            return;
        }
        this.a.a(str, z);
        AppMethodBeat.o(100733);
    }

    public final void b(String str, float f) {
        AppMethodBeat.i(100734);
        if (this.a == null) {
            AppMethodBeat.o(100734);
            return;
        }
        this.a.b(str, f);
        AppMethodBeat.o(100734);
    }

    public final void b() {
        AppMethodBeat.i(100735);
        if (this.a == null) {
            AppMethodBeat.o(100735);
            return;
        }
        this.a.b();
        AppMethodBeat.o(100735);
    }

    public List<j> b(String str) {
        AppMethodBeat.i(100736);
        if (this.a != null) {
            List b = this.a.b(str);
            AppMethodBeat.o(100736);
            return b;
        }
        AppMethodBeat.o(100736);
        return null;
    }

    public void c(String str, int i) {
        AppMethodBeat.i(100737);
        if (this.a == null) {
            AppMethodBeat.o(100737);
            return;
        }
        this.a.c(str, i);
        AppMethodBeat.o(100737);
    }
}
