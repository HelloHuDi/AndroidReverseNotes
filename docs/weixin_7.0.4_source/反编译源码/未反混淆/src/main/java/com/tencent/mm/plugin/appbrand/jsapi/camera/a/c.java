package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Rect;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.AnonymousClass1;

public abstract class c {
    private boolean cAY = false;
    public a hHx;

    public interface a {
        void b(int i, String str, byte[] bArr);
    }

    public abstract b aDs();

    public final void init() {
        aDs().init();
    }

    public final void release() {
        aDs().release();
    }

    public final void a(byte[] bArr, int i, int i2, Rect rect, int i3) {
        if (!this.cAY) {
            b aDs = aDs();
            if (bArr != null) {
                aDs.hHl.aa(new AnonymousClass1(bArr, i3, i, i2, rect));
            }
        }
    }
}
