package com.tencent.mm.plugin.walletlock.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.c;

public class WalletLockSettingUI extends MMPreference {
    private f ehK;
    private int emC = 0;
    private int gOW = -1;
    private c ggF;
    private IconPreference tXi;
    private IconPreference tXj;
    private IconPreference tXk;
    private IconPreference tXl;
    private boolean tXm = false;
    private boolean tXn = true;
    private boolean tXo = true;
    private boolean tXp = true;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(WalletLockSettingUI walletLockSettingUI) {
        AppMethodBeat.i(51765);
        walletLockSettingUI.cUh();
        AppMethodBeat.o(51765);
    }

    public final int JC() {
        return R.xml.cr;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(51748);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(51744);
                if (WalletLockSettingUI.this.tXm) {
                    WalletLockSettingUI.a(WalletLockSettingUI.this, "user cancel setting wallet lock");
                } else {
                    WalletLockSettingUI.this.finish();
                }
                AppMethodBeat.o(51744);
                return false;
            }
        });
        setMMTitle((int) R.string.fhn);
        this.ehK = this.yCw;
        this.ehK = this.yCw;
        this.tXi = (IconPreference) this.ehK.aqO("wallet_lock_fingerprint");
        this.tXj = (IconPreference) this.ehK.aqO("wallet_lock_gesture");
        this.tXk = (IconPreference) this.ehK.aqO("wallet_lock_close");
        this.tXl = (IconPreference) this.ehK.aqO("wallet_lock_faceid");
        this.tXi.NW(8);
        this.tXj.NW(8);
        this.tXk.NW(8);
        this.tXl.NW(8);
        this.ehK.ce("wallet_lock_faceid", true);
        this.emC = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
        this.gOW = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
        if (this.gOW == 1) {
            this.tXm = true;
            this.tXn = false;
        }
        bj bjVar = new bj();
        bjVar.cVT = 13;
        bjVar.dcm = 1;
        bjVar.dcn = (long) this.emC;
        bjVar.ajK();
        ab.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", Boolean.valueOf(this.tXm), Boolean.valueOf(this.tXn));
        AppMethodBeat.o(51748);
    }

    public void onResume() {
        AppMethodBeat.i(51749);
        super.onResume();
        cUh();
        AppMethodBeat.o(51749);
    }

    public void onPause() {
        AppMethodBeat.i(51750);
        super.onPause();
        if (this.ggF != null && this.ggF.isShowing()) {
            this.ggF.dismiss();
        }
        AppMethodBeat.o(51750);
    }

    public void onBackPressed() {
        AppMethodBeat.i(51751);
        ab.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
        if (this.tXm) {
            w(0, 4, "user cancel setting wallet lock");
            AppMethodBeat.o(51751);
            return;
        }
        finish();
        AppMethodBeat.o(51751);
    }

    private void w(int i, int i2, String str) {
        AppMethodBeat.i(51752);
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        intent.putExtra("key_err_msg", str);
        j(i, intent);
        AppMethodBeat.o(51752);
    }

    private void j(int i, Intent intent) {
        AppMethodBeat.i(51753);
        setResult(i, intent);
        finish();
        AppMethodBeat.o(51753);
    }

    private void cUh() {
        AppMethodBeat.i(51754);
        cUl();
        ab.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", Integer.valueOf(g.tWY.cTV()));
        cUi();
        cUj();
        cUk();
        AppMethodBeat.o(51754);
    }

    private void cUi() {
        AppMethodBeat.i(51755);
        g gVar = g.tWY;
        if (g.cTZ()) {
            boolean eT = m.eT(this.mController.ylL);
            g gVar2 = g.tWY;
            if (g.cTn()) {
                if (!eT) {
                    this.ehK.ce("wallet_lock_fingerprint", false);
                    this.tXi.setDesc(getString(R.string.fh2));
                    this.tXi.dAy();
                    a(this.tXi, true, false);
                    this.tXi.setEnabled(false);
                    this.tXi.yBZ = true;
                    this.tXo = false;
                    AppMethodBeat.o(51755);
                    return;
                } else if (this.tXn) {
                    this.ehK.ce("wallet_lock_fingerprint", false);
                    a(this.tXi, true, true);
                    AppMethodBeat.o(51755);
                    return;
                }
            } else if (eT) {
                this.ehK.ce("wallet_lock_fingerprint", false);
                a(this.tXi, false, true);
            } else {
                this.ehK.ce("wallet_lock_fingerprint", true);
                AppMethodBeat.o(51755);
                return;
            }
            AppMethodBeat.o(51755);
            return;
        }
        ab.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
        this.ehK.ce("wallet_lock_fingerprint", true);
        AppMethodBeat.o(51755);
    }

    private void cUj() {
        AppMethodBeat.i(51756);
        Object[] objArr = new Object[1];
        g gVar = g.tWY;
        objArr[0] = Boolean.valueOf(g.cTz());
        ab.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", objArr);
        if (g.tWY.cTV() == 2 || g.tWY.cTV() == 3) {
            a(this.tXj, false, true);
            this.ehK.ce("wallet_lock_modify_gesture", true);
            AppMethodBeat.o(51756);
            return;
        }
        if (g.tWY.cTV() != 1) {
            a(this.tXj, false, true);
            this.ehK.ce("wallet_lock_modify_gesture", true);
        } else if (this.tXn) {
            a(this.tXj, true, true);
            this.ehK.ce("wallet_lock_modify_gesture", false);
            AppMethodBeat.o(51756);
            return;
        }
        AppMethodBeat.o(51756);
    }

    private void cUk() {
        AppMethodBeat.i(51757);
        if (g.tWY.cTV() != 0) {
            a(this.tXk, false, true);
        } else if (this.tXn) {
            a(this.tXk, true, true);
            AppMethodBeat.o(51757);
            return;
        }
        AppMethodBeat.o(51757);
    }

    private void cUl() {
        AppMethodBeat.i(51758);
        if (this.tXi != null && this.tXo) {
            a(this.tXi, false, this.tXo);
        }
        if (this.tXl != null && this.tXp) {
            a(this.tXl, false, this.tXp);
        }
        if (this.tXj != null) {
            a(this.tXj, false, true);
        }
        if (this.tXk != null) {
            a(this.tXk, false, true);
        }
        AppMethodBeat.o(51758);
    }

    private void a(Preference preference, boolean z, boolean z2) {
        AppMethodBeat.i(51759);
        if (preference instanceof IconPreference) {
            IconPreference iconPreference = (IconPreference) preference;
            iconPreference.hn(a.fromDPToPix(this, 20), a.fromDPToPix(this, 20));
            if (z) {
                if (z2) {
                    iconPreference.NO(R.raw.radio_on);
                } else {
                    iconPreference.NO(R.raw.radio_default_on);
                }
                iconPreference.NP(0);
                AppMethodBeat.o(51759);
                return;
            }
            iconPreference.NO(R.raw.radio_off);
            iconPreference.NP(0);
        }
        AppMethodBeat.o(51759);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(51760);
        if ("wallet_lock_fingerprint".equals(preference.mKey)) {
            cUl();
            a(preference, true, true);
            if (this.tXo && !(this.tXn && g.tWY.cTV() == 2)) {
                if (!com.tencent.soter.core.a.iR(this)) {
                    cUm();
                } else if (!(this.tXn && g.tWY.cTV() == 2)) {
                    ab.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
                    ((b) com.tencent.mm.kernel.g.K(b.class)).b((Activity) this, 2, 1);
                }
            }
            AppMethodBeat.o(51760);
            return true;
        } else if ("wallet_lock_faceid".equals(preference.mKey)) {
            cUl();
            a(preference, true, true);
            if (this.tXp && !(this.tXn && g.tWY.cTV() == 3)) {
                if (!com.tencent.soter.core.a.iS(this)) {
                    cUm();
                } else if (!this.tXn || g.tWY.cTV() == 3) {
                    ab.i("MicroMsg.WalletLockSettingUI", "request open faceid lock");
                    ((b) com.tencent.mm.kernel.g.K(b.class)).b((Activity) this, 3, 4);
                }
            }
            AppMethodBeat.o(51760);
            return true;
        } else if ("wallet_lock_gesture".equals(preference.mKey)) {
            cUl();
            a(preference, true, true);
            if (g.tWY.cTV() != 1) {
                ab.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
                ((b) com.tencent.mm.kernel.g.K(b.class)).b((Activity) this, 1, 2);
            }
            AppMethodBeat.o(51760);
            return true;
        } else if ("wallet_lock_close".equals(preference.mKey)) {
            cUl();
            a(preference, true, true);
            if (g.tWY.cTV() != 0) {
                ab.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
                ((b) com.tencent.mm.kernel.g.K(b.class)).i(this, 3);
                bj bjVar = new bj();
                bjVar.cVT = 14;
                bjVar.dcm = 1;
                bjVar.ajK();
            }
            AppMethodBeat.o(51760);
            return true;
        } else if ("wallet_lock_modify_gesture".equals(preference.mKey)) {
            ((b) com.tencent.mm.kernel.g.K(b.class)).ad(this);
            AppMethodBeat.o(51760);
            return true;
        } else {
            AppMethodBeat.o(51760);
            return false;
        }
    }

    private void cUm() {
        AppMethodBeat.i(51761);
        this.ggF = h.a((Context) this, getString(R.string.fhj), "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(51745);
                WalletLockSettingUI.b(WalletLockSettingUI.this);
                AppMethodBeat.o(51745);
            }
        });
        this.ggF.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(51761);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(51762);
        ab.i("MicroMsg.WalletLockSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null) {
            ab.e("MicroMsg.WalletLockSettingUI", "alvinluo data is null");
            AppMethodBeat.o(51762);
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", -1);
        ab.i("MicroMsg.WalletLockSettingUI", "alvinluo wallet lock setting onActivityResult errCode: %d", Integer.valueOf(intExtra));
        if (i == 1) {
            ab.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock onActivityResult");
            if (intExtra == 0) {
                if (this.tXm) {
                    j(i2, intent);
                    AppMethodBeat.o(51762);
                    return;
                }
            } else if (intExtra != 4) {
                ab.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
                JN(getString(R.string.fh5));
                AppMethodBeat.o(51762);
                return;
            }
        } else if (i == 2) {
            ab.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
            if (intExtra == 0) {
                if (this.tXm) {
                    j(i2, intent);
                }
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(51746);
                        try {
                            com.tencent.soter.a.a.Ri(3);
                            AppMethodBeat.o(51746);
                        } catch (Exception e) {
                            ab.e("MicroMsg.WalletLockSettingUI", "Remove AK after open gesture lock failed! " + e.getMessage());
                            AppMethodBeat.o(51746);
                        }
                    }
                }, "WalletLockRemoveAuthKey");
                AppMethodBeat.o(51762);
                return;
            } else if (intExtra != 4) {
                ab.i("MicroMsg.WalletLockSettingUI", "alvinluo open gesture lock failed");
                JN(getString(R.string.fhg));
                AppMethodBeat.o(51762);
                return;
            }
        } else if (i == 3) {
            if (intExtra == 0) {
                ((b) com.tencent.mm.kernel.g.K(b.class)).HB(0);
                g gVar = g.tWY;
                g.cTq();
                cUh();
                Toast.makeText(this, getString(R.string.fgz), 0).show();
                com.tencent.mm.plugin.walletlock.c.h.cUb();
                if (this.tXm) {
                    w(-1, 0, "close wallet lock ok");
                }
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(51747);
                        try {
                            com.tencent.soter.a.a.Ri(3);
                            AppMethodBeat.o(51747);
                        } catch (Exception e) {
                            ab.e("MicroMsg.WalletLockSettingUI", "Remove AK after close wallet lock failed! " + e.getMessage());
                            AppMethodBeat.o(51747);
                        }
                    }
                }, "WalletLockRemoveAuthKey");
                bj bjVar = new bj();
                bjVar.cVT = 14;
                bjVar.dcm = 2;
                bjVar.ajK();
                AppMethodBeat.o(51762);
                return;
            } else if (intExtra != 4) {
                JN(getString(R.string.fh0));
            }
        }
        AppMethodBeat.o(51762);
    }

    private void JN(String str) {
        AppMethodBeat.i(51763);
        this.ggF = h.a((Context) this, str, "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        this.ggF.setCanceledOnTouchOutside(false);
        this.ggF.show();
        AppMethodBeat.o(51763);
    }
}
