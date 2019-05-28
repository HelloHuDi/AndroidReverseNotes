package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.plugin.wallet_core.c.a.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
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
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47848);
        super.onCreate(bundle);
        nf(1565);
        this.mAppId = getIntent().getStringExtra("appId");
        this.tMQ = getIntent().getStringExtra("nonceStr");
        this.mTimeStamp = getIntent().getStringExtra("timeStamp");
        this.tmv = getIntent().getStringExtra("packageExt");
        this.tMR = getIntent().getStringExtra("paySignature");
        this.tMS = getIntent().getStringExtra("signtype");
        this.tMT = getIntent().getStringExtra("url");
        a(new c(this.mAppId, this.tMQ, this.mTimeStamp, this.tmv, this.tMR, this.tMS, this.tMT), true, false);
        AppMethodBeat.o(47848);
    }

    public final int getLayoutId() {
        return R.layout.b0t;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(47849);
        if (i2 == -1) {
            if (i == 1) {
                iy iyVar = new iy();
                iyVar.cEc.requestCode = 25;
                iyVar.cEc.bFZ = -1;
                iyVar.cEc.cEd = new Intent();
                com.tencent.mm.sdk.b.a.xxA.m(iyVar);
            }
            setResult(-1);
            finish();
        }
        AppMethodBeat.o(47849);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47850);
        ab.i("MicroMsg.WalletIbgOrderInfoUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar);
        if (mVar instanceof c) {
            ng(1565);
            if (i == 0 && i2 == 0) {
                c cVar = (c) mVar;
                tog = cVar.tux;
                Orders orders = tog;
                ab.i("MicroMsg.WalletIbgOrderInfoUI", "gotoIbgOrderInfoUI, useNewPage: %s, orders: %s", Integer.valueOf(cVar.tuI), orders);
                Intent intent;
                if (cVar.tuI == 1) {
                    intent = new Intent(this, WalletIbgOrderInfoNewUI.class);
                    intent.putExtra("key_orders", orders);
                    startActivityForResult(intent, 1);
                } else {
                    intent = new Intent(this, WalletIbgOrderInfoOldUI.class);
                    intent.putExtra("key_orders", orders);
                    startActivityForResult(intent, 2);
                }
                AppMethodBeat.o(47850);
                return true;
            }
            setResult(0);
            finish();
        }
        setResult(0);
        finish();
        AppMethodBeat.o(47850);
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.i(47851);
        super.onDestroy();
        ng(1565);
        AppMethodBeat.o(47851);
    }
}
