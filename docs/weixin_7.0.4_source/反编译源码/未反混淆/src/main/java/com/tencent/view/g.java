package com.tencent.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.f;
import com.tencent.util.i;
import com.tencent.util.j;

public final class g {
    private static final float[] AIO = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] AIP = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static boolean AIQ = true;

    public static int dSO() {
        AppMethodBeat.i(86639);
        int[] iArr = new int[1];
        f.dSJ().c(iArr, true);
        checkGlError("glGenTextures");
        int i = iArr[0];
        AppMethodBeat.o(86639);
        return i;
    }

    public static int at(Bitmap bitmap) {
        AppMethodBeat.i(86640);
        int dSO = dSO();
        GLES20.glBindTexture(3553, dSO);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        checkGlError("texImage2D");
        AppMethodBeat.o(86640);
        return dSO;
    }

    public static void a(int i, int i2, int i3, byte[] bArr, int i4) {
        AppMethodBeat.i(86641);
        if (b.AIH < 0) {
            GLES20.glBindFramebuffer(36160, i4);
            checkGlError("glBindFramebuffer");
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
            checkGlError("glFramebufferTexture2D");
            GLSLRender.nativeToRGBData(bArr, i2, i3);
            GLES20.glBindFramebuffer(36160, 0);
            checkGlError("glBindFramebuffer");
            AppMethodBeat.o(86641);
            return;
        }
        GLSLRender.nativePushDataFromTexture(bArr, i2, i3, b.AIH);
        AppMethodBeat.o(86641);
    }

    public static void a(int i, int i2, int i3, Bitmap bitmap) {
        AppMethodBeat.i(86642);
        int i4 = b.AIH;
        if (i4 < 0) {
            if (j.dSM().AIv) {
                GLES20.glActiveTexture(33984);
                checkGlError("glActiveTexture");
                GLES20.glBindTexture(3553, i);
                checkGlError("glBindTexture");
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, i2, i3, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
                checkGlError("glTexImage2D");
            }
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glBindFramebuffer(36160, iArr[0]);
            checkGlError("glBindFramebuffer");
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
            checkGlError("glFramebufferTexture2D");
            checkGlError("glReadPixels");
            GLSLRender.nativeCopyPixelToBitmap(bitmap);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            checkGlError("glBindFramebuffer");
            AppMethodBeat.o(86642);
            return;
        }
        GLSLRender.nativeCopyPixelToBitmapWithShare(bitmap, i, i4);
        AppMethodBeat.o(86642);
    }

    public static Bitmap aK(int i, int i2, int i3) {
        AppMethodBeat.i(86643);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Config.ARGB_8888);
        if (createBitmap != null) {
            a(i, i2, i3, createBitmap);
        }
        AppMethodBeat.o(86643);
        return createBitmap;
    }

    public static QImage aL(int i, int i2, int i3) {
        AppMethodBeat.i(86644);
        int i4 = b.AIH;
        QImage nativeCopyTexture;
        if (i4 < 0) {
            if (j.dSM().AIv) {
                GLES20.glActiveTexture(33984);
                checkGlError("glActiveTexture");
                GLES20.glBindTexture(3553, i);
                checkGlError("glBindTexture");
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, i2, i3, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
                checkGlError("glTexImage2D");
            }
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glBindFramebuffer(36160, iArr[0]);
            checkGlError("glBindFramebuffer");
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
            checkGlError("glFramebufferTexture2D");
            checkGlError("glReadPixels");
            nativeCopyTexture = GLSLRender.nativeCopyTexture(i2, i3);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            checkGlError("glBindFramebuffer");
            AppMethodBeat.o(86644);
            return nativeCopyTexture;
        }
        nativeCopyTexture = GLSLRender.nativeCopyTextureWithShare(i2, i3, i, i4);
        AppMethodBeat.o(86644);
        return nativeCopyTexture;
    }

    public static void Sk(int i) {
        AppMethodBeat.i(86645);
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        checkGlError("glDeleteTextures");
        AppMethodBeat.o(86645);
    }

    public static void checkGlError(String str) {
        AppMethodBeat.i(86646);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0 && AIQ) {
            i.m("RendererUtils", str + ": glError " + glGetError);
            for (StackTraceElement stackTraceElement : (StackTraceElement[]) Thread.getAllStackTraces().get(Thread.currentThread())) {
                i.m("SS     ", stackTraceElement.toString());
            }
        }
        AppMethodBeat.o(86646);
    }

    public static void dSP() {
        AIQ = false;
    }

    public static boolean isEnableLog() {
        return AIQ;
    }
}
