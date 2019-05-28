package com.tencent.p177mm.p1374bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C42194e;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p230g.p231a.C18271fz;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7568av;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;

/* renamed from: com.tencent.mm.bi.b */
public final class C25861b extends C42194e {
    /* renamed from: a */
    public final C7620bi mo43844a(C7254cm c7254cm, String str, String str2, String str3) {
        AppMethodBeat.m2504i(16617);
        String a = C1946aa.m4148a(c7254cm.vED);
        if (a == null || a.length() <= 0) {
            C4990ab.m7412e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
            AppMethodBeat.m2505o(16617);
        } else {
            C5135a apC = C5135a.apC(a);
            if (!(apC.xZi == null && apC.xZj == null) && (apC.scene == 10 || apC.scene == 11)) {
                C18271fz c18271fz = new C18271fz();
                c18271fz.cAe.cAg = apC.xZi;
                c18271fz.cAe.cAh = apC.xZj;
                C4879a.xxA.mo10055m(c18271fz);
                if (c18271fz.cAf.cAi) {
                    C4990ab.m7418v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
                    AppMethodBeat.m2505o(16617);
                }
            }
            if (apC.pnz > 0) {
                C41730b.m73494d(apC.pnz, apC.xZh);
            }
            if (C5046bo.nullAsNil(apC.svN).length() > 0) {
                C17880h c17880h = new C17880h();
                c17880h.username = apC.svN;
                c17880h.dtR = 3;
                c17880h.mo33385cB(true);
                c17880h.bJt = -1;
                c17880h.frW = apC.xZk;
                c17880h.frV = apC.xZl;
                c17880h.bJt = -1;
                C4990ab.m7411d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", apC.svN, c17880h.ack(), c17880h.acl());
                C17884o.act().mo33391b(c17880h);
            }
            C7569ax c7569ax = new C7569ax();
            c7569ax.field_createTime = C37512c.m63303q(str, (long) c7254cm.pcX);
            c7569ax.field_isSend = 0;
            c7569ax.field_msgContent = C1946aa.m4148a(c7254cm.vED);
            c7569ax.field_svrId = c7254cm.ptF;
            c7569ax.field_talker = apC.svN;
            c7569ax.field_type = 0;
            C7568av apu = C41789d.akP().apu(c7569ax.field_talker);
            if (apu != null) {
                C4990ab.m7410d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + c7569ax.field_talker + " , real talker = " + apu.field_talker);
                c7569ax.field_encryptTalker = c7569ax.field_talker;
                c7569ax.field_talker = apu.field_talker;
            }
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(c7569ax.field_talker);
            if (aoO == null || !C7486a.m12942jh(aoO.field_type) || aoO.ewQ <= 0) {
                C41789d.akO().mo17080b(c7569ax);
                AppMethodBeat.m2505o(16617);
            } else {
                C4990ab.m7410d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + c7569ax.field_talker + " has already been in user's contact list");
                AppMethodBeat.m2505o(16617);
            }
        }
        return null;
    }
}
