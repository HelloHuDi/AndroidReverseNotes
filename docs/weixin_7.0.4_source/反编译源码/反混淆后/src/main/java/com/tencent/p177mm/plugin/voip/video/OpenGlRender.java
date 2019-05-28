package com.tencent.p177mm.plugin.voip.video;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.voip.video.p1045a.C29511d;
import com.tencent.p177mm.plugin.voip.video.p1045a.C43737a;
import com.tencent.p177mm.plugin.voip.video.p1045a.C46325b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.mm.plugin.voip.video.OpenGlRender */
public final class OpenGlRender implements Renderer {
    public static int FLAG_Angle270 = 12;
    public static int FLAG_Angle90 = 4;
    public static int FLAG_Mirror = 16;
    public static int FLAG_NV12 = 2;
    public static int FLAG_NV21 = 3;
    public static int FLAG_RGBA = 0;
    public static int FLAG_RGBAClip = 1;
    public static int FLAG_YV12 = 0;
    public static int FLAG_YV12Edge = 1;
    public static int MSG_FLUSH = 1;
    public static int MSG_RENDER = 0;
    public static int MSG_RESET = 2;
    public static int RenderLocal = 0;
    public static int RenderRemote = 1;
    public static String TAG = "OpenGlRender";
    public static int taQ = 0;
    static boolean taX = false;
    public float mBrightness = 1.2f;
    public float mContrast = 1.93f;
    int mRenderMode = RenderLocal;
    public float mSaturation = 1.05f;
    public boolean taA = false;
    boolean taB = false;
    boolean taC = false;
    boolean taD = false;
    int taE = 0;
    int taF = 0;
    WeakReference<OpenGlView> taG;
    public boolean taH = false;
    public Bitmap taI = null;
    private int taJ = 0;
    private int taK = 0;
    private byte[] taL = null;
    private int[] taM = null;
    private int taN;
    private int taO;
    private int taP;
    C46325b taR;
    private boolean taS;
    private int taT;
    private volatile boolean taU = false;
    public volatile boolean taV = false;
    WeakReference<Object> taW;
    boolean tat = false;
    int tau = 0;
    long tav = 0;
    long taw = 0;
    int tax = 0;
    C40040a tay;
    boolean taz = false;

    /* renamed from: com.tencent.mm.plugin.voip.video.OpenGlRender$1 */
    class C43021 implements Runnable {
        C43021() {
        }

        public final void run() {
            AppMethodBeat.m2504i(5069);
            if (OpenGlRender.this.taR != null) {
                OpenGlRender.this.taR.destroy();
            }
            AppMethodBeat.m2505o(5069);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.video.OpenGlRender$a */
    class C40040a extends C7306ak {
        public C40040a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(5070);
            OpenGlRender.this.requestRender();
            AppMethodBeat.m2505o(5070);
        }
    }

    private native void render32(int[] iArr, int i, int i2, int i3, int i4);

    private native void render8(byte[] bArr, int i, int i2, int i3, int i4);

    public final native void Init(int i, Object obj, int i2);

    public final native void Uninit(int i);

    public final native void setMode(int i, int i2, int i3, int i4);

    public final native void setParam(float f, float f2, float f3, int i);

    public static int getGLVersion() {
        int i;
        AppMethodBeat.m2504i(5071);
        if (taQ == 0) {
            if (C1443d.m3068iW(21)) {
                taQ = 2;
            } else {
                if (((ActivityManager) C4996ah.getContext().getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    i = 2;
                } else {
                    i = 1;
                }
                taQ = i;
                if (Build.MODEL.equals("Nexus 6")) {
                    taQ = 2;
                }
            }
            C4990ab.m7417i(TAG, "init gl version: %s", Integer.valueOf(taQ));
        }
        i = taQ;
        AppMethodBeat.m2505o(5071);
        return i;
    }

    public OpenGlRender(OpenGlView openGlView, int i) {
        AppMethodBeat.m2504i(5072);
        if (!taX) {
            C1449k.m3079a("mm_gl_disp", OpenGlRender.class.getClassLoader());
            taX = true;
        }
        this.mRenderMode = i;
        this.taG = new WeakReference(openGlView);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.tay = new C40040a(myLooper);
        } else {
            myLooper = Looper.getMainLooper();
            if (myLooper != null) {
                this.tay = new C40040a(myLooper);
            } else {
                this.tay = null;
            }
        }
        this.taW = null;
        if (OpenGlRender.getGLVersion() == 2) {
            this.taR = new C46325b();
        }
        this.taT = 0;
        AppMethodBeat.m2505o(5072);
    }

