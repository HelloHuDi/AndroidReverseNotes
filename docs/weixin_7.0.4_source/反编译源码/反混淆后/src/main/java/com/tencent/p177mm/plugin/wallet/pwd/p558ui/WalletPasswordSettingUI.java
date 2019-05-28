package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18416uq;
import com.tencent.p177mm.p230g.p231a.C26096bt;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C45375um;
import com.tencent.p177mm.p230g.p231a.C6533on;
import com.tencent.p177mm.p230g.p232b.p233a.C42088bj;
import com.tencent.p177mm.p230g.p232b.p233a.C46880bi;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.p1658b.C46333a;
import com.tencent.p177mm.plugin.wallet.pwd.C35452a;
import com.tencent.p177mm.plugin.wallet.pwd.C46357b;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C22539j;
import com.tencent.p177mm.plugin.wallet_core.id_verify.C40105a;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C43799ad;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14224ae;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7306ak.C4998a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI */
public class WalletPasswordSettingUI extends MMPreference implements C1202f {
    private boolean eFu;
    private C15541f ehK;
    private Dialog gII;
    private C7306ak handler = new C7306ak(new C142171());
    C4884c tmk = new C400845();
    CheckBoxPreference tsg;
    RightBelowPreference tsh;
    private boolean tsi = false;
    private IconPreference tsj;
    private Preference tsk;
    private String tsl;
    private String tsm;
    private String tsn;
    private C43799ad tso;
    private C43799ad tsp;
    private C43799ad tsq;
    private boolean tsr = false;
    private int tss = 0;
    private int tst = 0;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI$9 */
    class C43809 implements OnClickListener {
        C43809() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46359);
            WalletPasswordSettingUI.m68699f(WalletPasswordSettingUI.this);
            AppMethodBeat.m2505o(46359);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI$1 */
    class C142171 implements C4998a {
        C142171() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(46350);
            switch (message.what) {
                case 1:
                    WalletPasswordSettingUI.m68693a(WalletPasswordSettingUI.this);
                    break;
                case 2:
                    WalletPasswordSettingUI.m68695b(WalletPasswordSettingUI.this);
                    break;
                case 3:
                    WalletPasswordSettingUI.m68696c(WalletPasswordSettingUI.this);
                    break;
            }
            AppMethodBeat.m2505o(46350);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI$3 */
    class C225483 implements OnClickListener {
        C225483() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI$2 */
    class C296082 implements OnClickListener {
        C296082() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI$4 */
    class C296094 implements OnCancelListener {
        C296094() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(46351);
            if (WalletPasswordSettingUI.this.gII != null) {
                WalletPasswordSettingUI.this.gII.dismiss();
            }
            AppMethodBeat.m2505o(46351);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI$6 */
    class C354656 implements OnMenuItemClickListener {
        C354656() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(46354);
            WalletPasswordSettingUI.this.finish();
            AppMethodBeat.m2505o(46354);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI$7 */
    class C354667 implements C30857a {

        /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI$7$1 */
        class C142181 implements Runnable {
            C142181() {
            }

            public final void run() {
                AppMethodBeat.m2504i(46355);
                WalletPasswordSettingUI.this.cOI();
                AppMethodBeat.m2505o(46355);
            }
        }

        C354667() {
        }

