package com.tencent.mm.plugin.scanner.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.u.a.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class o {
    public c qah = new c<np>() {
        {
            AppMethodBeat.i(80877);
            this.xxI = np.class.getName().hashCode();
            AppMethodBeat.o(80877);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(80878);
            boolean h = o.this.h((np) bVar);
            AppMethodBeat.o(80878);
            return h;
        }
    };
    public c qai = new c<an>() {
        {
            AppMethodBeat.i(80879);
            this.xxI = an.class.getName().hashCode();
            AppMethodBeat.o(80879);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(80880);
            boolean h = o.this.h((an) bVar);
            AppMethodBeat.o(80880);
            return h;
        }
    };
    a qaj = new a() {
        public final void a(String str, String str2, byte[] bArr, int i, int i2) {
            AppMethodBeat.i(80881);
            ab.i("MicroMsg.RecogQBarOfImageFileListener", "result: %s, codeType: %s, codeVersion: %s, filePath:%s", str2, Integer.valueOf(i), Integer.valueOf(i2), str);
            m.pZK.bHT();
            nr nrVar = new nr();
            nrVar.cJX.filePath = str;
            nrVar.cJX.result = str2;
            nrVar.cJX.cvn = i;
            nrVar.cJX.cvo = i2;
            com.tencent.mm.sdk.b.a.xxA.m(nrVar);
            AppMethodBeat.o(80881);
        }

        public final void Vv(String str) {
            AppMethodBeat.i(80882);
            ab.i("MicroMsg.RecogQBarOfImageFileListener", "result(failed): %s", str);
            nq nqVar = new nq();
            nqVar.cJW.filePath = str;
            com.tencent.mm.sdk.b.a.xxA.m(nqVar);
            AppMethodBeat.o(80882);
        }
    };

    public o() {
        AppMethodBeat.i(80883);
        AppMethodBeat.o(80883);
    }

    public final boolean h(b bVar) {
        AppMethodBeat.i(80884);
        if (bVar == null) {
            AppMethodBeat.o(80884);
        } else {
            if (bVar instanceof np) {
                m.pZK.reset();
                m.pZK.BU(m.pZJ);
                np npVar = (np) bVar;
                e.cgy().pYI.a(npVar.cJU.filePath, this.qaj, npVar.cJU.cJV);
            } else if (bVar instanceof an) {
                m.pZK.bHT();
                an anVar = (an) bVar;
                com.tencent.mm.plugin.u.a.b bVar2 = e.cgy().pYI;
                String str = anVar.ctC.filePath;
                ab.i("MicroMsg.FileScanQueueService", "cancelDecode, fileUri: %s, callback: %x", str, Integer.valueOf(this.qaj.hashCode()));
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.FileScanQueueService", "cancel failed, uri is null or nil");
                } else {
                    bVar2.iGP.post(new com.tencent.mm.plugin.u.a.b.AnonymousClass2(str, r2));
                }
            }
            AppMethodBeat.o(80884);
        }
        return false;
    }
}
