package com.tencent.p177mm.plugin.collect.reward.p366a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40560pu;
import com.tencent.p177mm.protocal.protobuf.C46574pv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.collect.reward.a.g */
public final class C20269g extends C33863a {
    private final String TAG = "MicroMsg.NetSceneQrRewardSetCode";
    private C7472b ehh;
    private C1202f ehi;
    public C46574pv kDA;

    public C20269g(LinkedList<Integer> linkedList, String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(41048);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40560pu();
        c1196a.fsK = new C46574pv();
        c1196a.fsI = 1562;
        c1196a.uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C40560pu c40560pu = (C40560pu) this.ehh.fsG.fsP;
        c40560pu.vWt = linkedList;
        c40560pu.desc = str;
        c40560pu.vWT = z;
        c40560pu.vWU = z2;
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", str, Boolean.valueOf(z), Boolean.valueOf(z2));
        AppMethodBeat.m2505o(41048);
    }

    public final int getType() {
        return 1562;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(41049);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(41049);
        return a;
    }

    /* renamed from: b */
    public final void mo6954b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41050);
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kDA = (C46574pv) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDA.kCl), this.kDA.kCm);
        if (!(this.kDr || this.kDA.kCl == 0)) {
            this.kDs = true;
        }
        if (!this.kDr && !this.kDs) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_PHOTO_WIDTH_INT_SYNC, Integer.valueOf(this.kDA.vWw));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_ICON_WIDTH_INT_SYNC, Integer.valueOf(this.kDA.vWs));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_DESC_STRING_SYNC, this.kDA.desc);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_LAST_PHOTO_URL_STRING_SYNC, this.kDA.pOy);
            List arrayList = new ArrayList();
            Iterator it = this.kDA.vWt.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Integer) it.next()).intValue()));
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, C5046bo.m7536c(arrayList, ","));
            C7060h.pYm.mo8378a(724, 5, 1, false);
        } else if (this.kDr) {
            C7060h.pYm.mo8378a(724, 7, 1, false);
        } else {
            C7060h.pYm.mo8378a(724, 6, 1, false);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41050);
    }
}
