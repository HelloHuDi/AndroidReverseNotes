package com.tencent.mm.plugin.expt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.b.a.ct;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.expt.e.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class b extends m implements k {
    private f ehi;
    private int lNQ = 0;

    public b(int i) {
        this.lNQ = i;
    }

    public final int getType() {
        return 2738;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(73517);
        this.ehi = fVar;
        try {
            long yz = bo.yz();
            a aVar = new a();
            aVar.fsJ = new aip();
            aVar.fsK = new aiq();
            aVar.uri = "/cgi-bin/mmexptappsvr-bin/getexptconfig";
            aVar.fsI = 2738;
            aVar.fsL = 0;
            aVar.fsM = 0;
            com.tencent.mm.ai.b acD = aVar.acD();
            aip aip = (aip) acD.fsG.fsP;
            aip.Scene = this.lNQ;
            aip.woB = ((Integer) g.RP().Ry().get(ac.a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(0))).intValue();
            List<com.tencent.mm.plugin.expt.d.a> brw = a.bqR().lNF.brw();
            if (brw != null && brw.size() > 0) {
                aip.woC = new LinkedList();
                for (com.tencent.mm.plugin.expt.d.a aVar2 : brw) {
                    zf zfVar = new zf();
                    zfVar.weA = aVar2.field_exptId;
                    zfVar.weB = aVar2.field_groupId;
                    zfVar.weC = aVar2.field_exptSeq;
                    aip.woC.add(zfVar);
                }
                ab.i("MicroMsg.NetSceneGetExpt", "req local exptList [%s] ", Arrays.toString(brw.toArray()));
            }
            h.pYm.a(863, 0, 1, false);
            String str = "MicroMsg.NetSceneGetExpt";
            String str2 = "get expt config scene[%d] lastGetSvrSec[%d] localExptList[%d] cost[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(aip.Scene);
            objArr[1] = Integer.valueOf(aip.woB);
            objArr[2] = Integer.valueOf(aip.woC != null ? aip.woC.size() : 0);
            objArr[3] = Long.valueOf(bo.az(yz));
            ab.i(str, str2, objArr);
            int a = a(eVar, acD, this);
            AppMethodBeat.o(73517);
            return a;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSceneGetExpt", e, "get expt error", new Object[0]);
            AppMethodBeat.o(73517);
            return -1;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(73518);
        ab.i("MicroMsg.NetSceneGetExpt", "get expt on gy end. errType[%d] erroCode[%d] errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            aiq aiq = (aiq) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
            if (aiq != null) {
                if (aiq.getBaseResponse().Ret != 0) {
                    ab.w("MicroMsg.NetSceneGetExpt", "get expt error. resp baseResp [%d] [%s]", Integer.valueOf(aiq.getBaseResponse().Ret), aiq.getBaseResponse().ErrMsg);
                    h.pYm.a(863, 2, 1, false);
                } else {
                    Object obj;
                    int i4;
                    int i5;
                    long yz = bo.yz();
                    vb(aiq.woD);
                    int i6 = aiq.woE;
                    g.RP().Ry().set(ac.a.USERINFO_GET_EXPT_INTERVAL_SEC_INT, Integer.valueOf(i6));
                    if (aiq.woH == 1) {
                        h.pYm.a(863, 7, 1, false);
                        long yz2 = bo.yz();
                        a bqR = a.bqR();
                        int brt = bqR.lNF.brt();
                        int brt2 = bqR.lNG.brt();
                        ab.i("MicroMsg.ExptService", "delete all expt count[%d] map count[%d]", Integer.valueOf(brt), Integer.valueOf(brt2));
                        bqR.bqQ();
                        if (c.bru().brv()) {
                            as brs = c.brs();
                            if (brs != null) {
                                brs.clear().commit();
                            }
                        }
                        ab.i("MicroMsg.NetSceneGetExpt", "check need del all expt count[%d] cost[%d]", Integer.valueOf(brt), Long.valueOf(bo.az(yz2)));
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    List<Integer> list = aiq.woF;
                    if (list == null || list.size() <= 0) {
                        i4 = 0;
                    } else {
                        ab.i("MicroMsg.NetSceneGetExpt", "delete expt [%s]", Arrays.toString(list.toArray()));
                        for (Integer num : list) {
                            com.tencent.mm.plugin.expt.d.a uZ = a.bqR().uZ(num.intValue());
                            if (uZ != null && uZ.bro()) {
                                linkedList2.add(num);
                            }
                        }
                        i4 = a.bqR().bB(list);
                    }
                    LinkedList<zf> linkedList3 = aiq.woG;
                    if (linkedList3 == null || linkedList3.size() <= 0) {
                        i5 = 0;
                    } else {
                        LinkedList linkedList4 = new LinkedList();
                        ct ctVar = new ct();
                        for (zf zfVar : linkedList3) {
                            com.tencent.mm.plugin.expt.d.a aVar = new com.tencent.mm.plugin.expt.d.a();
                            aVar.La(zfVar.weD);
                            if (!(aVar.field_exptId == zfVar.weA && aVar.field_groupId == zfVar.weB && aVar.field_exptSeq == zfVar.weC)) {
                                ab.w("MicroMsg.NetSceneGetExpt", "expt item proto[%d %d %d] is different expt content[%d %d %d]", Integer.valueOf(zfVar.weA), Integer.valueOf(zfVar.weB), Integer.valueOf(zfVar.weC), Integer.valueOf(aVar.field_exptId), Integer.valueOf(aVar.field_groupId), Integer.valueOf(aVar.field_exptSeq));
                                h.pYm.a(863, 6, 1, false);
                            }
                            linkedList4.add(aVar);
                            ab.i("MicroMsg.NetSceneGetExpt", "get expt item [%s]", aVar.toString());
                            if (aVar.bro()) {
                                linkedList.add(aVar);
                            }
                            ctVar.dig = (long) aVar.field_exptId;
                            ctVar.dih = (long) aVar.field_groupId;
                            ctVar.dii = (long) aVar.field_exptSeq;
                            ctVar.ajK();
                        }
                        i5 = a.bqR().bA(linkedList4);
                    }
                    if (obj != null || i4 > 0 || i5 > 0) {
                        a.bqR().bqS();
                    }
                    a.bqR();
                    a.a(linkedList, aiq.vHk, linkedList2);
                    h.pYm.a(863, 1, 1, false);
                    String str2 = "MicroMsg.NetSceneGetExpt";
                    String str3 = "update expt svrTime:%d interval:%d exptFlag:%d  deleteCount:[svr:%d local:%d] replaceCount:[svr:%d local:%d] cost[%d]";
                    Object[] objArr = new Object[8];
                    objArr[0] = Integer.valueOf(aiq.woD);
                    objArr[1] = Integer.valueOf(i6);
                    objArr[2] = Integer.valueOf(aiq.woH);
                    objArr[3] = Integer.valueOf(list != null ? list.size() : 0);
                    objArr[4] = Integer.valueOf(i4);
                    objArr[5] = Integer.valueOf(linkedList3 != null ? linkedList3.size() : 0);
                    objArr[6] = Integer.valueOf(i5);
                    objArr[7] = Long.valueOf(bo.az(yz));
                    ab.i(str2, str3, objArr);
                }
            }
        } else {
            h.pYm.a(863, 2, 1, false);
            ab.w("MicroMsg.NetSceneGetExpt", "get expt error");
            vb((int) bo.anT());
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(73518);
    }

    private static void vb(int i) {
        AppMethodBeat.i(73519);
        int anT = (int) bo.anT();
        if (anT > i) {
            g.RP().Ry().set(ac.a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(anT));
            AppMethodBeat.o(73519);
            return;
        }
        g.RP().Ry().set(ac.a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(i));
        AppMethodBeat.o(73519);
    }
}
