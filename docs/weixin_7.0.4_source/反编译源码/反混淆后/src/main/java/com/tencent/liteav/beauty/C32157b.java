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
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p141e.C16517h;
import com.tencent.liteav.basic.p141e.C32140a;
import com.tencent.liteav.basic.p141e.C32144i;
import com.tencent.liteav.basic.p141e.C32144i.C32145a;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.C37363c.C37362b;
import com.tencent.liteav.beauty.C37363c.C8810d;
import com.tencent.liteav.beauty.p142a.p143a.C0955a;
import com.tencent.liteav.beauty.p142a.p143a.C6273c;
import com.tencent.liteav.beauty.p144b.C0960j;
import com.tencent.liteav.beauty.p144b.C16518b;
import com.tencent.liteav.beauty.p144b.C16520k;
import com.tencent.liteav.beauty.p144b.C16521l;
import com.tencent.liteav.beauty.p144b.C16523v;
import com.tencent.liteav.beauty.p144b.C17086c;
import com.tencent.liteav.beauty.p144b.C32156i;
import com.tencent.liteav.beauty.p144b.C45106n;
import com.tencent.liteav.beauty.p144b.C8807a;
import com.tencent.liteav.beauty.p144b.C8809m;
import com.tencent.liteav.beauty.p144b.p1454b.C37359a;
import com.tencent.liteav.beauty.p144b.p145a.C0957a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* renamed from: com.tencent.liteav.beauty.b */
class C32157b extends HandlerThread {
    /* renamed from: A */
    private int f14804A = 0;
    /* renamed from: B */
    private int f14805B = 0;
    /* renamed from: C */
    private boolean f14806C = false;
    /* renamed from: D */
    private float[] f14807D;
    /* renamed from: E */
    private int f14808E = 0;
    /* renamed from: F */
    private int f14809F = 0;
    /* renamed from: G */
    private C32140a f14810G = null;
    /* renamed from: H */
    private Bitmap f14811H = null;
    /* renamed from: I */
    private C16520k f14812I = null;
    /* renamed from: J */
    private C45106n f14813J = null;
    /* renamed from: K */
    private C16518b f14814K = null;
    /* renamed from: L */
    private C0957a f14815L = null;
    /* renamed from: M */
    private C37359a f14816M = null;
    /* renamed from: N */
    private C17086c f14817N = null;
    /* renamed from: O */
    private Bitmap f14818O;
    /* renamed from: P */
    private Bitmap f14819P;
    /* renamed from: Q */
    private float f14820Q;
    /* renamed from: R */
    private float f14821R;
    /* renamed from: S */
    private float f14822S;
    /* renamed from: T */
    private C16521l f14823T;
    /* renamed from: U */
    private C8809m f14824U = null;
    /* renamed from: V */
    private C16523v f14825V = null;
    /* renamed from: W */
    private C0960j f14826W = null;
    /* renamed from: X */
    private C32156i f14827X = null;
    /* renamed from: Y */
    private C8796g f14828Y = null;
    /* renamed from: Z */
    private C8796g f14829Z = null;
    /* renamed from: a */
    boolean f14830a = false;
    /* renamed from: aA */
    private byte[] f14831aA = null;
    /* renamed from: aB */
    private int f14832aB = -1;
    /* renamed from: aC */
    private int f14833aC = 0;
    /* renamed from: aD */
    private int f14834aD = 1;
    /* renamed from: aE */
    private int f14835aE = this.f14832aB;
    /* renamed from: aF */
    private C8811d f14836aF = null;
    /* renamed from: aG */
    private WeakReference<C0946a> f14837aG = new WeakReference(null);
    /* renamed from: aH */
    private C32145a f14838aH = new C321599();
    /* renamed from: aa */
    private C16517h f14839aa = null;
    /* renamed from: ab */
    private C8796g f14840ab = null;
    /* renamed from: ac */
    private final Queue<Runnable> f14841ac = new LinkedList();
    /* renamed from: ad */
    private boolean f14842ad;
    /* renamed from: ae */
    private Object f14843ae = new Object();
    /* renamed from: af */
    private Object f14844af = new Object();
    /* renamed from: ag */
    private Handler f14845ag;
    /* renamed from: ah */
    private C32163a f14846ah;
    /* renamed from: ai */
    private float f14847ai = 0.5f;
    /* renamed from: aj */
    private int f14848aj = 0;
    /* renamed from: ak */
    private int f14849ak = 0;
    /* renamed from: al */
    private int f14850al = 0;
    /* renamed from: am */
    private int f14851am = 0;
    /* renamed from: an */
    private int f14852an = 0;
    /* renamed from: ao */
    private boolean f14853ao = false;
    /* renamed from: ap */
    private C6273c f14854ap = null;
    /* renamed from: aq */
    private C0955a f14855aq = null;
    /* renamed from: ar */
    private Bitmap f14856ar = null;
    /* renamed from: as */
    private List<C8810d> f14857as = null;
    /* renamed from: at */
    private long f14858at = 0;
    /* renamed from: au */
    private int f14859au = 0;
    /* renamed from: av */
    private final int f14860av = 100;
    /* renamed from: aw */
    private final float f14861aw = 1000.0f;
    /* renamed from: ax */
    private byte[] f14862ax = null;
    /* renamed from: ay */
    private int[] f14863ay = null;
    /* renamed from: az */
    private boolean f14864az = false;
    /* renamed from: b */
    protected int[] f14865b = null;
    /* renamed from: c */
    protected int[] f14866c = null;
    /* renamed from: d */
    C8807a f14867d = new C8807a();
    /* renamed from: e */
    C8807a f14868e = new C8807a();
    /* renamed from: f */
    C8807a f14869f = new C8807a();
    /* renamed from: g */
    private int f14870g = 0;
    /* renamed from: h */
    private int f14871h = 0;
    /* renamed from: i */
    private int f14872i = 0;
    /* renamed from: j */
    private int f14873j = 0;
    /* renamed from: k */
    private int f14874k = 0;
    /* renamed from: l */
    private int f14875l = 0;
    /* renamed from: m */
    private Context f14876m = null;
    /* renamed from: n */
    private boolean f14877n = true;
    /* renamed from: o */
    private C8810d f14878o = null;
    /* renamed from: p */
    private int f14879p = -1;
    /* renamed from: q */
    private int f14880q = -1;
    /* renamed from: r */
    private int f14881r = -1;
    /* renamed from: s */
    private int f14882s = -1;
    /* renamed from: t */
    private int f14883t = -1;
    /* renamed from: u */
    private int f14884u = -1;
    /* renamed from: v */
    private int f14885v = -1;
    /* renamed from: w */
    private int f14886w = -1;
    /* renamed from: x */
    private float f14887x = 1.0f;
    /* renamed from: y */
    private int f14888y = -1;
    /* renamed from: z */
    private int f14889z = -1;

