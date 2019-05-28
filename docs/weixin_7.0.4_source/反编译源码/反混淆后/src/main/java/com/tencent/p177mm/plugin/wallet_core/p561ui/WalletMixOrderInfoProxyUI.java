package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44431r;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoProxyUI */
public class WalletMixOrderInfoProxyUI extends WalletOrderInfoNewUI {
    private String prepayId = null;
    private Orders tog;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47409);
        this.tog = (Orders) getIntent().getParcelableExtra("key_orders");
        this.prepayId = getIntent().getStringExtra("prepayId");
        super.onCreate(bundle);
        AppMethodBeat.m2505o(47409);
    }

    /* Access modifiers changed, original: protected|final */
    public final Orders cRD() {
        return this.tog;
    }

    public final void done() {
        AppMethodBeat.m2504i(47410);
        for (String str : this.tIc) {
            if (!C5046bo.isNullOrNil(str)) {
                C4990ab.m7411d("MicroMsg.WalletMixOrderInfoProxyUI", "hy: doing netscene subscribe...appName: %s", str);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C44431r(str), 0);
            }
        }
        if (!C5046bo.isNullOrNil(this.prepayId)) {
            C32652uv c32652uv = new C32652uv();
            Intent intent = new Intent();
            intent.putExtra("intent_pay_end", true);
            c32652uv.cRF.intent = intent;
            c32652uv.cRF.czZ = this.prepayId;
            c32652uv.cRF.result = -1;
            c32652uv.cRF.cRH = 1;
            C4879a.xxA.mo10055m(c32652uv);
        }
        setResult(-1);
        finish();
        AppMethodBeat.m2505o(47410);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cRq() {
    }
}
