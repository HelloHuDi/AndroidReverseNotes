package com.tencent.p177mm.plugin.appbrand.jsapi.camera.p302a;

import android.graphics.Rect;
import com.tencent.p177mm.plugin.appbrand.jsapi.camera.p302a.C19348b.C22441;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.a.c */
public abstract class C19350c {
    private boolean cAY = false;
    public C19351a hHx;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.a.c$a */
    public interface C19351a {
        /* renamed from: b */
        void mo30633b(int i, String str, byte[] bArr);
    }

    public abstract C19348b aDs();

    public final void init() {
        aDs().init();
    }

    public final void release() {
        aDs().release();
    }

    /* renamed from: a */
    public final void mo34514a(byte[] bArr, int i, int i2, Rect rect, int i3) {
        if (!this.cAY) {
            C19348b aDs = aDs();
            if (bArr != null) {
                aDs.hHl.mo10302aa(new C22441(bArr, i3, i, i2, rect));
            }
        }
    }
}
