package com.tencent.liteav.basic.e;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import javax.microedition.khronos.egl.EGLContext;

public class e implements a, l {
    public int a = 25;
    private volatile HandlerThread b = null;
    private volatile f c = null;
    private m d;
    private int[] e = null;
    private SurfaceTexture f = null;
    private boolean g = false;
    private long h = 0;
    private long i = 0;
    private float[] j = new float[16];

    static /* synthetic */ void a(e eVar, int i, Runnable runnable) {
        AppMethodBeat.i(66256);
        eVar.a(i, runnable);
        AppMethodBeat.o(66256);
    }

    public e() {
        AppMethodBeat.i(66238);
        AppMethodBeat.o(66238);
    }

    public void a(int i) {
        AppMethodBeat.i(66239);
        this.a = i;
        b();
        AppMethodBeat.o(66239);
    }

    public void a() {
        AppMethodBeat.i(66240);
        f();
        AppMethodBeat.o(66240);
    }

    public void setSurfaceTextureListener(m mVar) {
        this.d = mVar;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f;
    }

    public EGLContext getGLContext() {
        EGLContext a;
        AppMethodBeat.i(66241);
        synchronized (this) {
            try {
                a = this.c != null ? this.c.a() : null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66241);
            }
        }
        return a;
    }

    public void a(Runnable runnable) {
        AppMethodBeat.i(66242);
        synchronized (this) {
            try {
                if (this.c != null) {
                    this.c.post(runnable);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66242);
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x0026=Splitter:B:14:0x0026, B:10:0x001c=Splitter:B:10:0x001c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean z) {
        AppMethodBeat.i(66243);
        synchronized (this) {
            try {
                if (this.c != null) {
                    this.c.removeCallbacksAndMessages(null);
                }
                this.g = false;
                if (this.f == null || this.e == null) {
                    try {
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(66243);
                    }
                } else {
                    this.f.updateTexImage();
                    this.f.setOnFrameAvailableListener(new OnFrameAvailableListener() {
                        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                            AppMethodBeat.i(66237);
                            e.a(e.this, 103, new Runnable() {
                                public void run() {
                                    AppMethodBeat.i(66178);
                                    e.this.g = true;
                                    e.a(e.this, 102);
                                    AppMethodBeat.o(66178);
                                }
                            });
                            surfaceTexture.setOnFrameAvailableListener(null);
                            AppMethodBeat.o(66237);
                        }
                    });
                    AppMethodBeat.o(66243);
                }
            } catch (Exception e) {
            }
        }
    }

    public void a(int i, boolean z, int i2, int i3, int i4) {
    }

    public void c() {
        AppMethodBeat.i(66244);
        h();
        AppMethodBeat.o(66244);
    }

    public void d() {
        AppMethodBeat.i(66245);
        a(102, 5);
        if (!i()) {
            AppMethodBeat.o(66245);
        } else if (this.f == null || this.e == null) {
            AppMethodBeat.o(66245);
        } else {
            try {
                this.f.updateTexImage();
                this.f.getTransformMatrix(this.j);
            } catch (Exception e) {
                TXCLog.e("TXGLSurfaceTextureThread", "onMsgRend Exception " + e.getMessage());
            }
            m mVar = this.d;
            if (mVar != null) {
                mVar.a(this.e[0], this.j);
            }
            AppMethodBeat.o(66245);
        }
    }

    public void e() {
        AppMethodBeat.i(66246);
        g();
        AppMethodBeat.o(66246);
    }

    private void b() {
        AppMethodBeat.i(66247);
        f();
        synchronized (this) {
            try {
                this.b = new HandlerThread("TXGLSurfaceTextureThread");
                this.b.start();
                this.c = new f(this.b.getLooper());
                this.c.a((a) this);
                this.c.a = ActUtil.HEIGHT;
                this.c.b = 720;
                TXCLog.w("TXGLSurfaceTextureThread", "create gl thread " + this.b.getName());
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66247);
            }
        }
        b(100);
    }

    private void f() {
        AppMethodBeat.i(66248);
        synchronized (this) {
            try {
                if (this.c != null) {
                    f.a(this.c, this.b);
                    TXCLog.w("TXGLSurfaceTextureThread", "destroy gl thread");
                }
                this.c = null;
                this.b = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66248);
            }
        }
    }

    private void a(int i, long j) {
        AppMethodBeat.i(66249);
        synchronized (this) {
            try {
                if (this.c != null) {
                    this.c.sendEmptyMessageDelayed(i, j);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66249);
            }
        }
    }

    private void b(int i) {
        AppMethodBeat.i(66250);
        synchronized (this) {
            try {
                if (this.c != null) {
                    this.c.sendEmptyMessage(i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66250);
            }
        }
    }

    private void a(int i, Runnable runnable) {
        AppMethodBeat.i(66251);
        synchronized (this) {
            try {
                if (this.c != null) {
                    Message message = new Message();
                    message.what = i;
                    message.obj = runnable;
                    this.c.sendMessage(message);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66251);
            }
        }
    }

    private void g() {
        AppMethodBeat.i(66252);
        TXCLog.w("TXGLSurfaceTextureThread", "destroy surface texture ");
        m mVar = this.d;
        if (mVar != null) {
            mVar.b(this.f);
        }
        if (this.f != null) {
            this.f.setOnFrameAvailableListener(null);
            this.f.release();
            this.g = false;
            this.f = null;
        }
        if (this.e != null) {
            GLES20.glDeleteTextures(1, this.e, 0);
            this.e = null;
        }
        AppMethodBeat.o(66252);
    }

    private void h() {
        AppMethodBeat.i(66253);
        TXCLog.w("TXGLSurfaceTextureThread", "init surface texture ");
        this.e = new int[1];
        this.e[0] = i.b();
        if (this.e[0] <= 0) {
            this.e = null;
            AppMethodBeat.o(66253);
            return;
        }
        this.f = new SurfaceTexture(this.e[0]);
        this.f.setDefaultBufferSize(ActUtil.HEIGHT, 720);
        this.f.setOnFrameAvailableListener(new OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(66285);
                e.a(e.this, 103, new Runnable() {
                    public void run() {
                        AppMethodBeat.i(66208);
                        e.this.g = true;
                        e.a(e.this, 102);
                        AppMethodBeat.o(66208);
                    }
                });
                surfaceTexture.setOnFrameAvailableListener(null);
                AppMethodBeat.o(66285);
            }
        });
        m mVar = this.d;
        if (mVar != null) {
            mVar.a(this.f);
        }
        AppMethodBeat.o(66253);
    }

    private boolean i() {
        AppMethodBeat.i(66254);
        if (this.g) {
            long nanoTime = System.nanoTime();
            if (nanoTime < this.i + ((((this.h * 1000) * 1000) * 1000) / ((long) this.a))) {
                AppMethodBeat.o(66254);
                return false;
            }
            if (this.i == 0) {
                this.i = nanoTime;
            } else if (nanoTime > this.i + 1000000000) {
                this.h = 0;
                this.i = nanoTime;
            }
            this.h++;
            AppMethodBeat.o(66254);
            return true;
        }
        this.h = 0;
        this.i = System.nanoTime();
        AppMethodBeat.o(66254);
        return false;
    }
}
