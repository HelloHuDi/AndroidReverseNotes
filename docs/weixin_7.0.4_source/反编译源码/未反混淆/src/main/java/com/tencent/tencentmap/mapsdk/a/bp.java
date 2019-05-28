package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class bp {
    private bu a = null;

    public bp(bu buVar) {
        this.a = buVar;
    }

    public final void a() {
        if (this.a != null) {
            this.a = null;
        }
    }

    public final cq a(cr crVar) {
        AppMethodBeat.i(100858);
        if (this.a == null) {
            AppMethodBeat.o(100858);
            return null;
        }
        cq a = this.a.a(crVar, this);
        AppMethodBeat.o(100858);
        return a;
    }

    public final void a(String str) {
        AppMethodBeat.i(100859);
        if (this.a == null) {
            AppMethodBeat.o(100859);
            return;
        }
        this.a.a(str);
        AppMethodBeat.o(100859);
    }

    public final void a(String str, db dbVar) {
        AppMethodBeat.i(100860);
        if (this.a == null) {
            AppMethodBeat.o(100860);
            return;
        }
        this.a.a(str, dbVar);
        AppMethodBeat.o(100860);
    }

    public final void a(String str, int i) {
        AppMethodBeat.i(100861);
        if (this.a == null) {
            AppMethodBeat.o(100861);
            return;
        }
        this.a.a(str, i);
        AppMethodBeat.o(100861);
    }

    public final void a(String str, double d) {
        AppMethodBeat.i(100862);
        if (this.a == null) {
            AppMethodBeat.o(100862);
            return;
        }
        this.a.a(str, d);
        AppMethodBeat.o(100862);
    }

    public final void b(String str, int i) {
        AppMethodBeat.i(100863);
        if (this.a == null) {
            AppMethodBeat.o(100863);
            return;
        }
        this.a.b(str, i);
        AppMethodBeat.o(100863);
    }

    public final void a(String str, float f) {
        AppMethodBeat.i(100864);
        if (this.a == null) {
            AppMethodBeat.o(100864);
            return;
        }
        this.a.a(str, f);
        AppMethodBeat.o(100864);
    }

    public final void a(String str, boolean z) {
        AppMethodBeat.i(100865);
        if (this.a == null) {
            AppMethodBeat.o(100865);
            return;
        }
        this.a.a(str, z);
        AppMethodBeat.o(100865);
    }

    public final void b(String str, float f) {
        AppMethodBeat.i(100866);
        if (this.a == null) {
            AppMethodBeat.o(100866);
            return;
        }
        this.a.b(str, f);
        AppMethodBeat.o(100866);
    }

    public final void b() {
        AppMethodBeat.i(100867);
        if (this.a == null) {
            AppMethodBeat.o(100867);
            return;
        }
        this.a.b();
        AppMethodBeat.o(100867);
    }

    public final void c(String str, int i) {
        AppMethodBeat.i(100868);
        if (this.a == null) {
            AppMethodBeat.o(100868);
            return;
        }
        this.a.c(str, i);
        AppMethodBeat.o(100868);
    }

    public final List<j> b(String str) {
        AppMethodBeat.i(100869);
        if (this.a != null) {
            List b = this.a.b(str);
            AppMethodBeat.o(100869);
            return b;
        }
        AppMethodBeat.o(100869);
        return null;
    }
}
