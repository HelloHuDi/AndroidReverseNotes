package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.ttpic.VError;

@a(19)
public class WalletPwdConfirmUI extends WalletBaseUI {
    private c ecA = new c<ux>() {
        {
            AppMethodBeat.i(47543);
            this.xxI = ux.class.getName().hashCode();
            AppMethodBeat.o(47543);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(47544);
            if (((ux) bVar) instanceof ux) {
                ab.d("Micromsg.WalletPwdConfirmUI", "event WalletPwdConfirmDoSecondaryProgressCallbackEvent");
                WalletPwdConfirmUI.this.tJv = false;
                WalletPwdConfirmUI.e(WalletPwdConfirmUI.this);
            }
            AppMethodBeat.o(47544);
            return false;
        }
    };
    private TextView iDT;
    private TextView kiF;
    protected EditHintPasswdView nrZ;
    private PayInfo pVL;
    private TextView tJu;
    private boolean tJv = false;
    private ap tJw = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(47542);
            if (WalletPwdConfirmUI.this.tJv) {
                WalletPwdConfirmUI.this.tJv = false;
                WalletPwdConfirmUI.e(WalletPwdConfirmUI.this);
            }
            AppMethodBeat.o(47542);
            return false;
        }
    }, false);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletPwdConfirmUI() {
        AppMethodBeat.i(47545);
        AppMethodBeat.o(47545);
    }

    static /* synthetic */ void a(WalletPwdConfirmUI walletPwdConfirmUI, View view, View view2) {
        AppMethodBeat.i(47552);
        walletPwdConfirmUI.b(view, view2, 30);
        AppMethodBeat.o(47552);
    }

    static /* synthetic */ void e(WalletPwdConfirmUI walletPwdConfirmUI) {
        AppMethodBeat.i(47553);
        walletPwdConfirmUI.cRL();
        AppMethodBeat.o(47553);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47546);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        initView();
        d.a(this, this.mBundle, 6);
        findViewById(R.id.f9w).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47538);
                if (WalletPwdConfirmUI.this.cNR()) {
                    WalletPwdConfirmUI.this.aqX();
                    WalletPwdConfirmUI.this.showDialog(1000);
                    AppMethodBeat.o(47538);
                    return;
                }
                WalletPwdConfirmUI.this.finish();
                AppMethodBeat.o(47538);
            }
        });
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(R.color.vy));
            if (VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        AppMethodBeat.o(47546);
    }

    public final void initView() {
        AppMethodBeat.i(47547);
        this.iDT = (TextView) findViewById(R.id.cfp);
        this.kiF = (TextView) findViewById(R.id.f9x);
        if (dOD() != null && "ModifyPwdProcess".equals(dOD().bxP())) {
            this.iDT.setText(R.string.fk2);
        }
        this.kiF.setText(R.string.ft9);
        this.tJu = (TextView) findViewById(R.id.fh7);
        if (bo.ac(dOF())) {
            this.tJu.setText(R.string.qt);
        } else {
            this.tJu.setText(R.string.ftd);
        }
        this.tJu.setVisibility(0);
        this.tJu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47539);
                String string = WalletPwdConfirmUI.this.mBundle.getString("key_new_pwd1");
                String md5Value = WalletPwdConfirmUI.this.nrZ.getMd5Value();
                String string2 = WalletPwdConfirmUI.this.mBundle.getString("kreq_token");
                String string3 = WalletPwdConfirmUI.this.mBundle.getString("key_verify_code");
                ab.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + WalletPwdConfirmUI.this.pVL + " vertifyCode: " + string3);
                if (string == null || !string.equals(md5Value)) {
                    com.tencent.mm.wallet_core.a.o(WalletPwdConfirmUI.this, VError.ERROR_FACE_MODEL_INIT);
                    AppMethodBeat.o(47539);
                    return;
                }
                s sVar = new s();
                sVar.guu = WalletPwdConfirmUI.this.nrZ.getText();
                sVar.pGr = WalletPwdConfirmUI.this.pVL;
                sVar.token = string2;
                sVar.tCi = string3;
                sVar.tCj = WalletPwdConfirmUI.this.mBundle.getBoolean("key_is_bind_bankcard", true);
                if (com.tencent.mm.wallet_core.a.aE(WalletPwdConfirmUI.this).cRY()) {
                    sVar.flag = "4";
                } else {
                    sVar.flag = "1";
                }
                FavorPayInfo favorPayInfo = (FavorPayInfo) WalletPwdConfirmUI.this.mBundle.getParcelable("key_favor_pay_info");
                if (favorPayInfo != null) {
                    sVar.twn = favorPayInfo.tze;
                    sVar.two = favorPayInfo.tzb;
                }
                WalletPwdConfirmUI.this.dOE().p(sVar);
                AppMethodBeat.o(47539);
            }
        });
        this.tJu.setEnabled(false);
        this.tJu.setClickable(false);
        this.nrZ = (EditHintPasswdView) findViewById(R.id.cfs);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.nrZ);
        this.nrZ.setEditTextMaxLength(6);
        this.nrZ.setOnInputValidListener(new EditHintPasswdView.a() {
            public final void hY(boolean z) {
                AppMethodBeat.i(47540);
                if (z) {
                    String string = WalletPwdConfirmUI.this.mBundle.getString("key_new_pwd1");
                    String md5Value = WalletPwdConfirmUI.this.nrZ.getMd5Value();
                    if (string == null || !string.equals(md5Value)) {
                        com.tencent.mm.wallet_core.a.o(WalletPwdConfirmUI.this, VError.ERROR_FACE_MODEL_INIT);
                        AppMethodBeat.o(47540);
                        return;
                    }
                    WalletPwdConfirmUI.this.tJu.setEnabled(z);
                    WalletPwdConfirmUI.this.tJu.setClickable(z);
                    AppMethodBeat.o(47540);
                    return;
                }
                WalletPwdConfirmUI.this.tJu.setEnabled(z);
                WalletPwdConfirmUI.this.tJu.setClickable(z);
                AppMethodBeat.o(47540);
            }
        });
        findViewById(R.id.dm7).setVisibility(8);
        e(this.nrZ, 0, false);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.ih);
        this.obM = new com.tencent.mm.wallet_core.ui.a() {
            public final void ic(boolean z) {
                AppMethodBeat.i(47541);
                if (z) {
                    WalletPwdConfirmUI.a(WalletPwdConfirmUI.this, scrollView, WalletPwdConfirmUI.this.tJu);
                    AppMethodBeat.o(47541);
                    return;
                }
                scrollView.scrollTo(0, 0);
                AppMethodBeat.o(47541);
            }
        };
        AppMethodBeat.o(47547);
    }

    public void onResume() {
        AppMethodBeat.i(47548);
        this.nrZ.requestFocus();
        super.onResume();
        com.tencent.mm.sdk.b.a.xxA.c(this.ecA);
        AppMethodBeat.o(47548);
    }

    public void onPause() {
        AppMethodBeat.i(47549);
        super.onPause();
        com.tencent.mm.sdk.b.a.xxA.d(this.ecA);
        AppMethodBeat.o(47549);
    }

    public final boolean bwQ() {
        return true;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47551);
        if (i == 0 && i2 == 0) {
            this.mBundle.putString("key_pwd1", this.nrZ.getText());
            if (mVar instanceof y) {
                if (!this.tJv) {
                    cRL();
                }
            } else if (com.tencent.mm.wallet_core.a.aE(this) == null || !com.tencent.mm.wallet_core.a.aE(this).c((Activity) this, null)) {
                com.tencent.mm.wallet_core.a.j(this, this.mBundle);
            } else {
                String str2;
                if (this.pVL != null) {
                    str2 = this.pVL.czZ;
                } else {
                    str2 = "";
                }
                a(new y(str2, 22), true, false);
                uy uyVar = new uy();
                if (com.tencent.mm.sdk.b.a.xxA.av(uyVar.getClass())) {
                    this.tJv = true;
                    com.tencent.mm.sdk.b.a.xxA.m(uyVar);
                }
                this.tJw.ae(10000, 10000);
            }
            AppMethodBeat.o(47551);
            return true;
        }
        AppMethodBeat.o(47551);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b66;
    }

    public final boolean cNR() {
        return true;
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void cRL() {
        AppMethodBeat.i(47550);
        Bundle bundle = this.mBundle;
        bundle.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.j(this, bundle);
        AppMethodBeat.o(47550);
    }
}
