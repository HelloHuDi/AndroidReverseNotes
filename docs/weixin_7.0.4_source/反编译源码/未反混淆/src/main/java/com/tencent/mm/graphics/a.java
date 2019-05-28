package com.tencent.mm.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.tencent.e.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap a(InputStream inputStream, Rect rect, Options options) {
        BitmapRegionDecoder newInstance;
        Bitmap decodeRegion;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.i(57659);
        try {
            newInstance = BitmapRegionDecoder.newInstance(inputStream, true);
            try {
                decodeRegion = newInstance.decodeRegion(rect, options);
                if (newInstance != null) {
                    newInstance.recycle();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            newInstance = null;
            if (newInstance != null) {
                newInstance.recycle();
            }
            AppMethodBeat.o(57659);
            throw th;
        }
        if (decodeRegion != null) {
            b.w("MicroMsg.MMBitmapRegionDecoder", "fail to do regional decode with BitmapRegionDecoder, decode fully and crop instead.");
            decodeRegion = MMBitmapFactory.decodeStream(inputStream, null, options);
            if (decodeRegion != null) {
                bitmap = Bitmap.createBitmap(decodeRegion, rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top);
                if (bitmap != decodeRegion) {
                    decodeRegion.recycle();
                }
            }
        } else {
            bitmap = decodeRegion;
        }
        AppMethodBeat.o(57659);
        return bitmap;
        try {
            b.b("MicroMsg.MMBitmapRegionDecoder", th, "exception in MMBitmapRegionDecoder.");
            if (newInstance != null) {
                newInstance.recycle();
                decodeRegion = null;
            } else {
                decodeRegion = null;
            }
            if (decodeRegion != null) {
            }
            AppMethodBeat.o(57659);
            return bitmap;
        } catch (Throwable th4) {
            th = th4;
            if (newInstance != null) {
            }
            AppMethodBeat.o(57659);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap a(byte[] bArr, int i, Rect rect, Options options) {
        BitmapRegionDecoder newInstance;
        Bitmap decodeRegion;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.i(57660);
        try {
            newInstance = BitmapRegionDecoder.newInstance(bArr, 0, i, true);
            try {
                decodeRegion = newInstance.decodeRegion(rect, options);
                if (newInstance != null) {
                    newInstance.recycle();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            newInstance = null;
            if (newInstance != null) {
            }
            AppMethodBeat.o(57660);
            throw th;
        }
        if (decodeRegion != null) {
            b.w("MicroMsg.MMBitmapRegionDecoder", "fail to do regional decode with BitmapRegionDecoder, decode fully and crop instead.");
            decodeRegion = MMBitmapFactory.decodeByteArray(bArr, 0, i, options);
            if (decodeRegion != null) {
                bitmap = Bitmap.createBitmap(decodeRegion, rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top);
                if (bitmap != decodeRegion) {
                    decodeRegion.recycle();
                }
            }
        } else {
            bitmap = decodeRegion;
        }
        AppMethodBeat.o(57660);
        return bitmap;
        try {
            b.b("MicroMsg.MMBitmapRegionDecoder", th, "exception in MMBitmapRegionDecoder.");
            if (newInstance != null) {
                newInstance.recycle();
                decodeRegion = null;
            } else {
                decodeRegion = null;
            }
            if (decodeRegion != null) {
            }
            AppMethodBeat.o(57660);
            return bitmap;
        } catch (Throwable th4) {
            th = th4;
            if (newInstance != null) {
                newInstance.recycle();
            }
            AppMethodBeat.o(57660);
            throw th;
        }
    }
}
