package com.tencent.mm.loader.l;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.b.f;
import com.tencent.mm.loader.h.a.b;
import com.tencent.mm.sdk.platformtools.d;
import java.io.InputStream;

public final class a {
    public static boolean d(com.tencent.mm.loader.h.a.a aVar) {
        if (aVar == null || aVar.Uf() == b.ASSET_DATA || aVar.Uf() == b.DRAWABLE_ID || aVar.Uf() == b.LOCAL_PATH) {
            return true;
        }
        return false;
    }

    public static Bitmap a(f<?> fVar, InputStream inputStream, int i, int i2, boolean z, float f, boolean z2) {
        Bitmap a;
        if (i > 0 && i2 > 0) {
            a = d.a(inputStream, 0.0f, i, i2);
        } else if (fVar == null || fVar.width <= 0 || fVar.width <= 0) {
            a = d.decodeStream(inputStream);
        } else {
            a = d.a(inputStream, 0.0f, fVar.width, fVar.height);
        }
        if (z) {
            a = d.a(a, i, i2, false, true);
        }
        if (f > 0.0f) {
            a = d.c(a, f);
        }
        if (z2) {
            return d.ak(a);
        }
        return a;
    }
}
