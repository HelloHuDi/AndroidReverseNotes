package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.support.v4.widget.j;
import com.tencent.map.lib.f;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bg;
import java.lang.ref.WeakReference;

public class jq implements b, c, jt.b {
    private WeakReference<iz> a;
    private WeakReference<f> b;
    private jw c;
    private int d = -1;

    public jq(iz izVar) {
        AppMethodBeat.i(100090);
        this.a = new WeakReference(izVar);
        this.b = new WeakReference(izVar.b());
        this.c = new ju(izVar.i());
        a((b) this);
        a((c) this);
        AppMethodBeat.o(100090);
    }

    public void a(b bVar) {
        AppMethodBeat.i(100091);
        if (!(this.b == null || this.b.get() == null)) {
            ((f) this.b.get()).a(bVar);
        }
        AppMethodBeat.o(100091);
    }

    public void a(c cVar) {
        AppMethodBeat.i(100092);
        if (!(this.b == null || this.b.get() == null)) {
            ((f) this.b.get()).a(cVar);
        }
        AppMethodBeat.o(100092);
    }

    public int a() {
        AppMethodBeat.i(100093);
        if (!(this.b == null || this.b.get() == null)) {
            this.d = ((f) this.b.get()).C();
            if (this.d != -1) {
                ((f) this.b.get()).a(this.d, 4, 20);
            }
        }
        int i = this.d;
        AppMethodBeat.o(100093);
        return i;
    }

    public void b() {
        AppMethodBeat.i(100094);
        if (!(this.b == null || this.b.get() == null || this.d == -1)) {
            f fVar = (f) this.b.get();
            fVar.a(null);
            fVar.a(null);
            fVar.i(this.d);
            this.c.b();
            this.d = -1;
        }
        AppMethodBeat.o(100094);
    }

    public void c() {
        AppMethodBeat.i(100095);
        if (!(this.b == null || this.b.get() == null || this.d == j.INVALID_ID)) {
            ((f) this.b.get()).j(this.d);
        }
        AppMethodBeat.o(100095);
    }

    public Bitmap a(byte[] bArr) {
        AppMethodBeat.i(100096);
        if (this.a == null || this.a.get() == null || this.d == -1) {
            AppMethodBeat.o(100096);
            return null;
        }
        bg bgVar = new bg();
        bgVar.a(bArr);
        Bitmap a = this.c.a(bgVar.a(), bgVar.b(), bgVar.c(), bArr);
        AppMethodBeat.o(100096);
        return a;
    }

    public void a(String str, byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(100097);
        if (bArr2 == null || bArr == null || bArr2.length == 0 || bArr.length == 0) {
            AppMethodBeat.o(100097);
            return;
        }
        bg bgVar = new bg();
        bgVar.a(bArr);
        this.c.a(bgVar.a(), bgVar.b(), bgVar.c(), str, bArr2);
        AppMethodBeat.o(100097);
    }

    public void b_() {
        AppMethodBeat.i(100098);
        this.c.a();
        c();
        AppMethodBeat.o(100098);
    }
}
