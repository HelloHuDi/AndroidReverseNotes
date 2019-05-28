package com.tencent.mm.loader.h;

import com.tencent.mm.loader.b.a.c;
import com.tencent.mm.loader.h.f.a;
import java.io.OutputStream;

public final class b extends f<byte[]> {
    public String bqF;
    private a eRJ;

    /* renamed from: com.tencent.mm.loader.h.b$1 */
    public static class AnonymousClass1 implements a<byte[]> {
        final /* synthetic */ byte[] eRK;

        public AnonymousClass1(byte[] bArr) {
            this.eRK = bArr;
        }

        public final /* synthetic */ com.tencent.mm.loader.h.b.a TX() {
            return com.tencent.mm.loader.h.b.a.L(this.eRK);
        }
    }

    public b(byte[] bArr, String str, a<byte[]> aVar) {
        super(bArr);
        this.bqF = str;
        this.eRJ = aVar;
    }

    public final void a(OutputStream outputStream) {
        c cVar = c.ePl;
        c.a((byte[]) this.data, outputStream);
    }

    public final com.tencent.mm.loader.h.b.a TW() {
        return this.eRJ.TX();
    }
}
