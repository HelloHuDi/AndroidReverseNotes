package com.tencent.p177mm.plugin.collect.reward.p366a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40558pe;
import com.tencent.p177mm.protocal.protobuf.C46573pd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.collect.reward.a.b */
public final class C36753b extends C33863a {
    private final String TAG = "MicroMsg.NetSceneQrRewardGetCode";
    private C7472b ehh;
    private C1202f ehi;
    public C40558pe kDu;
    public boolean kDv;

    public C36753b(boolean z) {
        AppMethodBeat.m2504i(41034);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46573pd();
        c1196a.fsK = new C40558pe();
        c1196a.fsI = 1323;
        c1196a.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((C46573pd) this.ehh.fsG.fsP).vWp = z;
        this.kDv = z;
        AppMethodBeat.m2505o(41034);
    }

    public final int getType() {
        return 1323;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(41035);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(41035);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bgQ() {
        return false;
    }

    /* renamed from: b */
    public final void mo6954b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41036);
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kDu = (C40558pe) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDu.kCl), this.kDu.kCm);
        if (!(this.kDr || this.kDu.kCl == 0)) {
            this.kDs = true;
        }
        if (!this.kDr && !this.kDs) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_PHOTO_WIDTH_INT_SYNC, Integer.valueOf(this.kDu.vWw));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_ICON_WIDTH_INT_SYNC, Integer.valueOf(this.kDu.vWs));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_DESC_STRING_SYNC, this.kDu.desc);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, this.kDu.jMS);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_MAX_AMT_INT_SYNC, Integer.valueOf(this.kDu.vWv));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_BOTTOM_STR_STRING_SYNC, this.kDu.kdE);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_BOTTOM_URL_STRING_SYNC, this.kDu.vWu);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_LAST_PHOTO_URL_STRING_SYNC, this.kDu.pOy);
            List arrayList = new ArrayList();
            Iterator it = this.kDu.vWt.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Integer) it.next()).intValue()));
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, C5046bo.m7536c(arrayList, ","));
            C7060h.pYm.mo8378a(724, 2, 1, false);
        } else if (this.kDr) {
            C7060h.pYm.mo8378a(724, 4, 1, false);
        } else {
            C7060h.pYm.mo8378a(724, 3, 1, false);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41036);
    }
}
