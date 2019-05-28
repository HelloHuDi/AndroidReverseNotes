package com.tencent.p177mm.media.p255h.p1204a;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C8001y;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J-\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0&¢\u0006\u0002\u0010'J0\u0010(\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0002J \u0010,\u001a\u00020-2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020 H\u0002J-\u0010.\u001a\u00020-2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0&H\u0002¢\u0006\u0002\u0010/R\u000e\u0010\n\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fXD¢\u0006\u0004\n\u0002\b\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, dWq = {"Lcom/tencent/mm/media/render/config/RenderConfigChooser;", "Landroid/opengl/GLSurfaceView$EGLConfigChooser;", "mRedSize", "", "mGreenSize", "mBlueSize", "mAlphaSize", "mDepthSize", "mStencilSize", "(IIIIII)V", "EGL_OPENGL_ES2_BIT", "TAG", "", "TAG$1", "getMAlphaSize", "()I", "setMAlphaSize", "(I)V", "getMBlueSize", "setMBlueSize", "getMDepthSize", "setMDepthSize", "getMGreenSize", "setMGreenSize", "getMRedSize", "setMRedSize", "getMStencilSize", "setMStencilSize", "mValue", "", "s_configAttribs2", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "display", "Ljavax/microedition/khronos/egl/EGLDisplay;", "configs", "", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)Ljavax/microedition/khronos/egl/EGLConfig;", "findConfigAttrib", "config", "attribute", "defaultValue", "printConfig", "", "printConfigs", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)V", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.h.a.a */
public final class C32759a implements EGLConfigChooser {
    private static final String TAG = TAG;
    public static final C32760a eZg = new C32760a();
    private final int EGL_OPENGL_ES2_BIT = 4;
    private final String eZe = "MicroMsg.RenderConfigChooser";
    private final int[] eZf = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344};
    private int mAlphaSize = 0;
    private int mBlueSize = 5;
    private int mDepthSize = 0;
    private int mGreenSize = 6;
    private int mRedSize = 5;
    private int mStencilSize = 0;
    private final int[] mValue = new int[1];

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/render/config/RenderConfigChooser$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.h.a.a$a */
    public static final class C32760a {
        private C32760a() {
        }

        public /* synthetic */ C32760a(byte b) {
            this();
        }
    }

    public C32759a() {
        AppMethodBeat.m2504i(13096);
        AppMethodBeat.m2505o(13096);
    }

    public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        AppMethodBeat.m2504i(13092);
        C25052j.m39376p(egl10, "egl");
        C25052j.m39376p(eGLDisplay, ServerProtocol.DIALOG_PARAM_DISPLAY);
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eGLDisplay, this.eZf, null, 0, iArr);
        int i = iArr[0];
        if (i <= 0) {
            Throwable illegalArgumentException = new IllegalArgumentException("No configs match configSpec");
            AppMethodBeat.m2505o(13092);
            throw illegalArgumentException;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        egl10.eglChooseConfig(eGLDisplay, this.eZf, eGLConfigArr, i, iArr);
        m53491b(egl10, eGLDisplay, eGLConfigArr);
        EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
        AppMethodBeat.m2505o(13092);
        return chooseConfig;
    }

    private EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        AppMethodBeat.m2504i(13093);
        C25052j.m39376p(egl10, "egl");
        C25052j.m39376p(eGLDisplay, ServerProtocol.DIALOG_PARAM_DISPLAY);
        C25052j.m39376p(eGLConfigArr, "configs");
        for (EGLConfig eGLConfig : eGLConfigArr) {
            if (eGLConfig == null) {
                C25052j.dWJ();
            }
            int a = m53490a(egl10, eGLDisplay, eGLConfig, 12325);
            int a2 = m53490a(egl10, eGLDisplay, eGLConfig, 12326);
            if (a >= this.mDepthSize && a2 >= this.mStencilSize) {
                a = m53490a(egl10, eGLDisplay, eGLConfig, 12324);
                a2 = m53490a(egl10, eGLDisplay, eGLConfig, 12323);
                int a3 = m53490a(egl10, eGLDisplay, eGLConfig, 12322);
                int a4 = m53490a(egl10, eGLDisplay, eGLConfig, 12321);
                if (a == this.mRedSize && a2 == this.mGreenSize && a3 == this.mBlueSize && a4 == this.mAlphaSize) {
                    AppMethodBeat.m2505o(13093);
                    return eGLConfig;
                }
            }
        }
        AppMethodBeat.m2505o(13093);
        return null;
    }

    /* renamed from: a */
    private final int m53490a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
        AppMethodBeat.m2504i(13094);
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue)) {
            int i2 = this.mValue[0];
            AppMethodBeat.m2505o(13094);
            return i2;
        }
        AppMethodBeat.m2505o(13094);
        return 0;
    }

    /* renamed from: b */
    private final void m53491b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        AppMethodBeat.m2504i(13095);
        String str = this.eZe;
        C8001y c8001y = C8001y.AVH;
        String format = String.format("%d configurations", Arrays.copyOf(new Object[]{Integer.valueOf(r3)}, 1));
        C25052j.m39375o(format, "java.lang.String.format(format, *args)");
        C4990ab.m7416i(str, format);
        for (EGLConfig eGLConfig : eGLConfigArr) {
            format = this.eZe;
            C8001y c8001y2 = C8001y.AVH;
            String format2 = String.format("Configuration %d:\n", Arrays.copyOf(new Object[]{Integer.valueOf(r0)}, 1));
            C25052j.m39375o(format2, "java.lang.String.format(format, *args)");
            C4990ab.m7416i(format, format2);
            if (eGLConfig == null) {
                C25052j.dWJ();
            }
            int[] iArr = new int[]{12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
            String[] strArr = new String[]{"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
            int[] iArr2 = new int[1];
            for (int i = 0; i < 33; i++) {
                egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, iArr[i], iArr2);
            }
        }
        AppMethodBeat.m2505o(13095);
    }

    static {
        AppMethodBeat.m2504i(13097);
        AppMethodBeat.m2505o(13097);
    }
}
