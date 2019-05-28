package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bj;
import com.tencent.tencentmap.mapsdk.a.da;

public class lt implements bj {
    private da a = da.zh;

    public String a(int i, int i2, int i3) {
        AppMethodBeat.i(100481);
        String e = lq.e();
        if (e == null) {
            AppMethodBeat.o(100481);
            return null;
        }
        int[] h = lq.h();
        if (h.length == 0) {
            e = e.replaceFirst("\\{range\\}", "");
        } else {
            e = e.replaceFirst("\\{range\\}", Integer.toString(a(i + i2, h.length)));
        }
        e = e.replaceFirst("\\{z\\}", Integer.toString(i3)).replaceFirst("\\{x\\}", Integer.toString(i)).replaceFirst("\\{y\\}", Integer.toString(i2)).replaceFirst("\\{style\\}", Integer.toString(lq.a())).replaceFirst("\\{scene\\}", Integer.toString(lq.b())).replaceFirst("\\{version\\}", Integer.toString(lq.c())).replaceFirst("\\{ch\\}", this.a.name()) + "&foreignLanguage=" + this.a.name();
        AppMethodBeat.o(100481);
        return e;
    }

    /* Access modifiers changed, original: protected */
    public int a(int i, int i2) {
        int i3 = i % i2;
        return i3 * i2 < 0 ? i3 + i2 : i3;
    }

    public void a(da daVar) {
        this.a = daVar;
    }

    public da a() {
        return this.a;
    }
}
