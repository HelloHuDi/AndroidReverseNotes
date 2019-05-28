package com.tencent.mm.plugin.emojicapture.ui;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
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
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.ui.b.c;
import com.tencent.mm.plugin.emojicapture.ui.b.i;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTModule;
import com.tencent.ttpic.PTSegment;
import com.tencent.ttpic.gles.GlUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\bJ\u0010\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0015J\u0018\u0010%\u001a\u00020\b2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'H\u0002J\u0006\u0010(\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0015R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureRenderSurface;", "", "texture", "Landroid/graphics/SurfaceTexture;", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiVideoPlayTextureRenderer;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/graphics/SurfaceTexture;Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiVideoPlayTextureRenderer;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "mEglContext", "Landroid/opengl/EGLContext;", "mEglDisplay", "Landroid/opengl/EGLDisplay;", "kotlin.jvm.PlatformType", "mEglSurface", "Landroid/opengl/EGLSurface;", "needRender", "", "pauseRender", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "createEGLContext", "", "config", "Landroid/opengl/EGLConfig;", "destroyGL", "drawFrame", "pts", "", "initGL", "pause", "queue", "callback", "Lkotlin/Function0;", "releaseRender", "setNeedRender", "render", "plugin-emojicapture_release"})
public final class b {
    final String TAG = "MicroMsg.EmojiVideoPlayTextureRenderSurface";
    HandlerThread eXa;
    private ak eXb;
    final SurfaceTexture fcm;
    EGLDisplay llp = EGL14.EGL_NO_DISPLAY;
    EGLContext llq = EGL14.EGL_NO_CONTEXT;
    EGLSurface llr = EGL14.EGL_NO_SURFACE;
    private boolean lls;
    final i llt;
    private boolean needRender;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ b llu;

        a(b bVar) {
            this.llu = bVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(2898);
            ab.i(this.llu.TAG, "destroyGL");
            this.llu.llt.release();
            EGL14.eglDestroyContext(this.llu.llp, this.llu.llq);
            EGL14.eglDestroySurface(this.llu.llp, this.llu.llr);
            this.llu.llq = EGL14.EGL_NO_CONTEXT;
            this.llu.llr = EGL14.EGL_NO_SURFACE;
            this.llu.fcm.release();
            this.llu.eXa.quit();
            y yVar = y.AUy;
            AppMethodBeat.o(2898);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ b llu;
        final /* synthetic */ boolean lly;

        b(b bVar, boolean z) {
            this.llu = bVar;
            this.lly = z;
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            boolean z;
            i iVar = this.llu.llt;
            if (this.lly) {
                z = false;
            } else {
                z = true;
            }
            iVar.gLJ = z;
            return y.AUy;
        }
    }

