package com.tencent.p177mm.modelmulti;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1851p;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsimple.C9703aa;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C6541qc;
import com.tencent.p177mm.p230g.p231a.C6542qe;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19482c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C12527m;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C39367q;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.protobuf.bbe;
import com.tencent.p177mm.protocal.protobuf.bbf;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.bwl;
import com.tencent.p177mm.protocal.protobuf.bwm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.view.C31128d;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelmulti.h */
public final class C26451h extends C1207m implements C1918k {
    private static final List<Object> fIl = new ArrayList();
    public long cvx;
    private C7472b ehh;
    private C1202f ehi;
    private final List<C7620bi> fIm = new LinkedList();
    private int fIn = 3;
    private boolean fIo = false;
    private final List<C7620bi> fIp = new ArrayList();
    private C7620bi fIq = null;
    public C12527m fIr = null;

    static {
        AppMethodBeat.m2504i(59985);
        AppMethodBeat.m2505o(59985);
    }

    public C26451h(String str, String str2, int i, int i2, Object obj) {
        AppMethodBeat.m2504i(59967);
        C4990ab.m7411d("MicroMsg.NetSceneSendMsg", "dktext :%s", C5046bo.dpG());
        if (!C5046bo.isNullOrNil(str)) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.setStatus(1);
            c7620bi.mo14794ju(str);
            c7620bi.mo14775eJ(C1829bf.m3756oC(str));
            c7620bi.mo14781hO(1);
            c7620bi.setContent(str2);
            c7620bi.setType(i);
            String a = C26451h.m42119a(((C39367q) C1720g.m3528K(C39367q.class)).mo62261B(c7620bi), obj, i2);
            if (!C5046bo.isNullOrNil(a)) {
                c7620bi.mo14791ix(a);
                C4990ab.m7411d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", c7620bi.dqJ);
            }
            try {
                this.cvx = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15314c(c7620bi, true);
                if (this.cvx == -1) {
                    C7053e.pXa.mo8378a(111, 255, 1, false);
                }
                Assert.assertTrue(this.cvx != -1);
                C4990ab.m7416i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.cvx);
            } catch (SQLiteException e) {
                C7053e.pXa.mo8378a(111, 255, 1, false);
                AppMethodBeat.m2505o(59967);
                throw e;
            }
        }
        AppMethodBeat.m2505o(59967);
    }

    public C26451h(String str, String str2, int i) {
        AppMethodBeat.m2504i(59968);
        C4990ab.m7411d("MicroMsg.NetSceneSendMsg", "dktext :%s", C5046bo.dpG());
        if (!C5046bo.isNullOrNil(str)) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.setStatus(1);
            c7620bi.mo14794ju(str);
            c7620bi.mo14775eJ(C1829bf.m3756oC(str));
            c7620bi.mo14781hO(1);
            c7620bi.setContent(str2);
            c7620bi.setType(i);
            String B = ((C39367q) C1720g.m3528K(C39367q.class)).mo62261B(c7620bi);
            if (!C5046bo.isNullOrNil(B)) {
                c7620bi.mo14791ix(B);
                C4990ab.m7411d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", c7620bi.dqJ);
            }
            try {
                this.cvx = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15314c(c7620bi, true);
                if (this.cvx == -1) {
                    C7053e.pXa.mo8378a(111, 255, 1, false);
                }
                Assert.assertTrue(this.cvx != -1);
                C4990ab.m7416i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.cvx);
            } catch (SQLiteException e) {
                C7053e.pXa.mo8378a(111, 255, 1, false);
                AppMethodBeat.m2505o(59968);
                throw e;
            }
        }
        AppMethodBeat.m2505o(59968);
    }

    public C26451h(long j) {
        AppMethodBeat.m2504i(59969);
        C4990ab.m7416i("MicroMsg.NetSceneSendMsg", "resend msg , local id = ".concat(String.valueOf(j)));
        this.cvx = j;
        this.fIq = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
        if (this.fIq == null) {
            C4990ab.m7413e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", Long.valueOf(j));
        }
        AppMethodBeat.m2505o(59969);
    }

    public C26451h() {
        AppMethodBeat.m2504i(59970);
        C4990ab.m7411d("MicroMsg.NetSceneSendMsg", "dktext :%s", C5046bo.dpG());
        C4990ab.m7416i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
        AppMethodBeat.m2505o(59970);
    }

    public final boolean acI() {
        return true;
    }

    public final int acn() {
        return 10;
    }

    public final boolean acJ() {
        AppMethodBeat.m2504i(59971);
        boolean acJ = super.acJ();
        if (acJ) {
            C7053e.pXa.mo8378a(111, 254, 1, false);
        }
        AppMethodBeat.m2505o(59971);
        return acJ;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(59972);
        C1206b c1206b;
        if (this.fIm.size() > 0) {
            c1206b = C1206b.EOk;
            AppMethodBeat.m2505o(59972);
            return c1206b;
        }
        c1206b = C1206b.EFailed;
        AppMethodBeat.m2505o(59972);
        return c1206b;
    }

    /* renamed from: a */
    private static String m42119a(String str, Object obj, int i) {
        AppMethodBeat.m2504i(59973);
        String str2 = "MicroMsg.NetSceneSendMsg";
        String str3 = "[mergeMsgSource] rawSource:%s args is null:%s flag:%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(obj == null);
        objArr[2] = Integer.valueOf(i);
        C4990ab.m7417i(str2, str3, objArr);
        if (!C5046bo.isNullOrNil(str) && !str.startsWith("<msgsource>")) {
            C4990ab.m7421w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", str);
            AppMethodBeat.m2505o(59973);
            return str;
        } else if (i == 291 && (obj instanceof HashMap)) {
            StringBuffer stringBuffer = new StringBuffer();
            if (C5046bo.isNullOrNil(str)) {
                stringBuffer.append("<msgsource>");
            }
            for (Entry entry : ((HashMap) obj).entrySet()) {
                str2 = (String) entry.getValue();
                String str4 = (String) entry.getKey();
                if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str4)) {
                    C4990ab.m7421w("MicroMsg.NetSceneSendMsg", "%s %s", str4, str2);
                } else {
                    stringBuffer.append("<").append(str4).append(">");
                    stringBuffer.append(str2);
                    stringBuffer.append("</").append(str4).append(">");
                }
            }
            if (C5046bo.isNullOrNil(str)) {
                stringBuffer.append("</msgsource>");
                str = stringBuffer.toString();
                AppMethodBeat.m2505o(59973);
                return str;
            }
            str = str.replace("<msgsource>", "<msgsource>" + stringBuffer.toString());
            AppMethodBeat.m2505o(59973);
            return str;
        } else {
            AppMethodBeat.m2505o(59973);
            return str;
        }
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        List bOD;
        AppMethodBeat.m2504i(59974);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bwl();
        c1196a.fsK = new bwm();
        c1196a.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        c1196a.fsI = C19482c.CTRL_INDEX;
        c1196a.fsL = C31128d.MIC_PTU_LENGMEIREN;
        c1196a.fsM = 1000000237;
        this.ehh = c1196a.acD();
        bwl bwl = (bwl) this.ehh.fsG.fsP;
        if (this.fIq == null) {
            bOD = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().bOD();
        } else {
            if (this.fIq.field_status != 5) {
                C4990ab.m7421w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", Long.valueOf(this.fIq.field_msgId), Integer.valueOf(this.fIq.field_status));
            }
            this.fIq.setStatus(1);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.cvx, this.fIq);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.fIq);
            this.fIq = null;
            Object bOD2 = arrayList;
        }
        if (bOD2.size() == 0) {
            C4990ab.m7420w("MicroMsg.NetSceneSendMsg", "no sending message");
            AppMethodBeat.m2505o(59974);
            return -2;
        }
        this.fIm.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bOD2.size()) {
                break;
            }
            C7620bi c7620bi = (C7620bi) bOD2.get(i2);
            if (c7620bi.field_isSend == 1) {
                bbe bbe = new bbe();
                bbe.vEC = new bts().alV(c7620bi.field_talker);
                bbe.pcX = (int) (c7620bi.field_createTime / 1000);
                bbe.jCt = c7620bi.getType();
                bbe.ncM = c7620bi.field_content;
                bbe.wFW = C1851p.m3818m(C1853r.m3846Yz(), c7620bi.field_createTime).hashCode();
                if (this.fIr == null) {
                    this.fIr = ((C39367q) C1720g.m3528K(C39367q.class)).ahU();
                }
                C4990ab.m7417i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", this.fIr);
                this.fIr.mo24450a(bbe, c7620bi);
                C4990ab.m7417i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", bbe.vEG);
                bwl.jBw.add(bbe);
                bwl.jBv = bwl.jBw.size();
                this.fIm.add(c7620bi);
            }
            i = i2 + 1;
        }
        int a = mo4457a(c1902e, this.ehh, this);
        if (a < 0) {
            C4990ab.m7417i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", Integer.valueOf(a));
            ahQ();
        }
        AppMethodBeat.m2505o(59974);
        return a;
    }

    public final int getType() {
        return C19482c.CTRL_INDEX;
    }

    /* renamed from: lL */
    private void m42128lL(int i) {
        AppMethodBeat.m2504i(59975);
        if (this.fIm == null) {
            C4990ab.m7412e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
            AppMethodBeat.m2505o(59975);
        } else if (i >= this.fIm.size() || i < 0) {
            C4990ab.m7413e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", Integer.valueOf(i), Integer.valueOf(this.fIm.size()));
            AppMethodBeat.m2505o(59975);
        } else {
            C26451h.m42131z((C7620bi) this.fIm.get(i));
            AppMethodBeat.m2505o(59975);
        }
    }

    /* renamed from: z */
    private static void m42131z(C7620bi c7620bi) {
        AppMethodBeat.m2504i(59976);
        C6541qc c6541qc = new C6541qc();
        c6541qc.cMs.csG = c7620bi;
        C4879a.xxA.mo10055m(c6541qc);
        C4990ab.m7411d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", Long.valueOf(c7620bi.field_msgId));
        AppMethodBeat.m2505o(59976);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(59977);
        int i4;
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((bwm) this.ehh.fsH.fsP).jBw;
            ArrayList arrayList = new ArrayList();
            if (this.fIm.size() == linkedList.size()) {
                i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= linkedList.size()) {
                        C4990ab.m7417i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", Integer.valueOf(i5 - this.fIp.size()), Integer.valueOf(this.fIp.size()));
                        break;
                    }
                    bbf bbf = (bbf) linkedList.get(i5);
                    if (bbf.Ret != 0 || C1947ae.gjg) {
                        C7053e.pXa.mo8378a(111, 252, 1, false);
                        if (bbf.Ret == -49 || C1947ae.gjg) {
                            C4990ab.m7417i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", Integer.valueOf(bbf.Ret), Integer.valueOf(i5), Boolean.valueOf(C1947ae.gjg), Integer.valueOf(this.fIn));
                            if (this.fIo) {
                                this.fIp.add((C7620bi) this.fIm.get(i5));
                            } else if (this.fIn < 0) {
                                m42129lM(i5);
                                this.ehi.onSceneEnd(4, bbf.Ret, str, this);
                                m42128lL(i5);
                                AppMethodBeat.m2505o(59977);
                                return;
                            } else {
                                this.fIo = true;
                                this.fIn--;
                                this.fIp.add((C7620bi) this.fIm.get(i5));
                                final String str2 = str;
                                C1720g.m3539RS().mo10302aa(new Runnable() {

                                    /* renamed from: com.tencent.mm.modelmulti.h$1$1 */
                                    class C264531 implements C1202f {
                                        C264531() {
                                        }

                                        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                                            AppMethodBeat.m2504i(59965);
                                            c1207m.ftk = true;
                                            C4990ab.m7417i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(C26451h.this.fIp.size()), str, Boolean.valueOf(C26451h.this.fIo), Integer.valueOf(C26451h.this.fIn));
                                            if (i == 0 && i2 == 0) {
                                                C26451h.this.fIp.clear();
                                                C26451h.m42120a(C26451h.this, str);
                                            } else {
                                                C26451h.m42121ab(C26451h.this.fIp);
                                                C26451h.this.ehi.onSceneEnd(4, -49, str2, C26451h.this);
                                                C26451h.m42122ac(C26451h.this.fIp);
                                                C26451h.this.fIp.clear();
                                            }
                                            C26451h.this.fIo = false;
                                            C1947ae.gjg = false;
                                            AppMethodBeat.m2505o(59965);
                                        }
                                    }

                                    public final void run() {
                                        AppMethodBeat.m2504i(59966);
                                        new C9703aa(5, "", "", "", "", false, 1, false).mo4456a(C26451h.this.ftf, new C264531());
                                        AppMethodBeat.m2505o(59966);
                                    }
                                });
                            }
                        } else {
                            m42129lM(i5);
                            this.ehi.onSceneEnd(4, bbf.Ret, str, this);
                            m42128lL(i5);
                            AppMethodBeat.m2505o(59977);
                            return;
                        }
                    }
                    long j = ((C7620bi) this.fIm.get(i5)).field_msgId;
                    C4990ab.m7416i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + bbf.ptF + " sent successfully!");
                    C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
                    jf.mo14774eI(bbf.ptF);
                    C4990ab.m7411d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(bbf.ptF), Integer.valueOf(C1947ae.giA));
                    if (CdnLogic.kMediaTypeFavoriteBigFile == C1947ae.giz && C1947ae.giA != 0) {
                        jf.mo14774eI((long) C1947ae.giA);
                        C1947ae.giA = 0;
                    }
                    jf.setStatus(2);
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(j, jf);
                    if (this.fIm == null) {
                        C4990ab.m7412e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
                    } else if (i5 >= this.fIm.size() || i5 < 0) {
                        C4990ab.m7413e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", Integer.valueOf(i5), Integer.valueOf(this.fIm.size()));
                    } else {
                        C4990ab.m7411d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", Long.valueOf(((C7620bi) this.fIm.get(i5)).field_msgId));
                        C7620bi jf2 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
                        C6542qe c6542qe = new C6542qe();
                        c6542qe.cMu.csG = jf2;
                        C4879a.xxA.mo10055m(c6542qe);
                    }
                    arrayList.add(Integer.valueOf(i5));
                    if (1 == bbf.jCt) {
                        C7053e.pXa.mo8377a(11942, true, false, Long.valueOf(bbf.ptF));
                        C7053e.pXa.mo8377a(11945, false, true, Long.valueOf(bbf.ptF));
                        C7053e.pXa.mo8377a(11946, false, false, Long.valueOf(bbf.ptF));
                        C7053e.pXa.mo8378a(90, 0, 1, false);
                        C7053e.pXa.mo8378a(90, 1, 1, true);
                    }
                    i4 = i5 + 1;
                }
            }
            C4990ab.m7411d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", Boolean.valueOf(this.fIo));
            if (this.fIo) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(59977);
                return;
            }
            m42130sQ(str);
            AppMethodBeat.m2505o(59977);
            return;
        }
        C4990ab.m7417i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        C7053e.pXa.mo8378a(111, (long) (i2 + 40), 1, true);
        C7053e.pXa.mo8378a(111, 253, 1, false);
        if (i2 == 3 || i2 == 9 || i2 == 7 || i2 == 8 || i2 == 1) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            C4990ab.m7412e("MicroMsg.NetSceneSendMsg", "Message delivery failed due to network reasons.");
            AppMethodBeat.m2505o(59977);
            return;
        }
        ahQ();
        this.ehi.onSceneEnd(i2, i3, str, this);
        for (i4 = 0; i4 < this.fIm.size(); i4++) {
            m42128lL(i4);
        }
        C4990ab.m7410d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
        m42130sQ(str);
        AppMethodBeat.m2505o(59977);
    }

    /* renamed from: sQ */
    private void m42130sQ(String str) {
        AppMethodBeat.m2504i(59978);
        C4990ab.m7410d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
        int a = mo4456a(this.ftf, this.ehi);
        if (a == -2) {
            this.ehi.onSceneEnd(0, 0, str, this);
            AppMethodBeat.m2505o(59978);
            return;
        }
        if (a < 0) {
            this.ehi.onSceneEnd(3, -1, str, this);
        }
        AppMethodBeat.m2505o(59978);
    }

    private void ahQ() {
        AppMethodBeat.m2504i(59979);
        for (int i = 0; i < this.fIm.size(); i++) {
            m42129lM(i);
        }
        AppMethodBeat.m2505o(59979);
    }

    /* renamed from: lM */
    private void m42129lM(int i) {
        AppMethodBeat.m2504i(59980);
        C4990ab.m7411d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", Long.valueOf(((C7620bi) this.fIm.get(i)).field_msgId));
        C26451h.m42117A(r0);
        AppMethodBeat.m2505o(59980);
    }

    /* renamed from: A */
    private static void m42117A(C7620bi c7620bi) {
        AppMethodBeat.m2504i(59981);
        c7620bi.setStatus(5);
        C7053e.pXa.mo8378a(111, 30, 1, true);
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(c7620bi.field_msgId, c7620bi);
        Iterator it = fIl.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(59981);
    }

    /* renamed from: ab */
    static /* synthetic */ void m42121ab(List list) {
        AppMethodBeat.m2504i(59983);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C26451h.m42117A((C7620bi) list.get(i2));
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(59983);
                return;
            }
        }
    }

    /* renamed from: ac */
    static /* synthetic */ void m42122ac(List list) {
        AppMethodBeat.m2504i(59984);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C26451h.m42131z((C7620bi) list.get(i2));
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(59984);
                return;
            }
        }
    }
}
