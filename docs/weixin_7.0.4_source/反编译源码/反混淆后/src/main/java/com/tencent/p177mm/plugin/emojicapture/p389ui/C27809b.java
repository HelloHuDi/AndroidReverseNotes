package com.tencent.p177mm.plugin.emojicapture.p389ui;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.HandlerThread;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p206bu.C1333b;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C27808c;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C27808c.C20448a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C38919i;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTModule;
import com.tencent.ttpic.PTSegment;
import com.tencent.ttpic.gles.GlUtil;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\bJ\u0010\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0015J\u0018\u0010%\u001a\u00020\b2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'H\u0002J\u0006\u0010(\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0015R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureRenderSurface;", "", "texture", "Landroid/graphics/SurfaceTexture;", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiVideoPlayTextureRenderer;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/graphics/SurfaceTexture;Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiVideoPlayTextureRenderer;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "mEglContext", "Landroid/opengl/EGLContext;", "mEglDisplay", "Landroid/opengl/EGLDisplay;", "kotlin.jvm.PlatformType", "mEglSurface", "Landroid/opengl/EGLSurface;", "needRender", "", "pauseRender", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "createEGLContext", "", "config", "Landroid/opengl/EGLConfig;", "destroyGL", "drawFrame", "pts", "", "initGL", "pause", "queue", "callback", "Lkotlin/Function0;", "releaseRender", "setNeedRender", "render", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.b */
public final class C27809b {
    final String TAG = "MicroMsg.EmojiVideoPlayTextureRenderSurface";
    HandlerThread eXa;
    private C7306ak eXb;
    final SurfaceTexture fcm;
    EGLDisplay llp = EGL14.EGL_NO_DISPLAY;
    EGLContext llq = EGL14.EGL_NO_CONTEXT;
    EGLSurface llr = EGL14.EGL_NO_SURFACE;
    private boolean lls;
    final C38919i llt;
    private boolean needRender;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b$a */
    static final class C27810a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C27809b llu;

        C27810a(C27809b c27809b) {
            this.llu = c27809b;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(2898);
            C4990ab.m7416i(this.llu.TAG, "destroyGL");
            this.llu.llt.release();
            EGL14.eglDestroyContext(this.llu.llp, this.llu.llq);
            EGL14.eglDestroySurface(this.llu.llp, this.llu.llr);
            this.llu.llq = EGL14.EGL_NO_CONTEXT;
            this.llu.llr = EGL14.EGL_NO_SURFACE;
            this.llu.fcm.release();
            this.llu.eXa.quit();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2898);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b$b */
    static final class C27811b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C27809b llu;
        final /* synthetic */ boolean lly;

