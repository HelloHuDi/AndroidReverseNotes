package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.cge;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class i {
    private static boolean okX = false;
    private static List<a> okY = new ArrayList();

    public interface a {
        void a(cge cge);

        void b(bol bol);
    }

    static {
        AppMethodBeat.i(43115);
        AppMethodBeat.o(43115);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(a aVar, boolean z) {
        Throwable e;
        AppMethodBeat.i(43112);
        ab.i("MicroMsg.QueryWeChatWalletManager", "do query wechat wallet: %s", Boolean.valueOf(z));
        if (g.RK()) {
            int i;
            String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_PAGE_DATA_STRING_SYNC, null);
            if (bo.isNullOrNil(str)) {
                i = 0;
            } else {
                try {
                    cge cge = new cge();
                    cge.parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
                    if (aVar != null) {
                        try {
                            aVar.a(cge);
                        } catch (IOException e2) {
                            e = e2;
                            i = 1;
                            ab.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", e, "", new Object[0]);
                            okY.add(aVar);
                            if (okX) {
                            }
                            h.pYm.k(997, 1, 1);
                            AppMethodBeat.o(43112);
                            return;
                        }
                    }
                    i = 1;
                } catch (IOException e3) {
                    e = e3;
                    i = 0;
                    ab.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", e, "", new Object[0]);
                    okY.add(aVar);
                    if (okX) {
                    }
                    h.pYm.k(997, 1, 1);
                    AppMethodBeat.o(43112);
                    return;
                }
            }
            if (i == 0 || z) {
                if (!(aVar == null || okY.contains(aVar))) {
                    okY.add(aVar);
                }
                if (okX) {
                    ab.i("MicroMsg.QueryWeChatWalletManager", "is quering");
                } else {
                    okX = true;
                    e.a("wallet_balance_version", new b() {
                        public final void bZ(Object obj) {
                            AppMethodBeat.i(43111);
                            ab.i("MicroMsg.QueryWeChatWalletManager", "get from push done: %s", obj);
                            long j = 0;
                            if (obj instanceof Long) {
                                j = ((Long) obj).longValue();
                            }
                            new c(j).acy().h(new com.tencent.mm.vending.c.a<bol, com.tencent.mm.ai.a.a<bol>>() {
                                public final /* synthetic */ Object call(Object obj) {
                                    AppMethodBeat.i(43110);
                                    bol g = AnonymousClass2.g((com.tencent.mm.ai.a.a) obj);
                                    AppMethodBeat.o(43110);
                                    return g;
                                }

                                private static bol g(com.tencent.mm.ai.a.a<bol> aVar) {
                                    bol bol;
                                    AppMethodBeat.i(43109);
                                    ab.i("MicroMsg.QueryWeChatWalletManager", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
                                    if (aVar.errType == 0 && aVar.errCode == 0) {
                                        bol = (bol) aVar.fsy;
                                        if (bol.wRp != null) {
                                            try {
                                                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_PAGE_DATA_STRING_SYNC, new String(bol.wRp.toByteArray(), org.apache.commons.a.a.ISO_8859_1));
                                            } catch (IOException e) {
                                                ab.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", e, "", new Object[0]);
                                            }
                                        }
                                        if (bol.wRq != null) {
                                            ab.i("MicroMsg.QueryWeChatWalletManager", "wallet balance: %s", Long.valueOf(bol.wRq.xqj));
                                            ak cPI = r.cPI();
                                            if (cPI.tCT == null) {
                                                cPI.tCT = r.cPE().cRh();
                                            }
                                            aj ajVar = cPI.tCT;
                                            ajVar.field_wallet_balance = bol.wRq.xqj;
                                            r.cPI().a(ajVar);
                                        }
                                    }
                                    bol = (bol) aVar.fsy;
                                    AppMethodBeat.o(43109);
                                    return bol;
                                }
                            }).b(new com.tencent.mm.vending.c.a<Object, bol>() {
                                public final /* synthetic */ Object call(Object obj) {
                                    AppMethodBeat.i(43108);
                                    bol bol = (bol) obj;
                                    ab.i("MicroMsg.QueryWeChatWalletManager", "callback ui");
                                    i.okX = false;
                                    i.a(bol);
                                    AppMethodBeat.o(43108);
                                    return null;
                                }
                            });
                            AppMethodBeat.o(43111);
                        }
                    });
                }
                if (i == 0 && !z) {
                    h.pYm.k(997, 1, 1);
                }
            }
            AppMethodBeat.o(43112);
            return;
        }
        ab.w("MicroMsg.QueryWeChatWalletManager", "account not ready");
        AppMethodBeat.o(43112);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(43113);
        ab.d("MicroMsg.QueryWeChatWalletManager", "remove ret: %s", Boolean.valueOf(okY.remove(aVar)));
        AppMethodBeat.o(43113);
    }
}
