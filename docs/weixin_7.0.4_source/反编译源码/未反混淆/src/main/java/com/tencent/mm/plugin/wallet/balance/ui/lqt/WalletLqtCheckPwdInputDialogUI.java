package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.cashier.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletLqtCheckPwdInputDialogUI extends WalletBaseUI {
    private String mTitle = "";
    private String tgj;
    private String tgx = "";
    private b tgy;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        int i = 1;
        AppMethodBeat.i(45519);
        super.onCreate(bundle);
        AM(4);
        this.mTitle = getIntent().getStringExtra("lqt_fetch_pwd_title");
        this.tgx = getIntent().getStringExtra("lqt_fetch_pwd_money");
        this.tgj = getIntent().getStringExtra("lqt_redeem_listid");
        ab.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: money : %s, title : %s, redeemListId: %s", bo.nullAsNil(this.tgx), bo.nullAsNil(this.mTitle), this.tgj);
        if (bo.isNullOrNil(this.mTitle) || bo.isNullOrNil(this.tgx)) {
            i = 0;
        }
        if (i == 0) {
            h.a(this.mController.ylL, (int) R.string.fkw, 0, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(45516);
                    WalletLqtCheckPwdInputDialogUI.this.finish();
                    AppMethodBeat.o(45516);
                }
            });
            AppMethodBeat.o(45519);
            return;
        }
        getWindow().setBackgroundDrawableResource(R.color.a3p);
        showDialog();
        AppMethodBeat.o(45519);
    }

    private void showDialog() {
        AppMethodBeat.i(45520);
        if (this.tgy != null && this.tgy.isShowing()) {
            this.tgy.dismiss();
        }
        this.tgx = e.G(bo.getDouble(this.tgx, 0.0d));
        this.tgy = new b(this.mController.ylL);
        this.tgy.aq(this.mTitle, this.tgx, "");
        this.tgy.tMA = new b.a() {
            public final void a(String str, FavorPayInfo favorPayInfo, Bankcard bankcard) {
                AppMethodBeat.i(45517);
                Intent intent = new Intent();
                intent.putExtra("lqt_fetch_enc_pwd", str);
                intent.putExtra("lqt_redeem_listid", WalletLqtCheckPwdInputDialogUI.this.tgj);
                WalletLqtCheckPwdInputDialogUI.this.setResult(-1, intent);
                WalletLqtCheckPwdInputDialogUI.this.finish();
                AppMethodBeat.o(45517);
            }

            public final void onCancel() {
                AppMethodBeat.i(45518);
                ab.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: dialog cancel. finish");
                WalletLqtCheckPwdInputDialogUI.this.finish();
                AppMethodBeat.o(45518);
            }

            public final void cMN() {
            }
        };
        this.tgy.show();
        addDialog(this.tgy);
        AppMethodBeat.o(45520);
    }

    public final void wU(int i) {
        AppMethodBeat.i(45521);
        if (i == 0) {
            finish();
            AppMethodBeat.o(45521);
            return;
        }
        if (i == 1) {
            showDialog();
        }
        AppMethodBeat.o(45521);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }
}
