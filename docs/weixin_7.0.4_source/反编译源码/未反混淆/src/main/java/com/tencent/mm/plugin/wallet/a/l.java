package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.uk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;

public final class l extends c<uk> {
    public l() {
        AppMethodBeat.i(45843);
        this.xxI = uk.class.getName().hashCode();
        AppMethodBeat.o(45843);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(45845);
        final uk ukVar = (uk) bVar;
        g.RQ();
        final int intValue = ((Integer) g.RP().Ry().get(a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        int YG = r.YG();
        ukVar.cQD.retCode = 0;
        if (YG == 4) {
            if (intValue != ukVar.cQC.cQG) {
                ab.i("MicroMsg.HandleWCPayWalletBufferListener", "wrong region, client: %s, req: %s", Integer.valueOf(intValue), Integer.valueOf(ukVar.cQC.cQG));
                ukVar.cQD.retCode = -1;
            } else if ("fetch".equals(ukVar.cQC.action)) {
                String str;
                ab.i("MicroMsg.HandleWCPayWalletBufferListener", "do fetch");
                switch (intValue) {
                    case 1:
                        g.RQ();
                        str = (String) g.RP().Ry().get(a.USERINFO_WCPAY_WALLET_BUFFER_CN_STRING_SYNC, (Object) "");
                        break;
                    case 2:
                        g.RQ();
                        str = (String) g.RP().Ry().get(a.USERINFO_WCPAY_WALLET_BUFFER_MY_STRING_SYNC, (Object) "");
                        break;
                    case 4:
                        g.RQ();
                        str = (String) g.RP().Ry().get(a.USERINFO_WCPAY_WALLET_BUFFER_ZA_STRING_SYNC, (Object) "");
                        break;
                    case 8:
                        g.RQ();
                        str = (String) g.RP().Ry().get(a.USERINFO_WCPAY_WALLET_BUFFER_HK_STRING_SYNC, (Object) "");
                        break;
                    default:
                        str = "";
                        break;
                }
                if (bo.isNullOrNil(str)) {
                    ab.i("MicroMsg.HandleWCPayWalletBufferListener", "fetch empty buffer");
                    ukVar.cQD.retCode = -2;
                } else {
                    a(ukVar, new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(45841);
                            g.RQ();
                            g.RO().eJo.b(1767, (f) this);
                            if (i == 0 && i2 == 0) {
                                ukVar.cQD.buffer = str;
                                ukVar.cQD.cQH.run();
                                AppMethodBeat.o(45841);
                                return;
                            }
                            ab.i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", Integer.valueOf(i2), str);
                            ukVar.cQD.retCode = -1;
                            ukVar.cQD.cQH.run();
                            AppMethodBeat.o(45841);
                        }
                    });
                    AppMethodBeat.o(45845);
                }
            } else if ("save".equals(ukVar.cQC.action)) {
                ab.i("MicroMsg.HandleWCPayWalletBufferListener", "do save");
                a(ukVar, new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(45842);
                        g.RQ();
                        g.RO().eJo.b(1767, (f) this);
                        if (i == 0 && i2 == 0) {
                            int i3 = intValue;
                            Object obj = ukVar.cQC.buffer;
                            switch (i3) {
                                case 1:
                                    g.RQ();
                                    g.RP().Ry().set(a.USERINFO_WCPAY_WALLET_BUFFER_CN_STRING_SYNC, obj);
                                    break;
                                case 2:
                                    g.RQ();
                                    g.RP().Ry().set(a.USERINFO_WCPAY_WALLET_BUFFER_MY_STRING_SYNC, obj);
                                    break;
                                case 4:
                                    g.RQ();
                                    g.RP().Ry().set(a.USERINFO_WCPAY_WALLET_BUFFER_ZA_STRING_SYNC, obj);
                                    break;
                                case 8:
                                    g.RQ();
                                    g.RP().Ry().set(a.USERINFO_WCPAY_WALLET_BUFFER_HK_STRING_SYNC, obj);
                                    break;
                            }
                            ukVar.cQD.cQH.run();
                            AppMethodBeat.o(45842);
                            return;
                        }
                        ab.i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", Integer.valueOf(i2), str);
                        ukVar.cQD.retCode = -1;
                        ukVar.cQD.cQH.run();
                        AppMethodBeat.o(45842);
                    }
                });
                AppMethodBeat.o(45845);
            } else {
                ab.i("MicroMsg.HandleWCPayWalletBufferListener", "wrong action: %s", ukVar.cQC.action);
                ukVar.cQD.retCode = -1;
            }
            ukVar.cQD.cQH.run();
            AppMethodBeat.o(45845);
        } else {
            ab.i("MicroMsg.HandleWCPayWalletBufferListener", "wrong type: %s", Integer.valueOf(YG));
            ukVar.cQD.retCode = -1;
            ukVar.cQD.cQH.run();
            AppMethodBeat.o(45845);
        }
        return false;
    }

    private static void a(uk ukVar, f fVar) {
        AppMethodBeat.i(45844);
        ab.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
        g.RQ();
        g.RO().eJo.a(1767, fVar);
        uk.a aVar = ukVar.cQC;
        ab.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", aVar.appId, aVar.nonceStr, aVar.cvO, aVar.cQE, aVar.cQF, aVar.signType, aVar.url);
        m aVar2 = new com.tencent.mm.plugin.wallet_core.c.a.a(aVar.appId, aVar.nonceStr, aVar.cvO, aVar.cQE, aVar.cQF, aVar.signType, aVar.url);
        g.RQ();
        g.RO().eJo.a(aVar2, 0);
        AppMethodBeat.o(45844);
    }
}
