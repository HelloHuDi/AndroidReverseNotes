package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class WalletVerifyIdCardUI extends WalletBaseUI {
    private TextView iDT;
    private boolean tLj = false;
    private i tLl = new i();
    private a tLm = new a() {
        public final void cRX() {
            AppMethodBeat.i(47721);
            WalletVerifyIdCardUI.b(WalletVerifyIdCardUI.this);
            AppMethodBeat.o(47721);
        }
    };
    private EditHintPasswdView tLs;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletVerifyIdCardUI() {
        AppMethodBeat.i(47722);
        AppMethodBeat.o(47722);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47723);
        super.onCreate(bundle);
        this.tLl = new i(this.mBundle);
        initView();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.a69)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            customView = customView.findViewById(R.id.p3);
            if (customView != null) {
                customView.setBackgroundColor(getResources().getColor(R.color.a3p));
            }
        }
        if (d.iW(21)) {
            if (d.iW(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(47718);
                WalletVerifyIdCardUI.this.finish();
                AppMethodBeat.o(47718);
                return false;
            }
        }, R.raw.actionbar_icon_dark_back);
        AppMethodBeat.o(47723);
    }

    public final void initView() {
        AppMethodBeat.i(47724);
        this.iDT = (TextView) findViewById(R.id.fhn);
        this.tLs = (EditHintPasswdView) findViewById(R.id.fho);
        String string = this.mBundle.getString("key_true_name");
        String string2 = this.mBundle.getString("key_cre_name");
        String string3 = this.mBundle.getString("key_cre_type");
        this.iDT.setText(getString(R.string.ffs, new Object[]{string, string2}));
        this.tLs.setEditTextMaxLength(4);
        this.tLs.setEditTextSize(34.0f);
        this.tLs.setOnInputValidListener(new EditHintPasswdView.a() {
            public final void hY(final boolean z) {
                AppMethodBeat.i(47720);
                WalletVerifyIdCardUI.this.tLs.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(47719);
                        if (z) {
                            if (WalletVerifyIdCardUI.a(WalletVerifyIdCardUI.this, WalletVerifyIdCardUI.this.tLm)) {
                                AppMethodBeat.o(47719);
                                return;
                            }
                            WalletVerifyIdCardUI.b(WalletVerifyIdCardUI.this);
                        }
                        AppMethodBeat.o(47719);
                    }
                }, 50);
                AppMethodBeat.o(47720);
            }
        });
        if ("1".equals(string3)) {
            e(this.tLs, 1, false);
            AppMethodBeat.o(47724);
            return;
        }
        e(this.tLs, 1, true);
        AppMethodBeat.o(47724);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47725);
        if (mVar instanceof n) {
            if (i2 == 0 || !((n) mVar).cNi) {
                this.tLs.cey();
            } else {
                h.a(this.mController.ylL, str, null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            AppMethodBeat.o(47725);
            return true;
        }
        AppMethodBeat.o(47725);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b6i;
    }

    public final boolean i(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47727);
        ab.i("MicroMsg.WalletVerifyIdCardUI", "onPreSceneEnd %s %s", Integer.valueOf(i2), mVar);
        if ((mVar instanceof n) && i2 == 0) {
            this.tLj = true;
            t.makeText(this, R.string.fmp, 0).show();
            ab.i("MicroMsg.WalletVerifyIdCardUI", "tag it isCertInstalled ok");
        }
        AppMethodBeat.o(47727);
        return true;
    }

    private boolean cRY() {
        AppMethodBeat.i(47726);
        boolean z = this.mBundle.getBoolean("key_is_oversea", false);
        AppMethodBeat.o(47726);
        return z;
    }

    static /* synthetic */ boolean a(WalletVerifyIdCardUI walletVerifyIdCardUI, a aVar) {
        AppMethodBeat.i(47728);
        if (walletVerifyIdCardUI.tLj) {
            ab.i("MicroMsg.WalletVerifyIdCardUI", "isCertInstalled passed");
            AppMethodBeat.o(47728);
            return false;
        }
        String string = walletVerifyIdCardUI.mBundle.getString("key_cre_type");
        String text = walletVerifyIdCardUI.tLs.getText();
        if (walletVerifyIdCardUI.tLl.cPo()) {
            ab.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isBlockInstall %s", aVar);
            if (bo.isNullOrNil(text)) {
                ab.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isBlockInstall sms error %s", aVar);
                AppMethodBeat.o(47728);
                return false;
            }
            com.tencent.mm.plugin.report.service.h.pYm.e(13731, Integer.valueOf(6));
            walletVerifyIdCardUI.a(new n(string, text, walletVerifyIdCardUI.cNH(), aVar, true), true, true);
            AppMethodBeat.o(47728);
            return true;
        } else if (walletVerifyIdCardUI.tLl.cPn()) {
            ab.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isNeedInstall %s", aVar);
            com.tencent.mm.plugin.report.service.h.pYm.e(13731, Integer.valueOf(6));
            walletVerifyIdCardUI.a(new n(string, text, walletVerifyIdCardUI.cNH(), aVar, false), true, true);
            AppMethodBeat.o(47728);
            return true;
        } else {
            ab.i("MicroMsg.WalletVerifyIdCardUI", "no need installcert");
            AppMethodBeat.o(47728);
            return false;
        }
    }

    static /* synthetic */ void b(WalletVerifyIdCardUI walletVerifyIdCardUI) {
        AppMethodBeat.i(47729);
        if (walletVerifyIdCardUI.dOE() != null) {
            ab.d("MicroMsg.WalletVerifyIdCardUI", "3des text: %s", walletVerifyIdCardUI.tLs.getText());
            s sVar = new s();
            sVar.guu = walletVerifyIdCardUI.mBundle.getString("key_pwd1");
            sVar.pGr = (PayInfo) walletVerifyIdCardUI.mBundle.getParcelable("key_pay_info");
            sVar.cHG = 1;
            sVar.tCl = walletVerifyIdCardUI.mBundle.getString("key_cre_type");
            sVar.tCk = walletVerifyIdCardUI.tLs.getText();
            sVar.token = bo.bc(walletVerifyIdCardUI.mBundle.getString("kreq_token"), "");
            switch (walletVerifyIdCardUI.mBundle.getInt("key_pay_flag", 0)) {
                case 1:
                    sVar.flag = "1";
                    break;
                case 2:
                    if (!walletVerifyIdCardUI.cRY()) {
                        sVar.flag = "2";
                        break;
                    } else {
                        sVar.flag = "5";
                        break;
                    }
                case 3:
                    if (!walletVerifyIdCardUI.cRY()) {
                        sVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                        break;
                    } else {
                        sVar.flag = "6";
                        break;
                    }
            }
            Bankcard bankcard = (Bankcard) walletVerifyIdCardUI.mBundle.getParcelable("key_bankcard");
            if (bankcard != null) {
                sVar.pbn = bankcard.field_bankcardType;
                sVar.pbo = bankcard.field_bindSerial;
                sVar.twk = bo.bc(bankcard.field_arrive_type, "");
            } else {
                sVar.pbn = walletVerifyIdCardUI.mBundle.getString("key_bank_type");
                if (bo.isNullOrNil(sVar.pbn)) {
                    sVar.pbn = walletVerifyIdCardUI.mBundle.getString("key_bind_card_type", "");
                }
            }
            walletVerifyIdCardUI.dOE().p(sVar);
        }
        AppMethodBeat.o(47729);
    }
}
