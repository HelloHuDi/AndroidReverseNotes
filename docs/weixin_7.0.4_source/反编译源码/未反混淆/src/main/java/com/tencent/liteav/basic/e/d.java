package com.tencent.liteav.basic.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

public class d implements a {
    private volatile HandlerThread a = null;
    private volatile f b = null;
    private g c = null;
    private int d = 0;
    private boolean e = false;
    private float f = 1.0f;
    private float g = 1.0f;
    private int h = 0;
    private int i = 0;
    private boolean j = true;
    private n k = null;
    private boolean l = false;

    static /* synthetic */ void a(d dVar, int i, boolean z, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        AppMethodBeat.i(66226);
        dVar.b(i, z, i2, i3, i4, i5, i6, z2);
        AppMethodBeat.o(66226);
    }

    public void a(EGLContext eGLContext, Surface surface) {
        AppMethodBeat.i(66214);
        b(eGLContext, surface);
        AppMethodBeat.o(66214);
    }

    public void a() {
        AppMethodBeat.i(66215);
        f();
        AppMethodBeat.o(66215);
    }

    public Surface b() {
        Surface b;
        AppMethodBeat.i(66216);
        synchronized (this) {
            try {
                b = this.b != null ? this.b.b() : null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66216);
            }
        }
        return b;
    }

    public void a(Runnable runnable) {
        AppMethodBeat.i(66217);
        synchronized (this) {
            try {
                if (this.b != null) {
                    this.b.post(runnable);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66217);
            }
        }
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        AppMethodBeat.i(66218);
        GLES20.glFinish();
        synchronized (this) {
            try {
                if (this.b != null) {
                    final int i7 = i;
                    final boolean z3 = z;
                    final int i8 = i2;
                    final int i9 = i3;
                    final int i10 = i4;
                    final int i11 = i5;
                    final int i12 = i6;
                    final boolean z4 = z2;
                    this.b.post(new Runnable() {
                        public void run() {
                            AppMethodBeat.i(66206);
                            try {
                                d.a(d.this, i7, z3, i8, i9, i10, i11, i12, z4);
                                AppMethodBeat.o(66206);
                            } catch (Exception e) {
                                TXCLog.e("TXGLSurfaceRenderThread", "render texture error occurred!");
                                AppMethodBeat.o(66206);
                            }
                        }
                    });
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66218);
            }
        }
    }

    public void a(n nVar) {
        this.k = nVar;
        this.j = true;
    }

    public void c() {
        AppMethodBeat.i(66219);
        TXCLog.w("TXGLSurfaceRenderThread", "create egl context ");
        this.c = new g();
        if (this.c.a()) {
            this.c.a(k.e, k.a(j.NORMAL, false, false));
            AppMethodBeat.o(66219);
            return;
        }
        AppMethodBeat.o(66219);
    }

    public void d() {
    }

    public void e() {
        AppMethodBeat.i(66220);
        TXCLog.w("TXGLSurfaceRenderThread", "destroy egl context ");
        if (this.c != null) {
            this.c.d();
            this.c = null;
        }
        AppMethodBeat.o(66220);
    }

    private void b(EGLContext eGLContext, Surface surface) {
        AppMethodBeat.i(66221);
        f();
        synchronized (this) {
            try {
                this.a = new HandlerThread("TXGLSurfaceRenderThread");
                this.a.start();
                this.b = new f(this.a.getLooper());
                this.b.a((a) this);
                this.b.d = eGLContext;
                this.b.c = surface;
                TXCLog.w("TXGLSurfaceRenderThread", "create gl thread " + this.a.getName());
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66221);
            }
        }
        a(100);
    }

    private void f() {
        AppMethodBeat.i(66222);
        synchronized (this) {
            try {
                if (this.b != null) {
                    f.a(this.b, this.a);
                    TXCLog.w("TXGLSurfaceRenderThread", "destroy gl thread");
                }
                this.b = null;
                this.a = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66222);
            }
        }
    }

    private void a(int i) {
        AppMethodBeat.i(66223);
        synchronized (this) {
            try {
                if (this.b != null) {
                    this.b.sendEmptyMessage(i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66223);
            }
        }
    }

    private void b(int i, boolean z, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        AppMethodBeat.i(66224);
        if (i4 == 0 || i3 == 0 || i5 == 0 || i6 == 0 || this.c == null) {
            AppMethodBeat.o(66224);
        } else if (this.l) {
            this.l = false;
            AppMethodBeat.o(66224);
        } else {
            if (z2) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                GLES20.glBindFramebuffer(36160, 0);
                if (this.b != null) {
                    this.b.c();
                }
                this.l = true;
            }
            this.h = i3;
            this.i = i4;
            GLES20.glViewport(0, 0, i3, i4);
            float f = i4 != 0 ? ((float) i3) / ((float) i4) : 1.0f;
            float f2 = i6 != 0 ? ((float) i5) / ((float) i6) : 1.0f;
            if (!(this.e == z && this.d == i2 && this.f == f && this.g == f2)) {
                int i7;
                this.e = z;
                this.d = i2;
                this.f = f;
                this.g = f2;
                int i8 = (720 - this.d) % v2helper.VOIP_ENC_HEIGHT_LV1;
                Object obj = (i8 == 90 || i8 == 270) ? 1 : null;
                if (obj != null) {
                    i7 = i4;
                } else {
                    i7 = i3;
                }
                if (obj == null) {
                    i3 = i4;
                }
                this.c.a(i5, i6, i8, k.a(j.NORMAL, false, true), ((float) i7) / ((float) i3), obj != null ? false : this.e, obj != null ? this.e : false);
                if (obj != null) {
                    this.c.g();
                } else {
                    this.c.h();
                }
            }
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            GLES20.glBindFramebuffer(36160, 0);
            this.c.a(i);
            g();
            if (this.b != null) {
                this.b.c();
            }
            AppMethodBeat.o(66224);
        }
    }

    private void g() {
        AppMethodBeat.i(66225);
        if (this.j) {
            if (!(this.h == 0 || this.i == 0)) {
                int i;
                int i2;
                int i3 = this.h <= this.i ? 1 : 0;
                int i4 = this.i >= this.h ? this.i : this.h;
                int i5 = this.i >= this.h ? this.h : this.i;
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
                        AppMethodBeat.i(66257);
                        allocate.position(0);
                        createBitmap.copyPixelsFromBuffer(allocate);
                        Matrix matrix = new Matrix();
                        matrix.setScale(1.0f, -1.0f);
                        Bitmap createBitmap = Bitmap.createBitmap(createBitmap, 0, 0, i6, i7, matrix, false);
                        if (d.this.k != null) {
                            d.this.k.onTakePhotoComplete(createBitmap);
                            d.this.k = null;
                        }
                        createBitmap.recycle();
                        AppMethodBeat.o(66257);
                    }
                }).start();
            }
            this.j = false;
        }
        AppMethodBeat.o(66225);
    }
}
