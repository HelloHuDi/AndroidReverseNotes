package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class c extends Thread {
    private SurfaceTexture fcm;
    private d gLH;
    private EGL10 mEgl;
    private EGLContext mEglContext = EGL10.EGL_NO_CONTEXT;
    private EGLDisplay mEglDisplay = EGL10.EGL_NO_DISPLAY;
    private EGLSurface mEglSurface = EGL10.EGL_NO_SURFACE;
    volatile boolean needRender;

    public c(SurfaceTexture surfaceTexture, d dVar) {
        this.fcm = surfaceTexture;
        this.gLH = dVar;
    }

    public final void run() {
        Object obj;
        AppMethodBeat.i(76333);
        ab.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
        this.mEgl = (EGL10) EGLContext.getEGL();
        this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
            ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
            obj = -1;
        } else {
            if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (this.mEgl.eglChooseConfig(this.mEglDisplay, new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                    this.mEglContext = this.mEgl.eglCreateContext(this.mEglDisplay, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    this.mEglSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, eGLConfigArr[0], this.fcm, null);
                    if (this.mEglSurface != EGL10.EGL_NO_SURFACE && this.mEglContext != EGL10.EGL_NO_CONTEXT) {
                        if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
                            ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
                        }
                        obj = null;
                    } else if (this.mEgl.eglGetError() == 12299) {
                        ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                        obj = -1;
                    } else {
                        ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
                        obj = -1;
                    }
                } else {
                    ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
                    obj = -1;
                }
            } else {
                ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
                obj = -1;
            }
        }
        if (obj < null) {
            ab.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
            AppMethodBeat.o(76333);
            return;
        }
        d dVar;
        if (this.gLH != null) {
            dVar = this.gLH;
            synchronized (d.lock) {
                try {
                    ab.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", dVar);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glDisable(2929);
                    dVar.eZH = b.U("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
                    if (dVar.eZH == 0) {
                        ab.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
                    }
                    dVar.eZI = GLES20.glGetAttribLocation(dVar.eZH, "a_position");
                    dVar.eZJ = GLES20.glGetAttribLocation(dVar.eZH, "a_texCoord");
                    dVar.eZR = GLES20.glGetUniformLocation(dVar.eZH, "y_texture");
                    dVar.eZS = GLES20.glGetUniformLocation(dVar.eZH, "uv_texture");
                    dVar.gLy = GLES20.glGetUniformLocation(dVar.eZH, "uMatrix");
                    dVar.eZM = b.Vh();
                    dVar.eZN = b.Vh();
                    dVar.eZi = ByteBuffer.allocateDirect(dVar.gLB.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                    dVar.eZi.put(dVar.gLB);
                    dVar.eZi.position(0);
                    dVar.eZh = ByteBuffer.allocateDirect(d.eZZ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                    dVar.eZh.put(d.eZZ);
                    dVar.eZh.position(0);
                    ab.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", Integer.valueOf(dVar.eZM), Integer.valueOf(dVar.eZN), dVar);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(76333);
                    }
                }
            }
            ab.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        }
        while (this.needRender) {
            if (this.gLH != null) {
                if (!this.gLH.gLJ) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        ab.printErrStackTrace("MicroMsg.MMSightRecordTextureViewRenderThread", e, "", new Object[0]);
                    }
                }
                d dVar2 = this.gLH;
                bo.yz();
                dVar2.gLv = true;
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16640);
                synchronized (d.lock) {
                    try {
                        if (dVar2.eZH != -1 && dVar2.eZM != -1 && dVar2.eZN != -1 && dVar2.gLw > 0 && dVar2.gLx > 0 && dVar2.eZV != null && dVar2.eZU != null && dVar2.eZV.limit() > 0 && dVar2.eZU.limit() > 0 && dVar2.eZV.position() == 0 && dVar2.eZU.position() == 0) {
                            GLES20.glUseProgram(dVar2.eZH);
                            GLES20.glActiveTexture(33984);
                            GLES20.glBindTexture(3553, dVar2.eZM);
                            GLES20.glTexImage2D(3553, 0, 6409, dVar2.gLw, dVar2.gLx, 0, 6409, GLType.GL_UNSIGNED_BYTE, dVar2.eZU);
                            GLES20.glTexParameterf(3553, 10241, 9729.0f);
                            GLES20.glTexParameterf(3553, 10240, 9729.0f);
                            GLES20.glTexParameterf(3553, 10242, 33071.0f);
                            GLES20.glTexParameterf(3553, 10243, 33071.0f);
                            GLES20.glUniform1i(dVar2.eZR, 0);
                            GLES20.glActiveTexture(33985);
                            GLES20.glBindTexture(3553, dVar2.eZN);
                            GLES20.glTexImage2D(3553, 0, 6410, dVar2.gLw / 2, dVar2.gLx / 2, 0, 6410, GLType.GL_UNSIGNED_BYTE, dVar2.eZV);
                            GLES20.glTexParameterf(3553, 10241, 9729.0f);
                            GLES20.glTexParameterf(3553, 10240, 9729.0f);
                            GLES20.glTexParameterf(3553, 10242, 33071.0f);
                            GLES20.glTexParameterf(3553, 10243, 33071.0f);
                            GLES20.glUniform1i(dVar2.eZS, 1);
                            Matrix.setIdentityM(dVar2.gLz, 0);
                            Matrix.setRotateM(dVar2.gLz, 0, (float) dVar2.rotate, 0.0f, 0.0f, -1.0f);
                            GLES20.glUniformMatrix4fv(dVar2.gLy, 1, false, dVar2.gLz, 0);
                            dVar2.eZi.position(0);
                            GLES20.glVertexAttribPointer(dVar2.eZI, 2, 5126, false, 0, dVar2.eZi);
                            GLES20.glEnableVertexAttribArray(dVar2.eZI);
                            dVar2.eZh.position(0);
                            GLES20.glVertexAttribPointer(dVar2.eZJ, 2, 5126, false, 0, dVar2.eZh);
                            GLES20.glEnableVertexAttribArray(dVar2.eZJ);
                            GLES20.glDrawArrays(5, 0, 4);
                            GLES20.glDisableVertexAttribArray(dVar2.eZI);
                            GLES20.glDisableVertexAttribArray(dVar2.eZJ);
                            GLES20.glBindTexture(3553, 0);
                        }
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(76333);
                        }
                    }
                }
                dVar2.gLv = false;
            }
            if (this.mEgl != null) {
                this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
            }
        }
        ab.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, start destroy gl");
        if (this.gLH != null) {
            dVar = this.gLH;
            synchronized (d.lock) {
                try {
                    if (dVar.eZH >= 0) {
                        GLES20.glDeleteProgram(dVar.eZH);
                        dVar.eZH = -1;
                    }
                    if (dVar.eZN >= 0) {
                        GLES20.glDeleteTextures(1, new int[]{dVar.eZN}, 0);
                        dVar.eZN = -1;
                    }
                    if (dVar.eZM >= 0) {
                        GLES20.glDeleteTextures(1, new int[]{dVar.eZM}, 0);
                        dVar.eZM = -1;
                    }
                    dVar.gLx = -1;
                    dVar.gLw = -1;
                    dVar.eWi = true;
                    dVar.eZU = null;
                    dVar.eZV = null;
                } catch (Throwable th3) {
                    while (true) {
                        AppMethodBeat.o(76333);
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
        ab.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
        AppMethodBeat.o(76333);
    }
}
