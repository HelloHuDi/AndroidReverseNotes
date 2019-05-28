package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26096bt;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C40675h;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.wallet.p1658b.C46333a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.WalletPreferenceUI;

@C5271a(0)
/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI */
public class WalletBiometricPaySettingsUI extends WalletPreferenceUI {
    private C30052l mrm;
    private Preference tqU;
    private Preference tqV;
    private Preference tqW;
    private Preference tqX;
    private int tqY = 0;
    private boolean tqZ;
    private boolean tra;
    private boolean trb;
    private boolean trc;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI$1 */
    class C296051 implements OnMenuItemClickListener {
        C296051() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(46220);
            WalletBiometricPaySettingsUI.this.finish();
            AppMethodBeat.m2505o(46220);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI$4 */
    class C400824 implements OnClickListener {
        C400824() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI$3 */
    class C400833 implements OnClickListener {
        C400833() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: d */
    static /* synthetic */ void m68688d(WalletBiometricPaySettingsUI walletBiometricPaySettingsUI) {
        AppMethodBeat.m2504i(46238);
        walletBiometricPaySettingsUI.cOp();
        AppMethodBeat.m2505o(46238);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46223);
        super.onCreate(bundle);
        if (C46333a.cOR() && C46333a.cOQ()) {
            this.tqY = 1;
        } else if (C46333a.cOQ()) {
            this.tqY = 2;
        } else if (C46333a.cOR()) {
            this.tqY = 3;
        } else {
            C4990ab.m7420w("MicroMsg.WalletBiometricPaySettingsUI", "device not support biometric pay!");
            finish();
        }
        if (this.tqY == 1) {
            setMMTitle((int) C25738R.string.f_z);
        } else if (this.tqY == 2) {
            setMMTitle((int) C25738R.string.fn8);
        } else {
            setMMTitle((int) C25738R.string.fn6);
        }
        setBackBtn(new C296051());
        this.mrm = (C30052l) C1720g.m3528K(C30052l.class);
        C4990ab.m7417i("MicroMsg.WalletBiometricPaySettingsUI", "biometric mode: %s", Integer.valueOf(this.tqY));
        initView();
        AppMethodBeat.m2505o(46223);
    }

    public void onResume() {
        AppMethodBeat.m2504i(46225);
        super.onResume();
        C4990ab.m7417i("MicroMsg.WalletBiometricPaySettingsUI", "update pref check state: %s, %s", Boolean.valueOf(this.mrm.bxe()), Boolean.valueOf(this.mrm.bxh()));
        if (this.tqY == 1) {
            if (this.mrm.bxe()) {
                cOr();
            } else if (this.mrm.bxh()) {
                cOs();
            } else {
                cOp();
            }
        } else if (this.mrm.bxe() || this.mrm.bxh()) {
            cOq();
        } else {
            cOp();
        }
        this.yCw.notifyDataSetChanged();
        AppMethodBeat.m2505o(46225);
    }

    /* renamed from: f */
    public final boolean mo24791f(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8576cp;
    }

