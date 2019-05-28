package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.e;
import com.tencent.mm.at.o;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.je;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class b implements a {
    public final void a(e.a aVar, bi biVar, final String str, String str2, boolean z) {
        AppMethodBeat.i(18232);
        final cm cmVar = aVar.eAB;
        final com.tencent.mm.model.bf.b oE = bf.oE(cmVar.vEG);
        if (oE != null) {
            biVar.jA(oE.fmu);
            biVar.jy(oE.fmt);
            ab.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", oE.fmt);
            if (!(oE.fmx == null || oE.scene != 1 || cmVar.nao == Downloads.MIN_WAIT_FOR_NETWORK)) {
                aw.ZK();
                ad aoO = c.XM().aoO(str);
                if (aoO == null || ((int) aoO.ewQ) <= 0) {
                    ao.a.flu.a(str, null, new com.tencent.mm.model.ao.b.a() {
                        public final void o(String str, boolean z) {
                            AppMethodBeat.i(18231);
                            aw.ZK();
                            b.a(cmVar, oE, c.XM().aoO(str));
                            AppMethodBeat.o(18231);
                        }
                    });
                    AppMethodBeat.o(18232);
                    return;
                }
                a(cmVar, oE, aoO);
            }
        }
        AppMethodBeat.o(18232);
    }

    public final void b(e.a aVar, bi biVar, String str, String str2, boolean z) {
        AppMethodBeat.i(18233);
        if (com.tencent.mm.plugin.priority.a.a.a.bZu()) {
            int i = (t.mY(str) && t.nN(str)) ? 1 : 0;
            int i2;
            if (!t.kH(str) || t.nM(str)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (!z && biVar.drE() && i == 0 && i2 == 0) {
                com.tencent.mm.modelcontrol.c.afC();
                if (com.tencent.mm.modelcontrol.c.u(biVar)) {
                    com.tencent.mm.at.b ahn = o.ahn();
                    long j = biVar.field_msgId;
                    com.tencent.mm.modelcontrol.c.afC();
                    if (com.tencent.mm.modelcontrol.c.afD()) {
                        synchronized (ahn.fCV) {
                            try {
                                if (ahn.fCV.size() >= 100) {
                                    ahn.fCV.remove(0);
                                }
                                ahn.fCV.push(Long.valueOf(j));
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.o(18233);
                                }
                            }
                        }
                        ahn.fCZ = System.currentTimeMillis();
                        ab.i("MicroMsg.AutoGetBigImgLogic", "add %d", Long.valueOf(j));
                        ahn.start();
                    }
                }
            }
        }
        AppMethodBeat.o(18233);
    }

    static void a(cm cmVar, com.tencent.mm.model.bf.b bVar, ad adVar) {
        int i;
        AppMethodBeat.i(18234);
        String a = aa.a(cmVar.vEB);
        aw.ZK();
        c.Ry().set(73729, Integer.valueOf(1));
        String str = adVar.field_nickname;
        com.tencent.mm.storage.bf bfVar = new com.tencent.mm.storage.bf();
        bfVar.field_content = aa.a(cmVar.vED);
        bfVar.field_createtime = bo.anT();
        bfVar.field_imgpath = "";
        bfVar.field_sayhicontent = cmVar.nao == 3 ? ah.getContext().getString(R.string.d5e) : aa.a(cmVar.vED);
        bfVar.field_sayhiuser = a;
        bfVar.field_scene = 18;
        if (cmVar.jBT > 3) {
            i = cmVar.jBT;
        } else {
            i = 3;
        }
        bfVar.field_status = i;
        bfVar.field_svrid = cmVar.ptF;
        bfVar.field_talker = str;
        bfVar.field_type = cmVar.nao;
        bfVar.field_isSend = 0;
        bfVar.field_sayhiencryptuser = a;
        bfVar.field_ticket = bVar.fmx;
        d.akQ().a(bfVar);
        je jeVar = new je();
        jeVar.cEq.cEr = a;
        com.tencent.mm.sdk.b.a.xxA.m(jeVar);
        AppMethodBeat.o(18234);
    }
}
