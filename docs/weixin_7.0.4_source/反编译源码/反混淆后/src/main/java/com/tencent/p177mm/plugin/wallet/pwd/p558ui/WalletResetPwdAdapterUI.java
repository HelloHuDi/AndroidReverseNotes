package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet.C40052a;
import com.tencent.p177mm.plugin.wallet.pwd.C41327c;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22558a;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI */
public class WalletResetPwdAdapterUI extends WalletBaseUI {
    protected String edV = null;
    protected boolean pQP = false;
    protected C40052a pQQ = null;
    protected String tsy = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46384);
        super.onCreate(bundle);
        mo9439AM(8);
        this.tsy = getIntent().getStringExtra("reset_pwd_token");
        C4990ab.m7417i("MicroMsg.WalletResetPwdAdapterUI", "token_by_resetPwd %s", this.tsy);
        mo39992nf(580);
        if (getIntent() == null) {
            C4990ab.m7410d("MicroMsg.WalletResetPwdAdapterUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            AppMethodBeat.m2505o(46384);
            return;
        }
        C1207m c22558a = new C22558a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 13, "setWCPayPassword", getIntent().getIntExtra("pay_channel", 0));
        c22558a.eHT = "RemittanceProcess";
        mo39970a(c22558a, true, false);
        AppMethodBeat.m2505o(46384);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(46385);
        C4990ab.m7418v("MicroMsg.WalletResetPwdAdapterUI", "onNewIntent");
        int intExtra = intent.getIntExtra("RESET_PWD_USER_ACTION", 0);
        if (intExtra == 1) {
            setResult(-1);
            finish();
            AppMethodBeat.m2505o(46385);
        } else if (intExtra == 2) {
            setResult(-1000);
            finish();
            AppMethodBeat.m2505o(46385);
        } else {
            setResult(0);
            finish();
            AppMethodBeat.m2505o(46385);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46386);
        mo39993ng(580);
        super.onDestroy();
        AppMethodBeat.m2505o(46386);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(46387);
        if (this.pQP) {
            C4990ab.m7410d("MicroMsg.WalletResetPwdAdapterUI", "back press but lock");
            AppMethodBeat.m2505o(46387);
            return;
        }
        C4990ab.m7410d("MicroMsg.WalletResetPwdAdapterUI", "back press not lock");
        finish();
        AppMethodBeat.m2505o(46387);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46388);
        if (i != 0 || i2 != 0) {
            setResult(-1000);
            C30379h.m48465bQ(this, str);
            finish();
            AppMethodBeat.m2505o(46388);
            return true;
        } else if (c1207m instanceof C22558a) {
            C46512f.akr(((C22558a) c1207m).cOS());
            Bundle bundle = new Bundle();
            bundle.putString("kreq_token", this.tsy);
            C24143a.m37106a((Activity) this, C41327c.class, bundle, null);
            AppMethodBeat.m2505o(46388);
            return true;
        } else {
            AppMethodBeat.m2505o(46388);
            return false;
        }
    }

    public final int getLayoutId() {
        return -1;
    }
}
