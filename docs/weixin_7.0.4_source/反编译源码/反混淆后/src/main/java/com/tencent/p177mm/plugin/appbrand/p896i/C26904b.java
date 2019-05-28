package com.tencent.p177mm.plugin.appbrand.p896i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelappbrand.C45446k;
import com.tencent.p177mm.p181af.p1175a.C17871b;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3472n;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.i.b */
public enum C26904b implements C3472n {
    ;

    private C26904b(String str) {
    }

    static {
        AppMethodBeat.m2505o(132273);
    }

    /* renamed from: a */
    public final C1198b mo7932a(String str, Map<String, String> map, C1197a c1197a) {
        AppMethodBeat.m2504i(132272);
        if (str == null || !str.equals("subscribesysmsg")) {
            C4990ab.m7412e("MicroMsg.WxaSubscribeSysmsgHandler", "subType is err, return");
            AppMethodBeat.m2505o(132272);
            return null;
        }
        String str2 = (String) map.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey is null, return");
            AppMethodBeat.m2505o(132272);
            return null;
        }
        C4990ab.m7417i("MicroMsg.WxaSubscribeSysmsgHandler", "consumeNewXml subType:%s", str);
        C17871b pn = ((C45446k) C1720g.m3528K(C45446k.class)).mo60978pn(str2);
        if (pn == null) {
            C4990ab.m7413e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s wxaUpdateableMsg is null, ingore", str2);
            AppMethodBeat.m2505o(132272);
            return null;
        } else if (pn.field_btnState != 2 || pn.field_msgState != 0) {
            C4990ab.m7413e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s btnState:%d msgState:%d ingore", str2, Integer.valueOf(pn.field_btnState), Integer.valueOf(pn.field_msgState));
            AppMethodBeat.m2505o(132272);
            return null;
        } else if (c1197a == null || c1197a.eAB == null) {
            C4990ab.m7412e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
            AppMethodBeat.m2505o(132272);
            return null;
        } else {
            C7254cm c7254cm = c1197a.eAB;
            String a = C1946aa.m4148a(c7254cm.vED);
            String a2 = C1946aa.m4148a(c7254cm.vEB);
            String a3 = C1946aa.m4148a(c7254cm.vEC);
            C7620bi Q = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(a2, c7254cm.ptF);
            Object obj = null;
            if (Q.field_msgId > 0) {
                obj = 1;
            }
            Q.mo14774eI(c7254cm.ptF);
            if (!(c1197a.fsU && c1197a.fsW)) {
                Q.mo14775eJ(C1829bf.m3764q(a2, (long) c7254cm.pcX));
            }
            Q.setType(603979825);
            Q.setContent(a);
            Q.mo14781hO(0);
            Q.setStatus(3);
            if (a2.equals(C1853r.m3846Yz())) {
                Q.mo14794ju(a3);
            } else {
                Q.mo14794ju(a2);
            }
            Q.mo14791ix(c7254cm.vEG);
            C1829bf.m3743a(Q, c1197a);
            if (obj == null) {
                C1829bf.m3752l(Q);
            } else {
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(c7254cm.ptF, Q);
            }
            C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(Q.field_talker);
            if (aoZ != null) {
                aoZ.mo16712jj(33554432);
                int a4 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, Q.field_talker);
                C4990ab.m7411d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", Q.field_talker, Integer.valueOf(a4));
            } else {
                C4990ab.m7410d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
            }
            AppMethodBeat.m2505o(132272);
            return null;
        }
    }
}