        /* renamed from: n */
        public final Intent mo7785n(int i, Bundle bundle) {
            AppMethodBeat.m2504i(46356);
            C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "end readname process");
            C18416uq c18416uq = new C18416uq();
            if (i == -1) {
                c18416uq.cQP.scene = 17;
            } else if (i == 0) {
                c18416uq.cQP.scene = 18;
            } else {
                c18416uq.cQP.scene = 0;
            }
            c18416uq.cQQ.cQH = new C142181();
            C4879a.xxA.mo10055m(c18416uq);
            AppMethodBeat.m2505o(46356);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI$8 */
    class C354678 implements OnClickListener {
        C354678() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46358);
            final C4883b c26096bt = new C26096bt();
            c26096bt.callback = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(46357);
                    if (c26096bt.cuT != null) {
                        if (c26096bt.cuT.retCode == 0) {
                            WalletPasswordSettingUI.m68698e(WalletPasswordSettingUI.this);
                            C1720g.m3537RQ();
                            C1720g.m3535RO().eJo.mo14541a(new C35475y(null, 19), 0);
                            AppMethodBeat.m2505o(46357);
                            return;
                        }
                        WalletPasswordSettingUI.m68699f(WalletPasswordSettingUI.this);
                        WalletPasswordSettingUI.m68700g(WalletPasswordSettingUI.this);
                    }
                    AppMethodBeat.m2505o(46357);
                }
            };
            C4879a.xxA.mo10048a(c26096bt, WalletPasswordSettingUI.this.getMainLooper());
            AppMethodBeat.m2505o(46358);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI$5 */
    class C400845 extends C4884c<C45375um> {
        C400845() {
            AppMethodBeat.m2504i(46352);
            this.xxI = C45375um.class.getName().hashCode();
            AppMethodBeat.m2505o(46352);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(46353);
            WalletPasswordSettingUI.m68697d(WalletPasswordSettingUI.this);
            WalletPasswordSettingUI.this.cOI();
            AppMethodBeat.m2505o(46353);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletPasswordSettingUI() {
        AppMethodBeat.m2504i(46361);
        AppMethodBeat.m2505o(46361);
    }

    /* renamed from: d */
    static /* synthetic */ void m68697d(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.m2504i(46380);
        walletPasswordSettingUI.m68704nc(true);
        AppMethodBeat.m2505o(46380);
    }

    /* renamed from: e */
    static /* synthetic */ void m68698e(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.m2504i(46381);
        walletPasswordSettingUI.m68703nb(false);
        AppMethodBeat.m2505o(46381);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    /* renamed from: gK */
    private void m68701gK(String str, String str2) {
        AppMethodBeat.m2504i(46363);
        this.tsj.setTitle((CharSequence) str);
        if (C5046bo.isNullOrNil(str2)) {
            this.ehK.mo27715ce("wallet_open_auto_pay", true);
            C4990ab.m7412e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null");
            AppMethodBeat.m2505o(46363);
            return;
        }
        this.ehK.mo27715ce("wallet_open_auto_pay", false);
        AppMethodBeat.m2505o(46363);
    }

    private void cOE() {
        AppMethodBeat.m2504i(46364);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC, (Object) "");
        C1720g.m3537RQ();
        C4990ab.m7417i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", str, (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, (Object) ""));
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(r1)) {
            this.ehK.mo27715ce("wallet_password_setting_un_reg", true);
            AppMethodBeat.m2505o(46364);
            return;
        }
        this.ehK.mo27715ce("wallet_password_setting_un_reg", false);
        AppMethodBeat.m2505o(46364);
    }

    public void onResume() {
        AppMethodBeat.m2504i(46365);
        super.onResume();
        if (((C40167b) C1720g.m3528K(C40167b.class)).cTk()) {
            finish();
            AppMethodBeat.m2505o(46365);
            return;
        }
        cOI();
        AppMethodBeat.m2505o(46365);
    }

