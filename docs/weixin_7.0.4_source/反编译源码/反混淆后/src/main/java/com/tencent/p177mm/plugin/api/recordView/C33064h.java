package com.tencent.p177mm.plugin.api.recordView;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.api.recordView.C10045i.C10046a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.mm.plugin.api.recordView.h */
public final class C33064h {
    private final String TAG = "MicroMsg.YUVDateRenderToRBGBufferThread";
    boolean eCM = false;
    HandlerThread eXa = C7305d.anM("YUVDateRenderToRBGBufferThread");
    C7306ak eXb;
    int[] fab = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344};
    EGLSurface faf = null;
    EGLContext fag = null;
    int fcf;
    int gLw;
    int gLx;
    C10045i gMv;
    C10046a gMw = null;
    int gMx;
    int gMy;
    EGLDisplay gMz = null;

    /* renamed from: com.tencent.mm.plugin.api.recordView.h$2 */
    class C330622 implements Runnable {
        final /* synthetic */ int gMC;
        final /* synthetic */ byte[] val$data;

        C330622(byte[] bArr, int i) {
            this.val$data = bArr;
            this.gMC = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(76387);
            C10045i c10045i = C33064h.this.gMv;
            byte[] bArr = this.val$data;
            int i = C33064h.this.gLw;
            int i2 = C33064h.this.gLx;
            int i3 = C33064h.this.fcf;
            int i4 = this.gMC;
            try {
                int i5;
                if (c10045i.gLx == i2 && c10045i.gLw == i && c10045i.rotate == i3 && c10045i.gLD == i4) {
                    i5 = 0;
                } else {
                    i5 = 1;
                }
                if (i5 != 0) {
                    C4990ab.m7411d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(c10045i.fdb), Boolean.TRUE, c10045i);
                }
                c10045i.frameData = bArr;
                c10045i.gLw = i;
                c10045i.gLx = i2;
                c10045i.rotate = i3;
                c10045i.gLD = i4;
                if (i5 != 0) {
                    c10045i.eZU = ByteBuffer.allocateDirect(i2 * i);
                    c10045i.eZV = ByteBuffer.allocateDirect((i * i2) / 2);
                    c10045i.eZU.order(ByteOrder.nativeOrder());
                    c10045i.eZV.order(ByteOrder.nativeOrder());
                    if (c10045i.gLB != null) {
                        c10045i.eZi.put(c10045i.gLB);
                        c10045i.eZi.position(0);
                    }
                }
                if (!(c10045i.eZU == null || c10045i.eZV == null)) {
                    c10045i.eZU.put(bArr, 0, i * i2);
                    c10045i.eZU.position(0);
                    c10045i.eZV.put(bArr, i * i2, (i * i2) / 2);
                    c10045i.eZV.position(0);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame error: %s", e.getMessage());
            }
            C33064h.this.gMv.onDrawFrame(null);
            C33064h.this.gMw.asB();
            AppMethodBeat.m2505o(76387);
        }
    }

    /* renamed from: com.tencent.mm.plugin.api.recordView.h$3 */
    class C330633 implements Runnable {
        C330633() {
        }

        public final void run() {
            AppMethodBeat.m2504i(76388);
            C10045i c10045i = C33064h.this.gMv;
            if (c10045i.eZj != 0) {
                GLES20.glDeleteTextures(1, new int[]{c10045i.eZj}, 0);
            }
            if (c10045i.eZk != 0) {
                GLES20.glDeleteFramebuffers(1, new int[]{c10045i.eZk}, 0);
            }
            EGLDisplay eGLDisplay = C33064h.this.gMz;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            if (!(C33064h.this.faf == null || C33064h.this.fag == null || C33064h.this.gMz == null)) {
                EGL14.eglDestroySurface(C33064h.this.gMz, C33064h.this.faf);
                EGL14.eglDestroyContext(C33064h.this.gMz, C33064h.this.fag);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(C33064h.this.gMz);
                C33064h.this.fag = null;
                C33064h.this.gMz = null;
                C33064h.this.faf = null;
            }
            C33064h.this.eXb.removeCallbacksAndMessages(null);
            C33064h.this.eXa.quitSafely();
            AppMethodBeat.m2505o(76388);
        }
    }

    public C33064h() {
        AppMethodBeat.m2504i(76389);
        AppMethodBeat.m2505o(76389);
    }

    /* renamed from: a */
    public final void mo53630a(final EGLContext eGLContext) {
        AppMethodBeat.m2504i(76390);
        C4990ab.m7410d("MicroMsg.YUVDateRenderToRBGBufferThread", "start context : " + eGLContext + "  hasStart : " + this.eCM);
        if (this.eCM || eGLContext == null) {
            AppMethodBeat.m2505o(76390);
            return;
        }
        this.eCM = true;
        this.eXa.start();
        this.eXb = new C7306ak(this.eXa.getLooper());
        queue(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(76386);
                C33064h c33064h = C33064h.this;
                EGLContext eGLContext = eGLContext;
                int i = C33064h.this.gLw;
                int i2 = C33064h.this.gLx;
                c33064h.gMz = EGL14.eglGetDisplay(0);
                RuntimeException runtimeException;
                if (c33064h.gMz == EGL14.EGL_NO_DISPLAY) {
                    runtimeException = new RuntimeException("unable to get EGL14 display");
                    AppMethodBeat.m2505o(76386);
                    throw runtimeException;
                }
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(c33064h.gMz, iArr, 0, iArr, 1)) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    EGL14.eglChooseConfig(c33064h.gMz, c33064h.fab, 0, eGLConfigArr, 0, 1, new int[1], 0);
                    if (eGLConfigArr[0] == null) {
                        runtimeException = new RuntimeException("chooseConfig failed");
                        AppMethodBeat.m2505o(76386);
                        throw runtimeException;
                    }
                    c33064h.fag = EGL14.eglCreateContext(c33064h.gMz, eGLConfigArr[0], eGLContext, new int[]{12440, 2, 12344}, 0);
                    if (c33064h.fag == EGL14.EGL_NO_CONTEXT) {
                        runtimeException = new RuntimeException("EGL error " + EGL14.eglGetError());
                        AppMethodBeat.m2505o(76386);
                        throw runtimeException;
                    }
                    C33064h.m54047wH("eglCreateContext");
                    iArr = new int[]{12375, i, 12374, i2, 12344};
                    c33064h.faf = null;
                    try {
                        c33064h.faf = EGL14.eglCreatePbufferSurface(c33064h.gMz, eGLConfigArr[0], iArr, 0);
                    } catch (IllegalArgumentException e) {
                        C4990ab.m7413e("MicroMsg.YUVDateRenderToRBGBufferThread", "eglCreateWindowSurface", e);
                    }
                    C33064h.m54047wH("eglCreatePbufferSurface");
                    if ((c33064h.faf == null || c33064h.faf == EGL14.EGL_NO_SURFACE) && EGL14.eglGetError() == 12299) {
                        C4990ab.m7412e("MicroMsg.YUVDateRenderToRBGBufferThread", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    if (!EGL14.eglMakeCurrent(c33064h.gMz, c33064h.faf, c33064h.faf, c33064h.fag)) {
                        C4990ab.m7420w("MicroMsg.YUVDateRenderToRBGBufferThread", "eglMakeCurrent:" + EGL14.eglGetError());
                    }
                    C33064h c33064h2 = C33064h.this;
                    int i3 = C33064h.this.gLw;
                    int i4 = C33064h.this.gLx;
                    int i5 = C33064h.this.gMx;
                    int i6 = C33064h.this.gMy;
                    c33064h2.gMv = new C10045i(i3, i4, i5, i6);
                    c33064h2.gMv.onSurfaceCreated(null, null);
                    c33064h2.gMv.onSurfaceChanged(null, i5, i6);
                    if (c33064h2.gMw != null) {
                        c33064h2.gMv.buffer = c33064h2.gMw.getBuffer();
                    }
                    AppMethodBeat.m2505o(76386);
                    return;
                }
                c33064h.gMz = null;
                runtimeException = new RuntimeException("eglInitialize failed");
                AppMethodBeat.m2505o(76386);
                throw runtimeException;
            }
        });
        AppMethodBeat.m2505o(76390);
    }

    /* renamed from: h */
    public final void mo53631h(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(76391);
        C4990ab.m7417i("MicroMsg.YUVDateRenderToRBGBufferThread", "setFrameInfo, width: %s, height: %s, rotate: %s ,targetWidth:%d ,targetHeight:%d , this: %s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), this);
        if (!(i == this.gLw && i2 == this.gLx && i3 == this.fcf)) {
            this.gLw = i;
            this.gLx = i2;
            this.fcf = i3;
        }
        this.gMx = i4;
        this.gMy = i5;
        AppMethodBeat.m2505o(76391);
    }

    /* Access modifiers changed, original: final */
    public final void queue(Runnable runnable) {
        AppMethodBeat.m2504i(76392);
        if (this.eXa.isAlive()) {
            this.eXb.post(runnable);
        }
        AppMethodBeat.m2505o(76392);
    }

    public final void release() {
        AppMethodBeat.m2504i(76393);
        queue(new C330633());
        AppMethodBeat.m2505o(76393);
    }

    /* renamed from: wH */
    static boolean m54047wH(String str) {
        AppMethodBeat.m2504i(76394);
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            C4990ab.m7409c("MicroMsg.YUVDateRenderToRBGBufferThread", str + ": EGL error: 0x" + Integer.toHexString(eglGetError), new Object[0]);
            AppMethodBeat.m2505o(76394);
            return true;
        }
        AppMethodBeat.m2505o(76394);
        return false;
    }
}
