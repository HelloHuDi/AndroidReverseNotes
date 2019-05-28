package com.tencent.liteav.basic.p141e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p141e.C0950f.C0949a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.tencent.liteav.basic.e.d */
public class C32143d implements C0949a {
    /* renamed from: a */
    private volatile HandlerThread f14730a = null;
    /* renamed from: b */
    private volatile C0950f f14731b = null;
    /* renamed from: c */
    private C8796g f14732c = null;
    /* renamed from: d */
    private int f14733d = 0;
    /* renamed from: e */
    private boolean f14734e = false;
    /* renamed from: f */
    private float f14735f = 1.0f;
    /* renamed from: g */
    private float f14736g = 1.0f;
    /* renamed from: h */
    private int f14737h = 0;
    /* renamed from: i */
    private int f14738i = 0;
    /* renamed from: j */
    private boolean f14739j = true;
    /* renamed from: k */
    private C8802n f14740k = null;
    /* renamed from: l */
    private boolean f14741l = false;

    /* renamed from: a */
    static /* synthetic */ void m52295a(C32143d c32143d, int i, boolean z, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        AppMethodBeat.m2504i(66226);
        c32143d.m52296b(i, z, i2, i3, i4, i5, i6, z2);
        AppMethodBeat.m2505o(66226);
    }

    /* renamed from: a */
    public void mo52734a(EGLContext eGLContext, Surface surface) {
        AppMethodBeat.m2504i(66214);
        m52297b(eGLContext, surface);
        AppMethodBeat.m2505o(66214);
    }

    /* renamed from: a */
    public void mo52730a() {
        AppMethodBeat.m2504i(66215);
        m52298f();
        AppMethodBeat.m2505o(66215);
    }

