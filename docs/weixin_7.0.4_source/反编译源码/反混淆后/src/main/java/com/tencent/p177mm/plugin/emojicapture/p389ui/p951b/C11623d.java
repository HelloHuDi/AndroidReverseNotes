package com.tencent.p177mm.plugin.emojicapture.p389ui.p951b;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C27808c.C20448a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0006\u0010&\u001a\u00020\u001bJ\u001c\u0010'\u001a\u00020\u001b2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001b\u0018\u00010)J\u0006\u0010+\u001a\u00020#J\u0018\u0010,\u001a\u00020\u001b2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aJ\b\u0010.\u001a\u00020\u001bH\u0002J(\u0010/\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u0001012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001b\u0018\u00010)J\b\u00103\u001a\u00020\u001bH\u0002J\u0014\u00104\u001a\u00020\u001b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u000e\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u000202R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\u00100\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\u00120\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "", "width", "", "height", "(II)V", "TAG", "", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGLContext", "Ljavax/microedition/khronos/egl/EGLContext;", "kotlin.jvm.PlatformType", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eGLSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "glThread", "Landroid/os/HandlerThread;", "glThreadHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onPrepareDrawFrame", "Lkotlin/Function0;", "", "getOnPrepareDrawFrame", "()Lkotlin/jvm/functions/Function0;", "setOnPrepareDrawFrame", "(Lkotlin/jvm/functions/Function0;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "videoDecodeSurface", "Landroid/view/Surface;", "createEGLContext", "config", "destroyGL", "getRenderContent", "callback", "Lkotlin/Function1;", "", "getVideoDecodeSurface", "init", "afterInitCallback", "initPixelBuffer", "mixVideoAndEmojiFrame", "nextFrameInfo", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr$NextFrameInfo;", "", "onVideoSurfaceFrameAvailable", "queue", "setRemoveBackground", "remove", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.d */
public final class C11623d {
    public final String TAG = "MicroMsg.EmojiCaptureEGLPixelBuffer";
    final int height;
    final EGL10 loO;
    EGLDisplay loP;
    EGLContext loQ;
    EGLSurface loR;
    EGLConfig loS;
    public GL10 loT;
    public C45872e loU;
    Surface loV;
    public C7306ak loW;
    HandlerThread loX;
    public C31214a<C37091y> loY;
    final int width;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.d$e */
    static final class C11624e implements Runnable {
        final /* synthetic */ C31214a lix;

        C11624e(C31214a c31214a) {
            this.lix = c31214a;
        }

