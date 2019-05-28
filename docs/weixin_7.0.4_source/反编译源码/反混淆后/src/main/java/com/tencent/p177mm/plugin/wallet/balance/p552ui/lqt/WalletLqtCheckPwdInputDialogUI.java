package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.p561ui.cashier.C4432b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.cashier.C4432b.C4438a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI */
public class WalletLqtCheckPwdInputDialogUI extends WalletBaseUI {
    private String mTitle = "";
    private String tgj;
    private String tgx = "";
    private C4432b tgy;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI$1 */
    class C295571 implements OnClickListener {
        C295571() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45516);
            WalletLqtCheckPwdInputDialogUI.this.finish();
            AppMethodBeat.m2505o(45516);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI$2 */
    class C295582 implements C4438a {
        C295582() {
        }

        /* renamed from: a */
        public final void mo9483a(String str, FavorPayInfo favorPayInfo, Bankcard bankcard) {
            AppMethodBeat.m2504i(45517);
            Intent intent = new Intent();
            intent.putExtra("lqt_fetch_enc_pwd", str);
            intent.putExtra("lqt_redeem_listid", WalletLqtCheckPwdInputDialogUI.this.tgj);
            WalletLqtCheckPwdInputDialogUI.this.setResult(-1, intent);
            WalletLqtCheckPwdInputDialogUI.this.finish();
            AppMethodBeat.m2505o(45517);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(45518);
            C4990ab.m7416i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: dialog cancel. finish");
            WalletLqtCheckPwdInputDialogUI.this.finish();
            AppMethodBeat.m2505o(45518);
        }

        public final void cMN() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        int i = 1;
        AppMethodBeat.m2504i(45519);
        super.onCreate(bundle);
        mo9439AM(4);
        this.mTitle = getIntent().getStringExtra("lqt_fetch_pwd_title");
        this.tgx = getIntent().getStringExtra("lqt_fetch_pwd_money");
        this.tgj = getIntent().getStringExtra("lqt_redeem_listid");
        C4990ab.m7417i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: money : %s, title : %s, redeemListId: %s", C5046bo.nullAsNil(this.tgx), C5046bo.nullAsNil(this.mTitle), this.tgj);
        if (C5046bo.isNullOrNil(this.mTitle) || C5046bo.isNullOrNil(this.tgx)) {
            i = 0;
        }
        if (i == 0) {
            C30379h.m48431a(this.mController.ylL, (int) C25738R.string.fkw, 0, new C295571());
            AppMethodBeat.m2505o(45519);
            return;
        }
        getWindow().setBackgroundDrawableResource(C25738R.color.a3p);
        showDialog();
        AppMethodBeat.m2505o(45519);
    }

    private void showDialog() {
        AppMethodBeat.m2504i(45520);
        if (this.tgy != null && this.tgy.isShowing()) {
            this.tgy.dismiss();
        }
        this.tgx = C36391e.m59972G(C5046bo.getDouble(this.tgx, 0.0d));
        this.tgy = new C4432b(this.mController.ylL);
        this.tgy.mo9473aq(this.mTitle, this.tgx, "");
        this.tgy.tMA = new C295582();
        this.tgy.show();
        addDialog(this.tgy);
        AppMethodBeat.m2505o(45520);
    }

    /* renamed from: wU */
    public final void mo8137wU(int i) {
        AppMethodBeat.m2504i(45521);
        if (i == 0) {
            finish();
            AppMethodBeat.m2505o(45521);
            return;
        }
        if (i == 1) {
            showDialog();
        }
        AppMethodBeat.m2505o(45521);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }
}
