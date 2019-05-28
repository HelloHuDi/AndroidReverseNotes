package com.tencent.p177mm.plugin.fingerprint.p414ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.fingerprint.C43094a;
import com.tencent.p177mm.plugin.fingerprint.p413b.C39086c;
import com.tencent.p177mm.plugin.fingerprint.p413b.C39088e;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.pluginsdk.wallet.C14990c;
import com.tencent.p177mm.pluginsdk.wallet.C14992j;
import com.tencent.p177mm.pluginsdk.wallet.C30157a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.soter.p663a.p664g.C40994f;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI */
public class FingerPrintAuthUI extends WalletBaseUI implements C30157a {
    private boolean isPaused = false;
    private TextView msD;
    private C39086c msE;
    private C20769a msF;
    private boolean msG = false;
    private final int msH = 1;
    private Dialog msu = null;
    private C14992j msv = null;
    private Animation msx;
    private int msy = 0;

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI$5 */
    class C207685 implements OnClickListener {
        C207685() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41637);
            C24143a.m37113b(FingerPrintAuthUI.this, new Bundle(), -1);
            AppMethodBeat.m2505o(41637);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI$a */
    public class C20769a implements C14990c {
        private WeakReference<FingerPrintAuthUI> msL = null;

        public C20769a(FingerPrintAuthUI fingerPrintAuthUI) {
            AppMethodBeat.m2504i(41638);
            this.msL = new WeakReference(fingerPrintAuthUI);
            AppMethodBeat.m2505o(41638);
        }

        private FingerPrintAuthUI bxT() {
            AppMethodBeat.m2504i(41639);
            if (this.msL != null) {
                FingerPrintAuthUI fingerPrintAuthUI = (FingerPrintAuthUI) this.msL.get();
                AppMethodBeat.m2505o(41639);
                return fingerPrintAuthUI;
            }
            AppMethodBeat.m2505o(41639);
            return null;
        }

