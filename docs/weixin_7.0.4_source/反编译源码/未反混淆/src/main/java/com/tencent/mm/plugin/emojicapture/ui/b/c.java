package com.tencent.mm.plugin.emojicapture.ui.b;

import a.f.b.j;
import a.l;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.gles.GlUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureGLUtil;", "", "()V", "Companion", "plugin-emojicapture_release"})
public final class c {
    public static final float[] eZY = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] eZZ = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] faa = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final a loN = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0007J\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJB\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ:\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0016\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\fJ\u0006\u0010$\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\fJ\u0016\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\fJ\u0016\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureGLUtil$Companion;", "", "()V", "CUBE_PROTRAIT", "", "TAG", "", "TEXTURE_COORD", "TEXTURE_COORD_VERTICAL_FLIP", "bindFrameBuffer", "", "fbo", "", "texture", "width", "height", "bindRenderBuffer", "buffer", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "redSize", "greenSize", "blueSize", "alphaSize", "withSample", "", "chooseConfigEGL14", "Landroid/opengl/EGLConfig;", "Landroid/opengl/EGLDisplay;", "clearGL", "genFrameBuffer", "genRenderBuffer", "genTexture", "genTextureExternal", "loadShader", "shaderSource", "type", "loadShaderProgram", "vertexShaderSource", "fragmentShaderSource", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static int Vh() {
            AppMethodBeat.i(3146);
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9728);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glBindTexture(3553, 0);
            int i = iArr[0];
            AppMethodBeat.o(3146);
            return i;
        }

        public static int bof() {
            AppMethodBeat.i(3147);
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, iArr[0]);
            GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9729);
            GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9728);
            GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
            GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
            GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
            int i = iArr[0];
            AppMethodBeat.o(3147);
            return i;
        }

        private static int M(String str, int i) {
            AppMethodBeat.i(3148);
            j.p(str, "shaderSource");
            int[] iArr = new int[1];
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                ab.e("MicroMsg.EmojiCaptureGLUtil", "loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(glCreateShader));
                AppMethodBeat.o(3148);
                return 0;
            }
            AppMethodBeat.o(3148);
            return glCreateShader;
        }

        public static int U(String str, String str2) {
            AppMethodBeat.i(3149);
            j.p(str, "vertexShaderSource");
            j.p(str2, "fragmentShaderSource");
            int[] iArr = new int[1];
            int M = M(str, 35633);
            if (M == 0) {
                ab.e("MicroMsg.EmojiCaptureGLUtil", "load vertex shader failed");
                AppMethodBeat.o(3149);
                return 0;
            }
            int M2 = M(str2, 35632);
            if (M2 == 0) {
                ab.e("MicroMsg.EmojiCaptureGLUtil", "load fragment shader failed");
                AppMethodBeat.o(3149);
                return 0;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            GLES20.glAttachShader(glCreateProgram, M);
            GLES20.glAttachShader(glCreateProgram, M2);
            GLES20.glLinkProgram(glCreateProgram);
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] <= 0) {
                ab.e("MicroMsg.EmojiCaptureGLUtil", "link program failed");
                AppMethodBeat.o(3149);
                return 0;
            }
            GLES20.glDeleteShader(M);
            GLES20.glDeleteShader(M2);
            AppMethodBeat.o(3149);
            return glCreateProgram;
        }

        public static int Vi() {
            AppMethodBeat.i(3150);
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            if (iArr[0] == 0) {
                ab.e("MicroMsg.EmojiCaptureGLUtil", "gen frame buffer error");
                AppMethodBeat.o(3150);
                return 0;
            }
            int i = iArr[0];
            AppMethodBeat.o(3150);
            return i;
        }

        public static void Vj() {
            AppMethodBeat.i(3151);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(19798);
            GLES20.glBindFramebuffer(36160, 0);
            AppMethodBeat.o(3151);
        }

        public static void y(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(3152);
            GLES20.glBindFramebuffer(36160, i);
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, i3, i4, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
            GLES20.glBindTexture(3553, 0);
            AppMethodBeat.o(3152);
        }
    }

    public static final void y(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(3154);
        a.y(i, i2, i3, i4);
        AppMethodBeat.o(3154);
    }

    static {
        AppMethodBeat.i(3153);
        AppMethodBeat.o(3153);
    }
}
