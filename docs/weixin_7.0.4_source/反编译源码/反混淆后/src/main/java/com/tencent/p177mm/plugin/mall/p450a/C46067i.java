package com.tencent.p177mm.plugin.mall.p450a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22586aj;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.protocal.protobuf.bol;
import com.tencent.p177mm.protocal.protobuf.cge;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C36391e.C16099b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.p1431a.C41168a;

/* renamed from: com.tencent.mm.plugin.mall.a.i */
public final class C46067i {
    private static boolean okX = false;
    private static List<C3432a> okY = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.mall.a.i$a */
    public interface C3432a {
        /* renamed from: a */
        void mo7872a(cge cge);

        /* renamed from: b */
        void mo7873b(bol bol);
    }

    /* renamed from: com.tencent.mm.plugin.mall.a.i$1 */
    static class C393511 implements C16099b {

        /* renamed from: com.tencent.mm.plugin.mall.a.i$1$2 */
        class C393522 implements C5681a<bol, C37441a<bol>> {
            C393522() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(43110);
                bol g = C393522.m67096g((C37441a) obj);
                AppMethodBeat.m2505o(43110);
                return g;
            }

            /* renamed from: g */
            private static bol m67096g(C37441a<bol> c37441a) {
                bol bol;
                AppMethodBeat.m2504i(43109);
                C4990ab.m7417i("MicroMsg.QueryWeChatWalletManager", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
                if (c37441a.errType == 0 && c37441a.errCode == 0) {
                    bol = (bol) c37441a.fsy;
                    if (bol.wRp != null) {
                        try {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_PAGE_DATA_STRING_SYNC, new String(bol.wRp.toByteArray(), C41168a.ISO_8859_1));
                        } catch (IOException e) {
                            C4990ab.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", e, "", new Object[0]);
                        }
                    }
                    if (bol.wRq != null) {
                        C4990ab.m7417i("MicroMsg.QueryWeChatWalletManager", "wallet balance: %s", Long.valueOf(bol.wRq.xqj));
                        C22587ak cPI = C14241r.cPI();
                        if (cPI.tCT == null) {
                            cPI.tCT = C14241r.cPE().cRh();
                        }
                        C22586aj c22586aj = cPI.tCT;
                        c22586aj.field_wallet_balance = bol.wRq.xqj;
                        C14241r.cPI().mo38132a(c22586aj);
                    }
                }
                bol = (bol) c37441a.fsy;
                AppMethodBeat.m2505o(43109);
                return bol;
            }
        }

        /* renamed from: com.tencent.mm.plugin.mall.a.i$1$1 */
        class C393531 implements C5681a<Object, bol> {
            C393531() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(43108);
                bol bol = (bol) obj;
                C4990ab.m7416i("MicroMsg.QueryWeChatWalletManager", "callback ui");
                C46067i.okX = false;
                C46067i.m85828a(bol);
                AppMethodBeat.m2505o(43108);
                return null;
            }
        }

        C393511() {
        }

        /* renamed from: bZ */
        public final void mo28534bZ(Object obj) {
            AppMethodBeat.m2504i(43111);
            C4990ab.m7417i("MicroMsg.QueryWeChatWalletManager", "get from push done: %s", obj);
            long j = 0;
            if (obj instanceof Long) {
                j = ((Long) obj).longValue();
            }
            new C41295c(j).acy().mo60492h(new C393522()).mo60487b(new C393531());
            AppMethodBeat.m2505o(43111);
        }
    }

    static {
        AppMethodBeat.m2504i(43115);
        AppMethodBeat.m2505o(43115);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m85827a(C3432a c3432a, boolean z) {
        Throwable e;
        AppMethodBeat.m2504i(43112);
        C4990ab.m7417i("MicroMsg.QueryWeChatWalletManager", "do query wechat wallet: %s", Boolean.valueOf(z));
        if (C1720g.m3531RK()) {
            int i;
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_PAGE_DATA_STRING_SYNC, null);
            if (C5046bo.isNullOrNil(str)) {
                i = 0;
            } else {
                try {
                    cge cge = new cge();
                    cge.parseFrom(str.getBytes(C41168a.ISO_8859_1));
                    if (c3432a != null) {
                        try {
                            c3432a.mo7872a(cge);
                        } catch (IOException e2) {
                            e = e2;
                            i = 1;
                            C4990ab.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", e, "", new Object[0]);
                            okY.add(c3432a);
                            if (okX) {
                            }
                            C7060h.pYm.mo15419k(997, 1, 1);
                            AppMethodBeat.m2505o(43112);
                            return;
                        }
                    }
                    i = 1;
                } catch (IOException e3) {
                    e = e3;
                    i = 0;
                    C4990ab.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", e, "", new Object[0]);
                    okY.add(c3432a);
                    if (okX) {
                    }
                    C7060h.pYm.mo15419k(997, 1, 1);
                    AppMethodBeat.m2505o(43112);
                    return;
                }
            }
            if (i == 0 || z) {
                if (!(c3432a == null || okY.contains(c3432a))) {
                    okY.add(c3432a);
                }
                if (okX) {
                    C4990ab.m7416i("MicroMsg.QueryWeChatWalletManager", "is quering");
                } else {
                    okX = true;
                    C36391e.m59986a("wallet_balance_version", new C393511());
                }
                if (i == 0 && !z) {
                    C7060h.pYm.mo15419k(997, 1, 1);
                }
            }
            AppMethodBeat.m2505o(43112);
            return;
        }
        C4990ab.m7420w("MicroMsg.QueryWeChatWalletManager", "account not ready");
        AppMethodBeat.m2505o(43112);
    }

    /* renamed from: a */
    public static void m85826a(C3432a c3432a) {
        AppMethodBeat.m2504i(43113);
        C4990ab.m7411d("MicroMsg.QueryWeChatWalletManager", "remove ret: %s", Boolean.valueOf(okY.remove(c3432a)));
        AppMethodBeat.m2505o(43113);
    }
}
