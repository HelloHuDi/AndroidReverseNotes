package com.tencent.p177mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* renamed from: com.tencent.mm.plugin.api.recordView.c */
final class C10043c extends Thread {
    private SurfaceTexture fcm;
    private C33058d gLH;
    private EGL10 mEgl;
    private EGLContext mEglContext = EGL10.EGL_NO_CONTEXT;
    private EGLDisplay mEglDisplay = EGL10.EGL_NO_DISPLAY;
    private EGLSurface mEglSurface = EGL10.EGL_NO_SURFACE;
    volatile boolean needRender;

    public C10043c(SurfaceTexture surfaceTexture, C33058d c33058d) {
        this.fcm = surfaceTexture;
        this.gLH = c33058d;
    }

    public final void run() {
        Object obj;
        AppMethodBeat.m2504i(76333);
        C4990ab.m7416i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
        this.mEgl = (EGL10) EGLContext.getEGL();
        this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
            C4990ab.m7413e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
            obj = -1;
        } else {
            if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (this.mEgl.eglChooseConfig(this.mEglDisplay, new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                    this.mEglContext = this.mEgl.eglCreateContext(this.mEglDisplay, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    this.mEglSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, eGLConfigArr[0], this.fcm, null);
                    if (this.mEglSurface != EGL10.EGL_NO_SURFACE && this.mEglContext != EGL10.EGL_NO_CONTEXT) {
                        if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
                            C4990ab.m7413e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
                        }
                        obj = null;
                    } else if (this.mEgl.eglGetError() == 12299) {
                        C4990ab.m7412e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                        obj = -1;
                    } else {
                        C4990ab.m7413e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
                        obj = -1;
                    }
                } else {
                    C4990ab.m7413e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
                    obj = -1;
                }
            } else {
                C4990ab.m7413e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
                obj = -1;
            }
        }
        if (obj < null) {
            C4990ab.m7412e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
            AppMethodBeat.m2505o(76333);
            return;
        }
        C33058d c33058d;
        if (this.gLH != null) {
            c33058d = this.gLH;
            synchronized (C33058d.lock) {
                try {
                    C4990ab.m7417i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", c33058d);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glDisable(2929);
                    c33058d.eZH = C26715b.m42547U("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
                    if (c33058d.eZH == 0) {
                        C4990ab.m7412e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
                    }
                    c33058d.eZI = GLES20.glGetAttribLocation(c33058d.eZH, "a_position");
                    c33058d.eZJ = GLES20.glGetAttribLocation(c33058d.eZH, "a_texCoord");
                    c33058d.eZR = GLES20.glGetUniformLocation(c33058d.eZH, "y_texture");
                    c33058d.eZS = GLES20.glGetUniformLocation(c33058d.eZH, "uv_texture");
                    c33058d.gLy = GLES20.glGetUniformLocation(c33058d.eZH, "uMatrix");
                    c33058d.eZM = C26715b.m42548Vh();
                    c33058d.eZN = C26715b.m42548Vh();
                    c33058d.eZi = ByteBuffer.allocateDirect(c33058d.gLB.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                    c33058d.eZi.put(c33058d.gLB);
                    c33058d.eZi.position(0);
                    c33058d.eZh = ByteBuffer.allocateDirect(C33058d.eZZ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                    c33058d.eZh.put(C33058d.eZZ);
                    c33058d.eZh.position(0);
                    C4990ab.m7417i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", Integer.valueOf(c33058d.eZM), Integer.valueOf(c33058d.eZN), c33058d);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(76333);
                    }
                }
            }
            C4990ab.m7416i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        }
        while (this.needRender) {
            if (this.gLH != null) {
                if (!this.gLH.gLJ) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        C4990ab.printErrStackTrace("MicroMsg.MMSightRecordTextureViewRenderThread", e, "", new Object[0]);
                    }
                }
                C33058d c33058d2 = this.gLH;
                C5046bo.m7588yz();
                c33058d2.gLv = true;
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16640);
                synchronized (C33058d.lock) {
                    try {
                        if (c33058d2.eZH != -1 && c33058d2.eZM != -1 && c33058d2.eZN != -1 && c33058d2.gLw > 0 && c33058d2.gLx > 0 && c33058d2.eZV != null && c33058d2.eZU != null && c33058d2.eZV.limit() > 0 && c33058d2.eZU.limit() > 0 && c33058d2.eZV.position() == 0 && c33058d2.eZU.position() == 0) {
                            GLES20.glUseProgram(c33058d2.eZH);
                            GLES20.glActiveTexture(33984);
                            GLES20.glBindTexture(3553, c33058d2.eZM);
                            GLES20.glTexImage2D(3553, 0, 6409, c33058d2.gLw, c33058d2.gLx, 0, 6409, GLType.GL_UNSIGNED_BYTE, c33058d2.eZU);
                            GLES20.glTexParameterf(3553, 10241, 9729.0f);
                            GLES20.glTexParameterf(3553, 10240, 9729.0f);
                            GLES20.glTexParameterf(3553, 10242, 33071.0f);
                            GLES20.glTexParameterf(3553, 10243, 33071.0f);
                            GLES20.glUniform1i(c33058d2.eZR, 0);
                            GLES20.glActiveTexture(33985);
                            GLES20.glBindTexture(3553, c33058d2.eZN);
                            GLES20.glTexImage2D(3553, 0, 6410, c33058d2.gLw / 2, c33058d2.gLx / 2, 0, 6410, GLType.GL_UNSIGNED_BYTE, c33058d2.eZV);
                            GLES20.glTexParameterf(3553, 10241, 9729.0f);
                            GLES20.glTexParameterf(3553, 10240, 9729.0f);
                            GLES20.glTexParameterf(3553, 10242, 33071.0f);
                            GLES20.glTexParameterf(3553, 10243, 33071.0f);
                            GLES20.glUniform1i(c33058d2.eZS, 1);
                            Matrix.setIdentityM(c33058d2.gLz, 0);
                            Matrix.setRotateM(c33058d2.gLz, 0, (float) c33058d2.rotate, 0.0f, 0.0f, -1.0f);
                            GLES20.glUniformMatrix4fv(c33058d2.gLy, 1, false, c33058d2.gLz, 0);
                            c33058d2.eZi.position(0);
                            GLES20.glVertexAttribPointer(c33058d2.eZI, 2, 5126, false, 0, c33058d2.eZi);
                            GLES20.glEnableVertexAttribArray(c33058d2.eZI);
                            c33058d2.eZh.position(0);
                            GLES20.glVertexAttribPointer(c33058d2.eZJ, 2, 5126, false, 0, c33058d2.eZh);
                            GLES20.glEnableVertexAttribArray(c33058d2.eZJ);
                            GLES20.glDrawArrays(5, 0, 4);
                            GLES20.glDisableVertexAttribArray(c33058d2.eZI);
                            GLES20.glDisableVertexAttribArray(c33058d2.eZJ);
                            GLES20.glBindTexture(3553, 0);
                        }
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.m2505o(76333);
                        }
                    }
                }
                c33058d2.gLv = false;
            }
            if (this.mEgl != null) {
                this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
            }
        }
        C4990ab.m7416i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, start destroy gl");
        if (this.gLH != null) {
            c33058d = this.gLH;
            synchronized (C33058d.lock) {
                try {
                    if (c33058d.eZH >= 0) {
                        GLES20.glDeleteProgram(c33058d.eZH);
                        c33058d.eZH = -1;
                    }
                    if (c33058d.eZN >= 0) {
                        GLES20.glDeleteTextures(1, new int[]{c33058d.eZN}, 0);
                        c33058d.eZN = -1;
                    }
                    if (c33058d.eZM >= 0) {
                        GLES20.glDeleteTextures(1, new int[]{c33058d.eZM}, 0);
                        c33058d.eZM = -1;
                    }
                    c33058d.gLx = -1;
                    c33058d.gLw = -1;
                    c33058d.eWi = true;
                    c33058d.eZU = null;
                    c33058d.eZV = null;
                } catch (Throwable th3) {
                    while (true) {
                        AppMethodBeat.m2505o(76333);
                    }
                }
            }
        }
        if (!(this.mEgl == null || this.mEglContext == null || this.mEglSurface == null)) {
            this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
            this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
            this.mEglContext = EGL10.EGL_NO_CONTEXT;
            this.mEglSurface = EGL10.EGL_NO_SURFACE;
        }
        if (this.fcm != null) {
            this.fcm.release();
        }
        C4990ab.m7416i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
        AppMethodBeat.m2505o(76333);
    }
}
