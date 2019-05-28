package com.tencent.liteav.beauty.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLSurface;

public class b {
    protected a a;
    private EGLSurface b = EGL11.EGL_NO_SURFACE;
    private int c = -1;
    private int d = -1;

    protected b(a aVar) {
        this.a = aVar;
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(66841);
        if (this.b != EGL11.EGL_NO_SURFACE) {
            IllegalStateException illegalStateException = new IllegalStateException("surface already created");
            AppMethodBeat.o(66841);
            throw illegalStateException;
        }
        this.b = this.a.a(i, i2);
        this.c = i;
        this.d = i2;
        AppMethodBeat.o(66841);
    }

    public void a() {
        AppMethodBeat.i(66842);
        this.a.a(this.b);
        this.b = EGL11.EGL_NO_SURFACE;
        this.d = -1;
        this.c = -1;
        AppMethodBeat.o(66842);
    }

    public void b() {
        AppMethodBeat.i(66843);
        this.a.b(this.b);
        AppMethodBeat.o(66843);
    }
}
