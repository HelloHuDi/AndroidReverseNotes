package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class b implements f {

    /* renamed from: com.tencent.mm.modelvoiceaddr.b.b$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ List gcs;
        final /* synthetic */ String gct;
        final /* synthetic */ String gcu;

        public AnonymousClass1(List list, String str, String str2) {
            this.gcs = list;
            this.gct = str;
            this.gcu = str2;
        }

        public final void run() {
            AppMethodBeat.i(116799);
            LinkedList linkedList = new LinkedList();
            for (String alV : this.gcs) {
                linkedList.add(new bts().alV(alV));
                ab.d("MicroMsg.NewVoiceInputReportManager", "mVoiceIdSet Id = %s", alV);
            }
            bts alV2 = new bts().alV(this.gct);
            bts alV3 = new bts().alV(this.gcu);
            g.Rg().a(228, b.this);
            g.Rg().a(new a(linkedList.size(), linkedList, alV2, alV3), 0);
            AppMethodBeat.o(116799);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(116800);
        g.Rg().b(228, (f) this);
        if (mVar instanceof a) {
            ab.i("MicroMsg.NewVoiceInputReportManager", "onSceneEnd errType = %s, errCode = %s, errMsg = %s ", Integer.valueOf(i), Integer.valueOf(i2), str);
        }
        AppMethodBeat.o(116800);
    }
}
