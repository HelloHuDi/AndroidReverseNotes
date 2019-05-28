package com.tencent.p177mm.plugin.wallet_core.id_verify;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22558a;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameProcessProxyUI */
public class WalletRealNameProcessProxyUI extends WalletBaseUI {

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameProcessProxyUI$1 */
    class C354761 implements OnClickListener {
        C354761() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46613);
            WalletRealNameProcessProxyUI.this.setResult(1);
            WalletRealNameProcessProxyUI.this.finish();
            AppMethodBeat.m2505o(46613);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        int i;
        AppMethodBeat.m2504i(46614);
        super.onCreate(bundle);
        mo39992nf(580);
        Bundle bundle2 = this.mBundle;
        if (bundle2 != null) {
            i = bundle2.getInt("realname_scene", 0);
        } else {
            i = 0;
        }
        if (i == 0) {
            i = getIntent().getIntExtra("realname_scene", 0);
        }
        if (i == 1) {
            C4990ab.m7416i("MicroMsg.WalletRealNameProcessProxyUI", "from jsapi, do NetSceneCheckPayJsapi");
            if (getIntent() == null) {
                String str = "";
                if (C5046bo.isNullOrNil(str)) {
                    str = getString(C25738R.string.fu2);
                }
                C30379h.m48448a((Context) this, str, null, false, new C354761());
                AppMethodBeat.m2505o(46614);
                return;
            }
            String stringExtra = getIntent().getStringExtra("appId");
            String stringExtra2 = getIntent().getStringExtra("timeStamp");
            String stringExtra3 = getIntent().getStringExtra("nonceStr");
            String stringExtra4 = getIntent().getStringExtra("packageExt");
            String stringExtra5 = getIntent().getStringExtra("signtype");
            String stringExtra6 = getIntent().getStringExtra("paySignature");
            String stringExtra7 = getIntent().getStringExtra("url");
            int i2 = 8;
            if (this.mBundle.getInt("realname_scene") == 2) {
                i2 = 12;
            }
            mo39970a(new C22558a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, i2, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)), true, false);
            AppMethodBeat.m2505o(46614);
            return;
        }
        m58232R(bundle2);
        AppMethodBeat.m2505o(46614);
    }

    public void onResume() {
        AppMethodBeat.m2504i(46615);
        super.onResume();
        AppMethodBeat.m2505o(46615);
    }

    /* renamed from: R */
    private void m58232R(Bundle bundle) {
        AppMethodBeat.m2504i(46616);
        C4990ab.m7416i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI");
        if (bundle == null) {
            C4990ab.m7416i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI, param is null");
            bundle = new Bundle();
        }
        bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
        bundle.putString("realname_verify_process_jump_activity", ".id_verify.WalletRealNameProcessProxyUI");
        bundle.putBoolean("process_finish_stay_orgpage", false);
        C24143a.m37105a(this, C40105a.class, bundle);
        AppMethodBeat.m2505o(46616);
    }

    public final int getLayoutId() {
        return -1;
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46617);
        if (c1207m instanceof C22558a) {
            C4990ab.m7412e("MicroMsg.WalletRealNameProcessProxyUI", "NetSceneCheckPayJsapi resp,errType = " + i + ",errCode=" + i2);
            if (i == 0 && i2 == 0) {
                C46512f.akr(((C22558a) c1207m).cOS());
                m58232R(this.mBundle);
                AppMethodBeat.m2505o(46617);
                return true;
            }
        }
        AppMethodBeat.m2505o(46617);
        return false;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(46618);
        C4990ab.m7416i("MicroMsg.WalletRealNameProcessProxyUI", "onNewIntent");
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.getBoolean("key_is_realname_verify_process")) {
            setResult(0);
        } else {
            switch (extras.getInt("realname_verify_process_ret", 0)) {
                case -1:
                    setResult(-1);
                    break;
            }
            setResult(0);
        }
        finish();
        AppMethodBeat.m2505o(46618);
    }

    public final boolean bwP() {
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46619);
        super.onDestroy();
        mo39993ng(580);
        AppMethodBeat.m2505o(46619);
    }
}
