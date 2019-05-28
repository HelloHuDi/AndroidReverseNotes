package com.tencent.filter;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class QImage {
    private int height;
    private long nativeImage;
    private int pixelBytes;
    private int pixelFormat;
    private int width;

    public static native QImage BindBitmap(Bitmap bitmap);

    public static native QImage Bitmap2QImage(Bitmap bitmap);

    public static native byte[] CompressJPEGFromRGBA(byte[] bArr, int i, int i2, int i3);

    public native int AverageChannels();

    public native void CopyExif(QImage qImage);

    public native void CopyPixels(int[] iArr, int i);

    public native void CopyPixelsRGB(int[] iArr, int i);

    public native void CreateImage(int i, int i2, int i3);

    public native QImage CreateImageFromQImage();

    public native void Dispose();

    public native boolean FromBitmap(Bitmap bitmap);

    public native QImage InplaceBlur8bitQImage(int i, int i2);

    public native void RGB565toRGB(byte[] bArr, int i, int i2);

    public native boolean ToBitmap(Bitmap bitmap);

    public native boolean UnBindBitmap(Bitmap bitmap);

    public native void WrapExif(QImage qImage);

    public native void YUV420sp2RGB(byte[] bArr, int i, int i2);

    public native void YUV420sp2YUV(byte[] bArr, int i, int i2);

    public native void YUV420sp2YUV2(byte[] bArr, int i, int i2, int i3);

    public native void YUV422toRGB(byte[] bArr, int i, int i2);

    public native boolean alphaMix(Bitmap bitmap, int i, int i2);

    public native QImage createSubImage(int i, int i2, int i3, int i4);

    public native long getByteSize();

    public native boolean nativeFlip(int i, int i2);

    public native int[] nativeGetArrayHistogram();

    public native int[] nativeGetArrayHistogramChannels();

    public native boolean nativeRotate(int i);

    public native void nativeUpdateROI();

    public native void toGPUTexture(int i);

    public QImage() {
        this.width = 0;
        this.height = 0;
        this.nativeImage = 0;
        this.pixelBytes = 0;
    }

    public QImage(int i, int i2) {
        AppMethodBeat.m2504i(86424);
        CreateImage(i, i2, 4);
        AppMethodBeat.m2505o(86424);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getPixelFormat() {
        return this.pixelFormat;
    }

    public int getPixelBytes() {
        return this.pixelBytes;
    }
}
