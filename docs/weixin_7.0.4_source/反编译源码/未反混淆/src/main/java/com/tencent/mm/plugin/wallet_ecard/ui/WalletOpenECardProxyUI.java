package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;

@a(3)
public class WalletOpenECardProxyUI extends WalletECardBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48157);
        super.onCreate(bundle);
        AM(4);
        c dOD = dOD();
        if (dOD != null) {
            int i = this.mBundle.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPH, 0);
            ab.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, isReuseExistCard: %s", Integer.valueOf(i), Boolean.valueOf(this.mBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPZ, false)));
            if (this.mBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPZ, false)) {
                dOE().p(Integer.valueOf(2), Integer.valueOf(i), Boolean.TRUE);
                AppMethodBeat.o(48157);
                return;
            }
            String string = this.mBundle.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPI);
            boolean z = this.mBundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPK, false);
            ab.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, token==null:%s, isTokenInvalid: %s", Integer.valueOf(i), Boolean.valueOf(bo.isNullOrNil(string)), Boolean.valueOf(z));
            if (bo.isNullOrNil(string)) {
                dOD.a(this.mController.ylL, 0, this.mBundle);
                AppMethodBeat.o(48157);
                return;
            }
            dOE().p(Integer.valueOf(1), Integer.valueOf(i), string);
            AppMethodBeat.o(48157);
            return;
        }
        ab.w("MicroMsg.WalletOpenECardProxyUI", "no process!!!");
        finish();
        AppMethodBeat.o(48157);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(48158);
        ab.i("MicroMsg.WalletOpenECardProxyUI", "activity result, request:%s, result: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
            AppMethodBeat.o(48158);
        } else if (i2 == -1) {
            setResult(0);
            c dOD = dOD();
            if (dOD != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_process_result_code", 0);
                dOD.l(this, bundle);
                AppMethodBeat.o(48158);
                return;
            }
            finish();
            AppMethodBeat.o(48158);
        } else {
            finish();
            AppMethodBeat.o(48158);
        }
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(48159);
        ab.i("MicroMsg.WalletOpenECardProxyUI", "new intent, resultCode: %d, isEnd: %s", Integer.valueOf(intent.getIntExtra("key_process_result_code", -1)), Boolean.valueOf(intent.getBooleanExtra("key_process_is_end", false)));
        if (intent.getIntExtra("key_process_result_code", -1) == -1) {
            if (intent.getBooleanExtra("key_goto_lqt_detail", false)) {
                ab.i("MicroMsg.WalletOpenECardProxyUI", "jump to detail");
                Intent intent2 = new Intent();
                intent2.putExtra("key_account_type", 2);
                d.b((Context) this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent2);
            }
            setResult(-1);
        } else {
            setResult(0);
        }
        c dOD = dOD();
        if (r1) {
            finish();
            AppMethodBeat.o(48159);
            return;
        }
        if (dOD != null) {
            dOD.aG(this.mController.ylL);
        }
        AppMethodBeat.o(48159);
    }
}
