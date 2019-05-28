package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import java.util.LinkedList;

public final class g extends ai {
    public final boolean kw(int i) {
        return i != 0 && i < 604307701;
    }

    public final void transfer(int i) {
        AppMethodBeat.i(16435);
        if (i != 0 && i < 604307701) {
            h.pYm.k(336, 11, 1);
            aw.ZK();
            bi[] cC = c.XO().cC("fmessage", 20);
            if (cC == null) {
                ab.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
                AppMethodBeat.o(16435);
                return;
            }
            d.akP();
            ab.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + cC.length);
            for (cy cyVar : cC) {
                if (cyVar != null && cyVar.field_msgId != 0) {
                    ab.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + cyVar.getType());
                    String str = cyVar.field_content;
                    if (str != null && str.length() != 0) {
                        ax axVar;
                        switch (cyVar.getType()) {
                            case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
                                ab.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + cyVar.field_content);
                                bi.d apF = bi.d.apF(cyVar.field_content);
                                if (!ah.isNullOrNil(apF.svN) && (apF.scene == 18 || bf.kE(apF.scene))) {
                                    ab.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + apF.scene);
                                    break;
                                }
                                axVar = new ax();
                                axVar.field_createTime = cyVar.field_createTime;
                                axVar.field_isSend = 0;
                                axVar.field_msgContent = cyVar.field_content;
                                axVar.field_svrId = cyVar.field_msgSvrId;
                                axVar.field_talker = apF.svN;
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
                                d.akO().b(axVar);
                                break;
                            case 40:
                                ab.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + cyVar.field_content);
                                a apC = a.apC(cyVar.field_content);
                                axVar = new ax();
                                axVar.field_createTime = cyVar.field_createTime;
                                axVar.field_isSend = 0;
                                axVar.field_msgContent = cyVar.field_content;
                                axVar.field_svrId = cyVar.field_msgSvrId;
                                axVar.field_talker = apC.svN;
                                axVar.field_type = 0;
                                d.akO().b(axVar);
                                break;
                            default:
                                ab.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + cyVar.getType());
                                break;
                        }
                    }
                    ab.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + cyVar.field_msgId);
                } else {
                    ab.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
                }
            }
            aw.ZK();
            c.Ry().set(143618, Integer.valueOf(0));
            d.akP().dtc();
            ab.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
            aw.ZK();
            c.XM().aoU("fmessage");
            LinkedList linkedList = new LinkedList();
            linkedList.add("fmessage");
            aw.ZK();
            c.XR().aF(linkedList);
        }
        AppMethodBeat.o(16435);
    }

    public final String getTag() {
        return "MicroMsg.FMessageDataTransfer";
    }
}
