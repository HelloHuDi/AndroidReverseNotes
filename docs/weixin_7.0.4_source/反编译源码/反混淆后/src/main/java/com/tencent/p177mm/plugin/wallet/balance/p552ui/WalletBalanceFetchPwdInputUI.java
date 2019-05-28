package com.tencent.p177mm.plugin.wallet.balance.p552ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p561ui.cashier.C4432b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.cashier.C4432b.C4438a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI */
public class WalletBalanceFetchPwdInputUI extends WalletBaseUI {
    private String mTitle = "";
    private String rMr;
    private String tgx = "";
    private C4432b tgy;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI$2 */
    class C248472 implements C4438a {
        C248472() {
        }

        /* renamed from: a */
        public final void mo9483a(String str, FavorPayInfo favorPayInfo, Bankcard bankcard) {
            AppMethodBeat.m2504i(45336);
            if (WalletBalanceFetchPwdInputUI.this.dOD() != null) {
                WalletBalanceFetchPwdInputUI.this.dOE().mo9366p(str);
            }
            AppMethodBeat.m2505o(45336);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(45337);
            WalletBalanceFetchPwdInputUI.this.finish();
            C7060h.pYm.mo8381e(16398, WalletBalanceFetchPwdInputUI.this.rMr, Integer.valueOf(8), "", "");
            AppMethodBeat.m2505o(45337);
        }

        public final void cMN() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI$1 */
    class C248481 implements OnClickListener {
        C248481() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45335);
            WalletBalanceFetchPwdInputUI.this.finish();
            AppMethodBeat.m2505o(45335);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        int i = 1;
        AppMethodBeat.m2504i(45338);
        super.onCreate(bundle);
        mo9439AM(4);
        this.mTitle = this.mBundle.getString("key_pwd_cash_title");
        this.tgx = this.mBundle.getString("key_pwd_cash_money");
        this.rMr = this.mBundle.getString("key_report_session_id");
        C4990ab.m7417i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: money : %s, title : %s", C5046bo.nullAsNil(this.tgx), C5046bo.nullAsNil(this.mTitle));
        if (C5046bo.isNullOrNil(this.mTitle) || C5046bo.isNullOrNil(this.tgx)) {
            i = 0;
        }
        if (i == 0) {
            C30379h.m48431a(this.mController.ylL, (int) C25738R.string.fkw, 0, new C248481());
            AppMethodBeat.m2505o(45338);
            return;
        }
        showDialog();
        AppMethodBeat.m2505o(45338);
    }

    private void showDialog() {
        String string;
        AppMethodBeat.m2504i(45339);
        if (this.tgy != null && this.tgy.isShowing()) {
            this.tgy.dismiss();
        }
        String str = "";
        if (((Orders) this.mBundle.getParcelable("key_orders")).pPp > 0.0d) {
            str = this.mBundle.getString("key_fetch_cashier_desc");
            if (C5046bo.isNullOrNil(str)) {
                string = getResources().getString(C25738R.string.f8c, new Object[]{C36391e.m60006e(r0.pPp, r0.pcl)});
            } else {
                string = String.format(str, new Object[]{C36391e.m60006e(r0.pPp, r0.pcl)});
            }
        } else {
            string = str;
        }
        this.tgy = new C4432b(this.mController.ylL);
        this.tgy.mo9473aq(this.mTitle, this.tgx, string);
        this.tgy.tMA = new C248472();
        this.tgy.show();
        addDialog(this.tgy);
        AppMethodBeat.m2505o(45339);
    }

    /* renamed from: wU */
    public final void mo8137wU(int i) {
        AppMethodBeat.m2504i(45340);
        if (i == 0) {
            finish();
            AppMethodBeat.m2505o(45340);
            return;
        }
        if (i == 1) {
            showDialog();
        }
        AppMethodBeat.m2505o(45340);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }
}
