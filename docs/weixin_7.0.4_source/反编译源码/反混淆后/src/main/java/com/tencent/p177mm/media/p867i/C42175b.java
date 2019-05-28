package com.tencent.p177mm.media.p867i;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/util/GLEnvironmentUtil;", "", "()V", "Companion", "EGLEnvironment", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.i.b */
public final class C42175b {
    public static final float[] eZY = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] eZZ = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] faa = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final int[] fab = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344};
    private static final int[] fac = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12338, 1, 12337, 4, 12352, 4, 12610, 1, 12344};
    public static final C26386a fad = new C26386a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "", "disPlay", "Landroid/opengl/EGLDisplay;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglContext", "Landroid/opengl/EGLContext;", "(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)V", "getDisPlay", "()Landroid/opengl/EGLDisplay;", "setDisPlay", "(Landroid/opengl/EGLDisplay;)V", "getEglContext", "()Landroid/opengl/EGLContext;", "setEglContext", "(Landroid/opengl/EGLContext;)V", "getEglSurface", "()Landroid/opengl/EGLSurface;", "setEglSurface", "(Landroid/opengl/EGLSurface;)V", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.i.b$b */
    public static final class C9609b {
        public EGLDisplay fae;
        public EGLSurface faf;
        public EGLContext fag;

        public C9609b(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLContext eGLContext) {
            C25052j.m39376p(eGLDisplay, "disPlay");
            C25052j.m39376p(eGLSurface, "eglSurface");
            C25052j.m39376p(eGLContext, "eglContext");
            AppMethodBeat.m2504i(13125);
            this.fae = eGLDisplay;
            this.faf = eGLSurface;
            this.fag = eGLContext;
            AppMethodBeat.m2505o(13125);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0006J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J\u001e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\bH\u0002JB\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u001cJ:\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010$\u001a\u00020-2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u001cJ\u0006\u0010.\u001a\u00020\u0016J\u0016\u0010/\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u00100\u001a\u000201J$\u00102\u001a\u00020\u000f2\b\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0006J\u0006\u00105\u001a\u00020\u0006J\u0006\u00106\u001a\u00020\u0006J\u0006\u00107\u001a\u00020\u0006J\u0006\u00108\u001a\u00020\u0006J\u0016\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u0006J\u0016\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\bJ \u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020-2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u000e\u0010?\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\u000fJ\u001a\u0010D\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010-2\b\u0010@\u001a\u0004\u0018\u00010AR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, dWq = {"Lcom/tencent/mm/media/util/GLEnvironmentUtil$Companion;", "", "()V", "CUBE_PROTRAIT", "", "EGL_RECORDABLE_ANDROID", "", "TAG", "", "TEXTURE_COORD", "TEXTURE_COORD_VERTICAL_FLIP", "commonEGLAttributeList", "", "commonEGLAttributeListWithMSAA", "bindContextAndSurface", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglContext", "Landroid/opengl/EGLContext;", "surface", "width", "height", "bindFrameBuffer", "", "fbo", "texture", "bindRenderBuffer", "buffer", "checkEglError", "", "msg", "tag", "checkGLError", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "redSize", "greenSize", "blueSize", "alphaSize", "withSample", "chooseConfigEGL14", "Landroid/opengl/EGLConfig;", "Landroid/opengl/EGLDisplay;", "clearGL", "drawBitmapToTexture", "bitmap", "Landroid/graphics/Bitmap;", "eglSetupBySurface", "mSurface", "Landroid/view/Surface;", "genFrameBuffer", "genRenderBuffer", "genTexture", "genTextureExternal", "loadShader", "shaderSource", "type", "loadShaderProgram", "vertexShaderSource", "fragmentShaderSource", "release", "eglSurface", "Landroid/opengl/EGLSurface;", "eglDisplay", "eglEnvironment", "swapBuffers", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.i.b$a */
    public static final class C26386a {
        private C26386a() {
        }

        public /* synthetic */ C26386a(byte b) {
            this();
        }

        /* renamed from: Vh */
        public static int m41982Vh() {
            AppMethodBeat.m2504i(13114);
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9728);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glBindTexture(3553, 0);
            C26386a.m41989ma("genTexture");
            int i = iArr[0];
            AppMethodBeat.m2505o(13114);
            return i;
        }

        /* renamed from: M */
        private static int m41979M(String str, int i) {
            AppMethodBeat.m2504i(13115);
            C25052j.m39376p(str, "shaderSource");
            int[] iArr = new int[1];
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                C4990ab.m7413e("MicroMsg.GLEnvironmentUtil", "loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(glCreateShader));
                AppMethodBeat.m2505o(13115);
                return 0;
            }
            AppMethodBeat.m2505o(13115);
            return glCreateShader;
        }

        /* renamed from: U */
        public static int m41980U(String str, String str2) {
            AppMethodBeat.m2504i(13116);
            C25052j.m39376p(str, "vertexShaderSource");
            C25052j.m39376p(str2, "fragmentShaderSource");
            int[] iArr = new int[1];
            int M = C26386a.m41979M(str, 35633);
            if (M == 0) {
                C4990ab.m7412e("MicroMsg.GLEnvironmentUtil", "load vertex shader failed");
                AppMethodBeat.m2505o(13116);
                return 0;
            }
            int M2 = C26386a.m41979M(str2, 35632);
            if (M2 == 0) {
                C4990ab.m7412e("MicroMsg.GLEnvironmentUtil", "load fragment shader failed");
                AppMethodBeat.m2505o(13116);
                return 0;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            GLES20.glAttachShader(glCreateProgram, M);
            GLES20.glAttachShader(glCreateProgram, M2);
            GLES20.glLinkProgram(glCreateProgram);
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] <= 0) {
                C4990ab.m7412e("MicroMsg.GLEnvironmentUtil", "link program failed");
                AppMethodBeat.m2505o(13116);
                return 0;
            }
            GLES20.glDeleteShader(M);
            GLES20.glDeleteShader(M2);
            AppMethodBeat.m2505o(13116);
            return glCreateProgram;
        }

        /* renamed from: Vi */
        public static int m41983Vi() {
            AppMethodBeat.m2504i(13117);
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            if (iArr[0] == 0) {
                C4990ab.m7412e("MicroMsg.GLEnvironmentUtil", "gen frame buffer error");
                AppMethodBeat.m2505o(13117);
                return 0;
            }
            int i = iArr[0];
            AppMethodBeat.m2505o(13117);
            return i;
        }

        /* renamed from: Vj */
        public static void m41984Vj() {
            AppMethodBeat.m2504i(13118);
            GLES20.glClear(19798);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glBindFramebuffer(36160, 0);
            AppMethodBeat.m2505o(13118);
        }

        /* renamed from: b */
        public static C9609b m41987b(Surface surface, int i, int i2) {
            AppMethodBeat.m2504i(13119);
            C4990ab.m7416i("MicroMsg.GLEnvironmentUtil", "eglSetupBySurface");
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            Throwable runtimeException;
            if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                runtimeException = new RuntimeException("unable to get EGL14 display");
                AppMethodBeat.m2505o(13119);
                throw runtimeException;
            }
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                EGLSurface eglCreateWindowSurface;
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                EGL14.eglChooseConfig(eglGetDisplay, C42175b.fab, 0, eGLConfigArr, 0, 1, new int[1], 0);
                C26386a.m41988lZ("eglCreateContext RGB888+recordable ES2");
                EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                C26386a.m41988lZ("eglCreateContext");
                iArr = (i <= 0 || i2 <= 0) ? new int[]{12344} : new int[]{12375, i, 12374, i2, 12344};
                if (surface != null) {
                    eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eglGetDisplay, eGLConfigArr[0], surface, iArr, 0);
                } else {
                    eglCreateWindowSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfigArr[0], iArr, 0);
                }
                if (surface != null) {
                    C26386a.m41988lZ("eglCreateWindowSurface");
                } else {
                    C26386a.m41988lZ("eglCreatePbufferSurface");
                }
                EGL14.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                C26386a.m41988lZ("eglMakeCurrent");
                C25052j.m39375o(eglGetDisplay, "mEGLDisplay");
                C25052j.m39375o(eglCreateWindowSurface, "mEGLSurface");
                C25052j.m39375o(eglCreateContext, "mEGLContext");
                C9609b c9609b = new C9609b(eglGetDisplay, eglCreateWindowSurface, eglCreateContext);
                AppMethodBeat.m2505o(13119);
                return c9609b;
            }
            runtimeException = new RuntimeException("unable to initialize EGL14");
            AppMethodBeat.m2505o(13119);
            throw runtimeException;
        }

        /* renamed from: a */
        public static boolean m41986a(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.m2504i(13120);
            if (eGLDisplay == null || eGLSurface == null) {
                AppMethodBeat.m2505o(13120);
                return false;
            }
            boolean eglSwapBuffers = EGL14.eglSwapBuffers(eGLDisplay, eGLSurface);
            C26386a.m41988lZ("eglSwapBuffers");
            AppMethodBeat.m2505o(13120);
            return eglSwapBuffers;
        }

        /* renamed from: lZ */
        public static /* synthetic */ boolean m41988lZ(String str) {
            AppMethodBeat.m2504i(13122);
            boolean V = C26386a.m41981V(str, "MicroMsg.GLEnvironmentUtil");
            AppMethodBeat.m2505o(13122);
            return V;
        }

        /* renamed from: V */
        private static boolean m41981V(String str, String str2) {
            AppMethodBeat.m2504i(13121);
            C25052j.m39376p(str, "msg");
            C25052j.m39376p(str2, "tag");
            int eglGetError = EGL14.eglGetError();
            if (eglGetError != 12288) {
                C4990ab.m7409c(str2, str + ": EGL error: 0x" + Integer.toHexString(eglGetError), new Object[0]);
                AppMethodBeat.m2505o(13121);
                return true;
            }
            AppMethodBeat.m2505o(13121);
            return false;
        }

        /* renamed from: ma */
        public static void m41989ma(String str) {
            AppMethodBeat.m2504i(13123);
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                C4990ab.m7409c("MicroMsg.GLEnvironmentUtil", str + ": GL error: 0x" + Integer.toHexString(glGetError), new Object[0]);
            }
            AppMethodBeat.m2505o(13123);
        }

        /* renamed from: a */
        public static C9609b m41985a(EGLContext eGLContext, Object obj, int i, int i2) {
            AppMethodBeat.m2504i(13124);
            C25052j.m39376p(eGLContext, "eglContext");
            C4990ab.m7416i("MicroMsg.GLEnvironmentUtil", "bindContextAndSurface");
            Throwable runtimeException;
            if (obj == null || (obj instanceof Surface) || (obj instanceof SurfaceHolder)) {
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                    runtimeException = new RuntimeException("unable to get EGL14 display");
                    AppMethodBeat.m2505o(13124);
                    throw runtimeException;
                }
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    EGL14.eglChooseConfig(eglGetDisplay, C42175b.fab, 0, eGLConfigArr, 0, 1, new int[1], 0);
                    if (eGLConfigArr[0] == null) {
                        runtimeException = new RuntimeException("chooseConfig failed");
                        AppMethodBeat.m2505o(13124);
                        throw runtimeException;
                    }
                    EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfigArr[0], eGLContext, new int[]{12440, 2, 12344}, 0);
                    if (C25052j.m39373j(eglCreateContext, EGL14.EGL_NO_CONTEXT)) {
                        runtimeException = new RuntimeException("EGL error " + EGL14.eglGetError());
                        AppMethodBeat.m2505o(13124);
                        throw runtimeException;
                    }
                    EGLSurface eglCreateWindowSurface;
                    C26386a.m41988lZ("eglCreateContext");
                    iArr = (i <= 0 || i2 <= 0) ? new int[]{12344} : new int[]{12375, i, 12374, i2, 12344};
                    if (obj != null) {
                        try {
                            eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eglGetDisplay, eGLConfigArr[0], obj, iArr, 0);
                        } catch (IllegalArgumentException e) {
                            C4990ab.m7413e("MicroMsg.GLEnvironmentUtil", "eglCreateWindowSurface", e);
                            eglCreateWindowSurface = null;
                        }
                    } else {
                        eglCreateWindowSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfigArr[0], iArr, 0);
                    }
                    if (obj != null) {
                        C26386a.m41988lZ("eglCreateWindowSurface");
                    } else {
                        C26386a.m41988lZ("eglCreatePbufferSurface");
                    }
                    if ((eglCreateWindowSurface == null || eglCreateWindowSurface == EGL14.EGL_NO_SURFACE) && EGL14.eglGetError() == 12299) {
                        C4990ab.m7412e("MicroMsg.GLEnvironmentUtil", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    if (!EGL14.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext)) {
                        C4990ab.m7420w("MicroMsg.GLEnvironmentUtil", "eglMakeCurrent:" + EGL14.eglGetError());
                    }
                    C25052j.m39375o(eglGetDisplay, "eglDisplay");
                    if (eglCreateWindowSurface == null) {
                        C25052j.dWJ();
                    }
                    C25052j.m39375o(eglCreateContext, "outputEGLContext");
                    C9609b c9609b = new C9609b(eglGetDisplay, eglCreateWindowSurface, eglCreateContext);
                    AppMethodBeat.m2505o(13124);
                    return c9609b;
                }
                runtimeException = new RuntimeException("eglInitialize failed");
                AppMethodBeat.m2505o(13124);
                throw runtimeException;
            }
            runtimeException = new IllegalArgumentException("unsupported surface");
            AppMethodBeat.m2505o(13124);
            throw runtimeException;
        }
    }

    static {
        AppMethodBeat.m2504i(13126);
        AppMethodBeat.m2505o(13126);
    }
}
