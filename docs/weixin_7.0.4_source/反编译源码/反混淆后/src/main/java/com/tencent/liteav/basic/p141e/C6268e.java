package com.tencent.liteav.basic.p141e;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p141e.C0950f.C0949a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.tencent.liteav.basic.e.e */
public class C6268e implements C0949a, C37354l {
    /* renamed from: a */
    public int f1949a = 25;
    /* renamed from: b */
    private volatile HandlerThread f1950b = null;
    /* renamed from: c */
    private volatile C0950f f1951c = null;
    /* renamed from: d */
    private C25647m f1952d;
    /* renamed from: e */
    private int[] f1953e = null;
    /* renamed from: f */
    private SurfaceTexture f1954f = null;
    /* renamed from: g */
    private boolean f1955g = false;
    /* renamed from: h */
    private long f1956h = 0;
    /* renamed from: i */
    private long f1957i = 0;
    /* renamed from: j */
    private float[] f1958j = new float[16];

    /* renamed from: com.tencent.liteav.basic.e.e$1 */
    class C62691 implements OnFrameAvailableListener {

        /* renamed from: com.tencent.liteav.basic.e.e$1$1 */
        class C62701 implements Runnable {
            C62701() {
            }

            public void run() {
                AppMethodBeat.m2504i(66178);
                C6268e.this.f1955g = true;
                C6268e.m10249a(C6268e.this, 102);
                AppMethodBeat.m2505o(66178);
            }
        }

