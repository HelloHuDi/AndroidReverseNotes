package com.tencent.mm.media.g;

import a.f.b.k;
import a.l;
import a.v;
import a.y;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0014\b\u0016\u0018\u0000 Z2\u00020\u0001:\u0001ZB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00104\u001a\u00020-J5\u00105\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-2%\b\u0002\u00106\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nJ\b\u0010:\u001a\u00020\u000eH\u0002JM\u0010;\u001a\u00020\u000e2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2#\u00106\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nH\u0016JK\u0010A\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\b\b\u0002\u0010B\u001a\u00020\r2%\b\u0002\u00106\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nJ\u0016\u0010C\u001a\u00020\u000e2\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\"J\u0006\u0010D\u001a\u00020\u000eJ\u000e\u0010E\u001a\u00020\u000e2\u0006\u00102\u001a\u000203J9\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u000b2!\u0010I\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u000e0\nJ\u0016\u0010E\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020?2\u0006\u0010H\u001a\u00020\u000bJ\"\u0010E\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010L\u001a\u00020\rJ\u001a\u0010M\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010N\u001a\u00020\u000e2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0\"J\u0012\u0010O\u001a\u00020\u000e2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ \u0010P\u001a\u00020\u000e2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\nJ\b\u0010Q\u001a\u00020\u000eH\u0002J\u0018\u0010R\u001a\u00020\u000e2\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\"J\b\u0010S\u001a\u00020\u000eH\u0002J\u0010\u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020\u000bH\u0004J\u000e\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020?J\u0016\u0010X\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?J\u0016\u0010Y\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?J\b\u0010B\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n '*\u0004\u0018\u00010&0&X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0004R\u000e\u0010+\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000¨\u0006["}, dWq = {"Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "TAG", "", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "Lkotlin/Function1;", "", "drawCallback", "", "", "getDrawCallback", "()Lkotlin/jvm/functions/Function1;", "setDrawCallback", "(Lkotlin/jvm/functions/Function1;)V", "drawInOnFrameAvailable", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "firstFrame", "isFirstFrameAvailable", "isReleased", "lastFrameTimestamp", "newFrameAvailable", "newFrameLock", "Ljava/lang/Object;", "onDrawFrameOnFrameAvailableFailed", "Lkotlin/Function0;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "setUpEnvWithShareContext", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getOutputSurface", "initForRemuxer", "callback", "Lkotlin/ParameterName;", "name", "success", "initSurfaceTexture", "initWithSize", "eglContext", "Landroid/opengl/EGLContext;", "width", "", "height", "initWithSurface", "waitNewFrame", "queue", "release", "requestDraw", "data", "", "pts", "inputCallback", "textureId", "bitmap", "waitFistFrameAvailable", "requestDrawInGLThread", "runInGlesThread", "setDrawBlendBitmap", "setDrawBlendBitmapProvider", "setFirstFrameAvailable", "setOnDrawFrameOnFrameAvailableFailed", "setOnFrameAvailable", "setPresentationTime", "nsecs", "setRotate", "degree", "updateDrawSize", "updateTextureSize", "Companion", "plugin-mediaeditor_release"})
public final class a {
    public static final a eXn = new a();
    public final String TAG = "MicroMsg.CodecInputSurface";
    private volatile boolean aAP;
    public Surface aOO;
    private SurfaceTexture bsb;
    private final HandlerThread eXa = com.tencent.mm.sdk.g.d.anM("CodecInputSurface_renderThread");
    private ak eXb;
    com.tencent.mm.media.i.b.b eXc;
    public a.f.a.b<? super Boolean, y> eXd;
    private final Object eXe = new Object();
    private boolean eXf;
    private volatile boolean eXg;
    public a.f.a.b<? super Long, Bitmap> eXh;
    Bitmap eXi;
    boolean eXj;
    a.f.a.a<y> eXk;
    private boolean eXl;
    com.tencent.mm.media.h.a eXm;
    private long lastFrameTimestamp;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class h extends k implements a.f.a.a<y> {
        final /* synthetic */ a eXo;
        final /* synthetic */ long eXu;
        final /* synthetic */ int eXx;

        h(a aVar, int i, long j) {
            this.eXo = aVar;
            this.eXx = i;
            this.eXu = j;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13013);
            a.f.a.b bVar;
            try {
                this.eXo.eXm.input(this.eXx);
                this.eXo.eXm.Vd();
                if (this.eXo.aOO != null) {
                    this.eXo.setPresentationTime(this.eXu);
                    com.tencent.mm.media.i.b.b bVar2 = this.eXo.eXc;
                    if (bVar2 != null) {
                        com.tencent.mm.media.i.b.a aVar = com.tencent.mm.media.i.b.fad;
                        com.tencent.mm.media.i.b.a.a(bVar2.fae, bVar2.faf);
                    }
                }
                bVar = this.eXo.eXd;
                if (bVar != null) {
                    bVar.am(Boolean.TRUE);
                }
            } catch (Exception e) {
                ab.printErrStackTrace(this.eXo.TAG, e, "", new Object[0]);
                bVar = this.eXo.eXd;
                if (bVar != null) {
                    bVar.am(Boolean.FALSE);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13013);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
    static final class j implements OnFrameAvailableListener {
        final /* synthetic */ a eXo;

        j(a aVar) {
            this.eXo = aVar;
        }

        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Object valueOf;
            AppMethodBeat.i(13016);
            String b = this.eXo.TAG;
            StringBuilder append = new StringBuilder("onFrameAvailable, thread:").append(Thread.currentThread()).append(", surface timestamp:");
            SurfaceTexture f = this.eXo.bsb;
            if (f != null) {
                valueOf = Long.valueOf(f.getTimestamp());
            } else {
                valueOf = null;
            }
            ab.i(b, append.append(valueOf).append(", drawInOnFrameAvailable:").append(this.eXo.eXj).toString());
            f = this.eXo.bsb;
            if (f == null) {
                AppMethodBeat.o(13016);
            } else if (!this.eXo.eXg || f.getTimestamp() > 0) {
                if (!this.eXo.eXg) {
                    this.eXo.eXg = true;
                }
                if (this.eXo.eXj) {
                    long timestamp;
                    Bitmap j;
                    a aVar;
                    if (this.eXo.eXi != null) {
                        a aVar2 = this.eXo;
                        timestamp = f.getTimestamp();
                        j = this.eXo.eXi;
                        aVar = aVar2;
                    } else {
                        aVar = this.eXo;
                        timestamp = f.getTimestamp();
                        a.f.a.b k = this.eXo.eXh;
                        j = k != null ? (Bitmap) k.am(Long.valueOf(f.getTimestamp() / 1000)) : null;
                    }
                    a.a(aVar, timestamp, j);
                }
                AppMethodBeat.o(13016);
            } else {
                this.eXo.eXj = false;
                a.f.a.a i = this.eXo.eXk;
                if (i != null) {
                    i.invoke();
                    AppMethodBeat.o(13016);
                    return;
                }
                AppMethodBeat.o(13016);
            }
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/remuxer/CodecInputSurface$Companion;", "", "()V", "TIME_COST_TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class c extends k implements a.f.a.a<y> {
        final /* synthetic */ a eXo;
        final /* synthetic */ EGLContext eXq;
        final /* synthetic */ int eXr;
        final /* synthetic */ int eXs;
        final /* synthetic */ a.f.a.b exI;

        public c(a aVar, EGLContext eGLContext, int i, int i2, a.f.a.b bVar) {
            this.eXo = aVar;
            this.eXq = eGLContext;
            this.eXr = i;
            this.eXs = i2;
            this.exI = bVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13008);
            a.f.a.b bVar;
            try {
                a aVar;
                com.tencent.mm.media.i.b.a aVar2;
                if (this.eXq == null) {
                    this.eXo.eXf = false;
                    aVar = this.eXo;
                    aVar2 = com.tencent.mm.media.i.b.fad;
                    aVar.eXc = com.tencent.mm.media.i.b.a.b(null, this.eXr, this.eXs);
                    this.eXo.eXm.cs(true);
                    a.a(this.eXo);
                } else {
                    this.eXo.eXf = true;
                    aVar = this.eXo;
                    aVar2 = com.tencent.mm.media.i.b.fad;
                    aVar.eXc = com.tencent.mm.media.i.b.a.a(this.eXq, null, this.eXr, this.eXs);
                    this.eXo.eXm.cs(false);
                }
                ab.i(this.eXo.TAG, this.eXo.hashCode() + " initWithSize finish");
                bVar = this.exI;
                if (bVar != null) {
                    bVar.am(Boolean.TRUE);
                }
            } catch (Exception e) {
                ab.printErrStackTrace(this.eXo.TAG, e, "initWithSize error!", new Object[0]);
                bVar = this.exI;
                if (bVar != null) {
                    bVar.am(Boolean.FALSE);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13008);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ a eXo;
        final /* synthetic */ Surface eXp;
        final /* synthetic */ a.f.a.b exI;

        b(a aVar, Surface surface, a.f.a.b bVar) {
            this.eXo = aVar;
            this.eXp = surface;
            this.exI = bVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13007);
            a.f.a.b bVar;
            try {
                this.eXo.eXf = false;
                a aVar = this.eXo;
                com.tencent.mm.media.i.b.a aVar2 = com.tencent.mm.media.i.b.fad;
                aVar.eXc = com.tencent.mm.media.i.b.a.b(this.eXp, 0, 0);
                this.eXo.eXm.cs(true);
                a.a(this.eXo);
                a.c(this.eXo);
                bVar = this.exI;
                if (bVar != null) {
                    bVar.am(Boolean.TRUE);
                }
            } catch (Exception e) {
                ab.printErrStackTrace(this.eXo.TAG, e, "initWithSurface failed", new Object[0]);
                bVar = this.exI;
                if (bVar != null) {
                    bVar.am(Boolean.FALSE);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13007);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class i extends k implements a.f.a.a<y> {
        final /* synthetic */ a eXo;
        final /* synthetic */ SurfaceTexture eXy;

        public i(a aVar, SurfaceTexture surfaceTexture) {
            this.eXo = aVar;
            this.eXy = surfaceTexture;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13014);
            a.f.a.b bVar;
            try {
                this.eXy.attachToGLContext(this.eXo.eXm.eYN);
                this.eXy.updateTexImage();
                this.eXo.eXm.input(this.eXo.eXm.eYN);
                this.eXo.eXm.Vd();
                if (this.eXo.aOO != null) {
                    this.eXo.setPresentationTime(System.nanoTime());
                    com.tencent.mm.media.i.b.b bVar2 = this.eXo.eXc;
                    if (bVar2 != null) {
                        com.tencent.mm.media.i.b.a aVar = com.tencent.mm.media.i.b.fad;
                        com.tencent.mm.media.i.b.a.a(bVar2.fae, bVar2.faf);
                    }
                }
                this.eXy.detachFromGLContext();
                bVar = this.eXo.eXd;
                if (bVar != null) {
                    bVar.am(Boolean.TRUE);
                }
            } catch (Exception e) {
                ab.printErrStackTrace(this.eXo.TAG, e, "", new Object[0]);
                bVar = this.eXo.eXd;
                if (bVar != null) {
                    bVar.am(Boolean.FALSE);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13014);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class f extends k implements a.f.a.a<y> {
        final /* synthetic */ a eXo;
        final /* synthetic */ boolean eXt = true;
        final /* synthetic */ long eXu;
        final /* synthetic */ Bitmap eyc;

        f(a aVar, long j, Bitmap bitmap) {
            this.eXo = aVar;
            this.eXu = j;
            this.eyc = bitmap;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13011);
            a.f.a.b bVar;
            if (!this.eXt || this.eXo.eXg) {
                try {
                    ab.d(this.eXo.TAG, "render pts:" + this.eXu);
                    if (this.eXu <= 0) {
                        ab.e(this.eXo.TAG, "pts error:" + this.eXu);
                        bVar = this.eXo.eXd;
                        if (bVar != null) {
                            bVar.am(Boolean.FALSE);
                        }
                    } else {
                        long yz = bo.yz();
                        if (this.eXo.eXm instanceof com.tencent.mm.media.h.c) {
                            com.tencent.mm.media.h.a aVar = this.eXo.eXm;
                            if (aVar == null) {
                                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.media.render.MixRenderer");
                                AppMethodBeat.o(13011);
                                throw vVar;
                            }
                            ((com.tencent.mm.media.h.c) aVar).t(this.eyc);
                        }
                        ab.d(this.eXo.TAG, "render cost " + bo.az(yz));
                        long yz2 = bo.yz();
                        this.eXo.setPresentationTime(this.eXu);
                        com.tencent.mm.media.i.b.b bVar2 = this.eXo.eXc;
                        if (bVar2 != null) {
                            com.tencent.mm.media.i.b.a aVar2 = com.tencent.mm.media.i.b.fad;
                            com.tencent.mm.media.i.b.a.a(bVar2.fae, bVar2.faf);
                        }
                        ab.d(this.eXo.TAG, "swap buffer cost " + bo.az(yz2));
                        bVar = this.eXo.eXd;
                        if (bVar != null) {
                            bVar.am(Boolean.TRUE);
                        }
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace(this.eXo.TAG, e, "", new Object[0]);
                    bVar = this.eXo.eXd;
                    if (bVar != null) {
                        bVar.am(Boolean.FALSE);
                    }
                }
            } else {
                ab.i(this.eXo.TAG, "waitFistFrameAvailable and not firstFrameAvailable now, ignore");
                bVar = this.eXo.eXd;
                if (bVar != null) {
                    bVar.am(Boolean.TRUE);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13011);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ a eXo;
        final /* synthetic */ Surface eXp;
        final /* synthetic */ EGLContext eXq;
        final /* synthetic */ a.f.a.b exI;

        public d(a aVar, EGLContext eGLContext, Surface surface, a.f.a.b bVar) {
            this.eXo = aVar;
            this.eXq = eGLContext;
            this.eXp = surface;
            this.exI = bVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13009);
            a.f.a.b bVar;
            try {
                a aVar;
                com.tencent.mm.media.i.b.a aVar2;
                if (this.eXq == null) {
                    this.eXo.eXf = false;
                    aVar = this.eXo;
                    aVar2 = com.tencent.mm.media.i.b.fad;
                    aVar.eXc = com.tencent.mm.media.i.b.a.b(this.eXp, 0, 0);
                    this.eXo.eXm.cs(true);
                    a.a(this.eXo);
                } else {
                    this.eXo.eXf = true;
                    aVar = this.eXo;
                    aVar2 = com.tencent.mm.media.i.b.fad;
                    aVar.eXc = com.tencent.mm.media.i.b.a.a(this.eXq, this.eXp, 0, 0);
                    this.eXo.eXm.cs(false);
                }
                bVar = this.exI;
                if (bVar != null) {
                    bVar.am(Boolean.TRUE);
                }
            } catch (Exception e) {
                ab.printErrStackTrace(this.eXo.TAG, e, "initWithSurface failed", new Object[0]);
                bVar = this.exI;
                if (bVar != null) {
                    bVar.am(Boolean.FALSE);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13009);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends k implements a.f.a.a<y> {
        final /* synthetic */ a eXo;

        e(a aVar) {
            this.eXo = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13010);
            ab.i(this.eXo.TAG, this.eXo.hashCode() + " do release resources");
            this.eXo.aAP = true;
            this.eXo.eXm.release();
            com.tencent.mm.media.i.b.b bVar = this.eXo.eXc;
            if (bVar != null) {
                EGLDisplay eGLDisplay;
                com.tencent.mm.media.i.b.a aVar = com.tencent.mm.media.i.b.fad;
                a.f.b.j.p(bVar, "eglEnvironment");
                if (bVar.faf != EGL14.EGL_NO_DISPLAY) {
                    eGLDisplay = bVar.fae;
                    EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                    EGL14.eglDestroySurface(bVar.fae, bVar.faf);
                    EGL14.eglDestroyContext(bVar.fae, bVar.fag);
                    EGL14.eglReleaseThread();
                    EGL14.eglTerminate(bVar.fae);
                }
                eGLDisplay = EGL14.EGL_NO_DISPLAY;
                a.f.b.j.o(eGLDisplay, "EGL14.EGL_NO_DISPLAY");
                a.f.b.j.p(eGLDisplay, "<set-?>");
                bVar.fae = eGLDisplay;
                EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
                a.f.b.j.o(eGLContext, "EGL14.EGL_NO_CONTEXT");
                a.f.b.j.p(eGLContext, "<set-?>");
                bVar.fag = eGLContext;
                EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
                a.f.b.j.o(eGLSurface2, "EGL14.EGL_NO_SURFACE");
                a.f.b.j.p(eGLSurface2, "<set-?>");
                bVar.faf = eGLSurface2;
            }
            Surface surface = this.eXo.aOO;
            if (surface != null) {
                surface.release();
            }
            this.eXo.eXb.removeCallbacksAndMessages(null);
            this.eXo.eXa.quitSafely();
            y yVar = y.AUy;
            AppMethodBeat.o(13010);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class g extends k implements a.f.a.a<y> {
        final /* synthetic */ a eXo;
        final /* synthetic */ long eXu;
        final /* synthetic */ byte[] eXv;
        final /* synthetic */ a.f.a.b eXw;

        g(a aVar, byte[] bArr, long j, a.f.a.b bVar) {
            this.eXo = aVar;
            this.eXv = bArr;
            this.eXu = j;
            this.eXw = bVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(13012);
            a.f.a.b bVar;
            try {
                com.tencent.mm.media.h.a.a(this.eXo.eXm, this.eXv);
                this.eXo.eXm.Vd();
                if (this.eXo.aOO != null) {
                    this.eXo.setPresentationTime(this.eXu);
                    com.tencent.mm.media.i.b.b bVar2 = this.eXo.eXc;
                    if (bVar2 != null) {
                        com.tencent.mm.media.i.b.a aVar = com.tencent.mm.media.i.b.fad;
                        com.tencent.mm.media.i.b.a.a(bVar2.fae, bVar2.faf);
                    }
                }
                bVar = this.eXo.eXd;
                if (bVar != null) {
                    bVar.am(Boolean.TRUE);
                }
                this.eXw.am(this.eXv);
            } catch (Exception e) {
                ab.printErrStackTrace(this.eXo.TAG, e, "", new Object[0]);
                bVar = this.eXo.eXd;
                if (bVar != null) {
                    bVar.am(Boolean.FALSE);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13012);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(13028);
        AppMethodBeat.o(13028);
    }

    public a(com.tencent.mm.media.h.a aVar) {
        a.f.b.j.p(aVar, "renderer");
        AppMethodBeat.i(13027);
        this.eXm = aVar;
        this.eXa.start();
        HandlerThread handlerThread = this.eXa;
        a.f.b.j.o(handlerThread, "renderThread");
        this.eXb = new ak(handlerThread.getLooper());
        this.eXl = true;
        AppMethodBeat.o(13027);
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(13029);
        aVar.UZ();
        AppMethodBeat.o(13029);
    }

    public final void a(long j, Bitmap bitmap) {
        AppMethodBeat.i(13017);
        b((a.f.a.a) new f(this, j, bitmap));
        AppMethodBeat.o(13017);
    }

    public final void a(byte[] bArr, long j, a.f.a.b<? super byte[], y> bVar) {
        AppMethodBeat.i(13018);
        a.f.b.j.p(bArr, "data");
        a.f.b.j.p(bVar, "inputCallback");
        ab.d(this.TAG, "ByteArray length : " + bArr.length);
        b((a.f.a.a) new g(this, bArr, j, bVar));
        AppMethodBeat.o(13018);
    }

    public final void s(int i, long j) {
        AppMethodBeat.i(13019);
        b((a.f.a.a) new h(this, i, j));
        AppMethodBeat.o(13019);
    }

    public final Surface UY() {
        AppMethodBeat.i(13020);
        if (this.bsb == null) {
            UZ();
        }
        Surface surface = new Surface(this.bsb);
        AppMethodBeat.o(13020);
        return surface;
    }

    public final void cg(int i, int i2) {
        AppMethodBeat.i(13021);
        this.eXm.ci(i, i2);
        AppMethodBeat.o(13021);
    }

    public final void ch(int i, int i2) {
        AppMethodBeat.i(13022);
        this.eXm.ch(i, i2);
        AppMethodBeat.o(13022);
    }

    public final void ka(int i) {
        AppMethodBeat.i(13023);
        this.eXm.ka(i);
        AppMethodBeat.o(13023);
    }

    public final void b(a.f.a.a<y> aVar) {
        AppMethodBeat.i(13024);
        HandlerThread handlerThread = this.eXa;
        a.f.b.j.o(handlerThread, "renderThread");
        if (handlerThread.isAlive() && !this.aAP) {
            this.eXb.post(new b(aVar));
        }
        AppMethodBeat.o(13024);
    }

    private final void UZ() {
        this.bsb = this.eXm.bsb;
    }

    public final void release() {
        AppMethodBeat.i(13025);
        ab.i(this.TAG, hashCode() + " release resources");
        b((a.f.a.a) new e(this));
        AppMethodBeat.o(13025);
    }

    /* Access modifiers changed, original: protected|final */
    public final void setPresentationTime(long j) {
        AppMethodBeat.i(13026);
        com.tencent.mm.media.i.b.b bVar = this.eXc;
        if (bVar != null) {
            EGLExt.eglPresentationTimeANDROID(bVar.fae, bVar.faf, j);
        }
        com.tencent.mm.media.i.b.a aVar = com.tencent.mm.media.i.b.fad;
        com.tencent.mm.media.i.b.a.lZ("eglPresentationTimeANDROID");
        AppMethodBeat.o(13026);
    }

    public static final /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(13030);
        SurfaceTexture surfaceTexture = aVar.bsb;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(new j(aVar));
            AppMethodBeat.o(13030);
            return;
        }
        AppMethodBeat.o(13030);
    }
}
