package com.tencent.p177mm.plugin.appbrand.widget.p340i;

import android.graphics.Bitmap;
import com.tencent.p177mm.plugin.appbrand.C38492q;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.i.d */
public abstract class C33612d {
    C38492q hwf;
    int index = -1;
    String jpu;
    C33611c jpv;
    C33613a jpw;
    protected volatile C38594e jpx;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.i.d$a */
    public interface C33613a {
        void destroy(int i);
    }

    public abstract void aSg();

    /* renamed from: a */
    public final void mo54185a(C38594e c38594e) {
        this.jpx = c38594e;
    }

    /* renamed from: a */
    public final void mo54184a(C33613a c33613a) {
        this.jpw = c33613a;
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

    public C33612d(String str, C33611c c33611c, C38492q c38492q) {
        this.jpu = str;
        this.hwf = c38492q;
        this.jpv = c33611c;
    }

    public C33612d(String str, C33611c c33611c) {
        this.jpu = str;
        this.jpv = c33611c;
    }

    public final void cancel() {
        this.jpx = null;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: I */
    public final void mo54183I(Bitmap bitmap) {
        C38594e c38594e = this.jpx;
        if (c38594e != null) {
            c38594e.mo22659a(bitmap, this);
        }
    }
}
