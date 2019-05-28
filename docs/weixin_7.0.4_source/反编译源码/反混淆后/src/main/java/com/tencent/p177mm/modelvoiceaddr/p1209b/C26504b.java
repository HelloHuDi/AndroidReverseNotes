package com.tencent.p177mm.modelvoiceaddr.p1209b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.modelvoiceaddr.b.b */
public final class C26504b implements C1202f {

    /* renamed from: com.tencent.mm.modelvoiceaddr.b.b$1 */
    public class C265031 implements Runnable {
        final /* synthetic */ List gcs;
        final /* synthetic */ String gct;
        final /* synthetic */ String gcu;

        public C265031(List list, String str, String str2) {
            this.gcs = list;
            this.gct = str;
            this.gcu = str2;
        }

        public final void run() {
            AppMethodBeat.m2504i(116799);
            LinkedList linkedList = new LinkedList();
            for (String alV : this.gcs) {
                linkedList.add(new bts().alV(alV));
                C4990ab.m7411d("MicroMsg.NewVoiceInputReportManager", "mVoiceIdSet Id = %s", alV);
            }
            bts alV2 = new bts().alV(this.gct);
            bts alV3 = new bts().alV(this.gcu);
            C1720g.m3540Rg().mo14539a(228, C26504b.this);
            C1720g.m3540Rg().mo14541a(new C18724a(linkedList.size(), linkedList, alV2, alV3), 0);
            AppMethodBeat.m2505o(116799);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(116800);
        C1720g.m3540Rg().mo14546b(228, (C1202f) this);
        if (c1207m instanceof C18724a) {
            C4990ab.m7417i("MicroMsg.NewVoiceInputReportManager", "onSceneEnd errType = %s, errCode = %s, errMsg = %s ", Integer.valueOf(i), Integer.valueOf(i2), str);
        }
        AppMethodBeat.m2505o(116800);
    }
}