    public final void onDrawFrame(GL10 gl10) {
        AppMethodBeat.m2504i(5073);
        if (this.taA && this.taz && this.taG.get() != null) {
            if (this.taL != null) {
                int i = (this.taP & FLAG_Mirror) != 0 ? 1 : 0;
                if (this.taR == null || ((!this.taS || this.taT == 0) && !this.taV)) {
                    render8(this.taL, this.taN, this.taO, this.taP, this.mRenderMode);
                } else {
                    C4990ab.m7411d(TAG, "steve:doing voip beauty!beautyParam:%d", Integer.valueOf(this.taT));
                    C46325b c46325b = this.taR;
                    int i2 = this.taT;
                    if (!c46325b.eNa) {
                        c46325b.eZO = C46325b.m87011U("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
                        if (c46325b.eZO == 0) {
                            C4990ab.m7412e("MicroMsg.FilterRenderer", "checkInit, load program failed!");
                        }
                        c46325b.eZQ = GLES20.glGetAttribLocation(c46325b.eZO, "a_position");
                        c46325b.eZP = GLES20.glGetAttribLocation(c46325b.eZO, "a_texCoord");
                        c46325b.eZR = GLES20.glGetUniformLocation(c46325b.eZO, "y_texture");
                        c46325b.eZS = GLES20.glGetUniformLocation(c46325b.eZO, "uv_texture");
                        c46325b.eZT = GLES20.glGetUniformLocation(c46325b.eZO, "uMatrix");
                        c46325b.eZM = C46325b.m87012Vh();
                        c46325b.eZN = C46325b.m87012Vh();
                        c46325b.tbR = C46325b.m87011U("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D texture;                       \nvoid main (void) {                                 \n   gl_FragColor = vec4(texture2D(texture, v_texCoord).rgb, 1.0); \n}");
                        c46325b.lpE = GLES20.glGetAttribLocation(c46325b.tbR, "a_position");
                        c46325b.lpD = GLES20.glGetAttribLocation(c46325b.tbR, "a_texCoord");
                        c46325b.lpF = GLES20.glGetUniformLocation(c46325b.tbR, "texture");
                        c46325b.lpG = GLES20.glGetUniformLocation(c46325b.tbR, "uMatrix");
                        c46325b.lpC = C46325b.m87012Vh();
                        c46325b.lpS = C46325b.m87012Vh();
                        float[] fArr = C46325b.eZY;
                        c46325b.gLB = Arrays.copyOf(fArr, fArr.length);
                        c46325b.eZi = ByteBuffer.allocateDirect(c46325b.gLB.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                        c46325b.eZi.put(c46325b.gLB);
                        c46325b.eZi.position(0);
                        c46325b.eZh = ByteBuffer.allocateDirect(C46325b.eZZ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                        c46325b.eZh.put(C46325b.eZZ);
                        c46325b.eZh.position(0);
                        fArr = C46325b.tbQ;
                        c46325b.lpP = Arrays.copyOf(fArr, fArr.length);
                        c46325b.lpK = ByteBuffer.allocateDirect(c46325b.lpP.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                        c46325b.lpK.put(c46325b.lpP);
                        c46325b.lpK.position(0);
                        fArr = C46325b.eZY;
                        c46325b.lpO = Arrays.copyOf(fArr, fArr.length);
                        c46325b.lpL = ByteBuffer.allocateDirect(c46325b.lpO.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                        c46325b.lpL.put(c46325b.lpO);
                        c46325b.lpL.position(0);
                        c46325b.lpQ = C46325b.m87013Vi();
                        c46325b.sWh = null;
                        c46325b.lpR = C46325b.m87013Vi();
                        c46325b.lpU = C46325b.m87012Vh();
                        if (i2 != 0) {
                            c46325b.tbV = new C43737a();
                            c46325b.tbV.initial(c46325b.lpS, c46325b.lpU);
                        }
                        C4990ab.m7417i("MicroMsg.FilterRenderer", "%s checkInit, finish init", Integer.valueOf(c46325b.hashCode()));
                        c46325b.eNa = true;
                    }
                    this.taR.updateSize(this.taE, this.taF);
                    if (i == 0) {
                        this.taR.mo74527c(this.taL, this.taN, this.taO, this.taP, 0);
                    } else {
                        this.taR.mo74527c(this.taL, this.taN, this.taO, this.taP, this.taT);
                    }
                }
                this.taL = null;
            }
            if (this.taM != null) {
                if (this.taR != null) {
                    this.taR.reset();
                }
                render32(this.taM, this.taN, this.taO, this.taP, this.mRenderMode);
                this.taM = null;
            }
            if (this.taU && OpenGlRender.getGLVersion() == 2) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16640);
            }
            AppMethodBeat.m2505o(5073);
            return;
        }
        this.taL = null;
        this.taM = null;
        AppMethodBeat.m2505o(5073);
    }

    /* renamed from: mD */
    public final void mo63364mD(boolean z) {
        AppMethodBeat.m2504i(5074);
        C4990ab.m7417i(TAG, "drawTransparent: %s", Boolean.valueOf(z));
        this.taU = z;
        requestRender();
        AppMethodBeat.m2505o(5074);
    }

    /* renamed from: c */
    public final void mo63361c(byte[] bArr, int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(5075);
        if (this.taz && this.taL == null) {
            this.taN = i;
            this.taO = i2;
            this.taP = i3;
            this.taL = bArr;
            this.taS = z;
            requestRender();
        }
        AppMethodBeat.m2505o(5075);
    }

    /* renamed from: a */
    public final void mo63360a(int[] iArr, int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(5076);
        if (this.taz && this.taM == null) {
            this.taN = i;
            this.taO = i2;
            this.taP = i3;
            this.taM = iArr;
            this.taS = z;
            requestRender();
        }
        AppMethodBeat.m2505o(5076);
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        AppMethodBeat.m2504i(5077);
        C4990ab.m7417i(TAG, "%s onSurfaceChanged, width: %s, height: %s, self:%b, UI:%dx%d,mode:%d", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.taS), Integer.valueOf(this.taE), Integer.valueOf(this.taF), Integer.valueOf(this.mRenderMode));
        if (!(this.taE == i && this.taF == i2)) {
            gl10.glViewport(0, 0, i, i2);
            this.taE = i;
            this.taF = i2;
            if (VERSION.SDK_INT >= 23) {
                setMode(this.taE, this.taF, 1, this.mRenderMode);
            }
        }
        if (this.taR != null) {
            this.taR.updateSize(i, i2);
        }
        AppMethodBeat.m2505o(5077);
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }

    public final void cLI() {
        AppMethodBeat.m2504i(5078);
        C4990ab.m7417i(TAG, "%s onStop, renderMode: %s", Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode));
        this.taA = false;
        this.taD = false;
        AppMethodBeat.m2505o(5078);
    }

    public final void cLJ() {
        AppMethodBeat.m2504i(5079);
        C4990ab.m7417i(TAG, "%s steve: try to reset GLRender mode=%d, inited:%b, started:%b", Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode), Boolean.valueOf(this.taz), Boolean.valueOf(this.taA));
        if (this.taz && this.taA) {
            C4990ab.m7417i(TAG, "%s steve: Reset GLRender first! mode=%d", Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode));
            this.taz = false;
            this.taA = false;
            Uninit(this.mRenderMode);
            if (this.taR != null) {
                if (this.taG != null && this.taG.get() != null) {
                    ((OpenGlView) this.taG.get()).queueEvent(new C43021());
                    AppMethodBeat.m2505o(5079);
                    return;
                } else if (this.taR != null) {
                    this.taR.destroy();
                }
            }
        }
        AppMethodBeat.m2505o(5079);
    }

    public final void setVoipBeauty(int i) {
        AppMethodBeat.m2504i(5080);
        C4990ab.m7417i(TAG, "steve: isDrawingSelf:%b, set voipbeauty:%d, beautyParam:%d", Boolean.valueOf(this.taS), Integer.valueOf(i), Integer.valueOf(this.taT));
        this.taT = i;
        AppMethodBeat.m2505o(5080);
    }

    public final void requestRender() {
        AppMethodBeat.m2504i(5081);
        if (this.taz) {
            if (!this.taD) {
                setMode(((OpenGlView) this.taG.get()).getWidth(), ((OpenGlView) this.taG.get()).getHeight(), 0, this.mRenderMode);
                this.taD = true;
            }
            if (this.taG.get() != null) {
                ((OpenGlView) this.taG.get()).cLK();
            }
            AppMethodBeat.m2505o(5081);
            return;
        }
        AppMethodBeat.m2505o(5081);
    }

    /* renamed from: a */
    public final void mo63359a(C29511d c29511d) {
        AppMethodBeat.m2504i(5082);
        if (!(this.taR == null || this.taR.cLS() == null)) {
            c29511d.mo26429bu(this.taR.cLS());
        }
        AppMethodBeat.m2505o(5082);
    }
}
