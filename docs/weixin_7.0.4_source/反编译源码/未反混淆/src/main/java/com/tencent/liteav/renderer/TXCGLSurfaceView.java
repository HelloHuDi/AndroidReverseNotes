package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.e.g;
import com.tencent.liteav.basic.e.i;
import com.tencent.liteav.basic.e.j;
import com.tencent.liteav.basic.e.k;
import com.tencent.liteav.basic.e.l;
import com.tencent.liteav.basic.e.m;
import com.tencent.liteav.basic.e.n;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class TXCGLSurfaceView extends TXCGLSurfaceViewBase implements OnFrameAvailableListener, Renderer, l {
    private boolean A;
    private n B;
    private int C;
    private int D;
    private int E;
    private m F;
    private final Queue<Runnable> G;
    WeakReference<a> a;
    private SurfaceTexture g;
    private EGLContext h;
    private g i;
    private boolean j;
    private int[] k;
    private float[] l;
    private int m;
    private boolean n;
    private float o;
    private float p;
    private int q;
    private long r;
    private long s;
    private int t;
    private boolean u;
    private boolean v;
    private Object w;
    private Handler x;
    private int y;
    private int z;

    public TXCGLSurfaceView(Context context) {
        super(context);
        AppMethodBeat.i(67183);
        this.j = false;
        this.l = new float[16];
        this.m = 0;
        this.n = false;
        this.o = 1.0f;
        this.p = 1.0f;
        this.q = 20;
        this.r = 0;
        this.s = 0;
        this.t = 12288;
        this.u = true;
        this.v = false;
        this.w = new Object();
        this.y = 0;
        this.z = 0;
        this.A = true;
        this.B = null;
        this.C = 0;
        this.G = new LinkedList();
        setEGLContextClientVersion(2);
        a(8, 8, 8, 8, 16, 0);
        setRenderer(this);
        AppMethodBeat.o(67183);
    }

    public TXCGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(67184);
        this.j = false;
        this.l = new float[16];
        this.m = 0;
        this.n = false;
        this.o = 1.0f;
        this.p = 1.0f;
        this.q = 20;
        this.r = 0;
        this.s = 0;
        this.t = 12288;
        this.u = true;
        this.v = false;
        this.w = new Object();
        this.y = 0;
        this.z = 0;
        this.A = true;
        this.B = null;
        this.C = 0;
        this.G = new LinkedList();
        setEGLContextClientVersion(2);
        a(8, 8, 8, 8, 16, 0);
        setRenderer(this);
        AppMethodBeat.o(67184);
    }

    public void setFPS(final int i) {
        AppMethodBeat.i(67185);
        b(new Runnable() {
            public void run() {
                AppMethodBeat.i(67355);
                TXCGLSurfaceView.this.q = i;
                if (TXCGLSurfaceView.this.q <= 0) {
                    TXCGLSurfaceView.this.q = 1;
                } else if (TXCGLSurfaceView.this.q > 60) {
                    TXCGLSurfaceView.this.q = 60;
                }
                TXCGLSurfaceView.this.s = 0;
                TXCGLSurfaceView.this.r = 0;
                AppMethodBeat.o(67355);
            }
        });
        AppMethodBeat.o(67185);
    }

    public void setRendMode(final int i) {
        AppMethodBeat.i(67186);
        b(new Runnable() {
            public void run() {
                AppMethodBeat.i(67336);
                TXCGLSurfaceView.this.C = i;
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                AppMethodBeat.o(67336);
            }
        });
        AppMethodBeat.o(67186);
    }

    /* Access modifiers changed, original: protected */
    public void b() {
        AppMethodBeat.i(67187);
        if (this.F != null) {
            this.F.b(null);
        }
        AppMethodBeat.o(67187);
    }

    /* Access modifiers changed, original: protected */
    public void setRunInBackground(boolean z) {
        AppMethodBeat.i(67188);
        if (z) {
            synchronized (this) {
                try {
                    TXCLog.d("TXCGLSurfaceView", "background capture enter background");
                    this.c = true;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(67188);
                }
            }
            return;
        }
        b(new Runnable() {
            public void run() {
                AppMethodBeat.i(67221);
                synchronized (this) {
                    try {
                        TXCLog.d("TXCGLSurfaceView", "background capture exit background");
                        TXCGLSurfaceView.this.c = false;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(67221);
                    }
                }
            }
        });
        AppMethodBeat.o(67188);
    }

    public void setNotifyListener(a aVar) {
        AppMethodBeat.i(67189);
        this.a = new WeakReference(aVar);
        AppMethodBeat.o(67189);
    }

    public void a(n nVar) {
        this.B = nVar;
        this.A = true;
    }

    /* JADX WARNING: Missing block: B:10:0x001f, code skipped:
            r1 = getWidth();
            r0 = getHeight();
     */
    /* JADX WARNING: Missing block: B:11:0x0029, code skipped:
            if (r9.C != 0) goto L_0x00b6;
     */
    /* JADX WARNING: Missing block: B:12:0x002b, code skipped:
            r9.D = 0;
            r9.E = 0;
     */
    /* JADX WARNING: Missing block: B:13:0x0031, code skipped:
            r9.y = r1;
            r9.z = r0;
            android.opengl.GLES20.glViewport(r9.D, r9.E, r1, r0);
     */
    /* JADX WARNING: Missing block: B:14:0x003c, code skipped:
            if (r0 == 0) goto L_0x00d1;
     */
    /* JADX WARNING: Missing block: B:15:0x003e, code skipped:
            r3 = ((float) r1) / ((float) r0);
     */
    /* JADX WARNING: Missing block: B:16:0x0042, code skipped:
            if (r14 == 0) goto L_0x00d6;
     */
    /* JADX WARNING: Missing block: B:17:0x0044, code skipped:
            r2 = ((float) r13) / ((float) r14);
     */
    /* JADX WARNING: Missing block: B:19:0x0049, code skipped:
            if (r9.n != r11) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:21:0x004d, code skipped:
            if (r9.m != r12) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:23:0x0053, code skipped:
            if (r9.o != r3) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:25:0x0059, code skipped:
            if (r9.p == r2) goto L_0x0099;
     */
    /* JADX WARNING: Missing block: B:26:0x005b, code skipped:
            r9.n = r11;
            r9.m = r12;
            r9.o = r3;
            r9.p = r2;
            r3 = (720 - r9.m) % com.tencent.wxmm.v2helper.VOIP_ENC_HEIGHT_LV1;
     */
    /* JADX WARNING: Missing block: B:27:0x006b, code skipped:
            if (r3 == 90) goto L_0x0071;
     */
    /* JADX WARNING: Missing block: B:29:0x006f, code skipped:
            if (r3 != 270) goto L_0x00da;
     */
    /* JADX WARNING: Missing block: B:30:0x0071, code skipped:
            r8 = 1;
     */
    /* JADX WARNING: Missing block: B:31:0x0073, code skipped:
            if (r8 == null) goto L_0x00dd;
     */
    /* JADX WARNING: Missing block: B:32:0x0075, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:33:0x0076, code skipped:
            if (r8 == null) goto L_0x00df;
     */
    /* JADX WARNING: Missing block: B:34:0x0078, code skipped:
            r0 = r9.i;
            r4 = com.tencent.liteav.basic.e.k.a(com.tencent.liteav.basic.e.j.NORMAL, false, true);
            r5 = ((float) r2) / ((float) r1);
     */
    /* JADX WARNING: Missing block: B:35:0x0086, code skipped:
            if (r8 == null) goto L_0x00e1;
     */
    /* JADX WARNING: Missing block: B:36:0x0088, code skipped:
            r6 = false;
     */
    /* JADX WARNING: Missing block: B:37:0x0089, code skipped:
            if (r8 == null) goto L_0x00e4;
     */
    /* JADX WARNING: Missing block: B:38:0x008b, code skipped:
            r7 = r9.n;
     */
    /* JADX WARNING: Missing block: B:39:0x008d, code skipped:
            r0.a(r13, r14, r3, r4, r5, r6, r7);
     */
    /* JADX WARNING: Missing block: B:40:0x0092, code skipped:
            if (r8 == null) goto L_0x00e6;
     */
    /* JADX WARNING: Missing block: B:41:0x0094, code skipped:
            r9.i.g();
     */
    /* JADX WARNING: Missing block: B:42:0x0099, code skipped:
            android.opengl.GLES20.glBindFramebuffer(36160, 0);
            r9.i.a(r10);
            com.tencent.matrix.trace.core.AppMethodBeat.o(67190);
     */
    /* JADX WARNING: Missing block: B:48:0x00b9, code skipped:
            if (r9.C != 1) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:49:0x00bb, code skipped:
            r2 = a(r1, r0, r13, r14);
            r1 = r2[0];
            r0 = r2[1];
            r9.D = r2[2];
            r9.E = r2[3];
     */
    /* JADX WARNING: Missing block: B:50:0x00d1, code skipped:
            r3 = 1.0f;
     */
    /* JADX WARNING: Missing block: B:51:0x00d6, code skipped:
            r2 = 1.0f;
     */
    /* JADX WARNING: Missing block: B:52:0x00da, code skipped:
            r8 = null;
     */
    /* JADX WARNING: Missing block: B:53:0x00dd, code skipped:
            r2 = r1;
     */
    /* JADX WARNING: Missing block: B:54:0x00df, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:55:0x00e1, code skipped:
            r6 = r9.n;
     */
    /* JADX WARNING: Missing block: B:56:0x00e4, code skipped:
            r7 = false;
     */
    /* JADX WARNING: Missing block: B:57:0x00e6, code skipped:
            r9.i.h();
     */
    /* JADX WARNING: Missing block: B:63:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int i, boolean z, int i2, int i3, int i4) {
        AppMethodBeat.i(67190);
        if (this.i == null) {
            AppMethodBeat.o(67190);
            return;
        }
        synchronized (this) {
            try {
                if (this.c) {
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67190);
            }
        }
    }

    private int[] a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int[] iArr = new int[4];
        float f = ((float) i4) / ((float) i3);
        int i7;
        if (((float) i2) / ((float) i) > f) {
            i7 = (int) (((float) i) * f);
            i5 = (i2 - i7) / 2;
            i6 = 0;
            i2 = i7;
        } else {
            i7 = (int) (((float) i2) / f);
            i6 = (i - i7) / 2;
            i5 = 0;
            i = i7;
        }
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i6;
        iArr[3] = i5;
        return iArr;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.g;
    }

    public void a(int i) {
        AppMethodBeat.i(67191);
        this.q = i;
        this.j = false;
        this.B = null;
        this.A = false;
        b(true);
        AppMethodBeat.o(67191);
    }

    public void a() {
        AppMethodBeat.i(67192);
        b(false);
        AppMethodBeat.o(67192);
    }

    public void setSurfaceTextureListener(m mVar) {
        this.F = mVar;
    }

    public EGLContext getGLContext() {
        return this.h;
    }

    public void a(Runnable runnable) {
        AppMethodBeat.i(67193);
        synchronized (this.G) {
            try {
                this.G.add(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67193);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public int c() {
        AppMethodBeat.i(67194);
        if (this.t != 12288) {
            TXCLog.e("TXCGLSurfaceView", "background capture swapbuffer error : " + this.t);
        }
        int i = this.t;
        AppMethodBeat.o(67194);
        return i;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(67195);
        super.onDetachedFromWindow();
        if (VERSION.SDK_INT >= 21 && this.x != null) {
            this.x.getLooper().quitSafely();
        }
        AppMethodBeat.o(67195);
    }

    public void b(Runnable runnable) {
        AppMethodBeat.i(67196);
        synchronized (this.G) {
            try {
                this.G.add(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67196);
            }
        }
    }

    /* JADX WARNING: Missing block: B:9:0x001b, code skipped:
            if (r0 != null) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:10:0x001d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(67197);
     */
    /* JADX WARNING: Missing block: B:15:0x0028, code skipped:
            r0.run();
            com.tencent.matrix.trace.core.AppMethodBeat.o(67197);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(Queue<Runnable> queue) {
        AppMethodBeat.i(67197);
        synchronized (queue) {
            try {
                if (queue.isEmpty()) {
                } else {
                    Runnable runnable = (Runnable) queue.poll();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67197);
            }
        }
        return false;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.i(67198);
        this.h = ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
        this.k = new int[1];
        this.k[0] = i.b();
        if (this.k[0] <= 0) {
            this.k = null;
            TXCLog.e("TXCGLSurfaceView", "create oes texture error!! at glsurfaceview");
            AppMethodBeat.o(67198);
            return;
        }
        this.g = new SurfaceTexture(this.k[0]);
        if (VERSION.SDK_INT >= 21) {
            if (this.x != null) {
                this.x.getLooper().quitSafely();
            }
            HandlerThread handlerThread = new HandlerThread("VideoCaptureThread");
            handlerThread.start();
            this.x = new Handler(handlerThread.getLooper());
            this.g.setOnFrameAvailableListener(this, this.x);
        } else {
            this.g.setOnFrameAvailableListener(this);
        }
        this.i = new g();
        if (this.i.a()) {
            this.i.a(k.e, k.a(j.NORMAL, false, false));
            if (this.F != null) {
                this.F.a(this.g);
            }
            AppMethodBeat.o(67198);
            return;
        }
        AppMethodBeat.o(67198);
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    /* JADX WARNING: Missing block: B:28:0x006f, code skipped:
            if (r14.F == null) goto L_0x007d;
     */
    /* JADX WARNING: Missing block: B:29:0x0071, code skipped:
            r14.F.a(r14.k[0], r14.l);
     */
    /* JADX WARNING: Missing block: B:30:0x007d, code skipped:
            f();
     */
    /* JADX WARNING: Missing block: B:31:0x0080, code skipped:
            monitor-enter(r14);
     */
    /* JADX WARNING: Missing block: B:34:0x0083, code skipped:
            if (r14.c != false) goto L_0x0086;
     */
    /* JADX WARNING: Missing block: B:35:0x0085, code skipped:
            r0 = 1;
     */
    /* JADX WARNING: Missing block: B:36:0x0086, code skipped:
            monitor-exit(r14);
     */
    /* JADX WARNING: Missing block: B:37:0x0087, code skipped:
            if (r0 == null) goto L_0x008f;
     */
    /* JADX WARNING: Missing block: B:39:?, code skipped:
            r14.t = d();
     */
    /* JADX WARNING: Missing block: B:40:0x008f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(67199);
     */
    /* JADX WARNING: Missing block: B:66:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDrawFrame(GL10 gl10) {
        long currentTimeMillis;
        Object obj = null;
        AppMethodBeat.i(67199);
        a(this.G);
        while (true) {
            currentTimeMillis = System.currentTimeMillis();
            if (this.s == 0) {
                this.s = currentTimeMillis;
            }
            if (currentTimeMillis - this.s >= (this.r * 1000) / ((long) this.q)) {
                break;
            }
            g();
        }
        this.r++;
        if (currentTimeMillis - this.s > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            this.r = 1;
            this.s = System.currentTimeMillis();
        }
        if (this.u) {
            AppMethodBeat.o(67199);
            return;
        }
        try {
            synchronized (this) {
                if (this.v) {
                    if (this.g != null) {
                        this.g.updateTexImage();
                        this.g.getTransformMatrix(this.l);
                    }
                    this.v = false;
                } else {
                    AppMethodBeat.o(67199);
                }
            }
        } catch (Exception e) {
            AppMethodBeat.o(67199);
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.o(67199);
            }
        }
    }

    private void f() {
        AppMethodBeat.i(67200);
        if (this.A) {
            if (!(this.y == 0 || this.z == 0)) {
                int i;
                int i2;
                int i3 = getWidth() <= getHeight() ? 1 : 0;
                int i4 = this.z >= this.y ? this.z : this.y;
                int i5 = this.z >= this.y ? this.y : this.z;
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
                GLES20.glReadPixels(this.D, this.E, i2, i, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, allocate);
                final int i6 = i2;
                final int i7 = i;
                new Thread(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(67356);
                        allocate.position(0);
                        createBitmap.copyPixelsFromBuffer(allocate);
                        Matrix matrix = new Matrix();
                        matrix.setScale(1.0f, -1.0f);
                        Bitmap createBitmap = Bitmap.createBitmap(createBitmap, 0, 0, i6, i7, matrix, false);
                        if (TXCGLSurfaceView.this.B != null) {
                            TXCGLSurfaceView.this.B.onTakePhotoComplete(createBitmap);
                            TXCGLSurfaceView.this.B = null;
                        }
                        createBitmap.recycle();
                        AppMethodBeat.o(67356);
                    }
                }).start();
            }
            this.A = false;
        }
        AppMethodBeat.o(67200);
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(67201);
        if (!this.j) {
            b.a(this.a, 1007, "首帧画面采集完成");
            this.j = true;
        }
        this.u = false;
        synchronized (this) {
            try {
                this.v = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67201);
            }
        }
    }

    public void a(boolean z) {
        AppMethodBeat.i(67202);
        this.u = true;
        if (z) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16384);
            this.t = d();
        }
        synchronized (this) {
            try {
                if (this.v) {
                    this.v = false;
                    if (this.g != null) {
                        this.g.updateTexImage();
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67202);
            }
        }
    }

    private void g() {
        AppMethodBeat.i(67203);
        try {
            Thread.sleep(15);
            AppMethodBeat.o(67203);
        } catch (Exception e) {
            AppMethodBeat.o(67203);
        }
    }
}
