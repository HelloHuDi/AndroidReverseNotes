package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.loader.h.d;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends c<String, Bitmap> {
    private d<String, Bitmap> ePn = new d(50);
    private d<String, Bitmap> ePo = new d(10);

    public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a aVar, com.tencent.mm.loader.e.c.a aVar2, Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (aVar == null) {
            return;
        }
        if (bo.isNullOrNil((String) aVar.value())) {
            ab.w("MicroMsg.Loader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
        } else if (bitmap == null) {
            ab.w("MicroMsg.Loader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
        } else {
            long j;
            if (bitmap == null || !(bitmap instanceof Bitmap)) {
                j = 0;
            } else {
                Bitmap bitmap2 = bitmap;
                if (VERSION.SDK_INT >= 12) {
                    j = (long) bitmap2.getByteCount();
                } else {
                    j = (long) (bitmap2.getHeight() * bitmap2.getRowBytes());
                }
            }
            ab.d("MicroMsg.Loader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", aVar.value(), Long.valueOf(j), bo.ga(j));
            if (j > i.ACTION_MINI_PROGRAM_LAUNCH) {
                this.ePo.put(c.b(aVar, aVar2), bitmap);
            } else {
                this.ePn.put(c.b(aVar, aVar2), bitmap);
            }
        }
    }

    public final e<Bitmap> a(com.tencent.mm.loader.h.a.a<String> aVar, com.tencent.mm.loader.e.c.a<Bitmap> aVar2) {
        if (!bo.isNullOrNil((String) aVar.value())) {
            Object obj;
            String b = c.b(aVar, aVar2);
            Bitmap bitmap = (Bitmap) this.ePn.get(b);
            if (bitmap == null) {
                obj = (Bitmap) this.ePo.get(b);
            } else {
                Bitmap obj2 = bitmap;
            }
            if (obj2 != null) {
                return new e(obj2);
            }
        }
        return null;
    }
}