    /* renamed from: com.tencent.liteav.beauty.b$9 */
    class C321599 implements C32145a {
        C321599() {
        }
    }

    /* renamed from: com.tencent.liteav.beauty.b$a */
    class C32163a extends Handler {
        /* renamed from: b */
        private String f14905b = "EGLDrawThreadHandler";

        C32163a(Looper looper, Context context) {
            super(looper);
        }

        /* renamed from: a */
        private void m52436a(Object obj) {
            AppMethodBeat.m2504i(66902);
            TXCLog.m15677i(this.f14905b, "come into InitEGL");
            C37362b c37362b = (C37362b) obj;
            mo52787a();
            C32157b.this.f14855aq = new C0955a();
            C32157b.this.f14854ap = new C6273c(C32157b.this.f14855aq, c37362b.f15925g, c37362b.f15924f, false);
            C32157b.this.f14854ap.mo3838b();
            if (C32157b.m52376a(C32157b.this, c37362b)) {
                TXCLog.m15677i(this.f14905b, "come out InitEGL");
                AppMethodBeat.m2505o(66902);
                return;
            }
            TXCLog.m15676e(this.f14905b, "initInternal failed!");
            AppMethodBeat.m2505o(66902);
        }

        /* renamed from: a */
        public void mo52787a() {
            AppMethodBeat.m2504i(66903);
            TXCLog.m15677i(this.f14905b, "come into releaseEGL");
            if (C32157b.this.f14863ay != null && C32157b.this.f14863ay[0] > 0) {
                GLES20.glDeleteBuffers(1, C32157b.this.f14863ay, 0);
                C32157b.this.f14863ay = null;
            }
            C32157b.m52405p(C32157b.this);
            if (C32157b.this.f14854ap != null) {
                C32157b.this.f14854ap.mo14502c();
                C32157b.this.f14854ap = null;
            }
            if (C32157b.this.f14855aq != null) {
                C32157b.this.f14855aq.mo3833a();
                C32157b.this.f14855aq = null;
            }
            C32157b.this.f14853ao = false;
            NativeLoad.getInstance();
            NativeLoad.nativeDeleteYuv2Yuv();
            TXCLog.m15677i(this.f14905b, "come out releaseEGL");
            AppMethodBeat.m2505o(66903);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(Message message) {
            boolean z;
            AppMethodBeat.m2504i(66904);
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    m52436a(message.obj);
                    C32157b.this.f14853ao = true;
                    z = true;
                    break;
                case 1:
                    mo52787a();
                    C32157b.this.f14867d.mo19904a();
                    z = false;
                    break;
                case 2:
                    C32157b.m52371a(C32157b.this, (byte[]) message.obj);
                    z = false;
                    break;
                case 3:
                    C32157b.m52381b(C32157b.this, message.arg1);
                    z = true;
                    break;
                case 4:
                    C32157b.this.f14847ai = (float) (((double) message.arg1) / 100.0d);
                    if (C32157b.this.f14823T != null) {
                        C32157b.this.f14823T.mo30455a(C32157b.this.f14847ai);
                        z = false;
                        break;
                    }
                case 5:
                    C32157b.m52385b(C32157b.this, (C37362b) message.obj);
                    z = false;
                    break;
                case 7:
                    C32157b.m52370a(C32157b.this, C32157b.this.f14883t, C32157b.this.f14884u, C32157b.this.f14804A, message.arg1, message.arg2, ((Integer) message.obj).intValue());
                    C32157b.this.f14869f.mo19904a();
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
                            AppMethodBeat.m2505o(66904);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(66904);
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: b */
        public void mo52788b() {
            AppMethodBeat.m2504i(66905);
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
                try {
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(66905);
                }
            }
        }
    }

    /* renamed from: p */
    static /* synthetic */ void m52405p(C32157b c32157b) {
        AppMethodBeat.m2504i(66886);
        c32157b.m52383b();
        AppMethodBeat.m2505o(66886);
    }

    C32157b(Context context, boolean z) {
        super("TXCFilterDrawer");
        AppMethodBeat.m2504i(66847);
        this.f14876m = context;
        this.f14845ag = new Handler(this.f14876m.getMainLooper());
        this.f14842ad = z;
        AppMethodBeat.m2505o(66847);
    }

