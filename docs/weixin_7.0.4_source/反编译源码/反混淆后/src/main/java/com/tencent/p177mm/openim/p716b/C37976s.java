package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.all;
import com.tencent.p177mm.protocal.protobuf.bgf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.openim.b.s */
public final class C37976s {
    /* renamed from: a */
    public static int m64266a(all all) {
        AppMethodBeat.m2504i(78887);
        int i = all.ret;
        bgf bgf = all.wqL;
        C4990ab.m7417i("MicroMsg.OpenIMContactLogic", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", r3.field_username, r3.field_nickname, r3.field_conRemark, Integer.valueOf(r3.getSource()), Integer.valueOf(r3.dtS), r3.field_openImAppid, r3.duw, Integer.valueOf(r3.duv), Integer.valueOf(r3.field_type), C37976s.m64267a(bgf).field_descWordingId);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15701Y(r3);
        ((C32873b) C1720g.m3528K(C32873b.class)).mo44303aZ(bgf.app_id, bgf.wKh);
        C37976s.m64268b(bgf);
        AppMethodBeat.m2505o(78887);
        return i;
    }

    /* renamed from: a */
    public static C7616ad m64267a(bgf bgf) {
        AppMethodBeat.m2504i(78888);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(bgf.geZ);
        if (aoO == null) {
            aoO = new C7616ad();
        }
        aoO.setUsername(bgf.geZ);
        aoO.mo14703iB(bgf.nickname);
        aoO.setType(bgf.type);
        aoO.mo14729iz(bgf.hHV);
        aoO.setSource(bgf.cvd);
        aoO.mo14704iC(bgf.wKj);
        aoO.mo14705iD(bgf.wKk);
        aoO.mo14708iG(bgf.wKl);
        aoO.mo14707iF(bgf.wKm);
        aoO.mo14735jf(bgf.wKn == null ? "" : bgf.wKn.naq);
        aoO.mo14695hK(bgf.wKn == null ? 0 : bgf.wKn.wKo);
        aoO.mo14734je(bgf.vEP);
        aoO.mo14712iK(bgf.app_id);
        aoO.mo14685hA(bgf.dtS);
        aoO.mo14711iJ(bgf.wKh);
        aoO.mo14692hH((int) C5046bo.anT());
        AppMethodBeat.m2505o(78888);
        return aoO;
    }

    /* renamed from: b */
    public static void m64268b(bgf bgf) {
        int i;
        int i2 = 1;
        AppMethodBeat.m2504i(78889);
        Object obj = "";
        Object obj2 = "";
        C17880h qo = C17884o.act().mo33392qo(bgf.geZ);
        if (qo != null) {
            obj = qo.ack();
            obj2 = qo.acl();
        }
        qo = new C17880h();
        qo.bJt = -1;
        qo.username = bgf.geZ;
        qo.frV = bgf.wJX;
        qo.frW = bgf.wJW;
        C4990ab.m7417i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", qo.getUsername(), qo.ack(), qo.acl());
        if (qo.ack().equals(obj)) {
            i = 0;
        } else {
            C17884o.acd();
            C41732d.m73516E(bgf.geZ, true);
            i = 1;
        }
        if (qo.acl().equals(obj2)) {
            i2 = i;
        } else {
            C17884o.acd();
            C41732d.m73516E(bgf.geZ, false);
        }
        if (i2 != 0) {
            C17884o.acv().mo67495pZ(bgf.geZ);
            C17884o.act().mo33391b(qo);
        }
        AppMethodBeat.m2505o(78889);
    }
}
