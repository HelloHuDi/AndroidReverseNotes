package com.tencent.p177mm.media.p254g;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.p255h.C42173c;
import com.tencent.p177mm.media.p867i.C42175b;
import com.tencent.p177mm.media.p867i.C42175b.C26386a;
import com.tencent.p177mm.media.p867i.C42175b.C9609b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0014\b\u0016\u0018\u0000 Z2\u00020\u0001:\u0001ZB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00104\u001a\u00020-J5\u00105\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-2%\b\u0002\u00106\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nJ\b\u0010:\u001a\u00020\u000eH\u0002JM\u0010;\u001a\u00020\u000e2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2#\u00106\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nH\u0016JK\u0010A\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\b\b\u0002\u0010B\u001a\u00020\r2%\b\u0002\u00106\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nJ\u0016\u0010C\u001a\u00020\u000e2\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\"J\u0006\u0010D\u001a\u00020\u000eJ\u000e\u0010E\u001a\u00020\u000e2\u0006\u00102\u001a\u000203J9\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u000b2!\u0010I\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u000e0\nJ\u0016\u0010E\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020?2\u0006\u0010H\u001a\u00020\u000bJ\"\u0010E\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010L\u001a\u00020\rJ\u001a\u0010M\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010N\u001a\u00020\u000e2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0\"J\u0012\u0010O\u001a\u00020\u000e2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ \u0010P\u001a\u00020\u000e2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\nJ\b\u0010Q\u001a\u00020\u000eH\u0002J\u0018\u0010R\u001a\u00020\u000e2\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\"J\b\u0010S\u001a\u00020\u000eH\u0002J\u0010\u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020\u000bH\u0004J\u000e\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020?J\u0016\u0010X\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?J\u0016\u0010Y\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?J\b\u0010B\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n '*\u0004\u0018\u00010&0&X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0004R\u000e\u0010+\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000¨\u0006["}, dWq = {"Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "TAG", "", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "Lkotlin/Function1;", "", "drawCallback", "", "", "getDrawCallback", "()Lkotlin/jvm/functions/Function1;", "setDrawCallback", "(Lkotlin/jvm/functions/Function1;)V", "drawInOnFrameAvailable", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "firstFrame", "isFirstFrameAvailable", "isReleased", "lastFrameTimestamp", "newFrameAvailable", "newFrameLock", "Ljava/lang/Object;", "onDrawFrameOnFrameAvailableFailed", "Lkotlin/Function0;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "setUpEnvWithShareContext", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getOutputSurface", "initForRemuxer", "callback", "Lkotlin/ParameterName;", "name", "success", "initSurfaceTexture", "initWithSize", "eglContext", "Landroid/opengl/EGLContext;", "width", "", "height", "initWithSurface", "waitNewFrame", "queue", "release", "requestDraw", "data", "", "pts", "inputCallback", "textureId", "bitmap", "waitFistFrameAvailable", "requestDrawInGLThread", "runInGlesThread", "setDrawBlendBitmap", "setDrawBlendBitmapProvider", "setFirstFrameAvailable", "setOnDrawFrameOnFrameAvailableFailed", "setOnFrameAvailable", "setPresentationTime", "nsecs", "setRotate", "degree", "updateDrawSize", "updateTextureSize", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.g.a */
public final class C9587a {
    public static final C9588a eXn = new C9588a();
    public final String TAG = "MicroMsg.CodecInputSurface";
    private volatile boolean aAP;
    public Surface aOO;
    private SurfaceTexture bsb;
    private final HandlerThread eXa = C7305d.anM("CodecInputSurface_renderThread");
    private C7306ak eXb;
    C9609b eXc;
    public C17126b<? super Boolean, C37091y> eXd;
    private final Object eXe = new Object();
    private boolean eXf;
    private volatile boolean eXg;
    public C17126b<? super Long, Bitmap> eXh;
    Bitmap eXi;
    boolean eXj;
    C31214a<C37091y> eXk;
    private boolean eXl;
    C37897a eXm;
    private long lastFrameTimestamp;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.a$h */
    static final class C9585h extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C9587a eXo;
        final /* synthetic */ long eXu;
        final /* synthetic */ int eXx;

