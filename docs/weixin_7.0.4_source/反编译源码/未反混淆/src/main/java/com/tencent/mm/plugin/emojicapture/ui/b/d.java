package com.tencent.mm.plugin.emojicapture.ui.b;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

@l(dWo = {1, 1, 13}, dWp = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0006\u0010&\u001a\u00020\u001bJ\u001c\u0010'\u001a\u00020\u001b2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001b\u0018\u00010)J\u0006\u0010+\u001a\u00020#J\u0018\u0010,\u001a\u00020\u001b2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aJ\b\u0010.\u001a\u00020\u001bH\u0002J(\u0010/\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u0001012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001b\u0018\u00010)J\b\u00103\u001a\u00020\u001bH\u0002J\u0014\u00104\u001a\u00020\u001b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u000e\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u000202R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\u00100\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\u00120\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "", "width", "", "height", "(II)V", "TAG", "", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGLContext", "Ljavax/microedition/khronos/egl/EGLContext;", "kotlin.jvm.PlatformType", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eGLSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "glThread", "Landroid/os/HandlerThread;", "glThreadHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onPrepareDrawFrame", "Lkotlin/Function0;", "", "getOnPrepareDrawFrame", "()Lkotlin/jvm/functions/Function0;", "setOnPrepareDrawFrame", "(Lkotlin/jvm/functions/Function0;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "videoDecodeSurface", "Landroid/view/Surface;", "createEGLContext", "config", "destroyGL", "getRenderContent", "callback", "Lkotlin/Function1;", "", "getVideoDecodeSurface", "init", "afterInitCallback", "initPixelBuffer", "mixVideoAndEmojiFrame", "nextFrameInfo", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr$NextFrameInfo;", "", "onVideoSurfaceFrameAvailable", "queue", "setRemoveBackground", "remove", "plugin-emojicapture_release"})
public final class d {
    public final String TAG = "MicroMsg.EmojiCaptureEGLPixelBuffer";
    final int height;
    final EGL10 loO;
    EGLDisplay loP;
    EGLContext loQ;
    EGLSurface loR;
    EGLConfig loS;
    public GL10 loT;
    public e loU;
    Surface loV;
    public ak loW;
    HandlerThread loX;
    public a.f.a.a<y> loY;
    final int width;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ a.f.a.a lix;

        e(a.f.a.a aVar) {
            this.lix = aVar;
        }

        public final void run() {
            AppMethodBeat.i(3160);
            this.lix.invoke();
            AppMethodBeat.o(3160);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class f extends k implements a.f.a.a<y> {
        final /* synthetic */ d loZ;
        final /* synthetic */ boolean lpb;

        public f(d dVar, boolean z) {
            this.loZ = dVar;
            this.lpb = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(3161);
            d.a(this.loZ).ljd = this.lpb;
            y yVar = y.AUy;
            AppMethodBeat.o(3161);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.d$1 */
    static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ d loZ;

        AnonymousClass1(d dVar) {
            this.loZ = dVar;
        }

        public final void run() {
            AppMethodBeat.i(3155);
            d dVar = this.loZ;
            dVar.loP = dVar.loO.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (dVar.loP == EGL10.EGL_NO_DISPLAY) {
                ab.e(dVar.TAG, "egl get display error: %s", GLUtils.getEGLErrorString(dVar.loO.eglGetError()));
            }
            com.tencent.mm.plugin.emojicapture.model.d dVar2;
            if (dVar.loO.eglInitialize(dVar.loP, new int[2])) {
                EGLConfig eGLConfig;
                com.tencent.mm.plugin.emojicapture.ui.b.c.a aVar = c.loN;
                EGL10 egl10 = dVar.loO;
                EGLDisplay eGLDisplay = dVar.loP;
                j.o(eGLDisplay, "eGLDisplay");
                j.p(egl10, "eGL");
                j.p(eGLDisplay, "eGLDisplay");
                int[] iArr = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};
                int[] iArr2 = new int[1];
                egl10.eglChooseConfig(eGLDisplay, iArr, null, 0, iArr2);
                int i = iArr2[0];
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2)) {
                    eGLConfig = eGLConfigArr[0];
                } else {
                    ab.e("MicroMsg.EmojiCaptureGLUtil", "egl choose config failed: %s", GLUtils.getEGLErrorString(egl10.eglGetError()));
                    eGLConfig = null;
                }
                dVar.loS = eGLConfig;
                eGLConfig = dVar.loS;
                if (eGLConfig != null) {
                    Object obj;
                    dVar.loQ = dVar.loO.eglCreateContext(dVar.loP, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    dVar.loR = dVar.loO.eglCreatePbufferSurface(dVar.loP, eGLConfig, new int[]{12375, dVar.width, 12374, dVar.height, 12344});
                    if (dVar.loR != EGL10.EGL_NO_SURFACE && dVar.loQ != EGL10.EGL_NO_CONTEXT) {
                        obj = null;
                    } else if (dVar.loO.eglGetError() == 12299) {
                        ab.e(dVar.TAG, "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                        obj = -1;
                    } else {
                        ab.e(dVar.TAG, "eglCreateWindowSurface failed : %s", GLUtils.getEGLErrorString(dVar.loO.eglGetError()));
                        obj = -1;
                    }
                    if (obj < null) {
                        ab.e(dVar.TAG, "createEGLContext failed -1");
                        dVar2 = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                        com.tencent.mm.plugin.emojicapture.model.d.bna();
                    } else {
                        if (!dVar.loO.eglMakeCurrent(dVar.loP, dVar.loR, dVar.loR, dVar.loQ)) {
                            ab.e(dVar.TAG, "eglMakeCurrent failed : " + GLUtils.getEGLErrorString(dVar.loO.eglGetError()));
                            dVar2 = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                            com.tencent.mm.plugin.emojicapture.model.d.bna();
                        }
                        EGLContext eGLContext = dVar.loQ;
                        j.o(eGLContext, "eGLContext");
                        GL gl = eGLContext.getGL();
                        if (gl == null) {
                            v vVar = new v("null cannot be cast to non-null type javax.microedition.khronos.opengles.GL10");
                            AppMethodBeat.o(3155);
                            throw vVar;
                        }
                        dVar.loT = (GL10) gl;
                    }
                }
            } else {
                ab.e(dVar.TAG, "egl init error: %s", GLUtils.getEGLErrorString(dVar.loO.eglGetError()));
                dVar2 = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                com.tencent.mm.plugin.emojicapture.model.d.bna();
            }
            dVar.loU = new e();
            e eVar = dVar.loU;
            if (eVar == null) {
                j.avw("renderer");
            }
            if (!eVar.bZi) {
                ab.i(eVar.TAG, "init: ");
                com.tencent.mm.plugin.emojicapture.ui.b.c.a aVar2 = c.loN;
                eVar.lpc = com.tencent.mm.plugin.emojicapture.ui.b.c.a.bof();
                eVar.lpd = new SurfaceTexture(eVar.lpc);
                aVar2 = c.loN;
                eVar.eZu = com.tencent.mm.plugin.emojicapture.ui.b.c.a.Vh();
                aVar2 = c.loN;
                eVar.eZv = com.tencent.mm.plugin.emojicapture.ui.b.c.a.U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec2 bottomLeftCenter = vec2(radius, radius);\n            vec2 bottomRightCenter = vec2(size.x - radius, radius);\n            vec2 topLeftCenter = vec2(radius, size.y - radius);\n            vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n            if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.x && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n                gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n            } else {\n                vec4 videoColor;\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
                eVar.eZw = GLES20.glGetAttribLocation(eVar.eZv, "a_position");
                eVar.eZx = GLES20.glGetAttribLocation(eVar.eZv, "a_texCoord");
                eVar.eZy = GLES20.glGetUniformLocation(eVar.eZv, "videoExternalTexture");
                eVar.eZz = GLES20.glGetUniformLocation(eVar.eZv, "videoNormalTexture");
                eVar.eZA = GLES20.glGetUniformLocation(eVar.eZv, "emojiTexture");
                eVar.lpe = GLES20.glGetUniformLocation(eVar.eZv, "size");
                eVar.lpf = GLES20.glGetUniformLocation(eVar.eZv, "radius");
                eVar.eZB = GLES20.glGetUniformLocation(eVar.eZv, "hasEmojiTexture");
                eVar.eZD = GLES20.glGetUniformLocation(eVar.eZv, "uMatrix");
                eVar.eZC = GLES20.glGetUniformLocation(eVar.eZv, "useNormalVideoTexture");
                aVar2 = c.loN;
                eVar.lpg = com.tencent.mm.plugin.emojicapture.ui.b.c.a.U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
                eVar.lph = GLES20.glGetAttribLocation(eVar.lpg, "a_position");
                eVar.lpi = GLES20.glGetAttribLocation(eVar.lpg, "a_texCoord");
                eVar.lpj = GLES20.glGetUniformLocation(eVar.lpg, "texture");
                aVar2 = c.loN;
                eVar.lpl = com.tencent.mm.plugin.emojicapture.ui.b.c.a.Vh();
                aVar2 = c.loN;
                eVar.lpk = com.tencent.mm.plugin.emojicapture.ui.b.c.a.Vi();
                aVar2 = c.loN;
                eVar.lpr = com.tencent.mm.plugin.emojicapture.ui.b.c.a.Vh();
                eVar.eZi.put(c.eZY);
                eVar.lps.put(c.eZZ);
                eVar.lpo.init();
                eVar.lpp.init();
                try {
                    eVar.lpq = new h(eVar.lpk, eVar.lpl, eVar.lpm, eVar.lpm);
                } catch (Exception e) {
                    com.tencent.mm.plugin.emojicapture.model.d dVar3 = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                    com.tencent.mm.plugin.emojicapture.model.d.bnh();
                }
                eVar.bZi = true;
            }
            eVar = dVar.loU;
            if (eVar == null) {
                j.avw("renderer");
            }
            eVar.boh().setOnFrameAvailableListener(new c(dVar));
            e eVar2 = dVar.loU;
            if (eVar2 == null) {
                j.avw("renderer");
            }
            dVar.loV = new Surface(eVar2.boh());
            AppMethodBeat.o(3155);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ d loZ;
        final /* synthetic */ a.f.a.a lpa;

        public b(d dVar, a.f.a.a aVar) {
            this.loZ = dVar;
            this.lpa = aVar;
        }

        public final void run() {
            AppMethodBeat.i(3157);
            d.a(this.loZ).onSurfaceCreated(d.b(this.loZ), this.loZ.loS);
            d.a(this.loZ).onSurfaceChanged(d.b(this.loZ), this.loZ.width, this.loZ.height);
            a.f.a.a aVar = this.lpa;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(3157);
                return;
            }
            AppMethodBeat.o(3157);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ d loZ;

        d(d dVar) {
            this.loZ = dVar;
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            AppMethodBeat.i(3159);
            a.f.a.a aVar = this.loZ.loY;
            if (aVar != null) {
                aVar.invoke();
            }
            y yVar = y.AUy;
            AppMethodBeat.o(3159);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ d loZ;

        public a(d dVar) {
            this.loZ = dVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(3156);
            e a = d.a(this.loZ);
            ab.i(a.TAG, "release: ");
            GLES20.glDeleteTextures(5, new int[]{a.lpc, a.eZu, a.lpl, a.lpn, a.lpr}, 0);
            GLES20.glDeleteProgram(a.eZv);
            GLES20.glDeleteProgram(a.lpg);
            GLES20.glDeleteFramebuffers(1, new int[]{a.lpk}, 0);
            try {
                a.lpp.destroy();
            } catch (Exception e) {
                com.tencent.mm.plugin.emojicapture.model.d dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                com.tencent.mm.plugin.emojicapture.model.d.bnj();
            }
            a.lpo.destroy();
            h hVar = a.lpq;
            if (hVar == null) {
                j.avw("ptFaceFrame");
            }
            hVar.clear();
            EGL10 egl10 = this.loZ.loO;
            EGLDisplay eGLDisplay = this.loZ.loP;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.loZ.loO.eglDestroyContext(this.loZ.loP, this.loZ.loQ);
            this.loZ.loO.eglDestroySurface(this.loZ.loP, this.loZ.loR);
            this.loZ.loO.eglTerminate(this.loZ.loP);
            this.loZ.loQ = EGL10.EGL_NO_CONTEXT;
            this.loZ.loR = EGL10.EGL_NO_SURFACE;
            this.loZ.loX.quit();
            y yVar = y.AUy;
            AppMethodBeat.o(3156);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
    static final class c implements OnFrameAvailableListener {
        final /* synthetic */ d loZ;

        c(d dVar) {
            this.loZ = dVar;
        }

        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(3158);
            d dVar = this.loZ;
            ab.i(dVar.TAG, "onVideoSurfaceFrameAvailable");
            dVar.b((a.f.a.a) new d(dVar));
            AppMethodBeat.o(3158);
        }
    }

    public d(int i, int i2) {
        AppMethodBeat.i(3164);
        this.width = i;
        this.height = i2;
        EGL egl = EGLContext.getEGL();
        if (egl == null) {
            v vVar = new v("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            AppMethodBeat.o(3164);
            throw vVar;
        }
        this.loO = (EGL10) egl;
        this.loP = EGL10.EGL_NO_DISPLAY;
        this.loQ = EGL10.EGL_NO_CONTEXT;
        this.loR = EGL10.EGL_NO_SURFACE;
        HandlerThread anM = com.tencent.mm.sdk.g.d.anM("EmojiCaptureMixEGLPixelBuffer_GLThread");
        j.o(anM, "ThreadPool.newFreeHandle…EGLPixelBuffer_GLThread\")");
        this.loX = anM;
        this.loX.start();
        this.loW = new ak(this.loX.getLooper());
        this.loW.post(new AnonymousClass1(this));
        AppMethodBeat.o(3164);
    }

    public static final /* synthetic */ e a(d dVar) {
        AppMethodBeat.i(3165);
        e eVar = dVar.loU;
        if (eVar == null) {
            j.avw("renderer");
        }
        AppMethodBeat.o(3165);
        return eVar;
    }

    public final void b(a.f.a.a<y> aVar) {
        AppMethodBeat.i(3162);
        j.p(aVar, "callback");
        this.loW.post(new e(aVar));
        AppMethodBeat.o(3162);
    }

    public final Surface bog() {
        AppMethodBeat.i(3163);
        Surface surface = this.loV;
        if (surface == null) {
            j.avw("videoDecodeSurface");
        }
        AppMethodBeat.o(3163);
        return surface;
    }
}
