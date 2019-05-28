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
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p141e.C25647m;
import com.tencent.liteav.basic.p141e.C32144i;
import com.tencent.liteav.basic.p141e.C37353j;
import com.tencent.liteav.basic.p141e.C37354l;
import com.tencent.liteav.basic.p141e.C45103k;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.liteav.basic.p141e.C8802n;
import com.tencent.liteav.basic.util.C17778b;
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

public class TXCGLSurfaceView extends TXCGLSurfaceViewBase implements OnFrameAvailableListener, Renderer, C37354l {
    /* renamed from: A */
    private boolean f14937A;
    /* renamed from: B */
    private C8802n f14938B;
    /* renamed from: C */
    private int f14939C;
    /* renamed from: D */
    private int f14940D;
    /* renamed from: E */
    private int f14941E;
    /* renamed from: F */
    private C25647m f14942F;
    /* renamed from: G */
    private final Queue<Runnable> f14943G;
    /* renamed from: a */
    WeakReference<C0946a> f14944a;
    /* renamed from: g */
    private SurfaceTexture f14945g;
    /* renamed from: h */
    private EGLContext f14946h;
    /* renamed from: i */
    private C8796g f14947i;
    /* renamed from: j */
    private boolean f14948j;
    /* renamed from: k */
    private int[] f14949k;
    /* renamed from: l */
    private float[] f14950l;
    /* renamed from: m */
    private int f14951m;
    /* renamed from: n */
    private boolean f14952n;
    /* renamed from: o */
    private float f14953o;
    /* renamed from: p */
    private float f14954p;
    /* renamed from: q */
    private int f14955q;
    /* renamed from: r */
    private long f14956r;
    /* renamed from: s */
    private long f14957s;
    /* renamed from: t */
    private int f14958t;
    /* renamed from: u */
    private boolean f14959u;
    /* renamed from: v */
    private boolean f14960v;
    /* renamed from: w */
    private Object f14961w;
    /* renamed from: x */
    private Handler f14962x;
    /* renamed from: y */
    private int f14963y;
    /* renamed from: z */
    private int f14964z;

    /* renamed from: com.tencent.liteav.renderer.TXCGLSurfaceView$3 */
    class C321723 implements Runnable {
        C321723() {
        }

        public void run() {
            AppMethodBeat.m2504i(67221);
            synchronized (this) {
                try {
                    TXCLog.m15675d("TXCGLSurfaceView", "background capture exit background");
                    TXCGLSurfaceView.this.f17104c = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(67221);
                }
            }
        }
    }

    public TXCGLSurfaceView(Context context) {
        super(context);
        AppMethodBeat.m2504i(67183);
        this.f14948j = false;
        this.f14950l = new float[16];
        this.f14951m = 0;
        this.f14952n = false;
        this.f14953o = 1.0f;
        this.f14954p = 1.0f;
        this.f14955q = 20;
        this.f14956r = 0;
        this.f14957s = 0;
        this.f14958t = 12288;
        this.f14959u = true;
        this.f14960v = false;
        this.f14961w = new Object();
        this.f14963y = 0;
        this.f14964z = 0;
        this.f14937A = true;
        this.f14938B = null;
        this.f14939C = 0;
        this.f14943G = new LinkedList();
        setEGLContextClientVersion(2);
        mo67349a(8, 8, 8, 8, 16, 0);
        setRenderer(this);
        AppMethodBeat.m2505o(67183);
    }

