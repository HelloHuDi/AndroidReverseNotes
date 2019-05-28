package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.cok;
import com.tencent.p177mm.protocal.protobuf.cpv;
import com.tencent.p177mm.protocal.protobuf.cpw;
import com.tencent.p177mm.protocal.protobuf.cpy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voip.model.a.h */
public final class C43729h extends C22456n<cpv, cpw> {

    /* renamed from: com.tencent.mm.plugin.voip.model.a.h$1 */
    class C294931 implements C1202f {
        C294931() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4719);
            C46317a.Logi("MicroMsg.Voip.Redirect", "Redirect response:" + i + " errCode:" + i2 + " status:" + C43729h.this.sPK.mStatus);
            if (i2 != 0) {
                C46317a.Loge("MicroMsg.Voip.Redirect", " redirect response with error code:".concat(String.valueOf(i2)));
                AppMethodBeat.m2505o(4719);
                return;
            }
            cpw cpw = (cpw) C43729h.this.cKx();
            C46317a.Logi("MicroMsg.Voip.Redirect", "room " + cpw.wem + " member " + cpw.wPb + " key " + cpw.wen + " relay addr cnt " + cpw.xnR + " RedirectThreshold " + cpw.xnW + " RedirectDecision " + cpw.xnX);
            cok cok = new cok();
            cok cok2 = new cok();
            cok cok3 = new cok();
            cok.xlZ = cpw.xnR;
            cok.xma = cpw.xnS;
            cok2.xlZ = cpw.xnT;
            cok2.xma = cpw.xnU;
            cok3.xlZ = cpw.xnV;
            cok3.xma = cpw.xmC;
            C43729h.this.sPK.sPp.mo63274a(cok, cok2, cok3, cpw.xnW, cpw.xnX);
            AppMethodBeat.m2505o(4719);
        }
    }

    public C43729h(int i, long j, int i2, int i3, int i4, int[] iArr) {
        int i5 = 0;
        AppMethodBeat.m2504i(4720);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cpv();
        c1196a.fsK = new cpw();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipRedirect";
        this.ehh = c1196a.acD();
        cpv cpv = (cpv) this.ehh.fsG.fsP;
        cpv.wem = i;
        cpv.wen = j;
        cpv.wPb = i2;
        cpv.xnN = i3;
        cpv.xnO = i4;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            cpy cpy = new cpy();
            int i8 = i6 + 1;
            cpy.xnY = iArr[i6];
            i6 = i8 + 1;
            cpy.xnZ = iArr[i8];
            i8 = i6 + 1;
            cpy.xoa = iArr[i6];
            int i9 = i8 + 1;
            cpy.xob = iArr[i8];
            i6 = i9 + 1;
            cpy.xoc = iArr[i9];
            cpv.xnP.add(cpy);
        }
        if (this.sPK.sPp.sVH.sQF != 0) {
            i5 = (int) ((System.currentTimeMillis() - this.sPK.sPp.sVH.sQF) / 1000);
        }
        cpv.xnQ = i5;
        AppMethodBeat.m2505o(4720);
    }

    public final int getType() {
        return 678;
    }

    /* renamed from: fW */
    public final void mo26283fW(int i, int i2) {
        AppMethodBeat.m2504i(4721);
        if (i == 0 && i2 == 0) {
            if (((cpw) this.ehh.fsH.fsP) != null) {
                C4990ab.m7417i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", Integer.valueOf(((cpw) this.ehh.fsH.fsP).wem), Long.valueOf(((cpw) this.ehh.fsH.fsP).wen), Integer.valueOf(((cpw) this.ehh.fsH.fsP).wPb));
            }
            AppMethodBeat.m2505o(4721);
            return;
        }
        C4990ab.m7416i("MicroMsg.Voip.Redirect", "Redirect error");
        AppMethodBeat.m2505o(4721);
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4722);
        C294931 c294931 = new C294931();
        AppMethodBeat.m2505o(4722);
        return c294931;
    }
}
