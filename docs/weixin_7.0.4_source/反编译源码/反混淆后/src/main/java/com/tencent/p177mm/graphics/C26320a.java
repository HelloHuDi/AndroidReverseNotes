package com.tencent.p177mm.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p136e.p137a.C0926b;
import java.io.InputStream;

/* renamed from: com.tencent.mm.graphics.a */
public final class C26320a {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static Bitmap m41876a(InputStream inputStream, Rect rect, Options options) {
        BitmapRegionDecoder newInstance;
        Bitmap decodeRegion;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(57659);
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
            AppMethodBeat.m2505o(57659);
            throw th;
        }
        if (decodeRegion != null) {
            C0926b.m2107w("MicroMsg.MMBitmapRegionDecoder", "fail to do regional decode with BitmapRegionDecoder, decode fully and crop instead.");
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
        AppMethodBeat.m2505o(57659);
        return bitmap;
        try {
            C0926b.m2098b("MicroMsg.MMBitmapRegionDecoder", th, "exception in MMBitmapRegionDecoder.");
            if (newInstance != null) {
                newInstance.recycle();
                decodeRegion = null;
            } else {
                decodeRegion = null;
            }
            if (decodeRegion != null) {
            }
            AppMethodBeat.m2505o(57659);
            return bitmap;
        } catch (Throwable th4) {
            th = th4;
            if (newInstance != null) {
            }
            AppMethodBeat.m2505o(57659);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static Bitmap m41877a(byte[] bArr, int i, Rect rect, Options options) {
        BitmapRegionDecoder newInstance;
        Bitmap decodeRegion;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(57660);
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
            AppMethodBeat.m2505o(57660);
            throw th;
        }
        if (decodeRegion != null) {
            C0926b.m2107w("MicroMsg.MMBitmapRegionDecoder", "fail to do regional decode with BitmapRegionDecoder, decode fully and crop instead.");
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
        AppMethodBeat.m2505o(57660);
        return bitmap;
        try {
            C0926b.m2098b("MicroMsg.MMBitmapRegionDecoder", th, "exception in MMBitmapRegionDecoder.");
            if (newInstance != null) {
                newInstance.recycle();
                decodeRegion = null;
            } else {
                decodeRegion = null;
            }
            if (decodeRegion != null) {
            }
            AppMethodBeat.m2505o(57660);
            return bitmap;
        } catch (Throwable th4) {
            th = th4;
            if (newInstance != null) {
                newInstance.recycle();
            }
            AppMethodBeat.m2505o(57660);
            throw th;
        }
    }
}