    public final void initView() {
        AppMethodBeat.m2504i(46366);
        setMMTitle(C44423ae.m80310is(this));
        C36391e.dOJ();
        this.ehK = this.yCw;
        this.ehK.addPreferencesFromResource(cOF());
        this.tsj = (IconPreference) this.ehK.aqO("wallet_open_auto_pay");
        this.tsk = this.ehK.aqO("wallet_delay_transfer_date");
        C1720g.m3537RQ();
        if (!((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_PAY_DEDUCT_IS_NEW_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            this.tsj.mo48775ez(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
            this.tsj.mo48764NM(0);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_PAY_DEDUCT_IS_NEW_BOOLEAN_SYNC, Boolean.TRUE);
        }
        this.tsg = (CheckBoxPreference) this.ehK.aqO("wallet_fingerprint_switch");
        this.tsh = (RightBelowPreference) this.ehK.aqO("wallet_biometric_pay");
        cOI();
        this.ehK.mo27715ce("nfc_idpay", true);
        this.ehK.mo27715ce("wallet_open_auto_pay", true);
        this.ehK.mo27715ce("wallet_universal_pay_order", true);
        cOE();
        setBackBtn(new C354656());
        if (C46333a.cOR()) {
            C7060h.pYm.mo8381e(15817, Integer.valueOf(0));
        }
        AppMethodBeat.m2505o(46366);
    }

    /* Access modifiers changed, original: protected */
    public int cOF() {
        return C25738R.xml.f8579cs;
    }

    /* Access modifiers changed, original: protected */
    public void cOG() {
        AppMethodBeat.m2504i(46367);
        C24143a.m37106a((Activity) this, C46357b.class, null, null);
        AppMethodBeat.m2505o(46367);
    }

    /* Access modifiers changed, original: protected */
    public void cOH() {
        AppMethodBeat.m2504i(46368);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_paymanager", true);
        bundle.putInt("key_forgot_scene", 2);
        C24143a.m37106a((Activity) this, C35452a.class, bundle, null);
        AppMethodBeat.m2505o(46368);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(46370);
        String str;
        Intent intent;
        Intent intent2;
        if ("wallet_modify_password".equals(preference.mKey)) {
            cOG();
            C36391e.m59978QS(24);
            AppMethodBeat.m2505o(46370);
            return true;
        } else if ("wallet_forget_password".equals(preference.mKey)) {
            C1720g.m3537RQ();
            str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_DEDUCT_FORGET_URL_STRING, (Object) "");
            C46880bi c46880bi;
            if (C5046bo.isNullOrNil(str)) {
                str = C14241r.cPI().cQu();
                if (C5046bo.isNullOrNil(str)) {
                    cOH();
                    c46880bi = new C46880bi();
                    c46880bi.dck = 2;
                    c46880bi.dcl = 1;
                    c46880bi.ajK();
                    C36391e.m59978QS(25);
                    AppMethodBeat.m2505o(46370);
                    return true;
                }
                C4990ab.m7417i("MicroMsg.WalletPasswordSettingUI", "jump to forget url: %s", str);
                C36391e.m60016n(this, str, false);
                AppMethodBeat.m2505o(46370);
                return true;
            }
            C4990ab.m7417i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", str);
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            c46880bi = new C46880bi();
            c46880bi.dck = 2;
            c46880bi.dcl = 2;
            c46880bi.ajK();
            AppMethodBeat.m2505o(46370);
            return true;
        } else if ("wallet_realname_verify".equals(preference.mKey)) {
            if (!C14241r.cPI().cQg()) {
                C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "go to RealNameVerifyProcess");
                Bundle bundle = new Bundle();
                bundle.putInt("real_name_verify_mode", 0);
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                bundle.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
                C24143a.m37106a((Activity) this, C40105a.class, bundle, new C354667());
            } else if (C5046bo.isNullOrNil(this.tsm)) {
                C4990ab.m7412e("MicroMsg.WalletPasswordSettingUI", "mRealnameUrl is null");
            } else {
                C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
                intent2 = new Intent();
                intent2.putExtra("rawUrl", this.tsm);
                intent2.putExtra("showShare", false);
                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
            }
            AppMethodBeat.m2505o(46370);
            return true;
        } else if ("wallet_biometric_pay".equals(preference.mKey)) {
            startActivity(new Intent(this, WalletBiometricPaySettingsUI.class));
            AppMethodBeat.m2505o(46370);
            return true;
        } else {
            if ("wallet_open_auto_pay".equals(preference.mKey)) {
                if (C5046bo.isNullOrNil(this.tsl)) {
                    C4990ab.m7412e("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is null");
                } else {
                    C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is not null,jump!");
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", this.tsl);
                    intent2.putExtra("showShare", false);
                    C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                    this.tsj.mo48764NM(8);
                    AppMethodBeat.m2505o(46370);
                    return true;
                }
            }
            if ("wallet_digitalcert".equals(preference.mKey)) {
                if (!this.tsr) {
                    C1207m c22539j = new C22539j();
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(c22539j, 0);
                }
                C25985d.m41467b((Context) this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
                AppMethodBeat.m2505o(46370);
                return true;
            } else if ("wallet_delay_transfer_date".equals(preference.mKey)) {
                startActivity(new Intent(this, WalletDelayTransferSettingUI.class));
                AppMethodBeat.m2505o(46370);
                return true;
            } else {
                if ("wallet_password_setting_un_reg".equals(preference.mKey)) {
                    C1720g.m3537RQ();
                    str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, (Object) "");
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                }
                if ("wallet_switch_currency".equals(preference.mKey)) {
                    m68694a(this.tsp);
                    AppMethodBeat.m2505o(46370);
                    return true;
                } else if ("wallet_im_mch".equals(preference.mKey)) {
                    m68694a(this.tsq);
                    AppMethodBeat.m2505o(46370);
                    return true;
                } else if ("wallet_universal_pay_order".equals(preference.mKey)) {
                    startActivity(new Intent(this.mController.ylL, WalletUniversalPayOrderUI.class));
                    AppMethodBeat.m2505o(46370);
                    return true;
                } else if ("wallet_function_settings".equals(preference.mKey)) {
                    C25985d.m41448H(this.mController.ylL, "mall", ".ui.MallFunctionSettingsUI");
                    AppMethodBeat.m2505o(46370);
                    return true;
                } else {
                    AppMethodBeat.m2505o(46370);
                    return false;
                }
            }
        }
    }

