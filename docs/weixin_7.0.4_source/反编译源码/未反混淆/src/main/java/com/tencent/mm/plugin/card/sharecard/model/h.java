package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.List;

public final class h extends m implements k {
    private final b ehh;
    private f ehi;

    public h() {
        AppMethodBeat.i(88036);
        a aVar = new a();
        aVar.fsJ = new byz();
        aVar.fsK = new bza();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecardsync";
        this.ehh = aVar.acD();
        ((byz) this.ehh.fsG.fsP).wYg = ((Long) g.RP().Ry().get(ac.a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(0))).longValue();
        AppMethodBeat.o(88036);
    }

    public final int getType() {
        return 906;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(88037);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(88037);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(88038);
        ab.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(906), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            bza bza = (bza) this.ehh.fsH.fsP;
            List<byy> list = bza.fjr == null ? null : bza.fjr;
            String str2 = "MicroMsg.NetSceneShareCardSync";
            String str3 = "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(bza.wYh);
            objArr[2] = Long.valueOf(bza.wYf);
            ab.i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                ab.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
                com.tencent.mm.plugin.card.sharecard.a.a bbd = am.bbd();
                ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", Boolean.TRUE);
                synchronized (bbd.eMl) {
                    try {
                        bbd.kaA.addAll(bbd.kaB);
                        bbd.kaB.clear();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(88038);
                        }
                    }
                }
                bbd.bai();
            } else {
                int i4 = 0;
                for (byy b : list) {
                    int i5;
                    if (b(b)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                ab.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", Integer.valueOf(i4));
                am.bbd().bai();
            }
            g.RP().Ry().set(ac.a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(bza.wYf));
            am.bbd().kfq = bza.kfq;
            if (bza.wYh > 0) {
                ab.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", Integer.valueOf(bza.wYh));
                com.tencent.mm.plugin.card.sharecard.a.a bbd2 = am.bbd();
                bbd2.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(87971);
                        g.RO().eJo.a(new h(), 0);
                        AppMethodBeat.o(87971);
                    }
                });
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(88038);
            return;
        }
        ab.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(88038);
    }

    private static boolean b(byy byy) {
        AppMethodBeat.i(88039);
        if (byy == null) {
            ab.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
            AppMethodBeat.o(88039);
            return false;
        }
        ab.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", byy.cMC, Long.valueOf(byy.wYf));
        try {
            ab.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", Integer.valueOf(byy.kfy));
            switch (byy.kfy) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                    am.bbd().a(byy);
                    break;
                case 6:
                    com.tencent.mm.plugin.card.sharecard.a.a bbd = am.bbd();
                    if (byy != null) {
                        com.tencent.mm.plugin.card.base.b GK = am.bbe().GK(byy.cMC);
                        am.bbe().GJ(byy.cMC);
                        ab.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + byy.cMC);
                        if (GK != null) {
                            com.tencent.mm.plugin.card.sharecard.a.b.a(ah.getContext(), GK);
                        } else {
                            ab.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
                        }
                        bbd.aVU();
                        break;
                    }
                    ab.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
                    break;
                default:
                    ab.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", Integer.valueOf(byy.kfy));
                    AppMethodBeat.o(88039);
                    return false;
            }
            if (!(byy.kfy == 0 || byy.kfy == 5)) {
                String str = (String) g.RP().Ry().get(ac.a.USERINFO_CARD_MSG_CARD_ID_STRING_SYNC, (Object) "");
                boolean booleanValue = ((Boolean) g.RP().Ry().get(ac.a.USERINFO_CARD_MSG_NEED_CHECK_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                if (booleanValue && !bo.isNullOrNil(str) && str.equals(byy.cMC)) {
                    ab.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
                    com.tencent.mm.plugin.card.b.k.baK();
                } else if (booleanValue) {
                    ab.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
                } else {
                    ab.i("MicroMsg.NetSceneShareCardSync", "need check is false");
                }
            }
            AppMethodBeat.o(88039);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", e.getMessage());
            AppMethodBeat.o(88039);
            return false;
        }
    }
}
