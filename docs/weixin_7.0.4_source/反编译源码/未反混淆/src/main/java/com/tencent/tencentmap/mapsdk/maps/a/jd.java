package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.aj.l;

public class jd extends jb {
    private hx a;
    private iz b;

    public jd(iz izVar, hx hxVar) {
        this.b = izVar;
        this.a = hxVar;
    }

    public Rect a() {
        AppMethodBeat.i(100023);
        if (this.a == null) {
            AppMethodBeat.o(100023);
            return null;
        }
        Rect a = a(this.a.l());
        AppMethodBeat.o(100023);
        return a;
    }

    private Rect a(Rect rect) {
        AppMethodBeat.i(100024);
        if (rect == null) {
            AppMethodBeat.o(100024);
            return null;
        }
        int i = rect.left;
        int i2 = rect.right;
        int i3 = rect.top;
        int i4 = rect.bottom;
        int i5 = (rect.right + rect.left) / 2;
        int i6 = (rect.top + rect.bottom) / 2;
        int i7 = rect.bottom - rect.top;
        if (((float) (rect.right - rect.left)) < ic.s * 40.0f) {
            i = (int) (((float) i5) - (ic.s * 20.0f));
            i2 = (int) (((float) i5) + (ic.s * 20.0f));
        }
        if (((float) i7) < ic.s * 40.0f) {
            i3 = (int) (((float) i6) - (ic.s * 20.0f));
            i4 = (int) (((float) i6) + (ic.s * 20.0f));
        }
        Rect rect2 = new Rect(i, i3, i2, i4);
        AppMethodBeat.o(100024);
        return rect2;
    }

    public String b() {
        AppMethodBeat.i(100025);
        if (this.a == null) {
            AppMethodBeat.o(100025);
            return null;
        }
        String m = this.a.m();
        AppMethodBeat.o(100025);
        return m;
    }

    public void c() {
        AppMethodBeat.i(100026);
        if (this.b != null) {
            l lVar = this.b.s;
            if (!(this.a == null || lVar == null)) {
                lVar.a(this.a.y);
            }
        }
        AppMethodBeat.o(100026);
    }
}
