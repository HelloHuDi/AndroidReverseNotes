package com.tencent.p177mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C32527cr;
import com.tencent.p177mm.p230g.p231a.C32527cr.C26106a;
import com.tencent.p177mm.p230g.p231a.C6515lt;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22558a;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C22672b;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.a */
public class C7189a implements C1816at {
    private C30857a tPu;
    private C4884c<C32527cr> tPv = new C71911();
    private C4884c<C6515lt> tPw = new C71902();

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.a$a */
    class C4470a implements C30857a {
        private C32527cr tPC;

        public C4470a(C32527cr c32527cr) {
            this.tPC = c32527cr;
        }

        /* renamed from: n */
        public final Intent mo7785n(int i, Bundle bundle) {
            AppMethodBeat.m2504i(48044);
            C4990ab.m7417i("MicroMsg.SubCoreECard", "open process end: %s", Integer.valueOf(i));
            if (i == -1) {
                this.tPC.cvN.retCode = 0;
                C7060h.pYm.mo8381e(14954, C46512f.dlI(), "openEcard:ok");
            } else {
                this.tPC.cvN.retCode = -1;
                if (!C46512f.dlH()) {
                    C7060h.pYm.mo8381e(14954, C46512f.dlI(), "openEcard:fail");
                }
            }
            this.tPC.cvM.callback.run();
            if (!C46512f.dlH()) {
                C46512f.dlJ();
            }
            C7189a.this.tPu = null;
            Intent intent = new Intent();
            intent.putExtras(bundle);
            AppMethodBeat.m2505o(48044);
            return intent;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.a$2 */
    class C71902 extends C4884c<C6515lt> {
        C71902() {
            AppMethodBeat.m2504i(48042);
            this.xxI = C6515lt.class.getName().hashCode();
            AppMethodBeat.m2505o(48042);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(48043);
            C6515lt c6515lt = (C6515lt) c4883b;
            int i = 1;
            if (c6515lt.cHB.scene > 0) {
                i = c6515lt.cHB.scene;
            }
            Context context = (Context) c6515lt.cHB.aIq.get();
            if (context != null) {
                C22672b.m34356a(i, null, "WEB_DEBIT", null, context, null);
            }
            AppMethodBeat.m2505o(48043);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.a$1 */
    class C71911 extends C4884c<C32527cr> {
        C71911() {
            AppMethodBeat.m2504i(48039);
            this.xxI = C32527cr.class.getName().hashCode();
            AppMethodBeat.m2505o(48039);
        }

        /* renamed from: a */
        private boolean m11999a(final C32527cr c32527cr) {
            AppMethodBeat.m2504i(48040);
            final C26106a c26106a = c32527cr.cvM;
            HashMap hashMap = new HashMap();
            if (!C5046bo.isNullOrNil(c26106a.packageExt)) {
                String[] split = c26106a.packageExt.split("&");
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!C5046bo.isNullOrNil(split[i])) {
                            String[] split2 = split[i].split("=");
                            if (split2.length == 2 && !C5046bo.isNullOrNil(split2[0])) {
                                hashMap.put(split2[0], split2[1]);
                            }
                        }
                    }
                }
            }
            final String str = (String) hashMap.get("extradata");
            C4990ab.m7417i("MicroMsg.SubCoreECard", "start openECard, extraData: %s, packageExt: %s", str, hashMap);
            C1207m c22558a = new C22558a(c26106a.appId, c26106a.cvO, c26106a.nonceStr, c26106a.packageExt, c26106a.signType, c26106a.signature, c26106a.cvP, 15, "openECard", c26106a.cvS);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(580, new C1202f() {
                public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48038);
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14546b(580, (C1202f) this);
                    if (i == 0 && i2 == 0) {
                        C4990ab.m7416i("MicroMsg.SubCoreECard", "jsapi check success");
                        C46512f.akr(((C22558a) c1207m).cOS());
                        Context context = (Context) c26106a.aIq.get();
                        if (context == null || !(context instanceof Activity)) {
                            c32527cr.cvN.retCode = -1;
                            c32527cr.cvM.callback.run();
                            AppMethodBeat.m2505o(48038);
                            return;
                        }
                        C7189a.this.tPu = new C4470a(c32527cr);
                        C22672b.m34356a(C5046bo.getInt(c32527cr.cvM.cvR, 0), c32527cr.cvM.token, c32527cr.cvM.cvQ, str, context, C7189a.this.tPu);
                        AppMethodBeat.m2505o(48038);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.SubCoreECard", "jsapi check fail");
                    c32527cr.cvN.retCode = -1;
                    c32527cr.cvM.callback.run();
                    AppMethodBeat.m2505o(48038);
                }
            });
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c22558a, 0);
            AppMethodBeat.m2505o(48040);
            return false;
        }
    }

    public C7189a() {
        AppMethodBeat.m2504i(48045);
        AppMethodBeat.m2505o(48045);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(48046);
        this.tPv.dnU();
        this.tPw.dnU();
        AppMethodBeat.m2505o(48046);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(48047);
        this.tPv.dead();
        this.tPw.dead();
        AppMethodBeat.m2505o(48047);
    }
}
