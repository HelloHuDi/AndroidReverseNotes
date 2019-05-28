package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(17)
public final class DummySurface extends Surface {
    private static boolean brT;
    private static boolean brU;
    public final boolean bdY;
    private final C8719a brV;
    private boolean brW;

    /* renamed from: com.google.android.exoplayer2.video.DummySurface$a */
    static class C8719a extends HandlerThread implements OnFrameAvailableListener, Callback {
        private final int[] brX = new int[1];
        private EGLDisplay brY;
        private EGLContext brZ;
        private EGLSurface bsa;
        private SurfaceTexture bsb;
        private Error bsc;
        private RuntimeException bsd;
        private DummySurface bse;
        Handler handler;

        public C8719a() {
            super("dummySurface");
            AppMethodBeat.m2504i(95988);
            AppMethodBeat.m2505o(95988);
        }

        /* renamed from: aM */
        public final DummySurface mo19301aM(boolean z) {
            Object obj = null;
            AppMethodBeat.m2504i(95989);
            start();
            this.handler = new Handler(getLooper(), this);
            synchronized (this) {
                try {
                    this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
                    while (this.bse == null && this.bsd == null && this.bsc == null) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            obj = 1;
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(95989);
                }
            }
            if (obj != null) {
                Thread.currentThread().interrupt();
            }
            if (this.bsd != null) {
                obj = this.bsd;
                throw obj;
            } else if (this.bsc != null) {
                Error error = this.bsc;
                AppMethodBeat.m2505o(95989);
                throw error;
            } else {
                DummySurface dummySurface = this.bse;
                AppMethodBeat.m2505o(95989);
                return dummySurface;
            }
        }

        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(95990);
            this.handler.sendEmptyMessage(2);
            AppMethodBeat.m2505o(95990);
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(95991);
            switch (message.what) {
                case 1:
                    try {
                        boolean z;
                        if (message.arg1 != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.brY = EGL14.eglGetDisplay(0);
                        C45039a.checkState(this.brY != null, "eglGetDisplay failed");
                        int[] iArr = new int[2];
                        C45039a.checkState(EGL14.eglInitialize(this.brY, iArr, 0, iArr, 1), "eglInitialize failed");
                        EGLConfig[] eGLConfigArr = new EGLConfig[1];
                        int[] iArr2 = new int[1];
                        boolean z2 = EGL14.eglChooseConfig(this.brY, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr[0] != null;
                        C45039a.checkState(z2, "eglChooseConfig failed");
                        EGLConfig eGLConfig = eGLConfigArr[0];
                        if (z) {
                            iArr = new int[]{12440, 2, 12992, 1, 12344};
                        } else {
                            iArr = new int[]{12440, 2, 12344};
                        }
                        this.brZ = EGL14.eglCreateContext(this.brY, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
                        if (this.brZ != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        C45039a.checkState(z2, "eglCreateContext failed");
                        if (z) {
                            iArr = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                        } else {
                            iArr = new int[5];
                            iArr = new int[]{12375, 1, 12374, 1, 12344};
                        }
                        this.bsa = EGL14.eglCreatePbufferSurface(this.brY, eGLConfig, iArr, 0);
                        if (this.bsa != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        C45039a.checkState(z2, "eglCreatePbufferSurface failed");
                        C45039a.checkState(EGL14.eglMakeCurrent(this.brY, this.bsa, this.bsa, this.brZ), "eglMakeCurrent failed");
                        GLES20.glGenTextures(1, this.brX, 0);
                        this.bsb = new SurfaceTexture(this.brX[0]);
                        this.bsb.setOnFrameAvailableListener(this);
                        this.bse = new DummySurface(this, this.bsb, z, (byte) 0);
                        synchronized (this) {
                            try {
                                notify();
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.m2505o(95991);
                                    break;
                                }
                            }
                        }
                    } catch (RuntimeException e) {
                        this.bsd = e;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Error e2) {
                        this.bsc = e2;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th2) {
                        AppMethodBeat.m2505o(95991);
                    }
                    AppMethodBeat.m2505o(95991);
                    break;
                case 2:
                    this.bsb.updateTexImage();
                    AppMethodBeat.m2505o(95991);
                    break;
                case 3:
                    try {
                        if (this.bsb != null) {
                            this.bsb.release();
                            GLES20.glDeleteTextures(1, this.brX, 0);
                        }
                        if (this.bsa != null) {
                            EGL14.eglDestroySurface(this.brY, this.bsa);
                        }
                        if (this.brZ != null) {
                            EGL14.eglDestroyContext(this.brY, this.brZ);
                        }
                        this.bsa = null;
                        this.brZ = null;
                        this.brY = null;
                        this.bse = null;
                        this.bsb = null;
                        quit();
                    } catch (Throwable th3) {
                        quit();
                        AppMethodBeat.m2505o(95991);
                    }
                    AppMethodBeat.m2505o(95991);
                    break;
                default:
                    AppMethodBeat.m2505o(95991);
                    break;
            }
            return true;
        }
    }

    /* synthetic */ DummySurface(C8719a c8719a, SurfaceTexture surfaceTexture, boolean z, byte b) {
        this(c8719a, surfaceTexture, z);
    }

    /* JADX WARNING: Missing block: B:13:0x002c, code skipped:
            if (r2 != false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aj */
    public static synchronized boolean m15485aj(Context context) {
        boolean z = true;
        synchronized (DummySurface.class) {
            AppMethodBeat.m2504i(95992);
            if (!brU) {
                if (C17675v.SDK_INT >= 24) {
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    boolean z2;
                    if (eglQueryString == null || !eglQueryString.contains("EGL_EXT_protected_content")) {
                        z2 = false;
                    } else if (C17675v.SDK_INT == 24 && "samsung".equals(C17675v.MANUFACTURER)) {
                        z2 = false;
                    } else if (C17675v.SDK_INT >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                z = false;
                brT = z;
                brU = true;
            }
            z = brT;
            AppMethodBeat.m2505o(95992);
        }
        return z;
    }

    private DummySurface(C8719a c8719a, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.brV = c8719a;
        this.bdY = z;
    }

    public final void release() {
        AppMethodBeat.m2504i(95994);
        super.release();
        synchronized (this.brV) {
            try {
                if (!this.brW) {
                    this.brV.handler.sendEmptyMessage(3);
                    this.brW = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(95994);
            }
        }
    }

    /* renamed from: h */
    public static DummySurface m15486h(Context context, boolean z) {
        AppMethodBeat.m2504i(95993);
        if (C17675v.SDK_INT < 17) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unsupported prior to API level 17");
            AppMethodBeat.m2505o(95993);
            throw unsupportedOperationException;
        }
        boolean z2 = !z || m15485aj(context);
        C45039a.checkState(z2);
        DummySurface aM = new C8719a().mo19301aM(z);
        AppMethodBeat.m2505o(95993);
        return aM;
    }
}
