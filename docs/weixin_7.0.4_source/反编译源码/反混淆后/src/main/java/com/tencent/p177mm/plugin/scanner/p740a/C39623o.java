package com.tencent.p177mm.plugin.scanner.p740a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C37691an;
import com.tencent.p177mm.p230g.p231a.C37774nq;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.plugin.p543u.p544a.C35336b;
import com.tencent.p177mm.plugin.p543u.p544a.C35336b.C353352;
import com.tencent.p177mm.plugin.p543u.p544a.C35336b.C4254a;
import com.tencent.p177mm.plugin.scanner.C43488e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.scanner.a.o */
public final class C39623o {
    public C4884c qah = new C70651();
    public C4884c qai = new C131172();
    C4254a qaj = new C70663();

    /* renamed from: com.tencent.mm.plugin.scanner.a.o$1 */
    class C70651 extends C4884c<C45347np> {
        C70651() {
            AppMethodBeat.m2504i(80877);
            this.xxI = C45347np.class.getName().hashCode();
            AppMethodBeat.m2505o(80877);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(80878);
            boolean h = C39623o.this.mo62578h((C45347np) c4883b);
            AppMethodBeat.m2505o(80878);
            return h;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.a.o$3 */
    class C70663 implements C4254a {
        C70663() {
        }

        /* renamed from: a */
        public final void mo9237a(String str, String str2, byte[] bArr, int i, int i2) {
            AppMethodBeat.m2504i(80881);
            C4990ab.m7417i("MicroMsg.RecogQBarOfImageFileListener", "result: %s, codeType: %s, codeVersion: %s, filePath:%s", str2, Integer.valueOf(i), Integer.valueOf(i2), str);
            C21682m.pZK.bHT();
            C18346nr c18346nr = new C18346nr();
            c18346nr.cJX.filePath = str;
            c18346nr.cJX.result = str2;
            c18346nr.cJX.cvn = i;
            c18346nr.cJX.cvo = i2;
            C4879a.xxA.mo10055m(c18346nr);
            AppMethodBeat.m2505o(80881);
        }

        /* renamed from: Vv */
        public final void mo9236Vv(String str) {
            AppMethodBeat.m2504i(80882);
            C4990ab.m7417i("MicroMsg.RecogQBarOfImageFileListener", "result(failed): %s", str);
            C37774nq c37774nq = new C37774nq();
            c37774nq.cJW.filePath = str;
            C4879a.xxA.mo10055m(c37774nq);
            AppMethodBeat.m2505o(80882);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.a.o$2 */
    class C131172 extends C4884c<C37691an> {
        C131172() {
            AppMethodBeat.m2504i(80879);
            this.xxI = C37691an.class.getName().hashCode();
            AppMethodBeat.m2505o(80879);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(80880);
            boolean h = C39623o.this.mo62578h((C37691an) c4883b);
            AppMethodBeat.m2505o(80880);
            return h;
        }
    }

    public C39623o() {
        AppMethodBeat.m2504i(80883);
        AppMethodBeat.m2505o(80883);
    }

    /* renamed from: h */
    public final boolean mo62578h(C4883b c4883b) {
        AppMethodBeat.m2504i(80884);
        if (c4883b == null) {
            AppMethodBeat.m2505o(80884);
        } else {
            if (c4883b instanceof C45347np) {
                C21682m.pZK.reset();
                C21682m.pZK.mo37152BU(C21682m.pZJ);
                C45347np c45347np = (C45347np) c4883b;
                C43488e.cgy().pYI.mo56082a(c45347np.cJU.filePath, this.qaj, c45347np.cJU.cJV);
            } else if (c4883b instanceof C37691an) {
                C21682m.pZK.bHT();
                C37691an c37691an = (C37691an) c4883b;
                C35336b c35336b = C43488e.cgy().pYI;
                String str = c37691an.ctC.filePath;
                C4990ab.m7417i("MicroMsg.FileScanQueueService", "cancelDecode, fileUri: %s, callback: %x", str, Integer.valueOf(this.qaj.hashCode()));
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.FileScanQueueService", "cancel failed, uri is null or nil");
                } else {
                    c35336b.iGP.post(new C353352(str, r2));
                }
            }
            AppMethodBeat.m2505o(80884);
        }
        return false;
    }
}