    /* renamed from: a */
    public synchronized boolean mo52770a(C37362b c37362b) {
        boolean z;
        AppMethodBeat.m2504i(66848);
        z = true;
        if (c37362b.f15928j) {
            z = m52389c(c37362b);
        } else {
            if (this.f14846ah == null) {
                start();
                this.f14846ah = new C32163a(getLooper(), this.f14876m);
            }
            this.f14846ah.obtainMessage(0, c37362b).sendToTarget();
            this.f14846ah.mo52788b();
        }
        AppMethodBeat.m2505o(66848);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public int mo52755a(int i, int i2) {
        int b;
        AppMethodBeat.m2504i(66849);
        m52373a(this.f14841ac);
        int i3 = this.f14887x != 1.0f ? 1 : 0;
        GLES20.glViewport(0, 0, this.f14885v, this.f14886w);
        if (this.f14829Z != null) {
            if (4 == i2) {
                this.f14829Z.mo19874a(this.f14807D);
            }
            i = this.f14829Z.mo3840b(i);
        }
        if (this.f14814K != null && (this.f14849ak > 0 || this.f14850al > 0 || this.f14852an > 0)) {
            i = this.f14814K.mo3840b(i);
        }
        if (this.f14823T != null) {
            i = this.f14823T.mo3840b(i);
        }
        GLES20.glViewport(0, 0, this.f14883t, this.f14884u);
        if (this.f14826W != null) {
            i = this.f14826W.mo3849a(i);
            i3 = 0;
        }
        if (this.f14827X != null) {
            b = this.f14827X.mo3840b(i);
            i3 = 0;
        } else {
            b = i;
        }
        if (i3 != 0) {
            m52388c(this.f14883t, this.f14884u);
            if (this.f14840ab != null) {
                GLES20.glViewport(0, 0, this.f14883t, this.f14884u);
                i3 = this.f14840ab.mo3840b(b);
                if (this.f14836aF != null) {
                    b = this.f14836aF.mo19908a(i3, this.f14883t, this.f14884u);
                    if (b > 0) {
                        i3 = b;
                    }
                }
                GLES20.glViewport(0, 0, this.f14883t, this.f14884u);
                if (this.f14825V != null) {
                    i3 = this.f14825V.mo3840b(i3);
                }
                if (this.f14828Y != null) {
                    GLES20.glViewport(0, 0, this.f14888y, this.f14889z);
                    i3 = this.f14828Y.mo3840b(i3);
                }
                m52400m(i3);
                AppMethodBeat.m2505o(66849);
                return i3;
            }
        }
        i3 = b;
        if (this.f14836aF != null) {
        }
        GLES20.glViewport(0, 0, this.f14883t, this.f14884u);
        if (this.f14825V != null) {
        }
        if (this.f14828Y != null) {
        }
        m52400m(i3);
        AppMethodBeat.m2505o(66849);
        return i3;
    }

    /* renamed from: a */
    public int mo52756a(byte[] bArr, int i) {
        int n;
        AppMethodBeat.m2504i(66850);
        mo52768a(bArr);
        if (this.f14842ad) {
            m52384b(bArr);
            n = m52402n(i);
        } else {
            byte[] bArr2 = (byte[]) bArr.clone();
            this.f14846ah.obtainMessage(2, bArr2).sendToTarget();
            if (!this.f14864az) {
                TXCLog.m15677i("TXCFilterDrawer", "First Frame, clear queue");
                NativeLoad.getInstance();
                NativeLoad.nativeClearQueue();
            }
            this.f14846ah.obtainMessage(3, i, 0).sendToTarget();
            m52374a(bArr2, this.f14864az);
            this.f14864az = true;
            n = -1;
        }
        AppMethodBeat.m2505o(66850);
        return n;
    }

    /* renamed from: a */
    public void mo52758a(final float f) {
        AppMethodBeat.m2504i(66851);
        this.f14847ai = f;
        m52372a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66830);
                if (C32157b.this.f14823T != null) {
                    C32157b.this.f14823T.mo30455a(f);
                }
                AppMethodBeat.m2505o(66830);
            }
        });
        AppMethodBeat.m2505o(66851);
    }

    /* renamed from: a */
    public void mo52769a(final float[] fArr) {
        AppMethodBeat.m2504i(66852);
        m52372a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66891);
                C32157b.this.f14807D = fArr;
                AppMethodBeat.m2505o(66891);
            }
        });
        AppMethodBeat.m2505o(66852);
    }

    /* renamed from: a */
    private void m52367a(C32140a c32140a, int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        int i7;
        AppMethodBeat.m2504i(66853);
        if (this.f14829Z == null) {
            TXCLog.m15677i("TXCFilterDrawer", "Create CropFilter");
            if (4 == i6) {
                this.f14829Z = new C8796g("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", true);
            } else {
                this.f14829Z = new C8796g();
            }
            if (true == this.f14829Z.mo19876a()) {
                this.f14829Z.mo19873a(true);
            } else {
                TXCLog.m15676e("TXCFilterDrawer", "mInputCropFilter init failed!");
            }
        }
        this.f14829Z.mo3839a(i3, i4);
        float[] a = this.f14829Z.mo19877a(this.f14879p, this.f14880q, null, c32140a, i6);
        int i8 = (720 - i5) % v2helper.VOIP_ENC_HEIGHT_LV1;
        if (i8 == 90 || i8 == 270) {
            i7 = i4;
        } else {
            i7 = i3;
        }
        if (i8 == 90 || i8 == 270) {
            i4 = i3;
        }
        this.f14829Z.mo19867a(i, i2, i8, a, ((float) i7) / ((float) i4), z, false);
        AppMethodBeat.m2505o(66853);
    }

    /* renamed from: a */
    private void m52366a(int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.m2504i(66854);
        synchronized (this.f14844af) {
            try {
                int i7 = ((i6 - i3) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
                TXCLog.m15677i("TXCFilterDrawer", "real outputAngle ".concat(String.valueOf(i7)));
                if (this.f14828Y == null) {
                    if (i == i4 && i2 == i5 && i7 == 0) {
                        TXCLog.m15677i("TXCFilterDrawer", "Don't need change output Image, don't create out filter!");
                    } else {
                        this.f14828Y = new C8796g();
                        if (true == this.f14828Y.mo19876a()) {
                            this.f14828Y.mo19873a(true);
                        } else {
                            TXCLog.m15676e("TXCFilterDrawer", "mOutputZoomFilter init failed!");
                        }
                    }
                }
                this.f14828Y.mo3839a(i4, i5);
                this.f14828Y.mo19868a((720 - i7) % v2helper.VOIP_ENC_HEIGHT_LV1, null);
                AppMethodBeat.m2505o(66854);
            } finally {
                AppMethodBeat.m2505o(66854);
            }
        }
    }

    /* renamed from: a */
    public void mo52762a(Bitmap bitmap, float f, float f2, float f3) {
        AppMethodBeat.m2504i(66855);
        if (this.f14878o == null) {
            this.f14878o = new C8810d();
        }
        if (this.f14878o.f2675a != null && bitmap != null && true == this.f14878o.f2675a.equals(bitmap) && f == this.f14878o.f2676b && f2 == this.f14878o.f2677c && f3 == this.f14878o.f2678d) {
            AppMethodBeat.m2505o(66855);
            return;
        }
        this.f14878o.f2675a = bitmap;
        this.f14878o.f2676b = f;
        this.f14878o.f2677c = f2;
        this.f14878o.f2678d = f3;
        final Bitmap bitmap2 = bitmap;
        final float f4 = f;
        final float f5 = f2;
        final float f6 = f3;
        m52372a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66827);
                if (bitmap2 != null) {
                    C32148a.m52321a().mo52745e();
                }
                if (bitmap2 == null) {
                    if (C32157b.this.f14825V != null) {
                        C32157b.this.f14825V.mo19883d();
                        C32157b.this.f14825V = null;
                    }
                    AppMethodBeat.m2505o(66827);
                    return;
                }
                if (C32157b.this.f14825V == null) {
                    if (C32157b.this.f14883t <= 0 || C32157b.this.f14884u <= 0) {
                        TXCLog.m15676e("TXCFilterDrawer", "output Width and Height is error!");
                        AppMethodBeat.m2505o(66827);
                        return;
                    }
                    C32157b.this.f14825V = new C16523v();
                    C32157b.this.f14825V.mo19873a(true);
                    if (C32157b.this.f14825V.mo19876a()) {
                        C32157b.this.f14825V.mo3839a(C32157b.this.f14883t, C32157b.this.f14884u);
                    } else {
                        TXCLog.m15676e("TXCFilterDrawer", "mWatermarkFilter.init failed!");
                        C32157b.this.f14825V.mo19883d();
                        C32157b.this.f14825V = null;
                        AppMethodBeat.m2505o(66827);
                        return;
                    }
                }
                C32157b.this.f14825V.mo30462c(true);
                C32157b.this.f14825V.mo30460a(bitmap2, f4, f5, f6);
                AppMethodBeat.m2505o(66827);
            }
        });
        AppMethodBeat.m2505o(66855);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo52764a(C8811d c8811d) {
        AppMethodBeat.m2504i(66856);
        TXCLog.m15677i("TXCFilterDrawer", "set listener");
        this.f14836aF = c8811d;
        AppMethodBeat.m2505o(66856);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo52763a(C0946a c0946a) {
        AppMethodBeat.m2504i(66857);
        TXCLog.m15677i("TXCFilterDrawer", "set notify");
        this.f14837aG = new WeakReference(c0946a);
        AppMethodBeat.m2505o(66857);
    }

    /* renamed from: m */
    private int m52400m(int i) {
        AppMethodBeat.m2504i(66858);
        if (this.f14809F == 0) {
            if (this.f14836aF != null) {
                this.f14836aF.mo19909a(i, this.f14888y, this.f14889z, TXCTimeUtil.getTimeTick());
            }
            AppMethodBeat.m2505o(66858);
            return i;
        } else if (1 == this.f14809F || 3 == this.f14809F || 2 == this.f14809F) {
            GLES20.glViewport(0, 0, this.f14888y, this.f14889z);
            if (this.f14813J == null) {
                TXCLog.m15676e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
                AppMethodBeat.m2505o(66858);
                return i;
            }
            GLES20.glBindFramebuffer(36160, this.f14865b[0]);
            this.f14813J.mo19864a(i);
            if (2 == this.f14809F) {
                m52380b(this.f14888y, this.f14889z);
            } else {
                m52380b(this.f14888y, (this.f14889z * 3) / 8);
            }
            GLES20.glBindFramebuffer(36160, 0);
            AppMethodBeat.m2505o(66858);
            return i;
        } else {
            TXCLog.m15676e("TXCFilterDrawer", "Don't support format!");
            AppMethodBeat.m2505o(66858);
            return -1;
        }
    }

    /* renamed from: b */
    private int m52380b(int i, int i2) {
        AppMethodBeat.m2504i(66859);
        if (true == this.f14842ad) {
            if (this.f14836aF != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlReadPixs(i, i2, this.f14862ax);
                this.f14836aF.mo19910a(this.f14862ax, this.f14888y, this.f14889z, this.f14809F, TXCTimeUtil.getTimeTick());
            } else if (this.f14831aA != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlReadPixs(i, i2, this.f14831aA);
            }
        } else if (3 == C32144i.m52309a()) {
            if (0 == this.f14858at) {
                this.f14858at = TXCTimeUtil.getTimeTick();
            }
            int i3 = this.f14859au + 1;
            this.f14859au = i3;
            if (i3 >= 100) {
                TXCLog.m15677i("TXCFilterDrawer", "Real fps ".concat(String.valueOf(100.0f / (((float) (TXCTimeUtil.getTimeTick() - this.f14858at)) / 1000.0f))));
                this.f14859au = 0;
                this.f14858at = TXCTimeUtil.getTimeTick();
            }
            GLES30.glPixelStorei(3333, 1);
            if (VERSION.SDK_INT >= 18) {
                GLES30.glReadBuffer(1029);
            }
            GLES30.glBindBuffer(35051, this.f14863ay[0]);
            NativeLoad.getInstance();
            NativeLoad.nativeGlReadPixs(i, i2, null);
            ByteBuffer byteBuffer = null;
            if (VERSION.SDK_INT >= 18) {
                byteBuffer = (ByteBuffer) GLES30.glMapBufferRange(35051, 0, (i * i2) * 4, 1);
                if (byteBuffer == null) {
                    TXCLog.m15676e("TXCFilterDrawer", "glMapBufferRange is null");
                    AppMethodBeat.m2505o(66859);
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
        AppMethodBeat.m2505o(66859);
        return 0;
    }

    /* renamed from: a */
    public void mo52760a(final int i) {
        AppMethodBeat.m2504i(66860);
        m52372a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66826);
                C32157b.this.f14809F = i;
                AppMethodBeat.m2505o(66826);
            }
        });
        AppMethodBeat.m2505o(66860);
    }

    /* renamed from: a */
    private void m52374a(byte[] bArr, boolean z) {
        AppMethodBeat.m2504i(66861);
        if (z) {
            int i = (this.f14889z * 3) / 8;
            if (2 == this.f14809F) {
                i = this.f14889z;
            }
            if (this.f14836aF != null) {
                NativeLoad.getInstance();
                if (true == NativeLoad.nativeGlReadPixsFromQueue(this.f14888y, i, this.f14862ax)) {
                    this.f14836aF.mo19910a(this.f14862ax, this.f14888y, this.f14889z, this.f14809F, TXCTimeUtil.getTimeTick());
                    AppMethodBeat.m2505o(66861);
                    return;
                }
                TXCLog.m15675d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
                this.f14836aF.mo19910a(bArr, this.f14888y, this.f14889z, this.f14809F, TXCTimeUtil.getTimeTick());
                AppMethodBeat.m2505o(66861);
                return;
            }
            NativeLoad.getInstance();
            if (!NativeLoad.nativeGlReadPixsFromQueue(this.f14888y, i, this.f14831aA)) {
                TXCLog.m15675d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
            }
            AppMethodBeat.m2505o(66861);
        } else if (this.f14836aF != null) {
            this.f14836aF.mo19910a(bArr, this.f14888y, this.f14889z, this.f14809F, TXCTimeUtil.getTimeTick());
            AppMethodBeat.m2505o(66861);
        } else {
            TXCLog.m15677i("TXCFilterDrawer", "First Frame, don't process!");
            AppMethodBeat.m2505o(66861);
        }
    }

    /* renamed from: n */
    private int m52402n(int i) {
        AppMethodBeat.m2504i(66862);
        GLES20.glViewport(0, 0, this.f14879p, this.f14880q);
        int a = mo52755a(this.f14812I.mo30454q(), i);
        AppMethodBeat.m2505o(66862);
        return a;
    }

    /* renamed from: a */
    public void mo52768a(byte[] bArr) {
        this.f14831aA = bArr;
    }

    /* renamed from: b */
    private void m52384b(byte[] bArr) {
        AppMethodBeat.m2504i(66863);
        if (this.f14812I == null) {
            TXCLog.m15676e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
            AppMethodBeat.m2505o(66863);
            return;
        }
        this.f14812I.mo30453a(bArr);
        AppMethodBeat.m2505o(66863);
    }

    /* renamed from: a */
    public void mo52757a() {
        AppMethodBeat.m2504i(66864);
        if (this.f14842ad) {
            m52383b();
        } else if (this.f14846ah != null) {
            this.f14846ah.obtainMessage(1).sendToTarget();
            try {
                this.f14867d.mo19905b();
                AppMethodBeat.m2505o(66864);
                return;
            } catch (InterruptedException e) {
                AppMethodBeat.m2505o(66864);
                return;
            }
        }
        AppMethodBeat.m2505o(66864);
    }

    /* renamed from: b */
    private void m52383b() {
        AppMethodBeat.m2504i(66865);
        TXCLog.m15677i("TXCFilterDrawer", "come into releaseInternal");
        this.f14864az = false;
        if (this.f14812I != null) {
            this.f14812I.mo19883d();
            this.f14812I = null;
        }
        if (this.f14813J != null) {
            this.f14813J.mo19883d();
            this.f14813J = null;
        }
        m52387c();
        if (this.f14823T != null) {
            this.f14823T.mo19883d();
            this.f14823T = null;
        }
        if (this.f14824U != null) {
            this.f14824U.mo19907a();
            this.f14824U = null;
        }
        if (this.f14839aa != null) {
            this.f14839aa.mo19883d();
            this.f14839aa = null;
        }
        if (this.f14829Z != null) {
            this.f14829Z.mo19883d();
            this.f14829Z = null;
        }
        if (this.f14828Y != null) {
            this.f14828Y.mo19883d();
            this.f14828Y = null;
        }
        if (this.f14825V != null) {
            this.f14825V.mo19883d();
            this.f14825V = null;
        }
        if (this.f14826W != null) {
            this.f14826W.mo3850a();
            this.f14826W = null;
        }
        if (this.f14827X != null) {
            this.f14827X.mo19883d();
            this.f14827X = null;
        }
        if (this.f14840ab != null) {
            this.f14840ab.mo19883d();
            this.f14840ab = null;
        }
        if (this.f14865b != null) {
            GLES20.glDeleteFramebuffers(1, this.f14865b, 0);
            this.f14865b = null;
        }
        if (this.f14866c != null) {
            GLES20.glDeleteTextures(1, this.f14866c, 0);
            this.f14866c = null;
        }
        this.f14878o = null;
        TXCLog.m15677i("TXCFilterDrawer", "come out releaseInternal");
        AppMethodBeat.m2505o(66865);
    }

    /* renamed from: c */
    private boolean m52389c(C37362b c37362b) {
        AppMethodBeat.m2504i(66866);
        TXCLog.m15677i("TXCFilterDrawer", "come into initInternal");
        m52383b();
        this.f14842ad = c37362b.f15928j;
        this.f14879p = c37362b.f15922d;
        this.f14880q = c37362b.f15923e;
        this.f14810G = c37362b.f15931m;
        this.f14881r = c37362b.f15925g;
        this.f14882s = c37362b.f15924f;
        this.f14804A = c37362b.f15926h;
        this.f14806C = c37362b.f15927i;
        this.f14888y = c37362b.f15920b;
        this.f14889z = c37362b.f15921c;
        this.f14805B = c37362b.f15919a;
        this.f14883t = c37362b.f15925g;
        this.f14884u = c37362b.f15924f;
        if (this.f14804A == 90 || this.f14804A == 270) {
            this.f14883t = c37362b.f15924f;
            this.f14884u = c37362b.f15925g;
        }
        this.f14809F = c37362b.f15930l;
        this.f14808E = c37362b.f15929k;
        this.f14862ax = new byte[((this.f14888y * this.f14889z) * 4)];
        TXCLog.m15677i("TXCFilterDrawer", "processWidth mPituScaleRatio is " + this.f14887x);
        if (this.f14887x != 1.0f) {
            int i = this.f14883t < this.f14884u ? this.f14883t : this.f14884u;
            if (i > 368) {
                this.f14887x = 432.0f / ((float) i);
            }
            if (this.f14887x > 1.0f) {
                this.f14887x = 1.0f;
            }
        }
        this.f14885v = (int) (((float) this.f14883t) * this.f14887x);
        this.f14886w = (int) (((float) this.f14884u) * this.f14887x);
        m52365a(this.f14885v, this.f14886w, this.f14848aj);
        if (!(this.f14878o == null || this.f14878o.f2675a == null || this.f14825V != null)) {
            TXCLog.m15677i("TXCFilterDrawer", "reset water mark!");
            mo52762a(this.f14878o.f2675a, this.f14878o.f2676b, this.f14878o.f2677c, this.f14878o.f2678d);
        }
        if (!(this.f14818O == null && this.f14819P == null) && this.f14823T == null) {
            m52364a(this.f14885v, this.f14886w, this.f14820Q, this.f14818O, this.f14821R, this.f14819P, this.f14822S);
        }
        m52367a(this.f14810G, this.f14881r, this.f14882s, this.f14885v, this.f14886w, this.f14806C, this.f14804A, this.f14808E);
        m52366a(this.f14883t, this.f14884u, this.f14804A, this.f14888y, this.f14889z, this.f14805B);
        if (this.f14865b == null) {
            this.f14865b = new int[1];
        } else {
            GLES20.glDeleteFramebuffers(1, this.f14865b, 0);
        }
        if (this.f14866c == null) {
            this.f14866c = new int[1];
        } else {
            GLES20.glDeleteTextures(1, this.f14866c, 0);
        }
        m52375a(this.f14865b, this.f14866c, this.f14888y, this.f14889z);
        if (3 == C32144i.m52309a()) {
            if (this.f14863ay == null) {
                this.f14863ay = new int[1];
            } else {
                TXCLog.m15677i("TXCFilterDrawer", "m_pbo0 is not null, delete Buffers, and recreate");
                GLES30.glDeleteBuffers(1, this.f14863ay, 0);
            }
            TXCLog.m15677i("TXCFilterDrawer", "opengl es 3.0, use PBO");
            C32144i.m52313a(this.f14881r, this.f14882s, this.f14863ay);
        }
        TXCLog.m15677i("TXCFilterDrawer", "come out initInternal");
        AppMethodBeat.m2505o(66866);
        return true;
    }

    /* renamed from: b */
    public boolean mo52772b(C37362b c37362b) {
        AppMethodBeat.m2504i(66867);
        if (this.f14842ad) {
            m52391d(c37362b);
        } else if (this.f14846ah == null) {
            TXCLog.m15676e("TXCFilterDrawer", "mThreadHandler is null!");
            AppMethodBeat.m2505o(66867);
            return false;
        } else {
            this.f14846ah.obtainMessage(5, 0, 0, c37362b).sendToTarget();
        }
        AppMethodBeat.m2505o(66867);
        return true;
    }

    /* renamed from: a */
    private void m52375a(int[] iArr, int[] iArr2, int i, int i2) {
        AppMethodBeat.m2504i(66868);
        GLES20.glGenFramebuffers(1, iArr, 0);
        iArr2[0] = C32144i.m52312a(i, i2, (int) GLFormat.GL_RGBA, (int) GLFormat.GL_RGBA, iArr2);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr2[0], 0);
        GLES20.glBindFramebuffer(36160, 0);
        AppMethodBeat.m2505o(66868);
    }

    /* renamed from: d */
    private boolean m52391d(C37362b c37362b) {
        AppMethodBeat.m2504i(66869);
        if ((1 == c37362b.f15929k || 3 == c37362b.f15929k || 2 == c37362b.f15929k) && this.f14812I == null) {
            this.f14812I = new C16520k(c37362b.f15929k);
            this.f14812I.mo19873a(true);
            if (this.f14812I.mo19876a()) {
                this.f14812I.mo3839a(c37362b.f15922d, c37362b.f15923e);
            } else {
                TXCLog.m15676e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
                AppMethodBeat.m2505o(66869);
                return false;
            }
        }
        if ((1 == c37362b.f15930l || 3 == c37362b.f15930l || 2 == c37362b.f15930l) && this.f14813J == null) {
            this.f14813J = new C45106n(c37362b.f15930l);
            if (this.f14813J.mo19876a()) {
                this.f14813J.mo3839a(c37362b.f15920b, c37362b.f15921c);
            } else {
                TXCLog.m15676e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
                AppMethodBeat.m2505o(66869);
                return false;
            }
        }
        AppMethodBeat.m2505o(66869);
        return true;
    }

    /* renamed from: b */
    public void mo52771b(final int i) {
        AppMethodBeat.m2504i(66870);
        this.f14849ak = i;
        m52372a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(67088);
                if (i > 0) {
                    C32148a.m52321a().mo52742b();
                }
                if (C32157b.this.f14814K != null && i >= 0) {
                    C32157b.this.f14814K.mo3842c(i);
                }
                AppMethodBeat.m2505o(67088);
            }
        });
        AppMethodBeat.m2505o(66870);
    }

    /* renamed from: c */
    public void mo52773c(final int i) {
        AppMethodBeat.m2504i(66871);
        if (this.f14848aj == i || i > 2 || i < 0) {
            AppMethodBeat.m2505o(66871);
            return;
        }
        this.f14848aj = i;
        m52372a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66894);
                C32157b.m52369a(C32157b.this, C32157b.this.f14885v, C32157b.this.f14886w, i);
                AppMethodBeat.m2505o(66894);
            }
        });
        AppMethodBeat.m2505o(66871);
    }

    /* renamed from: d */
    public void mo52774d(final int i) {
        AppMethodBeat.m2504i(66872);
        this.f14850al = i;
        m52372a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66846);
                if (i > 0) {
                    C32148a.m52321a().mo52743c();
                }
                if (C32157b.this.f14814K != null && i >= 0) {
                    C32157b.this.f14814K.mo3843d(i);
                }
                AppMethodBeat.m2505o(66846);
            }
        });
        AppMethodBeat.m2505o(66872);
    }

    /* renamed from: e */
    public void mo52775e(final int i) {
        AppMethodBeat.m2504i(66873);
        this.f14851am = i;
        m52372a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66893);
                if (i > 0) {
                    C32148a.m52321a().mo52743c();
                }
                if (C32157b.this.f14814K != null && i >= 0) {
                    C32157b.this.f14814K.mo3846f(i);
                }
                AppMethodBeat.m2505o(66893);
            }
        });
        AppMethodBeat.m2505o(66873);
    }

    /* renamed from: f */
    public void mo52776f(final int i) {
        AppMethodBeat.m2504i(66874);
        this.f14852an = i;
        m52372a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66825);
                if (i > 0) {
                    C32148a.m52321a().mo52743c();
                }
                if (C32157b.this.f14814K != null && i >= 0) {
                    C32157b.this.f14814K.mo3845e(i);
                }
                AppMethodBeat.m2505o(66825);
            }
        });
        AppMethodBeat.m2505o(66874);
    }

    /* renamed from: a */
    public void mo52765a(String str) {
    }

    /* renamed from: a */
    public void mo52767a(boolean z) {
    }

    /* renamed from: a */
    public void mo52766a(String str, boolean z) {
    }

    /* renamed from: a */
    public void mo52761a(Bitmap bitmap) {
        AppMethodBeat.m2504i(66875);
        mo52759a(1.0f, bitmap, this.f14847ai, null, 0.0f);
        AppMethodBeat.m2505o(66875);
    }

    /* renamed from: a */
    public void mo52759a(final float f, Bitmap bitmap, final float f2, Bitmap bitmap2, final float f3) {
        AppMethodBeat.m2504i(66876);
        if (this.f14818O == bitmap && this.f14819P == bitmap2) {
            if (!(this.f14823T == null || (this.f14820Q == f && this.f14821R == f2 && this.f14822S == f3))) {
                this.f14820Q = f;
                this.f14821R = f2;
                this.f14822S = f3;
                m52372a(new Runnable() {
                    public void run() {
                        AppMethodBeat.m2504i(66892);
                        C32157b.this.f14823T.mo30456a(f, f2, f3);
                        AppMethodBeat.m2505o(66892);
                    }
                });
            }
            AppMethodBeat.m2505o(66876);
            return;
        }
        this.f14818O = bitmap;
        this.f14819P = bitmap2;
        this.f14820Q = f;
        this.f14821R = f2;
        this.f14822S = f3;
        final float f4 = f;
        final Bitmap bitmap3 = bitmap;
        final float f5 = f2;
        final Bitmap bitmap4 = bitmap2;
        final float f6 = f3;
        m52372a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66829);
                if (C32157b.this.f14823T != null) {
                    C32148a.m52321a().mo52744d();
                }
                if (C32157b.this.f14818O == null && C32157b.this.f14819P == null) {
                    if (C32157b.this.f14823T != null) {
                        C32157b.this.f14823T.mo19883d();
                        C32157b.this.f14823T = null;
                        AppMethodBeat.m2505o(66829);
                        return;
                    }
                } else if (C32157b.this.f14823T == null) {
                    C32157b.m52368a(C32157b.this, C32157b.this.f14885v, C32157b.this.f14886w, C32157b.this.f14820Q, C32157b.this.f14818O, C32157b.this.f14821R, C32157b.this.f14819P, C32157b.this.f14822S);
                    AppMethodBeat.m2505o(66829);
                    return;
                } else {
                    C32157b.this.f14823T.mo30457a(f4, bitmap3, f5, bitmap4, f6);
                }
                AppMethodBeat.m2505o(66829);
            }
        });
        AppMethodBeat.m2505o(66876);
    }

    /* renamed from: g */
    public void mo52777g(int i) {
    }

    /* renamed from: h */
    public void mo52778h(int i) {
    }

    /* renamed from: i */
    public void mo52779i(int i) {
    }

    /* renamed from: j */
    public void mo52780j(int i) {
    }

    /* renamed from: k */
    public void mo52781k(int i) {
    }

    /* renamed from: l */
    public void mo52782l(int i) {
    }

    /* renamed from: a */
    private void m52365a(int i, int i2, int i3) {
        AppMethodBeat.m2504i(66877);
        TXCLog.m15677i("TXCFilterDrawer", "create Beauty Filter!");
        if (i3 == 0) {
            if (this.f14815L == null) {
                this.f14815L = new C0957a();
            }
            this.f14814K = this.f14815L;
        } else if (1 == i3) {
            if (this.f14816M == null) {
                this.f14816M = new C37359a();
            }
            this.f14814K = this.f14816M;
        } else if (2 == i3) {
            if (this.f14817N == null) {
                this.f14817N = new C17086c();
            }
            this.f14814K = this.f14817N;
        }
        if (this.f14814K == null) {
            TXCLog.m15676e("TXCFilterDrawer", "mBeautyFilter set error!");
            AppMethodBeat.m2505o(66877);
            return;
        }
        this.f14814K.mo19873a(true);
        if (true == this.f14814K.mo3841b(i, i2)) {
            if (this.f14849ak > 0) {
                this.f14814K.mo3842c(this.f14849ak);
            }
            if (this.f14850al > 0) {
                this.f14814K.mo3843d(this.f14850al);
            }
            if (this.f14852an > 0) {
                this.f14814K.mo3845e(this.f14852an);
            }
            if (this.f14851am > 0) {
                this.f14814K.mo3846f(this.f14851am);
                AppMethodBeat.m2505o(66877);
                return;
            }
        }
        TXCLog.m15676e("TXCFilterDrawer", "mBeautyFilter init failed!");
        AppMethodBeat.m2505o(66877);
    }

    /* renamed from: c */
    private void m52387c() {
        AppMethodBeat.m2504i(66878);
        if (this.f14815L != null) {
            this.f14815L.mo19883d();
            this.f14815L = null;
        }
        if (this.f14816M != null) {
            this.f14816M.mo19883d();
            this.f14816M = null;
        }
        if (this.f14817N != null) {
            this.f14817N.mo19883d();
            this.f14817N = null;
        }
        this.f14814K = null;
        AppMethodBeat.m2505o(66878);
    }

    /* renamed from: a */
    private void m52364a(int i, int i2, float f, Bitmap bitmap, float f2, Bitmap bitmap2, float f3) {
        AppMethodBeat.m2504i(66879);
        if (this.f14823T == null) {
            TXCLog.m15677i("TXCFilterDrawer", "createComLooKupFilter");
            this.f14823T = new C16521l(f, bitmap, f2, bitmap2, f3);
            if (true == this.f14823T.mo19876a()) {
                this.f14823T.mo19873a(true);
                this.f14823T.mo3839a(i, i2);
                AppMethodBeat.m2505o(66879);
                return;
            }
            TXCLog.m15676e("TXCFilterDrawer", "mLookupFilterGroup init failed!");
        }
        AppMethodBeat.m2505o(66879);
    }

    /* renamed from: c */
    private void m52388c(int i, int i2) {
        AppMethodBeat.m2504i(66880);
        if (this.f14840ab == null) {
            TXCLog.m15677i("TXCFilterDrawer", "createRecoverScaleFilter");
            this.f14840ab = new C8796g();
            if (true == this.f14840ab.mo19876a()) {
                this.f14840ab.mo19873a(true);
            } else {
                TXCLog.m15676e("TXCFilterDrawer", "mRecoverScaleFilter init failed!");
            }
        }
        if (this.f14840ab != null) {
            this.f14840ab.mo3839a(i, i2);
        }
        AppMethodBeat.m2505o(66880);
    }

    /* renamed from: a */
    private void m52372a(Runnable runnable) {
        AppMethodBeat.m2504i(66881);
        synchronized (this.f14841ac) {
            try {
                this.f14841ac.add(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66881);
            }
        }
    }

    /* renamed from: a */
    private void m52373a(Queue<Runnable> queue) {
        AppMethodBeat.m2504i(66882);
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
                    AppMethodBeat.m2505o(66882);
                }
            }
            if (runnable == null) {
                break;
            }
            runnable.run();
        }
    }
}
