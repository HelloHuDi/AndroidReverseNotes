package com.tencent.p177mm.p1374bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p230g.p231a.C6497je;
import com.tencent.p177mm.p230g.p231a.C6524nb;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7568av;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7619ay;
import com.tencent.p177mm.storage.C7620bi.C5138d;

/* renamed from: com.tencent.mm.bi.e */
public final class C37513e implements C1201e {
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        int i = 0;
        AppMethodBeat.m2504i(16632);
        C7254cm c7254cm = c1197a.eAB;
        String a = C1946aa.m4148a(c7254cm.vEB);
        if ("fmessage".equals(a) || c7254cm.nao == 37) {
            String a2 = C1946aa.m4148a(c7254cm.vED);
            final C5138d apF = C5138d.apF(a2);
            String Yz = C1853r.m3846Yz();
            if (apF.svN == null || !apF.svN.equals(Yz)) {
                C7616ad aoO;
                String str;
                C17880h c17880h = new C17880h();
                c17880h.username = apF.svN;
                c17880h.dtR = 3;
                c17880h.mo33385cB(true);
                c17880h.bJt = -1;
                c17880h.frW = apF.xZk;
                c17880h.frV = apF.xZl;
                C4990ab.m7411d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", apF.svN, c17880h.ack(), c17880h.acl());
                C17884o.act().mo33391b(c17880h);
                if (!C5046bo.isNullOrNil(apF.svN)) {
                    if (apF.scene == 18) {
                        C41789d.m73765a(c7254cm, apF);
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(73729, Integer.valueOf(1));
                        C9638aw.m17190ZK();
                        aoO = C18628c.m29078XM().aoO(apF.xZx);
                        if (aoO == null || ((int) aoO.ewQ) <= 0) {
                            C26417a.flu.mo20966a(apF.xZx, null, new C9636a() {
                                /* renamed from: o */
                                public final void mo6218o(String str, boolean z) {
                                    AppMethodBeat.m2504i(16631);
                                    C9638aw.m17190ZK();
                                    C4990ab.m7410d("MicroMsg.VerifyMessageExtension", String.valueOf(C18628c.m29078XM().aoO(apF.xZx)));
                                    C6497je c6497je = new C6497je();
                                    c6497je.cEq.cEr = apF.xZx;
                                    c6497je.cEq.type = 1;
                                    C4879a.xxA.mo10055m(c6497je);
                                    AppMethodBeat.m2505o(16631);
                                }
                            });
                        } else {
                            str = aoO.field_username;
                            if (!(str == null || C1855t.m3911mX(str))) {
                                aoO.setUsername(apF.xZx);
                                aoO.mo14709iH(null);
                                C9638aw.m17190ZK();
                                C18628c.m29078XM().mo15724b(str, aoO);
                            }
                            C6497je c6497je = new C6497je();
                            c6497je.cEq.cEr = apF.xZx;
                            c6497je.cEq.type = 1;
                            C4879a.xxA.mo10055m(c6497je);
                        }
                        AppMethodBeat.m2505o(16632);
                    } else if (C1829bf.m3750kE(apF.scene)) {
                        C41789d.m73766b(c7254cm, apF);
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(73730, Integer.valueOf(1));
                        AppMethodBeat.m2505o(16632);
                    } else if (apF.scene == 48) {
                        C6524nb c6524nb = new C6524nb();
                        c6524nb.cJf.cJh = a2;
                        c6524nb.cJf.talker = apF.svN;
                        C4879a.xxA.mo10055m(c6524nb);
                    }
                }
                C7569ax c7569ax = new C7569ax();
                c7569ax.field_createTime = C37512c.m63303q(a, (long) c7254cm.pcX);
                if (c7254cm.jBT == 4) {
                    i = 2;
                }
                c7569ax.field_isSend = i + 0;
                c7569ax.field_msgContent = C1946aa.m4148a(c7254cm.vED);
                c7569ax.field_svrId = c7254cm.ptF;
                c7569ax.field_talker = apF.svN;
                C9638aw.m17190ZK();
                aoO = C18628c.m29078XM().aoO(apF.chatroomName);
                if (!(aoO == null || ((int) aoO.ewQ) == -1)) {
                    c7569ax.field_chatroomName = apF.chatroomName;
                }
                switch (apF.cAd) {
                    case 2:
                        c7569ax.field_type = 1;
                        break;
                    case 5:
                        c7569ax.field_type = 2;
                        break;
                    case 6:
                        c7569ax.field_type = 3;
                        break;
                    default:
                        c7569ax.field_type = 1;
                        break;
                }
                if (C5046bo.isNullOrNil(apF.xZx)) {
                    C4990ab.m7412e("MicroMsg.VerifyMessageExtension", "it should not go in here");
                    C7568av apu = C41789d.akP().apu(c7569ax.field_talker);
                    if (apu != null) {
                        c7569ax.field_encryptTalker = apu.field_talker;
                        c7569ax.field_talker = apu.field_talker;
                    }
                    C41789d.akO().mo17080b(c7569ax);
                } else {
                    c7569ax.field_encryptTalker = apF.xZx;
                    if (C41789d.akP().mo7910QR(apF.xZx) != null) {
                        C7619ay akO = C41789d.akO();
                        str = c7569ax.field_encryptTalker;
                        akO.bSd.mo10108hY("fmessage_msginfo", "update fmessage_msginfo set talker = '" + C5046bo.m7586vA(c7569ax.field_talker) + "'  where talker = '" + C5046bo.m7586vA(str) + "'");
                        C41789d.akP().mo7911p(0, c7569ax.field_encryptTalker);
                    }
                    C41789d.akO().mo17080b(c7569ax);
                }
                AppMethodBeat.m2505o(16632);
            } else {
                C4990ab.m7411d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", Integer.valueOf(apF.scene), a2);
                C4990ab.m7412e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
                AppMethodBeat.m2505o(16632);
            }
        } else {
            AppMethodBeat.m2505o(16632);
        }
        return null;
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }
}