        /* renamed from: bJ */
        public final void mo7357bJ(int i, int i2) {
            AppMethodBeat.m2504i(41640);
            String string;
            switch (i) {
                case 0:
                    C4990ab.m7416i("MicroMsg.FingerPrintAuthUI", "identify success");
                    if (bxT() != null) {
                        FingerPrintAuthUI.m56040a(bxT(), i2);
                        AppMethodBeat.m2505o(41640);
                        return;
                    }
                    break;
                case 2001:
                    C4990ab.m7416i("MicroMsg.FingerPrintAuthUI", "identify timeout");
                    if (bxT() != null) {
                        FingerPrintAuthUI.m56042a(FingerPrintAuthUI.this, false);
                        AppMethodBeat.m2505o(41640);
                        return;
                    }
                    break;
                case 2002:
                    C4990ab.m7416i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                    if (bxT() != null) {
                        FingerPrintAuthUI.m56039a(bxT());
                        FingerPrintAuthUI.m56042a(FingerPrintAuthUI.this, true);
                        AppMethodBeat.m2505o(41640);
                        return;
                    }
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                case 10308:
                    C4990ab.m7417i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", Integer.valueOf(i));
                    string = C4996ah.getContext().getString(C25738R.string.ere);
                    if (i == 10308) {
                        string = C4996ah.getContext().getString(C25738R.string.erf);
                        C46261a.m86639d(6, -1000223, -1, "too many trial");
                    } else {
                        C46261a.m86639d(1000, -1000223, i, "fingerprint error");
                    }
                    if (bxT() != null) {
                        FingerPrintAuthUI.m56041a(bxT(), string, -1);
                        AppMethodBeat.m2505o(41640);
                        return;
                    }
                    break;
                case 2009:
                    C4990ab.m7417i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", Integer.valueOf(i));
                    string = C4996ah.getContext().getString(C25738R.string.ere);
                    C46261a.m86639d(1000, -1000223, i, "fingerprint error");
                    C46261a.m86638EE(2);
                    if (bxT() != null) {
                        FingerPrintAuthUI.m56041a(bxT(), string, -1);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(41640);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI$1 */
    class C341831 implements C30157a {
        C341831() {
        }

        /* renamed from: aC */
        public final void mo7375aC(int i, String str) {
            AppMethodBeat.m2504i(41632);
            FingerPrintAuthUI.this.mo54762fE(false);
            if (i == 0) {
                FingerPrintAuthUI.this.msG = true;
                if (FingerPrintAuthUI.m56044c(FingerPrintAuthUI.this)) {
                    FingerPrintAuthUI.m56042a(FingerPrintAuthUI.this, false);
                    AppMethodBeat.m2505o(41632);
                    return;
                }
            }
            FingerPrintAuthUI.m56041a(FingerPrintAuthUI.this, FingerPrintAuthUI.this.getString(C25738R.string.a98), i);
            AppMethodBeat.m2505o(41632);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI$3 */
    class C341843 implements Runnable {
        C341843() {
        }

        public final void run() {
            AppMethodBeat.m2504i(41634);
            FingerPrintAuthUI.this.msD.setVisibility(0);
            AppMethodBeat.m2505o(41634);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m56041a(FingerPrintAuthUI fingerPrintAuthUI, String str, int i) {
        AppMethodBeat.m2504i(41653);
        fingerPrintAuthUI.m56045cg(str, i);
        AppMethodBeat.m2505o(41653);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41641);
        super.onCreate(bundle);
        setMMTitle(getString(C25738R.string.dak));
        this.msD = (TextView) findViewById(2131824043);
        C43094a.bwM();
        this.msE = C43094a.bwN();
        this.msv = C39086c.bxm();
        Bundle aD = C24143a.m37110aD((Activity) this);
        if (aD != null) {
            String string = aD.getString("pwd");
            if (TextUtils.isEmpty(string)) {
                C4990ab.m7412e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
                m56045cg(getString(C25738R.string.bv_), -1);
                C46261a.m86639d(1000, -1000223, -1, "get user pwd error");
                AppMethodBeat.m2505o(41641);
                return;
            } else if (C39088e.bxs()) {
                mo54762fE(true);
                C40994f.dRn().dRo();
                this.msv.mo27383a((Context) this, new C341831(), string);
                AppMethodBeat.m2505o(41641);
                return;
            } else {
                C4990ab.m7412e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
                AppMethodBeat.m2505o(41641);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
        m56045cg(getString(C25738R.string.bv_), -1);
        C46261a.m86639d(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
        AppMethodBeat.m2505o(41641);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: fE */
    public final void mo54762fE(final boolean z) {
        AppMethodBeat.m2504i(41642);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(41633);
                if (z) {
                    FingerPrintAuthUI.this.msu = C30901g.m49318b(FingerPrintAuthUI.this, false, null);
                    AppMethodBeat.m2505o(41633);
                    return;
                }
                if (FingerPrintAuthUI.this.msu != null && FingerPrintAuthUI.this.msu.isShowing()) {
                    FingerPrintAuthUI.this.msu.dismiss();
                    FingerPrintAuthUI.this.msu = null;
                }
                AppMethodBeat.m2505o(41633);
            }
        });
        AppMethodBeat.m2505o(41642);
    }

    public void onResume() {
        AppMethodBeat.m2504i(41643);
        super.onResume();
        this.isPaused = false;
        if (this.msG) {
            m56048hw(false);
        }
        AppMethodBeat.m2505o(41643);
    }

    /* renamed from: hw */
    private void m56048hw(boolean z) {
        AppMethodBeat.m2504i(41644);
        C43094a.bwM();
        C43094a.bwN();
        C39086c.abort();
        C39086c.release();
        if (C39086c.bxl()) {
            if (this.msF == null) {
                this.msF = new C20769a(this);
            }
            if (C39086c.m66508a(this.msF, z) != 0) {
                C4990ab.m7412e("MicroMsg.FingerPrintAuthUI", "startFingerprintAuth failed!");
            }
            AppMethodBeat.m2505o(41644);
            return;
        }
        C4990ab.m7412e("MicroMsg.FingerPrintAuthUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
        AppMethodBeat.m2505o(41644);
    }

    public void onPause() {
        AppMethodBeat.m2504i(41645);
        super.onPause();
        this.isPaused = true;
        WakeLock newWakeLock = ((PowerManager) this.mController.ylL.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        C4990ab.m7416i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
        C43094a.bwM();
        if (C43094a.bwN() != null) {
            C39086c.bxk();
        }
        if (newWakeLock != null) {
            newWakeLock.release();
        }
        AppMethodBeat.m2505o(41645);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41646);
        C4990ab.m7416i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
        if (this.msx != null) {
            this.msx.cancel();
        }
        this.msF = null;
        super.onDestroy();
        AppMethodBeat.m2505o(41646);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41647);
        if (this.msv.mo27385c(i, i2, str, c1207m)) {
            AppMethodBeat.m2505o(41647);
            return true;
        } else if (c1207m instanceof C35475y) {
            mo54762fE(false);
            C24143a.m37113b((Activity) this, new Bundle(), 0);
            Toast.makeText(this, C25738R.string.bva, 0).show();
            AppMethodBeat.m2505o(41647);
            return true;
        } else {
            AppMethodBeat.m2505o(41647);
            return false;
        }
    }

    /* renamed from: cg */
    private void m56045cg(final String str, final int i) {
        AppMethodBeat.m2504i(41648);
        this.msG = false;
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI$4$1 */
            class C280571 implements OnClickListener {
                C280571() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(41635);
                    C24143a.m37113b(FingerPrintAuthUI.this, new Bundle(), i);
                    AppMethodBeat.m2505o(41635);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(41636);
                C30379h.m48447a(FingerPrintAuthUI.this, str, "", FingerPrintAuthUI.this.getString(C25738R.string.ffp), false, new C280571());
                AppMethodBeat.m2505o(41636);
            }
        });
        AppMethodBeat.m2505o(41648);
    }

    public final int getLayoutId() {
        return 2130969561;
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: aC */
    public final void mo7375aC(int i, String str) {
        AppMethodBeat.m2504i(41649);
        if (i == 0) {
            C4990ab.m7416i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
            mo39970a(new C35475y(null, 19), false, false);
            AppMethodBeat.m2505o(41649);
            return;
        }
        mo54762fE(false);
        C4990ab.m7412e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
        C30379h.m48438a((Context) this, getString(C25738R.string.bv_), "", new C207685());
        AppMethodBeat.m2505o(41649);
    }

    /* renamed from: a */
    static /* synthetic */ void m56039a(FingerPrintAuthUI fingerPrintAuthUI) {
        AppMethodBeat.m2504i(41651);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthUI.msy > 1) {
            fingerPrintAuthUI.msy = currentTimeMillis;
            fingerPrintAuthUI.msD.setText(C25738R.string.bv3);
            fingerPrintAuthUI.msD.setTextColor(fingerPrintAuthUI.getResources().getColor(C25738R.color.f12266xy));
            fingerPrintAuthUI.msD.setVisibility(4);
            if (fingerPrintAuthUI.msx == null) {
                fingerPrintAuthUI.msx = AnimationUtils.loadAnimation(fingerPrintAuthUI.mController.ylL, C25738R.anim.f8334b7);
            }
            fingerPrintAuthUI.msD.startAnimation(fingerPrintAuthUI.msx);
            C5004al.m7442n(new C341843(), fingerPrintAuthUI.msx.getDuration());
            AppMethodBeat.m2505o(41651);
            return;
        }
        AppMethodBeat.m2505o(41651);
    }

    /* renamed from: c */
    static /* synthetic */ boolean m56044c(FingerPrintAuthUI fingerPrintAuthUI) {
        boolean z;
        AppMethodBeat.m2504i(41654);
        String str = "MicroMsg.FingerPrintAuthUI";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        if (fingerPrintAuthUI.isPaused) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (fingerPrintAuthUI.isPaused) {
            AppMethodBeat.m2505o(41654);
            return false;
        }
        AppMethodBeat.m2505o(41654);
        return true;
    }
}