    public b(SurfaceTexture surfaceTexture, i iVar, final a.f.a.b<? super b, y> bVar) {
        j.p(surfaceTexture, "texture");
        j.p(iVar, "renderer");
        AppMethodBeat.i(2903);
        this.fcm = surfaceTexture;
        this.llt = iVar;
        HandlerThread anM = d.anM("EmojiVideoPlayTextureRenderSurface_renderThread");
        j.o(anM, "ThreadPool.newFreeHandle…derSurface_renderThread\")");
        this.eXa = anM;
        this.eXa.start();
        this.eXb = new ak(this.eXa.getLooper());
        b(new a.f.a.a<y>(this) {
            final /* synthetic */ b llu;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "pts", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b$1$1 */
            static final class AnonymousClass1 extends k implements a.f.a.b<Long, y> {
                final /* synthetic */ AnonymousClass1 llw;

                AnonymousClass1(AnonymousClass1 anonymousClass1) {
                    this.llw = anonymousClass1;
                    super(1);
                }

                public final /* synthetic */ Object am(Object obj) {
                    AppMethodBeat.i(2896);
                    final long longValue = ((Number) obj).longValue();
                    this.llw.llu.b(new a.f.a.a<y>(this) {
                        final /* synthetic */ AnonymousClass1 llx;

                        public final /* synthetic */ Object invoke() {
                            AppMethodBeat.i(2895);
                            b bVar = this.llx.llw.llu;
                            long j = longValue;
                            i iVar = bVar.llt;
                            SurfaceTexture surfaceTexture = iVar.lql;
                            if (surfaceTexture != null) {
                                surfaceTexture.updateTexImage();
                            }
                            iVar.gLv = true;
                            if (iVar.iZn > 0 && iVar.iZo > 0) {
                                com.tencent.mm.plugin.emojicapture.ui.b.c.a aVar = c.loN;
                                com.tencent.mm.plugin.emojicapture.ui.b.c.a.Vj();
                                if (!iVar.ljd) {
                                    GLES20.glViewport(0, 0, iVar.iZn, iVar.iZo);
                                    i.a(iVar, iVar.lpX, iVar.iZn, iVar.iZo, true);
                                } else if (iVar.lqh > 0 && iVar.lqi > 0) {
                                    PTFaceAttr a;
                                    aVar = c.loN;
                                    h hVar = iVar.lpq;
                                    if (hVar == null) {
                                        j.avw("ptFaceFrame");
                                    }
                                    int wE = hVar.wE();
                                    h hVar2 = iVar.lpq;
                                    if (hVar2 == null) {
                                        j.avw("ptFaceFrame");
                                    }
                                    int textureId = hVar2.getTextureId();
                                    h hVar3 = iVar.lpq;
                                    if (hVar3 == null) {
                                        j.avw("ptFaceFrame");
                                    }
                                    int i = hVar3.width;
                                    h hVar4 = iVar.lpq;
                                    if (hVar4 == null) {
                                        j.avw("ptFaceFrame");
                                    }
                                    com.tencent.mm.plugin.emojicapture.ui.b.c.a.y(wE, textureId, i, hVar4.height);
                                    GLES20.glViewport(0, 0, iVar.lqj, iVar.lqj);
                                    wE = iVar.lqi;
                                    if (wE != 0) {
                                        GLES20.glUseProgram(iVar.lpg);
                                        GLES20.glActiveTexture(33984);
                                        GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, wE);
                                        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
                                        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
                                        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 33071.0f);
                                        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 33071.0f);
                                        GLES20.glUniform1i(iVar.lpj, 0);
                                        iVar.eZi.position(0);
                                        GLES20.glVertexAttribPointer(iVar.lph, 2, 5126, false, 0, iVar.eZi);
                                        GLES20.glEnableVertexAttribArray(iVar.lph);
                                        iVar.eZh.position(0);
                                        iVar.eZh.put(c.faa);
                                        iVar.eZh.position(0);
                                        GLES20.glVertexAttribPointer(iVar.lpi, 2, 5126, false, 0, iVar.eZh);
                                        GLES20.glEnableVertexAttribArray(iVar.lpi);
                                        GLES20.glDrawArrays(5, 0, 4);
                                        GLES20.glDisableVertexAttribArray(iVar.lph);
                                        GLES20.glDisableVertexAttribArray(iVar.lpi);
                                        GLES20.glBindTexture(3553, 0);
                                        GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
                                        GLES20.glUseProgram(0);
                                    }
                                    GLES20.glBindFramebuffer(36160, 0);
                                    aVar = c.loN;
                                    com.tencent.mm.plugin.emojicapture.ui.b.c.a.Vj();
                                    GLES20.glViewport(0, 0, iVar.lqj, iVar.lqj);
                                    hVar3 = iVar.lpq;
                                    if (hVar3 == null) {
                                        j.avw("ptFaceFrame");
                                    }
                                    com.tencent.mm.bu.b bVar2 = iVar.lpo;
                                    if (bVar2 != null) {
                                        hVar2 = iVar.lpq;
                                        if (hVar2 == null) {
                                            j.avw("ptFaceFrame");
                                        }
                                        a = com.tencent.mm.bu.b.a(bVar2, hVar2);
                                    } else {
                                        a = null;
                                    }
                                    if (a != null) {
                                        if (a.getOrigFrame() != null) {
                                            hVar3 = a.getOrigFrame();
                                            j.o(hVar3, "faceAttr.origFrame");
                                        }
                                        long yz = bo.yz();
                                        try {
                                            PTSegment pTSegment = iVar.lpp;
                                            if (pTSegment != null) {
                                                hVar = pTSegment.segTexture(a, hVar3, 0.015f, iVar.lqj, iVar.lqj);
                                                if (hVar != null) {
                                                    hVar3 = hVar;
                                                }
                                            }
                                        } catch (Exception e) {
                                            com.tencent.mm.plugin.emojicapture.model.d dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                                            com.tencent.mm.plugin.emojicapture.model.d.bni();
                                        }
                                        ab.d(iVar.TAG, "segTexture used " + bo.az(yz) + "ms");
                                        aVar = c.loN;
                                        com.tencent.mm.plugin.emojicapture.ui.b.c.a.Vj();
                                    }
                                    GLES20.glFinish();
                                    aVar = c.loN;
                                    com.tencent.mm.plugin.emojicapture.ui.b.c.a.Vj();
                                    GLES20.glViewport(0, 0, iVar.iZn, iVar.iZo);
                                    i.a(iVar, hVar3.getTextureId(), iVar.iZn, iVar.iZo, false);
                                }
                            }
                            iVar.gLv = false;
                            iVar.gLJ = false;
                            a.f.a.a aVar2 = iVar.lqm;
                            if (aVar2 != null) {
                                aVar2.invoke();
                            }
                            EGLExt.eglPresentationTimeANDROID(bVar.llp, bVar.llr, j);
                            EGL14.eglSwapBuffers(bVar.llp, bVar.llr);
                            y yVar = y.AUy;
                            AppMethodBeat.o(2895);
                            return yVar;
                        }
                    });
                    y yVar = y.AUy;
                    AppMethodBeat.o(2896);
                    return yVar;
                }
            }

