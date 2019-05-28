package com.tencent.mm.plugin.hp.b;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.Map;

public final class h implements a {
    public final void a(e.a aVar) {
        AppMethodBeat.i(90613);
        cm cmVar = aVar.eAB;
        if (cmVar.nao == 10002) {
            String a = aa.a(cmVar.vED);
            if (bo.isNullOrNil(a)) {
                ab.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
                AppMethodBeat.o(90613);
                return;
            }
            ab.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "onReciveMsg :%s", a);
            Map z = br.z(a, "sysmsg");
            if (z != null && z.size() > 0) {
                a = (String) z.get(".sysmsg.$type");
                if (!bo.isNullOrNil(a) && a.equalsIgnoreCase("prconfignotify")) {
                    int ank = bo.ank((String) z.get(".sysmsg.boots.ignorenetwork"));
                    String bc = bo.bc((String) z.get(".sysmsg.boots.xmlkey"), "");
                    ab.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", Integer.valueOf(ank), bc);
                    com.tinkerboots.sdk.a iN = com.tinkerboots.sdk.a.dWj().iN(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(((long) com.tencent.mm.kernel.a.Ra()) & 4294967295L));
                    String str = TencentLocation.NETWORK_PROVIDER;
                    int i = (at.isWifi(ah.getContext()) || ank == 1) ? 3 : 2;
                    iN.iN(str, String.valueOf(i));
                    if (!bo.isNullOrNil(bc)) {
                        com.tinkerboots.sdk.a.dWj().iN("xmlkey", bc);
                    }
                    com.tinkerboots.sdk.a.dWj().rF(true);
                }
            }
        }
        AppMethodBeat.o(90613);
    }
}
