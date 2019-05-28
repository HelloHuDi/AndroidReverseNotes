package com.tencent.d.a;

import com.tencent.d.e.a.b.a;
import com.tencent.d.e.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {

    /* renamed from: com.tencent.d.a.d$1 */
    public static class AnonymousClass1 implements c {
        final /* synthetic */ b ArF;
        final /* synthetic */ com.tencent.d.b.c ArG;

        public AnonymousClass1(b bVar, com.tencent.d.b.c cVar) {
            this.ArF = bVar;
            this.ArG = cVar;
        }

        public final void asv() {
            AppMethodBeat.i(114465);
            this.ArF.m(-10, new byte[0]);
            AppMethodBeat.o(114465);
        }

        public final com.tencent.d.e.a.b.d a(String str, String str2, a aVar) {
            AppMethodBeat.i(114466);
            boolean a = d.a(this.ArG, this.ArF, str, str2, aVar);
            com.tencent.d.e.a.b.d dVar = new com.tencent.d.e.a.b.d();
            if (!a) {
                dVar.errorCode = -1;
            }
            AppMethodBeat.o(114466);
            return dVar;
        }

        public final com.tencent.d.e.a.b.c b(String str, String str2, a aVar) {
            AppMethodBeat.i(114467);
            boolean a = d.a(this.ArG, this.ArF, str, str2, aVar);
            com.tencent.d.e.a.b.c cVar = new com.tencent.d.e.a.b.c();
            if (!a) {
                cVar.errCode = -1;
            }
            AppMethodBeat.o(114467);
            return cVar;
        }
    }

    static /* synthetic */ boolean a(com.tencent.d.b.c cVar, b bVar, String str, String str2, a aVar) {
        boolean z = false;
        AppMethodBeat.i(114468);
        byte[] c = cVar.c(str, str2, aVar);
        if (c == null || c.length == 0) {
            bVar.m(-20, new byte[0]);
        } else {
            z = bVar.m(0, c);
        }
        AppMethodBeat.o(114468);
        return z;
    }
}
