package com.tencent.mm.modelmulti;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.p;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.jsapi.storage.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.bwl;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.view.d;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class h extends m implements k {
    private static final List<Object> fIl = new ArrayList();
    public long cvx;
    private b ehh;
    private f ehi;
    private final List<bi> fIm = new LinkedList();
    private int fIn = 3;
    private boolean fIo = false;
    private final List<bi> fIp = new ArrayList();
    private bi fIq = null;
    public com.tencent.mm.plugin.messenger.foundation.a.m fIr = null;

    static {
        AppMethodBeat.i(59985);
        AppMethodBeat.o(59985);
    }

    public h(String str, String str2, int i, int i2, Object obj) {
        AppMethodBeat.i(59967);
        ab.d("MicroMsg.NetSceneSendMsg", "dktext :%s", bo.dpG());
        if (!bo.isNullOrNil(str)) {
            bi biVar = new bi();
            biVar.setStatus(1);
            biVar.ju(str);
            biVar.eJ(bf.oC(str));
            biVar.hO(1);
            biVar.setContent(str2);
            biVar.setType(i);
            String a = a(((q) g.K(q.class)).B(biVar), obj, i2);
            if (!bo.isNullOrNil(a)) {
                biVar.ix(a);
                ab.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", biVar.dqJ);
            }
            try {
                this.cvx = ((j) g.K(j.class)).bOr().c(biVar, true);
                if (this.cvx == -1) {
                    e.pXa.a(111, 255, 1, false);
                }
                Assert.assertTrue(this.cvx != -1);
                ab.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.cvx);
            } catch (SQLiteException e) {
                e.pXa.a(111, 255, 1, false);
                AppMethodBeat.o(59967);
                throw e;
            }
        }
        AppMethodBeat.o(59967);
    }

    public h(String str, String str2, int i) {
        AppMethodBeat.i(59968);
        ab.d("MicroMsg.NetSceneSendMsg", "dktext :%s", bo.dpG());
        if (!bo.isNullOrNil(str)) {
            bi biVar = new bi();
            biVar.setStatus(1);
            biVar.ju(str);
            biVar.eJ(bf.oC(str));
            biVar.hO(1);
            biVar.setContent(str2);
            biVar.setType(i);
            String B = ((q) g.K(q.class)).B(biVar);
            if (!bo.isNullOrNil(B)) {
                biVar.ix(B);
                ab.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", biVar.dqJ);
            }
            try {
                this.cvx = ((j) g.K(j.class)).bOr().c(biVar, true);
                if (this.cvx == -1) {
                    e.pXa.a(111, 255, 1, false);
                }
                Assert.assertTrue(this.cvx != -1);
                ab.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.cvx);
            } catch (SQLiteException e) {
                e.pXa.a(111, 255, 1, false);
                AppMethodBeat.o(59968);
                throw e;
            }
        }
        AppMethodBeat.o(59968);
    }

    public h(long j) {
        AppMethodBeat.i(59969);
        ab.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = ".concat(String.valueOf(j)));
        this.cvx = j;
        this.fIq = ((j) g.K(j.class)).bOr().jf(j);
        if (this.fIq == null) {
            ab.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", Long.valueOf(j));
        }
        AppMethodBeat.o(59969);
    }

    public h() {
        AppMethodBeat.i(59970);
        ab.d("MicroMsg.NetSceneSendMsg", "dktext :%s", bo.dpG());
        ab.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
        AppMethodBeat.o(59970);
    }

    public final boolean acI() {
        return true;
    }

    public final int acn() {
        return 10;
    }

    public final boolean acJ() {
        AppMethodBeat.i(59971);
        boolean acJ = super.acJ();
        if (acJ) {
            e.pXa.a(111, 254, 1, false);
        }
        AppMethodBeat.o(59971);
        return acJ;
    }

    public final m.b b(com.tencent.mm.network.q qVar) {
        AppMethodBeat.i(59972);
        m.b bVar;
        if (this.fIm.size() > 0) {
            bVar = m.b.EOk;
            AppMethodBeat.o(59972);
            return bVar;
        }
        bVar = m.b.EFailed;
        AppMethodBeat.o(59972);
        return bVar;
    }

    private static String a(String str, Object obj, int i) {
        AppMethodBeat.i(59973);
        String str2 = "MicroMsg.NetSceneSendMsg";
        String str3 = "[mergeMsgSource] rawSource:%s args is null:%s flag:%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(obj == null);
        objArr[2] = Integer.valueOf(i);
        ab.i(str2, str3, objArr);
        if (!bo.isNullOrNil(str) && !str.startsWith("<msgsource>")) {
            ab.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", str);
            AppMethodBeat.o(59973);
            return str;
        } else if (i == 291 && (obj instanceof HashMap)) {
            StringBuffer stringBuffer = new StringBuffer();
            if (bo.isNullOrNil(str)) {
                stringBuffer.append("<msgsource>");
            }
            for (Entry entry : ((HashMap) obj).entrySet()) {
                str2 = (String) entry.getValue();
                String str4 = (String) entry.getKey();
                if (bo.isNullOrNil(str2) || bo.isNullOrNil(str4)) {
                    ab.w("MicroMsg.NetSceneSendMsg", "%s %s", str4, str2);
                } else {
                    stringBuffer.append("<").append(str4).append(">");
                    stringBuffer.append(str2);
                    stringBuffer.append("</").append(str4).append(">");
                }
            }
            if (bo.isNullOrNil(str)) {
                stringBuffer.append("</msgsource>");
                str = stringBuffer.toString();
                AppMethodBeat.o(59973);
                return str;
            }
            str = str.replace("<msgsource>", "<msgsource>" + stringBuffer.toString());
            AppMethodBeat.o(59973);
            return str;
        } else {
            AppMethodBeat.o(59973);
            return str;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        List bOD;
        AppMethodBeat.i(59974);
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new bwl();
        aVar.fsK = new bwm();
        aVar.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        aVar.fsI = c.CTRL_INDEX;
        aVar.fsL = d.MIC_PTU_LENGMEIREN;
        aVar.fsM = 1000000237;
        this.ehh = aVar.acD();
        bwl bwl = (bwl) this.ehh.fsG.fsP;
        if (this.fIq == null) {
            bOD = ((j) g.K(j.class)).bOr().bOD();
        } else {
            if (this.fIq.field_status != 5) {
                ab.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", Long.valueOf(this.fIq.field_msgId), Integer.valueOf(this.fIq.field_status));
            }
            this.fIq.setStatus(1);
            ((j) g.K(j.class)).bOr().a(this.cvx, this.fIq);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.fIq);
            this.fIq = null;
            Object bOD2 = arrayList;
        }
        if (bOD2.size() == 0) {
            ab.w("MicroMsg.NetSceneSendMsg", "no sending message");
            AppMethodBeat.o(59974);
            return -2;
        }
        this.fIm.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bOD2.size()) {
                break;
            }
            bi biVar = (bi) bOD2.get(i2);
            if (biVar.field_isSend == 1) {
                bbe bbe = new bbe();
                bbe.vEC = new bts().alV(biVar.field_talker);
                bbe.pcX = (int) (biVar.field_createTime / 1000);
                bbe.jCt = biVar.getType();
                bbe.ncM = biVar.field_content;
                bbe.wFW = p.m(r.Yz(), biVar.field_createTime).hashCode();
                if (this.fIr == null) {
                    this.fIr = ((q) g.K(q.class)).ahU();
                }
                ab.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", this.fIr);
                this.fIr.a(bbe, biVar);
                ab.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", bbe.vEG);
                bwl.jBw.add(bbe);
                bwl.jBv = bwl.jBw.size();
                this.fIm.add(biVar);
            }
            i = i2 + 1;
        }
        int a = a(eVar, this.ehh, this);
        if (a < 0) {
            ab.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", Integer.valueOf(a));
            ahQ();
        }
        AppMethodBeat.o(59974);
        return a;
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    private void lL(int i) {
        AppMethodBeat.i(59975);
        if (this.fIm == null) {
            ab.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
            AppMethodBeat.o(59975);
        } else if (i >= this.fIm.size() || i < 0) {
            ab.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", Integer.valueOf(i), Integer.valueOf(this.fIm.size()));
            AppMethodBeat.o(59975);
        } else {
            z((bi) this.fIm.get(i));
            AppMethodBeat.o(59975);
        }
    }

    private static void z(bi biVar) {
        AppMethodBeat.i(59976);
        qc qcVar = new qc();
        qcVar.cMs.csG = biVar;
        com.tencent.mm.sdk.b.a.xxA.m(qcVar);
        ab.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", Long.valueOf(biVar.field_msgId));
        AppMethodBeat.o(59976);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(59977);
        int i4;
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((bwm) this.ehh.fsH.fsP).jBw;
            ArrayList arrayList = new ArrayList();
            if (this.fIm.size() == linkedList.size()) {
                i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= linkedList.size()) {
                        ab.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", Integer.valueOf(i5 - this.fIp.size()), Integer.valueOf(this.fIp.size()));
                        break;
                    }
                    bbf bbf = (bbf) linkedList.get(i5);
                    if (bbf.Ret != 0 || ae.gjg) {
                        e.pXa.a(111, 252, 1, false);
                        if (bbf.Ret == -49 || ae.gjg) {
                            ab.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", Integer.valueOf(bbf.Ret), Integer.valueOf(i5), Boolean.valueOf(ae.gjg), Integer.valueOf(this.fIn));
                            if (this.fIo) {
                                this.fIp.add((bi) this.fIm.get(i5));
                            } else if (this.fIn < 0) {
                                lM(i5);
                                this.ehi.onSceneEnd(4, bbf.Ret, str, this);
                                lL(i5);
                                AppMethodBeat.o(59977);
                                return;
                            } else {
                                this.fIo = true;
                                this.fIn--;
                                this.fIp.add((bi) this.fIm.get(i5));
                                final String str2 = str;
                                g.RS().aa(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(59966);
                                        new aa(5, "", "", "", "", false, 1, false).a(h.this.ftf, new f() {
                                            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                                AppMethodBeat.i(59965);
                                                mVar.ftk = true;
                                                ab.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(h.this.fIp.size()), str, Boolean.valueOf(h.this.fIo), Integer.valueOf(h.this.fIn));
                                                if (i == 0 && i2 == 0) {
                                                    h.this.fIp.clear();
                                                    h.a(h.this, str);
                                                } else {
                                                    h.ab(h.this.fIp);
                                                    h.this.ehi.onSceneEnd(4, -49, str2, h.this);
                                                    h.ac(h.this.fIp);
                                                    h.this.fIp.clear();
                                                }
                                                h.this.fIo = false;
                                                ae.gjg = false;
                                                AppMethodBeat.o(59965);
                                            }
                                        });
                                        AppMethodBeat.o(59966);
                                    }
                                });
                            }
                        } else {
                            lM(i5);
                            this.ehi.onSceneEnd(4, bbf.Ret, str, this);
                            lL(i5);
                            AppMethodBeat.o(59977);
                            return;
                        }
                    }
                    long j = ((bi) this.fIm.get(i5)).field_msgId;
                    ab.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + bbf.ptF + " sent successfully!");
                    bi jf = ((j) g.K(j.class)).bOr().jf(j);
                    jf.eI(bbf.ptF);
                    ab.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(bbf.ptF), Integer.valueOf(ae.giA));
                    if (CdnLogic.kMediaTypeFavoriteBigFile == ae.giz && ae.giA != 0) {
                        jf.eI((long) ae.giA);
                        ae.giA = 0;
                    }
                    jf.setStatus(2);
                    ((j) g.K(j.class)).bOr().a(j, jf);
                    if (this.fIm == null) {
                        ab.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
                    } else if (i5 >= this.fIm.size() || i5 < 0) {
                        ab.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", Integer.valueOf(i5), Integer.valueOf(this.fIm.size()));
                    } else {
                        ab.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", Long.valueOf(((bi) this.fIm.get(i5)).field_msgId));
                        bi jf2 = ((j) g.K(j.class)).bOr().jf(j);
                        qe qeVar = new qe();
                        qeVar.cMu.csG = jf2;
                        com.tencent.mm.sdk.b.a.xxA.m(qeVar);
                    }
                    arrayList.add(Integer.valueOf(i5));
                    if (1 == bbf.jCt) {
                        e.pXa.a(11942, true, false, Long.valueOf(bbf.ptF));
                        e.pXa.a(11945, false, true, Long.valueOf(bbf.ptF));
                        e.pXa.a(11946, false, false, Long.valueOf(bbf.ptF));
                        e.pXa.a(90, 0, 1, false);
                        e.pXa.a(90, 1, 1, true);
                    }
                    i4 = i5 + 1;
                }
            }
            ab.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", Boolean.valueOf(this.fIo));
            if (this.fIo) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(59977);
                return;
            }
            sQ(str);
            AppMethodBeat.o(59977);
            return;
        }
        ab.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        e.pXa.a(111, (long) (i2 + 40), 1, true);
        e.pXa.a(111, 253, 1, false);
        if (i2 == 3 || i2 == 9 || i2 == 7 || i2 == 8 || i2 == 1) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            ab.e("MicroMsg.NetSceneSendMsg", "Message delivery failed due to network reasons.");
            AppMethodBeat.o(59977);
            return;
        }
        ahQ();
        this.ehi.onSceneEnd(i2, i3, str, this);
        for (i4 = 0; i4 < this.fIm.size(); i4++) {
            lL(i4);
        }
        ab.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
        sQ(str);
        AppMethodBeat.o(59977);
    }

    private void sQ(String str) {
        AppMethodBeat.i(59978);
        ab.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
        int a = a(this.ftf, this.ehi);
        if (a == -2) {
            this.ehi.onSceneEnd(0, 0, str, this);
            AppMethodBeat.o(59978);
            return;
        }
        if (a < 0) {
            this.ehi.onSceneEnd(3, -1, str, this);
        }
        AppMethodBeat.o(59978);
    }

    private void ahQ() {
        AppMethodBeat.i(59979);
        for (int i = 0; i < this.fIm.size(); i++) {
            lM(i);
        }
        AppMethodBeat.o(59979);
    }

    private void lM(int i) {
        AppMethodBeat.i(59980);
        ab.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", Long.valueOf(((bi) this.fIm.get(i)).field_msgId));
        A(r0);
        AppMethodBeat.o(59980);
    }

    private static void A(bi biVar) {
        AppMethodBeat.i(59981);
        biVar.setStatus(5);
        e.pXa.a(111, 30, 1, true);
        ((j) g.K(j.class)).bOr().a(biVar.field_msgId, biVar);
        Iterator it = fIl.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(59981);
    }

    static /* synthetic */ void ab(List list) {
        AppMethodBeat.i(59983);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                A((bi) list.get(i2));
                i = i2 + 1;
            } else {
                AppMethodBeat.o(59983);
                return;
            }
        }
    }

    static /* synthetic */ void ac(List list) {
        AppMethodBeat.i(59984);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                z((bi) list.get(i2));
                i = i2 + 1;
            } else {
                AppMethodBeat.o(59984);
                return;
            }
        }
    }
}