    public TXCGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(67184);
        this.f14948j = false;
        this.f14950l = new float[16];
        this.f14951m = 0;
        this.f14952n = false;
        this.f14953o = 1.0f;
        this.f14954p = 1.0f;
        this.f14955q = 20;
        this.f14956r = 0;
        this.f14957s = 0;
        this.f14958t = 12288;
        this.f14959u = true;
        this.f14960v = false;
        this.f14961w = new Object();
        this.f14963y = 0;
        this.f14964z = 0;
        this.f14937A = true;
        this.f14938B = null;
        this.f14939C = 0;
        this.f14943G = new LinkedList();
        setEGLContextClientVersion(2);
        mo67349a(8, 8, 8, 8, 16, 0);
        setRenderer(this);
        AppMethodBeat.m2505o(67184);
    }

    public void setFPS(final int i) {
        AppMethodBeat.m2504i(67185);
        mo52805b(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(67355);
                TXCGLSurfaceView.this.f14955q = i;
                if (TXCGLSurfaceView.this.f14955q <= 0) {
                    TXCGLSurfaceView.this.f14955q = 1;
                } else if (TXCGLSurfaceView.this.f14955q > 60) {
                    TXCGLSurfaceView.this.f14955q = 60;
                }
                TXCGLSurfaceView.this.f14957s = 0;
                TXCGLSurfaceView.this.f14956r = 0;
                AppMethodBeat.m2505o(67355);
            }
        });
        AppMethodBeat.m2505o(67185);
    }

    public void setRendMode(final int i) {
        AppMethodBeat.m2504i(67186);
        mo52805b(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(67336);
                TXCGLSurfaceView.this.f14939C = i;
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                AppMethodBeat.m2505o(67336);
            }
        });
        AppMethodBeat.m2505o(67186);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo52804b() {
        AppMethodBeat.m2504i(67187);
        if (this.f14942F != null) {
            this.f14942F.mo43377b(null);
        }
        AppMethodBeat.m2505o(67187);
    }

    /* Access modifiers changed, original: protected */
    public void setRunInBackground(boolean z) {
        AppMethodBeat.m2504i(67188);
        if (z) {
            synchronized (this) {
                try {
                    TXCLog.m15675d("TXCGLSurfaceView", "background capture enter background");
                    this.f17104c = true;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(67188);
                }
            }
            return;
        }
        mo52805b(new C321723());
        AppMethodBeat.m2505o(67188);
    }

    public void setNotifyListener(C0946a c0946a) {
        AppMethodBeat.m2504i(67189);
        this.f14944a = new WeakReference(c0946a);
        AppMethodBeat.m2505o(67189);
    }

    /* renamed from: a */
    public void mo52803a(C8802n c8802n) {
        this.f14938B = c8802n;
        this.f14937A = true;
    }

    /* JADX WARNING: Missing block: B:10:0x001f, code skipped:
            r1 = getWidth();
            r0 = getHeight();
     */
    /* JADX WARNING: Missing block: B:11:0x0029, code skipped:
            if (r9.f14939C != 0) goto L_0x00b6;
     */
    /* JADX WARNING: Missing block: B:12:0x002b, code skipped:
            r9.f14940D = 0;
            r9.f14941E = 0;
     */
    /* JADX WARNING: Missing block: B:13:0x0031, code skipped:
            r9.f14963y = r1;
            r9.f14964z = r0;
            android.opengl.GLES20.glViewport(r9.f14940D, r9.f14941E, r1, r0);
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
            if (r9.f14952n != r11) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:21:0x004d, code skipped:
            if (r9.f14951m != r12) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:23:0x0053, code skipped:
            if (r9.f14953o != r3) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:25:0x0059, code skipped:
            if (r9.f14954p == r2) goto L_0x0099;
     */
    /* JADX WARNING: Missing block: B:26:0x005b, code skipped:
            r9.f14952n = r11;
            r9.f14951m = r12;
            r9.f14953o = r3;
            r9.f14954p = r2;
            r3 = (720 - r9.f14951m) % com.tencent.wxmm.v2helper.VOIP_ENC_HEIGHT_LV1;
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
            r0 = r9.f14947i;
            r4 = com.tencent.liteav.basic.p141e.C45103k.m82749a(com.tencent.liteav.basic.p141e.C37353j.NORMAL, false, true);
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
            r7 = r9.f14952n;
     */
    /* JADX WARNING: Missing block: B:39:0x008d, code skipped:
            r0.mo19867a(r13, r14, r3, r4, r5, r6, r7);
     */
    /* JADX WARNING: Missing block: B:40:0x0092, code skipped:
            if (r8 == null) goto L_0x00e6;
     */
    /* JADX WARNING: Missing block: B:41:0x0094, code skipped:
            r9.f14947i.mo19885g();
     */
    /* JADX WARNING: Missing block: B:42:0x0099, code skipped:
            android.opengl.GLES20.glBindFramebuffer(36160, 0);
            r9.f14947i.mo19864a(r10);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(67190);
     */
    /* JADX WARNING: Missing block: B:48:0x00b9, code skipped:
            if (r9.f14939C != 1) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:49:0x00bb, code skipped:
            r2 = m52461a(r1, r0, r13, r14);
            r1 = r2[0];
            r0 = r2[1];
            r9.f14940D = r2[2];
            r9.f14941E = r2[3];
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
            r6 = r9.f14952n;
     */
    /* JADX WARNING: Missing block: B:56:0x00e4, code skipped:
            r7 = false;
     */
    /* JADX WARNING: Missing block: B:57:0x00e6, code skipped:
            r9.f14947i.mo19886h();
     */
    /* JADX WARNING: Missing block: B:63:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo14492a(int i, boolean z, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(67190);
        if (this.f14947i == null) {
            AppMethodBeat.m2505o(67190);
            return;
        }
        synchronized (this) {
            try {
                if (this.f17104c) {
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67190);
            }
        }
    }

    /* renamed from: a */
    private int[] m52461a(int i, int i2, int i3, int i4) {
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
        return this.f14945g;
    }

    /* renamed from: a */
    public void mo14491a(int i) {
        AppMethodBeat.m2504i(67191);
        this.f14955q = i;
        this.f14948j = false;
        this.f14938B = null;
        this.f14937A = false;
        mo67350b(true);
        AppMethodBeat.m2505o(67191);
    }

    /* renamed from: a */
    public void mo14490a() {
        AppMethodBeat.m2504i(67192);
        mo67350b(false);
        AppMethodBeat.m2505o(67192);
    }

    public void setSurfaceTextureListener(C25647m c25647m) {
        this.f14942F = c25647m;
    }

    public EGLContext getGLContext() {
        return this.f14946h;
    }

    /* renamed from: a */
    public void mo14493a(Runnable runnable) {
        AppMethodBeat.m2504i(67193);
        synchronized (this.f14943G) {
            try {
                this.f14943G.add(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67193);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public int mo52806c() {
        AppMethodBeat.m2504i(67194);
        if (this.f14958t != 12288) {
            TXCLog.m15676e("TXCGLSurfaceView", "background capture swapbuffer error : " + this.f14958t);
        }
        int i = this.f14958t;
        AppMethodBeat.m2505o(67194);
        return i;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(67195);
        super.onDetachedFromWindow();
        if (VERSION.SDK_INT >= 21 && this.f14962x != null) {
            this.f14962x.getLooper().quitSafely();
        }
        AppMethodBeat.m2505o(67195);
    }

    /* renamed from: b */
    public void mo52805b(Runnable runnable) {
        AppMethodBeat.m2504i(67196);
        synchronized (this.f14943G) {
            try {
                this.f14943G.add(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67196);
            }
        }
    }

    /* JADX WARNING: Missing block: B:9:0x001b, code skipped:
            if (r0 != null) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:10:0x001d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(67197);
     */
    /* JADX WARNING: Missing block: B:15:0x0028, code skipped:
            r0.run();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(67197);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m52460a(Queue<Runnable> queue) {
        AppMethodBeat.m2504i(67197);
        synchronized (queue) {
            try {
                if (queue.isEmpty()) {
                } else {
                    Runnable runnable = (Runnable) queue.poll();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67197);
            }
        }
        return false;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.m2504i(67198);
        this.f14946h = ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
        this.f14949k = new int[1];
        this.f14949k[0] = C32144i.m52319b();
        if (this.f14949k[0] <= 0) {
            this.f14949k = null;
            TXCLog.m15676e("TXCGLSurfaceView", "create oes texture error!! at glsurfaceview");
            AppMethodBeat.m2505o(67198);
            return;
        }
        this.f14945g = new SurfaceTexture(this.f14949k[0]);
        if (VERSION.SDK_INT >= 21) {
            if (this.f14962x != null) {
                this.f14962x.getLooper().quitSafely();
            }
            HandlerThread handlerThread = new HandlerThread("VideoCaptureThread");
            handlerThread.start();
            this.f14962x = new Handler(handlerThread.getLooper());
            this.f14945g.setOnFrameAvailableListener(this, this.f14962x);
        } else {
            this.f14945g.setOnFrameAvailableListener(this);
        }
        this.f14947i = new C8796g();
        if (this.f14947i.mo19876a()) {
            this.f14947i.mo19875a(C45103k.f17758e, C45103k.m82749a(C37353j.NORMAL, false, false));
            if (this.f14942F != null) {
                this.f14942F.mo43376a(this.f14945g);
            }
            AppMethodBeat.m2505o(67198);
            return;
        }
        AppMethodBeat.m2505o(67198);
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    /* JADX WARNING: Missing block: B:28:0x006f, code skipped:
            if (r14.f14942F == null) goto L_0x007d;
     */
    /* JADX WARNING: Missing block: B:29:0x0071, code skipped:
            r14.f14942F.mo43375a(r14.f14949k[0], r14.f14950l);
     */
    /* JADX WARNING: Missing block: B:30:0x007d, code skipped:
            m52465f();
     */
    /* JADX WARNING: Missing block: B:31:0x0080, code skipped:
            monitor-enter(r14);
     */
    /* JADX WARNING: Missing block: B:34:0x0083, code skipped:
            if (r14.f17104c != false) goto L_0x0086;
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
            r14.f14958t = mo67351d();
     */
    /* JADX WARNING: Missing block: B:40:0x008f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(67199);
     */
    /* JADX WARNING: Missing block: B:66:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDrawFrame(GL10 gl10) {
        long currentTimeMillis;
        Object obj = null;
        AppMethodBeat.m2504i(67199);
        m52460a(this.f14943G);
        while (true) {
            currentTimeMillis = System.currentTimeMillis();
            if (this.f14957s == 0) {
                this.f14957s = currentTimeMillis;
            }
            if (currentTimeMillis - this.f14957s >= (this.f14956r * 1000) / ((long) this.f14955q)) {
                break;
            }
            m52466g();
        }
        this.f14956r++;
        if (currentTimeMillis - this.f14957s > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            this.f14956r = 1;
            this.f14957s = System.currentTimeMillis();
        }
        if (this.f14959u) {
            AppMethodBeat.m2505o(67199);
            return;
        }
        try {
            synchronized (this) {
                if (this.f14960v) {
                    if (this.f14945g != null) {
                        this.f14945g.updateTexImage();
                        this.f14945g.getTransformMatrix(this.f14950l);
                    }
                    this.f14960v = false;
                } else {
                    AppMethodBeat.m2505o(67199);
                }
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(67199);
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.m2505o(67199);
            }
        }
    }

    /* renamed from: f */
    private void m52465f() {
        AppMethodBeat.m2504i(67200);
        if (this.f14937A) {
            if (!(this.f14963y == 0 || this.f14964z == 0)) {
                int i;
                int i2;
                int i3 = getWidth() <= getHeight() ? 1 : 0;
                int i4 = this.f14964z >= this.f14963y ? this.f14964z : this.f14963y;
                int i5 = this.f14964z >= this.f14963y ? this.f14963y : this.f14964z;
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
                GLES20.glReadPixels(this.f14940D, this.f14941E, i2, i, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, allocate);
                final int i6 = i2;
                final int i7 = i;
                new Thread(new Runnable() {
                    public void run() {
                        AppMethodBeat.m2504i(67356);
                        allocate.position(0);
                        createBitmap.copyPixelsFromBuffer(allocate);
                        Matrix matrix = new Matrix();
                        matrix.setScale(1.0f, -1.0f);
                        Bitmap createBitmap = Bitmap.createBitmap(createBitmap, 0, 0, i6, i7, matrix, false);
                        if (TXCGLSurfaceView.this.f14938B != null) {
                            TXCGLSurfaceView.this.f14938B.onTakePhotoComplete(createBitmap);
                            TXCGLSurfaceView.this.f14938B = null;
                        }
                        createBitmap.recycle();
                        AppMethodBeat.m2505o(67356);
                    }
                }).start();
            }
            this.f14937A = false;
        }
        AppMethodBeat.m2505o(67200);
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(67201);
        if (!this.f14948j) {
            C17778b.m27743a(this.f14944a, 1007, "首帧画面采集完成");
            this.f14948j = true;
        }
        this.f14959u = false;
        synchronized (this) {
            try {
                this.f14960v = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67201);
            }
        }
    }

    /* renamed from: a */
    public void mo14494a(boolean z) {
        AppMethodBeat.m2504i(67202);
        this.f14959u = true;
        if (z) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16384);
            this.f14958t = mo67351d();
        }
        synchronized (this) {
            try {
                if (this.f14960v) {
                    this.f14960v = false;
                    if (this.f14945g != null) {
                        this.f14945g.updateTexImage();
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67202);
            }
        }
    }

    /* renamed from: g */
    private void m52466g() {
        AppMethodBeat.m2504i(67203);
        try {
            Thread.sleep(15);
            AppMethodBeat.m2505o(67203);
        } catch (Exception e) {
            AppMethodBeat.m2505o(67203);
        }
    }
}
