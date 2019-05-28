package com.tencent.liteav.beauty;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.tencent.liteav.basic.e.g;
import com.tencent.liteav.basic.e.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.c;
import com.tencent.liteav.beauty.b.i;
import com.tencent.liteav.beauty.b.j;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.beauty.b.l;
import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.b.n;
import com.tencent.liteav.beauty.b.v;
import com.tencent.liteav.beauty.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class b extends HandlerThread {
    private int A = 0;
    private int B = 0;
    private boolean C = false;
    private float[] D;
    private int E = 0;
    private int F = 0;
    private com.tencent.liteav.basic.e.a G = null;
    private Bitmap H = null;
    private k I = null;
    private n J = null;
    private com.tencent.liteav.beauty.b.b K = null;
    private com.tencent.liteav.beauty.b.a.a L = null;
    private com.tencent.liteav.beauty.b.b.a M = null;
    private c N = null;
    private Bitmap O;
    private Bitmap P;
    private float Q;
    private float R;
    private float S;
    private l T;
    private m U = null;
    private v V = null;
    private j W = null;
    private i X = null;
    private g Y = null;
    private g Z = null;
    boolean a = false;
    private byte[] aA = null;
    private int aB = -1;
    private int aC = 0;
    private int aD = 1;
    private int aE = this.aB;
    private d aF = null;
    private WeakReference<com.tencent.liteav.basic.d.a> aG = new WeakReference(null);
    private com.tencent.liteav.basic.e.i.a aH = new com.tencent.liteav.basic.e.i.a() {
    };
    private h aa = null;
    private g ab = null;
    private final Queue<Runnable> ac = new LinkedList();
    private boolean ad;
    private Object ae = new Object();
    private Object af = new Object();
    private Handler ag;
    private a ah;
    private float ai = 0.5f;
    private int aj = 0;
    private int ak = 0;
    private int al = 0;
    private int am = 0;
    private int an = 0;
    private boolean ao = false;
    private com.tencent.liteav.beauty.a.a.c ap = null;
    private com.tencent.liteav.beauty.a.a.a aq = null;
    private Bitmap ar = null;
    private List<d> as = null;
    private long at = 0;
    private int au = 0;
    private final int av = 100;
    private final float aw = 1000.0f;
    private byte[] ax = null;
    private int[] ay = null;
    private boolean az = false;
    protected int[] b = null;
    protected int[] c = null;
    com.tencent.liteav.beauty.b.a d = new com.tencent.liteav.beauty.b.a();
    com.tencent.liteav.beauty.b.a e = new com.tencent.liteav.beauty.b.a();
    com.tencent.liteav.beauty.b.a f = new com.tencent.liteav.beauty.b.a();
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private Context m = null;
    private boolean n = true;
    private d o = null;
    private int p = -1;
    private int q = -1;
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = -1;
    private float x = 1.0f;
    private int y = -1;
    private int z = -1;

    class a extends Handler {
        private String b = "EGLDrawThreadHandler";

        a(Looper looper, Context context) {
            super(looper);
        }

        private void a(Object obj) {
            AppMethodBeat.i(66902);
            TXCLog.i(this.b, "come into InitEGL");
            b bVar = (b) obj;
            a();
            b.this.aq = new com.tencent.liteav.beauty.a.a.a();
            b.this.ap = new com.tencent.liteav.beauty.a.a.c(b.this.aq, bVar.g, bVar.f, false);
            b.this.ap.b();
            if (b.a(b.this, bVar)) {
                TXCLog.i(this.b, "come out InitEGL");
                AppMethodBeat.o(66902);
                return;
            }
            TXCLog.e(this.b, "initInternal failed!");
            AppMethodBeat.o(66902);
        }

        public void a() {
            AppMethodBeat.i(66903);
            TXCLog.i(this.b, "come into releaseEGL");
            if (b.this.ay != null && b.this.ay[0] > 0) {
                GLES20.glDeleteBuffers(1, b.this.ay, 0);
                b.this.ay = null;
            }
            b.p(b.this);
            if (b.this.ap != null) {
                b.this.ap.c();
                b.this.ap = null;
            }
            if (b.this.aq != null) {
                b.this.aq.a();
                b.this.aq = null;
            }
            b.this.ao = false;
            NativeLoad.getInstance();
            NativeLoad.nativeDeleteYuv2Yuv();
            TXCLog.i(this.b, "come out releaseEGL");
            AppMethodBeat.o(66903);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(Message message) {
            boolean z;
            AppMethodBeat.i(66904);
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    a(message.obj);
                    b.this.ao = true;
                    z = true;
                    break;
                case 1:
                    a();
                    b.this.d.a();
                    z = false;
                    break;
                case 2:
                    b.a(b.this, (byte[]) message.obj);
                    z = false;
                    break;
                case 3:
                    b.b(b.this, message.arg1);
                    z = true;
                    break;
                case 4:
                    b.this.ai = (float) (((double) message.arg1) / 100.0d);
                    if (b.this.T != null) {
                        b.this.T.a(b.this.ai);
                        z = false;
                        break;
                    }
                case 5:
                    b.b(b.this, (b) message.obj);
                    z = false;
                    break;
                case 7:
                    b.a(b.this, b.this.t, b.this.u, b.this.A, message.arg1, message.arg2, ((Integer) message.obj).intValue());
                    b.this.f.a();
                    z = false;
                    break;
            }
            z = false;
            synchronized (this) {
                if (true == z) {
                    try {
                        notify();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(66904);
                        }
                    }
                }
            }
            AppMethodBeat.o(66904);
        }

        /* Access modifiers changed, original: 0000 */
        public void b() {
            AppMethodBeat.i(66905);
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
                try {
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(66905);
                }
            }
        }
    }

    static /* synthetic */ void p(b bVar) {
        AppMethodBeat.i(66886);
        bVar.b();
        AppMethodBeat.o(66886);
    }

    b(Context context, boolean z) {
        super("TXCFilterDrawer");
        AppMethodBeat.i(66847);
        this.m = context;
        this.ag = new Handler(this.m.getMainLooper());
        this.ad = z;
        AppMethodBeat.o(66847);
    }

    public synchronized boolean a(b bVar) {
        boolean z;
        AppMethodBeat.i(66848);
        z = true;
        if (bVar.j) {
            z = c(bVar);
        } else {
            if (this.ah == null) {
                start();
                this.ah = new a(getLooper(), this.m);
            }
            this.ah.obtainMessage(0, bVar).sendToTarget();
            this.ah.b();
        }
        AppMethodBeat.o(66848);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(int i, int i2) {
        int b;
        AppMethodBeat.i(66849);
        a(this.ac);
        int i3 = this.x != 1.0f ? 1 : 0;
        GLES20.glViewport(0, 0, this.v, this.w);
        if (this.Z != null) {
            if (4 == i2) {
                this.Z.a(this.D);
            }
            i = this.Z.b(i);
        }
        if (this.K != null && (this.ak > 0 || this.al > 0 || this.an > 0)) {
            i = this.K.b(i);
        }
        if (this.T != null) {
            i = this.T.b(i);
        }
        GLES20.glViewport(0, 0, this.t, this.u);
        if (this.W != null) {
            i = this.W.a(i);
            i3 = 0;
        }
        if (this.X != null) {
            b = this.X.b(i);
            i3 = 0;
        } else {
            b = i;
        }
        if (i3 != 0) {
            c(this.t, this.u);
            if (this.ab != null) {
                GLES20.glViewport(0, 0, this.t, this.u);
                i3 = this.ab.b(b);
                if (this.aF != null) {
                    b = this.aF.a(i3, this.t, this.u);
                    if (b > 0) {
                        i3 = b;
                    }
                }
                GLES20.glViewport(0, 0, this.t, this.u);
                if (this.V != null) {
                    i3 = this.V.b(i3);
                }
                if (this.Y != null) {
                    GLES20.glViewport(0, 0, this.y, this.z);
                    i3 = this.Y.b(i3);
                }
                m(i3);
                AppMethodBeat.o(66849);
                return i3;
            }
        }
        i3 = b;
        if (this.aF != null) {
        }
        GLES20.glViewport(0, 0, this.t, this.u);
        if (this.V != null) {
        }
        if (this.Y != null) {
        }
        m(i3);
        AppMethodBeat.o(66849);
        return i3;
    }

    public int a(byte[] bArr, int i) {
        int n;
        AppMethodBeat.i(66850);
        a(bArr);
        if (this.ad) {
            b(bArr);
            n = n(i);
        } else {
            byte[] bArr2 = (byte[]) bArr.clone();
            this.ah.obtainMessage(2, bArr2).sendToTarget();
            if (!this.az) {
                TXCLog.i("TXCFilterDrawer", "First Frame, clear queue");
                NativeLoad.getInstance();
                NativeLoad.nativeClearQueue();
            }
            this.ah.obtainMessage(3, i, 0).sendToTarget();
            a(bArr2, this.az);
            this.az = true;
            n = -1;
        }
        AppMethodBeat.o(66850);
        return n;
    }

    public void a(final float f) {
        AppMethodBeat.i(66851);
        this.ai = f;
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66830);
                if (b.this.T != null) {
                    b.this.T.a(f);
                }
                AppMethodBeat.o(66830);
            }
        });
        AppMethodBeat.o(66851);
    }

    public void a(final float[] fArr) {
        AppMethodBeat.i(66852);
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66891);
                b.this.D = fArr;
                AppMethodBeat.o(66891);
            }
        });
        AppMethodBeat.o(66852);
    }

    private void a(com.tencent.liteav.basic.e.a aVar, int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        int i7;
        AppMethodBeat.i(66853);
        if (this.Z == null) {
            TXCLog.i("TXCFilterDrawer", "Create CropFilter");
            if (4 == i6) {
                this.Z = new g("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", true);
            } else {
                this.Z = new g();
            }
            if (true == this.Z.a()) {
                this.Z.a(true);
            } else {
                TXCLog.e("TXCFilterDrawer", "mInputCropFilter init failed!");
            }
        }
        this.Z.a(i3, i4);
        float[] a = this.Z.a(this.p, this.q, null, aVar, i6);
        int i8 = (720 - i5) % v2helper.VOIP_ENC_HEIGHT_LV1;
        if (i8 == 90 || i8 == 270) {
            i7 = i4;
        } else {
            i7 = i3;
        }
        if (i8 == 90 || i8 == 270) {
            i4 = i3;
        }
        this.Z.a(i, i2, i8, a, ((float) i7) / ((float) i4), z, false);
        AppMethodBeat.o(66853);
    }

    private void a(int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(66854);
        synchronized (this.af) {
            try {
                int i7 = ((i6 - i3) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
                TXCLog.i("TXCFilterDrawer", "real outputAngle ".concat(String.valueOf(i7)));
                if (this.Y == null) {
                    if (i == i4 && i2 == i5 && i7 == 0) {
                        TXCLog.i("TXCFilterDrawer", "Don't need change output Image, don't create out filter!");
                    } else {
                        this.Y = new g();
                        if (true == this.Y.a()) {
                            this.Y.a(true);
                        } else {
                            TXCLog.e("TXCFilterDrawer", "mOutputZoomFilter init failed!");
                        }
                    }
                }
                this.Y.a(i4, i5);
                this.Y.a((720 - i7) % v2helper.VOIP_ENC_HEIGHT_LV1, null);
                AppMethodBeat.o(66854);
            } finally {
                AppMethodBeat.o(66854);
            }
        }
    }

    public void a(Bitmap bitmap, float f, float f2, float f3) {
        AppMethodBeat.i(66855);
        if (this.o == null) {
            this.o = new d();
        }
        if (this.o.a != null && bitmap != null && true == this.o.a.equals(bitmap) && f == this.o.b && f2 == this.o.c && f3 == this.o.d) {
            AppMethodBeat.o(66855);
            return;
        }
        this.o.a = bitmap;
        this.o.b = f;
        this.o.c = f2;
        this.o.d = f3;
        final Bitmap bitmap2 = bitmap;
        final float f4 = f;
        final float f5 = f2;
        final float f6 = f3;
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66827);
                if (bitmap2 != null) {
                    a.a().e();
                }
                if (bitmap2 == null) {
                    if (b.this.V != null) {
                        b.this.V.d();
                        b.this.V = null;
                    }
                    AppMethodBeat.o(66827);
                    return;
                }
                if (b.this.V == null) {
                    if (b.this.t <= 0 || b.this.u <= 0) {
                        TXCLog.e("TXCFilterDrawer", "output Width and Height is error!");
                        AppMethodBeat.o(66827);
                        return;
                    }
                    b.this.V = new v();
                    b.this.V.a(true);
                    if (b.this.V.a()) {
                        b.this.V.a(b.this.t, b.this.u);
                    } else {
                        TXCLog.e("TXCFilterDrawer", "mWatermarkFilter.init failed!");
                        b.this.V.d();
                        b.this.V = null;
                        AppMethodBeat.o(66827);
                        return;
                    }
                }
                b.this.V.c(true);
                b.this.V.a(bitmap2, f4, f5, f6);
                AppMethodBeat.o(66827);
            }
        });
        AppMethodBeat.o(66855);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(d dVar) {
        AppMethodBeat.i(66856);
        TXCLog.i("TXCFilterDrawer", "set listener");
        this.aF = dVar;
        AppMethodBeat.o(66856);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(com.tencent.liteav.basic.d.a aVar) {
        AppMethodBeat.i(66857);
        TXCLog.i("TXCFilterDrawer", "set notify");
        this.aG = new WeakReference(aVar);
        AppMethodBeat.o(66857);
    }

    private int m(int i) {
        AppMethodBeat.i(66858);
        if (this.F == 0) {
            if (this.aF != null) {
                this.aF.a(i, this.y, this.z, TXCTimeUtil.getTimeTick());
            }
            AppMethodBeat.o(66858);
            return i;
        } else if (1 == this.F || 3 == this.F || 2 == this.F) {
            GLES20.glViewport(0, 0, this.y, this.z);
            if (this.J == null) {
                TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
                AppMethodBeat.o(66858);
                return i;
            }
            GLES20.glBindFramebuffer(36160, this.b[0]);
            this.J.a(i);
            if (2 == this.F) {
                b(this.y, this.z);
            } else {
                b(this.y, (this.z * 3) / 8);
            }
            GLES20.glBindFramebuffer(36160, 0);
            AppMethodBeat.o(66858);
            return i;
        } else {
            TXCLog.e("TXCFilterDrawer", "Don't support format!");
            AppMethodBeat.o(66858);
            return -1;
        }
    }

    private int b(int i, int i2) {
        AppMethodBeat.i(66859);
        if (true == this.ad) {
            if (this.aF != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlReadPixs(i, i2, this.ax);
                this.aF.a(this.ax, this.y, this.z, this.F, TXCTimeUtil.getTimeTick());
            } else if (this.aA != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlReadPixs(i, i2, this.aA);
            }
        } else if (3 == com.tencent.liteav.basic.e.i.a()) {
            if (0 == this.at) {
                this.at = TXCTimeUtil.getTimeTick();
            }
            int i3 = this.au + 1;
            this.au = i3;
            if (i3 >= 100) {
                TXCLog.i("TXCFilterDrawer", "Real fps ".concat(String.valueOf(100.0f / (((float) (TXCTimeUtil.getTimeTick() - this.at)) / 1000.0f))));
                this.au = 0;
                this.at = TXCTimeUtil.getTimeTick();
            }
            GLES30.glPixelStorei(3333, 1);
            if (VERSION.SDK_INT >= 18) {
                GLES30.glReadBuffer(1029);
            }
            GLES30.glBindBuffer(35051, this.ay[0]);
            NativeLoad.getInstance();
            NativeLoad.nativeGlReadPixs(i, i2, null);
            ByteBuffer byteBuffer = null;
            if (VERSION.SDK_INT >= 18) {
                byteBuffer = (ByteBuffer) GLES30.glMapBufferRange(35051, 0, (i * i2) * 4, 1);
                if (byteBuffer == null) {
                    TXCLog.e("TXCFilterDrawer", "glMapBufferRange is null");
                    AppMethodBeat.o(66859);
                    return -1;
                }
            }
            NativeLoad.getInstance();
            NativeLoad.nativeGlMapBufferToQueue(i, i2, byteBuffer);
            if (VERSION.SDK_INT >= 18) {
                GLES30.glUnmapBuffer(35051);
            }
            GLES30.glBindBuffer(35051, 0);
        } else {
            NativeLoad.getInstance();
            NativeLoad.nativeGlReadPixsToQueue(i, i2);
        }
        AppMethodBeat.o(66859);
        return 0;
    }

    public void a(final int i) {
        AppMethodBeat.i(66860);
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66826);
                b.this.F = i;
                AppMethodBeat.o(66826);
            }
        });
        AppMethodBeat.o(66860);
    }

    private void a(byte[] bArr, boolean z) {
        AppMethodBeat.i(66861);
        if (z) {
            int i = (this.z * 3) / 8;
            if (2 == this.F) {
                i = this.z;
            }
            if (this.aF != null) {
                NativeLoad.getInstance();
                if (true == NativeLoad.nativeGlReadPixsFromQueue(this.y, i, this.ax)) {
                    this.aF.a(this.ax, this.y, this.z, this.F, TXCTimeUtil.getTimeTick());
                    AppMethodBeat.o(66861);
                    return;
                }
                TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
                this.aF.a(bArr, this.y, this.z, this.F, TXCTimeUtil.getTimeTick());
                AppMethodBeat.o(66861);
                return;
            }
            NativeLoad.getInstance();
            if (!NativeLoad.nativeGlReadPixsFromQueue(this.y, i, this.aA)) {
                TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
            }
            AppMethodBeat.o(66861);
        } else if (this.aF != null) {
            this.aF.a(bArr, this.y, this.z, this.F, TXCTimeUtil.getTimeTick());
            AppMethodBeat.o(66861);
        } else {
            TXCLog.i("TXCFilterDrawer", "First Frame, don't process!");
            AppMethodBeat.o(66861);
        }
    }

    private int n(int i) {
        AppMethodBeat.i(66862);
        GLES20.glViewport(0, 0, this.p, this.q);
        int a = a(this.I.q(), i);
        AppMethodBeat.o(66862);
        return a;
    }

    public void a(byte[] bArr) {
        this.aA = bArr;
    }

    private void b(byte[] bArr) {
        AppMethodBeat.i(66863);
        if (this.I == null) {
            TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
            AppMethodBeat.o(66863);
            return;
        }
        this.I.a(bArr);
        AppMethodBeat.o(66863);
    }

    public void a() {
        AppMethodBeat.i(66864);
        if (this.ad) {
            b();
        } else if (this.ah != null) {
            this.ah.obtainMessage(1).sendToTarget();
            try {
                this.d.b();
                AppMethodBeat.o(66864);
                return;
            } catch (InterruptedException e) {
                AppMethodBeat.o(66864);
                return;
            }
        }
        AppMethodBeat.o(66864);
    }

    private void b() {
        AppMethodBeat.i(66865);
        TXCLog.i("TXCFilterDrawer", "come into releaseInternal");
        this.az = false;
        if (this.I != null) {
            this.I.d();
            this.I = null;
        }
        if (this.J != null) {
            this.J.d();
            this.J = null;
        }
        c();
        if (this.T != null) {
            this.T.d();
            this.T = null;
        }
        if (this.U != null) {
            this.U.a();
            this.U = null;
        }
        if (this.aa != null) {
            this.aa.d();
            this.aa = null;
        }
        if (this.Z != null) {
            this.Z.d();
            this.Z = null;
        }
        if (this.Y != null) {
            this.Y.d();
            this.Y = null;
        }
        if (this.V != null) {
            this.V.d();
            this.V = null;
        }
        if (this.W != null) {
            this.W.a();
            this.W = null;
        }
        if (this.X != null) {
            this.X.d();
            this.X = null;
        }
        if (this.ab != null) {
            this.ab.d();
            this.ab = null;
        }
        if (this.b != null) {
            GLES20.glDeleteFramebuffers(1, this.b, 0);
            this.b = null;
        }
        if (this.c != null) {
            GLES20.glDeleteTextures(1, this.c, 0);
            this.c = null;
        }
        this.o = null;
        TXCLog.i("TXCFilterDrawer", "come out releaseInternal");
        AppMethodBeat.o(66865);
    }

    private boolean c(b bVar) {
        AppMethodBeat.i(66866);
        TXCLog.i("TXCFilterDrawer", "come into initInternal");
        b();
        this.ad = bVar.j;
        this.p = bVar.d;
        this.q = bVar.e;
        this.G = bVar.m;
        this.r = bVar.g;
        this.s = bVar.f;
        this.A = bVar.h;
        this.C = bVar.i;
        this.y = bVar.b;
        this.z = bVar.c;
        this.B = bVar.a;
        this.t = bVar.g;
        this.u = bVar.f;
        if (this.A == 90 || this.A == 270) {
            this.t = bVar.f;
            this.u = bVar.g;
        }
        this.F = bVar.l;
        this.E = bVar.k;
        this.ax = new byte[((this.y * this.z) * 4)];
        TXCLog.i("TXCFilterDrawer", "processWidth mPituScaleRatio is " + this.x);
        if (this.x != 1.0f) {
            int i = this.t < this.u ? this.t : this.u;
            if (i > 368) {
                this.x = 432.0f / ((float) i);
            }
            if (this.x > 1.0f) {
                this.x = 1.0f;
            }
        }
        this.v = (int) (((float) this.t) * this.x);
        this.w = (int) (((float) this.u) * this.x);
        a(this.v, this.w, this.aj);
        if (!(this.o == null || this.o.a == null || this.V != null)) {
            TXCLog.i("TXCFilterDrawer", "reset water mark!");
            a(this.o.a, this.o.b, this.o.c, this.o.d);
        }
        if (!(this.O == null && this.P == null) && this.T == null) {
            a(this.v, this.w, this.Q, this.O, this.R, this.P, this.S);
        }
        a(this.G, this.r, this.s, this.v, this.w, this.C, this.A, this.E);
        a(this.t, this.u, this.A, this.y, this.z, this.B);
        if (this.b == null) {
            this.b = new int[1];
        } else {
            GLES20.glDeleteFramebuffers(1, this.b, 0);
        }
        if (this.c == null) {
            this.c = new int[1];
        } else {
            GLES20.glDeleteTextures(1, this.c, 0);
        }
        a(this.b, this.c, this.y, this.z);
        if (3 == com.tencent.liteav.basic.e.i.a()) {
            if (this.ay == null) {
                this.ay = new int[1];
            } else {
                TXCLog.i("TXCFilterDrawer", "m_pbo0 is not null, delete Buffers, and recreate");
                GLES30.glDeleteBuffers(1, this.ay, 0);
            }
            TXCLog.i("TXCFilterDrawer", "opengl es 3.0, use PBO");
            com.tencent.liteav.basic.e.i.a(this.r, this.s, this.ay);
        }
        TXCLog.i("TXCFilterDrawer", "come out initInternal");
        AppMethodBeat.o(66866);
        return true;
    }

    public boolean b(b bVar) {
        AppMethodBeat.i(66867);
        if (this.ad) {
            d(bVar);
        } else if (this.ah == null) {
            TXCLog.e("TXCFilterDrawer", "mThreadHandler is null!");
            AppMethodBeat.o(66867);
            return false;
        } else {
            this.ah.obtainMessage(5, 0, 0, bVar).sendToTarget();
        }
        AppMethodBeat.o(66867);
        return true;
    }

    private void a(int[] iArr, int[] iArr2, int i, int i2) {
        AppMethodBeat.i(66868);
        GLES20.glGenFramebuffers(1, iArr, 0);
        iArr2[0] = com.tencent.liteav.basic.e.i.a(i, i2, (int) GLFormat.GL_RGBA, (int) GLFormat.GL_RGBA, iArr2);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr2[0], 0);
        GLES20.glBindFramebuffer(36160, 0);
        AppMethodBeat.o(66868);
    }

    private boolean d(b bVar) {
        AppMethodBeat.i(66869);
        if ((1 == bVar.k || 3 == bVar.k || 2 == bVar.k) && this.I == null) {
            this.I = new k(bVar.k);
            this.I.a(true);
            if (this.I.a()) {
                this.I.a(bVar.d, bVar.e);
            } else {
                TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
                AppMethodBeat.o(66869);
                return false;
            }
        }
        if ((1 == bVar.l || 3 == bVar.l || 2 == bVar.l) && this.J == null) {
            this.J = new n(bVar.l);
            if (this.J.a()) {
                this.J.a(bVar.b, bVar.c);
            } else {
                TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
                AppMethodBeat.o(66869);
                return false;
            }
        }
        AppMethodBeat.o(66869);
        return true;
    }

    public void b(final int i) {
        AppMethodBeat.i(66870);
        this.ak = i;
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(67088);
                if (i > 0) {
                    a.a().b();
                }
                if (b.this.K != null && i >= 0) {
                    b.this.K.c(i);
                }
                AppMethodBeat.o(67088);
            }
        });
        AppMethodBeat.o(66870);
    }

    public void c(final int i) {
        AppMethodBeat.i(66871);
        if (this.aj == i || i > 2 || i < 0) {
            AppMethodBeat.o(66871);
            return;
        }
        this.aj = i;
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66894);
                b.a(b.this, b.this.v, b.this.w, i);
                AppMethodBeat.o(66894);
            }
        });
        AppMethodBeat.o(66871);
    }

    public void d(final int i) {
        AppMethodBeat.i(66872);
        this.al = i;
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66846);
                if (i > 0) {
                    a.a().c();
                }
                if (b.this.K != null && i >= 0) {
                    b.this.K.d(i);
                }
                AppMethodBeat.o(66846);
            }
        });
        AppMethodBeat.o(66872);
    }

    public void e(final int i) {
        AppMethodBeat.i(66873);
        this.am = i;
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66893);
                if (i > 0) {
                    a.a().c();
                }
                if (b.this.K != null && i >= 0) {
                    b.this.K.f(i);
                }
                AppMethodBeat.o(66893);
            }
        });
        AppMethodBeat.o(66873);
    }

    public void f(final int i) {
        AppMethodBeat.i(66874);
        this.an = i;
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66825);
                if (i > 0) {
                    a.a().c();
                }
                if (b.this.K != null && i >= 0) {
                    b.this.K.e(i);
                }
                AppMethodBeat.o(66825);
            }
        });
        AppMethodBeat.o(66874);
    }

    public void a(String str) {
    }

    public void a(boolean z) {
    }

    public void a(String str, boolean z) {
    }

    public void a(Bitmap bitmap) {
        AppMethodBeat.i(66875);
        a(1.0f, bitmap, this.ai, null, 0.0f);
        AppMethodBeat.o(66875);
    }

    public void a(final float f, Bitmap bitmap, final float f2, Bitmap bitmap2, final float f3) {
        AppMethodBeat.i(66876);
        if (this.O == bitmap && this.P == bitmap2) {
            if (!(this.T == null || (this.Q == f && this.R == f2 && this.S == f3))) {
                this.Q = f;
                this.R = f2;
                this.S = f3;
                a(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(66892);
                        b.this.T.a(f, f2, f3);
                        AppMethodBeat.o(66892);
                    }
                });
            }
            AppMethodBeat.o(66876);
            return;
        }
        this.O = bitmap;
        this.P = bitmap2;
        this.Q = f;
        this.R = f2;
        this.S = f3;
        final float f4 = f;
        final Bitmap bitmap3 = bitmap;
        final float f5 = f2;
        final Bitmap bitmap4 = bitmap2;
        final float f6 = f3;
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66829);
                if (b.this.T != null) {
                    a.a().d();
                }
                if (b.this.O == null && b.this.P == null) {
                    if (b.this.T != null) {
                        b.this.T.d();
                        b.this.T = null;
                        AppMethodBeat.o(66829);
                        return;
                    }
                } else if (b.this.T == null) {
                    b.a(b.this, b.this.v, b.this.w, b.this.Q, b.this.O, b.this.R, b.this.P, b.this.S);
                    AppMethodBeat.o(66829);
                    return;
                } else {
                    b.this.T.a(f4, bitmap3, f5, bitmap4, f6);
                }
                AppMethodBeat.o(66829);
            }
        });
        AppMethodBeat.o(66876);
    }

    public void g(int i) {
    }

    public void h(int i) {
    }

    public void i(int i) {
    }

    public void j(int i) {
    }

    public void k(int i) {
    }

    public void l(int i) {
    }

    private void a(int i, int i2, int i3) {
        AppMethodBeat.i(66877);
        TXCLog.i("TXCFilterDrawer", "create Beauty Filter!");
        if (i3 == 0) {
            if (this.L == null) {
                this.L = new com.tencent.liteav.beauty.b.a.a();
            }
            this.K = this.L;
        } else if (1 == i3) {
            if (this.M == null) {
                this.M = new com.tencent.liteav.beauty.b.b.a();
            }
            this.K = this.M;
        } else if (2 == i3) {
            if (this.N == null) {
                this.N = new c();
            }
            this.K = this.N;
        }
        if (this.K == null) {
            TXCLog.e("TXCFilterDrawer", "mBeautyFilter set error!");
            AppMethodBeat.o(66877);
            return;
        }
        this.K.a(true);
        if (true == this.K.b(i, i2)) {
            if (this.ak > 0) {
                this.K.c(this.ak);
            }
            if (this.al > 0) {
                this.K.d(this.al);
            }
            if (this.an > 0) {
                this.K.e(this.an);
            }
            if (this.am > 0) {
                this.K.f(this.am);
                AppMethodBeat.o(66877);
                return;
            }
        }
        TXCLog.e("TXCFilterDrawer", "mBeautyFilter init failed!");
        AppMethodBeat.o(66877);
    }

    private void c() {
        AppMethodBeat.i(66878);
        if (this.L != null) {
            this.L.d();
            this.L = null;
        }
        if (this.M != null) {
            this.M.d();
            this.M = null;
        }
        if (this.N != null) {
            this.N.d();
            this.N = null;
        }
        this.K = null;
        AppMethodBeat.o(66878);
    }

    private void a(int i, int i2, float f, Bitmap bitmap, float f2, Bitmap bitmap2, float f3) {
        AppMethodBeat.i(66879);
        if (this.T == null) {
            TXCLog.i("TXCFilterDrawer", "createComLooKupFilter");
            this.T = new l(f, bitmap, f2, bitmap2, f3);
            if (true == this.T.a()) {
                this.T.a(true);
                this.T.a(i, i2);
                AppMethodBeat.o(66879);
                return;
            }
            TXCLog.e("TXCFilterDrawer", "mLookupFilterGroup init failed!");
        }
        AppMethodBeat.o(66879);
    }

    private void c(int i, int i2) {
        AppMethodBeat.i(66880);
        if (this.ab == null) {
            TXCLog.i("TXCFilterDrawer", "createRecoverScaleFilter");
            this.ab = new g();
            if (true == this.ab.a()) {
                this.ab.a(true);
            } else {
                TXCLog.e("TXCFilterDrawer", "mRecoverScaleFilter init failed!");
            }
        }
        if (this.ab != null) {
            this.ab.a(i, i2);
        }
        AppMethodBeat.o(66880);
    }

    private void a(Runnable runnable) {
        AppMethodBeat.i(66881);
        synchronized (this.ac) {
            try {
                this.ac.add(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66881);
            }
        }
    }

    private void a(Queue<Runnable> queue) {
        AppMethodBeat.i(66882);
        while (true) {
            Runnable runnable = null;
            synchronized (queue) {
                try {
                    if (!queue.isEmpty()) {
                        runnable = (Runnable) queue.poll();
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(66882);
                }
            }
            if (runnable == null) {
                break;
            }
            runnable.run();
        }
    }
}
