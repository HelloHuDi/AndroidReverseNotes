package com.tencent.p177mm.plugin.walletlock.p1060ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p232b.p233a.C42088bj;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.soter.p528d.C4104m;
import com.tencent.p177mm.plugin.walletlock.p1319c.C40171g;
import com.tencent.p177mm.plugin.walletlock.p1319c.C46388h;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.p663a.C30954a;

/* renamed from: com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI */
public class WalletLockSettingUI extends MMPreference {
    private C15541f ehK;
    private int emC = 0;
    private int gOW = -1;
    private C5653c ggF;
    private IconPreference tXi;
    private IconPreference tXj;
    private IconPreference tXk;
    private IconPreference tXl;
    private boolean tXm = false;
    private boolean tXn = true;
    private boolean tXo = true;
    private boolean tXp = true;

    /* renamed from: com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI$4 */
    class C144034 implements OnClickListener {
        C144034() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI$5 */
    class C144045 implements Runnable {
        C144045() {
        }

        public final void run() {
            AppMethodBeat.m2504i(51747);
            try {
                C30954a.m49584Ri(3);
                AppMethodBeat.m2505o(51747);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WalletLockSettingUI", "Remove AK after close wallet lock failed! " + e.getMessage());
                AppMethodBeat.m2505o(51747);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI$2 */
    class C355522 implements OnClickListener {
        C355522() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(51745);
            WalletLockSettingUI.m87270b(WalletLockSettingUI.this);
            AppMethodBeat.m2505o(51745);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI$3 */
    class C401773 implements Runnable {
        C401773() {
        }

        public final void run() {
            AppMethodBeat.m2504i(51746);
            try {
                C30954a.m49584Ri(3);
                AppMethodBeat.m2505o(51746);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WalletLockSettingUI", "Remove AK after open gesture lock failed! " + e.getMessage());
                AppMethodBeat.m2505o(51746);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI$1 */
    class C463921 implements OnMenuItemClickListener {
        C463921() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(51744);
            if (WalletLockSettingUI.this.tXm) {
                WalletLockSettingUI.m87267a(WalletLockSettingUI.this, "user cancel setting wallet lock");
            } else {
                WalletLockSettingUI.this.finish();
            }
            AppMethodBeat.m2505o(51744);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m87270b(WalletLockSettingUI walletLockSettingUI) {
        AppMethodBeat.m2504i(51765);
        walletLockSettingUI.cUh();
        AppMethodBeat.m2505o(51765);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8578cr;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(51748);
        super.onCreate(bundle);
        setBackBtn(new C463921());
        setMMTitle((int) C25738R.string.fhn);
        this.ehK = this.yCw;
        this.ehK = this.yCw;
        this.tXi = (IconPreference) this.ehK.aqO("wallet_lock_fingerprint");
        this.tXj = (IconPreference) this.ehK.aqO("wallet_lock_gesture");
        this.tXk = (IconPreference) this.ehK.aqO("wallet_lock_close");
        this.tXl = (IconPreference) this.ehK.aqO("wallet_lock_faceid");
        this.tXi.mo39406NW(8);
        this.tXj.mo39406NW(8);
        this.tXk.mo39406NW(8);
        this.tXl.mo39406NW(8);
        this.ehK.mo27715ce("wallet_lock_faceid", true);
        this.emC = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
        this.gOW = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
        if (this.gOW == 1) {
            this.tXm = true;
            this.tXn = false;
        }
        C42088bj c42088bj = new C42088bj();
        c42088bj.cVT = 13;
        c42088bj.dcm = 1;
        c42088bj.dcn = (long) this.emC;
        c42088bj.ajK();
        C4990ab.m7417i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", Boolean.valueOf(this.tXm), Boolean.valueOf(this.tXn));
        AppMethodBeat.m2505o(51748);
    }

    public void onResume() {
        AppMethodBeat.m2504i(51749);
        super.onResume();
        cUh();
        AppMethodBeat.m2505o(51749);
    }

    public void onPause() {
        AppMethodBeat.m2504i(51750);
        super.onPause();
        if (this.ggF != null && this.ggF.isShowing()) {
            this.ggF.dismiss();
        }
        AppMethodBeat.m2505o(51750);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(51751);
        C4990ab.m7416i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
        if (this.tXm) {
            m87272w(0, 4, "user cancel setting wallet lock");
            AppMethodBeat.m2505o(51751);
            return;
        }
        finish();
        AppMethodBeat.m2505o(51751);
    }

    /* renamed from: w */
    private void m87272w(int i, int i2, String str) {
        AppMethodBeat.m2504i(51752);
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        intent.putExtra("key_err_msg", str);
        m87271j(i, intent);
        AppMethodBeat.m2505o(51752);
    }

    /* renamed from: j */
    private void m87271j(int i, Intent intent) {
        AppMethodBeat.m2504i(51753);
        setResult(i, intent);
        finish();
        AppMethodBeat.m2505o(51753);
    }

    private void cUh() {
        AppMethodBeat.m2504i(51754);
        cUl();
        C4990ab.m7417i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", Integer.valueOf(C40171g.tWY.cTV()));
        cUi();
        cUj();
        cUk();
        AppMethodBeat.m2505o(51754);
    }

    private void cUi() {
        AppMethodBeat.m2504i(51755);
        C40171g c40171g = C40171g.tWY;
        if (C40171g.cTZ()) {
            boolean eT = C4104m.m6423eT(this.mController.ylL);
            C40171g c40171g2 = C40171g.tWY;
            if (C40171g.cTn()) {
                if (!eT) {
                    this.ehK.mo27715ce("wallet_lock_fingerprint", false);
                    this.tXi.setDesc(getString(C25738R.string.fh2));
                    this.tXi.dAy();
                    m87268a(this.tXi, true, false);
                    this.tXi.setEnabled(false);
                    this.tXi.yBZ = true;
                    this.tXo = false;
                    AppMethodBeat.m2505o(51755);
                    return;
                } else if (this.tXn) {
                    this.ehK.mo27715ce("wallet_lock_fingerprint", false);
                    m87268a(this.tXi, true, true);
                    AppMethodBeat.m2505o(51755);
                    return;
                }
            } else if (eT) {
                this.ehK.mo27715ce("wallet_lock_fingerprint", false);
                m87268a(this.tXi, false, true);
            } else {
                this.ehK.mo27715ce("wallet_lock_fingerprint", true);
                AppMethodBeat.m2505o(51755);
                return;
            }
            AppMethodBeat.m2505o(51755);
            return;
        }
        C4990ab.m7420w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
        this.ehK.mo27715ce("wallet_lock_fingerprint", true);
        AppMethodBeat.m2505o(51755);
    }

    private void cUj() {
        AppMethodBeat.m2504i(51756);
        Object[] objArr = new Object[1];
        C40171g c40171g = C40171g.tWY;
        objArr[0] = Boolean.valueOf(C40171g.cTz());
        C4990ab.m7417i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", objArr);
        if (C40171g.tWY.cTV() == 2 || C40171g.tWY.cTV() == 3) {
            m87268a(this.tXj, false, true);
            this.ehK.mo27715ce("wallet_lock_modify_gesture", true);
            AppMethodBeat.m2505o(51756);
            return;
        }
        if (C40171g.tWY.cTV() != 1) {
            m87268a(this.tXj, false, true);
            this.ehK.mo27715ce("wallet_lock_modify_gesture", true);
        } else if (this.tXn) {
            m87268a(this.tXj, true, true);
            this.ehK.mo27715ce("wallet_lock_modify_gesture", false);
            AppMethodBeat.m2505o(51756);
            return;
        }
        AppMethodBeat.m2505o(51756);
    }

    private void cUk() {
        AppMethodBeat.m2504i(51757);
        if (C40171g.tWY.cTV() != 0) {
            m87268a(this.tXk, false, true);
        } else if (this.tXn) {
            m87268a(this.tXk, true, true);
            AppMethodBeat.m2505o(51757);
            return;
        }
        AppMethodBeat.m2505o(51757);
    }

    private void cUl() {
        AppMethodBeat.m2504i(51758);
        if (this.tXi != null && this.tXo) {
            m87268a(this.tXi, false, this.tXo);
        }
        if (this.tXl != null && this.tXp) {
            m87268a(this.tXl, false, this.tXp);
        }
        if (this.tXj != null) {
            m87268a(this.tXj, false, true);
        }
        if (this.tXk != null) {
            m87268a(this.tXk, false, true);
        }
        AppMethodBeat.m2505o(51758);
    }

    /* renamed from: a */
    private void m87268a(Preference preference, boolean z, boolean z2) {
        AppMethodBeat.m2504i(51759);
        if (preference instanceof IconPreference) {
            IconPreference iconPreference = (IconPreference) preference;
            iconPreference.mo48777hn(C1338a.fromDPToPix(this, 20), C1338a.fromDPToPix(this, 20));
            if (z) {
                if (z2) {
                    iconPreference.mo48766NO(C1318a.radio_on);
                } else {
                    iconPreference.mo48766NO(C1318a.radio_default_on);
                }
                iconPreference.mo48767NP(0);
                AppMethodBeat.m2505o(51759);
                return;
            }
            iconPreference.mo48766NO(C1318a.radio_off);
            iconPreference.mo48767NP(0);
        }
        AppMethodBeat.m2505o(51759);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(51760);
        if ("wallet_lock_fingerprint".equals(preference.mKey)) {
            cUl();
            m87268a(preference, true, true);
            if (this.tXo && !(this.tXn && C40171g.tWY.cTV() == 2)) {
                if (!C40997a.m71099iR(this)) {
                    cUm();
                } else if (!(this.tXn && C40171g.tWY.cTV() == 2)) {
                    C4990ab.m7416i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
                    ((C40167b) C1720g.m3528K(C40167b.class)).mo38289b((Activity) this, 2, 1);
                }
            }
            AppMethodBeat.m2505o(51760);
            return true;
        } else if ("wallet_lock_faceid".equals(preference.mKey)) {
            cUl();
            m87268a(preference, true, true);
            if (this.tXp && !(this.tXn && C40171g.tWY.cTV() == 3)) {
                if (!C40997a.m71100iS(this)) {
                    cUm();
                } else if (!this.tXn || C40171g.tWY.cTV() == 3) {
                    C4990ab.m7416i("MicroMsg.WalletLockSettingUI", "request open faceid lock");
                    ((C40167b) C1720g.m3528K(C40167b.class)).mo38289b((Activity) this, 3, 4);
                }
            }
            AppMethodBeat.m2505o(51760);
            return true;
        } else if ("wallet_lock_gesture".equals(preference.mKey)) {
            cUl();
            m87268a(preference, true, true);
            if (C40171g.tWY.cTV() != 1) {
                C4990ab.m7416i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
                ((C40167b) C1720g.m3528K(C40167b.class)).mo38289b((Activity) this, 1, 2);
            }
            AppMethodBeat.m2505o(51760);
            return true;
        } else if ("wallet_lock_close".equals(preference.mKey)) {
            cUl();
            m87268a(preference, true, true);
            if (C40171g.tWY.cTV() != 0) {
                C4990ab.m7416i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
                ((C40167b) C1720g.m3528K(C40167b.class)).mo38296i(this, 3);
                C42088bj c42088bj = new C42088bj();
                c42088bj.cVT = 14;
                c42088bj.dcm = 1;
                c42088bj.ajK();
            }
            AppMethodBeat.m2505o(51760);
            return true;
        } else if ("wallet_lock_modify_gesture".equals(preference.mKey)) {
            ((C40167b) C1720g.m3528K(C40167b.class)).mo38288ad(this);
            AppMethodBeat.m2505o(51760);
            return true;
        } else {
            AppMethodBeat.m2505o(51760);
            return false;
        }
    }

    private void cUm() {
        AppMethodBeat.m2504i(51761);
        this.ggF = C30379h.m48438a((Context) this, getString(C25738R.string.fhj), "", new C355522());
        this.ggF.setCanceledOnTouchOutside(false);
        AppMethodBeat.m2505o(51761);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(51762);
        C4990ab.m7417i("MicroMsg.WalletLockSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.WalletLockSettingUI", "alvinluo data is null");
            AppMethodBeat.m2505o(51762);
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", -1);
        C4990ab.m7417i("MicroMsg.WalletLockSettingUI", "alvinluo wallet lock setting onActivityResult errCode: %d", Integer.valueOf(intExtra));
        if (i == 1) {
            C4990ab.m7416i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock onActivityResult");
            if (intExtra == 0) {
                if (this.tXm) {
                    m87271j(i2, intent);
                    AppMethodBeat.m2505o(51762);
                    return;
                }
            } else if (intExtra != 4) {
                C4990ab.m7416i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
                m87266JN(getString(C25738R.string.fh5));
                AppMethodBeat.m2505o(51762);
                return;
            }
        } else if (i == 2) {
            C4990ab.m7416i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
            if (intExtra == 0) {
                if (this.tXm) {
                    m87271j(i2, intent);
                }
                C7305d.post(new C401773(), "WalletLockRemoveAuthKey");
                AppMethodBeat.m2505o(51762);
                return;
            } else if (intExtra != 4) {
                C4990ab.m7416i("MicroMsg.WalletLockSettingUI", "alvinluo open gesture lock failed");
                m87266JN(getString(C25738R.string.fhg));
                AppMethodBeat.m2505o(51762);
                return;
            }
        } else if (i == 3) {
            if (intExtra == 0) {
                ((C40167b) C1720g.m3528K(C40167b.class)).mo38285HB(0);
                C40171g c40171g = C40171g.tWY;
                C40171g.cTq();
                cUh();
                Toast.makeText(this, getString(C25738R.string.fgz), 0).show();
                C46388h.cUb();
                if (this.tXm) {
                    m87272w(-1, 0, "close wallet lock ok");
                }
                C7305d.post(new C144045(), "WalletLockRemoveAuthKey");
                C42088bj c42088bj = new C42088bj();
                c42088bj.cVT = 14;
                c42088bj.dcm = 2;
                c42088bj.ajK();
                AppMethodBeat.m2505o(51762);
                return;
            } else if (intExtra != 4) {
                m87266JN(getString(C25738R.string.fh0));
            }
        }
        AppMethodBeat.m2505o(51762);
    }

    /* renamed from: JN */
    private void m87266JN(String str) {
        AppMethodBeat.m2504i(51763);
        this.ggF = C30379h.m48438a((Context) this, str, "", new C144034());
        this.ggF.setCanceledOnTouchOutside(false);
        this.ggF.show();
        AppMethodBeat.m2505o(51763);
    }
}
