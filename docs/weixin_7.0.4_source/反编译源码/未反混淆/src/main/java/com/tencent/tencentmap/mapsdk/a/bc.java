package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class bc {
    private cd a = null;

    public bc(cd cdVar) {
        this.a = cdVar;
    }

    public final void a() {
        if (this.a != null) {
            this.a = null;
        }
    }

    public final dl a(dm dmVar) {
        AppMethodBeat.i(100752);
        if (this.a == null) {
            AppMethodBeat.o(100752);
            return null;
        }
        dl a = this.a.a(dmVar, this);
        AppMethodBeat.o(100752);
        return a;
    }

    public final void a(String str) {
        AppMethodBeat.i(100753);
        if (this.a == null) {
            AppMethodBeat.o(100753);
            return;
        }
        this.a.a(str);
        AppMethodBeat.o(100753);
    }

    public final void a(String str, int i) {
        AppMethodBeat.i(100754);
        if (this.a == null) {
            AppMethodBeat.o(100754);
            return;
        }
        this.a.a(str, i);
        AppMethodBeat.o(100754);
    }

    public final void a(String str, cm cmVar) {
        AppMethodBeat.i(100755);
        if (this.a == null) {
            AppMethodBeat.o(100755);
            return;
        }
        this.a.a(str, cmVar);
        AppMethodBeat.o(100755);
    }

    public final void a(String str, List<db> list) {
        AppMethodBeat.i(100756);
        if (this.a == null) {
            AppMethodBeat.o(100756);
            return;
        }
        this.a.a(str, (List) list);
        AppMethodBeat.o(100756);
    }

    public final void a(String str, boolean z) {
        AppMethodBeat.i(100757);
        if (this.a == null) {
            AppMethodBeat.o(100757);
            return;
        }
        this.a.a(str, z);
        AppMethodBeat.o(100757);
    }

    public final void a(String str, float f) {
        AppMethodBeat.i(100758);
        if (this.a == null) {
            AppMethodBeat.o(100758);
            return;
        }
        this.a.a(str, f);
        AppMethodBeat.o(100758);
    }

    public final void b(String str, float f) {
        AppMethodBeat.i(100759);
        if (this.a == null) {
            AppMethodBeat.o(100759);
            return;
        }
        this.a.b(str, f);
        AppMethodBeat.o(100759);
    }

    public final void a(String str, int i, db dbVar) {
        AppMethodBeat.i(100760);
        if (this.a == null) {
            AppMethodBeat.o(100760);
            return;
        }
        this.a.a(str, i, dbVar);
        AppMethodBeat.o(100760);
    }

    public final void b() {
        AppMethodBeat.i(100761);
        if (this.a == null) {
            AppMethodBeat.o(100761);
            return;
        }
        this.a.b();
        AppMethodBeat.o(100761);
    }

    public final void b(String str, boolean z) {
        AppMethodBeat.i(100762);
        if (this.a == null) {
            AppMethodBeat.o(100762);
            return;
        }
        this.a.b(str, z);
        AppMethodBeat.o(100762);
    }

    public final List<j> b(String str) {
        AppMethodBeat.i(100763);
        if (this.a != null) {
            List b = this.a.b(str);
            AppMethodBeat.o(100763);
            return b;
        }
        AppMethodBeat.o(100763);
        return null;
    }

    public final void b(String str, int i) {
        AppMethodBeat.i(100764);
        if (this.a == null) {
            AppMethodBeat.o(100764);
            return;
        }
        this.a.b(str, i);
        AppMethodBeat.o(100764);
    }
}
