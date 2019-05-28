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
import com.tencent.util.C16371i;
import com.tencent.util.C16372j;
import com.tencent.util.C36572f;

/* renamed from: com.tencent.view.g */
public final class C41106g {
    private static final float[] AIO = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] AIP = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static boolean AIQ = true;

    public static int dSO() {
        AppMethodBeat.m2504i(86639);
        int[] iArr = new int[1];
        C36572f.dSJ().mo58343c(iArr, true);
        C41106g.checkGlError("glGenTextures");
        int i = iArr[0];
        AppMethodBeat.m2505o(86639);
        return i;
    }

    /* renamed from: at */
    public static int m71543at(Bitmap bitmap) {
        AppMethodBeat.m2504i(86640);
        int dSO = C41106g.dSO();
        GLES20.glBindTexture(3553, dSO);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        C41106g.checkGlError("texImage2D");
        AppMethodBeat.m2505o(86640);
        return dSO;
    }

    /* renamed from: a */
    public static void m71540a(int i, int i2, int i3, byte[] bArr, int i4) {
        AppMethodBeat.m2504i(86641);
        if (C44569b.AIH < 0) {
            GLES20.glBindFramebuffer(36160, i4);
            C41106g.checkGlError("glBindFramebuffer");
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
            C41106g.checkGlError("glFramebufferTexture2D");
            GLSLRender.nativeToRGBData(bArr, i2, i3);
            GLES20.glBindFramebuffer(36160, 0);
            C41106g.checkGlError("glBindFramebuffer");
            AppMethodBeat.m2505o(86641);
            return;
        }
        GLSLRender.nativePushDataFromTexture(bArr, i2, i3, C44569b.AIH);
        AppMethodBeat.m2505o(86641);
    }

    /* renamed from: a */
    public static void m71539a(int i, int i2, int i3, Bitmap bitmap) {
        AppMethodBeat.m2504i(86642);
        int i4 = C44569b.AIH;
        if (i4 < 0) {
            if (C16372j.dSM().AIv) {
                GLES20.glActiveTexture(33984);
                C41106g.checkGlError("glActiveTexture");
                GLES20.glBindTexture(3553, i);
                C41106g.checkGlError("glBindTexture");
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, i2, i3, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
                C41106g.checkGlError("glTexImage2D");
            }
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glBindFramebuffer(36160, iArr[0]);
            C41106g.checkGlError("glBindFramebuffer");
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
            C41106g.checkGlError("glFramebufferTexture2D");
            C41106g.checkGlError("glReadPixels");
            GLSLRender.nativeCopyPixelToBitmap(bitmap);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            C41106g.checkGlError("glBindFramebuffer");
            AppMethodBeat.m2505o(86642);
            return;
        }
        GLSLRender.nativeCopyPixelToBitmapWithShare(bitmap, i, i4);
        AppMethodBeat.m2505o(86642);
    }

    /* renamed from: aK */
    public static Bitmap m71541aK(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86643);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Config.ARGB_8888);
        if (createBitmap != null) {
            C41106g.m71539a(i, i2, i3, createBitmap);
        }
        AppMethodBeat.m2505o(86643);
        return createBitmap;
    }

    /* renamed from: aL */
    public static QImage m71542aL(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86644);
        int i4 = C44569b.AIH;
        QImage nativeCopyTexture;
        if (i4 < 0) {
            if (C16372j.dSM().AIv) {
                GLES20.glActiveTexture(33984);
                C41106g.checkGlError("glActiveTexture");
                GLES20.glBindTexture(3553, i);
                C41106g.checkGlError("glBindTexture");
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, i2, i3, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
                C41106g.checkGlError("glTexImage2D");
            }
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glBindFramebuffer(36160, iArr[0]);
            C41106g.checkGlError("glBindFramebuffer");
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
            C41106g.checkGlError("glFramebufferTexture2D");
            C41106g.checkGlError("glReadPixels");
            nativeCopyTexture = GLSLRender.nativeCopyTexture(i2, i3);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            C41106g.checkGlError("glBindFramebuffer");
            AppMethodBeat.m2505o(86644);
            return nativeCopyTexture;
        }
        nativeCopyTexture = GLSLRender.nativeCopyTextureWithShare(i2, i3, i, i4);
        AppMethodBeat.m2505o(86644);
        return nativeCopyTexture;
    }

    /* renamed from: Sk */
    public static void m71538Sk(int i) {
        AppMethodBeat.m2504i(86645);
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        C41106g.checkGlError("glDeleteTextures");
        AppMethodBeat.m2505o(86645);
    }

    public static void checkGlError(String str) {
        AppMethodBeat.m2504i(86646);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0 && AIQ) {
            C16371i.m25188m("RendererUtils", str + ": glError " + glGetError);
            for (StackTraceElement stackTraceElement : (StackTraceElement[]) Thread.getAllStackTraces().get(Thread.currentThread())) {
                C16371i.m25188m("SS     ", stackTraceElement.toString());
            }
        }
        AppMethodBeat.m2505o(86646);
    }

    public static void dSP() {
        AIQ = false;
    }

    public static boolean isEnableLog() {
        return AIQ;
    }
}
