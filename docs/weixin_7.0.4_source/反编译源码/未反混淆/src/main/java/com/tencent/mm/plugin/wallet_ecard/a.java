package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class a implements at {
    private com.tencent.mm.wallet_core.c.a tPu;
    private c<cr> tPv = new c<cr>() {
        {
            AppMethodBeat.i(48039);
            this.xxI = cr.class.getName().hashCode();
            AppMethodBeat.o(48039);
        }

        private boolean a(final cr crVar) {
            AppMethodBeat.i(48040);
            final com.tencent.mm.g.a.cr.a aVar = crVar.cvM;
            HashMap hashMap = new HashMap();
            if (!bo.isNullOrNil(aVar.packageExt)) {
                String[] split = aVar.packageExt.split("&");
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!bo.isNullOrNil(split[i])) {
                            String[] split2 = split[i].split("=");
                            if (split2.length == 2 && !bo.isNullOrNil(split2[0])) {
                                hashMap.put(split2[0], split2[1]);
                            }
                        }
                    }
                }
            }
            final String str = (String) hashMap.get("extradata");
            ab.i("MicroMsg.SubCoreECard", "start openECard, extraData: %s, packageExt: %s", str, hashMap);
            m aVar2 = new com.tencent.mm.plugin.wallet_core.c.a(aVar.appId, aVar.cvO, aVar.nonceStr, aVar.packageExt, aVar.signType, aVar.signature, aVar.cvP, 15, "openECard", aVar.cvS);
            g.RQ();
            g.RO().eJo.a(580, new f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48038);
                    g.RQ();
                    g.RO().eJo.b(580, (f) this);
                    if (i == 0 && i2 == 0) {
                        ab.i("MicroMsg.SubCoreECard", "jsapi check success");
                        com.tencent.mm.pluginsdk.wallet.f.akr(((com.tencent.mm.plugin.wallet_core.c.a) mVar).cOS());
                        Context context = (Context) aVar.aIq.get();
                        if (context == null || !(context instanceof Activity)) {
                            crVar.cvN.retCode = -1;
                            crVar.cvM.callback.run();
                            AppMethodBeat.o(48038);
                            return;
                        }
                        a.this.tPu = new a(crVar);
                        b.a(bo.getInt(crVar.cvM.cvR, 0), crVar.cvM.token, crVar.cvM.cvQ, str, context, a.this.tPu);
                        AppMethodBeat.o(48038);
                        return;
                    }
                    ab.e("MicroMsg.SubCoreECard", "jsapi check fail");
                    crVar.cvN.retCode = -1;
                    crVar.cvM.callback.run();
                    AppMethodBeat.o(48038);
                }
            });
            g.RQ();
            g.RO().eJo.a(aVar2, 0);
            AppMethodBeat.o(48040);
            return false;
        }
    };
    private c<lt> tPw = new c<lt>() {
        {
            AppMethodBeat.i(48042);
            this.xxI = lt.class.getName().hashCode();
            AppMethodBeat.o(48042);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(48043);
            lt ltVar = (lt) bVar;
            int i = 1;
            if (ltVar.cHB.scene > 0) {
                i = ltVar.cHB.scene;
            }
            Context context = (Context) ltVar.cHB.aIq.get();
            if (context != null) {
                b.a(i, null, "WEB_DEBIT", null, context, null);
            }
            AppMethodBeat.o(48043);
            return false;
        }
    };

    class a implements com.tencent.mm.wallet_core.c.a {
        private cr tPC;

        public a(cr crVar) {
            this.tPC = crVar;
        }

        public final Intent n(int i, Bundle bundle) {
            AppMethodBeat.i(48044);
            ab.i("MicroMsg.SubCoreECard", "open process end: %s", Integer.valueOf(i));
            if (i == -1) {
                this.tPC.cvN.retCode = 0;
                h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "openEcard:ok");
            } else {
                this.tPC.cvN.retCode = -1;
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "openEcard:fail");
                }
            }
            this.tPC.cvM.callback.run();
            if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                com.tencent.mm.pluginsdk.wallet.f.dlJ();
            }
            a.this.tPu = null;
            Intent intent = new Intent();
            intent.putExtras(bundle);
            AppMethodBeat.o(48044);
            return intent;
        }
    }

    public a() {
        AppMethodBeat.i(48045);
        AppMethodBeat.o(48045);
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(48046);
        this.tPv.dnU();
        this.tPw.dnU();
        AppMethodBeat.o(48046);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(48047);
        this.tPv.dead();
        this.tPw.dead();
        AppMethodBeat.o(48047);
    }
}
