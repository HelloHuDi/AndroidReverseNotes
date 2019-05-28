package com.tencent.tencentmap.mapsdk.a;

import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ci {
    bv a = null;

    public ci(bv bvVar) {
        this.a = bvVar;
    }

    public void a() {
        if (this.a != null) {
            this.a = null;
        }
    }

    public final Location b() {
        AppMethodBeat.i(100937);
        if (this.a != null) {
            Location d = this.a.d();
            AppMethodBeat.o(100937);
            return d;
        }
        AppMethodBeat.o(100937);
        return null;
    }

    public void c() {
        AppMethodBeat.i(100938);
        if (this.a != null) {
            this.a.a();
        }
        AppMethodBeat.o(100938);
    }

    public void d() {
        AppMethodBeat.i(100939);
        if (this.a != null) {
            this.a.b();
        }
        AppMethodBeat.o(100939);
    }

    public boolean e() {
        AppMethodBeat.i(100940);
        if (this.a != null) {
            boolean c = this.a.c();
            AppMethodBeat.o(100940);
            return c;
        }
        AppMethodBeat.o(100940);
        return false;
    }
}
