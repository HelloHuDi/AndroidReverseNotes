package com.tencent.p177mm.plugin.api.recordView;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* renamed from: com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView */
class MMSightCameraGLSurfaceView extends GLSurfaceView {
    EGLContext fag;
    int fcf;
    C10042a gLE = null;
    private int gLF = 0;
    int gLw;
    int gLx;

    /* renamed from: com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView$b */
    class C26713b implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION = 12440;

        C26713b() {
        }

        public final javax.microedition.khronos.egl.EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.m2504i(76317);
            C4990ab.m7420w("MicroMsg.MMSightCameraGLSurfaceView", "creating OpenGL ES 2.0 context");
            javax.microedition.khronos.egl.EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
            AppMethodBeat.m2505o(76317);
            return eglCreateContext;
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext) {
            AppMethodBeat.m2504i(76318);
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
            AppMethodBeat.m2505o(76318);
        }
    }

    /* renamed from: com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView$a */
    class C26714a implements EGLConfigChooser {
        private int EGL_OPENGL_ES2_BIT = 4;
        private int[] eZf = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344};
        protected int mAlphaSize = 0;
        protected int mBlueSize = 5;
        protected int mDepthSize = 0;
        protected int mGreenSize = 6;
        protected int mRedSize = 5;
        protected int mStencilSize = 0;
        private int[] mValue = new int[1];

        public C26714a() {
            AppMethodBeat.m2504i(76312);
            AppMethodBeat.m2505o(76312);
        }

        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            AppMethodBeat.m2504i(76313);
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, this.eZf, null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No configs match configSpec");
                AppMethodBeat.m2505o(76313);
                throw illegalArgumentException;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglChooseConfig(eGLDisplay, this.eZf, eGLConfigArr, i, iArr);
            C26714a.m42545b(egl10, eGLDisplay, eGLConfigArr);
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            AppMethodBeat.m2505o(76313);
            return chooseConfig;
        }

        private EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.m2504i(76314);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = m42544a(egl10, eGLDisplay, eGLConfig, 12325);
                int a2 = m42544a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a >= this.mDepthSize && a2 >= this.mStencilSize) {
                    a = m42544a(egl10, eGLDisplay, eGLConfig, 12324);
                    a2 = m42544a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a3 = m42544a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a4 = m42544a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a == this.mRedSize && a2 == this.mGreenSize && a3 == this.mBlueSize && a4 == this.mAlphaSize) {
                        AppMethodBeat.m2505o(76314);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.m2505o(76314);
            return null;
        }

        /* renamed from: a */
        private int m42544a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            AppMethodBeat.m2504i(76315);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue)) {
                int i2 = this.mValue[0];
                AppMethodBeat.m2505o(76315);
                return i2;
            }
            AppMethodBeat.m2505o(76315);
            return 0;
        }

        /* renamed from: b */
        private static void m42545b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.m2504i(76316);
            C4990ab.m7416i("GLConfigChooser", String.format("%d configurations", new Object[]{Integer.valueOf(eGLConfigArr.length)}));
            for (EGLConfig eGLConfig : eGLConfigArr) {
                C4990ab.m7416i("GLConfigChooser", String.format("Configuration %d:\n", new Object[]{Integer.valueOf(r2)}));
                int[] iArr = new int[]{12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
                String[] strArr = new String[]{"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
                int[] iArr2 = new int[1];
                for (int i = 0; i < 33; i++) {
                    egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, iArr[i], iArr2);
                }
            }
            AppMethodBeat.m2505o(76316);
        }
    }

    public MMSightCameraGLSurfaceView(Context context) {
        super(context);
        AppMethodBeat.m2504i(76319);
        init();
        AppMethodBeat.m2505o(76319);
    }

    public MMSightCameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(76320);
        init();
        AppMethodBeat.m2505o(76320);
    }

    private void init() {
        AppMethodBeat.m2504i(76321);
        getHolder().addCallback(this);
        try {
            getHolder().setType(2);
        } catch (Exception e) {
            try {
                getHolder().setType(1);
            } catch (Exception e2) {
                try {
                    getHolder().setType(0);
                } catch (Exception e3) {
                }
            }
        }
        setEGLContextFactory(new C26713b());
        setEGLConfigChooser(new C26714a());
        this.gLE = new C10042a();
        setRenderer(this.gLE);
        setRenderMode(0);
        AppMethodBeat.m2505o(76321);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(76322);
        super.surfaceCreated(surfaceHolder);
        C4990ab.m7417i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", surfaceHolder, this, Integer.valueOf(getId()));
        this.fag = EGL14.eglGetCurrentContext();
        AppMethodBeat.m2505o(76322);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(76323);
        super.surfaceDestroyed(surfaceHolder);
        C4990ab.m7417i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", surfaceHolder, this);
        AppMethodBeat.m2505o(76323);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.m2504i(76324);
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        C4990ab.m7417i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), this);
        AppMethodBeat.m2505o(76324);
    }
}
