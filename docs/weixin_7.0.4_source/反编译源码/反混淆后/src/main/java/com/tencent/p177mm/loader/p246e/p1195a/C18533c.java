package com.tencent.p177mm.loader.p246e.p1195a;

import android.graphics.Bitmap;
import com.tencent.p177mm.loader.C45421f;
import com.tencent.p177mm.loader.p1197h.C42161e;
import com.tencent.p177mm.loader.p1197h.p1199b.C18545a;
import com.tencent.p177mm.loader.p1201l.C26372a;
import com.tencent.p177mm.loader.p245d.C32727c;
import com.tencent.p177mm.loader.p246e.p247b.C32731f;
import com.tencent.p177mm.p823ab.C8901a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.InputStream;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0010\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/loader/impr/imageproducer/InputStreamBitmapProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.e.a.c */
public class C18533c extends C26360b {
    private String TAG = "MicroMsg.Loader.InputStreamBitmapProducer";

    /* JADX WARNING: Missing block: B:6:0x0047, code skipped:
            if (r0.mo20892b(r2, r1) == true) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public C42161e<Bitmap> mo33786a(C32731f<?> c32731f, C45421f<?, Bitmap> c45421f, C18545a c18545a) {
        Object a;
        C37091y c37091y;
        C25052j.m39376p(c32731f, "targetView");
        C25052j.m39376p(c45421f, "reaper");
        C25052j.m39376p(c18545a, "input");
        InputStream Uj = c18545a.mo33796Uj();
        boolean TD = c45421f.eOF.mo60615TD();
        String TE = c45421f.eOF.mo60616TE();
        C8901a c8901a = new C8901a("InputStreamBitmapProducer");
        C4990ab.m7410d(this.TAG, "hy: should check md5:".concat(String.valueOf(TD)));
        if (Uj != null) {
            if (TD) {
                C32727c c32727c = c45421f.eOM;
                if (c32727c != null) {
                }
            }
            a = C26372a.m41962a(c32731f, Uj, c45421f.eOF.mo60627Tz(), c45421f.eOF.mo60612TA(), c45421f.eOF.mo60619TH(), c45421f.eOF.getAlpha(), c45421f.eOF.mo60613TB());
            c37091y = C37091y.AUy;
            c8901a.mo20314SW();
            return new C42161e(a);
        }
        a = null;
        c37091y = C37091y.AUy;
        c8901a.mo20314SW();
        return new C42161e(a);
    }
}
