package com.tencent.p177mm.loader.p1197h;

import com.tencent.p177mm.loader.p1197h.C42162f.C42163a;
import com.tencent.p177mm.loader.p1197h.p1199b.C18545a;
import com.tencent.p177mm.loader.p858b.p859a.C9564c;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.loader.h.a */
public final class C32734a extends C42162f<String> {
    public String bqF;
    private C42163a eRJ;

    private C32734a(String str, String str2, C42163a<String> c42163a) {
        super(str);
        this.bqF = str2;
        this.eRJ = c42163a;
    }

    /* renamed from: S */
    public static C32734a m53415S(final String str, String str2) {
        return new C32734a(str, str2, new C42163a<String>() {
            /* renamed from: TX */
            public final /* synthetic */ C18545a mo33802TX() {
                return C18545a.m28857lT(str);
            }
        });
    }

    /* renamed from: a */
    public final void mo33801a(OutputStream outputStream) {
        C9564c c9564c = C9564c.ePl;
        C9564c.m17034a((String) this.data, outputStream);
    }

    /* renamed from: TW */
    public final C18545a mo33800TW() {
        return this.eRJ.mo33802TX();
    }
}
