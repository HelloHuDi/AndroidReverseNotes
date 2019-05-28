package com.tencent.p177mm.plugin.wallet_payu.pay.p572ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletOrderInfoOldUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.p1659b.C46358a;
import com.tencent.p177mm.plugin.wallet_payu.p1561a.C43823d;
import com.tencent.p177mm.plugin.wallet_payu.pay.p571a.C22700a;
import com.tencent.p177mm.plugin.wallet_payu.pay.p571a.C36856c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p649c.C44431r;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUOrderInfoUI */
public class WalletPayUOrderInfoUI extends WalletOrderInfoOldUI {

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUOrderInfoUI$1 */
    class C44991 implements OnClickListener {
        C44991() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48476);
            C24143a.m37113b(WalletPayUOrderInfoUI.this, WalletPayUOrderInfoUI.this.mBundle, 0);
            AppMethodBeat.m2505o(48476);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48477);
        super.onCreate(bundle);
        mo39992nf(1554);
        AppMethodBeat.m2505o(48477);
    }

    public final void cRI() {
        AppMethodBeat.m2504i(48478);
        mo39970a(new C46358a(), true, true);
        AppMethodBeat.m2505o(48478);
    }

    public final void adb(String str) {
        AppMethodBeat.m2504i(48479);
        mo39970a(new C36856c(str, 1), true, true);
        AppMethodBeat.m2505o(48479);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(48480);
        mo39993ng(1554);
        super.onDestroy();
        AppMethodBeat.m2505o(48480);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48481);
        if (c1207m instanceof C22700a) {
            AppMethodBeat.m2505o(48481);
            return true;
        }
        if (c1207m instanceof C36856c) {
            C36856c c36856c = (C36856c) c1207m;
            if (c36856c.pWy.tAq == null || c36856c.pWy.tAq.size() <= 0) {
                C4990ab.m7420w("MicroMsg.WalletPayUOrderInfoUI", "hy: no commodity. show alert");
                C30379h.m48431a((Context) this, (int) C25738R.string.fph, (int) C25738R.string.f9238tz, new C44991());
            } else {
                Commodity commodity = (Commodity) c36856c.pWy.tAq.get(0);
                C4990ab.m7410d("MicroMsg.WalletPayUOrderInfoUI", "Coomdity:".concat(String.valueOf(commodity)));
                C43823d.cTf().tTA = null;
                if (commodity != null) {
                    this.tId = new ArrayList();
                    this.tId.add(commodity);
                    C1720g.m3537RQ();
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(commodity.pcm);
                    if (aoO == null || ((int) aoO.ewQ) == 0) {
                        C26417a.flu.mo20966a(commodity.pcm, "", this.tIU);
                    } else {
                        mo47912S(aoO);
                    }
                    this.tIN.notifyDataSetChanged();
                    cRJ();
                }
            }
        }
        boolean c = super.mo7885c(i, i2, str, c1207m);
        AppMethodBeat.m2505o(48481);
        return c;
    }

    public final void done() {
        String str;
        AppMethodBeat.m2504i(48482);
        cRq();
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.mBundle.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.mBundle.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.mBundle.getBoolean("intent_pay_end"));
        C4990ab.m7416i("MicroMsg.WalletPayUOrderInfoUI", "pay done...feedbackData errCode:" + this.mBundle.getInt("intent_pay_end_errcode"));
        for (String str2 : this.tIc) {
            if (!C5046bo.isNullOrNil(str2)) {
                C4990ab.m7411d("MicroMsg.WalletPayUOrderInfoUI", "hy: doing netscene subscribe...appName: %s", str2);
                mo39970a(new C44431r(str2), false, false);
            }
        }
        C24143a.m37116j(this, bundle);
        if (!(this.tog == null || C5046bo.isNullOrNil(this.tog.lvz))) {
            str2 = this.tog.tAq.size() > 0 ? ((Commodity) this.tog.tAq.get(0)).cAa : "";
            str2 = String.format("%sreqkey=%s&transid=%s", new Object[]{this.tog.lvz, this.tog.czZ, str2});
            C4990ab.m7410d("MicroMsg.WalletPayUOrderInfoUI", "url = ".concat(String.valueOf(str2)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", C1853r.m3846Yz());
            C25985d.m41467b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.m2505o(48482);
    }
}
