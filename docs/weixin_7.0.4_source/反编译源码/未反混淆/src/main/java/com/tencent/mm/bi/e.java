package com.tencent.mm.bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bi.d;

public final class e implements com.tencent.mm.ai.e {
    public final b b(a aVar) {
        int i = 0;
        AppMethodBeat.i(16632);
        cm cmVar = aVar.eAB;
        String a = aa.a(cmVar.vEB);
        if ("fmessage".equals(a) || cmVar.nao == 37) {
            String a2 = aa.a(cmVar.vED);
            final d apF = d.apF(a2);
            String Yz = r.Yz();
            if (apF.svN == null || !apF.svN.equals(Yz)) {
                ad aoO;
                String str;
                h hVar = new h();
                hVar.username = apF.svN;
                hVar.dtR = 3;
                hVar.cB(true);
                hVar.bJt = -1;
                hVar.frW = apF.xZk;
                hVar.frV = apF.xZl;
                ab.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", apF.svN, hVar.ack(), hVar.acl());
                o.act().b(hVar);
                if (!bo.isNullOrNil(apF.svN)) {
                    if (apF.scene == 18) {
                        d.a(cmVar, apF);
                        aw.ZK();
                        c.Ry().set(73729, Integer.valueOf(1));
                        aw.ZK();
                        aoO = c.XM().aoO(apF.xZx);
                        if (aoO == null || ((int) aoO.ewQ) <= 0) {
                            ao.a.flu.a(apF.xZx, null, new ao.b.a() {
                                public final void o(String str, boolean z) {
                                    AppMethodBeat.i(16631);
                                    aw.ZK();
                                    ab.d("MicroMsg.VerifyMessageExtension", String.valueOf(c.XM().aoO(apF.xZx)));
                                    je jeVar = new je();
                                    jeVar.cEq.cEr = apF.xZx;
                                    jeVar.cEq.type = 1;
                                    com.tencent.mm.sdk.b.a.xxA.m(jeVar);
                                    AppMethodBeat.o(16631);
                                }
                            });
                        } else {
                            str = aoO.field_username;
                            if (!(str == null || t.mX(str))) {
                                aoO.setUsername(apF.xZx);
                                aoO.iH(null);
                                aw.ZK();
                                c.XM().b(str, aoO);
                            }
                            je jeVar = new je();
                            jeVar.cEq.cEr = apF.xZx;
                            jeVar.cEq.type = 1;
                            com.tencent.mm.sdk.b.a.xxA.m(jeVar);
                        }
                        AppMethodBeat.o(16632);
                    } else if (bf.kE(apF.scene)) {
                        d.b(cmVar, apF);
                        aw.ZK();
                        c.Ry().set(73730, Integer.valueOf(1));
                        AppMethodBeat.o(16632);
                    } else if (apF.scene == 48) {
                        nb nbVar = new nb();
                        nbVar.cJf.cJh = a2;
                        nbVar.cJf.talker = apF.svN;
                        com.tencent.mm.sdk.b.a.xxA.m(nbVar);
                    }
                }
                ax axVar = new ax();
                axVar.field_createTime = c.q(a, (long) cmVar.pcX);
                if (cmVar.jBT == 4) {
                    i = 2;
                }
                axVar.field_isSend = i + 0;
                axVar.field_msgContent = aa.a(cmVar.vED);
                axVar.field_svrId = cmVar.ptF;
                axVar.field_talker = apF.svN;
                aw.ZK();
                aoO = c.XM().aoO(apF.chatroomName);
                if (!(aoO == null || ((int) aoO.ewQ) == -1)) {
                    axVar.field_chatroomName = apF.chatroomName;
                }
                switch (apF.cAd) {
                    case 2:
                        axVar.field_type = 1;
                        break;
                    case 5:
                        axVar.field_type = 2;
                        break;
                    case 6:
                        axVar.field_type = 3;
                        break;
                    default:
                        axVar.field_type = 1;
                        break;
                }
                if (bo.isNullOrNil(apF.xZx)) {
                    ab.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
                    av apu = d.akP().apu(axVar.field_talker);
                    if (apu != null) {
                        axVar.field_encryptTalker = apu.field_talker;
                        axVar.field_talker = apu.field_talker;
                    }
                    d.akO().b(axVar);
                } else {
                    axVar.field_encryptTalker = apF.xZx;
                    if (d.akP().QR(apF.xZx) != null) {
                        ay akO = d.akO();
                        str = axVar.field_encryptTalker;
                        akO.bSd.hY("fmessage_msginfo", "update fmessage_msginfo set talker = '" + bo.vA(axVar.field_talker) + "'  where talker = '" + bo.vA(str) + "'");
                        d.akP().p(0, axVar.field_encryptTalker);
                    }
                    d.akO().b(axVar);
                }
                AppMethodBeat.o(16632);
            } else {
                ab.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", Integer.valueOf(apF.scene), a2);
                ab.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
                AppMethodBeat.o(16632);
            }
        } else {
            AppMethodBeat.o(16632);
        }
        return null;
    }

    public final void a(com.tencent.mm.ai.e.c cVar) {
    }
}