        C62691() {
        }

        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(66237);
            C6268e.m10250a(C6268e.this, 103, new C62701());
            surfaceTexture.setOnFrameAvailableListener(null);
            AppMethodBeat.m2505o(66237);
        }
    }

    /* renamed from: com.tencent.liteav.basic.e.e$2 */
    class C62712 implements OnFrameAvailableListener {

        /* renamed from: com.tencent.liteav.basic.e.e$2$1 */
        class C62721 implements Runnable {
            C62721() {
            }

            public void run() {
                AppMethodBeat.m2504i(66208);
                C6268e.this.f1955g = true;
                C6268e.m10249a(C6268e.this, 102);
                AppMethodBeat.m2505o(66208);
            }
        }

        C62712() {
        }

        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(66285);
            C6268e.m10250a(C6268e.this, 103, new C62721());
            surfaceTexture.setOnFrameAvailableListener(null);
            AppMethodBeat.m2505o(66285);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m10250a(C6268e c6268e, int i, Runnable runnable) {
        AppMethodBeat.m2504i(66256);
        c6268e.m10248a(i, runnable);
        AppMethodBeat.m2505o(66256);
    }

    public C6268e() {
        AppMethodBeat.m2504i(66238);
        AppMethodBeat.m2505o(66238);
    }

    /* renamed from: a */
    public void mo14491a(int i) {
        AppMethodBeat.m2504i(66239);
        this.f1949a = i;
        m10252b();
        AppMethodBeat.m2505o(66239);
    }

    /* renamed from: a */
    public void mo14490a() {
        AppMethodBeat.m2504i(66240);
        m10254f();
        AppMethodBeat.m2505o(66240);
    }

    public void setSurfaceTextureListener(C25647m c25647m) {
        this.f1952d = c25647m;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f1954f;
    }

    public EGLContext getGLContext() {
        EGLContext a;
        AppMethodBeat.m2504i(66241);
        synchronized (this) {
            try {
                a = this.f1951c != null ? this.f1951c.mo3825a() : null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66241);
            }
        }
        return a;
    }

    /* renamed from: a */
    public void mo14493a(Runnable runnable) {
        AppMethodBeat.m2504i(66242);
        synchronized (this) {
            try {
                if (this.f1951c != null) {
                    this.f1951c.post(runnable);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66242);
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x0026=Splitter:B:14:0x0026, B:10:0x001c=Splitter:B:10:0x001c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo14494a(boolean z) {
        AppMethodBeat.m2504i(66243);
        synchronized (this) {
            try {
                if (this.f1951c != null) {
                    this.f1951c.removeCallbacksAndMessages(null);
                }
                this.f1955g = false;
                if (this.f1954f == null || this.f1953e == null) {
                    try {
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(66243);
                    }
                } else {
                    this.f1954f.updateTexImage();
                    this.f1954f.setOnFrameAvailableListener(new C62691());
                    AppMethodBeat.m2505o(66243);
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public void mo14492a(int i, boolean z, int i2, int i3, int i4) {
    }

    /* renamed from: c */
    public void mo3822c() {
        AppMethodBeat.m2504i(66244);
        m10256h();
        AppMethodBeat.m2505o(66244);
    }

    /* renamed from: d */
    public void mo3823d() {
        AppMethodBeat.m2504i(66245);
        m10247a(102, 5);
        if (!m10257i()) {
            AppMethodBeat.m2505o(66245);
        } else if (this.f1954f == null || this.f1953e == null) {
            AppMethodBeat.m2505o(66245);
        } else {
            try {
                this.f1954f.updateTexImage();
                this.f1954f.getTransformMatrix(this.f1958j);
            } catch (Exception e) {
                TXCLog.m15676e("TXGLSurfaceTextureThread", "onMsgRend Exception " + e.getMessage());
            }
            C25647m c25647m = this.f1952d;
            if (c25647m != null) {
                c25647m.mo43375a(this.f1953e[0], this.f1958j);
            }
            AppMethodBeat.m2505o(66245);
        }
    }

    /* renamed from: e */
    public void mo3824e() {
        AppMethodBeat.m2504i(66246);
        m10255g();
        AppMethodBeat.m2505o(66246);
    }

    /* renamed from: b */
    private void m10252b() {
        AppMethodBeat.m2504i(66247);
        m10254f();
        synchronized (this) {
            try {
                this.f1950b = new HandlerThread("TXGLSurfaceTextureThread");
                this.f1950b.start();
                this.f1951c = new C0950f(this.f1950b.getLooper());
                this.f1951c.mo3826a((C0949a) this);
                this.f1951c.f1072a = ActUtil.HEIGHT;
                this.f1951c.f1073b = 720;
                TXCLog.m15679w("TXGLSurfaceTextureThread", "create gl thread " + this.f1950b.getName());
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66247);
            }
        }
        m10253b(100);
    }

    /* renamed from: f */
    private void m10254f() {
        AppMethodBeat.m2504i(66248);
        synchronized (this) {
            try {
                if (this.f1951c != null) {
                    C0950f.m2144a(this.f1951c, this.f1950b);
                    TXCLog.m15679w("TXGLSurfaceTextureThread", "destroy gl thread");
                }
                this.f1951c = null;
                this.f1950b = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66248);
            }
        }
    }

    /* renamed from: a */
    private void m10247a(int i, long j) {
        AppMethodBeat.m2504i(66249);
        synchronized (this) {
            try {
                if (this.f1951c != null) {
                    this.f1951c.sendEmptyMessageDelayed(i, j);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66249);
            }
        }
    }

    /* renamed from: b */
    private void m10253b(int i) {
        AppMethodBeat.m2504i(66250);
        synchronized (this) {
            try {
                if (this.f1951c != null) {
                    this.f1951c.sendEmptyMessage(i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66250);
            }
        }
    }

    /* renamed from: a */
    private void m10248a(int i, Runnable runnable) {
        AppMethodBeat.m2504i(66251);
        synchronized (this) {
            try {
                if (this.f1951c != null) {
                    Message message = new Message();
                    message.what = i;
                    message.obj = runnable;
                    this.f1951c.sendMessage(message);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66251);
            }
        }
    }

    /* renamed from: g */
    private void m10255g() {
        AppMethodBeat.m2504i(66252);
        TXCLog.m15679w("TXGLSurfaceTextureThread", "destroy surface texture ");
        C25647m c25647m = this.f1952d;
        if (c25647m != null) {
            c25647m.mo43377b(this.f1954f);
        }
        if (this.f1954f != null) {
            this.f1954f.setOnFrameAvailableListener(null);
            this.f1954f.release();
            this.f1955g = false;
            this.f1954f = null;
        }
        if (this.f1953e != null) {
            GLES20.glDeleteTextures(1, this.f1953e, 0);
            this.f1953e = null;
        }
        AppMethodBeat.m2505o(66252);
    }

    /* renamed from: h */
    private void m10256h() {
        AppMethodBeat.m2504i(66253);
        TXCLog.m15679w("TXGLSurfaceTextureThread", "init surface texture ");
        this.f1953e = new int[1];
        this.f1953e[0] = C32144i.m52319b();
        if (this.f1953e[0] <= 0) {
            this.f1953e = null;
            AppMethodBeat.m2505o(66253);
            return;
        }
        this.f1954f = new SurfaceTexture(this.f1953e[0]);
        this.f1954f.setDefaultBufferSize(ActUtil.HEIGHT, 720);
        this.f1954f.setOnFrameAvailableListener(new C62712());
        C25647m c25647m = this.f1952d;
        if (c25647m != null) {
            c25647m.mo43376a(this.f1954f);
        }
        AppMethodBeat.m2505o(66253);
    }

    /* renamed from: i */
    private boolean m10257i() {
        AppMethodBeat.m2504i(66254);
        if (this.f1955g) {
            long nanoTime = System.nanoTime();
            if (nanoTime < this.f1957i + ((((this.f1956h * 1000) * 1000) * 1000) / ((long) this.f1949a))) {
                AppMethodBeat.m2505o(66254);
                return false;
            }
            if (this.f1957i == 0) {
                this.f1957i = nanoTime;
            } else if (nanoTime > this.f1957i + 1000000000) {
                this.f1956h = 0;
                this.f1957i = nanoTime;
            }
            this.f1956h++;
            AppMethodBeat.m2505o(66254);
            return true;
        }
        this.f1956h = 0;
        this.f1957i = System.nanoTime();
        AppMethodBeat.m2505o(66254);
        return false;
    }
}
