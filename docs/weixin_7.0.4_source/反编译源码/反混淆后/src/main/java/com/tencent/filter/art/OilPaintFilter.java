package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.C17753c;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C44569b;

public class OilPaintFilter extends C17753c {
    int type;

    public static native int nativeGetBrushSize(long j);

    public static native long nativeInitialize(QImage qImage, int i);

    public static native QImage nativeProcessOilPaintFilter(long j, QImage qImage, int i, int i2);

    public static native void nativeRelease(long j);

    public static native void nativeSetBrush(long j, Bitmap[] bitmapArr);

    public OilPaintFilter(int i) {
        this.type = i;
    }

    public QImage ApplyFilter(QImage qImage) {
        int i = 0;
        AppMethodBeat.m2504i(86310);
        long nativeInitialize = nativeInitialize(qImage, this.type);
        int nativeGetBrushSize = nativeGetBrushSize(nativeInitialize);
        Bitmap[] bitmapArr = new Bitmap[4];
        if (this.type == 0) {
            bitmapArr[0] = C44569b.m80950a("brush/brush00.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
            bitmapArr[1] = C44569b.m80950a("brush/brush01.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
            bitmapArr[2] = C44569b.m80950a("brush/brush02.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
            bitmapArr[3] = C44569b.m80950a("brush/brush03.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
        } else {
            bitmapArr[0] = C44569b.m80950a("brush/brush10.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
            bitmapArr[1] = C44569b.m80950a("brush/brush11.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
            bitmapArr[2] = C44569b.m80950a("brush/brush12.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
            bitmapArr[3] = C44569b.m80950a("brush/brush13.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
        }
        nativeSetBrush(nativeInitialize, bitmapArr);
        QImage nativeProcessOilPaintFilter = nativeProcessOilPaintFilter(nativeInitialize, qImage, this.type, 5);
        nativeRelease(nativeInitialize);
        while (i < 4) {
            if (bitmapArr[i] != null) {
                bitmapArr[i].recycle();
            }
            i++;
        }
        AppMethodBeat.m2505o(86310);
        return nativeProcessOilPaintFilter;
    }
}
