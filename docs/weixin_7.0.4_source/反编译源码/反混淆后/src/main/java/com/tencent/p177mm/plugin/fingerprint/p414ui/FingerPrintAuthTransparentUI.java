package com.tencent.p177mm.plugin.fingerprint.p414ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.fingerprint.C43094a;
import com.tencent.p177mm.plugin.fingerprint.p413b.C39086c;
import com.tencent.p177mm.plugin.fingerprint.p413b.C39088e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.pluginsdk.wallet.C14990c;
import com.tencent.p177mm.pluginsdk.wallet.C14992j;
import com.tencent.p177mm.pluginsdk.wallet.C30157a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.soter.p663a.p664g.C40994f;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI */
public class FingerPrintAuthTransparentUI extends WalletBaseUI implements C30157a {
    private C14990c mrx = new C119411();
    private int msA = 0;
    private boolean msB = false;
    private C15532i mst = null;
    Dialog msu;
    private C14992j msv = null;
    private int msw = -1;
    private Animation msx;
    private int msy = 0;
    private boolean msz = false;
    View view = null;

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI$7 */
    class C31327 implements OnClickListener {
        C31327() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41603);
            FingerPrintAuthTransparentUI.m19825c(FingerPrintAuthTransparentUI.this);
            AppMethodBeat.m2505o(41603);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI$8 */
    class C31338 implements OnClickListener {
        C31338() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41604);
            FingerPrintAuthTransparentUI.m19824b(FingerPrintAuthTransparentUI.this, false);
            AppMethodBeat.m2505o(41604);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI$12 */
    class C1193312 implements View.OnClickListener {
        C1193312() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41608);
            if (FingerPrintAuthTransparentUI.this.mst != null) {
                FingerPrintAuthTransparentUI.this.mst.cancel();
            }
            FingerPrintAuthTransparentUI.bxS();
            FingerPrintAuthTransparentUI.this.finish();
            AppMethodBeat.m2505o(41608);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI$5 */
    class C119345 implements OnClickListener {
        C119345() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41601);
            FingerPrintAuthTransparentUI.this.finish();
            AppMethodBeat.m2505o(41601);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI$13 */
    class C1193713 implements OnCancelListener {
        C1193713() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(41609);
            dialogInterface.dismiss();
            FingerPrintAuthTransparentUI.bxS();
            FingerPrintAuthTransparentUI.this.finish();
            AppMethodBeat.m2505o(41609);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI$11 */
    class C1193811 implements C30157a {
        C1193811() {
        }

