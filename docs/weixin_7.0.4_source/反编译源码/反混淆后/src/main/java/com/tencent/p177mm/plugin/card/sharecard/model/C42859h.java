package com.tencent.p177mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p352b.C2752k;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42855a;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42855a.C337732;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.protocal.protobuf.byy;
import com.tencent.p177mm.protocal.protobuf.byz;
import com.tencent.p177mm.protocal.protobuf.bza;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.sharecard.model.h */
public final class C42859h extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C42859h() {
        AppMethodBeat.m2504i(88036);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new byz();
        c1196a.fsK = new bza();
        c1196a.uri = "/cgi-bin/micromsg-bin/sharecardsync";
        this.ehh = c1196a.acD();
        ((byz) this.ehh.fsG.fsP).wYg = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(0))).longValue();
        AppMethodBeat.m2505o(88036);
    }

    public final int getType() {
        return 906;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(88037);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(88037);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(88038);
        C4990ab.m7417i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(906), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            bza bza = (bza) this.ehh.fsH.fsP;
            List<byy> list = bza.fjr == null ? null : bza.fjr;
            String str2 = "MicroMsg.NetSceneShareCardSync";
            String str3 = "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(bza.wYh);
            objArr[2] = Long.valueOf(bza.wYf);
            C4990ab.m7417i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                C4990ab.m7416i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
                C42855a bbd = C42852am.bbd();
                C4990ab.m7417i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", Boolean.TRUE);
                synchronized (bbd.eMl) {
                    try {
                        bbd.kaA.addAll(bbd.kaB);
                        bbd.kaB.clear();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(88038);
                        }
                    }
                }
                bbd.bai();
            } else {
                int i4 = 0;
                for (byy b : list) {
                    int i5;
                    if (C42859h.m76096b(b)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                C4990ab.m7417i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", Integer.valueOf(i4));
                C42852am.bbd().bai();
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(bza.wYf));
            C42852am.bbd().kfq = bza.kfq;
            if (bza.wYh > 0) {
                C4990ab.m7417i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", Integer.valueOf(bza.wYh));
                C42855a bbd2 = C42852am.bbd();
                bbd2.mHandler.post(new C337732());
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(88038);
            return;
        }
        C4990ab.m7413e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(88038);
    }

    /* renamed from: b */
    private static boolean m76096b(byy byy) {
        AppMethodBeat.m2504i(88039);
        if (byy == null) {
            C4990ab.m7412e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
            AppMethodBeat.m2505o(88039);
            return false;
        }
        C4990ab.m7417i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", byy.cMC, Long.valueOf(byy.wYf));
        try {
            C4990ab.m7417i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", Integer.valueOf(byy.kfy));
            switch (byy.kfy) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                    C42852am.bbd().mo68359a(byy);
                    break;
                case 6:
                    C42855a bbd = C42852am.bbd();
                    if (byy != null) {
                        C42837b GK = C42852am.bbe().mo35397GK(byy.cMC);
                        C42852am.bbe().mo35396GJ(byy.cMC);
                        C4990ab.m7416i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + byy.cMC);
                        if (GK != null) {
                            C42856b.m76079a(C4996ah.getContext(), GK);
                        } else {
                            C4990ab.m7412e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
                        }
                        bbd.aVU();
                        break;
                    }
                    C4990ab.m7412e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
                    break;
                default:
                    C4990ab.m7413e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", Integer.valueOf(byy.kfy));
                    AppMethodBeat.m2505o(88039);
                    return false;
            }
            if (!(byy.kfy == 0 || byy.kfy == 5)) {
                String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_MSG_CARD_ID_STRING_SYNC, (Object) "");
                boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_MSG_NEED_CHECK_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                if (booleanValue && !C5046bo.isNullOrNil(str) && str.equals(byy.cMC)) {
                    C4990ab.m7416i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
                    C2752k.baK();
                } else if (booleanValue) {
                    C4990ab.m7416i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
                } else {
                    C4990ab.m7416i("MicroMsg.NetSceneShareCardSync", "need check is false");
                }
            }
            AppMethodBeat.m2505o(88039);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", e.getMessage());
            AppMethodBeat.m2505o(88039);
            return false;
        }
    }
}