        C27811b(C27809b c27809b, boolean z) {
            this.llu = c27809b;
            this.lly = z;
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            boolean z;
            C38919i c38919i = this.llu.llt;
            if (this.lly) {
                z = false;
            } else {
                z = true;
            }
            c38919i.gLJ = z;
            return C37091y.AUy;
        }
    }

    public C27809b(SurfaceTexture surfaceTexture, C38919i c38919i, final C17126b<? super C27809b, C37091y> c17126b) {
        C25052j.m39376p(surfaceTexture, "texture");
        C25052j.m39376p(c38919i, "renderer");
        AppMethodBeat.m2504i(2903);
        this.fcm = surfaceTexture;
        this.llt = c38919i;
        HandlerThread anM = C7305d.anM("EmojiVideoPlayTextureRenderSurface_renderThread");
        C25052j.m39375o(anM, "ThreadPool.newFreeHandle…derSurface_renderThread\")");
        this.eXa = anM;
        this.eXa.start();
        this.eXb = new C7306ak(this.eXa.getLooper());
        mo45653b(new C31214a<C37091y>(this) {
            final /* synthetic */ C27809b llu;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "pts", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b$1$1 */
            static final class C204451 extends C25053k implements C17126b<Long, C37091y> {
                final /* synthetic */ C204441 llw;

                C204451(C204441 c204441) {
                    this.llw = c204441;
                    super(1);
                }

                /* renamed from: am */
                public final /* synthetic */ Object mo50am(Object obj) {
                    AppMethodBeat.m2504i(2896);
                    final long longValue = ((Number) obj).longValue();
                    this.llw.llu.mo45653b(new C31214a<C37091y>(this) {
                        final /* synthetic */ C204451 llx;

                        public final /* synthetic */ Object invoke() {
                            AppMethodBeat.m2504i(2895);
                            C27809b c27809b = this.llx.llw.llu;
                            long j = longValue;
                            C38919i c38919i = c27809b.llt;
                            SurfaceTexture surfaceTexture = c38919i.lql;
                            if (surfaceTexture != null) {
                                surfaceTexture.updateTexImage();
                            }
                            c38919i.gLv = true;
                            if (c38919i.iZn > 0 && c38919i.iZo > 0) {
                                C20448a c20448a = C27808c.loN;
                                C20448a.m31604Vj();
                                if (!c38919i.ljd) {
                                    GLES20.glViewport(0, 0, c38919i.iZn, c38919i.iZo);
                                    C38919i.m66063a(c38919i, c38919i.lpX, c38919i.iZn, c38919i.iZo, true);
                                } else if (c38919i.lqh > 0 && c38919i.lqi > 0) {
                                    PTFaceAttr a;
                                    c20448a = C27808c.loN;
                                    C41672h c41672h = c38919i.lpq;
                                    if (c41672h == null) {
                                        C25052j.avw("ptFaceFrame");
                                    }
                                    int wE = c41672h.mo67192wE();
                                    C41672h c41672h2 = c38919i.lpq;
                                    if (c41672h2 == null) {
                                        C25052j.avw("ptFaceFrame");
                                    }
                                    int textureId = c41672h2.getTextureId();
                                    C41672h c41672h3 = c38919i.lpq;
                                    if (c41672h3 == null) {
                                        C25052j.avw("ptFaceFrame");
                                    }
                                    int i = c41672h3.width;
                                    C41672h c41672h4 = c38919i.lpq;
                                    if (c41672h4 == null) {
                                        C25052j.avw("ptFaceFrame");
                                    }
                                    C20448a.m31605y(wE, textureId, i, c41672h4.height);
                                    GLES20.glViewport(0, 0, c38919i.lqj, c38919i.lqj);
                                    wE = c38919i.lqi;
                                    if (wE != 0) {
                                        GLES20.glUseProgram(c38919i.lpg);
                                        GLES20.glActiveTexture(33984);
                                        GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, wE);
                                        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
                                        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
                                        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 33071.0f);
                                        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 33071.0f);
                                        GLES20.glUniform1i(c38919i.lpj, 0);
                                        c38919i.eZi.position(0);
                                        GLES20.glVertexAttribPointer(c38919i.lph, 2, 5126, false, 0, c38919i.eZi);
                                        GLES20.glEnableVertexAttribArray(c38919i.lph);
                                        c38919i.eZh.position(0);
                                        c38919i.eZh.put(C27808c.faa);
                                        c38919i.eZh.position(0);
                                        GLES20.glVertexAttribPointer(c38919i.lpi, 2, 5126, false, 0, c38919i.eZh);
                                        GLES20.glEnableVertexAttribArray(c38919i.lpi);
                                        GLES20.glDrawArrays(5, 0, 4);
                                        GLES20.glDisableVertexAttribArray(c38919i.lph);
                                        GLES20.glDisableVertexAttribArray(c38919i.lpi);
                                        GLES20.glBindTexture(3553, 0);
                                        GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
                                        GLES20.glUseProgram(0);
                                    }
                                    GLES20.glBindFramebuffer(36160, 0);
                                    c20448a = C27808c.loN;
                                    C20448a.m31604Vj();
                                    GLES20.glViewport(0, 0, c38919i.lqj, c38919i.lqj);
                                    c41672h3 = c38919i.lpq;
                                    if (c41672h3 == null) {
                                        C25052j.avw("ptFaceFrame");
                                    }
                                    C1333b c1333b = c38919i.lpo;
                                    if (c1333b != null) {
                                        c41672h2 = c38919i.lpq;
                                        if (c41672h2 == null) {
                                            C25052j.avw("ptFaceFrame");
                                        }
                                        a = C1333b.m2852a(c1333b, c41672h2);
                                    } else {
                                        a = null;
                                    }
                                    if (a != null) {
                                        if (a.getOrigFrame() != null) {
                                            c41672h3 = a.getOrigFrame();
                                            C25052j.m39375o(c41672h3, "faceAttr.origFrame");
                                        }
                                        long yz = C5046bo.m7588yz();
                                        try {
                                            PTSegment pTSegment = c38919i.lpp;
                                            if (pTSegment != null) {
                                                c41672h = pTSegment.segTexture(a, c41672h3, 0.015f, c38919i.lqj, c38919i.lqj);
                                                if (c41672h != null) {
                                                    c41672h3 = c41672h;
                                                }
                                            }
                                        } catch (Exception e) {
                                            C34007d c34007d = C34007d.lhz;
                                            C34007d.bni();
                                        }
                                        C4990ab.m7410d(c38919i.TAG, "segTexture used " + C5046bo.m7525az(yz) + "ms");
                                        c20448a = C27808c.loN;
                                        C20448a.m31604Vj();
                                    }
                                    GLES20.glFinish();
                                    c20448a = C27808c.loN;
                                    C20448a.m31604Vj();
                                    GLES20.glViewport(0, 0, c38919i.iZn, c38919i.iZo);
                                    C38919i.m66063a(c38919i, c41672h3.getTextureId(), c38919i.iZn, c38919i.iZo, false);
                                }
                            }
                            c38919i.gLv = false;
                            c38919i.gLJ = false;
                            C31214a c31214a = c38919i.lqm;
                            if (c31214a != null) {
                                c31214a.invoke();
                            }
                            EGLExt.eglPresentationTimeANDROID(c27809b.llp, c27809b.llr, j);
                            EGL14.eglSwapBuffers(c27809b.llp, c27809b.llr);
                            C37091y c37091y = C37091y.AUy;
                            AppMethodBeat.m2505o(2895);
                            return c37091y;
                        }
                    });
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(2896);
                    return c37091y;
                }
            }

            public final /* synthetic */ Object invoke() {
                C20448a c20448a;
                AppMethodBeat.m2504i(2897);
                C27809b c27809b = this.llu;
                C4990ab.m7416i(c27809b.TAG, "initGL");
                c27809b.llp = EGL14.eglGetDisplay(0);
                if (c27809b.llp == EGL14.EGL_NO_DISPLAY) {
                    C4990ab.m7413e(c27809b.TAG, "egl get display error: %s", GLUtils.getEGLErrorString(EGL14.eglGetError()));
                } else {
                    int[] iArr = new int[2];
                    if (EGL14.eglInitialize(c27809b.llp, iArr, 0, iArr, 1)) {
                        EGLConfig eGLConfig;
                        c20448a = C27808c.loN;
                        EGLDisplay eGLDisplay = c27809b.llp;
                        C25052j.m39375o(eGLDisplay, "mEglDisplay");
                        C25052j.m39376p(eGLDisplay, "eGLDisplay");
                        EGLConfig[] eGLConfigArr = new EGLConfig[1];
                        if (EGL14.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                            eGLConfig = eGLConfigArr[0];
                        } else {
                            C4990ab.m7413e("MicroMsg.EmojiCaptureGLUtil", "egl choose config failed: %s", GLUtils.getEGLErrorString(EGL14.eglGetError()));
                            eGLConfig = null;
                        }
                        if (eGLConfig != null) {
                            Object obj;
                            c27809b.llq = EGL14.eglCreateContext(c27809b.llp, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                            c27809b.llr = EGL14.eglCreateWindowSurface(c27809b.llp, eGLConfig, c27809b.fcm, new int[]{12344}, 0);
                            if (c27809b.llr != EGL14.EGL_NO_SURFACE && c27809b.llq != EGL14.EGL_NO_CONTEXT) {
                                obj = null;
                            } else if (EGL14.eglGetError() == 12299) {
                                C4990ab.m7412e(c27809b.TAG, "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                                obj = -1;
                            } else {
                                C4990ab.m7413e(c27809b.TAG, "eglCreateWindowSurface failed : %s", GLUtils.getEGLErrorString(EGL14.eglGetError()));
                                obj = -1;
                            }
                            if (obj >= null && !EGL14.eglMakeCurrent(c27809b.llp, c27809b.llr, c27809b.llr, c27809b.llq)) {
                                C4990ab.m7413e(c27809b.TAG, "eglMakeCurrent failed : %s", GLUtils.getEGLErrorString(EGL14.eglGetError()));
                            }
                        }
                    } else {
                        C4990ab.m7413e(c27809b.TAG, "egl init error: %s", GLUtils.getEGLErrorString(EGL14.eglGetError()));
                    }
                }
                C38919i c38919i = this.llu.llt;
                if (!c38919i.eNa) {
                    c38919i.eNa = true;
                    C4990ab.m7416i(c38919i.TAG, "init: " + c38919i + ", " + c38919i.llN);
                    c20448a = C27808c.loN;
                    c38919i.lpX = C20448a.bof();
                    c20448a = C27808c.loN;
                    c38919i.lpY = C20448a.m31601U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES externalTexture;\n        uniform sampler2D normalTexture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int calcRoundCorner;\n        uniform int useNormalTexture;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(radius, radius);\n                vec2 bottomRightCenter = vec2(size.x - radius, radius);\n                vec2 topLeftCenter = vec2(radius, size.y - radius);\n                vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.x && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n                   gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n                } else {\n                    if (useNormalTexture == 1) {\n                        gl_FragColor = texture2D(normalTexture, v_texCoord);\n                    } else {\n                        gl_FragColor = vec4(texture2D(externalTexture, v_texCoord).rgb, 1.0);\n                    }\n                }\n            } else {\n                if (useNormalTexture == 1) {\n                    gl_FragColor = texture2D(normalTexture, v_texCoord);\n                } else {\n                    gl_FragColor = vec4(texture2D(externalTexture, v_texCoord).rgb, 1.0);\n                }\n            }\n        }\n        ");
                    c38919i.lpZ = GLES20.glGetAttribLocation(c38919i.lpY, "a_texCoord");
                    c38919i.lqa = GLES20.glGetAttribLocation(c38919i.lpY, "a_position");
                    c38919i.lqb = GLES20.glGetUniformLocation(c38919i.lpY, "externalTexture");
                    c38919i.lqc = GLES20.glGetUniformLocation(c38919i.lpY, "normalTexture");
                    c38919i.lqd = GLES20.glGetUniformLocation(c38919i.lpY, "size");
                    c38919i.lqe = GLES20.glGetUniformLocation(c38919i.lpY, "radius");
                    c38919i.lqf = GLES20.glGetUniformLocation(c38919i.lpY, "calcRoundCorner");
                    c38919i.lqg = GLES20.glGetUniformLocation(c38919i.lpY, "useNormalTexture");
                    c20448a = C27808c.loN;
                    c38919i.lpg = C20448a.m31601U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
                    c38919i.lph = GLES20.glGetAttribLocation(c38919i.lpg, "a_position");
                    c38919i.lpi = GLES20.glGetAttribLocation(c38919i.lpg, "a_texCoord");
                    c38919i.lpj = GLES20.glGetUniformLocation(c38919i.lpg, "texture");
                    c20448a = C27808c.loN;
                    c38919i.lqh = C20448a.m31603Vi();
                    c20448a = C27808c.loN;
                    c38919i.lqi = C20448a.m31602Vh();
                    c20448a = C27808c.loN;
                    c38919i.lpr = C20448a.m31602Vh();
                    c38919i.eZi.put(c38919i.gLB);
                    c38919i.eZh.put(c38919i.gLC);
                    GLES20.glBindTexture(3553, c38919i.lpX);
                    C11617a c11617a = C34006c.lhw;
                    int bmM = C34006c.lht;
                    C11617a c11617a2 = C34006c.lhw;
                    GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, bmM, C34006c.lht, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
                    GLES20.glBindTexture(3553, 0);
                    c38919i.lql = new SurfaceTexture(c38919i.lpX);
                    SurfaceTexture surfaceTexture = c38919i.lql;
                    if (surfaceTexture != null) {
                        surfaceTexture.setOnFrameAvailableListener(c38919i);
                    }
                    if (c38919i.llN && !c38919i.lqp) {
                        c38919i.lqp = true;
                        C4990ab.m7416i(c38919i.TAG, "initSegment: ");
                        try {
                            PTModule.getInstance().init(EGL14.eglGetCurrentContext());
                            c38919i.lpo = new C1333b();
                            c38919i.lpp = new PTSegment();
                            C1333b c1333b = c38919i.lpo;
                            if (c1333b != null) {
                                c1333b.init();
                            }
                            PTSegment pTSegment = c38919i.lpp;
                            if (pTSegment != null) {
                                pTSegment.init();
                            }
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace(c38919i.TAG, e, "init segment error", new Object[0]);
                            C34007d c34007d = C34007d.lhz;
                            C34007d.bnh();
                        }
                    }
                    c38919i.lpq = new C41672h(c38919i.lqh, c38919i.lqi, c38919i.lqj, c38919i.lqj);
                }
                this.llu.llt.lqn = new C204451(this);
                C17126b c17126b = c17126b;
                if (c17126b != null) {
                    c17126b.mo50am(this.llu);
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(2897);
                return c37091y;
            }
        });
        AppMethodBeat.m2505o(2903);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo45653b(C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(2900);
        this.eXb.post(new C20449c(c31214a));
        AppMethodBeat.m2505o(2900);
    }

    /* renamed from: gF */
    public final void mo45654gF(boolean z) {
        AppMethodBeat.m2504i(2901);
        C4990ab.m7416i(this.TAG, "setNeedRender:".concat(String.valueOf(z)));
        this.needRender = z;
        AppMethodBeat.m2505o(2901);
    }

    /* renamed from: gG */
    public final void mo45655gG(boolean z) {
        AppMethodBeat.m2504i(2902);
        this.lls = z;
        mo45653b(new C27811b(this, z));
        AppMethodBeat.m2505o(2902);
    }
}
