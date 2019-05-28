package com.tencent.ttpic.gles;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLES31;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class ProgramTools {
    public static final int PER_FLOAT_BYTE = 4;
    private static final String TAG = ProgramTools.class.getSimpleName();

    static {
        AppMethodBeat.m2504i(50028);
        AppMethodBeat.m2505o(50028);
    }

    private static String readTextFile(Context context, int i) {
        AppMethodBeat.m2504i(50021);
        InputStream openRawResource = context.getResources().openRawResource(i);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine);
                    stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                    }
                }
            } catch (Exception e2) {
                try {
                    openRawResource.close();
                    bufferedReader.close();
                } catch (IOException e3) {
                }
                AppMethodBeat.m2505o(50021);
                return null;
            } catch (Throwable th) {
                try {
                    openRawResource.close();
                    bufferedReader.close();
                } catch (IOException e4) {
                }
                AppMethodBeat.m2505o(50021);
            }
        }
        openRawResource.close();
        bufferedReader.close();
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(50021);
        return stringBuilder2;
    }

    public static int createProgram(String str, String str2) {
        AppMethodBeat.m2504i(50022);
        int glCreateShader = GLES20.glCreateShader(35633);
        int glCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glShaderSource(glCreateShader2, str2);
        int[] iArr = new int[1];
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        int length;
        if (iArr[0] == 0) {
            String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
            GLES20.glDeleteShader(glCreateShader);
            if (GLConfig.DEBUG) {
                if (str.length() >= 100) {
                    length = str.length() - 100;
                } else {
                    length = 0;
                }
                LogUtils.m50202e(TAG, "vertex shader compile,failed:" + str.substring(length));
                LogUtils.m50202e(TAG, glGetShaderInfoLog);
            }
            AppMethodBeat.m2505o(50022);
            return 0;
        }
        GLES20.glCompileShader(glCreateShader2);
        GLES20.glGetShaderiv(glCreateShader2, 35713, iArr, 0);
        if (iArr[0] == 0) {
            String glGetShaderInfoLog2 = GLES20.glGetShaderInfoLog(glCreateShader2);
            GLES20.glDeleteShader(glCreateShader2);
            if (GLConfig.DEBUG) {
                if (str2.length() >= 100) {
                    length = str2.length() - 100;
                } else {
                    length = 0;
                }
                LogUtils.m50202e(TAG, "fragment shader compile,failed:" + str2.substring(length));
                LogUtils.m50202e(TAG, glGetShaderInfoLog2);
            }
            AppMethodBeat.m2505o(50022);
            return 0;
        }
        length = GLES20.glCreateProgram();
        GLES20.glAttachShader(length, glCreateShader);
        GLES20.glAttachShader(length, glCreateShader2);
        GLES20.glLinkProgram(length);
        GLES20.glGetProgramiv(length, 35714, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteProgram(length);
            new StringBuilder("link program,failed:").append(GLES20.glGetProgramInfoLog(length));
            if (GLConfig.DEBUG) {
                LogUtils.m50202e(TAG, "link program,failed:" + GLES20.glGetProgramInfoLog(length));
            }
            AppMethodBeat.m2505o(50022);
            return 0;
        }
        GLES20.glDeleteShader(glCreateShader);
        GLES20.glDeleteShader(glCreateShader2);
        AppMethodBeat.m2505o(50022);
        return length;
    }

    public static int createComputeProgram(String str) {
        AppMethodBeat.m2504i(50023);
        int glCreateShader = GLES31.glCreateShader(37305);
        GLES20.glShaderSource(glCreateShader, str);
        int[] iArr = new int[1];
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        int length;
        if (iArr[0] == 0) {
            String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
            GLES20.glDeleteShader(glCreateShader);
            if (GLConfig.DEBUG) {
                if (str.length() >= 100) {
                    length = str.length() - 100;
                } else {
                    length = 0;
                }
                LogUtils.m50202e(TAG, "vertex shader compile,failed:" + str.substring(length));
                LogUtils.m50202e(TAG, glGetShaderInfoLog);
            }
            AppMethodBeat.m2505o(50023);
            return 0;
        }
        length = GLES20.glCreateProgram();
        GLES20.glAttachShader(length, glCreateShader);
        GLES20.glLinkProgram(length);
        GLES20.glGetProgramiv(length, 35714, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteProgram(length);
            new StringBuilder("link program,failed:").append(GLES20.glGetProgramInfoLog(length));
            if (GLConfig.DEBUG) {
                LogUtils.m50202e(TAG, "link program,failed:" + GLES20.glGetProgramInfoLog(length));
            }
            AppMethodBeat.m2505o(50023);
            return 0;
        }
        GLES20.glDeleteShader(glCreateShader);
        AppMethodBeat.m2505o(50023);
        return length;
    }

    public static void createTexture(int i, int i2, int i3, int[] iArr) {
        AppMethodBeat.m2504i(50024);
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, GLType.GL_UNSIGNED_BYTE, null);
        AppMethodBeat.m2505o(50024);
    }

    public static int loadShader(int i, String str) {
        AppMethodBeat.m2504i(50025);
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        AppMethodBeat.m2505o(50025);
        return glCreateShader;
    }

    public static void mallocTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(50026);
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, i2, i3, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
        AppMethodBeat.m2505o(50026);
    }

    @TargetApi(18)
    public static void setupSSBufferObject(int i, int i2, float[] fArr, int i3) {
        AppMethodBeat.m2504i(50027);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(i3 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        if (fArr != null) {
            asFloatBuffer.put(fArr).position(0);
        }
        GLES31.glBindBuffer(37074, i);
        GLES31.glBufferData(37074, i3 * 4, asFloatBuffer, 35044);
        GLES31.glBindBufferBase(37074, i2, i);
        AppMethodBeat.m2505o(50027);
    }
}
