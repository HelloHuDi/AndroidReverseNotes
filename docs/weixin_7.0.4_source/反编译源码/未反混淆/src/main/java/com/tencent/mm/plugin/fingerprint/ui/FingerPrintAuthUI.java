package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.soter.a.g.f;
import java.lang.ref.WeakReference;

public class FingerPrintAuthUI extends WalletBaseUI implements com.tencent.mm.pluginsdk.wallet.a {
    private boolean isPaused = false;
    private TextView msD;
    private c msE;
    private a msF;
    private boolean msG = false;
    private final int msH = 1;
    private Dialog msu = null;
    private j msv = null;
    private Animation msx;
    private int msy = 0;

    public class a implements com.tencent.mm.pluginsdk.wallet.c {
        private WeakReference<FingerPrintAuthUI> msL = null;

        public a(FingerPrintAuthUI fingerPrintAuthUI) {
            AppMethodBeat.i(41638);
            this.msL = new WeakReference(fingerPrintAuthUI);
            AppMethodBeat.o(41638);
        }

        private FingerPrintAuthUI bxT() {
            AppMethodBeat.i(41639);
            if (this.msL != null) {
                FingerPrintAuthUI fingerPrintAuthUI = (FingerPrintAuthUI) this.msL.get();
                AppMethodBeat.o(41639);
                return fingerPrintAuthUI;
            }
            AppMethodBeat.o(41639);
            return null;
        }