            public final /* synthetic */ Object invoke() {
                com.tencent.mm.plugin.emojicapture.ui.b.c.a aVar;
                AppMethodBeat.i(2897);
                b bVar = this.llu;
                ab.i(bVar.TAG, "initGL");
                bVar.llp = EGL14.eglGetDisplay(0);
                if (bVar.llp == EGL14.EGL_NO_DISPLAY) {
                    ab.e(bVar.TAG, "egl get display error: %s", GLUtils.getEGLErrorString(EGL14.eglGetError()));
                } else {
                    int[] iArr = new int[2];
                    if (EGL14.eglInitialize(bVar.llp, iArr, 0, iArr, 1)) {
                        EGLConfig eGLConfig;
                        aVar = c.loN;
                        EGLDisplay eGLDisplay = bVar.llp;
                        j.o(eGLDisplay, "mEglDisplay");
                        j.p(eGLDisplay, "eGLDisplay");
                        EGLConfig[] eGLConfigArr = new EGLConfig[1];
                        if (EGL14.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                            eGLConfig = eGLConfigArr[0];
                        } else {
                            ab.e("MicroMsg.EmojiCaptureGLUtil", "egl choose config failed: %s", GLUtils.getEGLErrorString(EGL14.eglGetError()));
                            eGLConfig = null;
                        }
                        if (eGLConfig != null) {
                            Object obj;
                            bVar.llq = EGL14.eglCreateContext(bVar.llp, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                            bVar.llr = EGL14.eglCreateWindowSurface(bVar.llp, eGLConfig, bVar.fcm, new int[]{12344}, 0);
                            if (bVar.llr != EGL14.EGL_NO_SURFACE && bVar.llq != EGL14.EGL_NO_CONTEXT) {
                                obj = null;
                            } else if (EGL14.eglGetError() == 12299) {
                                ab.e(bVar.TAG, "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                                obj = -1;
                            } else {
                                ab.e(bVar.TAG, "eglCreateWindowSurface failed : %s", GLUtils.getEGLErrorString(EGL14.eglGetError()));
                                obj = -1;
                            }
                            if (obj >= null && !EGL14.eglMakeCurrent(bVar.llp, bVar.llr, bVar.llr, bVar.llq)) {
                                ab.e(bVar.TAG, "eglMakeCurrent failed : %s", GLUtils.getEGLErrorString(EGL14.eglGetError()));
                            }
                        }
                    } else {
                        ab.e(bVar.TAG, "egl init error: %s", GLUtils.getEGLErrorString(EGL14.eglGetError()));
                    }
                }
                i iVar = this.llu.llt;
                if (!iVar.eNa) {
                    iVar.eNa = true;
                    ab.i(iVar.TAG, "init: " + iVar + ", " + iVar.llN);
                    aVar = c.loN;
                    iVar.lpX = com.tencent.mm.plugin.emojicapture.ui.b.c.a.bof();
                    aVar = c.loN;
                    iVar.lpY = com.tencent.mm.plugin.emojicapture.ui.b.c.a.U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES externalTexture;\n        uniform sampler2D normalTexture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int calcRoundCorner;\n        uniform int useNormalTexture;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(radius, radius);\n                vec2 bottomRightCenter = vec2(size.x - radius, radius);\n                vec2 topLeftCenter = vec2(radius, size.y - radius);\n                vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.x && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n                   gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n                } else {\n                    if (useNormalTexture == 1) {\n                        gl_FragColor = texture2D(normalTexture, v_texCoord);\n                    } else {\n                        gl_FragColor = vec4(texture2D(externalTexture, v_texCoord).rgb, 1.0);\n                    }\n                }\n            } else {\n                if (useNormalTexture == 1) {\n                    gl_FragColor = texture2D(normalTexture, v_texCoord);\n                } else {\n                    gl_FragColor = vec4(texture2D(externalTexture, v_texCoord).rgb, 1.0);\n                }\n            }\n        }\n        ");
                    iVar.lpZ = GLES20.glGetAttribLocation(iVar.lpY, "a_texCoord");
                    iVar.lqa = GLES20.glGetAttribLocation(iVar.lpY, "a_position");
                    iVar.lqb = GLES20.glGetUniformLocation(iVar.lpY, "externalTexture");
                    iVar.lqc = GLES20.glGetUniformLocation(iVar.lpY, "normalTexture");
                    iVar.lqd = GLES20.glGetUniformLocation(iVar.lpY, "size");
                    iVar.lqe = GLES20.glGetUniformLocation(iVar.lpY, "radius");
                    iVar.lqf = GLES20.glGetUniformLocation(iVar.lpY, "calcRoundCorner");
                    iVar.lqg = GLES20.glGetUniformLocation(iVar.lpY, "useNormalTexture");
                    aVar = c.loN;
                    iVar.lpg = com.tencent.mm.plugin.emojicapture.ui.b.c.a.U("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
                    iVar.lph = GLES20.glGetAttribLocation(iVar.lpg, "a_position");
                    iVar.lpi = GLES20.glGetAttribLocation(iVar.lpg, "a_texCoord");
                    iVar.lpj = GLES20.glGetUniformLocation(iVar.lpg, "texture");
                    aVar = c.loN;
                    iVar.lqh = com.tencent.mm.plugin.emojicapture.ui.b.c.a.Vi();
                    aVar = c.loN;
                    iVar.lqi = com.tencent.mm.plugin.emojicapture.ui.b.c.a.Vh();
                    aVar = c.loN;
                    iVar.lpr = com.tencent.mm.plugin.emojicapture.ui.b.c.a.Vh();
                    iVar.eZi.put(iVar.gLB);
                    iVar.eZh.put(iVar.gLC);
                    GLES20.glBindTexture(3553, iVar.lpX);
                    com.tencent.mm.plugin.emojicapture.model.c.a aVar2 = com.tencent.mm.plugin.emojicapture.model.c.lhw;
                    int bmM = com.tencent.mm.plugin.emojicapture.model.c.lht;
                    com.tencent.mm.plugin.emojicapture.model.c.a aVar3 = com.tencent.mm.plugin.emojicapture.model.c.lhw;
                    GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, bmM, com.tencent.mm.plugin.emojicapture.model.c.lht, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
                    GLES20.glBindTexture(3553, 0);
                    iVar.lql = new SurfaceTexture(iVar.lpX);
                    SurfaceTexture surfaceTexture = iVar.lql;
                    if (surfaceTexture != null) {
                        surfaceTexture.setOnFrameAvailableListener(iVar);
                    }
                    if (iVar.llN && !iVar.lqp) {
                        iVar.lqp = true;
                        ab.i(iVar.TAG, "initSegment: ");
                        try {
                            PTModule.getInstance().init(EGL14.eglGetCurrentContext());
                            iVar.lpo = new com.tencent.mm.bu.b();
                            iVar.lpp = new PTSegment();
                            com.tencent.mm.bu.b bVar2 = iVar.lpo;
                            if (bVar2 != null) {
                                bVar2.init();
                            }
                            PTSegment pTSegment = iVar.lpp;
                            if (pTSegment != null) {
                                pTSegment.init();
                            }
                        } catch (Exception e) {
                            ab.printErrStackTrace(iVar.TAG, e, "init segment error", new Object[0]);
                            com.tencent.mm.plugin.emojicapture.model.d dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                            com.tencent.mm.plugin.emojicapture.model.d.bnh();
                        }
                    }
                    iVar.lpq = new h(iVar.lqh, iVar.lqi, iVar.lqj, iVar.lqj);
                }
                this.llu.llt.lqn = new AnonymousClass1(this);
                a.f.a.b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.am(this.llu);
                }
                y yVar = y.AUy;
                AppMethodBeat.o(2897);
                return yVar;
            }
        });
        AppMethodBeat.o(2903);
    }

    /* Access modifiers changed, original: final */
    public final void b(a.f.a.a<y> aVar) {
        AppMethodBeat.i(2900);
        this.eXb.post(new c(aVar));
        AppMethodBeat.o(2900);
    }

    public final void gF(boolean z) {
        AppMethodBeat.i(2901);
        ab.i(this.TAG, "setNeedRender:".concat(String.valueOf(z)));
        this.needRender = z;
        AppMethodBeat.o(2901);
    }

    public final void gG(boolean z) {
        AppMethodBeat.i(2902);
        this.lls = z;
        b(new b(this, z));
        AppMethodBeat.o(2902);
    }
}
