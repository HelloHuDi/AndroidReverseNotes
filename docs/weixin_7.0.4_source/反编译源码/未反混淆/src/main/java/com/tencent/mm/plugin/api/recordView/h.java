package com.tencent.mm.plugin.api.recordView;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.api.recordView.i.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class h {
    private final String TAG = "MicroMsg.YUVDateRenderToRBGBufferThread";
    boolean eCM = false;
    HandlerThread eXa = d.anM("YUVDateRenderToRBGBufferThread");
    ak eXb;
    int[] fab = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344};
    EGLSurface faf = null;
    EGLContext fag = null;
    int fcf;
    int gLw;
    int gLx;
    i gMv;
    a gMw = null;
    int gMx;
    int gMy;
    EGLDisplay gMz = null;

    /* renamed from: com.tencent.mm.plugin.api.recordView.h$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int gMC;
        final /* synthetic */ byte[] val$data;

        AnonymousClass2(byte[] bArr, int i) {
            this.val$data = bArr;
            this.gMC = i;
        }

        public final void run() {
            AppMethodBeat.i(76387);
            i iVar = h.this.gMv;
            byte[] bArr = this.val$data;
            int i = h.this.gLw;
            int i2 = h.this.gLx;
            int i3 = h.this.fcf;
            int i4 = this.gMC;
            try {
                int i5;
                if (iVar.gLx == i2 && iVar.gLw == i && iVar.rotate == i3 && iVar.gLD == i4) {
                    i5 = 0;
                } else {
                    i5 = 1;
                }
                if (i5 != 0) {
                    ab.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(iVar.fdb), Boolean.TRUE, iVar);
                }
                iVar.frameData = bArr;
                iVar.gLw = i;
                iVar.gLx = i2;
                iVar.rotate = i3;
                iVar.gLD = i4;
                if (i5 != 0) {
                    iVar.eZU = ByteBuffer.allocateDirect(i2 * i);
                    iVar.eZV = ByteBuffer.allocateDirect((i * i2) / 2);
                    iVar.eZU.order(ByteOrder.nativeOrder());
                    iVar.eZV.order(ByteOrder.nativeOrder());
                    if (iVar.gLB != null) {
                        iVar.eZi.put(iVar.gLB);
                        iVar.eZi.position(0);
                    }
                }
                if (!(iVar.eZU == null || iVar.eZV == null)) {
                    iVar.eZU.put(bArr, 0, i * i2);
                    iVar.eZU.position(0);
                    iVar.eZV.put(bArr, i * i2, (i * i2) / 2);
                    iVar.eZV.position(0);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame error: %s", e.getMessage());
            }
            h.this.gMv.onDrawFrame(null);
            h.this.gMw.asB();
            AppMethodBeat.o(76387);
        }
    }

    public h() {
        AppMethodBeat.i(76389);
        AppMethodBeat.o(76389);
    }

    public final void a(final EGLContext eGLContext) {
        AppMethodBeat.i(76390);
        ab.d("MicroMsg.YUVDateRenderToRBGBufferThread", "start context : " + eGLContext + "  hasStart : " + this.eCM);
        if (this.eCM || eGLContext == null) {
            AppMethodBeat.o(76390);
            return;
        }
        this.eCM = true;
        this.eXa.start();
        this.eXb = new ak(this.eXa.getLooper());
        queue(new Runnable() {
            public final void run() {
                AppMethodBeat.i(76386);
                h hVar = h.this;
                EGLContext eGLContext = eGLContext;
                int i = h.this.gLw;
                int i2 = h.this.gLx;
                hVar.gMz = EGL14.eglGetDisplay(0);
                RuntimeException runtimeException;
                if (hVar.gMz == EGL14.EGL_NO_DISPLAY) {
                    runtimeException = new RuntimeException("unable to get EGL14 display");
                    AppMethodBeat.o(76386);
                    throw runtimeException;
                }
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(hVar.gMz, iArr, 0, iArr, 1)) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    EGL14.eglChooseConfig(hVar.gMz, hVar.fab, 0, eGLConfigArr, 0, 1, new int[1], 0);
                    if (eGLConfigArr[0] == null) {
                        runtimeException = new RuntimeException("chooseConfig failed");
                        AppMethodBeat.o(76386);
                        throw runtimeException;
                    }
                    hVar.fag = EGL14.eglCreateContext(hVar.gMz, eGLConfigArr[0], eGLContext, new int[]{12440, 2, 12344}, 0);
                    if (hVar.fag == EGL14.EGL_NO_CONTEXT) {
                        runtimeException = new RuntimeException("EGL error " + EGL14.eglGetError());
                        AppMethodBeat.o(76386);
                        throw runtimeException;
                    }
                    h.wH("eglCreateContext");
                    iArr = new int[]{12375, i, 12374, i2, 12344};
                    hVar.faf = null;
                    try {
                        hVar.faf = EGL14.eglCreatePbufferSurface(hVar.gMz, eGLConfigArr[0], iArr, 0);
                    } catch (IllegalArgumentException e) {
                        ab.e("MicroMsg.YUVDateRenderToRBGBufferThread", "eglCreateWindowSurface", e);
                    }
                    h.wH("eglCreatePbufferSurface");
                    if ((hVar.faf == null || hVar.faf == EGL14.EGL_NO_SURFACE) && EGL14.eglGetError() == 12299) {
                        ab.e("MicroMsg.YUVDateRenderToRBGBufferThread", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    if (!EGL14.eglMakeCurrent(hVar.gMz, hVar.faf, hVar.faf, hVar.fag)) {
                        ab.w("MicroMsg.YUVDateRenderToRBGBufferThread", "eglMakeCurrent:" + EGL14.eglGetError());
                    }
                    h hVar2 = h.this;
                    int i3 = h.this.gLw;
                    int i4 = h.this.gLx;
                    int i5 = h.this.gMx;
                    int i6 = h.this.gMy;
                    hVar2.gMv = new i(i3, i4, i5, i6);
                    hVar2.gMv.onSurfaceCreated(null, null);
                    hVar2.gMv.onSurfaceChanged(null, i5, i6);
                    if (hVar2.gMw != null) {
                        hVar2.gMv.buffer = hVar2.gMw.getBuffer();
                    }
                    AppMethodBeat.o(76386);
                    return;
                }
                hVar.gMz = null;
                runtimeException = new RuntimeException("eglInitialize failed");
                AppMethodBeat.o(76386);
                throw runtimeException;
            }
        });
        AppMethodBeat.o(76390);
    }

    public final void h(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(76391);
        ab.i("MicroMsg.YUVDateRenderToRBGBufferThread", "setFrameInfo, width: %s, height: %s, rotate: %s ,targetWidth:%d ,targetHeight:%d , this: %s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), this);
        if (!(i == this.gLw && i2 == this.gLx && i3 == this.fcf)) {
            this.gLw = i;
            this.gLx = i2;
            this.fcf = i3;
        }
        this.gMx = i4;
        this.gMy = i5;
        AppMethodBeat.o(76391);
    }

    /* Access modifiers changed, original: final */
    public final void queue(Runnable runnable) {
        AppMethodBeat.i(76392);
        if (this.eXa.isAlive()) {
            this.eXb.post(runnable);
        }
        AppMethodBeat.o(76392);
    }

    public final void release() {
        AppMethodBeat.i(76393);
        queue(new Runnable() {
            public final void run() {
                AppMethodBeat.i(76388);
                i iVar = h.this.gMv;
                if (iVar.eZj != 0) {
                    GLES20.glDeleteTextures(1, new int[]{iVar.eZj}, 0);
                }
                if (iVar.eZk != 0) {
                    GLES20.glDeleteFramebuffers(1, new int[]{iVar.eZk}, 0);
                }
                EGLDisplay eGLDisplay = h.this.gMz;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                if (!(h.this.faf == null || h.this.fag == null || h.this.gMz == null)) {
                    EGL14.eglDestroySurface(h.this.gMz, h.this.faf);
                    EGL14.eglDestroyContext(h.this.gMz, h.this.fag);
                    EGL14.eglReleaseThread();
                    EGL14.eglTerminate(h.this.gMz);
                    h.this.fag = null;
                    h.this.gMz = null;
                    h.this.faf = null;
                }
                h.this.eXb.removeCallbacksAndMessages(null);
                h.this.eXa.quitSafely();
                AppMethodBeat.o(76388);
            }
        });
        AppMethodBeat.o(76393);
    }

    static boolean wH(String str) {
        AppMethodBeat.i(76394);
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            ab.c("MicroMsg.YUVDateRenderToRBGBufferThread", str + ": EGL error: 0x" + Integer.toHexString(eglGetError), new Object[0]);
            AppMethodBeat.o(76394);
            return true;
        }
        AppMethodBeat.o(76394);
        return false;
    }
}
