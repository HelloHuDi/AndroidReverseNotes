package com.tencent.mm.plugin.appbrand.widget.i;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.q;

public abstract class d {
    q hwf;
    int index = -1;
    String jpu;
    c jpv;
    a jpw;
    protected volatile e jpx;

    public interface a {
        void destroy(int i);
    }

    public abstract void aSg();

    public final void a(e eVar) {
        this.jpx = eVar;
    }

    public final void a(a aVar) {
        this.jpw = aVar;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final String aSh() {
        if (this.jpu == null || this.jpu.isEmpty()) {
            return null;
        }
        return this.jpu;
    }

    public d(String str, c cVar, q qVar) {
        this.jpu = str;
        this.hwf = qVar;
        this.jpv = cVar;
    }

    public d(String str, c cVar) {
        this.jpu = str;
        this.jpv = cVar;
    }

    public final void cancel() {
        this.jpx = null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void I(Bitmap bitmap) {
        e eVar = this.jpx;
        if (eVar != null) {
            eVar.a(bitmap, this);
        }
    }
}
