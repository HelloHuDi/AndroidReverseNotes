package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32654ux;
import com.tencent.p177mm.p230g.p231a.C6555uy;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C40947a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView.C30883a;
import com.tencent.ttpic.VError;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI */
public class WalletPwdConfirmUI extends WalletBaseUI {
    private C4884c ecA = new C401196();
    private TextView iDT;
    private TextView kiF;
    protected EditHintPasswdView nrZ;
    private PayInfo pVL;
    private TextView tJu;
    private boolean tJv = false;
    private C7564ap tJw = new C7564ap(new C463705(), false);

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI$1 */
    class C226141 implements OnClickListener {
        C226141() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47538);
            if (WalletPwdConfirmUI.this.cNR()) {
                WalletPwdConfirmUI.this.aqX();
                WalletPwdConfirmUI.this.showDialog(1000);
                AppMethodBeat.m2505o(47538);
                return;
            }
            WalletPwdConfirmUI.this.finish();
            AppMethodBeat.m2505o(47538);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI$3 */
    class C401183 implements C30883a {
        C401183() {
        }

        /* renamed from: hY */
        public final void mo9438hY(boolean z) {
            AppMethodBeat.m2504i(47540);
            if (z) {
                String string = WalletPwdConfirmUI.this.mBundle.getString("key_new_pwd1");
                String md5Value = WalletPwdConfirmUI.this.nrZ.getMd5Value();
                if (string == null || !string.equals(md5Value)) {
                    C24143a.m37118o(WalletPwdConfirmUI.this, VError.ERROR_FACE_MODEL_INIT);
                    AppMethodBeat.m2505o(47540);
                    return;
                }
                WalletPwdConfirmUI.this.tJu.setEnabled(z);
                WalletPwdConfirmUI.this.tJu.setClickable(z);
                AppMethodBeat.m2505o(47540);
                return;
            }
            WalletPwdConfirmUI.this.tJu.setEnabled(z);
            WalletPwdConfirmUI.this.tJu.setClickable(z);
            AppMethodBeat.m2505o(47540);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI$6 */
    class C401196 extends C4884c<C32654ux> {
        C401196() {
            AppMethodBeat.m2504i(47543);
            this.xxI = C32654ux.class.getName().hashCode();
            AppMethodBeat.m2505o(47543);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(47544);
            if (((C32654ux) c4883b) instanceof C32654ux) {
                C4990ab.m7410d("Micromsg.WalletPwdConfirmUI", "event WalletPwdConfirmDoSecondaryProgressCallbackEvent");
                WalletPwdConfirmUI.this.tJv = false;
                WalletPwdConfirmUI.m87163e(WalletPwdConfirmUI.this);
            }
            AppMethodBeat.m2505o(47544);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI$2 */
    class C463692 implements OnClickListener {
        C463692() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47539);
            String string = WalletPwdConfirmUI.this.mBundle.getString("key_new_pwd1");
            String md5Value = WalletPwdConfirmUI.this.nrZ.getMd5Value();
            String string2 = WalletPwdConfirmUI.this.mBundle.getString("kreq_token");
            String string3 = WalletPwdConfirmUI.this.mBundle.getString("key_verify_code");
            C4990ab.m7410d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + WalletPwdConfirmUI.this.pVL + " vertifyCode: " + string3);
            if (string == null || !string.equals(md5Value)) {
                C24143a.m37118o(WalletPwdConfirmUI.this, VError.ERROR_FACE_MODEL_INIT);
                AppMethodBeat.m2505o(47539);
                return;
            }
            C14264s c14264s = new C14264s();
            c14264s.guu = WalletPwdConfirmUI.this.nrZ.getText();
            c14264s.pGr = WalletPwdConfirmUI.this.pVL;
            c14264s.token = string2;
            c14264s.tCi = string3;
            c14264s.tCj = WalletPwdConfirmUI.this.mBundle.getBoolean("key_is_bind_bankcard", true);
            if (C24143a.m37112aE(WalletPwdConfirmUI.this).cRY()) {
                c14264s.flag = "4";
            } else {
                c14264s.flag = "1";
            }
            FavorPayInfo favorPayInfo = (FavorPayInfo) WalletPwdConfirmUI.this.mBundle.getParcelable("key_favor_pay_info");
            if (favorPayInfo != null) {
                c14264s.twn = favorPayInfo.tze;
                c14264s.two = favorPayInfo.tzb;
            }
            WalletPwdConfirmUI.this.dOE().mo9366p(c14264s);
            AppMethodBeat.m2505o(47539);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI$5 */
    class C463705 implements C5015a {
        C463705() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(47542);
            if (WalletPwdConfirmUI.this.tJv) {
                WalletPwdConfirmUI.this.tJv = false;
                WalletPwdConfirmUI.m87163e(WalletPwdConfirmUI.this);
            }
            AppMethodBeat.m2505o(47542);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletPwdConfirmUI() {
        AppMethodBeat.m2504i(47545);
        AppMethodBeat.m2505o(47545);
    }

    /* renamed from: a */
    static /* synthetic */ void m87159a(WalletPwdConfirmUI walletPwdConfirmUI, View view, View view2) {
        AppMethodBeat.m2504i(47552);
        walletPwdConfirmUI.mo39974b(view, view2, 30);
        AppMethodBeat.m2505o(47552);
    }

    /* renamed from: e */
    static /* synthetic */ void m87163e(WalletPwdConfirmUI walletPwdConfirmUI) {
        AppMethodBeat.m2504i(47553);
        walletPwdConfirmUI.cRL();
        AppMethodBeat.m2505o(47553);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47546);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        initView();
        C40148d.m68847a(this, this.mBundle, 6);
        findViewById(2131828753).setOnClickListener(new C226141());
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(C25738R.color.f12206vy));
            if (VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        AppMethodBeat.m2505o(47546);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47547);
        this.iDT = (TextView) findViewById(2131824899);
        this.kiF = (TextView) findViewById(2131828754);
        if (dOD() != null && "ModifyPwdProcess".equals(dOD().bxP())) {
            this.iDT.setText(C25738R.string.fk2);
        }
        this.kiF.setText(C25738R.string.ft9);
        this.tJu = (TextView) findViewById(2131829060);
        if (C5046bo.m7519ac(dOF())) {
            this.tJu.setText(C25738R.string.f9142qt);
        } else {
            this.tJu.setText(C25738R.string.ftd);
        }
        this.tJu.setVisibility(0);
        this.tJu.setOnClickListener(new C463692());
        this.tJu.setEnabled(false);
        this.tJu.setClickable(false);
        this.nrZ = (EditHintPasswdView) findViewById(2131824902);
        C30890a.m49291a(this.nrZ);
        this.nrZ.setEditTextMaxLength(6);
        this.nrZ.setOnInputValidListener(new C401183());
        findViewById(2131826507).setVisibility(8);
        mo39989e(this.nrZ, 0, false);
        final ScrollView scrollView = (ScrollView) findViewById(2131820884);
        this.obM = new C40947a() {
            /* renamed from: ic */
            public final void mo9448ic(boolean z) {
                AppMethodBeat.m2504i(47541);
                if (z) {
                    WalletPwdConfirmUI.m87159a(WalletPwdConfirmUI.this, scrollView, WalletPwdConfirmUI.this.tJu);
                    AppMethodBeat.m2505o(47541);
                    return;
                }
                scrollView.scrollTo(0, 0);
                AppMethodBeat.m2505o(47541);
            }
        };
        AppMethodBeat.m2505o(47547);
    }

    public void onResume() {
        AppMethodBeat.m2504i(47548);
        this.nrZ.requestFocus();
        super.onResume();
        C4879a.xxA.mo10052c(this.ecA);
        AppMethodBeat.m2505o(47548);
    }

    public void onPause() {
        AppMethodBeat.m2504i(47549);
        super.onPause();
        C4879a.xxA.mo10053d(this.ecA);
        AppMethodBeat.m2505o(47549);
    }

    public final boolean bwQ() {
        return true;
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47551);
        if (i == 0 && i2 == 0) {
            this.mBundle.putString("key_pwd1", this.nrZ.getText());
            if (c1207m instanceof C35475y) {
                if (!this.tJv) {
                    cRL();
                }
            } else if (C24143a.m37112aE(this) == null || !C24143a.m37112aE(this).mo8128c((Activity) this, null)) {
                C24143a.m37116j(this, this.mBundle);
            } else {
                String str2;
                if (this.pVL != null) {
                    str2 = this.pVL.czZ;
                } else {
                    str2 = "";
                }
                mo39970a(new C35475y(str2, 22), true, false);
                C6555uy c6555uy = new C6555uy();
                if (C4879a.xxA.mo10050av(c6555uy.getClass())) {
                    this.tJv = true;
                    C4879a.xxA.mo10055m(c6555uy);
                }
                this.tJw.mo16770ae(10000, 10000);
            }
            AppMethodBeat.m2505o(47551);
            return true;
        }
        AppMethodBeat.m2505o(47551);
        return false;
    }

    public final int getLayoutId() {
        return 2130971169;
    }

    public final boolean cNR() {
        return true;
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void cRL() {
        AppMethodBeat.m2504i(47550);
        Bundle bundle = this.mBundle;
        bundle.putBoolean("intent_bind_end", true);
        C24143a.m37116j(this, bundle);
        AppMethodBeat.m2505o(47550);
    }
}