        public final void run() {
            AppMethodBeat.m2504i(3160);
            this.lix.invoke();
            AppMethodBeat.m2505o(3160);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.d$f */
    public static final class C11625f extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C11623d loZ;
        final /* synthetic */ boolean lpb;

        public C11625f(C11623d c11623d, boolean z) {
            this.loZ = c11623d;
            this.lpb = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(3161);
            C11623d.m19441a(this.loZ).ljd = this.lpb;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(3161);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.d$1 */
    static final class C116261 implements Runnable {
        final /* synthetic */ C11623d loZ;

        C116261(C11623d c11623d) {
            this.loZ = c11623d;
        }

        public final void run() {
            AppMethodBeat.m2504i(3155);
            C11623d c11623d = this.loZ;
            c11623d.loP = c11623d.loO.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (c11623d.loP == EGL10.EGL_NO_DISPLAY) {
                C4990ab.m7413e(c11623d.TAG, "egl get display error: %s", GLUtils.getEGLErrorString(c11623d.loO.eglGetError()));
            }
            C34007d c34007d;
            if (c11623d.loO.eglInitialize(c11623d.loP, new int[2])) {
                EGLConfig eGLConfig;
                C20448a c20448a = C27808c.loN;
                EGL10 egl10 = c11623d.loO;
                EGLDisplay eGLDisplay = c11623d.loP;
                C25052j.m39375o(eGLDisplay, "eGLDisplay");
                C25052j.m39376p(egl10, "eGL");
                C25052j.m39376p(eGLDisplay, "eGLDisplay");
                int[] iArr = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};
                int[] iArr2 = new int[1];
                egl10.eglChooseConfig(eGLDisplay, iArr, null, 0, iArr2);
                int i = iArr2[0];
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2)) {
                    eGLConfig = eGLConfigArr[0];
                } else {
                    C4990ab.m7413e("MicroMsg.EmojiCaptureGLUtil", "egl choose config failed: %s", GLUtils.getEGLErrorString(egl10.eglGetError()));
                    eGLConfig = null;
                }
                c11623d.loS = eGLConfig;
                eGLConfig = c11623d.loS;
                if (eGLConfig != null) {
                    Object obj;
                    c11623d.loQ = c11623d.loO.eglCreateContext(c11623d.loP, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    c11623d.loR = c11623d.loO.eglCreatePbufferSurface(c11623d.loP, eGLConfig, new int[]{12375, c11623d.width, 12374, c11623d.height, 12344});
                    if (c11623d.loR != EGL10.EGL_NO_SURFACE && c11623d.loQ != EGL10.EGL_NO_CONTEXT) {
                        obj = null;
                    } else if (c11623d.loO.eglGetError() == 12299) {
                        C4990ab.m7412e(c11623d.TAG, "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                        obj = -1;
                    } else {
                        C4990ab.m7413e(c11623d.TAG, "eglCreateWindowSurface failed : %s", GLUtils.getEGLErrorString(c11623d.loO.eglGetError()));
                        obj = -1;
                    }
                    if (obj < null) {
                        C4990ab.m7412e(c11623d.TAG, "createEGLContext failed -1");
                        c34007d = C34007d.lhz;
                        C34007d.bna();
                    } else {
                        if (!c11623d.loO.eglMakeCurrent(c11623d.loP, c11623d.loR, c11623d.loR, c11623d.loQ)) {
                            C4990ab.m7412e(c11623d.TAG, "eglMakeCurrent failed : " + GLUtils.getEGLErrorString(c11623d.loO.eglGetError()));
                            c34007d = C34007d.lhz;
                            C34007d.bna();
                        }
                        EGLContext eGLContext = c11623d.loQ;
                        C25052j.m39375o(eGLContext, "eGLContext");
                        GL gl = eGLContext.getGL();
                        if (gl == null) {
                            C44941v c44941v = new C44941v("null cannot be cast to non-null type javax.microedition.khronos.opengles.GL10");
                            AppMethodBeat.m2505o(3155);
                            throw c44941v;
                        }
                        c11623d.loT = (GL10) gl;
                    }
                }
            } else {
                C4990ab.m7413e(c11623d.TAG, "egl init error: %s", GLUtils.getEGLErrorString(c11623d.loO.eglGetError()));
                c34007d = C34007d.lhz;
                C34007d.bna();
            }
            c11623d.loU = new C45872e();
            C45872e c45872e = c11623d.loU;
            if (c45872e == null) {
                C25052j.avw("renderer");
            }
            if (!c45872e.bZi) {
                C4990ab.m7416i(c45872e.TAG, "init: ");
                C20448a c20448a2 = C27808c.loN;
                c45872e.lpc = C20448a.bof();
                c45872e.lpd = new SurfaceTexture(c45872e.lpc);
                c20448a2 = C27808c.loN;
                c45872e.eZu = C20448a.m31602Vh();
                c20448a2 = C27808c.loN;
                c45872e.eZv = C20448a.m31601U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec2 bottomLeftCenter = vec2(radius, radius);\n            vec2 bottomRightCenter = vec2(size.x - radius, radius);\n            vec2 topLeftCenter = vec2(radius, size.y - radius);\n            vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n            if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.x && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n                gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n            } else {\n                vec4 videoColor;\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (videoColor.a != 1.0) {\n                    videoColor.a = 0.0;\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
                c45872e.eZw = GLES20.glGetAttribLocation(c45872e.eZv, "a_position");
                c45872e.eZx = GLES20.glGetAttribLocation(c45872e.eZv, "a_texCoord");
                c45872e.eZy = GLES20.glGetUniformLocation(c45872e.eZv, "videoExternalTexture");
                c45872e.eZz = GLES20.glGetUniformLocation(c45872e.eZv, "videoNormalTexture");
                c45872e.eZA = GLES20.glGetUniformLocation(c45872e.eZv, "emojiTexture");
                c45872e.lpe = GLES20.glGetUniformLocation(c45872e.eZv, "size");
                c45872e.lpf = GLES20.glGetUniformLocation(c45872e.eZv, "radius");
                c45872e.eZB = GLES20.glGetUniformLocation(c45872e.eZv, "hasEmojiTexture");
                c45872e.eZD = GLES20.glGetUniformLocation(c45872e.eZv, "uMatrix");
                c45872e.eZC = GLES20.glGetUniformLocation(c45872e.eZv, "useNormalVideoTexture");
                c20448a2 = C27808c.loN;
                c45872e.lpg = C20448a.m31601U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
                c45872e.lph = GLES20.glGetAttribLocation(c45872e.lpg, "a_position");
                c45872e.lpi = GLES20.glGetAttribLocation(c45872e.lpg, "a_texCoord");
                c45872e.lpj = GLES20.glGetUniformLocation(c45872e.lpg, "texture");
                c20448a2 = C27808c.loN;
                c45872e.lpl = C20448a.m31602Vh();
                c20448a2 = C27808c.loN;
                c45872e.lpk = C20448a.m31603Vi();
                c20448a2 = C27808c.loN;
                c45872e.lpr = C20448a.m31602Vh();
                c45872e.eZi.put(C27808c.eZY);
                c45872e.lps.put(C27808c.eZZ);
                c45872e.lpo.init();
                c45872e.lpp.init();
                try {
                    c45872e.lpq = new C41672h(c45872e.lpk, c45872e.lpl, c45872e.lpm, c45872e.lpm);
                } catch (Exception e) {
                    C34007d c34007d2 = C34007d.lhz;
                    C34007d.bnh();
                }
                c45872e.bZi = true;
            }
            c45872e = c11623d.loU;
            if (c45872e == null) {
                C25052j.avw("renderer");
            }
            c45872e.boh().setOnFrameAvailableListener(new C11630c(c11623d));
            C45872e c45872e2 = c11623d.loU;
            if (c45872e2 == null) {
                C25052j.avw("renderer");
            }
            c11623d.loV = new Surface(c45872e2.boh());
            AppMethodBeat.m2505o(3155);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.d$b */
    public static final class C11627b implements Runnable {
        final /* synthetic */ C11623d loZ;
        final /* synthetic */ C31214a lpa;

        public C11627b(C11623d c11623d, C31214a c31214a) {
            this.loZ = c11623d;
            this.lpa = c31214a;
        }

        public final void run() {
            AppMethodBeat.m2504i(3157);
            C11623d.m19441a(this.loZ).onSurfaceCreated(C11623d.m19442b(this.loZ), this.loZ.loS);
            C11623d.m19441a(this.loZ).onSurfaceChanged(C11623d.m19442b(this.loZ), this.loZ.width, this.loZ.height);
            C31214a c31214a = this.lpa;
            if (c31214a != null) {
                c31214a.invoke();
                AppMethodBeat.m2505o(3157);
                return;
            }
            AppMethodBeat.m2505o(3157);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.d$d */
    static final class C11628d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C11623d loZ;

        C11628d(C11623d c11623d) {
            this.loZ = c11623d;
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(3159);
            C31214a c31214a = this.loZ.loY;
            if (c31214a != null) {
                c31214a.invoke();
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(3159);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.d$a */
    public static final class C11629a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C11623d loZ;

        public C11629a(C11623d c11623d) {
            this.loZ = c11623d;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(3156);
            C45872e a = C11623d.m19441a(this.loZ);
            C4990ab.m7416i(a.TAG, "release: ");
            GLES20.glDeleteTextures(5, new int[]{a.lpc, a.eZu, a.lpl, a.lpn, a.lpr}, 0);
            GLES20.glDeleteProgram(a.eZv);
            GLES20.glDeleteProgram(a.lpg);
            GLES20.glDeleteFramebuffers(1, new int[]{a.lpk}, 0);
            try {
                a.lpp.destroy();
            } catch (Exception e) {
                C34007d c34007d = C34007d.lhz;
                C34007d.bnj();
            }
            a.lpo.destroy();
            C41672h c41672h = a.lpq;
            if (c41672h == null) {
                C25052j.avw("ptFaceFrame");
            }
            c41672h.clear();
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
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(3156);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.d$c */
    static final class C11630c implements OnFrameAvailableListener {
        final /* synthetic */ C11623d loZ;

        C11630c(C11623d c11623d) {
            this.loZ = c11623d;
        }

        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(3158);
            C11623d c11623d = this.loZ;
            C4990ab.m7416i(c11623d.TAG, "onVideoSurfaceFrameAvailable");
            c11623d.mo23373b((C31214a) new C11628d(c11623d));
            AppMethodBeat.m2505o(3158);
        }
    }

    public C11623d(int i, int i2) {
        AppMethodBeat.m2504i(3164);
        this.width = i;
        this.height = i2;
        EGL egl = EGLContext.getEGL();
        if (egl == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            AppMethodBeat.m2505o(3164);
            throw c44941v;
        }
        this.loO = (EGL10) egl;
        this.loP = EGL10.EGL_NO_DISPLAY;
        this.loQ = EGL10.EGL_NO_CONTEXT;
        this.loR = EGL10.EGL_NO_SURFACE;
        HandlerThread anM = C7305d.anM("EmojiCaptureMixEGLPixelBuffer_GLThread");
        C25052j.m39375o(anM, "ThreadPool.newFreeHandle…EGLPixelBuffer_GLThread\")");
        this.loX = anM;
        this.loX.start();
        this.loW = new C7306ak(this.loX.getLooper());
        this.loW.post(new C116261(this));
        AppMethodBeat.m2505o(3164);
    }

    /* renamed from: a */
    public static final /* synthetic */ C45872e m19441a(C11623d c11623d) {
        AppMethodBeat.m2504i(3165);
        C45872e c45872e = c11623d.loU;
        if (c45872e == null) {
            C25052j.avw("renderer");
        }
        AppMethodBeat.m2505o(3165);
        return c45872e;
    }

    /* renamed from: b */
    public final void mo23373b(C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(3162);
        C25052j.m39376p(c31214a, "callback");
        this.loW.post(new C11624e(c31214a));
        AppMethodBeat.m2505o(3162);
    }

    public final Surface bog() {
        AppMethodBeat.m2504i(3163);
        Surface surface = this.loV;
        if (surface == null) {
            C25052j.avw("videoDecodeSurface");
        }
        AppMethodBeat.m2505o(3163);
        return surface;
    }
}