    /* renamed from: a */
    private void m68694a(C43799ad c43799ad) {
        AppMethodBeat.m2504i(46371);
        switch (c43799ad.field_jump_type) {
            case 1:
                C4990ab.m7417i("MicroMsg.WalletPasswordSettingUI", "jump type h5, url: %s", c43799ad.field_pref_url);
                if (!C5046bo.isNullOrNil(c43799ad.field_pref_url)) {
                    C36391e.m60016n(this, c43799ad.field_pref_url, false);
                    AppMethodBeat.m2505o(46371);
                    return;
                }
                break;
            case 2:
                if (!C5046bo.isNullOrNil(c43799ad.field_tinyapp_username)) {
                    C32628se c32628se = new C32628se();
                    c32628se.cOf.userName = c43799ad.field_tinyapp_username;
                    c32628se.cOf.cOh = C5046bo.m7532bc(c43799ad.field_tinyapp_path, "");
                    c32628se.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_FEIHONG;
                    c32628se.cOf.cOi = 0;
                    C4879a.xxA.mo10055m(c32628se);
                    AppMethodBeat.m2505o(46371);
                    return;
                }
                break;
            case 3:
                C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "jump type payment management");
                C25985d.m41448H(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                AppMethodBeat.m2505o(46371);
                return;
            case 4:
                C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "jump type payment security");
                Intent intent = new Intent();
                intent.putExtra("wallet_lock_jsapi_scene", 1);
                C25985d.m41467b((Context) this, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent);
                C42088bj c42088bj = new C42088bj();
                AppMethodBeat.m2505o(46371);
                return;
            case 5:
                C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "jump type wallet switch");
                C25985d.m41471c((Context) this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
                AppMethodBeat.m2505o(46371);
                return;
            case 8:
                C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "jump type honey pay");
                C25985d.m41448H(this, "honey_pay", ".ui.HoneyPayMainUI");
                break;
        }
        AppMethodBeat.m2505o(46371);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(46372);
        if (i == 65281 && i2 == -1) {
            if (C1853r.m3832YN()) {
                finish();
            } else {
                finish();
                C6533on c6533on = new C6533on();
                c6533on.cKQ.context = this.mController.ylL;
                C4879a.xxA.mo10055m(c6533on);
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(46372);
    }

    /* Access modifiers changed, original: protected */
    public void cOI() {
        boolean z;
        boolean z2;
        AppMethodBeat.m2504i(46373);
        if (C14241r.cPI().cQi() || C14241r.cPI().cQh()) {
            this.ehK.mo27715ce("wallet_modify_password", true);
            this.ehK.mo27715ce("wallet_forget_password", true);
            this.ehK.mo27715ce("wallet_realname_verify", false);
            this.ehK.aqO("wallet_realname_verify").setSummary((int) C25738R.string.fnc);
            this.ehK.mo27715ce("wallet_universal_pay_order", true);
            this.ehK.mo27715ce("wallet_switch_currency", true);
            this.ehK.mo27715ce("wallet_switch_category", true);
            this.ehK.mo27715ce("wallet_biometric_pay", true);
        } else if (C14241r.cPI().cQg()) {
            this.ehK.mo27715ce("wallet_modify_password", false);
            this.ehK.mo27715ce("wallet_forget_password", false);
            this.ehK.mo27715ce("wallet_realname_verify", false);
            this.ehK.aqO("wallet_realname_verify").setSummary((int) C25738R.string.fni);
            this.ehK.mo27715ce("wallet_universal_pay_order", true);
            if (C14241r.cPI().cQi() || C14241r.cPI().cQh()) {
                this.ehK.mo27715ce("wallet_biometric_pay", true);
            } else {
                C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
                if (C46333a.cOQ() && C46333a.cOR()) {
                    this.tsh.setTitle((int) C25738R.string.fn3);
                    this.tsh.setSummary((int) C25738R.string.fn2);
                    if (c30052l.bxh()) {
                        this.tsh.mo56186L(getString(C25738R.string.fa3));
                    } else if (c30052l.bxe()) {
                        this.tsh.mo56186L(getString(C25738R.string.fa4));
                    } else {
                        this.tsh.mo56186L(getString(C25738R.string.eu7));
                    }
                } else if (C46333a.cOQ()) {
                    this.tsh.setTitle((int) C25738R.string.fn1);
                    this.tsh.setSummary((int) C25738R.string.fn0);
                    if (c30052l.bxe()) {
                        this.tsh.mo56186L(getString(C25738R.string.etw));
                    } else {
                        this.tsh.mo56186L(getString(C25738R.string.eu7));
                    }
                } else if (C46333a.cOR()) {
                    this.tsh.setTitle((int) C25738R.string.fmz);
                    this.tsh.setSummary((int) C25738R.string.fmy);
                    if (c30052l.bxh()) {
                        this.tsh.mo56186L(getString(C25738R.string.etw));
                    } else {
                        this.tsh.mo56186L(getString(C25738R.string.eu7));
                    }
                } else {
                    this.ehK.mo27715ce("wallet_biometric_pay", true);
                }
            }
        } else {
            C4990ab.m7412e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
        }
        this.ehK.mo27715ce("wallet_universal_pay_order", true);
        this.ehK.mo27715ce("wallet_digitalcert", true);
        this.tsp = C14241r.cPH().acO("wallet_switch_currency");
        if (this.tsp == null || this.tsp.field_is_show != 1) {
            this.ehK.mo27715ce("wallet_switch_currency", true);
            z = true;
        } else {
            this.ehK.mo27715ce("wallet_switch_currency", false);
            Preference aqO = this.ehK.aqO("wallet_switch_currency");
            aqO.setTitle(this.tsp.field_pref_title);
            aqO.setSummary(this.tsp.field_pref_desc);
            z = false;
        }
        this.tsq = C14241r.cPH().acO("wallet_im_mch");
        if (this.tsq == null || this.tsq.field_is_show != 1) {
            this.ehK.mo27715ce("wallet_im_mch", true);
            z2 = true;
        } else {
            this.ehK.mo27715ce("wallet_im_mch", false);
            Preference aqO2 = this.ehK.aqO("wallet_im_mch");
            aqO2.setTitle(this.tsq.field_pref_title);
            aqO2.setSummary(this.tsq.field_pref_desc);
            z2 = false;
        }
        C4990ab.m7417i("MicroMsg.WalletPasswordSettingUI", "hideSwitch: %s, hideImMch: %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z && z2) {
            this.ehK.mo27715ce("wallet_switch_category", true);
        } else {
            this.ehK.mo27715ce("wallet_switch_category", false);
        }
        C1720g.m3537RQ();
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(147457, Long.valueOf(0))).longValue();
        int i = C25738R.string.fe7;
        if ((16 & longValue) != 0) {
            i = C25738R.string.fe6;
        } else if ((longValue & 32) != 0) {
            i = C25738R.string.fe5;
        }
        this.ehK.aqO("wallet_delay_transfer_date").setSummary(i);
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_wcpay_android_wallet_management_entry, 0) == 0) {
            this.ehK.mo27715ce("wallet_function_settings", true);
        } else {
            this.ehK.mo27715ce("wallet_function_settings", false);
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(46373);
    }