        public final void bJ(int i, int i2) {
            AppMethodBeat.i(41640);
            String string;
            switch (i) {
                case 0:
                    ab.i("MicroMsg.FingerPrintAuthUI", "identify success");
                    if (bxT() != null) {
                        FingerPrintAuthUI.a(bxT(), i2);
                        AppMethodBeat.o(41640);
                        return;
                    }
                    break;
                case 2001:
                    ab.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
                    if (bxT() != null) {
                        FingerPrintAuthUI.a(FingerPrintAuthUI.this, false);
                        AppMethodBeat.o(41640);
                        return;
                    }
                    break;
                case 2002:
                    ab.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                    if (bxT() != null) {
                        FingerPrintAuthUI.a(bxT());
                        FingerPrintAuthUI.a(FingerPrintAuthUI.this, true);
                        AppMethodBeat.o(41640);
                        return;
                    }
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                case 10308:
                    ab.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", Integer.valueOf(i));
                    string = ah.getContext().getString(R.string.ere);
                    if (i == 10308) {
                        string = ah.getContext().getString(R.string.erf);
                        com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
                    } else {
                        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, i, "fingerprint error");
                    }
                    if (bxT() != null) {
                        FingerPrintAuthUI.a(bxT(), string, -1);
                        AppMethodBeat.o(41640);
                        return;
                    }
                    break;
                case 2009:
                    ab.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", Integer.valueOf(i));
                    string = ah.getContext().getString(R.string.ere);
                    com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, i, "fingerprint error");
                    com.tencent.mm.plugin.soter.d.a.EE(2);
                    if (bxT() != null) {
                        FingerPrintAuthUI.a(bxT(), string, -1);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(41640);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI, String str, int i) {
        AppMethodBeat.i(41653);
        fingerPrintAuthUI.cg(str, i);
        AppMethodBeat.o(41653);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41641);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.dak));
        this.msD = (TextView) findViewById(R.id.btk);
        com.tencent.mm.plugin.fingerprint.a.bwM();
        this.msE = com.tencent.mm.plugin.fingerprint.a.bwN();
        this.msv = c.bxm();
        Bundle aD = com.tencent.mm.wallet_core.a.aD((Activity) this);
        if (aD != null) {
            String string = aD.getString("pwd");
            if (TextUtils.isEmpty(string)) {
                ab.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
                cg(getString(R.string.bv_), -1);
                com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, -1, "get user pwd error");
                AppMethodBeat.o(41641);
                return;
            } else if (e.bxs()) {
                fE(true);
                f.dRn().dRo();
                this.msv.a((Context) this, new com.tencent.mm.pluginsdk.wallet.a() {
                    public final void aC(int i, String str) {
                        AppMethodBeat.i(41632);
                        FingerPrintAuthUI.this.fE(false);
                        if (i == 0) {
                            FingerPrintAuthUI.this.msG = true;
                            if (FingerPrintAuthUI.c(FingerPrintAuthUI.this)) {
                                FingerPrintAuthUI.a(FingerPrintAuthUI.this, false);
                                AppMethodBeat.o(41632);
                                return;
                            }
                        }
                        FingerPrintAuthUI.a(FingerPrintAuthUI.this, FingerPrintAuthUI.this.getString(R.string.a98), i);
                        AppMethodBeat.o(41632);
                    }
                }, string);
                AppMethodBeat.o(41641);
                return;
            } else {
                ab.e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
                AppMethodBeat.o(41641);
                return;
            }
        }
        ab.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
        cg(getString(R.string.bv_), -1);
        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
        AppMethodBeat.o(41641);
    }

    /* Access modifiers changed, original: protected|final */
    public final void fE(final boolean z) {
        AppMethodBeat.i(41642);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(41633);
                if (z) {
                    FingerPrintAuthUI.this.msu = g.b(FingerPrintAuthUI.this, false, null);
                    AppMethodBeat.o(41633);
                    return;
                }
                if (FingerPrintAuthUI.this.msu != null && FingerPrintAuthUI.this.msu.isShowing()) {
                    FingerPrintAuthUI.this.msu.dismiss();
                    FingerPrintAuthUI.this.msu = null;
                }
                AppMethodBeat.o(41633);
            }
        });
        AppMethodBeat.o(41642);
    }

    public void onResume() {
        AppMethodBeat.i(41643);
        super.onResume();
        this.isPaused = false;
        if (this.msG) {
            hw(false);
        }
        AppMethodBeat.o(41643);
    }

    private void hw(boolean z) {
        AppMethodBeat.i(41644);
        com.tencent.mm.plugin.fingerprint.a.bwM();
        com.tencent.mm.plugin.fingerprint.a.bwN();
        c.abort();
        c.release();
        if (c.bxl()) {
            if (this.msF == null) {
                this.msF = new a(this);
            }
            if (c.a(this.msF, z) != 0) {
                ab.e("MicroMsg.FingerPrintAuthUI", "startFingerprintAuth failed!");
            }
            AppMethodBeat.o(41644);
            return;
        }
        ab.e("MicroMsg.FingerPrintAuthUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
        AppMethodBeat.o(41644);
    }

    public void onPause() {
        AppMethodBeat.i(41645);
        super.onPause();
        this.isPaused = true;
        WakeLock newWakeLock = ((PowerManager) this.mController.ylL.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        ab.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
        com.tencent.mm.plugin.fingerprint.a.bwM();
        if (com.tencent.mm.plugin.fingerprint.a.bwN() != null) {
            c.bxk();
        }
        if (newWakeLock != null) {
            newWakeLock.release();
        }
        AppMethodBeat.o(41645);
    }

    public void onDestroy() {
        AppMethodBeat.i(41646);
        ab.i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
        if (this.msx != null) {
            this.msx.cancel();
        }
        this.msF = null;
        super.onDestroy();
        AppMethodBeat.o(41646);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41647);
        if (this.msv.c(i, i2, str, mVar)) {
            AppMethodBeat.o(41647);
            return true;
        } else if (mVar instanceof y) {
            fE(false);
            com.tencent.mm.wallet_core.a.b((Activity) this, new Bundle(), 0);
            Toast.makeText(this, R.string.bva, 0).show();
            AppMethodBeat.o(41647);
            return true;
        } else {
            AppMethodBeat.o(41647);
            return false;
        }
    }

    private void cg(final String str, final int i) {
        AppMethodBeat.i(41648);
        this.msG = false;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(41636);
                h.a(FingerPrintAuthUI.this, str, "", FingerPrintAuthUI.this.getString(R.string.ffp), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(41635);
                        com.tencent.mm.wallet_core.a.b(FingerPrintAuthUI.this, new Bundle(), i);
                        AppMethodBeat.o(41635);
                    }
                });
                AppMethodBeat.o(41636);
            }
        });
        AppMethodBeat.o(41648);
    }

    public final int getLayoutId() {
        return R.layout.zu;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void aC(int i, String str) {
        AppMethodBeat.i(41649);
        if (i == 0) {
            ab.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
            a(new y(null, 19), false, false);
            AppMethodBeat.o(41649);
            return;
        }
        fE(false);
        ab.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
        h.a((Context) this, getString(R.string.bv_), "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(41637);
                com.tencent.mm.wallet_core.a.b(FingerPrintAuthUI.this, new Bundle(), -1);
                AppMethodBeat.o(41637);
            }
        });
        AppMethodBeat.o(41649);
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI) {
        AppMethodBeat.i(41651);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthUI.msy > 1) {
            fingerPrintAuthUI.msy = currentTimeMillis;
            fingerPrintAuthUI.msD.setText(R.string.bv3);
            fingerPrintAuthUI.msD.setTextColor(fingerPrintAuthUI.getResources().getColor(R.color.xy));
            fingerPrintAuthUI.msD.setVisibility(4);
            if (fingerPrintAuthUI.msx == null) {
                fingerPrintAuthUI.msx = AnimationUtils.loadAnimation(fingerPrintAuthUI.mController.ylL, R.anim.b7);
            }
            fingerPrintAuthUI.msD.startAnimation(fingerPrintAuthUI.msx);
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(41634);
                    FingerPrintAuthUI.this.msD.setVisibility(0);
                    AppMethodBeat.o(41634);
                }
            }, fingerPrintAuthUI.msx.getDuration());
            AppMethodBeat.o(41651);
            return;
        }
        AppMethodBeat.o(41651);
    }

    static /* synthetic */ boolean c(FingerPrintAuthUI fingerPrintAuthUI) {
        boolean z;
        AppMethodBeat.i(41654);
        String str = "MicroMsg.FingerPrintAuthUI";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        if (fingerPrintAuthUI.isPaused) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (fingerPrintAuthUI.isPaused) {
            AppMethodBeat.o(41654);
            return false;
        }
        AppMethodBeat.o(41654);
        return true;
    }
}
