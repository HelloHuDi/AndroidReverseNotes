package com.tencent.p177mm.p824am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.am.g */
public final class C25777g extends C1812ai {
    /* renamed from: kw */
    public final boolean mo5386kw(int i) {
        return i != 0 && i < 604307701;
    }

    public final void transfer(int i) {
        AppMethodBeat.m2504i(16435);
        if (i != 0 && i < 604307701) {
            C7060h.pYm.mo15419k(336, 11, 1);
            C9638aw.m17190ZK();
            C7620bi[] cC = C18628c.m29080XO().mo15318cC("fmessage", 20);
            if (cC == null) {
                C4990ab.m7412e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
                AppMethodBeat.m2505o(16435);
                return;
            }
            C41789d.akP();
            C4990ab.m7410d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + cC.length);
            for (C6575cy c6575cy : cC) {
                if (c6575cy != null && c6575cy.field_msgId != 0) {
                    C4990ab.m7410d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + c6575cy.getType());
                    String str = c6575cy.field_content;
                    if (str != null && str.length() != 0) {
                        C7569ax c7569ax;
                        switch (c6575cy.getType()) {
                            case C2275g.CTRL_INDEX /*37*/:
                                C4990ab.m7410d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + c6575cy.field_content);
                                C5138d apF = C5138d.apF(c6575cy.field_content);
                                if (!C42252ah.isNullOrNil(apF.svN) && (apF.scene == 18 || C1829bf.m3750kE(apF.scene))) {
                                    C4990ab.m7416i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + apF.scene);
                                    break;
                                }
                                c7569ax = new C7569ax();
                                c7569ax.field_createTime = c6575cy.field_createTime;
                                c7569ax.field_isSend = 0;
                                c7569ax.field_msgContent = c6575cy.field_content;
                                c7569ax.field_svrId = c6575cy.field_msgSvrId;
                                c7569ax.field_talker = apF.svN;
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
                                C41789d.akO().mo17080b(c7569ax);
                                break;
                            case 40:
                                C4990ab.m7410d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + c6575cy.field_content);
                                C5135a apC = C5135a.apC(c6575cy.field_content);
                                c7569ax = new C7569ax();
                                c7569ax.field_createTime = c6575cy.field_createTime;
                                c7569ax.field_isSend = 0;
                                c7569ax.field_msgContent = c6575cy.field_content;
                                c7569ax.field_svrId = c6575cy.field_msgSvrId;
                                c7569ax.field_talker = apC.svN;
                                c7569ax.field_type = 0;
                                C41789d.akO().mo17080b(c7569ax);
                                break;
                            default:
                                C4990ab.m7416i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + c6575cy.getType());
                                break;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + c6575cy.field_msgId);
                } else {
                    C4990ab.m7412e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
                }
            }
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(143618, Integer.valueOf(0));
            C41789d.akP().dtc();
            C4990ab.m7410d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
            C9638aw.m17190ZK();
            C18628c.m29078XM().aoU("fmessage");
            LinkedList linkedList = new LinkedList();
            linkedList.add("fmessage");
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo15778aF(linkedList);
        }
        AppMethodBeat.m2505o(16435);
    }

    public final String getTag() {
        return "MicroMsg.FMessageDataTransfer";
    }
}