        C9585h(C9587a c9587a, int i, long j) {
            this.eXo = c9587a;
            this.eXx = i;
            this.eXu = j;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13013);
            C17126b c17126b;
            try {
                this.eXo.eXm.input(this.eXx);
                this.eXo.eXm.mo60640Vd();
                if (this.eXo.aOO != null) {
                    this.eXo.setPresentationTime(this.eXu);
                    C9609b c9609b = this.eXo.eXc;
                    if (c9609b != null) {
                        C26386a c26386a = C42175b.fad;
                        C26386a.m41986a(c9609b.fae, c9609b.faf);
                    }
                }
                c17126b = this.eXo.eXd;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.TRUE);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.eXo.TAG, e, "", new Object[0]);
                c17126b = this.eXo.eXd;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.FALSE);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13013);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
    /* renamed from: com.tencent.mm.media.g.a$j */
    static final class C9586j implements OnFrameAvailableListener {
        final /* synthetic */ C9587a eXo;

        C9586j(C9587a c9587a) {
            this.eXo = c9587a;
        }

        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Object valueOf;
            AppMethodBeat.m2504i(13016);
            String b = this.eXo.TAG;
            StringBuilder append = new StringBuilder("onFrameAvailable, thread:").append(Thread.currentThread()).append(", surface timestamp:");
            SurfaceTexture f = this.eXo.bsb;
            if (f != null) {
                valueOf = Long.valueOf(f.getTimestamp());
            } else {
                valueOf = null;
            }
            C4990ab.m7416i(b, append.append(valueOf).append(", drawInOnFrameAvailable:").append(this.eXo.eXj).toString());
            f = this.eXo.bsb;
            if (f == null) {
                AppMethodBeat.m2505o(13016);
            } else if (!this.eXo.eXg || f.getTimestamp() > 0) {
                if (!this.eXo.eXg) {
                    this.eXo.eXg = true;
                }
                if (this.eXo.eXj) {
                    long timestamp;
                    Bitmap j;
                    C9587a c9587a;
                    if (this.eXo.eXi != null) {
                        C9587a c9587a2 = this.eXo;
                        timestamp = f.getTimestamp();
                        j = this.eXo.eXi;
                        c9587a = c9587a2;
                    } else {
                        c9587a = this.eXo;
                        timestamp = f.getTimestamp();
                        C17126b k = this.eXo.eXh;
                        j = k != null ? (Bitmap) k.mo50am(Long.valueOf(f.getTimestamp() / 1000)) : null;
                    }
                    C9587a.m17073a(c9587a, timestamp, j);
                }
                AppMethodBeat.m2505o(13016);
            } else {
                this.eXo.eXj = false;
                C31214a i = this.eXo.eXk;
                if (i != null) {
                    i.invoke();
                    AppMethodBeat.m2505o(13016);
                    return;
                }
                AppMethodBeat.m2505o(13016);
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/remuxer/CodecInputSurface$Companion;", "", "()V", "TIME_COST_TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.g.a$a */
    public static final class C9588a {
        private C9588a() {
        }

        public /* synthetic */ C9588a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.a$c */
    public static final class C9589c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C9587a eXo;
        final /* synthetic */ EGLContext eXq;
        final /* synthetic */ int eXr;
        final /* synthetic */ int eXs;
        final /* synthetic */ C17126b exI;

        public C9589c(C9587a c9587a, EGLContext eGLContext, int i, int i2, C17126b c17126b) {
            this.eXo = c9587a;
            this.eXq = eGLContext;
            this.eXr = i;
            this.eXs = i2;
            this.exI = c17126b;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13008);
            C17126b c17126b;
            try {
                C9587a c9587a;
                C26386a c26386a;
                if (this.eXq == null) {
                    this.eXo.eXf = false;
                    c9587a = this.eXo;
                    c26386a = C42175b.fad;
                    c9587a.eXc = C26386a.m41987b(null, this.eXr, this.eXs);
                    this.eXo.eXm.mo60643cs(true);
                    C9587a.m17072a(this.eXo);
                } else {
                    this.eXo.eXf = true;
                    c9587a = this.eXo;
                    c26386a = C42175b.fad;
                    c9587a.eXc = C26386a.m41985a(this.eXq, null, this.eXr, this.eXs);
                    this.eXo.eXm.mo60643cs(false);
                }
                C4990ab.m7416i(this.eXo.TAG, this.eXo.hashCode() + " initWithSize finish");
                c17126b = this.exI;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.TRUE);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.eXo.TAG, e, "initWithSize error!", new Object[0]);
                c17126b = this.exI;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.FALSE);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13008);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.a$b */
    static final class C9590b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C9587a eXo;
        final /* synthetic */ Surface eXp;
        final /* synthetic */ C17126b exI;

        C9590b(C9587a c9587a, Surface surface, C17126b c17126b) {
            this.eXo = c9587a;
            this.eXp = surface;
            this.exI = c17126b;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13007);
            C17126b c17126b;
            try {
                this.eXo.eXf = false;
                C9587a c9587a = this.eXo;
                C26386a c26386a = C42175b.fad;
                c9587a.eXc = C26386a.m41987b(this.eXp, 0, 0);
                this.eXo.eXm.mo60643cs(true);
                C9587a.m17072a(this.eXo);
                C9587a.m17076c(this.eXo);
                c17126b = this.exI;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.TRUE);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.eXo.TAG, e, "initWithSurface failed", new Object[0]);
                c17126b = this.exI;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.FALSE);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13007);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.a$i */
    public static final class C9591i extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C9587a eXo;
        final /* synthetic */ SurfaceTexture eXy;

        public C9591i(C9587a c9587a, SurfaceTexture surfaceTexture) {
            this.eXo = c9587a;
            this.eXy = surfaceTexture;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13014);
            C17126b c17126b;
            try {
                this.eXy.attachToGLContext(this.eXo.eXm.eYN);
                this.eXy.updateTexImage();
                this.eXo.eXm.input(this.eXo.eXm.eYN);
                this.eXo.eXm.mo60640Vd();
                if (this.eXo.aOO != null) {
                    this.eXo.setPresentationTime(System.nanoTime());
                    C9609b c9609b = this.eXo.eXc;
                    if (c9609b != null) {
                        C26386a c26386a = C42175b.fad;
                        C26386a.m41986a(c9609b.fae, c9609b.faf);
                    }
                }
                this.eXy.detachFromGLContext();
                c17126b = this.eXo.eXd;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.TRUE);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.eXo.TAG, e, "", new Object[0]);
                c17126b = this.eXo.eXd;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.FALSE);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13014);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.a$f */
    static final class C9592f extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C9587a eXo;
        final /* synthetic */ boolean eXt = true;
        final /* synthetic */ long eXu;
        final /* synthetic */ Bitmap eyc;

        C9592f(C9587a c9587a, long j, Bitmap bitmap) {
            this.eXo = c9587a;
            this.eXu = j;
            this.eyc = bitmap;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13011);
            C17126b c17126b;
            if (!this.eXt || this.eXo.eXg) {
                try {
                    C4990ab.m7410d(this.eXo.TAG, "render pts:" + this.eXu);
                    if (this.eXu <= 0) {
                        C4990ab.m7412e(this.eXo.TAG, "pts error:" + this.eXu);
                        c17126b = this.eXo.eXd;
                        if (c17126b != null) {
                            c17126b.mo50am(Boolean.FALSE);
                        }
                    } else {
                        long yz = C5046bo.m7588yz();
                        if (this.eXo.eXm instanceof C42173c) {
                            C37897a c37897a = this.eXo.eXm;
                            if (c37897a == null) {
                                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.media.render.MixRenderer");
                                AppMethodBeat.m2505o(13011);
                                throw c44941v;
                            }
                            ((C42173c) c37897a).mo67717t(this.eyc);
                        }
                        C4990ab.m7410d(this.eXo.TAG, "render cost " + C5046bo.m7525az(yz));
                        long yz2 = C5046bo.m7588yz();
                        this.eXo.setPresentationTime(this.eXu);
                        C9609b c9609b = this.eXo.eXc;
                        if (c9609b != null) {
                            C26386a c26386a = C42175b.fad;
                            C26386a.m41986a(c9609b.fae, c9609b.faf);
                        }
                        C4990ab.m7410d(this.eXo.TAG, "swap buffer cost " + C5046bo.m7525az(yz2));
                        c17126b = this.eXo.eXd;
                        if (c17126b != null) {
                            c17126b.mo50am(Boolean.TRUE);
                        }
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace(this.eXo.TAG, e, "", new Object[0]);
                    c17126b = this.eXo.eXd;
                    if (c17126b != null) {
                        c17126b.mo50am(Boolean.FALSE);
                    }
                }
            } else {
                C4990ab.m7416i(this.eXo.TAG, "waitFistFrameAvailable and not firstFrameAvailable now, ignore");
                c17126b = this.eXo.eXd;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.TRUE);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13011);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.a$d */
    public static final class C9593d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C9587a eXo;
        final /* synthetic */ Surface eXp;
        final /* synthetic */ EGLContext eXq;
        final /* synthetic */ C17126b exI;

        public C9593d(C9587a c9587a, EGLContext eGLContext, Surface surface, C17126b c17126b) {
            this.eXo = c9587a;
            this.eXq = eGLContext;
            this.eXp = surface;
            this.exI = c17126b;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13009);
            C17126b c17126b;
            try {
                C9587a c9587a;
                C26386a c26386a;
                if (this.eXq == null) {
                    this.eXo.eXf = false;
                    c9587a = this.eXo;
                    c26386a = C42175b.fad;
                    c9587a.eXc = C26386a.m41987b(this.eXp, 0, 0);
                    this.eXo.eXm.mo60643cs(true);
                    C9587a.m17072a(this.eXo);
                } else {
                    this.eXo.eXf = true;
                    c9587a = this.eXo;
                    c26386a = C42175b.fad;
                    c9587a.eXc = C26386a.m41985a(this.eXq, this.eXp, 0, 0);
                    this.eXo.eXm.mo60643cs(false);
                }
                c17126b = this.exI;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.TRUE);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.eXo.TAG, e, "initWithSurface failed", new Object[0]);
                c17126b = this.exI;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.FALSE);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13009);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.a$e */
    static final class C9594e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C9587a eXo;

        C9594e(C9587a c9587a) {
            this.eXo = c9587a;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13010);
            C4990ab.m7416i(this.eXo.TAG, this.eXo.hashCode() + " do release resources");
            this.eXo.aAP = true;
            this.eXo.eXm.release();
            C9609b c9609b = this.eXo.eXc;
            if (c9609b != null) {
                EGLDisplay eGLDisplay;
                C26386a c26386a = C42175b.fad;
                C25052j.m39376p(c9609b, "eglEnvironment");
                if (c9609b.faf != EGL14.EGL_NO_DISPLAY) {
                    eGLDisplay = c9609b.fae;
                    EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                    EGL14.eglDestroySurface(c9609b.fae, c9609b.faf);
                    EGL14.eglDestroyContext(c9609b.fae, c9609b.fag);
                    EGL14.eglReleaseThread();
                    EGL14.eglTerminate(c9609b.fae);
                }
                eGLDisplay = EGL14.EGL_NO_DISPLAY;
                C25052j.m39375o(eGLDisplay, "EGL14.EGL_NO_DISPLAY");
                C25052j.m39376p(eGLDisplay, "<set-?>");
                c9609b.fae = eGLDisplay;
                EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
                C25052j.m39375o(eGLContext, "EGL14.EGL_NO_CONTEXT");
                C25052j.m39376p(eGLContext, "<set-?>");
                c9609b.fag = eGLContext;
                EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
                C25052j.m39375o(eGLSurface2, "EGL14.EGL_NO_SURFACE");
                C25052j.m39376p(eGLSurface2, "<set-?>");
                c9609b.faf = eGLSurface2;
            }
            Surface surface = this.eXo.aOO;
            if (surface != null) {
                surface.release();
            }
            this.eXo.eXb.removeCallbacksAndMessages(null);
            this.eXo.eXa.quitSafely();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13010);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.a$g */
    static final class C9595g extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C9587a eXo;
        final /* synthetic */ long eXu;
        final /* synthetic */ byte[] eXv;
        final /* synthetic */ C17126b eXw;

        C9595g(C9587a c9587a, byte[] bArr, long j, C17126b c17126b) {
            this.eXo = c9587a;
            this.eXv = bArr;
            this.eXu = j;
            this.eXw = c17126b;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(13012);
            C17126b c17126b;
            try {
                C37897a.m63987a(this.eXo.eXm, this.eXv);
                this.eXo.eXm.mo60640Vd();
                if (this.eXo.aOO != null) {
                    this.eXo.setPresentationTime(this.eXu);
                    C9609b c9609b = this.eXo.eXc;
                    if (c9609b != null) {
                        C26386a c26386a = C42175b.fad;
                        C26386a.m41986a(c9609b.fae, c9609b.faf);
                    }
                }
                c17126b = this.eXo.eXd;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.TRUE);
                }
                this.eXw.mo50am(this.eXv);
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.eXo.TAG, e, "", new Object[0]);
                c17126b = this.eXo.eXd;
                if (c17126b != null) {
                    c17126b.mo50am(Boolean.FALSE);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13012);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(13028);
        AppMethodBeat.m2505o(13028);
    }

    public C9587a(C37897a c37897a) {
        C25052j.m39376p(c37897a, "renderer");
        AppMethodBeat.m2504i(13027);
        this.eXm = c37897a;
        this.eXa.start();
        HandlerThread handlerThread = this.eXa;
        C25052j.m39375o(handlerThread, "renderThread");
        this.eXb = new C7306ak(handlerThread.getLooper());
        this.eXl = true;
        AppMethodBeat.m2505o(13027);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m17072a(C9587a c9587a) {
        AppMethodBeat.m2504i(13029);
        c9587a.m17071UZ();
        AppMethodBeat.m2505o(13029);
    }

    /* renamed from: a */
    public final void mo20911a(long j, Bitmap bitmap) {
        AppMethodBeat.m2504i(13017);
        mo20913b((C31214a) new C9592f(this, j, bitmap));
        AppMethodBeat.m2505o(13017);
    }

    /* renamed from: a */
    public final void mo20912a(byte[] bArr, long j, C17126b<? super byte[], C37091y> c17126b) {
        AppMethodBeat.m2504i(13018);
        C25052j.m39376p(bArr, "data");
        C25052j.m39376p(c17126b, "inputCallback");
        C4990ab.m7410d(this.TAG, "ByteArray length : " + bArr.length);
        mo20913b((C31214a) new C9595g(this, bArr, j, c17126b));
        AppMethodBeat.m2505o(13018);
    }

    /* renamed from: s */
    public final void mo20918s(int i, long j) {
        AppMethodBeat.m2504i(13019);
        mo20913b((C31214a) new C9585h(this, i, j));
        AppMethodBeat.m2505o(13019);
    }

    /* renamed from: UY */
    public final Surface mo20910UY() {
        AppMethodBeat.m2504i(13020);
        if (this.bsb == null) {
            m17071UZ();
        }
        Surface surface = new Surface(this.bsb);
        AppMethodBeat.m2505o(13020);
        return surface;
    }

    /* renamed from: cg */
    public final void mo20914cg(int i, int i2) {
        AppMethodBeat.m2504i(13021);
        this.eXm.mo60642ci(i, i2);
        AppMethodBeat.m2505o(13021);
    }

    /* renamed from: ch */
    public final void mo20915ch(int i, int i2) {
        AppMethodBeat.m2504i(13022);
        this.eXm.mo60641ch(i, i2);
        AppMethodBeat.m2505o(13022);
    }

    /* renamed from: ka */
    public final void mo20916ka(int i) {
        AppMethodBeat.m2504i(13023);
        this.eXm.mo60646ka(i);
        AppMethodBeat.m2505o(13023);
    }

    /* renamed from: b */
    public final void mo20913b(C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(13024);
        HandlerThread handlerThread = this.eXa;
        C25052j.m39375o(handlerThread, "renderThread");
        if (handlerThread.isAlive() && !this.aAP) {
            this.eXb.post(new C26385b(c31214a));
        }
        AppMethodBeat.m2505o(13024);
    }

    /* renamed from: UZ */
    private final void m17071UZ() {
        this.bsb = this.eXm.bsb;
    }

    public final void release() {
        AppMethodBeat.m2504i(13025);
        C4990ab.m7416i(this.TAG, hashCode() + " release resources");
        mo20913b((C31214a) new C9594e(this));
        AppMethodBeat.m2505o(13025);
    }

    /* Access modifiers changed, original: protected|final */
    public final void setPresentationTime(long j) {
        AppMethodBeat.m2504i(13026);
        C9609b c9609b = this.eXc;
        if (c9609b != null) {
            EGLExt.eglPresentationTimeANDROID(c9609b.fae, c9609b.faf, j);
        }
        C26386a c26386a = C42175b.fad;
        C26386a.m41988lZ("eglPresentationTimeANDROID");
        AppMethodBeat.m2505o(13026);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m17076c(C9587a c9587a) {
        AppMethodBeat.m2504i(13030);
        SurfaceTexture surfaceTexture = c9587a.bsb;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(new C9586j(c9587a));
            AppMethodBeat.m2505o(13030);
            return;
        }
        AppMethodBeat.m2505o(13030);
    }
}
