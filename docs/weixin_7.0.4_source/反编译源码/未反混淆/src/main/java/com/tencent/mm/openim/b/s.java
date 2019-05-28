package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class s {
    public static int a(all all) {
        AppMethodBeat.i(78887);
        int i = all.ret;
        bgf bgf = all.wqL;
        ab.i("MicroMsg.OpenIMContactLogic", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", r3.field_username, r3.field_nickname, r3.field_conRemark, Integer.valueOf(r3.getSource()), Integer.valueOf(r3.dtS), r3.field_openImAppid, r3.duw, Integer.valueOf(r3.duv), Integer.valueOf(r3.field_type), a(bgf).field_descWordingId);
        ((j) g.K(j.class)).XM().Y(r3);
        ((b) g.K(b.class)).aZ(bgf.app_id, bgf.wKh);
        b(bgf);
        AppMethodBeat.o(78887);
        return i;
    }

    public static ad a(bgf bgf) {
        AppMethodBeat.i(78888);
        ad aoO = ((j) g.K(j.class)).XM().aoO(bgf.geZ);
        if (aoO == null) {
            aoO = new ad();
        }
        aoO.setUsername(bgf.geZ);
        aoO.iB(bgf.nickname);
        aoO.setType(bgf.type);
        aoO.iz(bgf.hHV);
        aoO.setSource(bgf.cvd);
        aoO.iC(bgf.wKj);
        aoO.iD(bgf.wKk);
        aoO.iG(bgf.wKl);
        aoO.iF(bgf.wKm);
        aoO.jf(bgf.wKn == null ? "" : bgf.wKn.naq);
        aoO.hK(bgf.wKn == null ? 0 : bgf.wKn.wKo);
        aoO.je(bgf.vEP);
        aoO.iK(bgf.app_id);
        aoO.hA(bgf.dtS);
        aoO.iJ(bgf.wKh);
        aoO.hH((int) bo.anT());
        AppMethodBeat.o(78888);
        return aoO;
    }

    public static void b(bgf bgf) {
        int i;
        int i2 = 1;
        AppMethodBeat.i(78889);
        Object obj = "";
        Object obj2 = "";
        h qo = o.act().qo(bgf.geZ);
        if (qo != null) {
            obj = qo.ack();
            obj2 = qo.acl();
        }
        qo = new h();
        qo.bJt = -1;
        qo.username = bgf.geZ;
        qo.frV = bgf.wJX;
        qo.frW = bgf.wJW;
        ab.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", qo.getUsername(), qo.ack(), qo.acl());
        if (qo.ack().equals(obj)) {
            i = 0;
        } else {
            o.acd();
            d.E(bgf.geZ, true);
            i = 1;
        }
        if (qo.acl().equals(obj2)) {
            i2 = i;
        } else {
            o.acd();
            d.E(bgf.geZ, false);
        }
        if (i2 != 0) {
            o.acv().pZ(bgf.geZ);
            o.act().b(qo);
        }
        AppMethodBeat.o(78889);
    }
}
