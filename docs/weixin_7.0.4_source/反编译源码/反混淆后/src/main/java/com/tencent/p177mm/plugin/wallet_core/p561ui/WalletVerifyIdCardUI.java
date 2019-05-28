package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.model.C22592i;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C30860n;
import com.tencent.p177mm.wallet_core.p649c.C30860n.C30861a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView.C30883a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI */
public class WalletVerifyIdCardUI extends WalletBaseUI {
    private TextView iDT;
    private boolean tLj = false;
    private C22592i tLl = new C22592i();
    private C30861a tLm = new C438144();
    private EditHintPasswdView tLs;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI$2 */
    class C226182 implements C30883a {
        C226182() {
        }

        /* renamed from: hY */
        public final void mo9438hY(final boolean z) {
            AppMethodBeat.m2504i(47720);
            WalletVerifyIdCardUI.this.tLs.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(47719);
                    if (z) {
                        if (WalletVerifyIdCardUI.m78540a(WalletVerifyIdCardUI.this, WalletVerifyIdCardUI.this.tLm)) {
                            AppMethodBeat.m2505o(47719);
                            return;
                        }
                        WalletVerifyIdCardUI.m78541b(WalletVerifyIdCardUI.this);
                    }
                    AppMethodBeat.m2505o(47719);
                }
            }, 50);
            AppMethodBeat.m2505o(47720);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI$3 */
    class C226203 implements OnClickListener {
        C226203() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI$1 */
    class C296651 implements OnMenuItemClickListener {
        C296651() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(47718);
            WalletVerifyIdCardUI.this.finish();
            AppMethodBeat.m2505o(47718);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI$4 */
    class C438144 implements C30861a {
        C438144() {
        }

        public final void cRX() {
            AppMethodBeat.m2504i(47721);
            WalletVerifyIdCardUI.m78541b(WalletVerifyIdCardUI.this);
            AppMethodBeat.m2505o(47721);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletVerifyIdCardUI() {
        AppMethodBeat.m2504i(47722);
        AppMethodBeat.m2505o(47722);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47723);
        super.onCreate(bundle);
        this.tLl = new C22592i(this.mBundle);
        initView();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(C25738R.color.a69)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            customView = customView.findViewById(2131821128);
            if (customView != null) {
                customView.setBackgroundColor(getResources().getColor(C25738R.color.a3p));
            }
        }
        if (C1443d.m3068iW(21)) {
            if (C1443d.m3068iW(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        setMMTitle("");
        setBackBtn(new C296651(), C1318a.actionbar_icon_dark_back);
        AppMethodBeat.m2505o(47723);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47724);
        this.iDT = (TextView) findViewById(2131829077);
        this.tLs = (EditHintPasswdView) findViewById(2131829078);
        String string = this.mBundle.getString("key_true_name");
        String string2 = this.mBundle.getString("key_cre_name");
        String string3 = this.mBundle.getString("key_cre_type");
        this.iDT.setText(getString(C25738R.string.ffs, new Object[]{string, string2}));
        this.tLs.setEditTextMaxLength(4);
        this.tLs.setEditTextSize(34.0f);
        this.tLs.setOnInputValidListener(new C226182());
        if ("1".equals(string3)) {
            mo39989e(this.tLs, 1, false);
            AppMethodBeat.m2505o(47724);
            return;
        }
        mo39989e(this.tLs, 1, true);
        AppMethodBeat.m2505o(47724);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47725);
        if (c1207m instanceof C30860n) {
            if (i2 == 0 || !((C30860n) c1207m).cNi) {
                this.tLs.cey();
            } else {
                C30379h.m48448a(this.mController.ylL, str, null, false, new C226203());
            }
            AppMethodBeat.m2505o(47725);
            return true;
        }
        AppMethodBeat.m2505o(47725);
        return false;
    }

    public final int getLayoutId() {
        return 2130971182;
    }

    /* renamed from: i */
    public final boolean mo39991i(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47727);
        C4990ab.m7417i("MicroMsg.WalletVerifyIdCardUI", "onPreSceneEnd %s %s", Integer.valueOf(i2), c1207m);
        if ((c1207m instanceof C30860n) && i2 == 0) {
            this.tLj = true;
            C23639t.makeText(this, C25738R.string.fmp, 0).show();
            C4990ab.m7416i("MicroMsg.WalletVerifyIdCardUI", "tag it isCertInstalled ok");
        }
        AppMethodBeat.m2505o(47727);
        return true;
    }

    private boolean cRY() {
        AppMethodBeat.m2504i(47726);
        boolean z = this.mBundle.getBoolean("key_is_oversea", false);
        AppMethodBeat.m2505o(47726);
        return z;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m78540a(WalletVerifyIdCardUI walletVerifyIdCardUI, C30861a c30861a) {
        AppMethodBeat.m2504i(47728);
        if (walletVerifyIdCardUI.tLj) {
            C4990ab.m7416i("MicroMsg.WalletVerifyIdCardUI", "isCertInstalled passed");
            AppMethodBeat.m2505o(47728);
            return false;
        }
        String string = walletVerifyIdCardUI.mBundle.getString("key_cre_type");
        String text = walletVerifyIdCardUI.tLs.getText();
        if (walletVerifyIdCardUI.tLl.cPo()) {
            C4990ab.m7417i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isBlockInstall %s", c30861a);
            if (C5046bo.isNullOrNil(text)) {
                C4990ab.m7417i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isBlockInstall sms error %s", c30861a);
                AppMethodBeat.m2505o(47728);
                return false;
            }
            C7060h.pYm.mo8381e(13731, Integer.valueOf(6));
            walletVerifyIdCardUI.mo39970a(new C30860n(string, text, walletVerifyIdCardUI.cNH(), c30861a, true), true, true);
            AppMethodBeat.m2505o(47728);
            return true;
        } else if (walletVerifyIdCardUI.tLl.cPn()) {
            C4990ab.m7417i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isNeedInstall %s", c30861a);
            C7060h.pYm.mo8381e(13731, Integer.valueOf(6));
            walletVerifyIdCardUI.mo39970a(new C30860n(string, text, walletVerifyIdCardUI.cNH(), c30861a, false), true, true);
            AppMethodBeat.m2505o(47728);
            return true;
        } else {
            C4990ab.m7416i("MicroMsg.WalletVerifyIdCardUI", "no need installcert");
            AppMethodBeat.m2505o(47728);
            return false;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m78541b(WalletVerifyIdCardUI walletVerifyIdCardUI) {
        AppMethodBeat.m2504i(47729);
        if (walletVerifyIdCardUI.dOE() != null) {
            C4990ab.m7411d("MicroMsg.WalletVerifyIdCardUI", "3des text: %s", walletVerifyIdCardUI.tLs.getText());
            C14264s c14264s = new C14264s();
            c14264s.guu = walletVerifyIdCardUI.mBundle.getString("key_pwd1");
            c14264s.pGr = (PayInfo) walletVerifyIdCardUI.mBundle.getParcelable("key_pay_info");
            c14264s.cHG = 1;
            c14264s.tCl = walletVerifyIdCardUI.mBundle.getString("key_cre_type");
            c14264s.tCk = walletVerifyIdCardUI.tLs.getText();
            c14264s.token = C5046bo.m7532bc(walletVerifyIdCardUI.mBundle.getString("kreq_token"), "");
            switch (walletVerifyIdCardUI.mBundle.getInt("key_pay_flag", 0)) {
                case 1:
                    c14264s.flag = "1";
                    break;
                case 2:
                    if (!walletVerifyIdCardUI.cRY()) {
                        c14264s.flag = "2";
                        break;
                    } else {
                        c14264s.flag = "5";
                        break;
                    }
                case 3:
                    if (!walletVerifyIdCardUI.cRY()) {
                        c14264s.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                        break;
                    } else {
                        c14264s.flag = "6";
                        break;
                    }
            }
            Bankcard bankcard = (Bankcard) walletVerifyIdCardUI.mBundle.getParcelable("key_bankcard");
            if (bankcard != null) {
                c14264s.pbn = bankcard.field_bankcardType;
                c14264s.pbo = bankcard.field_bindSerial;
                c14264s.twk = C5046bo.m7532bc(bankcard.field_arrive_type, "");
            } else {
                c14264s.pbn = walletVerifyIdCardUI.mBundle.getString("key_bank_type");
                if (C5046bo.isNullOrNil(c14264s.pbn)) {
                    c14264s.pbn = walletVerifyIdCardUI.mBundle.getString("key_bind_card_type", "");
                }
            }
            walletVerifyIdCardUI.dOE().mo9366p(c14264s);
        }
        AppMethodBeat.m2505o(47729);
    }
}
