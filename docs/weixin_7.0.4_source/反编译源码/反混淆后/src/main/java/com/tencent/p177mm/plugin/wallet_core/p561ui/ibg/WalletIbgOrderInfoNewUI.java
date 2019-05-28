package com.tencent.p177mm.plugin.wallet_core.p561ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C45334iy;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletOrderInfoNewUI;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44431r;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoNewUI */
public class WalletIbgOrderInfoNewUI extends WalletOrderInfoNewUI {
    private Orders tog;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47844);
        this.tog = WalletIbgOrderInfoUI.tog;
        super.onCreate(bundle);
        C45334iy c45334iy = new C45334iy();
        c45334iy.cEc.requestCode = 25;
        c45334iy.cEc.bFZ = -1;
        c45334iy.cEc.cEd = new Intent();
        C4879a.xxA.mo10055m(c45334iy);
        AppMethodBeat.m2505o(47844);
    }

    public final Orders cRD() {
        return this.tog;
    }

    public final void done() {
        AppMethodBeat.m2504i(47845);
        C4990ab.m7416i("MicroMsg.WalletIbgOrderInfoNewUI", "hy: result is not set manly. set to OK");
        for (String str : this.tIc) {
            if (!C5046bo.isNullOrNil(str)) {
                C4990ab.m7411d("MicroMsg.WalletIbgOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", str);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C44431r(str), 0);
            }
        }
        setResult(-1);
        finish();
        AppMethodBeat.m2505o(47845);
    }

    public final void cRq() {
    }
}
