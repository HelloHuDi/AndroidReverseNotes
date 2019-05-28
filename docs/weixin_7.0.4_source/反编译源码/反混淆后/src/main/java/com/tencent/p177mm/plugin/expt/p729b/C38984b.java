package com.tencent.p177mm.plugin.expt.p729b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p232b.p233a.C26291ct;
import com.tencent.p177mm.plugin.expt.p1257e.C27892c;
import com.tencent.p177mm.plugin.expt.p396d.C7503a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C35969zf;
import com.tencent.p177mm.protocal.protobuf.aip;
import com.tencent.p177mm.protocal.protobuf.aiq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.expt.b.b */
public final class C38984b extends C1207m implements C1918k {
    private C1202f ehi;
    private int lNQ = 0;

    public C38984b(int i) {
        this.lNQ = i;
    }

    public final int getType() {
        return 2738;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(73517);
        this.ehi = c1202f;
        try {
            long yz = C5046bo.m7588yz();
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new aip();
            c1196a.fsK = new aiq();
            c1196a.uri = "/cgi-bin/mmexptappsvr-bin/getexptconfig";
            c1196a.fsI = 2738;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            C7472b acD = c1196a.acD();
            aip aip = (aip) acD.fsG.fsP;
            aip.Scene = this.lNQ;
            aip.woB = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(0))).intValue();
            List<C7503a> brw = C45898a.bqR().lNF.brw();
            if (brw != null && brw.size() > 0) {
                aip.woC = new LinkedList();
                for (C7503a c7503a : brw) {
                    C35969zf c35969zf = new C35969zf();
                    c35969zf.weA = c7503a.field_exptId;
                    c35969zf.weB = c7503a.field_groupId;
                    c35969zf.weC = c7503a.field_exptSeq;
                    aip.woC.add(c35969zf);
                }
                C4990ab.m7417i("MicroMsg.NetSceneGetExpt", "req local exptList [%s] ", Arrays.toString(brw.toArray()));
            }
            C7060h.pYm.mo8378a(863, 0, 1, false);
            String str = "MicroMsg.NetSceneGetExpt";
            String str2 = "get expt config scene[%d] lastGetSvrSec[%d] localExptList[%d] cost[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(aip.Scene);
            objArr[1] = Integer.valueOf(aip.woB);
            objArr[2] = Integer.valueOf(aip.woC != null ? aip.woC.size() : 0);
            objArr[3] = Long.valueOf(C5046bo.m7525az(yz));
            C4990ab.m7417i(str, str2, objArr);
            int a = mo4457a(c1902e, acD, this);
            AppMethodBeat.m2505o(73517);
            return a;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetExpt", e, "get expt error", new Object[0]);
            AppMethodBeat.m2505o(73517);
            return -1;
        }
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(73518);
        C4990ab.m7417i("MicroMsg.NetSceneGetExpt", "get expt on gy end. errType[%d] erroCode[%d] errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            aiq aiq = (aiq) ((C7472b) c1929q).fsH.fsP;
            if (aiq != null) {
                if (aiq.getBaseResponse().Ret != 0) {
                    C4990ab.m7421w("MicroMsg.NetSceneGetExpt", "get expt error. resp baseResp [%d] [%s]", Integer.valueOf(aiq.getBaseResponse().Ret), aiq.getBaseResponse().ErrMsg);
                    C7060h.pYm.mo8378a(863, 2, 1, false);
                } else {
                    Object obj;
                    int i4;
                    int i5;
                    long yz = C5046bo.m7588yz();
                    C38984b.m66224vb(aiq.woD);
                    int i6 = aiq.woE;
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GET_EXPT_INTERVAL_SEC_INT, Integer.valueOf(i6));
                    if (aiq.woH == 1) {
                        C7060h.pYm.mo8378a(863, 7, 1, false);
                        long yz2 = C5046bo.m7588yz();
                        C45898a bqR = C45898a.bqR();
                        int brt = bqR.lNF.brt();
                        int brt2 = bqR.lNG.brt();
                        C4990ab.m7417i("MicroMsg.ExptService", "delete all expt count[%d] map count[%d]", Integer.valueOf(brt), Integer.valueOf(brt2));
                        bqR.bqQ();
                        if (C27892c.bru().brv()) {
                            C5018as brs = C27892c.brs();
                            if (brs != null) {
                                brs.clear().commit();
                            }
                        }
                        C4990ab.m7417i("MicroMsg.NetSceneGetExpt", "check need del all expt count[%d] cost[%d]", Integer.valueOf(brt), Long.valueOf(C5046bo.m7525az(yz2)));
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
                        C4990ab.m7417i("MicroMsg.NetSceneGetExpt", "delete expt [%s]", Arrays.toString(list.toArray()));
                        for (Integer num : list) {
                            C7503a uZ = C45898a.bqR().mo73729uZ(num.intValue());
                            if (uZ != null && uZ.bro()) {
                                linkedList2.add(num);
                            }
                        }
                        i4 = C45898a.bqR().mo73726bB(list);
                    }
                    LinkedList<C35969zf> linkedList3 = aiq.woG;
                    if (linkedList3 == null || linkedList3.size() <= 0) {
                        i5 = 0;
                    } else {
                        LinkedList linkedList4 = new LinkedList();
                        C26291ct c26291ct = new C26291ct();
                        for (C35969zf c35969zf : linkedList3) {
                            C7503a c7503a = new C7503a();
                            c7503a.mo16726La(c35969zf.weD);
                            if (!(c7503a.field_exptId == c35969zf.weA && c7503a.field_groupId == c35969zf.weB && c7503a.field_exptSeq == c35969zf.weC)) {
                                C4990ab.m7421w("MicroMsg.NetSceneGetExpt", "expt item proto[%d %d %d] is different expt content[%d %d %d]", Integer.valueOf(c35969zf.weA), Integer.valueOf(c35969zf.weB), Integer.valueOf(c35969zf.weC), Integer.valueOf(c7503a.field_exptId), Integer.valueOf(c7503a.field_groupId), Integer.valueOf(c7503a.field_exptSeq));
                                C7060h.pYm.mo8378a(863, 6, 1, false);
                            }
                            linkedList4.add(c7503a);
                            C4990ab.m7417i("MicroMsg.NetSceneGetExpt", "get expt item [%s]", c7503a.toString());
                            if (c7503a.bro()) {
                                linkedList.add(c7503a);
                            }
                            c26291ct.dig = (long) c7503a.field_exptId;
                            c26291ct.dih = (long) c7503a.field_groupId;
                            c26291ct.dii = (long) c7503a.field_exptSeq;
                            c26291ct.ajK();
                        }
                        i5 = C45898a.bqR().mo73725bA(linkedList4);
                    }
                    if (obj != null || i4 > 0 || i5 > 0) {
                        C45898a.bqR().bqS();
                    }
                    C45898a.bqR();
                    C45898a.m85074a(linkedList, aiq.vHk, linkedList2);
                    C7060h.pYm.mo8378a(863, 1, 1, false);
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
                    objArr[7] = Long.valueOf(C5046bo.m7525az(yz));
                    C4990ab.m7417i(str2, str3, objArr);
                }
            }
        } else {
            C7060h.pYm.mo8378a(863, 2, 1, false);
            C4990ab.m7420w("MicroMsg.NetSceneGetExpt", "get expt error");
            C38984b.m66224vb((int) C5046bo.anT());
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(73518);
    }

    /* renamed from: vb */
    private static void m66224vb(int i) {
        AppMethodBeat.m2504i(73519);
        int anT = (int) C5046bo.anT();
        if (anT > i) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(anT));
            AppMethodBeat.m2505o(73519);
            return;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(i));
        AppMethodBeat.m2505o(73519);
    }
}
