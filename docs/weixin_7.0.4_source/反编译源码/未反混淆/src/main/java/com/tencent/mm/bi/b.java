package com.tencent.mm.bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;

public final class b extends e {
    public final bi a(cm cmVar, String str, String str2, String str3) {
        AppMethodBeat.i(16617);
        String a = aa.a(cmVar.vED);
        if (a == null || a.length() <= 0) {
            ab.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
            AppMethodBeat.o(16617);
        } else {
            a apC = a.apC(a);
            if (!(apC.xZi == null && apC.xZj == null) && (apC.scene == 10 || apC.scene == 11)) {
                fz fzVar = new fz();
                fzVar.cAe.cAg = apC.xZi;
                fzVar.cAe.cAh = apC.xZj;
                com.tencent.mm.sdk.b.a.xxA.m(fzVar);
                if (fzVar.cAf.cAi) {
                    ab.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
                    AppMethodBeat.o(16617);
                }
            }
            if (apC.pnz > 0) {
                com.tencent.mm.ah.b.d(apC.pnz, apC.xZh);
            }
            if (bo.nullAsNil(apC.svN).length() > 0) {
                h hVar = new h();
                hVar.username = apC.svN;
                hVar.dtR = 3;
                hVar.cB(true);
                hVar.bJt = -1;
                hVar.frW = apC.xZk;
                hVar.frV = apC.xZl;
                hVar.bJt = -1;
                ab.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", apC.svN, hVar.ack(), hVar.acl());
                o.act().b(hVar);
            }
            ax axVar = new ax();
            axVar.field_createTime = c.q(str, (long) cmVar.pcX);
            axVar.field_isSend = 0;
            axVar.field_msgContent = aa.a(cmVar.vED);
            axVar.field_svrId = cmVar.ptF;
            axVar.field_talker = apC.svN;
            axVar.field_type = 0;
            av apu = d.akP().apu(axVar.field_talker);
            if (apu != null) {
                ab.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + axVar.field_talker + " , real talker = " + apu.field_talker);
                axVar.field_encryptTalker = axVar.field_talker;
                axVar.field_talker = apu.field_talker;
            }
            aw.ZK();
            ad aoO = c.XM().aoO(axVar.field_talker);
            if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type) || aoO.ewQ <= 0) {
                d.akO().b(axVar);
                AppMethodBeat.o(16617);
            } else {
                ab.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + axVar.field_talker + " has already been in user's contact list");
                AppMethodBeat.o(16617);
            }
        }
        return null;
    }
}
