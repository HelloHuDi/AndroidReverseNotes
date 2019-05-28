package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

@a(0)
public class WalletBiometricPaySettingsUI extends WalletPreferenceUI {
    private l mrm;
    private Preference tqU;
    private Preference tqV;
    private Preference tqW;
    private Preference tqX;
    private int tqY = 0;
    private boolean tqZ;
    private boolean tra;
    private boolean trb;
    private boolean trc;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void d(WalletBiometricPaySettingsUI walletBiometricPaySettingsUI) {
        AppMethodBeat.i(46238);
        walletBiometricPaySettingsUI.cOp();
        AppMethodBeat.o(46238);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46223);
        super.onCreate(bundle);
        if (com.tencent.mm.plugin.wallet.b.a.cOR() && com.tencent.mm.plugin.wallet.b.a.cOQ()) {
            this.tqY = 1;
        } else if (com.tencent.mm.plugin.wallet.b.a.cOQ()) {
            this.tqY = 2;
        } else if (com.tencent.mm.plugin.wallet.b.a.cOR()) {
            this.tqY = 3;
        } else {
            ab.w("MicroMsg.WalletBiometricPaySettingsUI", "device not support biometric pay!");
            finish();
        }
        if (this.tqY == 1) {
            setMMTitle((int) R.string.f_z);
        } else if (this.tqY == 2) {
            setMMTitle((int) R.string.fn8);
        } else {
            setMMTitle((int) R.string.fn6);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(46220);
                WalletBiometricPaySettingsUI.this.finish();
                AppMethodBeat.o(46220);
                return false;
            }
        });
        this.mrm = (l) g.K(l.class);
        ab.i("MicroMsg.WalletBiometricPaySettingsUI", "biometric mode: %s", Integer.valueOf(this.tqY));
        initView();
        AppMethodBeat.o(46223);
    }

    public void onResume() {
        AppMethodBeat.i(46225);
        super.onResume();
        ab.i("MicroMsg.WalletBiometricPaySettingsUI", "update pref check state: %s, %s", Boolean.valueOf(this.mrm.bxe()), Boolean.valueOf(this.mrm.bxh()));
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
        AppMethodBeat.o(46225);
    }

    public final boolean f(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int JC() {
        return R.xml.cp;
    }

    public final boolean a(final f fVar, Preference preference) {
        AppMethodBeat.i(46226);
        ab.i("MicroMsg.WalletBiometricPaySettingsUI", "click key: %s", preference.mKey);
        this.trc = a(this.tqU);
        if (this.tqY == 1) {
            this.tra = a(this.tqX);
            this.trb = a(this.tqW);
        } else {
            this.tqZ = a(this.tqV);
        }
        ab.i("MicroMsg.WalletBiometricPaySettingsUI", "is checked: %s", Boolean.valueOf(a(preference)));
        if (a(preference)) {
            AppMethodBeat.o(46226);
        } else {
            if ("biometric_pay_close".equals(preference.mKey)) {
                String string = getString(R.string.bv5);
                if (this.mrm.bxh()) {
                    string = getString(R.string.bmo);
                }
                h.a((Context) this, false, string, "", getString(R.string.s6), getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(46222);
                        final Dialog b = com.tencent.mm.wallet_core.ui.g.b(WalletBiometricPaySettingsUI.this.mController.ylL, false, null);
                        final b btVar = new bt();
                        btVar.cuS.cuU = WalletBiometricPaySettingsUI.this.mrm.bxe() ? 1 : 2;
                        btVar.callback = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(46221);
                                if (btVar.cuT != null) {
                                    if (b != null) {
                                        b.dismiss();
                                    }
                                    ab.i("MicroMsg.WalletBiometricPaySettingsUI", "close event result: %s", Integer.valueOf(btVar.cuT.retCode));
                                    if (btVar.cuT.retCode == 0) {
                                        g.RO().eJo.a(new y(null, 19), 0);
                                        AppMethodBeat.o(46221);
                                        return;
                                    }
                                    WalletBiometricPaySettingsUI.b(WalletBiometricPaySettingsUI.this);
                                    WalletBiometricPaySettingsUI.c(WalletBiometricPaySettingsUI.this);
                                }
                                AppMethodBeat.o(46221);
                            }
                        };
                        com.tencent.mm.sdk.b.a.xxA.a(btVar, WalletBiometricPaySettingsUI.this.getMainLooper());
                        WalletBiometricPaySettingsUI.d(WalletBiometricPaySettingsUI.this);
                        fVar.notifyDataSetChanged();
                        AppMethodBeat.o(46222);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
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
            fVar.notifyDataSetChanged();
            AppMethodBeat.o(46226);
        }
        return false;
    }

    private static void a(Preference preference, boolean z) {
        AppMethodBeat.i(46227);
        preference.setWidgetLayoutResource(z ? R.layout.ag0 : R.layout.ag1);
        AppMethodBeat.o(46227);
    }

    private void cOp() {
        AppMethodBeat.i(46228);
        if (this.tqY == 1) {
            a(this.tqW, false);
            a(this.tqX, false);
        } else {
            a(this.tqV, false);
        }
        a(this.tqU, true);
        AppMethodBeat.o(46228);
    }

    private void cOq() {
        AppMethodBeat.i(46229);
        if (this.tqY == 2 || this.tqY == 3) {
            a(this.tqV, true);
            a(this.tqU, false);
        }
        AppMethodBeat.o(46229);
    }

    private void cOr() {
        AppMethodBeat.i(46230);
        if (this.tqY == 1) {
            a(this.tqW, true);
            a(this.tqX, false);
            a(this.tqU, false);
        }
        AppMethodBeat.o(46230);
    }

    private void cOs() {
        AppMethodBeat.i(46231);
        if (this.tqY == 1) {
            a(this.tqW, false);
            a(this.tqX, true);
            a(this.tqU, false);
        }
        AppMethodBeat.o(46231);
    }

    private void Hh(int i) {
        AppMethodBeat.i(46232);
        ab.i("MicroMsg.WalletBiometricPaySettingsUI", "start open process: %s", Integer.valueOf(i));
        Bundle bundle = new Bundle();
        bundle.putInt("open_scene", 1);
        bundle.putInt("key_open_biometric_type", i);
        com.tencent.mm.wallet_core.a.b((Activity) this, "FingerprintAuth", bundle);
        AppMethodBeat.o(46232);
    }

    private void Hi(int i) {
        AppMethodBeat.i(46233);
        ab.i("MicroMsg.WalletBiometricPaySettingsUI", "show enroll biometric guide: %s", Integer.valueOf(i));
        String string = getString(R.string.fnk);
        if (i == 1) {
            string = getString(R.string.fnm);
        }
        h.a((Context) this, string, "", getString(R.string.fnj), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(46233);
    }

    private void cOt() {
        AppMethodBeat.i(46234);
        ab.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open fingerprint");
        if (this.mrm.bxo()) {
            Hh(1);
            if (this.tqY == 1) {
                cOr();
                AppMethodBeat.o(46234);
                return;
            }
            cOq();
            AppMethodBeat.o(46234);
            return;
        }
        Hi(1);
        AppMethodBeat.o(46234);
    }

    private void cOu() {
        AppMethodBeat.i(46235);
        ab.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open faceid");
        if (this.mrm.bxB()) {
            Hh(2);
            if (this.tqY == 1) {
                cOs();
                AppMethodBeat.o(46235);
                return;
            }
            cOq();
            AppMethodBeat.o(46235);
            return;
        }
        Hi(2);
        AppMethodBeat.o(46235);
    }

    public final void initView() {
        AppMethodBeat.i(46224);
        com.tencent.mm.ui.base.preference.h hVar = this.yCw;
        this.tqU = hVar.aqO("biometric_pay_close");
        this.tqU.NW(8);
        ab.i("MicroMsg.WalletBiometricPaySettingsUI", "fingerprint: %s, faceid: %s", Boolean.valueOf(this.mrm.bxe()), Boolean.valueOf(this.mrm.bxh()));
        if (this.tqY == 2 || this.tqY == 3) {
            this.tqV = new Preference(this);
            this.tqV.setKey("key_single_open");
            this.tqV.setTitle((int) R.string.fa0);
            this.tqV.yDf = false;
            hVar.a(this.tqV, 0);
            this.tqV.NW(8);
            AppMethodBeat.o(46224);
            return;
        }
        if (this.tqY == 1) {
            this.tqX = new Preference(this);
            this.tqX.setKey("key_faceid_open");
            this.tqX.setTitle((int) R.string.fa1);
            hVar.a(this.tqX, 0);
            this.tqW = new Preference(this);
            this.tqW.setKey("key_fingerprint_open");
            this.tqW.setTitle((int) R.string.fa2);
            hVar.a(this.tqW, 1);
            this.tqX.NW(8);
            this.tqW.NW(8);
        }
        AppMethodBeat.o(46224);
    }

    private static boolean a(Preference preference) {
        return preference.yDl == R.layout.ag0;
    }

    static /* synthetic */ void b(WalletBiometricPaySettingsUI walletBiometricPaySettingsUI) {
        AppMethodBeat.i(46236);
        a(walletBiometricPaySettingsUI.tqU, walletBiometricPaySettingsUI.trc);
        if (walletBiometricPaySettingsUI.tqY == 1) {
            a(walletBiometricPaySettingsUI.tqX, walletBiometricPaySettingsUI.tra);
            a(walletBiometricPaySettingsUI.tqW, walletBiometricPaySettingsUI.trb);
        } else {
            a(walletBiometricPaySettingsUI.tqV, walletBiometricPaySettingsUI.tqZ);
        }
        walletBiometricPaySettingsUI.yCw.notifyDataSetChanged();
        AppMethodBeat.o(46236);
    }

    static /* synthetic */ void c(WalletBiometricPaySettingsUI walletBiometricPaySettingsUI) {
        AppMethodBeat.i(46237);
        if (walletBiometricPaySettingsUI.mrm.bxe()) {
            h.b((Context) walletBiometricPaySettingsUI, walletBiometricPaySettingsUI.getResources().getString(R.string.bv7), "", true);
            AppMethodBeat.o(46237);
            return;
        }
        h.b((Context) walletBiometricPaySettingsUI, walletBiometricPaySettingsUI.getResources().getString(R.string.fn4), "", true);
        AppMethodBeat.o(46237);
    }
}
