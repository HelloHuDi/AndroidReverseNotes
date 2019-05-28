package com.tencent.p177mm.plugin.wallet_ecard.p563ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C43818a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI */
public class WalletOpenECardProxyUI extends WalletECardBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48157);
        super.onCreate(bundle);
        mo9439AM(4);
        C40931c dOD = dOD();
        if (dOD != null) {
            int i = this.mBundle.getInt(C43818a.tPH, 0);
            C4990ab.m7417i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, isReuseExistCard: %s", Integer.valueOf(i), Boolean.valueOf(this.mBundle.getBoolean(C43818a.tPZ, false)));
            if (this.mBundle.getBoolean(C43818a.tPZ, false)) {
                dOE().mo9366p(Integer.valueOf(2), Integer.valueOf(i), Boolean.TRUE);
                AppMethodBeat.m2505o(48157);
                return;
            }
            String string = this.mBundle.getString(C43818a.tPI);
            boolean z = this.mBundle.getBoolean(C43818a.tPK, false);
            C4990ab.m7417i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, token==null:%s, isTokenInvalid: %s", Integer.valueOf(i), Boolean.valueOf(C5046bo.isNullOrNil(string)), Boolean.valueOf(z));
            if (C5046bo.isNullOrNil(string)) {
                dOD.mo8124a(this.mController.ylL, 0, this.mBundle);
                AppMethodBeat.m2505o(48157);
                return;
            }
            dOE().mo9366p(Integer.valueOf(1), Integer.valueOf(i), string);
            AppMethodBeat.m2505o(48157);
            return;
        }
        C4990ab.m7420w("MicroMsg.WalletOpenECardProxyUI", "no process!!!");
        finish();
        AppMethodBeat.m2505o(48157);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(48158);
        C4990ab.m7417i("MicroMsg.WalletOpenECardProxyUI", "activity result, request:%s, result: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
            AppMethodBeat.m2505o(48158);
        } else if (i2 == -1) {
            setResult(0);
            C40931c dOD = dOD();
            if (dOD != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_process_result_code", 0);
                dOD.mo64582l(this, bundle);
                AppMethodBeat.m2505o(48158);
                return;
            }
            finish();
            AppMethodBeat.m2505o(48158);
        } else {
            finish();
            AppMethodBeat.m2505o(48158);
        }
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(48159);
        C4990ab.m7417i("MicroMsg.WalletOpenECardProxyUI", "new intent, resultCode: %d, isEnd: %s", Integer.valueOf(intent.getIntExtra("key_process_result_code", -1)), Boolean.valueOf(intent.getBooleanExtra("key_process_is_end", false)));
        if (intent.getIntExtra("key_process_result_code", -1) == -1) {
            if (intent.getBooleanExtra("key_goto_lqt_detail", false)) {
                C4990ab.m7416i("MicroMsg.WalletOpenECardProxyUI", "jump to detail");
                Intent intent2 = new Intent();
                intent2.putExtra("key_account_type", 2);
                C25985d.m41467b((Context) this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent2);
            }
            setResult(-1);
        } else {
            setResult(0);
        }
        C40931c dOD = dOD();
        if (r1) {
            finish();
            AppMethodBeat.m2505o(48159);
            return;
        }
        if (dOD != null) {
            dOD.mo64570aG(this.mController.ylL);
        }
        AppMethodBeat.m2505o(48159);
    }
}
