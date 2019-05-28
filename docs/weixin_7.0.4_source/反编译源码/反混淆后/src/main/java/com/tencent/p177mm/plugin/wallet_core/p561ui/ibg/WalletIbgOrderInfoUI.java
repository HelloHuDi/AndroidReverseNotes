package com.tencent.p177mm.plugin.wallet_core.p561ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C45334iy;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p749c.p750a.C40092c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoUI */
public class WalletIbgOrderInfoUI extends WalletBaseUI {
    public static Orders tog;
    private String mAppId = null;
    private String mTimeStamp = null;
    private String tMQ = null;
    private String tMR = null;
    private String tMS = null;
    private String tMT = null;
    private final int tMU = 1;
    private final int tMV = 2;
    private String tmv = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47848);
        super.onCreate(bundle);
        mo39992nf(1565);
        this.mAppId = getIntent().getStringExtra("appId");
        this.tMQ = getIntent().getStringExtra("nonceStr");
        this.mTimeStamp = getIntent().getStringExtra("timeStamp");
        this.tmv = getIntent().getStringExtra("packageExt");
        this.tMR = getIntent().getStringExtra("paySignature");
        this.tMS = getIntent().getStringExtra("signtype");
        this.tMT = getIntent().getStringExtra("url");
        mo39970a(new C40092c(this.mAppId, this.tMQ, this.mTimeStamp, this.tmv, this.tMR, this.tMS, this.tMT), true, false);
        AppMethodBeat.m2505o(47848);
    }

    public final int getLayoutId() {
        return 2130970969;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(47849);
        if (i2 == -1) {
            if (i == 1) {
                C45334iy c45334iy = new C45334iy();
                c45334iy.cEc.requestCode = 25;
                c45334iy.cEc.bFZ = -1;
                c45334iy.cEc.cEd = new Intent();
                C4879a.xxA.mo10055m(c45334iy);
            }
            setResult(-1);
            finish();
        }
        AppMethodBeat.m2505o(47849);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47850);
        C4990ab.m7417i("MicroMsg.WalletIbgOrderInfoUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m);
        if (c1207m instanceof C40092c) {
            mo39993ng(1565);
            if (i == 0 && i2 == 0) {
                C40092c c40092c = (C40092c) c1207m;
                tog = c40092c.tux;
                Orders orders = tog;
                C4990ab.m7417i("MicroMsg.WalletIbgOrderInfoUI", "gotoIbgOrderInfoUI, useNewPage: %s, orders: %s", Integer.valueOf(c40092c.tuI), orders);
                Intent intent;
                if (c40092c.tuI == 1) {
                    intent = new Intent(this, WalletIbgOrderInfoNewUI.class);
                    intent.putExtra("key_orders", orders);
                    startActivityForResult(intent, 1);
                } else {
                    intent = new Intent(this, WalletIbgOrderInfoOldUI.class);
                    intent.putExtra("key_orders", orders);
                    startActivityForResult(intent, 2);
                }
                AppMethodBeat.m2505o(47850);
                return true;
            }
            setResult(0);
            finish();
        }
        setResult(0);
        finish();
        AppMethodBeat.m2505o(47850);
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47851);
        super.onDestroy();
        mo39993ng(1565);
        AppMethodBeat.m2505o(47851);
    }
}
