package com.tencent.mm.loader.e.a;

import a.f.b.j;
import a.l;
import a.y;
import android.graphics.Bitmap;
import com.tencent.mm.loader.e.b.f;
import com.tencent.mm.loader.h.b.a;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0010\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/loader/impr/imageproducer/InputStreamBitmapProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "libimageloader_release"})
public class c extends b {
    private String TAG = "MicroMsg.Loader.InputStreamBitmapProducer";

    /* JADX WARNING: Missing block: B:6:0x0047, code skipped:
            if (r0.b(r2, r1) == true) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e<Bitmap> a(f<?> fVar, com.tencent.mm.loader.f<?, Bitmap> fVar2, a aVar) {
        Object a;
        y yVar;
        j.p(fVar, "targetView");
        j.p(fVar2, "reaper");
        j.p(aVar, "input");
        InputStream Uj = aVar.Uj();
        boolean TD = fVar2.eOF.TD();
        String TE = fVar2.eOF.TE();
        com.tencent.mm.ab.a aVar2 = new com.tencent.mm.ab.a("InputStreamBitmapProducer");
        ab.d(this.TAG, "hy: should check md5:".concat(String.valueOf(TD)));
        if (Uj != null) {
            if (TD) {
                com.tencent.mm.loader.d.c cVar = fVar2.eOM;
                if (cVar != null) {
                }
            }
            a = com.tencent.mm.loader.l.a.a(fVar, Uj, fVar2.eOF.Tz(), fVar2.eOF.TA(), fVar2.eOF.TH(), fVar2.eOF.getAlpha(), fVar2.eOF.TB());
            yVar = y.AUy;
            aVar2.SW();
            return new e(a);
        }
        a = null;
        yVar = y.AUy;
        aVar2.SW();
        return new e(a);
    }
}
