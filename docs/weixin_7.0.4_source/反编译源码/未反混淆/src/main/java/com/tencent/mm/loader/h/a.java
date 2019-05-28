package com.tencent.mm.loader.h;

import com.tencent.mm.loader.b.a.c;
import java.io.OutputStream;

public final class a extends f<String> {
    public String bqF;
    private com.tencent.mm.loader.h.f.a eRJ;

    private a(String str, String str2, com.tencent.mm.loader.h.f.a<String> aVar) {
        super(str);
        this.bqF = str2;
        this.eRJ = aVar;
    }

    public static a S(final String str, String str2) {
        return new a(str, str2, new com.tencent.mm.loader.h.f.a<String>() {
            public final /* synthetic */ com.tencent.mm.loader.h.b.a TX() {
                return com.tencent.mm.loader.h.b.a.lT(str);
            }
        });
    }

    public final void a(OutputStream outputStream) {
        c cVar = c.ePl;
        c.a((String) this.data, outputStream);
    }

    public final com.tencent.mm.loader.h.b.a TW() {
        return this.eRJ.TX();
    }
}
