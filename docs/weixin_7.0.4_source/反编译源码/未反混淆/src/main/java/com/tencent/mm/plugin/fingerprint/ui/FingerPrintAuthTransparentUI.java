package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.soter.a.g.f;

@a(7)
public class FingerPrintAuthTransparentUI extends WalletBaseUI implements com.tencent.mm.pluginsdk.wallet.a {
    private c mrx = new c() {
        public final void bJ(int i, int i2) {
            AppMethodBeat.i(41597);
            String string;
            switch (i) {
                case 0:
                    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
                    FingerPrintAuthTransparentUI.this.msw = i2;
                    FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this);
                    AppMethodBeat.o(41597);
                    return;
                case 2001:
                    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
                    AppMethodBeat.o(41597);
                    return;
                case 2002:
                    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                    FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this);
                    FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, true);
                    AppMethodBeat.o(41597);
                    return;
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                case 10308:
                    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", Integer.valueOf(i));
                    string = ah.getContext().getString(R.string.ere);
                    if (i == 10308) {
                        string = ah.getContext().getString(R.string.erf);
                        com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
                    } else {
                        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, i, "fingerprint error");
                    }
                    FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, string);
                    AppMethodBeat.o(41597);
                    return;
                case 2009:
                    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", Integer.valueOf(i));
                    string = ah.getContext().getString(R.string.ere);
                    com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, i, "fingerprint error");
                    com.tencent.mm.plugin.soter.d.a.EE(2);
                    FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, string);
                    break;
            }
            AppMethodBeat.o(41597);
        }
    };
    private int msA = 0;
    private boolean msB = false;
    private i mst = null;
    Dialog msu;
    private j msv = null;
    private int msw = -1;
    private Animation msx;
    private int msy = 0;
    private boolean msz = false;
    View view = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FingerPrintAuthTransparentUI() {
        AppMethodBeat.i(41610);
        AppMethodBeat.o(41610);
    }

    static /* synthetic */ void bxS() {
        AppMethodBeat.i(41631);
        bxQ();
        AppMethodBeat.o(41631);
    }

    static /* synthetic */ void c(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        AppMethodBeat.i(41628);
        fingerPrintAuthTransparentUI.bxR();
        AppMethodBeat.o(41628);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41611);
        super.onCreate(bundle);
        ab.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
        if (!e.bxs()) {
            ab.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
            finish();
            AppMethodBeat.o(41611);
        } else if (r.YM()) {
            ab.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
            finish();
            AppMethodBeat.o(41611);
        } else if (e.bxG()) {
            ab.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
            finish();
            AppMethodBeat.o(41611);
        } else {
            com.tencent.mm.plugin.fingerprint.a.bwM();
            com.tencent.mm.plugin.fingerprint.a.bwN();
            if (com.tencent.mm.plugin.fingerprint.b.c.bxl()) {
                if (q.etg.etr != 1) {
                    ab.e("MicroMsg.FingerPrintAuthTransparentUI", "hy: device config force to not support");
                    finish();
                }
                ak cPI = com.tencent.mm.plugin.wallet_core.model.r.cPI();
                com.tencent.mm.plugin.fingerprint.a.bwM();
                com.tencent.mm.plugin.fingerprint.a.bwN();
                this.msv = com.tencent.mm.plugin.fingerprint.b.c.bxm();
                this.msB = g.RP().Ry().getBoolean(ac.a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, false);
                if (!cPI.cQg() || e.bxG()) {
                    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + cPI.cQg() + ";isOpenTouch:" + e.bxG());
                    ab.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
                    finish();
                    AppMethodBeat.o(41611);
                    return;
                }
                ab.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
                f.dRn().dRo();
                h.pYm.e(12924, Integer.valueOf(1));
                com.tencent.mm.plugin.soter.d.a.EB(0);
                if (!getIntent().getBooleanExtra("key_show_guide", true)) {
                    bxR();
                    AppMethodBeat.o(41611);
                    return;
                } else if (g.RP().Ry().getBoolean(ac.a.USERINFO_FINGER_PRINT_IS_FIRST_SHOWN_BOOLEAN_SYNC, true)) {
                    String string;
                    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
                    g.RP().Ry().set(ac.a.USERINFO_FINGER_PRINT_IS_FIRST_SHOWN_BOOLEAN_SYNC, Boolean.FALSE);
                    g.RP().Ry().set(ac.a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, Boolean.FALSE);
                    if (this.msB) {
                        string = getString(R.string.c_6);
                    } else {
                        string = getString(R.string.c_5);
                    }
                    com.tencent.mm.ui.base.h.a((Context) this, string, "", getString(R.string.abi), getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(41603);
                            FingerPrintAuthTransparentUI.c(FingerPrintAuthTransparentUI.this);
                            AppMethodBeat.o(41603);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(41604);
                            FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this, false);
                            AppMethodBeat.o(41604);
                        }
                    });
                    g.RP().Ry().set(ac.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC, Integer.valueOf(1));
                    this.msA = 1;
                    com.tencent.mm.plugin.soter.d.a.fG(1, this.msA);
                    AppMethodBeat.o(41611);
                    return;
                } else {
                    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
                    View inflate = LayoutInflater.from(this).inflate(R.layout.zv, null);
                    final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.btq);
                    this.msA = ((Integer) g.RP().Ry().get(ac.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC, null)).intValue() + 1;
                    g.RP().Ry().set(ac.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC, Integer.valueOf(this.msA));
                    com.tencent.mm.plugin.soter.d.a.fG(1, this.msA);
                    com.tencent.mm.ui.base.h.a((Context) this, false, null, inflate, getString(R.string.abi), getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(41605);
                            FingerPrintAuthTransparentUI.c(FingerPrintAuthTransparentUI.this);
                            AppMethodBeat.o(41605);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(41606);
                            FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this, checkBox.isChecked());
                            AppMethodBeat.o(41606);
                        }
                    });
                    AppMethodBeat.o(41611);
                    return;
                }
            }
            ab.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
            finish();
            AppMethodBeat.o(41611);
        }
    }

    public void onResume() {
        AppMethodBeat.i(41612);
        super.onResume();
        if (this.msz) {
            hw(false);
        }
        AppMethodBeat.o(41612);
    }

    public void onPause() {
        AppMethodBeat.i(41613);
        super.onPause();
        ab.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
        WakeLock newWakeLock = ((PowerManager) this.mController.ylL.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        bxQ();
        if (newWakeLock != null) {
            newWakeLock.release();
        }
        AppMethodBeat.o(41613);
    }

    public void onStop() {
        AppMethodBeat.i(41614);
        super.onStop();
        finish();
        AppMethodBeat.o(41614);
    }

    private void hw(boolean z) {
        AppMethodBeat.i(41615);
        com.tencent.mm.plugin.fingerprint.a.bwM();
        com.tencent.mm.plugin.fingerprint.a.bwN();
        com.tencent.mm.plugin.fingerprint.b.c.abort();
        com.tencent.mm.plugin.fingerprint.b.c.release();
        if (com.tencent.mm.plugin.fingerprint.b.c.bxl()) {
            if (com.tencent.mm.plugin.fingerprint.b.c.a(this.mrx, z) != 0) {
                ab.e("MicroMsg.FingerPrintAuthTransparentUI", "startFingerprintAuth failed!");
            }
            AppMethodBeat.o(41615);
            return;
        }
        ab.e("MicroMsg.FingerPrintAuthTransparentUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
        AppMethodBeat.o(41615);
    }

    private static void bxQ() {
        AppMethodBeat.i(41616);
        ab.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
        com.tencent.mm.plugin.fingerprint.a.bwM();
        if (com.tencent.mm.plugin.fingerprint.a.bwN() != null) {
            com.tencent.mm.plugin.fingerprint.b.c.bxk();
        }
        AppMethodBeat.o(41616);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41617);
        boolean c = this.msv.c(i, i2, str, mVar);
        AppMethodBeat.o(41617);
        return c;
    }

    public final int getLayoutId() {
        return -1;
    }

    private void bxR() {
        AppMethodBeat.i(41618);
        com.tencent.mm.plugin.soter.d.a.fG(3, this.msA);
        Intent intent = getIntent();
        String str = "";
        if (intent != null) {
            str = intent.getStringExtra("key_pwd1");
        }
        this.msv.a((Context) this, new com.tencent.mm.pluginsdk.wallet.a() {
            public final void aC(int i, String str) {
                AppMethodBeat.i(41607);
                FingerPrintAuthTransparentUI.this.fE(false);
                if (i == 0) {
                    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
                    FingerPrintAuthTransparentUI.d(FingerPrintAuthTransparentUI.this);
                    FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, false);
                    AppMethodBeat.o(41607);
                    return;
                }
                FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, FingerPrintAuthTransparentUI.this.getString(R.string.a98));
                AppMethodBeat.o(41607);
            }
        }, str);
        fE(true);
        if (this.mst != null && this.mst.isShowing()) {
            this.mst.dismiss();
        }
        AppMethodBeat.o(41618);
    }

    public void finish() {
        AppMethodBeat.i(41619);
        if (this.msv != null) {
            this.msv.clear();
        }
        super.finish();
        AppMethodBeat.o(41619);
    }

    private void Mm(String str) {
        String string;
        AppMethodBeat.i(41620);
        if (TextUtils.isEmpty(str)) {
            string = getString(-1);
        } else {
            string = str;
        }
        com.tencent.mm.ui.base.h.a((Context) this, string, "", getString(R.string.ffp), false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(41599);
                ab.i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
                dialogInterface.dismiss();
                FingerPrintAuthTransparentUI.this.finish();
                AppMethodBeat.o(41599);
            }
        });
        AppMethodBeat.o(41620);
    }

    /* Access modifiers changed, original: protected|final */
    public final void fE(boolean z) {
        AppMethodBeat.i(41621);
        if (z) {
            this.msu = com.tencent.mm.wallet_core.ui.g.a((Context) this, false, null);
            AppMethodBeat.o(41621);
            return;
        }
        if (this.msu != null && this.msu.isShowing()) {
            this.msu.dismiss();
            this.msu = null;
        }
        AppMethodBeat.o(41621);
    }

    public void onDestroy() {
        AppMethodBeat.i(41622);
        if (this.mst != null && this.mst.isShowing()) {
            this.mst.dismiss();
            this.mst = null;
        }
        if (this.msx != null) {
            this.msx.cancel();
        }
        fE(false);
        super.onDestroy();
        AppMethodBeat.o(41622);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void aC(int i, String str) {
        AppMethodBeat.i(41623);
        fE(false);
        if (i == 0) {
            ab.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
            a(new y(null, 19), false, false);
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.bvc), getString(R.string.bv9), getString(R.string.fnj), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(41598);
                    dialogInterface.dismiss();
                    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
                    FingerPrintAuthTransparentUI.this.finish();
                    AppMethodBeat.o(41598);
                }
            });
            AppMethodBeat.o(41623);
        } else if (i == -2) {
            String string;
            ab.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
            if (TextUtils.isEmpty(str)) {
                string = getString(R.string.bv_);
            } else {
                string = str;
            }
            com.tencent.mm.ui.base.h.a((Context) this, string, "", getString(R.string.bvh), getString(R.string.or), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(41600);
                    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
                    FingerPrintAuthTransparentUI.d(FingerPrintAuthTransparentUI.this);
                    FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, false);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(41600);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(41601);
                    FingerPrintAuthTransparentUI.this.finish();
                    AppMethodBeat.o(41601);
                }
            });
            AppMethodBeat.o(41623);
        } else {
            Mm(str);
            AppMethodBeat.o(41623);
        }
    }

    static /* synthetic */ void a(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        AppMethodBeat.i(41624);
        fingerPrintAuthTransparentUI.msz = false;
        com.tencent.mm.plugin.fingerprint.a.bwM();
        com.tencent.mm.plugin.fingerprint.a.bwN();
        com.tencent.mm.plugin.fingerprint.b.c.release();
        fingerPrintAuthTransparentUI.mst.dismiss();
        fingerPrintAuthTransparentUI.msv.a((com.tencent.mm.pluginsdk.wallet.a) fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.msw, 2);
        AppMethodBeat.o(41624);
    }

    static /* synthetic */ void b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        AppMethodBeat.i(41625);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthTransparentUI.msy > 1) {
            fingerPrintAuthTransparentUI.msy = currentTimeMillis;
            ((TextView) fingerPrintAuthTransparentUI.view.findViewById(R.id.kv)).setVisibility(8);
            final TextView textView = (TextView) fingerPrintAuthTransparentUI.view.findViewById(R.id.bti);
            textView.setVisibility(4);
            if (fingerPrintAuthTransparentUI.msx == null) {
                fingerPrintAuthTransparentUI.msx = AnimationUtils.loadAnimation(fingerPrintAuthTransparentUI.mController.ylL, R.anim.b7);
            }
            textView.startAnimation(fingerPrintAuthTransparentUI.msx);
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(41602);
                    textView.setVisibility(0);
                    AppMethodBeat.o(41602);
                }
            }, fingerPrintAuthTransparentUI.msx.getDuration());
            AppMethodBeat.o(41625);
            return;
        }
        AppMethodBeat.o(41625);
    }

    static /* synthetic */ void b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI, boolean z) {
        AppMethodBeat.i(41629);
        com.tencent.mm.plugin.soter.d.a.fG(2, fingerPrintAuthTransparentUI.msA);
        if (z) {
            com.tencent.mm.plugin.soter.d.a.d(10, -1000223, -1, "user permanent cancelled");
            ab.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled and checked as not show anymore");
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.TRUE);
        } else {
            ab.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled but will show again");
            com.tencent.mm.plugin.soter.d.a.d(1, -1000223, -1, "user cancelled");
        }
        fingerPrintAuthTransparentUI.finish();
        AppMethodBeat.o(41629);
    }

    static /* synthetic */ void d(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        ViewGroup viewGroup;
        AppMethodBeat.i(41630);
        ab.i("MicroMsg.FingerPrintAuthTransparentUI", "showIdentifyUI!");
        fingerPrintAuthTransparentUI.view = LayoutInflater.from(fingerPrintAuthTransparentUI).inflate(R.layout.zt, null);
        ViewParent parent = fingerPrintAuthTransparentUI.view.getParent();
        if (parent != null) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ((ImageView) fingerPrintAuthTransparentUI.view.findViewById(R.id.bth)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41608);
                if (FingerPrintAuthTransparentUI.this.mst != null) {
                    FingerPrintAuthTransparentUI.this.mst.cancel();
                }
                FingerPrintAuthTransparentUI.bxS();
                FingerPrintAuthTransparentUI.this.finish();
                AppMethodBeat.o(41608);
            }
        });
        if (fingerPrintAuthTransparentUI.mst != null && fingerPrintAuthTransparentUI.mst.isShowing()) {
            fingerPrintAuthTransparentUI.mst.dismiss();
            fingerPrintAuthTransparentUI.mst = null;
        }
        fingerPrintAuthTransparentUI.mst = new i(fingerPrintAuthTransparentUI, R.style.zw);
        fingerPrintAuthTransparentUI.mst.setContentView(fingerPrintAuthTransparentUI.view);
        fingerPrintAuthTransparentUI.mst.setCanceledOnTouchOutside(false);
        fingerPrintAuthTransparentUI.mst.setCancelable(true);
        fingerPrintAuthTransparentUI.mst.show();
        fingerPrintAuthTransparentUI.mst.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(41609);
                dialogInterface.dismiss();
                FingerPrintAuthTransparentUI.bxS();
                FingerPrintAuthTransparentUI.this.finish();
                AppMethodBeat.o(41609);
            }
        });
        com.tencent.mm.ui.base.h.a(fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.mst);
        AppMethodBeat.o(41630);
    }
}