    /* renamed from: b */
    public Surface mo52735b() {
        Surface b;
        AppMethodBeat.m2504i(66216);
        synchronized (this) {
            try {
                b = this.f14731b != null ? this.f14731b.mo3827b() : null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66216);
            }
        }
        return b;
    }

    /* renamed from: a */
    public void mo52733a(Runnable runnable) {
        AppMethodBeat.m2504i(66217);
        synchronized (this) {
            try {
                if (this.f14731b != null) {
                    this.f14731b.post(runnable);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66217);
            }
        }
    }

    /* renamed from: a */
    public void mo52731a(int i, boolean z, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        AppMethodBeat.m2504i(66218);
        GLES20.glFinish();
        synchronized (this) {
            try {
                if (this.f14731b != null) {
                    final int i7 = i;
                    final boolean z3 = z;
                    final int i8 = i2;
                    final int i9 = i3;
                    final int i10 = i4;
                    final int i11 = i5;
                    final int i12 = i6;
                    final boolean z4 = z2;
                    this.f14731b.post(new Runnable() {
                        public void run() {
                            AppMethodBeat.m2504i(66206);
                            try {
                                C32143d.m52295a(C32143d.this, i7, z3, i8, i9, i10, i11, i12, z4);
                                AppMethodBeat.m2505o(66206);
                            } catch (Exception e) {
                                TXCLog.m15676e("TXGLSurfaceRenderThread", "render texture error occurred!");
                                AppMethodBeat.m2505o(66206);
                            }
                        }
                    });
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66218);
            }
        }
    }

    /* renamed from: a */
    public void mo52732a(C8802n c8802n) {
        this.f14740k = c8802n;
        this.f14739j = true;
    }

    /* renamed from: c */
    public void mo3822c() {
        AppMethodBeat.m2504i(66219);
        TXCLog.m15679w("TXGLSurfaceRenderThread", "create egl context ");
        this.f14732c = new C8796g();
        if (this.f14732c.mo19876a()) {
            this.f14732c.mo19875a(C45103k.f17758e, C45103k.m82749a(C37353j.NORMAL, false, false));
            AppMethodBeat.m2505o(66219);
            return;
        }
        AppMethodBeat.m2505o(66219);
    }

    /* renamed from: d */
    public void mo3823d() {
    }

    /* renamed from: e */
    public void mo3824e() {
        AppMethodBeat.m2504i(66220);
        TXCLog.m15679w("TXGLSurfaceRenderThread", "destroy egl context ");
        if (this.f14732c != null) {
            this.f14732c.mo19883d();
            this.f14732c = null;
        }
        AppMethodBeat.m2505o(66220);
    }

    /* renamed from: b */
    private void m52297b(EGLContext eGLContext, Surface surface) {
        AppMethodBeat.m2504i(66221);
        m52298f();
        synchronized (this) {
            try {
                this.f14730a = new HandlerThread("TXGLSurfaceRenderThread");
                this.f14730a.start();
                this.f14731b = new C0950f(this.f14730a.getLooper());
                this.f14731b.mo3826a((C0949a) this);
                this.f14731b.f1075d = eGLContext;
                this.f14731b.f1074c = surface;
                TXCLog.m15679w("TXGLSurfaceRenderThread", "create gl thread " + this.f14730a.getName());
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66221);
            }
        }
        m52294a(100);
    }

    /* renamed from: f */
    private void m52298f() {
        AppMethodBeat.m2504i(66222);
        synchronized (this) {
            try {
                if (this.f14731b != null) {
                    C0950f.m2144a(this.f14731b, this.f14730a);
                    TXCLog.m15679w("TXGLSurfaceRenderThread", "destroy gl thread");
                }
                this.f14731b = null;
                this.f14730a = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66222);
            }
        }
    }

    /* renamed from: a */
    private void m52294a(int i) {
        AppMethodBeat.m2504i(66223);
        synchronized (this) {
            try {
                if (this.f14731b != null) {
                    this.f14731b.sendEmptyMessage(i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66223);
            }
        }
    }

    /* renamed from: b */
    private void m52296b(int i, boolean z, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        AppMethodBeat.m2504i(66224);
        if (i4 == 0 || i3 == 0 || i5 == 0 || i6 == 0 || this.f14732c == null) {
            AppMethodBeat.m2505o(66224);
        } else if (this.f14741l) {
            this.f14741l = false;
            AppMethodBeat.m2505o(66224);
        } else {
            if (z2) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                GLES20.glBindFramebuffer(36160, 0);
                if (this.f14731b != null) {
                    this.f14731b.mo3828c();
                }
                this.f14741l = true;
            }
            this.f14737h = i3;
            this.f14738i = i4;
            GLES20.glViewport(0, 0, i3, i4);
            float f = i4 != 0 ? ((float) i3) / ((float) i4) : 1.0f;
            float f2 = i6 != 0 ? ((float) i5) / ((float) i6) : 1.0f;
            if (!(this.f14734e == z && this.f14733d == i2 && this.f14735f == f && this.f14736g == f2)) {
                int i7;
                this.f14734e = z;
                this.f14733d = i2;
                this.f14735f = f;
                this.f14736g = f2;
                int i8 = (720 - this.f14733d) % v2helper.VOIP_ENC_HEIGHT_LV1;
                Object obj = (i8 == 90 || i8 == 270) ? 1 : null;
                if (obj != null) {
                    i7 = i4;
                } else {
                    i7 = i3;
                }
                if (obj == null) {
                    i3 = i4;
                }
                this.f14732c.mo19867a(i5, i6, i8, C45103k.m82749a(C37353j.NORMAL, false, true), ((float) i7) / ((float) i3), obj != null ? false : this.f14734e, obj != null ? this.f14734e : false);
                if (obj != null) {
                    this.f14732c.mo19885g();
                } else {
                    this.f14732c.mo19886h();
                }
            }
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            GLES20.glBindFramebuffer(36160, 0);
            this.f14732c.mo19864a(i);
            m52299g();
            if (this.f14731b != null) {
                this.f14731b.mo3828c();
            }
            AppMethodBeat.m2505o(66224);
        }
    }

    /* renamed from: g */
    private void m52299g() {
        AppMethodBeat.m2504i(66225);
        if (this.f14739j) {
            if (!(this.f14737h == 0 || this.f14738i == 0)) {
                int i;
                int i2;
                int i3 = this.f14737h <= this.f14738i ? 1 : 0;
                int i4 = this.f14738i >= this.f14737h ? this.f14738i : this.f14737h;
                int i5 = this.f14738i >= this.f14737h ? this.f14737h : this.f14738i;
                if (i3 != 0) {
                    i = i4;
                    i2 = i5;
                } else {
                    i = i5;
                    i2 = i4;
                }
                final ByteBuffer allocate = ByteBuffer.allocate((i2 * i) * 4);
                final Bitmap createBitmap = Bitmap.createBitmap(i2, i, Config.ARGB_8888);
                allocate.position(0);
                GLES20.glReadPixels(0, 0, i2, i, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, allocate);
                final int i6 = i2;
                final int i7 = i;
                new Thread(new Runnable() {
                    public void run() {
                        AppMethodBeat.m2504i(66257);
                        allocate.position(0);
                        createBitmap.copyPixelsFromBuffer(allocate);
                        Matrix matrix = new Matrix();
                        matrix.setScale(1.0f, -1.0f);
                        Bitmap createBitmap = Bitmap.createBitmap(createBitmap, 0, 0, i6, i7, matrix, false);
                        if (C32143d.this.f14740k != null) {
                            C32143d.this.f14740k.onTakePhotoComplete(createBitmap);
                            C32143d.this.f14740k = null;
                        }
                        createBitmap.recycle();
                        AppMethodBeat.m2505o(66257);
                    }
                }).start();
            }
            this.f14739j = false;
        }
        AppMethodBeat.m2505o(66225);
    }
}
