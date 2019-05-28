package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletRealNameProcessProxyUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        int i;
        AppMethodBeat.i(46614);
        super.onCreate(bundle);
        nf(580);
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
            ab.i("MicroMsg.WalletRealNameProcessProxyUI", "from jsapi, do NetSceneCheckPayJsapi");
            if (getIntent() == null) {
                String str = "";
                if (bo.isNullOrNil(str)) {
                    str = getString(R.string.fu2);
                }
                h.a((Context) this, str, null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(46613);
                        WalletRealNameProcessProxyUI.this.setResult(1);
                        WalletRealNameProcessProxyUI.this.finish();
                        AppMethodBeat.o(46613);
                    }
                });
                AppMethodBeat.o(46614);
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
            a(new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, i2, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)), true, false);
            AppMethodBeat.o(46614);
            return;
        }
        R(bundle2);
        AppMethodBeat.o(46614);
    }

    public void onResume() {
        AppMethodBeat.i(46615);
        super.onResume();
        AppMethodBeat.o(46615);
    }

    private void R(Bundle bundle) {
        AppMethodBeat.i(46616);
        ab.i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI");
        if (bundle == null) {
            ab.i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI, param is null");
            bundle = new Bundle();
        }
        bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
        bundle.putString("realname_verify_process_jump_activity", ".id_verify.WalletRealNameProcessProxyUI");
        bundle.putBoolean("process_finish_stay_orgpage", false);
        com.tencent.mm.wallet_core.a.a(this, a.class, bundle);
        AppMethodBeat.o(46616);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46617);
        if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            ab.e("MicroMsg.WalletRealNameProcessProxyUI", "NetSceneCheckPayJsapi resp,errType = " + i + ",errCode=" + i2);
            if (i == 0 && i2 == 0) {
                f.akr(((com.tencent.mm.plugin.wallet_core.c.a) mVar).cOS());
                R(this.mBundle);
                AppMethodBeat.o(46617);
                return true;
            }
        }
        AppMethodBeat.o(46617);
        return false;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(46618);
        ab.i("MicroMsg.WalletRealNameProcessProxyUI", "onNewIntent");
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
        AppMethodBeat.o(46618);
    }

    public final boolean bwP() {
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.i(46619);
        super.onDestroy();
        ng(580);
        AppMethodBeat.o(46619);
    }
}
