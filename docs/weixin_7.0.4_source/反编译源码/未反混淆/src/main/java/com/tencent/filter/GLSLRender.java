package com.tencent.filter;

import android.graphics.Bitmap;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.view.d;

public class GLSLRender {
    public static int GL_TEXTURE_2D = 3553;
    public static int bJB = 0;
    public static int bJC = 1;
    public static int bJD = 2;
    public static int bJE = 3;
    public static int bJF = 4;
    public static int bJG = 5;
    public static int bJH = 6;
    public static int bJI = 7;
    public static int bJJ = 8;
    public static int bJK = 9;
    public static int bJL = 10;
    public static int bJM = 11;
    public static int bJN = 12;
    public static int bJO = 13;
    public static int bJP = 14;
    public static int bJQ = 15;
    public static int bJR = 16;
    public static int bJS = 17;
    public static int bJT = 18;
    public static int bJU = 19;
    public static int bJV = 20;
    public static int bJW = 21;
    public static int bJX = 22;
    public static int bJY = 23;
    public static int bJZ = 24;
    public static int bKA = 51;
    public static int bKB = 52;
    public static int bKC = 53;
    public static int bKD = 54;
    public static int bKE = 55;
    public static int bKF = 56;
    public static int bKG = 57;
    public static int bKH = 58;
    public static int bKI = 59;
    public static int bKJ = 60;
    public static int bKK = 61;
    public static int bKL = 62;
    public static int bKM = 63;
    public static int bKN = 64;
    public static int bKO = 65;
    public static int bKP = 66;
    public static int bKQ = 67;
    public static int bKR = 68;
    public static int bKS = 69;
    public static int bKT = 70;
    public static int bKU = 71;
    public static int bKV = 72;
    public static int bKW = 73;
    public static int bKX = 74;
    public static int bKY = 75;
    public static int bKZ = 76;
    public static int bKa = 25;
    public static int bKb = 26;
    public static int bKc = 27;
    public static int bKd = 28;
    public static int bKe = 29;
    public static int bKf = 30;
    public static int bKg = 31;
    public static int bKh = 32;
    public static int bKi = 33;
    public static int bKj = 34;
    public static int bKk = 35;
    public static int bKl = 36;
    public static int bKm = 37;
    public static int bKn = 38;
    public static int bKo = 39;
    public static int bKp = 40;
    public static int bKq = 41;
    public static int bKr = 42;
    public static int bKs = 43;
    public static int bKt = 44;
    public static int bKu = 45;
    public static int bKv = 46;
    public static int bKw = 47;
    public static int bKx = 48;
    public static int bKy = 49;
    public static int bKz = 50;
    public static int bLA = 103;
    public static int bLB = 104;
    public static int bLC = 105;
    public static int bLD = 106;
    public static int bLE = 107;
    public static int bLF = 108;
    public static int bLG = 109;
    public static int bLH = 110;
    public static int bLI = 111;
    public static int bLJ = 112;
    public static int bLK = 113;
    public static int bLL = 114;
    public static int bLM = 115;
    public static int bLN = 116;
    public static int bLO = d.MIC_ALPHA_ADJUST_REAL;
    public static int bLP = 118;
    public static int bLQ = d.MIC_AVROUND_BLUR;
    public static int bLR = 120;
    public static int bLS = 121;
    public static int bLT = 122;
    public static int bLU = 123;
    public static int bLV = 124;
    public static int bLW = 125;
    public static int bLX = 126;
    public static int bLY = d.MIC_SketchMark;
    public static int bLZ = 128;
    public static int bLa = 77;
    public static int bLb = 78;
    public static int bLc = 79;
    public static int bLd = 80;
    public static int bLe = 81;
    public static int bLf = 82;
    public static int bLg = 83;
    public static int bLh = 84;
    public static int bLi = 85;
    public static int bLj = 86;
    public static int bLk = 87;
    public static int bLl = 88;
    public static int bLm = 89;
    public static int bLn = 90;
    public static int bLo = 91;
    public static int bLp = 92;
    public static int bLq = 93;
    public static int bLr = 94;
    public static int bLs = 95;
    public static int bLt = 96;
    public static int bLu = 97;
    public static int bLv = 98;
    public static int bLw = 99;
    public static int bLx = 100;
    public static int bLy = 101;
    public static int bLz = 102;
    public static int bMa = GmsClientSupervisor.DEFAULT_BIND_FLAGS;
    public static int bMb = 130;
    public static int bMc = 131;
    public static int bMd = 132;
    public static int bMe = e.CTRL_INDEX;
    public static int bMf = com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX;
    public static int bMg = b.CTRL_INDEX;
    public static int bMh = n.CTRL_INDEX;
    public static int bMi = 137;
    public static int bMj = 138;
    public static int bMk = GlUtil.GL_TEXTURE_EXTERNAL_OES;
    public static int bMl = 0;
    public static int bMm = 1;
    public static int bMn = 2;
    public static int bMo = 3;
    public static int bMp = 4;
    public static int bMq = 5;
    public static int bMr = 6;
    public static int bMs = 7;
    public static int bMt = 8;
    public static int bMu = 9;
    public static int bMv = 10;
    public static int bMw = 11;
    public static int bMx = 12;
    public static int bMy = 13;

    public static native long nativeAllocBuffer(int i);

    public static native void nativeBeginUseEglImage(int i, int i2, int i3);

    public static native void nativeCalHistogramFromGPU(long j, long j2, int i, int i2, int i3, int i4, float f, float f2, int i5, int i6, float f3, float f4);

    public static native int nativeCheckMagicEngine(int i, int i2);

    public static native int nativeCopyPixelToBitmap(Bitmap bitmap);

    public static native int nativeCopyPixelToBitmapWithShare(Bitmap bitmap, int i, int i2);

    public static native void nativeCopyTexturToDataWithShare(int i, byte[] bArr, int i2, int i3, int i4);

    public static native QImage nativeCopyTexture(int i, int i2);

    public static native void nativeCopyTexture2(QImage qImage);

    public static native QImage nativeCopyTextureWithShare(int i, int i2, int i3, int i4);

    public static native int nativeDeinitMagicEngine(int i);

    public static native void nativeEndUseEglImage(int i, int i2, int i3);

    public static native void nativeFreeBuffer(long j);

    public static native int nativeInitMagicEngine(int i, int i2);

    public static native void nativePickJepgToTexture(QImage qImage, int i, int i2, int i3, int i4, int i5, int[] iArr);

    public static native void nativePreprocessJepg(QImage qImage, int[] iArr);

    public static native void nativePreviewData(byte[] bArr, int i, int i2, int i3);

    public static native void nativePreviewYuvData(byte[] bArr, int i, int i2, int i3);

    public static native void nativePushBitmapFromTexture(Bitmap bitmap, int i);

    public static native void nativePushDataFromTexture(byte[] bArr, int i, int i2, int i3);

    public static native void nativePushJepgFromTexture(QImage qImage, int i, int i2, int i3, int i4, int i5);

    public static native int nativeRenderPixelToBitmap(Bitmap bitmap, int i, int i2);

    public static native int nativeSnap(Bitmap bitmap);

    public static native void nativeTextCure(int[] iArr, int i);

    public static native void nativeTextImage(QImage qImage, int i);

    public static native void nativeToRGBData(byte[] bArr, int i, int i2);

    public static native void nativeUpdateScaleBitmap(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, int i, int i2);
}