        /* renamed from: aC */
        public final void mo7375aC(int i, String str) {
            AppMethodBeat.m2504i(41607);
            FingerPrintAuthTransparentUI.this.mo23783fE(false);
            if (i == 0) {
                C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
                FingerPrintAuthTransparentUI.m19826d(FingerPrintAuthTransparentUI.this);
                FingerPrintAuthTransparentUI.m19822a(FingerPrintAuthTransparentUI.this, false);
                AppMethodBeat.m2505o(41607);
                return;
            }
            FingerPrintAuthTransparentUI.m19821a(FingerPrintAuthTransparentUI.this, FingerPrintAuthTransparentUI.this.getString(C25738R.string.a98));
            AppMethodBeat.m2505o(41607);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI$4 */
    class C119394 implements OnClickListener {
        C119394() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41600);
            C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
            FingerPrintAuthTransparentUI.m19826d(FingerPrintAuthTransparentUI.this);
            FingerPrintAuthTransparentUI.m19822a(FingerPrintAuthTransparentUI.this, false);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(41600);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI$9 */
    class C119409 implements OnClickListener {
        C119409() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41605);
            FingerPrintAuthTransparentUI.m19825c(FingerPrintAuthTransparentUI.this);
            AppMethodBeat.m2505o(41605);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI$1 */
    class C119411 implements C14990c {
        C119411() {
        }

        /* renamed from: bJ */
        public final void mo7357bJ(int i, int i2) {
            AppMethodBeat.m2504i(41597);
            String string;
            switch (i) {
                case 0:
                    C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
                    FingerPrintAuthTransparentUI.this.msw = i2;
                    FingerPrintAuthTransparentUI.m19820a(FingerPrintAuthTransparentUI.this);
                    AppMethodBeat.m2505o(41597);
                    return;
                case 2001:
                    C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
                    AppMethodBeat.m2505o(41597);
                    return;
                case 2002:
                    C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                    FingerPrintAuthTransparentUI.m19823b(FingerPrintAuthTransparentUI.this);
                    FingerPrintAuthTransparentUI.m19822a(FingerPrintAuthTransparentUI.this, true);
                    AppMethodBeat.m2505o(41597);
                    return;
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                case 10308:
                    C4990ab.m7417i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", Integer.valueOf(i));
                    string = C4996ah.getContext().getString(C25738R.string.ere);
                    if (i == 10308) {
                        string = C4996ah.getContext().getString(C25738R.string.erf);
                        C46261a.m86639d(6, -1000223, -1, "too many trial");
                    } else {
                        C46261a.m86639d(1000, -1000223, i, "fingerprint error");
                    }
                    FingerPrintAuthTransparentUI.m19821a(FingerPrintAuthTransparentUI.this, string);
                    AppMethodBeat.m2505o(41597);
                    return;
                case 2009:
                    C4990ab.m7417i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", Integer.valueOf(i));
                    string = C4996ah.getContext().getString(C25738R.string.ere);
                    C46261a.m86639d(1000, -1000223, i, "fingerprint error");
                    C46261a.m86638EE(2);
                    FingerPrintAuthTransparentUI.m19821a(FingerPrintAuthTransparentUI.this, string);
                    break;
            }
            AppMethodBeat.m2505o(41597);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI$3 */
    class C119423 implements OnClickListener {
        C119423() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41599);
            C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
            dialogInterface.dismiss();
            FingerPrintAuthTransparentUI.this.finish();
            AppMethodBeat.m2505o(41599);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI$2 */
    class C119432 implements OnClickListener {
        C119432() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(41598);
            dialogInterface.dismiss();
            C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
            FingerPrintAuthTransparentUI.this.finish();
            AppMethodBeat.m2505o(41598);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FingerPrintAuthTransparentUI() {
        AppMethodBeat.m2504i(41610);
        AppMethodBeat.m2505o(41610);
    }

    static /* synthetic */ void bxS() {
        AppMethodBeat.m2504i(41631);
        FingerPrintAuthTransparentUI.bxQ();
        AppMethodBeat.m2505o(41631);
    }

    /* renamed from: c */
    static /* synthetic */ void m19825c(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        AppMethodBeat.m2504i(41628);
        fingerPrintAuthTransparentUI.bxR();
        AppMethodBeat.m2505o(41628);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41611);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
        if (!C39088e.bxs()) {
            C4990ab.m7412e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
            finish();
            AppMethodBeat.m2505o(41611);
        } else if (C1853r.m3831YM()) {
            C4990ab.m7412e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
            finish();
            AppMethodBeat.m2505o(41611);
        } else if (C39088e.bxG()) {
            C4990ab.m7412e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
            finish();
            AppMethodBeat.m2505o(41611);
        } else {
            C43094a.bwM();
            C43094a.bwN();
            if (C39086c.bxl()) {
                if (C1427q.etg.etr != 1) {
                    C4990ab.m7412e("MicroMsg.FingerPrintAuthTransparentUI", "hy: device config force to not support");
                    finish();
                }
                C22587ak cPI = C14241r.cPI();
                C43094a.bwM();
                C43094a.bwN();
                this.msv = C39086c.bxm();
                this.msB = C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, false);
                if (!cPI.cQg() || C39088e.bxG()) {
                    C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + cPI.cQg() + ";isOpenTouch:" + C39088e.bxG());
                    C4990ab.m7412e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
                    finish();
                    AppMethodBeat.m2505o(41611);
                    return;
                }
                C4990ab.m7412e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
                C40994f.dRn().dRo();
                C7060h.pYm.mo8381e(12924, Integer.valueOf(1));
                C46261a.m86635EB(0);
                if (!getIntent().getBooleanExtra("key_show_guide", true)) {
                    bxR();
                    AppMethodBeat.m2505o(41611);
                    return;
                } else if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_FINGER_PRINT_IS_FIRST_SHOWN_BOOLEAN_SYNC, true)) {
                    String string;
                    C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_IS_FIRST_SHOWN_BOOLEAN_SYNC, Boolean.FALSE);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, Boolean.FALSE);
                    if (this.msB) {
                        string = getString(C25738R.string.c_6);
                    } else {
                        string = getString(C25738R.string.c_5);
                    }
                    C30379h.m48445a((Context) this, string, "", getString(C25738R.string.abi), getString(C25738R.string.f9076or), false, new C31327(), new C31338());
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC, Integer.valueOf(1));
                    this.msA = 1;
                    C46261a.m86641fG(1, this.msA);
                    AppMethodBeat.m2505o(41611);
                    return;
                } else {
                    C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
                    View inflate = LayoutInflater.from(this).inflate(2130969563, null);
                    final CheckBox checkBox = (CheckBox) inflate.findViewById(2131824049);
                    this.msA = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC, null)).intValue() + 1;
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC, Integer.valueOf(this.msA));
                    C46261a.m86641fG(1, this.msA);
                    C30379h.m48451a((Context) this, false, null, inflate, getString(C25738R.string.abi), getString(C25738R.string.f9076or), new C119409(), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(41606);
                            FingerPrintAuthTransparentUI.m19824b(FingerPrintAuthTransparentUI.this, checkBox.isChecked());
                            AppMethodBeat.m2505o(41606);
                        }
                    });
                    AppMethodBeat.m2505o(41611);
                    return;
                }
            }
            C4990ab.m7412e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
            finish();
            AppMethodBeat.m2505o(41611);
        }
    }

    public void onResume() {
        AppMethodBeat.m2504i(41612);
        super.onResume();
        if (this.msz) {
            m19828hw(false);
        }
        AppMethodBeat.m2505o(41612);
    }

    public void onPause() {
        AppMethodBeat.m2504i(41613);
        super.onPause();
        C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
        WakeLock newWakeLock = ((PowerManager) this.mController.ylL.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        FingerPrintAuthTransparentUI.bxQ();
        if (newWakeLock != null) {
            newWakeLock.release();
        }
        AppMethodBeat.m2505o(41613);
    }

    public void onStop() {
        AppMethodBeat.m2504i(41614);
        super.onStop();
        finish();
        AppMethodBeat.m2505o(41614);
    }

    /* renamed from: hw */
    private void m19828hw(boolean z) {
        AppMethodBeat.m2504i(41615);
        C43094a.bwM();
        C43094a.bwN();
        C39086c.abort();
        C39086c.release();
        if (C39086c.bxl()) {
            if (C39086c.m66508a(this.mrx, z) != 0) {
                C4990ab.m7412e("MicroMsg.FingerPrintAuthTransparentUI", "startFingerprintAuth failed!");
            }
            AppMethodBeat.m2505o(41615);
            return;
        }
        C4990ab.m7412e("MicroMsg.FingerPrintAuthTransparentUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
        AppMethodBeat.m2505o(41615);
    }

    private static void bxQ() {
        AppMethodBeat.m2504i(41616);
        C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
        C43094a.bwM();
        if (C43094a.bwN() != null) {
            C39086c.bxk();
        }
        AppMethodBeat.m2505o(41616);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41617);
        boolean c = this.msv.mo27385c(i, i2, str, c1207m);
        AppMethodBeat.m2505o(41617);
        return c;
    }

    public final int getLayoutId() {
        return -1;
    }

    private void bxR() {
        AppMethodBeat.m2504i(41618);
        C46261a.m86641fG(3, this.msA);
        Intent intent = getIntent();
        String str = "";
        if (intent != null) {
            str = intent.getStringExtra("key_pwd1");
        }
        this.msv.mo27383a((Context) this, new C1193811(), str);
        mo23783fE(true);
        if (this.mst != null && this.mst.isShowing()) {
            this.mst.dismiss();
        }
        AppMethodBeat.m2505o(41618);
    }

    public void finish() {
        AppMethodBeat.m2504i(41619);
        if (this.msv != null) {
            this.msv.clear();
        }
        super.finish();
        AppMethodBeat.m2505o(41619);
    }

    /* renamed from: Mm */
    private void m19818Mm(String str) {
        String string;
        AppMethodBeat.m2504i(41620);
        if (TextUtils.isEmpty(str)) {
            string = getString(-1);
        } else {
            string = str;
        }
        C30379h.m48447a((Context) this, string, "", getString(C25738R.string.ffp), false, new C119423());
        AppMethodBeat.m2505o(41620);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: fE */
    public final void mo23783fE(boolean z) {
        AppMethodBeat.m2504i(41621);
        if (z) {
            this.msu = C30901g.m49317a((Context) this, false, null);
            AppMethodBeat.m2505o(41621);
            return;
        }
        if (this.msu != null && this.msu.isShowing()) {
            this.msu.dismiss();
            this.msu = null;
        }
        AppMethodBeat.m2505o(41621);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41622);
        if (this.mst != null && this.mst.isShowing()) {
            this.mst.dismiss();
            this.mst = null;
        }
        if (this.msx != null) {
            this.msx.cancel();
        }
        mo23783fE(false);
        super.onDestroy();
        AppMethodBeat.m2505o(41622);
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: aC */
    public final void mo7375aC(int i, String str) {
        AppMethodBeat.m2504i(41623);
        mo23783fE(false);
        if (i == 0) {
            C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
            mo39970a(new C35475y(null, 19), false, false);
            C30379h.m48447a((Context) this, getString(C25738R.string.bvc), getString(C25738R.string.bv9), getString(C25738R.string.fnj), false, new C119432());
            AppMethodBeat.m2505o(41623);
        } else if (i == -2) {
            String string;
            C4990ab.m7412e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
            if (TextUtils.isEmpty(str)) {
                string = getString(C25738R.string.bv_);
            } else {
                string = str;
            }
            C30379h.m48445a((Context) this, string, "", getString(C25738R.string.bvh), getString(C25738R.string.f9076or), false, new C119394(), new C119345());
            AppMethodBeat.m2505o(41623);
        } else {
            m19818Mm(str);
            AppMethodBeat.m2505o(41623);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m19820a(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        AppMethodBeat.m2504i(41624);
        fingerPrintAuthTransparentUI.msz = false;
        C43094a.bwM();
        C43094a.bwN();
        C39086c.release();
        fingerPrintAuthTransparentUI.mst.dismiss();
        fingerPrintAuthTransparentUI.msv.mo27384a((C30157a) fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.msw, 2);
        AppMethodBeat.m2505o(41624);
    }

    /* renamed from: b */
    static /* synthetic */ void m19823b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        AppMethodBeat.m2504i(41625);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthTransparentUI.msy > 1) {
            fingerPrintAuthTransparentUI.msy = currentTimeMillis;
            ((TextView) fingerPrintAuthTransparentUI.view.findViewById(2131820972)).setVisibility(8);
            final TextView textView = (TextView) fingerPrintAuthTransparentUI.view.findViewById(2131824041);
            textView.setVisibility(4);
            if (fingerPrintAuthTransparentUI.msx == null) {
                fingerPrintAuthTransparentUI.msx = AnimationUtils.loadAnimation(fingerPrintAuthTransparentUI.mController.ylL, C25738R.anim.f8334b7);
            }
            textView.startAnimation(fingerPrintAuthTransparentUI.msx);
            C5004al.m7442n(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(41602);
                    textView.setVisibility(0);
                    AppMethodBeat.m2505o(41602);
                }
            }, fingerPrintAuthTransparentUI.msx.getDuration());
            AppMethodBeat.m2505o(41625);
            return;
        }
        AppMethodBeat.m2505o(41625);
    }

    /* renamed from: b */
    static /* synthetic */ void m19824b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI, boolean z) {
        AppMethodBeat.m2504i(41629);
        C46261a.m86641fG(2, fingerPrintAuthTransparentUI.msA);
        if (z) {
            C46261a.m86639d(10, -1000223, -1, "user permanent cancelled");
            C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled and checked as not show anymore");
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.TRUE);
        } else {
            C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled but will show again");
            C46261a.m86639d(1, -1000223, -1, "user cancelled");
        }
        fingerPrintAuthTransparentUI.finish();
        AppMethodBeat.m2505o(41629);
    }

    /* renamed from: d */
    static /* synthetic */ void m19826d(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        ViewGroup viewGroup;
        AppMethodBeat.m2504i(41630);
        C4990ab.m7416i("MicroMsg.FingerPrintAuthTransparentUI", "showIdentifyUI!");
        fingerPrintAuthTransparentUI.view = LayoutInflater.from(fingerPrintAuthTransparentUI).inflate(2130969560, null);
        ViewParent parent = fingerPrintAuthTransparentUI.view.getParent();
        if (parent != null) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ((ImageView) fingerPrintAuthTransparentUI.view.findViewById(2131824040)).setOnClickListener(new C1193312());
        if (fingerPrintAuthTransparentUI.mst != null && fingerPrintAuthTransparentUI.mst.isShowing()) {
            fingerPrintAuthTransparentUI.mst.dismiss();
            fingerPrintAuthTransparentUI.mst = null;
        }
        fingerPrintAuthTransparentUI.mst = new C15532i(fingerPrintAuthTransparentUI, C25738R.style.f11418zw);
        fingerPrintAuthTransparentUI.mst.setContentView(fingerPrintAuthTransparentUI.view);
        fingerPrintAuthTransparentUI.mst.setCanceledOnTouchOutside(false);
        fingerPrintAuthTransparentUI.mst.setCancelable(true);
        fingerPrintAuthTransparentUI.mst.show();
        fingerPrintAuthTransparentUI.mst.setOnCancelListener(new C1193713());
        C30379h.m48455a(fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.mst);
        AppMethodBeat.m2505o(41630);
    }
}
