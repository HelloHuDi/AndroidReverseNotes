package com.tencent.liteav.beauty.p142a.p143a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLSurface;

/* renamed from: com.tencent.liteav.beauty.a.a.b */
public class C0956b {
    /* renamed from: a */
    protected C0955a f1087a;
    /* renamed from: b */
    private EGLSurface f1088b = EGL11.EGL_NO_SURFACE;
    /* renamed from: c */
    private int f1089c = -1;
    /* renamed from: d */
    private int f1090d = -1;

    protected C0956b(C0955a c0955a) {
        this.f1087a = c0955a;
    }

    /* renamed from: a */
    public void mo3837a(int i, int i2) {
        AppMethodBeat.m2504i(66841);
        if (this.f1088b != EGL11.EGL_NO_SURFACE) {
            IllegalStateException illegalStateException = new IllegalStateException("surface already created");
            AppMethodBeat.m2505o(66841);
            throw illegalStateException;
        }
        this.f1088b = this.f1087a.mo3832a(i, i2);
        this.f1089c = i;
        this.f1090d = i2;
        AppMethodBeat.m2505o(66841);
    }

    /* renamed from: a */
    public void mo3836a() {
        AppMethodBeat.m2504i(66842);
        this.f1087a.mo3834a(this.f1088b);
        this.f1088b = EGL11.EGL_NO_SURFACE;
        this.f1090d = -1;
        this.f1089c = -1;
        AppMethodBeat.m2505o(66842);
    }

    /* renamed from: b */
    public void mo3838b() {
        AppMethodBeat.m2504i(66843);
        this.f1087a.mo3835b(this.f1088b);
        AppMethodBeat.m2505o(66843);
    }
}
