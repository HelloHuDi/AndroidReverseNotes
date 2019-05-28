package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pwd.c;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletResetPwdAdapterUI extends WalletBaseUI {
    protected String edV = null;
    protected boolean pQP = false;
    protected com.tencent.mm.plugin.wallet.a pQQ = null;
    protected String tsy = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46384);
        super.onCreate(bundle);
        AM(8);
        this.tsy = getIntent().getStringExtra("reset_pwd_token");
        ab.i("MicroMsg.WalletResetPwdAdapterUI", "token_by_resetPwd %s", this.tsy);
        nf(580);
        if (getIntent() == null) {
            ab.d("MicroMsg.WalletResetPwdAdapterUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            AppMethodBeat.o(46384);
            return;
        }
        m aVar = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 13, "setWCPayPassword", getIntent().getIntExtra("pay_channel", 0));
        aVar.eHT = "RemittanceProcess";
        a(aVar, true, false);
        AppMethodBeat.o(46384);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(46385);
        ab.v("MicroMsg.WalletResetPwdAdapterUI", "onNewIntent");
        int intExtra = intent.getIntExtra("RESET_PWD_USER_ACTION", 0);
        if (intExtra == 1) {
            setResult(-1);
            finish();
            AppMethodBeat.o(46385);
        } else if (intExtra == 2) {
            setResult(-1000);
            finish();
            AppMethodBeat.o(46385);
        } else {
            setResult(0);
            finish();
            AppMethodBeat.o(46385);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(46386);
        ng(580);
        super.onDestroy();
        AppMethodBeat.o(46386);
    }

    public void onBackPressed() {
        AppMethodBeat.i(46387);
        if (this.pQP) {
            ab.d("MicroMsg.WalletResetPwdAdapterUI", "back press but lock");
            AppMethodBeat.o(46387);
            return;
        }
        ab.d("MicroMsg.WalletResetPwdAdapterUI", "back press not lock");
        finish();
        AppMethodBeat.o(46387);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46388);
        if (i != 0 || i2 != 0) {
            setResult(-1000);
            h.bQ(this, str);
            finish();
            AppMethodBeat.o(46388);
            return true;
        } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            f.akr(((com.tencent.mm.plugin.wallet_core.c.a) mVar).cOS());
            Bundle bundle = new Bundle();
            bundle.putString("kreq_token", this.tsy);
            com.tencent.mm.wallet_core.a.a((Activity) this, c.class, bundle, null);
            AppMethodBeat.o(46388);
            return true;
        } else {
            AppMethodBeat.o(46388);
            return false;
        }
    }

    public final int getLayoutId() {
        return -1;
    }
}
