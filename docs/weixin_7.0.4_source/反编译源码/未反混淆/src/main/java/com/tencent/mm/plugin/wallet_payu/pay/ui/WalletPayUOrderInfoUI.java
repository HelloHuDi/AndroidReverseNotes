package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.plugin.wallet_payu.a.d;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;

public class WalletPayUOrderInfoUI extends WalletOrderInfoOldUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48477);
        super.onCreate(bundle);
        nf(1554);
        AppMethodBeat.o(48477);
    }

    public final void cRI() {
        AppMethodBeat.i(48478);
        a(new a(), true, true);
        AppMethodBeat.o(48478);
    }

    public final void adb(String str) {
        AppMethodBeat.i(48479);
        a(new c(str, 1), true, true);
        AppMethodBeat.o(48479);
    }

    public void onDestroy() {
        AppMethodBeat.i(48480);
        ng(1554);
        super.onDestroy();
        AppMethodBeat.o(48480);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48481);
        if (mVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a) {
            AppMethodBeat.o(48481);
            return true;
        }
        if (mVar instanceof c) {
            c cVar = (c) mVar;
            if (cVar.pWy.tAq == null || cVar.pWy.tAq.size() <= 0) {
                ab.w("MicroMsg.WalletPayUOrderInfoUI", "hy: no commodity. show alert");
                h.a((Context) this, (int) R.string.fph, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(48476);
                        com.tencent.mm.wallet_core.a.b(WalletPayUOrderInfoUI.this, WalletPayUOrderInfoUI.this.mBundle, 0);
                        AppMethodBeat.o(48476);
                    }
                });
            } else {
                Commodity commodity = (Commodity) cVar.pWy.tAq.get(0);
                ab.d("MicroMsg.WalletPayUOrderInfoUI", "Coomdity:".concat(String.valueOf(commodity)));
                d.cTf().tTA = null;
                if (commodity != null) {
                    this.tId = new ArrayList();
                    this.tId.add(commodity);
                    g.RQ();
                    ad aoO = ((j) g.K(j.class)).XM().aoO(commodity.pcm);
                    if (aoO == null || ((int) aoO.ewQ) == 0) {
                        ao.a.flu.a(commodity.pcm, "", this.tIU);
                    } else {
                        S(aoO);
                    }
                    this.tIN.notifyDataSetChanged();
                    cRJ();
                }
            }
        }
        boolean c = super.c(i, i2, str, mVar);
        AppMethodBeat.o(48481);
        return c;
    }

    public final void done() {
        String str;
        AppMethodBeat.i(48482);
        cRq();
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.mBundle.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.mBundle.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.mBundle.getBoolean("intent_pay_end"));
        ab.i("MicroMsg.WalletPayUOrderInfoUI", "pay done...feedbackData errCode:" + this.mBundle.getInt("intent_pay_end_errcode"));
        for (String str2 : this.tIc) {
            if (!bo.isNullOrNil(str2)) {
                ab.d("MicroMsg.WalletPayUOrderInfoUI", "hy: doing netscene subscribe...appName: %s", str2);
                a(new r(str2), false, false);
            }
        }
        com.tencent.mm.wallet_core.a.j(this, bundle);
        if (!(this.tog == null || bo.isNullOrNil(this.tog.lvz))) {
            str2 = this.tog.tAq.size() > 0 ? ((Commodity) this.tog.tAq.get(0)).cAa : "";
            str2 = String.format("%sreqkey=%s&transid=%s", new Object[]{this.tog.lvz, this.tog.czZ, str2});
            ab.d("MicroMsg.WalletPayUOrderInfoUI", "url = ".concat(String.valueOf(str2)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", com.tencent.mm.model.r.Yz());
            com.tencent.mm.bp.d.b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(48482);
    }
}
