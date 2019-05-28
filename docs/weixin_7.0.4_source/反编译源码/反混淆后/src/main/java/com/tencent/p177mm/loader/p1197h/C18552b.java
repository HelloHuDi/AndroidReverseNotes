package com.tencent.p177mm.loader.p1197h;

import com.tencent.p177mm.loader.p1197h.C42162f.C42163a;
import com.tencent.p177mm.loader.p1197h.p1199b.C18545a;
import com.tencent.p177mm.loader.p858b.p859a.C9564c;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.loader.h.b */
public final class C18552b extends C42162f<byte[]> {
    public String bqF;
    private C42163a eRJ;

    /* renamed from: com.tencent.mm.loader.h.b$1 */
    public static class C185531 implements C42163a<byte[]> {
        final /* synthetic */ byte[] eRK;

        public C185531(byte[] bArr) {
            this.eRK = bArr;
        }

        /* renamed from: TX */
        public final /* synthetic */ C18545a mo33802TX() {
            return C18545a.m28853L(this.eRK);
        }
    }

    public C18552b(byte[] bArr, String str, C42163a<byte[]> c42163a) {
        super(bArr);
        this.bqF = str;
        this.eRJ = c42163a;
    }

    /* renamed from: a */
    public final void mo33801a(OutputStream outputStream) {
        C9564c c9564c = C9564c.ePl;
        C9564c.m17035a((byte[]) this.data, outputStream);
    }

    /* renamed from: TW */
    public final C18545a mo33800TW() {
        return this.eRJ.mo33802TX();
    }
}