    /* renamed from: nc */
    private void m68704nc(boolean z) {
        AppMethodBeat.m2504i(46374);
        C1207m c22539j = new C22539j();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c22539j, 0);
        this.tsr = true;
        if (z) {
            this.gII = C30901g.m49317a((Context) this, false, new C296094());
        }
        AppMethodBeat.m2505o(46374);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46375);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C22539j) {
                cOI();
                C22539j c22539j = (C22539j) c1207m;
                C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + c22539j.tqB);
                this.tsm = c22539j.tqF;
                if (c22539j.tqB == 1) {
                    this.tsl = c22539j.tqC;
                    m68701gK(C5046bo.m7532bc(c22539j.tqE, getString(C25738R.string.foe)), c22539j.tqC);
                } else {
                    this.ehK.mo27715ce("wallet_open_auto_pay", true);
                }
                cOE();
                if (this.gII != null) {
                    this.gII.dismiss();
                }
                AppMethodBeat.m2505o(46375);
                return;
            } else if (c1207m instanceof C14224ae) {
                this.tsn = ((C14224ae) c1207m).tuB;
                this.tss = ((C14224ae) c1207m).tuG;
                if (this.tss == 0) {
                    this.ehK.mo27715ce("wallet_delay_transfer_date", true);
                    AppMethodBeat.m2505o(46375);
                    return;
                }
                if (C5046bo.isNullOrNil(this.tsn)) {
                    C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
                } else {
                    this.tsk.setTitle(this.tsn);
                }
                this.ehK.mo27715ce("wallet_delay_transfer_date", false);
                AppMethodBeat.m2505o(46375);
                return;
            }
        } else if (c1207m instanceof C14224ae) {
            C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
        }
        AppMethodBeat.m2505o(46375);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46376);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.tmk);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
        AppMethodBeat.m2505o(46376);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46362);
        this.yll = true;
        super.onCreate(bundle);
        mo17446xE(this.mController.dyj());
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(385, (C1202f) this);
        C4879a.xxA.mo10052c(this.tmk);
        this.eFu = getIntent().getBooleanExtra("key_is_from_system", false);
        this.tsi = getIntent().getBooleanExtra("key_default_show_currency", false);
        if (this.eFu) {
            C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
            ((C40167b) C1720g.m3528K(C40167b.class)).mo38286a(this, null);
        }
        initView();
        if (C22539j.bxX()) {
            m68704nc(false);
        } else {
            C1720g.m3537RQ();
            this.tsm = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REALNAME_URL_STRING_SYNC, (Object) "");
            this.tso = C14241r.cPH().acO("wallet_open_auto_pay");
            if (this.tso != null && this.tso.field_is_show == 1 && !C5046bo.isNullOrNil(this.tso.field_pref_url)) {
                C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
                this.tsl = this.tso.field_pref_url;
                m68701gK(this.tso.field_pref_title, this.tso.field_pref_url);
            } else if (this.tso == null) {
                C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
            } else {
                C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.tso.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + C5046bo.isNullOrNil(this.tso.field_pref_url));
            }
        }
        C1720g.m3537RQ();
        this.tss = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DELAY_TRANSFER_SHOW_SWITCH_FLAG_INT, Integer.valueOf(0))).intValue();
        C1720g.m3537RQ();
        this.tsn = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DELAY_TRANSFER_SWITCH_WORDING_STRING, (Object) "");
        if (C5046bo.isNullOrNil(this.tsn)) {
            C14224ae.m22423a(true, null);
        } else {
            this.tsk.setTitle(this.tsn);
            C14224ae.m22423a(false, null);
        }
        if (this.tss == 0) {
            this.ehK.mo27715ce("wallet_delay_transfer_date", true);
        }
        AppMethodBeat.m2505o(46362);
    }

    /* renamed from: nb */
    private void m68703nb(boolean z) {
        AppMethodBeat.m2504i(46369);
        this.ehZ.edit().putBoolean("wallet_fingerprint_switch", z).commit();
        this.tsg.uOT = z;
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(46369);
    }

    /* renamed from: b */
    static /* synthetic */ void m68695b(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.m2504i(46378);
        walletPasswordSettingUI.m68703nb(false);
        final C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        C30379h.m48445a((Context) walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(C25738R.string.fnm), "", walletPasswordSettingUI.getResources().getString(c30052l.bxr() ? C25738R.string.fnl : C25738R.string.f9187s6), walletPasswordSettingUI.getString(C25738R.string.f9076or), true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(46360);
                C4990ab.m7416i("MicroMsg.WalletPasswordSettingUI", "user click the button to set system fingerprint");
                c30052l.mo48310dO(WalletPasswordSettingUI.this);
                AppMethodBeat.m2505o(46360);
            }
        }, new C296082());
        AppMethodBeat.m2505o(46378);
    }

    /* renamed from: c */
    static /* synthetic */ void m68696c(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.m2504i(46379);
        walletPasswordSettingUI.m68703nb(false);
        C1720g.m3528K(C30052l.class);
        C30379h.m48443a((Context) walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(C25738R.string.fnk), "", walletPasswordSettingUI.getString(C25738R.string.fnj), new C225483());
        AppMethodBeat.m2505o(46379);
    }

    /* renamed from: f */
    static /* synthetic */ void m68699f(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.m2504i(46382);
        C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
        if (walletPasswordSettingUI.tsg.isChecked() != c30052l.bxe()) {
            walletPasswordSettingUI.m68703nb(c30052l.bxe());
            AppMethodBeat.m2505o(46382);
            return;
        }
        AppMethodBeat.m2505o(46382);
    }

    /* renamed from: g */
    static /* synthetic */ void m68700g(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.m2504i(46383);
        C30379h.m48461b((Context) walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(C25738R.string.bv7), "", true);
        AppMethodBeat.m2505o(46383);
    }
}
