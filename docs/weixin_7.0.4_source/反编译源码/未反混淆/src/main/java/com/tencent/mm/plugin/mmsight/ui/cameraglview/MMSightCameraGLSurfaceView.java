package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class MMSightCameraGLSurfaceView extends GLSurfaceView {
    int fcf;
    private int gLF = 0;
    int gLw;
    int gLx;
    b oDF = null;

    class b implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION = 12440;

        b() {
        }

        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.i(55324);
            ab.w("MicroMsg.MMSightCameraGLSurfaceView", "creating OpenGL ES 2.0 context");
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
            AppMethodBeat.o(55324);
            return eglCreateContext;
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.i(55325);
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
            AppMethodBeat.o(55325);
        }
    }

    class a implements EGLConfigChooser {
        private int EGL_OPENGL_ES2_BIT = 4;
        private int[] eZf = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344};
        protected int mAlphaSize = 0;
        protected int mBlueSize = 5;
        protected int mDepthSize = 0;
        protected int mGreenSize = 6;
        protected int mRedSize = 5;
        protected int mStencilSize = 0;
        private int[] mValue = new int[1];

        public a() {
            AppMethodBeat.i(55319);
            AppMethodBeat.o(55319);
        }

        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            AppMethodBeat.i(55320);
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, this.eZf, null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No configs match configSpec");
                AppMethodBeat.o(55320);
                throw illegalArgumentException;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglChooseConfig(eGLDisplay, this.eZf, eGLConfigArr, i, iArr);
            b(egl10, eGLDisplay, eGLConfigArr);
            EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            AppMethodBeat.o(55320);
            return chooseConfig;
        }

        private EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.i(55321);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a >= this.mDepthSize && a2 >= this.mStencilSize) {
                    a = a(egl10, eGLDisplay, eGLConfig, 12324);
                    a2 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a == this.mRedSize && a2 == this.mGreenSize && a3 == this.mBlueSize && a4 == this.mAlphaSize) {
                        AppMethodBeat.o(55321);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.o(55321);
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            AppMethodBeat.i(55322);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue)) {
                int i2 = this.mValue[0];
                AppMethodBeat.o(55322);
                return i2;
            }
            AppMethodBeat.o(55322);
            return 0;
        }

        private static void b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.i(55323);
            ab.i("GLConfigChooser", String.format("%d configurations", new Object[]{Integer.valueOf(eGLConfigArr.length)}));
            for (EGLConfig eGLConfig : eGLConfigArr) {
                ab.i("GLConfigChooser", String.format("Configuration %d:\n", new Object[]{Integer.valueOf(r2)}));
                int[] iArr = new int[]{12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
                String[] strArr = new String[]{"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
                int[] iArr2 = new int[1];
                for (int i = 0; i < 33; i++) {
                    egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, iArr[i], iArr2);
                }
            }
            AppMethodBeat.o(55323);
        }
    }

    public MMSightCameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(55326);
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
        setEGLContextFactory(new b());
        setEGLConfigChooser(new a());
        this.oDF = new b();
        setRenderer(this.oDF);
        setRenderMode(0);
        AppMethodBeat.o(55326);
    }

    public final void ab(int i, int i2, int i3) {
        AppMethodBeat.i(55327);
        ab.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), this);
        this.gLw = i;
        this.gLx = i2;
        this.fcf = i3;
        AppMethodBeat.o(55327);
    }

    public int getFrameWidth() {
        return this.gLw;
    }

    public int getFrameHeight() {
        return this.gLx;
    }

    public int getFrameRotate() {
        return this.fcf;
    }

    public final void f(byte[] bArr, int i, boolean z) {
        AppMethodBeat.i(55328);
        if (bArr == null || this.oDF == null || this.oDF.gLv) {
            ab.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
            AppMethodBeat.o(55328);
            return;
        }
        this.oDF.b(bArr, this.gLw, this.gLx, i, z);
        requestRender();
        AppMethodBeat.o(55328);
    }

    public final void WB() {
        AppMethodBeat.i(55329);
        if (this.oDF != null) {
            this.oDF.gLA = true;
            requestRender();
        }
        AppMethodBeat.o(55329);
    }

    public b getRenderer() {
        return this.oDF;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(55330);
        super.surfaceCreated(surfaceHolder);
        ab.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", surfaceHolder, this, Integer.valueOf(getId()));
        AppMethodBeat.o(55330);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(55331);
        super.surfaceDestroyed(surfaceHolder);
        ab.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", surfaceHolder, this);
        AppMethodBeat.o(55331);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.i(55332);
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        ab.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), this);
        AppMethodBeat.o(55332);
    }
}
