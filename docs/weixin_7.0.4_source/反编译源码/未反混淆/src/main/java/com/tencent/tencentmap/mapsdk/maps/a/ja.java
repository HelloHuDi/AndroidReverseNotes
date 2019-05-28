package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import com.tencent.map.lib.d;
import com.tencent.map.lib.gl.JNICallback.f;
import com.tencent.map.lib.gl.e;
import com.tencent.map.lib.gl.e.g;
import com.tencent.map.lib.gl.e.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ak;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class ja extends e implements f, m, gg {
    private iz a;
    private boolean b;
    private Object c;

    public iz getVectorMapDelegate() {
        return this.a;
    }

    public ja(Context context, ak akVar) {
        super(context);
        AppMethodBeat.i(99988);
        if (!(akVar == null || akVar.d() == null)) {
            this.c = akVar.d();
        }
        d();
        this.a = new iz(this, getContext().getApplicationContext(), akVar);
        setContentDescription("地图");
        AppMethodBeat.o(99988);
    }

    public void a(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.i(99989);
        if (this.a != null) {
            this.a.a(gl10, eGLConfig);
        }
        AppMethodBeat.o(99989);
    }

    public void a(GL10 gl10, int i, int i2) {
        AppMethodBeat.i(99990);
        if (this.a != null) {
            this.a.a(gl10, i, i2);
        }
        AppMethodBeat.o(99990);
    }

    public void j() {
        AppMethodBeat.i(99991);
        if (this.a != null) {
            this.a.j();
        }
        AppMethodBeat.o(99991);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(99992);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.a != null) {
            this.a.a(i, i2);
        }
        AppMethodBeat.o(99992);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(99993);
        if (this.a != null) {
            boolean a = this.a.a(motionEvent);
            AppMethodBeat.o(99993);
            return a;
        }
        AppMethodBeat.o(99993);
        return false;
    }

    public void g() {
        AppMethodBeat.i(99994);
        if (this.a != null) {
            this.a.g();
        }
        AppMethodBeat.o(99994);
    }

    public void f() {
        AppMethodBeat.i(99995);
        if (this.b) {
            super.f();
        }
        if (this.a != null) {
            this.a.f();
        }
        AppMethodBeat.o(99995);
    }

    public void e() {
        AppMethodBeat.i(99996);
        if (this.b) {
            super.e();
        }
        if (this.a != null) {
            this.a.e();
        }
        AppMethodBeat.o(99996);
    }

    public void a_() {
        AppMethodBeat.i(99997);
        if (getVisibility() == 0) {
            b();
        }
        AppMethodBeat.o(99997);
    }

    public boolean a(GL10 gl10) {
        AppMethodBeat.i(99998);
        if (this.a == null) {
            AppMethodBeat.o(99998);
            return false;
        }
        boolean a = this.a.a(gl10);
        AppMethodBeat.o(99998);
        return a;
    }

    public int getEGLContextHash() {
        AppMethodBeat.i(99999);
        if (this.a != null) {
            int eGLContextHash = this.a.getEGLContextHash();
            AppMethodBeat.o(99999);
            return eGLContextHash;
        }
        AppMethodBeat.o(99999);
        return 0;
    }

    private void h() {
        AppMethodBeat.i(100000);
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        a(8, 8, 8, 8, 16, 0);
        setEGLContextFactory(new e.f() {
            public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
                AppMethodBeat.i(99984);
                byte[] bArr = new byte[1];
                ja.a(ja.this, bArr);
                synchronized (bArr) {
                    try {
                        bArr.wait(1000);
                    } catch (InterruptedException e) {
                        d.b(Log.getStackTraceString(e));
                        Thread.currentThread().interrupt();
                    } catch (Throwable th) {
                        AppMethodBeat.o(99984);
                    }
                }
                ja.a(ja.this);
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                egl10.eglDestroyContext(eGLDisplay, eGLContext);
                AppMethodBeat.o(99984);
            }

            public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
                AppMethodBeat.i(99985);
                EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                AppMethodBeat.o(99985);
                return eglCreateContext;
            }
        });
        if (this.c != null) {
            setEGLWindowSurfaceFactory(new g() {
                public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
                    EGLSurface eGLSurface = null;
                    AppMethodBeat.i(99986);
                    try {
                        eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, ja.this.c, null);
                    } catch (IllegalArgumentException | OutOfMemoryError e) {
                    }
                    AppMethodBeat.o(99986);
                    return eGLSurface;
                }

                public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
                    AppMethodBeat.i(99987);
                    egl10.eglDestroySurface(eGLDisplay, eGLSurface);
                    AppMethodBeat.o(99987);
                }
            });
        }
        AppMethodBeat.o(100000);
    }

    private void i() {
        AppMethodBeat.i(100001);
        if (this.a != null) {
            this.a.d();
        }
        AppMethodBeat.o(100001);
    }

    private void a(byte[] bArr) {
        AppMethodBeat.i(100002);
        if (this.a != null) {
            this.a.a(bArr);
        }
        AppMethodBeat.o(100002);
    }

    public void d() {
        AppMethodBeat.i(100003);
        h();
        setRenderer(this);
        setRenderMode(0);
        this.b = ew.a(this, true);
        AppMethodBeat.o(100003);
    }

    /* Access modifiers changed, original: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(100004);
        if (this.a == null || !this.a.b(motionEvent)) {
            boolean dispatchHoverEvent = super.dispatchHoverEvent(motionEvent);
            AppMethodBeat.o(100004);
            return dispatchHoverEvent;
        }
        AppMethodBeat.o(100004);
        return true;
    }
}
