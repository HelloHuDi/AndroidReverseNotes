package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.cashier.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletBalanceFetchPwdInputUI extends WalletBaseUI {
    private String mTitle = "";
    private String rMr;
    private String tgx = "";
    private b tgy;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        int i = 1;
        AppMethodBeat.i(45338);
        super.onCreate(bundle);
        AM(4);
        this.mTitle = this.mBundle.getString("key_pwd_cash_title");
        this.tgx = this.mBundle.getString("key_pwd_cash_money");
        this.rMr = this.mBundle.getString("key_report_session_id");
        ab.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: money : %s, title : %s", bo.nullAsNil(this.tgx), bo.nullAsNil(this.mTitle));
        if (bo.isNullOrNil(this.mTitle) || bo.isNullOrNil(this.tgx)) {
            i = 0;
        }
        if (i == 0) {
            h.a(this.mController.ylL, (int) R.string.fkw, 0, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(45335);
                    WalletBalanceFetchPwdInputUI.this.finish();
                    AppMethodBeat.o(45335);
                }
            });
            AppMethodBeat.o(45338);
            return;
        }
        showDialog();
        AppMethodBeat.o(45338);
    }

    private void showDialog() {
        String string;
        AppMethodBeat.i(45339);
        if (this.tgy != null && this.tgy.isShowing()) {
            this.tgy.dismiss();
        }
        String str = "";
        if (((Orders) this.mBundle.getParcelable("key_orders")).pPp > 0.0d) {
            str = this.mBundle.getString("key_fetch_cashier_desc");
            if (bo.isNullOrNil(str)) {
                string = getResources().getString(R.string.f8c, new Object[]{e.e(r0.pPp, r0.pcl)});
            } else {
                string = String.format(str, new Object[]{e.e(r0.pPp, r0.pcl)});
            }
        } else {
            string = str;
        }
        this.tgy = new b(this.mController.ylL);
        this.tgy.aq(this.mTitle, this.tgx, string);
        this.tgy.tMA = new b.a() {
            public final void a(String str, FavorPayInfo favorPayInfo, Bankcard bankcard) {
                AppMethodBeat.i(45336);
                if (WalletBalanceFetchPwdInputUI.this.dOD() != null) {
                    WalletBalanceFetchPwdInputUI.this.dOE().p(str);
                }
                AppMethodBeat.o(45336);
            }

            public final void onCancel() {
                AppMethodBeat.i(45337);
                WalletBalanceFetchPwdInputUI.this.finish();
                com.tencent.mm.plugin.report.service.h.pYm.e(16398, WalletBalanceFetchPwdInputUI.this.rMr, Integer.valueOf(8), "", "");
                AppMethodBeat.o(45337);
            }

            public final void cMN() {
            }
        };
        this.tgy.show();
        addDialog(this.tgy);
        AppMethodBeat.o(45339);
    }

    public final void wU(int i) {
        AppMethodBeat.i(45340);
        if (i == 0) {
            finish();
            AppMethodBeat.o(45340);
            return;
        }
        if (i == 1) {
            showDialog();
        }
        AppMethodBeat.o(45340);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }
}