    /* renamed from: a */
    public final boolean mo8453a(final C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(46226);
        C4990ab.m7417i("MicroMsg.WalletBiometricPaySettingsUI", "click key: %s", preference.mKey);
        this.trc = WalletBiometricPaySettingsUI.m68685a(this.tqU);
        if (this.tqY == 1) {
            this.tra = WalletBiometricPaySettingsUI.m68685a(this.tqX);
            this.trb = WalletBiometricPaySettingsUI.m68685a(this.tqW);
        } else {
            this.tqZ = WalletBiometricPaySettingsUI.m68685a(this.tqV);
        }
        C4990ab.m7417i("MicroMsg.WalletBiometricPaySettingsUI", "is checked: %s", Boolean.valueOf(WalletBiometricPaySettingsUI.m68685a(preference)));
        if (WalletBiometricPaySettingsUI.m68685a(preference)) {
            AppMethodBeat.m2505o(46226);
        } else {
            if ("biometric_pay_close".equals(preference.mKey)) {
                String string = getString(C25738R.string.bv5);
                if (this.mrm.bxh()) {
                    string = getString(C25738R.string.bmo);
                }
                C30379h.m48453a((Context) this, false, string, "", getString(C25738R.string.f9187s6), getString(C25738R.string.f9076or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(46222);
                        final Dialog b = C30901g.m49318b(WalletBiometricPaySettingsUI.this.mController.ylL, false, null);
                        final C4883b c26096bt = new C26096bt();
                        c26096bt.cuS.cuU = WalletBiometricPaySettingsUI.this.mrm.bxe() ? 1 : 2;
                        c26096bt.callback = new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(46221);
                                if (c26096bt.cuT != null) {
                                    if (b != null) {
                                        b.dismiss();
                                    }
                                    C4990ab.m7417i("MicroMsg.WalletBiometricPaySettingsUI", "close event result: %s", Integer.valueOf(c26096bt.cuT.retCode));
                                    if (c26096bt.cuT.retCode == 0) {
                                        C1720g.m3535RO().eJo.mo14541a(new C35475y(null, 19), 0);
                                        AppMethodBeat.m2505o(46221);
                                        return;
                                    }
                                    WalletBiometricPaySettingsUI.m68686b(WalletBiometricPaySettingsUI.this);
                                    WalletBiometricPaySettingsUI.m68687c(WalletBiometricPaySettingsUI.this);
                                }
                                AppMethodBeat.m2505o(46221);
                            }
                        };
                        C4879a.xxA.mo10048a(c26096bt, WalletBiometricPaySettingsUI.this.getMainLooper());
                        WalletBiometricPaySettingsUI.m68688d(WalletBiometricPaySettingsUI.this);
                        c15541f.notifyDataSetChanged();
                        AppMethodBeat.m2505o(46222);
                    }
                }, new C400833());
            } else if ("key_single_open".equals(preference.mKey)) {
                if (this.tqY == 2) {
                    cOt();
                } else if (this.tqY == 3) {
                    cOu();
                }
            } else if ("key_fingerprint_open".equals(preference.mKey)) {
                cOt();
            } else if ("key_faceid_open".equals(preference.mKey)) {
                cOu();
            }
            c15541f.notifyDataSetChanged();
            AppMethodBeat.m2505o(46226);
        }
        return false;
    }

    /* renamed from: a */
    private static void m68684a(Preference preference, boolean z) {
        AppMethodBeat.m2504i(46227);
        preference.setWidgetLayoutResource(z ? 2130970197 : 2130970198);
        AppMethodBeat.m2505o(46227);
    }

    private void cOp() {
        AppMethodBeat.m2504i(46228);
        if (this.tqY == 1) {
            WalletBiometricPaySettingsUI.m68684a(this.tqW, false);
            WalletBiometricPaySettingsUI.m68684a(this.tqX, false);
        } else {
            WalletBiometricPaySettingsUI.m68684a(this.tqV, false);
        }
        WalletBiometricPaySettingsUI.m68684a(this.tqU, true);
        AppMethodBeat.m2505o(46228);
    }

    private void cOq() {
        AppMethodBeat.m2504i(46229);
        if (this.tqY == 2 || this.tqY == 3) {
            WalletBiometricPaySettingsUI.m68684a(this.tqV, true);
            WalletBiometricPaySettingsUI.m68684a(this.tqU, false);
        }
        AppMethodBeat.m2505o(46229);
    }

    private void cOr() {
        AppMethodBeat.m2504i(46230);
        if (this.tqY == 1) {
            WalletBiometricPaySettingsUI.m68684a(this.tqW, true);
            WalletBiometricPaySettingsUI.m68684a(this.tqX, false);
            WalletBiometricPaySettingsUI.m68684a(this.tqU, false);
        }
        AppMethodBeat.m2505o(46230);
    }

    private void cOs() {
        AppMethodBeat.m2504i(46231);
        if (this.tqY == 1) {
            WalletBiometricPaySettingsUI.m68684a(this.tqW, false);
            WalletBiometricPaySettingsUI.m68684a(this.tqX, true);
            WalletBiometricPaySettingsUI.m68684a(this.tqU, false);
        }
        AppMethodBeat.m2505o(46231);
    }

    /* renamed from: Hh */
    private void m68681Hh(int i) {
        AppMethodBeat.m2504i(46232);
        C4990ab.m7417i("MicroMsg.WalletBiometricPaySettingsUI", "start open process: %s", Integer.valueOf(i));
        Bundle bundle = new Bundle();
        bundle.putInt("open_scene", 1);
        bundle.putInt("key_open_biometric_type", i);
        C24143a.m37114b((Activity) this, "FingerprintAuth", bundle);
        AppMethodBeat.m2505o(46232);
    }

    /* renamed from: Hi */
    private void m68682Hi(int i) {
        AppMethodBeat.m2504i(46233);
        C4990ab.m7417i("MicroMsg.WalletBiometricPaySettingsUI", "show enroll biometric guide: %s", Integer.valueOf(i));
        String string = getString(C25738R.string.fnk);
        if (i == 1) {
            string = getString(C25738R.string.fnm);
        }
        C30379h.m48443a((Context) this, string, "", getString(C25738R.string.fnj), new C400824());
        AppMethodBeat.m2505o(46233);
    }

    private void cOt() {
        AppMethodBeat.m2504i(46234);
        C4990ab.m7416i("MicroMsg.WalletBiometricPaySettingsUI", "on click open fingerprint");
        if (this.mrm.bxo()) {
            m68681Hh(1);
            if (this.tqY == 1) {
                cOr();
                AppMethodBeat.m2505o(46234);
                return;
            }
            cOq();
            AppMethodBeat.m2505o(46234);
            return;
        }
        m68682Hi(1);
        AppMethodBeat.m2505o(46234);
    }

    private void cOu() {
        AppMethodBeat.m2504i(46235);
        C4990ab.m7416i("MicroMsg.WalletBiometricPaySettingsUI", "on click open faceid");
        if (this.mrm.bxB()) {
            m68681Hh(2);
            if (this.tqY == 1) {
                cOs();
                AppMethodBeat.m2505o(46235);
                return;
            }
            cOq();
            AppMethodBeat.m2505o(46235);
            return;
        }
        m68682Hi(2);
        AppMethodBeat.m2505o(46235);
    }

    public final void initView() {
        AppMethodBeat.m2504i(46224);
        C40675h c40675h = this.yCw;
        this.tqU = c40675h.aqO("biometric_pay_close");
        this.tqU.mo39406NW(8);
        C4990ab.m7417i("MicroMsg.WalletBiometricPaySettingsUI", "fingerprint: %s, faceid: %s", Boolean.valueOf(this.mrm.bxe()), Boolean.valueOf(this.mrm.bxh()));
        if (this.tqY == 2 || this.tqY == 3) {
            this.tqV = new Preference(this);
            this.tqV.setKey("key_single_open");
            this.tqV.setTitle((int) C25738R.string.fa0);
            this.tqV.yDf = false;
            c40675h.mo27708a(this.tqV, 0);
            this.tqV.mo39406NW(8);
            AppMethodBeat.m2505o(46224);
            return;
        }
        if (this.tqY == 1) {
            this.tqX = new Preference(this);
            this.tqX.setKey("key_faceid_open");
            this.tqX.setTitle((int) C25738R.string.fa1);
            c40675h.mo27708a(this.tqX, 0);
            this.tqW = new Preference(this);
            this.tqW.setKey("key_fingerprint_open");
            this.tqW.setTitle((int) C25738R.string.fa2);
            c40675h.mo27708a(this.tqW, 1);
            this.tqX.mo39406NW(8);
            this.tqW.mo39406NW(8);
        }
        AppMethodBeat.m2505o(46224);
    }

    /* renamed from: a */
    private static boolean m68685a(Preference preference) {
        return preference.yDl == 2130970197;
    }

    /* renamed from: b */
    static /* synthetic */ void m68686b(WalletBiometricPaySettingsUI walletBiometricPaySettingsUI) {
        AppMethodBeat.m2504i(46236);
        WalletBiometricPaySettingsUI.m68684a(walletBiometricPaySettingsUI.tqU, walletBiometricPaySettingsUI.trc);
        if (walletBiometricPaySettingsUI.tqY == 1) {
            WalletBiometricPaySettingsUI.m68684a(walletBiometricPaySettingsUI.tqX, walletBiometricPaySettingsUI.tra);
            WalletBiometricPaySettingsUI.m68684a(walletBiometricPaySettingsUI.tqW, walletBiometricPaySettingsUI.trb);
        } else {
            WalletBiometricPaySettingsUI.m68684a(walletBiometricPaySettingsUI.tqV, walletBiometricPaySettingsUI.tqZ);
        }
        walletBiometricPaySettingsUI.yCw.notifyDataSetChanged();
        AppMethodBeat.m2505o(46236);
    }

    /* renamed from: c */
    static /* synthetic */ void m68687c(WalletBiometricPaySettingsUI walletBiometricPaySettingsUI) {
        AppMethodBeat.m2504i(46237);
        if (walletBiometricPaySettingsUI.mrm.bxe()) {
            C30379h.m48461b((Context) walletBiometricPaySettingsUI, walletBiometricPaySettingsUI.getResources().getString(C25738R.string.bv7), "", true);
            AppMethodBeat.m2505o(46237);
            return;
        }
        C30379h.m48461b((Context) walletBiometricPaySettingsUI, walletBiometricPaySettingsUI.getResources().getString(C25738R.string.fn4), "", true);
        AppMethodBeat.m2505o(46237);
    }
}
