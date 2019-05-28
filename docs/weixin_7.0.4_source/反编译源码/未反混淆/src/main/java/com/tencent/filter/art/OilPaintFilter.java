package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.QImage;
import com.tencent.filter.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.b;

public class OilPaintFilter extends c {
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
        AppMethodBeat.i(86310);
        long nativeInitialize = nativeInitialize(qImage, this.type);
        int nativeGetBrushSize = nativeGetBrushSize(nativeInitialize);
        Bitmap[] bitmapArr = new Bitmap[4];
        if (this.type == 0) {
            bitmapArr[0] = b.a("brush/brush00.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
            bitmapArr[1] = b.a("brush/brush01.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
            bitmapArr[2] = b.a("brush/brush02.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
            bitmapArr[3] = b.a("brush/brush03.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
        } else {
            bitmapArr[0] = b.a("brush/brush10.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
            bitmapArr[1] = b.a("brush/brush11.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
            bitmapArr[2] = b.a("brush/brush12.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
            bitmapArr[3] = b.a("brush/brush13.png", Config.ARGB_8888, nativeGetBrushSize, nativeGetBrushSize);
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
        AppMethodBeat.o(86310);
        return nativeProcessOilPaintFilter;
    }
}
