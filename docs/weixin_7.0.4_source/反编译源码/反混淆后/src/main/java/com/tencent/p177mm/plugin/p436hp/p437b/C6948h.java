package com.tencent.p177mm.plugin.p436hp.p437b;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tinkerboots.sdk.C44598a;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.hp.b.h */
public final class C6948h implements C1837a {
    /* renamed from: a */
    public final void mo5414a(C1197a c1197a) {
        AppMethodBeat.m2504i(90613);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm.nao == 10002) {
            String a = C1946aa.m4148a(c7254cm.vED);
            if (C5046bo.isNullOrNil(a)) {
                C4990ab.m7420w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
                AppMethodBeat.m2505o(90613);
                return;
            }
            C4990ab.m7417i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "onReciveMsg :%s", a);
            Map z = C5049br.m7595z(a, "sysmsg");
            if (z != null && z.size() > 0) {
                a = (String) z.get(".sysmsg.$type");
                if (!C5046bo.isNullOrNil(a) && a.equalsIgnoreCase("prconfignotify")) {
                    int ank = C5046bo.ank((String) z.get(".sysmsg.boots.ignorenetwork"));
                    String bc = C5046bo.m7532bc((String) z.get(".sysmsg.boots.xmlkey"), "");
                    C4990ab.m7417i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", Integer.valueOf(ank), bc);
                    C44598a iN = C44598a.dWj().mo71471iN(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(((long) C1668a.m3396Ra()) & 4294967295L));
                    String str = TencentLocation.NETWORK_PROVIDER;
                    int i = (C5023at.isWifi(C4996ah.getContext()) || ank == 1) ? 3 : 2;
                    iN.mo71471iN(str, String.valueOf(i));
                    if (!C5046bo.isNullOrNil(bc)) {
                        C44598a.dWj().mo71471iN("xmlkey", bc);
                    }
                    C44598a.dWj().mo71472rF(true);
                }
            }
        }
        AppMethodBeat.m2505o(90613);
    }
}
