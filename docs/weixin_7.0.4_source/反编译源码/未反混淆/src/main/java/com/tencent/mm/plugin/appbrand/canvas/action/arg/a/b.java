package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.sdk.platformtools.bg;

public abstract class b {
    private bg<a> hdw = new bg(100);

    public abstract a ayi();

    public final a ayh() {
        a aVar = (a) this.hdw.aA();
        if (aVar == null) {
            return ayi();
        }
        return aVar;
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.hdw.release(aVar);
        }
    }
}
