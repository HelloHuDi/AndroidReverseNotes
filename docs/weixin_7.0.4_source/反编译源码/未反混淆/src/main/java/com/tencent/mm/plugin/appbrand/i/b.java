package com.tencent.mm.plugin.appbrand.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import java.util.Map;

public enum b implements n {
    ;

    private b(String str) {
    }

    static {
        AppMethodBeat.o(132273);
    }

    public final com.tencent.mm.ai.e.b a(String str, Map<String, String> map, a aVar) {
        AppMethodBeat.i(132272);
        if (str == null || !str.equals("subscribesysmsg")) {
            ab.e("MicroMsg.WxaSubscribeSysmsgHandler", "subType is err, return");
            AppMethodBeat.o(132272);
            return null;
        }
        String str2 = (String) map.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey is null, return");
            AppMethodBeat.o(132272);
            return null;
        }
        ab.i("MicroMsg.WxaSubscribeSysmsgHandler", "consumeNewXml subType:%s", str);
        com.tencent.mm.af.a.b pn = ((k) g.K(k.class)).pn(str2);
        if (pn == null) {
            ab.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s wxaUpdateableMsg is null, ingore", str2);
            AppMethodBeat.o(132272);
            return null;
        } else if (pn.field_btnState != 2 || pn.field_msgState != 0) {
            ab.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s btnState:%d msgState:%d ingore", str2, Integer.valueOf(pn.field_btnState), Integer.valueOf(pn.field_msgState));
            AppMethodBeat.o(132272);
            return null;
        } else if (aVar == null || aVar.eAB == null) {
            ab.e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
            AppMethodBeat.o(132272);
            return null;
        } else {
            cm cmVar = aVar.eAB;
            String a = aa.a(cmVar.vED);
            String a2 = aa.a(cmVar.vEB);
            String a3 = aa.a(cmVar.vEC);
            bi Q = ((j) g.K(j.class)).bOr().Q(a2, cmVar.ptF);
            Object obj = null;
            if (Q.field_msgId > 0) {
                obj = 1;
            }
            Q.eI(cmVar.ptF);
            if (!(aVar.fsU && aVar.fsW)) {
                Q.eJ(bf.q(a2, (long) cmVar.pcX));
            }
            Q.setType(603979825);
            Q.setContent(a);
            Q.hO(0);
            Q.setStatus(3);
            if (a2.equals(r.Yz())) {
                Q.ju(a3);
            } else {
                Q.ju(a2);
            }
            Q.ix(cmVar.vEG);
            bf.a(Q, aVar);
            if (obj == null) {
                bf.l(Q);
            } else {
                ((j) g.K(j.class)).bOr().b(cmVar.ptF, Q);
            }
            ak aoZ = ((j) g.K(j.class)).XR().aoZ(Q.field_talker);
            if (aoZ != null) {
                aoZ.jj(33554432);
                int a4 = ((j) g.K(j.class)).XR().a(aoZ, Q.field_talker);
                ab.d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", Q.field_talker, Integer.valueOf(a4));
            } else {
                ab.d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
            }
            AppMethodBeat.o(132272);
            return null;
        }
    }
}
