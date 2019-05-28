package com.tencent.p177mm.loader.p858b.p860b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.loader.p1197h.C42160d;
import com.tencent.p177mm.loader.p1197h.C42161e;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p246e.p862c.C9569a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.loader.b.b.a */
public final class C18529a extends C9566c<String, Bitmap> {
    private C42160d<String, Bitmap> ePn = new C42160d(50);
    private C42160d<String, Bitmap> ePo = new C42160d(10);

    /* renamed from: a */
    public final /* synthetic */ void mo20874a(C42156a c42156a, C9569a c9569a, Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (c42156a == null) {
            return;
        }
        if (C5046bo.isNullOrNil((String) c42156a.value())) {
            C4990ab.m7420w("MicroMsg.Loader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
        } else if (bitmap == null) {
            C4990ab.m7420w("MicroMsg.Loader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
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
            C4990ab.m7411d("MicroMsg.Loader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", c42156a.value(), Long.valueOf(j), C5046bo.m7565ga(j));
            if (j > C1625i.ACTION_MINI_PROGRAM_LAUNCH) {
                this.ePo.put(C9566c.m17036b(c42156a, c9569a), bitmap);
            } else {
                this.ePn.put(C9566c.m17036b(c42156a, c9569a), bitmap);
            }
        }
    }

    /* renamed from: a */
    public final C42161e<Bitmap> mo20873a(C42156a<String> c42156a, C9569a<Bitmap> c9569a) {
        if (!C5046bo.isNullOrNil((String) c42156a.value())) {
            Object obj;
            String b = C9566c.m17036b(c42156a, c9569a);
            Bitmap bitmap = (Bitmap) this.ePn.get(b);
            if (bitmap == null) {
                obj = (Bitmap) this.ePo.get(b);
            } else {
                Bitmap obj2 = bitmap;
            }
            if (obj2 != null) {
                return new C42161e(obj2);
            }
        }
        return null;
    }
}
