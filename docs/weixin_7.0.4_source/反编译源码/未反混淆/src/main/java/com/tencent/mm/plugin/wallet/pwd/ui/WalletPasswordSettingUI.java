package com.tencent.mm.plugin.wallet.pwd.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.um;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.g.b.a.bi;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pwd.a.j;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.ttpic.FilterEnum4Shaka;

public class WalletPasswordSettingUI extends MMPreference implements f {
    private boolean eFu;
    private com.tencent.mm.ui.base.preference.f ehK;
    private Dialog gII;
    private ak handler = new ak(new a() {
        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(46350);
            switch (message.what) {
                case 1:
                    WalletPasswordSettingUI.a(WalletPasswordSettingUI.this);
                    break;
                case 2:
                    WalletPasswordSettingUI.b(WalletPasswordSettingUI.this);
                    break;
                case 3:
                    WalletPasswordSettingUI.c(WalletPasswordSettingUI.this);
                    break;
            }
            AppMethodBeat.o(46350);
            return false;
        }
    });
    c tmk = new c<um>() {
        {
            AppMethodBeat.i(46352);
            this.xxI = um.class.getName().hashCode();
            AppMethodBeat.o(46352);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(46353);
            WalletPasswordSettingUI.d(WalletPasswordSettingUI.this);
            WalletPasswordSettingUI.this.cOI();
            AppMethodBeat.o(46353);
            return false;
        }
    };
    CheckBoxPreference tsg;
    RightBelowPreference tsh;
    private boolean tsi = false;
    private IconPreference tsj;
    private Preference tsk;
    private String tsl;
    private String tsm;
    private String tsn;
    private ad tso;
    private ad tsp;
    private ad tsq;
    private boolean tsr = false;
    private int tss = 0;
    private int tst = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletPasswordSettingUI() {
        AppMethodBeat.i(46361);
        AppMethodBeat.o(46361);
    }

    static /* synthetic */ void d(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(46380);
        walletPasswordSettingUI.nc(true);
        AppMethodBeat.o(46380);
    }

    static /* synthetic */ void e(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(46381);
        walletPasswordSettingUI.nb(false);
        AppMethodBeat.o(46381);
    }

    public final int JC() {
        return -1;
    }

    private void gK(String str, String str2) {
        AppMethodBeat.i(46363);
        this.tsj.setTitle((CharSequence) str);
        if (bo.isNullOrNil(str2)) {
            this.ehK.ce("wallet_open_auto_pay", true);
            ab.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null");
            AppMethodBeat.o(46363);
            return;
        }
        this.ehK.ce("wallet_open_auto_pay", false);
        AppMethodBeat.o(46363);
    }

    private void cOE() {
        AppMethodBeat.i(46364);
        g.RQ();
        String str = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC, (Object) "");
        g.RQ();
        ab.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", str, (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, (Object) ""));
        if (bo.isNullOrNil(str) || bo.isNullOrNil(r1)) {
            this.ehK.ce("wallet_password_setting_un_reg", true);
            AppMethodBeat.o(46364);
            return;
        }
        this.ehK.ce("wallet_password_setting_un_reg", false);
        AppMethodBeat.o(46364);
    }

    public void onResume() {
        AppMethodBeat.i(46365);
        super.onResume();
        if (((com.tencent.mm.plugin.walletlock.a.b) g.K(com.tencent.mm.plugin.walletlock.a.b.class)).cTk()) {
            finish();
            AppMethodBeat.o(46365);
            return;
        }
        cOI();
        AppMethodBeat.o(46365);
    }

    public final void initView() {
        AppMethodBeat.i(46366);
        setMMTitle(ae.is(this));
        e.dOJ();
        this.ehK = this.yCw;
        this.ehK.addPreferencesFromResource(cOF());
        this.tsj = (IconPreference) this.ehK.aqO("wallet_open_auto_pay");
        this.tsk = this.ehK.aqO("wallet_delay_transfer_date");
        g.RQ();
        if (!((Boolean) g.RP().Ry().get(ac.a.USERINFO_WALLET_PAY_DEDUCT_IS_NEW_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            this.tsj.ez(getString(R.string.s0), R.drawable.w3);
            this.tsj.NM(0);
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_WALLET_PAY_DEDUCT_IS_NEW_BOOLEAN_SYNC, Boolean.TRUE);
        }
        this.tsg = (CheckBoxPreference) this.ehK.aqO("wallet_fingerprint_switch");
        this.tsh = (RightBelowPreference) this.ehK.aqO("wallet_biometric_pay");
        cOI();
        this.ehK.ce("nfc_idpay", true);
        this.ehK.ce("wallet_open_auto_pay", true);
        this.ehK.ce("wallet_universal_pay_order", true);
        cOE();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(46354);
                WalletPasswordSettingUI.this.finish();
                AppMethodBeat.o(46354);
                return true;
            }
        });
        if (com.tencent.mm.plugin.wallet.b.a.cOR()) {
            h.pYm.e(15817, Integer.valueOf(0));
        }
        AppMethodBeat.o(46366);
    }

    /* Access modifiers changed, original: protected */
    public int cOF() {
        return R.xml.cs;
    }

    /* Access modifiers changed, original: protected */
    public void cOG() {
        AppMethodBeat.i(46367);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
        AppMethodBeat.o(46367);
    }

    /* Access modifiers changed, original: protected */
    public void cOH() {
        AppMethodBeat.i(46368);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_paymanager", true);
        bundle.putInt("key_forgot_scene", 2);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.pwd.a.class, bundle, null);
        AppMethodBeat.o(46368);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(46370);
        String str;
        Intent intent;
        Intent intent2;
        if ("wallet_modify_password".equals(preference.mKey)) {
            cOG();
            e.QS(24);
            AppMethodBeat.o(46370);
            return true;
        } else if ("wallet_forget_password".equals(preference.mKey)) {
            g.RQ();
            str = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_DEDUCT_FORGET_URL_STRING, (Object) "");
            bi biVar;
            if (bo.isNullOrNil(str)) {
                str = r.cPI().cQu();
                if (bo.isNullOrNil(str)) {
                    cOH();
                    biVar = new bi();
                    biVar.dck = 2;
                    biVar.dcl = 1;
                    biVar.ajK();
                    e.QS(25);
                    AppMethodBeat.o(46370);
                    return true;
                }
                ab.i("MicroMsg.WalletPasswordSettingUI", "jump to forget url: %s", str);
                e.n(this, str, false);
                AppMethodBeat.o(46370);
                return true;
            }
            ab.i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", str);
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            biVar = new bi();
            biVar.dck = 2;
            biVar.dcl = 2;
            biVar.ajK();
            AppMethodBeat.o(46370);
            return true;
        } else if ("wallet_realname_verify".equals(preference.mKey)) {
            if (!r.cPI().cQg()) {
                ab.i("MicroMsg.WalletPasswordSettingUI", "go to RealNameVerifyProcess");
                Bundle bundle = new Bundle();
                bundle.putInt("real_name_verify_mode", 0);
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                bundle.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
                com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle, new com.tencent.mm.wallet_core.c.a() {
                    public final Intent n(int i, Bundle bundle) {
                        AppMethodBeat.i(46356);
                        ab.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
                        uq uqVar = new uq();
                        if (i == -1) {
                            uqVar.cQP.scene = 17;
                        } else if (i == 0) {
                            uqVar.cQP.scene = 18;
                        } else {
                            uqVar.cQP.scene = 0;
                        }
                        uqVar.cQQ.cQH = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(46355);
                                WalletPasswordSettingUI.this.cOI();
                                AppMethodBeat.o(46355);
                            }
                        };
                        com.tencent.mm.sdk.b.a.xxA.m(uqVar);
                        AppMethodBeat.o(46356);
                        return null;
                    }
                });
            } else if (bo.isNullOrNil(this.tsm)) {
                ab.e("MicroMsg.WalletPasswordSettingUI", "mRealnameUrl is null");
            } else {
                ab.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
                intent2 = new Intent();
                intent2.putExtra("rawUrl", this.tsm);
                intent2.putExtra("showShare", false);
                d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
            }
            AppMethodBeat.o(46370);
            return true;
        } else if ("wallet_biometric_pay".equals(preference.mKey)) {
            startActivity(new Intent(this, WalletBiometricPaySettingsUI.class));
            AppMethodBeat.o(46370);
            return true;
        } else {
            if ("wallet_open_auto_pay".equals(preference.mKey)) {
                if (bo.isNullOrNil(this.tsl)) {
                    ab.e("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is null");
                } else {
                    ab.i("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is not null,jump!");
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", this.tsl);
                    intent2.putExtra("showShare", false);
                    d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
                    this.tsj.NM(8);
                    AppMethodBeat.o(46370);
                    return true;
                }
            }
            if ("wallet_digitalcert".equals(preference.mKey)) {
                if (!this.tsr) {
                    m jVar = new j();
                    g.RQ();
                    g.RO().eJo.a(jVar, 0);
                }
                d.b((Context) this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
                AppMethodBeat.o(46370);
                return true;
            } else if ("wallet_delay_transfer_date".equals(preference.mKey)) {
                startActivity(new Intent(this, WalletDelayTransferSettingUI.class));
                AppMethodBeat.o(46370);
                return true;
            } else {
                if ("wallet_password_setting_un_reg".equals(preference.mKey)) {
                    g.RQ();
                    str = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, (Object) "");
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                }
                if ("wallet_switch_currency".equals(preference.mKey)) {
                    a(this.tsp);
                    AppMethodBeat.o(46370);
                    return true;
                } else if ("wallet_im_mch".equals(preference.mKey)) {
                    a(this.tsq);
                    AppMethodBeat.o(46370);
                    return true;
                } else if ("wallet_universal_pay_order".equals(preference.mKey)) {
                    startActivity(new Intent(this.mController.ylL, WalletUniversalPayOrderUI.class));
                    AppMethodBeat.o(46370);
                    return true;
                } else if ("wallet_function_settings".equals(preference.mKey)) {
                    d.H(this.mController.ylL, "mall", ".ui.MallFunctionSettingsUI");
                    AppMethodBeat.o(46370);
                    return true;
                } else {
                    AppMethodBeat.o(46370);
                    return false;
                }
            }
        }
    }

    private void a(ad adVar) {
        AppMethodBeat.i(46371);
        switch (adVar.field_jump_type) {
            case 1:
                ab.i("MicroMsg.WalletPasswordSettingUI", "jump type h5, url: %s", adVar.field_pref_url);
                if (!bo.isNullOrNil(adVar.field_pref_url)) {
                    e.n(this, adVar.field_pref_url, false);
                    AppMethodBeat.o(46371);
                    return;
                }
                break;
            case 2:
                if (!bo.isNullOrNil(adVar.field_tinyapp_username)) {
                    se seVar = new se();
                    seVar.cOf.userName = adVar.field_tinyapp_username;
                    seVar.cOf.cOh = bo.bc(adVar.field_tinyapp_path, "");
                    seVar.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_FEIHONG;
                    seVar.cOf.cOi = 0;
                    com.tencent.mm.sdk.b.a.xxA.m(seVar);
                    AppMethodBeat.o(46371);
                    return;
                }
                break;
            case 3:
                ab.i("MicroMsg.WalletPasswordSettingUI", "jump type payment management");
                d.H(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                AppMethodBeat.o(46371);
                return;
            case 4:
                ab.i("MicroMsg.WalletPasswordSettingUI", "jump type payment security");
                Intent intent = new Intent();
                intent.putExtra("wallet_lock_jsapi_scene", 1);
                d.b((Context) this, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent);
                bj bjVar = new bj();
                AppMethodBeat.o(46371);
                return;
            case 5:
                ab.i("MicroMsg.WalletPasswordSettingUI", "jump type wallet switch");
                d.c((Context) this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
                AppMethodBeat.o(46371);
                return;
            case 8:
                ab.i("MicroMsg.WalletPasswordSettingUI", "jump type honey pay");
                d.H(this, "honey_pay", ".ui.HoneyPayMainUI");
                break;
        }
        AppMethodBeat.o(46371);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(46372);
        if (i == 65281 && i2 == -1) {
            if (com.tencent.mm.model.r.YN()) {
                finish();
            } else {
                finish();
                on onVar = new on();
                onVar.cKQ.context = this.mController.ylL;
                com.tencent.mm.sdk.b.a.xxA.m(onVar);
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(46372);
    }

    /* Access modifiers changed, original: protected */
    public void cOI() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(46373);
        if (r.cPI().cQi() || r.cPI().cQh()) {
            this.ehK.ce("wallet_modify_password", true);
            this.ehK.ce("wallet_forget_password", true);
            this.ehK.ce("wallet_realname_verify", false);
            this.ehK.aqO("wallet_realname_verify").setSummary((int) R.string.fnc);
            this.ehK.ce("wallet_universal_pay_order", true);
            this.ehK.ce("wallet_switch_currency", true);
            this.ehK.ce("wallet_switch_category", true);
            this.ehK.ce("wallet_biometric_pay", true);
        } else if (r.cPI().cQg()) {
            this.ehK.ce("wallet_modify_password", false);
            this.ehK.ce("wallet_forget_password", false);
            this.ehK.ce("wallet_realname_verify", false);
            this.ehK.aqO("wallet_realname_verify").setSummary((int) R.string.fni);
            this.ehK.ce("wallet_universal_pay_order", true);
            if (r.cPI().cQi() || r.cPI().cQh()) {
                this.ehK.ce("wallet_biometric_pay", true);
            } else {
                l lVar = (l) g.K(l.class);
                if (com.tencent.mm.plugin.wallet.b.a.cOQ() && com.tencent.mm.plugin.wallet.b.a.cOR()) {
                    this.tsh.setTitle((int) R.string.fn3);
                    this.tsh.setSummary((int) R.string.fn2);
                    if (lVar.bxh()) {
                        this.tsh.L(getString(R.string.fa3));
                    } else if (lVar.bxe()) {
                        this.tsh.L(getString(R.string.fa4));
                    } else {
                        this.tsh.L(getString(R.string.eu7));
                    }
                } else if (com.tencent.mm.plugin.wallet.b.a.cOQ()) {
                    this.tsh.setTitle((int) R.string.fn1);
                    this.tsh.setSummary((int) R.string.fn0);
                    if (lVar.bxe()) {
                        this.tsh.L(getString(R.string.etw));
                    } else {
                        this.tsh.L(getString(R.string.eu7));
                    }
                } else if (com.tencent.mm.plugin.wallet.b.a.cOR()) {
                    this.tsh.setTitle((int) R.string.fmz);
                    this.tsh.setSummary((int) R.string.fmy);
                    if (lVar.bxh()) {
                        this.tsh.L(getString(R.string.etw));
                    } else {
                        this.tsh.L(getString(R.string.eu7));
                    }
                } else {
                    this.ehK.ce("wallet_biometric_pay", true);
                }
            }
        } else {
            ab.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
        }
        this.ehK.ce("wallet_universal_pay_order", true);
        this.ehK.ce("wallet_digitalcert", true);
        this.tsp = r.cPH().acO("wallet_switch_currency");
        if (this.tsp == null || this.tsp.field_is_show != 1) {
            this.ehK.ce("wallet_switch_currency", true);
            z = true;
        } else {
            this.ehK.ce("wallet_switch_currency", false);
            Preference aqO = this.ehK.aqO("wallet_switch_currency");
            aqO.setTitle(this.tsp.field_pref_title);
            aqO.setSummary(this.tsp.field_pref_desc);
            z = false;
        }
        this.tsq = r.cPH().acO("wallet_im_mch");
        if (this.tsq == null || this.tsq.field_is_show != 1) {
            this.ehK.ce("wallet_im_mch", true);
            z2 = true;
        } else {
            this.ehK.ce("wallet_im_mch", false);
            Preference aqO2 = this.ehK.aqO("wallet_im_mch");
            aqO2.setTitle(this.tsq.field_pref_title);
            aqO2.setSummary(this.tsq.field_pref_desc);
            z2 = false;
        }
        ab.i("MicroMsg.WalletPasswordSettingUI", "hideSwitch: %s, hideImMch: %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z && z2) {
            this.ehK.ce("wallet_switch_category", true);
        } else {
            this.ehK.ce("wallet_switch_category", false);
        }
        g.RQ();
        long longValue = ((Long) g.RP().Ry().get(147457, Long.valueOf(0))).longValue();
        int i = R.string.fe7;
        if ((16 & longValue) != 0) {
            i = R.string.fe6;
        } else if ((longValue & 32) != 0) {
            i = R.string.fe5;
        }
        this.ehK.aqO("wallet_delay_transfer_date").setSummary(i);
        if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_wcpay_android_wallet_management_entry, 0) == 0) {
            this.ehK.ce("wallet_function_settings", true);
        } else {
            this.ehK.ce("wallet_function_settings", false);
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(46373);
    }

    private void nc(boolean z) {
        AppMethodBeat.i(46374);
        m jVar = new j();
        g.RQ();
        g.RO().eJo.a(jVar, 0);
        this.tsr = true;
        if (z) {
            this.gII = com.tencent.mm.wallet_core.ui.g.a((Context) this, false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(46351);
                    if (WalletPasswordSettingUI.this.gII != null) {
                        WalletPasswordSettingUI.this.gII.dismiss();
                    }
                    AppMethodBeat.o(46351);
                }
            });
        }
        AppMethodBeat.o(46374);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46375);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof j) {
                cOI();
                j jVar = (j) mVar;
                ab.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + jVar.tqB);
                this.tsm = jVar.tqF;
                if (jVar.tqB == 1) {
                    this.tsl = jVar.tqC;
                    gK(bo.bc(jVar.tqE, getString(R.string.foe)), jVar.tqC);
                } else {
                    this.ehK.ce("wallet_open_auto_pay", true);
                }
                cOE();
                if (this.gII != null) {
                    this.gII.dismiss();
                }
                AppMethodBeat.o(46375);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.ae) {
                this.tsn = ((com.tencent.mm.plugin.wallet_core.c.ae) mVar).tuB;
                this.tss = ((com.tencent.mm.plugin.wallet_core.c.ae) mVar).tuG;
                if (this.tss == 0) {
                    this.ehK.ce("wallet_delay_transfer_date", true);
                    AppMethodBeat.o(46375);
                    return;
                }
                if (bo.isNullOrNil(this.tsn)) {
                    ab.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
                } else {
                    this.tsk.setTitle(this.tsn);
                }
                this.ehK.ce("wallet_delay_transfer_date", false);
                AppMethodBeat.o(46375);
                return;
            }
        } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.ae) {
            ab.i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
        }
        AppMethodBeat.o(46375);
    }

    public void onDestroy() {
        AppMethodBeat.i(46376);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.tmk);
        g.RQ();
        g.RO().eJo.b(385, (f) this);
        AppMethodBeat.o(46376);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46362);
        this.yll = true;
        super.onCreate(bundle);
        xE(this.mController.dyj());
        g.RQ();
        g.RO().eJo.a(385, (f) this);
        com.tencent.mm.sdk.b.a.xxA.c(this.tmk);
        this.eFu = getIntent().getBooleanExtra("key_is_from_system", false);
        this.tsi = getIntent().getBooleanExtra("key_default_show_currency", false);
        if (this.eFu) {
            ab.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
            ((com.tencent.mm.plugin.walletlock.a.b) g.K(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        }
        initView();
        if (j.bxX()) {
            nc(false);
        } else {
            g.RQ();
            this.tsm = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_REALNAME_URL_STRING_SYNC, (Object) "");
            this.tso = r.cPH().acO("wallet_open_auto_pay");
            if (this.tso != null && this.tso.field_is_show == 1 && !bo.isNullOrNil(this.tso.field_pref_url)) {
                ab.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
                this.tsl = this.tso.field_pref_url;
                gK(this.tso.field_pref_title, this.tso.field_pref_url);
            } else if (this.tso == null) {
                ab.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
            } else {
                ab.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.tso.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bo.isNullOrNil(this.tso.field_pref_url));
            }
        }
        g.RQ();
        this.tss = ((Integer) g.RP().Ry().get(ac.a.USERINFO_DELAY_TRANSFER_SHOW_SWITCH_FLAG_INT, Integer.valueOf(0))).intValue();
        g.RQ();
        this.tsn = (String) g.RP().Ry().get(ac.a.USERINFO_DELAY_TRANSFER_SWITCH_WORDING_STRING, (Object) "");
        if (bo.isNullOrNil(this.tsn)) {
            com.tencent.mm.plugin.wallet_core.c.ae.a(true, null);
        } else {
            this.tsk.setTitle(this.tsn);
            com.tencent.mm.plugin.wallet_core.c.ae.a(false, null);
        }
        if (this.tss == 0) {
            this.ehK.ce("wallet_delay_transfer_date", true);
        }
        AppMethodBeat.o(46362);
    }

    private void nb(boolean z) {
        AppMethodBeat.i(46369);
        this.ehZ.edit().putBoolean("wallet_fingerprint_switch", z).commit();
        this.tsg.uOT = z;
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(46369);
    }

    static /* synthetic */ void b(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(46378);
        walletPasswordSettingUI.nb(false);
        final l lVar = (l) g.K(l.class);
        com.tencent.mm.ui.base.h.a((Context) walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(R.string.fnm), "", walletPasswordSettingUI.getResources().getString(lVar.bxr() ? R.string.fnl : R.string.s6), walletPasswordSettingUI.getString(R.string.or), true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(46360);
                ab.i("MicroMsg.WalletPasswordSettingUI", "user click the button to set system fingerprint");
                lVar.dO(WalletPasswordSettingUI.this);
                AppMethodBeat.o(46360);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(46378);
    }

    static /* synthetic */ void c(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(46379);
        walletPasswordSettingUI.nb(false);
        g.K(l.class);
        com.tencent.mm.ui.base.h.a((Context) walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(R.string.fnk), "", walletPasswordSettingUI.getString(R.string.fnj), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(46379);
    }

    static /* synthetic */ void f(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(46382);
        l lVar = (l) g.K(l.class);
        if (walletPasswordSettingUI.tsg.isChecked() != lVar.bxe()) {
            walletPasswordSettingUI.nb(lVar.bxe());
            AppMethodBeat.o(46382);
            return;
        }
        AppMethodBeat.o(46382);
    }

    static /* synthetic */ void g(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(46383);
        com.tencent.mm.ui.base.h.b((Context) walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(R.string.bv7), "", true);
        AppMethodBeat.o(46383);
    }
}
