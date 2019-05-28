package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.jt.b;
import javax.microedition.khronos.opengles.GL10;

public class jr extends hz implements b {
    private jq a;

    public jr(jq jqVar) {
        AppMethodBeat.i(100099);
        this.a = jqVar;
        jqVar.a();
        AppMethodBeat.o(100099);
    }

    public void a(GL10 gl10) {
    }

    public boolean a(float f, float f2) {
        return false;
    }

    public boolean a() {
        return false;
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
        AppMethodBeat.i(100100);
        e();
        AppMethodBeat.o(100100);
    }

    public void e() {
        AppMethodBeat.i(100101);
        if (this.a != null) {
            this.a.b();
        }
        AppMethodBeat.o(100101);
    }

    public void b_() {
        AppMethodBeat.i(100102);
        if (this.a != null) {
            this.a.b_();
        }
        AppMethodBeat.o(100102);
    }
}
