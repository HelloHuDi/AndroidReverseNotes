package com.tencent.p177mm.plugin.wallet.p748a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26252uk;
import com.tencent.p177mm.p230g.p231a.C26252uk.C26253a;
import com.tencent.p177mm.plugin.wallet_core.p749c.p750a.C7183a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.wallet.a.l */
public final class C35395l extends C4884c<C26252uk> {
    public C35395l() {
        AppMethodBeat.m2504i(45843);
        this.xxI = C26252uk.class.getName().hashCode();
        AppMethodBeat.m2505o(45843);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(45845);
        final C26252uk c26252uk = (C26252uk) c4883b;
        C1720g.m3537RQ();
        final int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        int YG = C1853r.m3825YG();
        c26252uk.cQD.retCode = 0;
        if (YG == 4) {
            if (intValue != c26252uk.cQC.cQG) {
                C4990ab.m7417i("MicroMsg.HandleWCPayWalletBufferListener", "wrong region, client: %s, req: %s", Integer.valueOf(intValue), Integer.valueOf(c26252uk.cQC.cQG));
                c26252uk.cQD.retCode = -1;
            } else if ("fetch".equals(c26252uk.cQC.action)) {
                String str;
                C4990ab.m7416i("MicroMsg.HandleWCPayWalletBufferListener", "do fetch");
                switch (intValue) {
                    case 1:
                        C1720g.m3537RQ();
                        str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WCPAY_WALLET_BUFFER_CN_STRING_SYNC, (Object) "");
                        break;
                    case 2:
                        C1720g.m3537RQ();
                        str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WCPAY_WALLET_BUFFER_MY_STRING_SYNC, (Object) "");
                        break;
                    case 4:
                        C1720g.m3537RQ();
                        str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WCPAY_WALLET_BUFFER_ZA_STRING_SYNC, (Object) "");
                        break;
                    case 8:
                        C1720g.m3537RQ();
                        str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WCPAY_WALLET_BUFFER_HK_STRING_SYNC, (Object) "");
                        break;
                    default:
                        str = "";
                        break;
                }
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7416i("MicroMsg.HandleWCPayWalletBufferListener", "fetch empty buffer");
                    c26252uk.cQD.retCode = -2;
                } else {
                    C35395l.m58090a(c26252uk, new C1202f() {
                        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                            AppMethodBeat.m2504i(45841);
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14546b(1767, (C1202f) this);
                            if (i == 0 && i2 == 0) {
                                c26252uk.cQD.buffer = str;
                                c26252uk.cQD.cQH.run();
                                AppMethodBeat.m2505o(45841);
                                return;
                            }
                            C4990ab.m7417i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", Integer.valueOf(i2), str);
                            c26252uk.cQD.retCode = -1;
                            c26252uk.cQD.cQH.run();
                            AppMethodBeat.m2505o(45841);
                        }
                    });
                    AppMethodBeat.m2505o(45845);
                }
            } else if ("save".equals(c26252uk.cQC.action)) {
                C4990ab.m7416i("MicroMsg.HandleWCPayWalletBufferListener", "do save");
                C35395l.m58090a(c26252uk, new C1202f() {
                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(45842);
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14546b(1767, (C1202f) this);
                        if (i == 0 && i2 == 0) {
                            int i3 = intValue;
                            Object obj = c26252uk.cQC.buffer;
                            switch (i3) {
                                case 1:
                                    C1720g.m3537RQ();
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WCPAY_WALLET_BUFFER_CN_STRING_SYNC, obj);
                                    break;
                                case 2:
                                    C1720g.m3537RQ();
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WCPAY_WALLET_BUFFER_MY_STRING_SYNC, obj);
                                    break;
                                case 4:
                                    C1720g.m3537RQ();
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WCPAY_WALLET_BUFFER_ZA_STRING_SYNC, obj);
                                    break;
                                case 8:
                                    C1720g.m3537RQ();
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WCPAY_WALLET_BUFFER_HK_STRING_SYNC, obj);
                                    break;
                            }
                            c26252uk.cQD.cQH.run();
                            AppMethodBeat.m2505o(45842);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", Integer.valueOf(i2), str);
                        c26252uk.cQD.retCode = -1;
                        c26252uk.cQD.cQH.run();
                        AppMethodBeat.m2505o(45842);
                    }
                });
                AppMethodBeat.m2505o(45845);
            } else {
                C4990ab.m7417i("MicroMsg.HandleWCPayWalletBufferListener", "wrong action: %s", c26252uk.cQC.action);
                c26252uk.cQD.retCode = -1;
            }
            c26252uk.cQD.cQH.run();
            AppMethodBeat.m2505o(45845);
        } else {
            C4990ab.m7417i("MicroMsg.HandleWCPayWalletBufferListener", "wrong type: %s", Integer.valueOf(YG));
            c26252uk.cQD.retCode = -1;
            c26252uk.cQD.cQH.run();
            AppMethodBeat.m2505o(45845);
        }
        return false;
    }

    /* renamed from: a */
    private static void m58090a(C26252uk c26252uk, C1202f c1202f) {
        AppMethodBeat.m2504i(45844);
        C4990ab.m7416i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1767, c1202f);
        C26253a c26253a = c26252uk.cQC;
        C4990ab.m7417i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", c26253a.appId, c26253a.nonceStr, c26253a.cvO, c26253a.cQE, c26253a.cQF, c26253a.signType, c26253a.url);
        C1207m c7183a = new C7183a(c26253a.appId, c26253a.nonceStr, c26253a.cvO, c26253a.cQE, c26253a.cQF, c26253a.signType, c26253a.url);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c7183a, 0);
        AppMethodBeat.m2505o(45844);
    }
}
