package com.tencent.ttpic.gles;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.ETC1Util;
import android.opengl.ETC1Util.ETC1Texture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import org.xwalk.core.XWalkCoreWrapper;

public class GlUtil {
    public static final float[] EMPTY_POSITIONS = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    public static final float[] EMPTY_POSITIONS_TRIANGLES = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
    public static final float[] IDENTITY_MATRIX;
    public static final int NO_TEXTURE = -1;
    public static final float[] ORIGIN_POSITION_COORDS = new float[]{-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f};
    public static final float[] ORIGIN_TEX_COORDS = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    public static final float[] ORIGIN_TEX_COORDS_REVERSE = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] ORIGIN_TEX_COORDS_TRIANGLES = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private static final int SIZEOF_FLOAT = 4;
    public static final String TAG = GlUtil.class.getSimpleName();
    public static boolean curBlendModeEnabled;

    public enum DRAW_MODE {
        TRIANGLE_STRIP,
        TRIANGLES,
        TRIANGLE_FAN,
        LINES,
        POINTS;

        static {
            AppMethodBeat.m2505o(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
        }
    }

    static {
        AppMethodBeat.m2504i(50018);
        float[] fArr = new float[16];
        IDENTITY_MATRIX = fArr;
        Matrix.setIdentityM(fArr, 0);
        AppMethodBeat.m2505o(50018);
    }

    private GlUtil() {
    }

    public static FloatBuffer createSquareVtx() {
        AppMethodBeat.m2504i(XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_IDKEY);
        float[] fArr = new float[]{-1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f};
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(80);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_IDKEY);
        return asFloatBuffer;
    }

    public static int createProgram(String str, String str2) {
        int i = 0;
        AppMethodBeat.m2504i(XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_KVSTAT);
        int loadShader = loadShader(35633, str);
        if (loadShader == 0) {
            AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_KVSTAT);
        } else {
            int loadShader2 = loadShader(35632, str2);
            if (loadShader2 == 0) {
                AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_KVSTAT);
            } else {
                int glCreateProgram = GLES20.glCreateProgram();
                checkGlError("glCreateProgram");
                GLES20.glAttachShader(glCreateProgram, loadShader);
                checkGlError("glAttachShader");
                GLES20.glAttachShader(glCreateProgram, loadShader2);
                checkGlError("glAttachShader");
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    GLES20.glGetProgramInfoLog(glCreateProgram);
                    GLES20.glDeleteProgram(glCreateProgram);
                } else {
                    i = glCreateProgram;
                }
                AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_KVSTAT);
            }
        }
        return i;
    }

    private static int loadShader(int i, String str) {
        int i2 = 0;
        AppMethodBeat.m2504i(50003);
        int glCreateShader = GLES20.glCreateShader(i);
        checkGlError("glCreateShader type=".concat(String.valueOf(i)));
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            new StringBuilder("Could not compile shader ").append(i).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            new StringBuilder(" ").append(GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
        } else {
            i2 = glCreateShader;
        }
        AppMethodBeat.m2505o(50003);
        return i2;
    }

    public static void checkGlError(String str) {
        AppMethodBeat.m2504i(50004);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            new StringBuilder().append(str).append(": glError 0x").append(Integer.toHexString(glGetError));
        }
        AppMethodBeat.m2505o(50004);
    }

    @TargetApi(18)
    public static void checkEglError(String str) {
        AppMethodBeat.m2504i(50005);
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError != 12288) {
                new StringBuilder().append(str).append(": eglGetError: 0x").append(Integer.toHexString(eglGetError));
            } else {
                AppMethodBeat.m2505o(50005);
                return;
            }
        }
    }

    public static void checkLocation(int i, String str) {
        AppMethodBeat.m2504i(50006);
        if (i < 0) {
            RuntimeException runtimeException = new RuntimeException("Unable to locate '" + str + "' in program");
            AppMethodBeat.m2505o(50006);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(50006);
    }

    public static int createImageTexture(ByteBuffer byteBuffer, int i, int i2, int i3) {
        AppMethodBeat.m2504i(50007);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i4 = iArr[0];
        checkGlError("glGenTextures");
        GLES20.glBindTexture(3553, i4);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        checkGlError("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, GLType.GL_UNSIGNED_BYTE, byteBuffer);
        checkGlError("loadImageTexture");
        AppMethodBeat.m2505o(50007);
        return i4;
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        AppMethodBeat.m2504i(50008);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        AppMethodBeat.m2505o(50008);
        return asFloatBuffer;
    }

    public static void logVersionInfo() {
        AppMethodBeat.m2504i(50009);
        new StringBuilder("vendor  : ").append(GLES20.glGetString(7936));
        new StringBuilder("renderer: ").append(GLES20.glGetString(7937));
        new StringBuilder("version : ").append(GLES20.glGetString(7938));
        AppMethodBeat.m2505o(50009);
    }

    public static void loadTexture(int i, ETC1Texture eTC1Texture) {
        AppMethodBeat.m2504i(50010);
        if (eTC1Texture != null) {
            GLES20.glBindTexture(3553, i);
            ETC1Util.loadTexture(3553, 0, 0, GLFormat.GL_RGB, GLType.GL_UNSIGNED_SHORT_5_6_5, eTC1Texture);
        }
        AppMethodBeat.m2505o(50010);
    }

    public static void loadTexture(int i, Bitmap bitmap) {
        AppMethodBeat.m2504i(50011);
        if (BitmapUtils.isLegal(bitmap)) {
            GLES20.glBindTexture(3553, i);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        }
        AppMethodBeat.m2505o(50011);
    }

    public static void loadTexture(int i, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(50012);
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        checkGlError("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, i4, i2, i3, 0, i4, GLType.GL_UNSIGNED_BYTE, byteBuffer);
        checkGlError("loadImageTexture");
        AppMethodBeat.m2505o(50012);
    }

    public static void saveTextureToRgbaBuffer(int i, int i2, int i3, byte[] bArr, int i4) {
        AppMethodBeat.m2504i(50013);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(50013);
            return;
        }
        GLES20.glBindFramebuffer(36160, i4);
        checkGlError("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        checkGlError("glFramebufferTexture2D");
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        GLES20.glPixelStorei(3333, 1);
        GLES20.glReadPixels(0, 0, i2, i3, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, wrap);
        GLES20.glBindFramebuffer(36160, 0);
        checkGlError("glBindFramebuffer");
        AppMethodBeat.m2505o(50013);
    }

    public static void saveTextureToRgbaBuffer(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6) {
        AppMethodBeat.m2504i(50014);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(50014);
            return;
        }
        GLES20.glBindFramebuffer(36160, i6);
        checkGlError("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        checkGlError("glFramebufferTexture2D");
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        GLES20.glPixelStorei(3333, 1);
        GLES20.glReadPixels(i2, i3, i4, i5, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, wrap);
        GLES20.glBindFramebuffer(36160, 0);
        checkGlError("glBindFramebuffer");
        AppMethodBeat.m2505o(50014);
    }

    public static void reBind(C41672h c41672h, int i, int i2, int i3) {
        AppMethodBeat.m2504i(50015);
        if (c41672h == null) {
            AppMethodBeat.m2505o(50015);
            return;
        }
        c41672h.width = i2;
        c41672h.height = i3;
        GLES20.glBindFramebuffer(36160, c41672h.bJz[0]);
        checkGlError("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        checkGlError("glFramebufferTexture2D");
        AppMethodBeat.m2505o(50015);
    }

    public static void createEtcTexture(int[] iArr) {
        int i = 0;
        AppMethodBeat.m2504i(50016);
        GLES20.glGenTextures(iArr.length, iArr, 0);
        while (i < iArr.length) {
            GLES20.glBindTexture(3553, iArr[i]);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            i++;
        }
        AppMethodBeat.m2505o(50016);
    }

    public static void setBlendMode(boolean z) {
        AppMethodBeat.m2504i(50017);
        curBlendModeEnabled = z;
        if (z) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            AppMethodBeat.m2505o(50017);
            return;
        }
        GLES20.glDisable(3042);
        AppMethodBeat.m2505o(50017);
    }
}
