package com.tencent.p177mm.plugin.walletlock.fingerprint.p1058ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p232b.p233a.C42088bj;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a.C14373a;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a.C14374c;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a.C40174h;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a.C40174h.C227211;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a.C40174h.C227222;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a.C43834d;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a.C43834d.C29713a;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C46391e;
import com.tencent.p177mm.plugin.walletlock.gesture.p751ui.GestureGuardLogicUI;
import com.tencent.p177mm.plugin.walletlock.p1319c.C40171g;
import com.tencent.p177mm.plugin.walletlock.p1319c.C40172i;
import com.tencent.p177mm.plugin.walletlock.p1319c.C43833b;
import com.tencent.p177mm.plugin.walletlock.p1319c.C46388h;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C30973j;
import com.tencent.soter.p663a.C30954a;
import com.tencent.soter.p663a.p1105a.C40985a;
import com.tencent.soter.p663a.p1105a.C40986b;
import com.tencent.soter.p663a.p664g.C24298b;
import com.tencent.soter.p663a.p664g.C24298b.C5823a;
import com.tencent.soter.p663a.p664g.C40994f;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI */
public class FingerprintWalletLockUI extends MMActivity {
    /* renamed from: JU */
    private String f2953JU;
    private String gHr = null;
    private String gtl;
    private C5653c hSs = null;
    private boolean isCancelled = false;
    private TextView juY;
    private ProgressDialog kvA = null;
    private int msy = 0;
    private boolean ozH = true;
    private boolean tVe = false;
    private TextView tVl;
    private TextView tVm;
    private TextView tVn;
    private Animation tVo;
    private String tVp;
    private String tVq;
    private C43834d tVr;
    private C40174h tVs;
    private C43833b tVt;
    private String tVu = "-1";
    private int tVv = -1;
    private int tVw = -1;

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$6 */
    class C143776 implements C29713a {
        C143776() {
        }

        /* renamed from: aC */
        public final void mo26641aC(int i, String str) {
            AppMethodBeat.m2504i(51503);
            C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo open fingerprint lock onFinish errCode: %d, errMsg: %s", Integer.valueOf(i), str);
            if (i == 0) {
                FingerprintWalletLockUI.m22614k(FingerprintWalletLockUI.this);
                AppMethodBeat.m2505o(51503);
                return;
            }
            FingerprintWalletLockUI.m22604b(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(C25738R.string.fh5));
            AppMethodBeat.m2505o(51503);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$10 */
    class C1437810 implements C29713a {
        C1437810() {
        }

        /* renamed from: aC */
        public final void mo26641aC(int i, String str) {
            AppMethodBeat.m2504i(51507);
            C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "prepare onFinish errCode: %d, errMsg: %s, time: %d", Integer.valueOf(i), str, Long.valueOf(System.currentTimeMillis()));
            if (FingerprintWalletLockUI.this.isCancelled) {
                C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo has cancelled and return");
                AppMethodBeat.m2505o(51507);
            } else if (i == 0) {
                FingerprintWalletLockUI.m22611h(FingerprintWalletLockUI.this);
                AppMethodBeat.m2505o(51507);
            } else {
                FingerprintWalletLockUI.m22604b(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(C25738R.string.fh4));
                AppMethodBeat.m2505o(51507);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$11 */
    class C1437911 implements OnClickListener {
        C1437911() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(51508);
            C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo click negative button");
            AppMethodBeat.m2505o(51508);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$12 */
    class C1438012 implements OnClickListener {
        C1438012() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(51509);
            FingerprintWalletLockUI.m22612i(FingerprintWalletLockUI.this);
            AppMethodBeat.m2505o(51509);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$4 */
    class C143814 implements OnClickListener {
        C143814() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(51501);
            FingerprintWalletLockUI.this.finish();
            AppMethodBeat.m2505o(51501);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$13 */
    class C1438213 implements OnClickListener {
        C1438213() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(51510);
            FingerprintWalletLockUI.this.finish();
            FingerprintWalletLockUI.cTw();
            AppMethodBeat.m2505o(51510);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$3 */
    class C143833 implements Runnable {
        C143833() {
        }

        public final void run() {
            AppMethodBeat.m2504i(51500);
            FingerprintWalletLockUI.this.finish();
            AppMethodBeat.m2505o(51500);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$5 */
    class C143845 implements Runnable {
        C143845() {
        }

        public final void run() {
            AppMethodBeat.m2504i(51502);
            FingerprintWalletLockUI.this.tVl.setVisibility(0);
            AppMethodBeat.m2505o(51502);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$a */
    public class C14385a implements C43833b {
        private WeakReference<FingerprintWalletLockUI> msL = null;

        public C14385a(FingerprintWalletLockUI fingerprintWalletLockUI) {
            AppMethodBeat.m2504i(51513);
            this.msL = new WeakReference(fingerprintWalletLockUI);
            AppMethodBeat.m2505o(51513);
        }

        private FingerprintWalletLockUI cTx() {
            AppMethodBeat.m2504i(51514);
            if (this.msL != null) {
                FingerprintWalletLockUI fingerprintWalletLockUI = (FingerprintWalletLockUI) this.msL.get();
                AppMethodBeat.m2505o(51514);
                return fingerprintWalletLockUI;
            }
            AppMethodBeat.m2505o(51514);
            return null;
        }

        public final void cTy() {
            AppMethodBeat.m2504i(51515);
            FingerprintWalletLockUI.m22599a(FingerprintWalletLockUI.this);
            FingerprintWalletLockUI.m22602b(FingerprintWalletLockUI.this);
            AppMethodBeat.m2505o(51515);
        }

        /* renamed from: T */
        public final void mo26648T(int i, String str) {
            C42088bj c42088bj;
            AppMethodBeat.m2504i(51516);
            C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", Integer.valueOf(i), str, Boolean.valueOf(FingerprintWalletLockUI.this.isCancelled));
            if (FingerprintWalletLockUI.this.f2953JU != null && FingerprintWalletLockUI.this.f2953JU.equals("action.switch_on_pattern")) {
                c42088bj = new C42088bj();
                c42088bj.cVT = 3;
                c42088bj.dcm = 1;
                c42088bj.ajK();
            }
            if (FingerprintWalletLockUI.this.f2953JU != null && FingerprintWalletLockUI.this.f2953JU.equals("action.verify_pattern")) {
                if (FingerprintWalletLockUI.this.tVw == 1) {
                    c42088bj = new C42088bj();
                    c42088bj.cVT = 7;
                    c42088bj.dcm = 1;
                    c42088bj.ajK();
                } else if (FingerprintWalletLockUI.this.tVw == 2) {
                    c42088bj = new C42088bj();
                    c42088bj.cVT = 9;
                    c42088bj.dcm = 1;
                    c42088bj.ajK();
                }
            }
            if (FingerprintWalletLockUI.this.isCancelled) {
                AppMethodBeat.m2505o(51516);
                return;
            }
            switch (i) {
                case 0:
                    C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "identify success");
                    if (cTx() != null) {
                        FingerprintWalletLockUI.m22609f(cTx());
                    }
                    if (FingerprintWalletLockUI.this.f2953JU != null && FingerprintWalletLockUI.this.f2953JU.equals("action.switch_on_pattern")) {
                        c42088bj = new C42088bj();
                        c42088bj.cVT = 3;
                        c42088bj.dcm = 2;
                        c42088bj.ajK();
                    }
                    if (FingerprintWalletLockUI.this.f2953JU != null && FingerprintWalletLockUI.this.f2953JU.equals("action.verify_pattern")) {
                        if (FingerprintWalletLockUI.this.tVw == 1) {
                            c42088bj = new C42088bj();
                            c42088bj.cVT = 7;
                            c42088bj.dcm = 2;
                            c42088bj.ajK();
                            AppMethodBeat.m2505o(51516);
                            return;
                        } else if (FingerprintWalletLockUI.this.tVw == 2) {
                            c42088bj = new C42088bj();
                            c42088bj.cVT = 9;
                            c42088bj.dcm = 2;
                            c42088bj.ajK();
                            AppMethodBeat.m2505o(51516);
                            return;
                        }
                    }
                    break;
                case 1:
                    C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
                    if (cTx() != null) {
                        FingerprintWalletLockUI.m22600a(cTx(), i, FingerprintWalletLockUI.this.getString(C25738R.string.fhb));
                        AppMethodBeat.m2505o(51516);
                        return;
                    }
                    break;
                case 2:
                    if (cTx() != null) {
                        FingerprintWalletLockUI.m22603b(cTx(), i, FingerprintWalletLockUI.this.getString(C25738R.string.fh4));
                        AppMethodBeat.m2505o(51516);
                        return;
                    }
                    break;
                case 3:
                    C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", Integer.valueOf(i));
                    if (cTx() != null) {
                        FingerprintWalletLockUI.m22603b(cTx(), i, FingerprintWalletLockUI.this.getString(C25738R.string.fha));
                        break;
                    }
                    break;
                case 4:
                    C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
                    AppMethodBeat.m2505o(51516);
                    return;
                case 5:
                    C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
                    if (cTx() != null) {
                        FingerprintWalletLockUI.m22600a(cTx(), i, FingerprintWalletLockUI.this.getString(C25738R.string.fhb));
                        AppMethodBeat.m2505o(51516);
                        return;
                    }
                    break;
                case 8:
                    if (cTx() != null) {
                        FingerprintWalletLockUI.m22603b(cTx(), i, FingerprintWalletLockUI.this.getString(C25738R.string.fhk));
                        AppMethodBeat.m2505o(51516);
                        return;
                    }
                    break;
            }
            AppMethodBeat.m2505o(51516);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$1 */
    class C143861 implements View.OnClickListener {
        C143861() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(51498);
            FingerprintWalletLockUI.m22610g(FingerprintWalletLockUI.this);
            AppMethodBeat.m2505o(51498);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$14 */
    class C1438714 implements OnCancelListener {
        C1438714() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(51511);
            C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
            FingerprintWalletLockUI.this.finish();
            FingerprintWalletLockUI.cTw();
            AppMethodBeat.m2505o(51511);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$2 */
    class C143882 implements OnClickListener {
        C143882() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(51499);
            C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
            ((C40167b) C1720g.m3528K(C40167b.class)).mo38296i(FingerprintWalletLockUI.this, 5);
            AppMethodBeat.m2505o(51499);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$9 */
    class C143899 implements View.OnClickListener {
        C143899() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(51506);
            FingerprintWalletLockUI.m22610g(FingerprintWalletLockUI.this);
            AppMethodBeat.m2505o(51506);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$7 */
    class C143907 implements Runnable {
        C143907() {
        }

        public final void run() {
            AppMethodBeat.m2504i(51504);
            C14373a.cTm();
            C14373a.ado(FingerprintWalletLockUI.this.tVu);
            C14373a.m22586lK(-1);
            C40171g c40171g = C40171g.tWY;
            C40171g.cTW();
            AppMethodBeat.m2505o(51504);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$8 */
    class C143918 implements View.OnClickListener {
        C143918() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(51505);
            FingerprintWalletLockUI.cTw();
            FingerprintWalletLockUI.m22601a(FingerprintWalletLockUI.this, "user cancel setting fingerprint lock");
            AppMethodBeat.m2505o(51505);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI$15 */
    class C1439215 implements OnClickListener {
        C1439215() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(51512);
            C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
            ((C40167b) C1720g.m3528K(C40167b.class)).mo38289b(FingerprintWalletLockUI.this, 1, 4);
            AppMethodBeat.m2505o(51512);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m22599a(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.m2504i(51535);
        fingerprintWalletLockUI.aDw();
        AppMethodBeat.m2505o(51535);
    }

    /* renamed from: a */
    static /* synthetic */ void m22601a(FingerprintWalletLockUI fingerprintWalletLockUI, String str) {
        AppMethodBeat.m2504i(51542);
        fingerprintWalletLockUI.m22605bv(4, str);
        AppMethodBeat.m2505o(51542);
    }

    /* renamed from: b */
    static /* synthetic */ void m22602b(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.m2504i(51536);
        fingerprintWalletLockUI.cTs();
        AppMethodBeat.m2505o(51536);
    }

    /* renamed from: b */
    static /* synthetic */ void m22604b(FingerprintWalletLockUI fingerprintWalletLockUI, String str) {
        AppMethodBeat.m2504i(51544);
        fingerprintWalletLockUI.m22596Dv(str);
        AppMethodBeat.m2505o(51544);
    }

    /* renamed from: g */
    static /* synthetic */ void m22610g(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.m2504i(51540);
        fingerprintWalletLockUI.m22597HC(1);
        AppMethodBeat.m2505o(51540);
    }

    /* renamed from: h */
    static /* synthetic */ void m22611h(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.m2504i(51543);
        fingerprintWalletLockUI.cTu();
        AppMethodBeat.m2505o(51543);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(51517);
        super.onCreate(bundle);
        C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", Long.valueOf(System.currentTimeMillis()));
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
        Intent intent = getIntent();
        this.f2953JU = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        this.tVq = this.f2953JU;
        this.tVp = intent.getStringExtra("next_action");
        this.gtl = intent.getStringExtra("token");
        this.gHr = intent.getStringExtra("key_pay_passwd");
        this.tVw = intent.getIntExtra("scene", -1);
        C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", this.f2953JU, this.tVp);
        if (this.f2953JU.equals("action.verify_pattern")) {
            this.tVv = 2;
            C46388h.cUc();
            AppMethodBeat.m2505o(51517);
            return;
        }
        if (this.f2953JU.equals("action.switch_on_pattern")) {
            this.tVv = 1;
        }
        AppMethodBeat.m2505o(51517);
    }

    public void onResume() {
        AppMethodBeat.m2504i(51518);
        super.onResume();
        C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", Boolean.valueOf(this.ozH));
        if (this.ozH) {
            this.tVr = new C14374c();
            this.tVs = new C40174h();
            this.isCancelled = false;
            C40994f.dRn().dRo();
            this.kvA = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), false, null);
            cTs();
            if (this.f2953JU.equals("action.switch_on_pattern")) {
                this.tVe = false;
            } else {
                this.tVe = true;
            }
            C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.tVe));
            C40171g c40171g = C40171g.tWY;
            boolean cTY = C40171g.cTY();
            C40171g c40171g2 = C40171g.tWY;
            if (C40171g.cTn() && !cTY) {
                C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", Boolean.valueOf(cTY));
                if (C46391e.cTz()) {
                    C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
                    ((C40167b) C1720g.m3528K(C40167b.class)).mo38285HB(1);
                    c40171g = C40171g.tWY;
                    C40171g.cTW();
                    finish();
                    Intent intent = new Intent(this, GestureGuardLogicUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
                    intent.setPackage(C4996ah.getPackageName());
                    if (!C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, false)) {
                        intent.putExtra("verify_title", getString(C25738R.string.fhq));
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, Boolean.TRUE);
                        C1720g.m3536RP().mo5239Ry().dsb();
                    }
                    C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", Boolean.valueOf(r1));
                    startActivity(intent);
                    C7060h.pYm.mo8381e(12097, Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                } else {
                    C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
                    aDw();
                    this.hSs = new C5652a(this).mo11450PZ(C25738R.string.fhl).mo11453Qc(C25738R.string.fhp).mo11457a(new C1439215()).mo11478f(new C1438714()).aMb();
                    this.hSs.setCanceledOnTouchOutside(false);
                    this.hSs.mo11491b(getString(C25738R.string.fgy), false, new C143882());
                    this.hSs.show();
                }
            } else if (C40997a.m71099iR(this)) {
                Bundle bundle = new Bundle();
                bundle.putString("key_pay_passwd", this.gHr);
                bundle.putBoolean("key_fp_lock_offline_mode", this.tVe);
                this.tVr.mo26638a(new C1437810(), bundle);
            } else {
                cTt();
            }
            C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.m2505o(51518);
            return;
        }
        AppMethodBeat.m2505o(51518);
    }

    public void onPause() {
        AppMethodBeat.m2504i(51519);
        super.onPause();
        C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
        dismissDialog();
        release();
        this.ozH = true;
        AppMethodBeat.m2505o(51519);
    }

    public final void initView() {
        AppMethodBeat.m2504i(51520);
        super.initView();
        this.tVl = (TextView) findViewById(2131824062);
        this.tVm = (TextView) findViewById(2131824063);
        this.juY = (TextView) findViewById(2131824059);
        this.tVn = (TextView) findViewById(2131824060);
        this.tVm.setOnClickListener(new C143861());
        this.juY.setOnClickListener(new C143918());
        this.tVn.setOnClickListener(new C143899());
        AppMethodBeat.m2505o(51520);
    }

    private void cTs() {
        AppMethodBeat.m2504i(51521);
        if (this.f2953JU.equals("action.verify_pattern")) {
            this.tVl.setText(C25738R.string.fhd);
            this.tVl.setTextColor(getResources().getColor(C25738R.color.f12212w4));
            this.tVn.setVisibility(0);
            AppMethodBeat.m2505o(51521);
            return;
        }
        this.tVl.setText(C25738R.string.fh7);
        this.tVl.setTextColor(getResources().getColor(C25738R.color.f12212w4));
        this.tVn.setVisibility(8);
        AppMethodBeat.m2505o(51521);
    }

    public final int getLayoutId() {
        return 2130969566;
    }

    private void cTt() {
        AppMethodBeat.m2504i(51522);
        aDw();
        C5652a c5652a = new C5652a(this);
        C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", Integer.valueOf(this.tVv));
        if (this.tVv == 2) {
            c5652a.mo11450PZ(C25738R.string.fhk).mo11453Qc(C25738R.string.fho).mo11457a(new C1438012()).mo11454Qd(C25738R.string.f9076or).mo11476b(new C1437911());
        } else {
            c5652a.mo11450PZ(C25738R.string.fhj).asJ(getString(C25738R.string.f9187s6)).mo11457a(new C1438213());
        }
        this.hSs = c5652a.aMb();
        this.hSs.setCanceledOnTouchOutside(false);
        this.hSs.show();
        AppMethodBeat.m2505o(51522);
    }

    private void dismissDialog() {
        AppMethodBeat.m2504i(51523);
        aDw();
        if (this.hSs != null && this.hSs.isShowing()) {
            this.hSs.dismiss();
        }
        AppMethodBeat.m2505o(51523);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(51524);
        C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
        finish();
        C40172i.tXc.cUg();
        AppMethodBeat.m2505o(51524);
    }

    private void cTu() {
        AppMethodBeat.m2504i(51525);
        C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", this.tVq);
        if (C5046bo.isNullOrNil(this.tVq)) {
            finish();
            AppMethodBeat.m2505o(51525);
            return;
        }
        String str = this.tVq;
        boolean z = true;
        switch (str.hashCode()) {
            case -1423990800:
                if (str.equals("next_action.goto_protected_page")) {
                    z = true;
                    break;
                }
                break;
            case -1305462654:
                if (str.equals("action.verify_pattern")) {
                    z = true;
                    break;
                }
                break;
            case -639789777:
                if (str.equals("next_action.switch_on_pattern")) {
                    z = true;
                    break;
                }
                break;
            case 1420518755:
                if (str.equals("action.switch_on_pattern")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
                this.tVt = new C14385a(this);
                this.tVu = "-1";
                if (this.tVs == null) {
                    this.tVs = new C40174h();
                }
                C40174h c40174h = this.tVs;
                C43833b c43833b = this.tVt;
                C40986b c227211 = new C227211(c43833b);
                c40174h.tVi = new C40985a();
                C24298b c24298b = new C5823a().mo12217iW(this).mo12211Rk(1).mo12212a(c40174h.tVi).mo12213a(c227211).aug(C40171g.tWY.tWZ).mo12210Rj(3).Awk;
                C40171g.tWY.tXa = null;
                C4990ab.m7416i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
                C30954a.m49585a(new C227222(c43833b), c24298b);
                AppMethodBeat.m2505o(51525);
                return;
            case true:
                C30973j c30973j = C40171g.tWY.tXa;
                if (c30973j == null) {
                    m22596Dv(getString(C25738R.string.fh9));
                    AppMethodBeat.m2505o(51525);
                    return;
                }
                String str2 = c30973j.Avx;
                String str3 = c30973j.signature;
                if (this.tVr != null) {
                    this.kvA = C30379h.m48458b((Context) this, getString(C25738R.string.fhf), false, null);
                    this.tVr.mo26639a(new C143776(), this.gtl, str2, str3);
                }
                AppMethodBeat.m2505o(51525);
                return;
            case true:
                C14373a.m22586lK(SystemClock.elapsedRealtime());
                cTv();
                break;
        }
        AppMethodBeat.m2505o(51525);
    }

    private void cTv() {
        AppMethodBeat.m2504i(51526);
        this.ozH = false;
        C5004al.m7442n(new C143833(), 200);
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
            C40172i.tXc.mo63515nB(true);
            C40172i.tXc.mo63516nC(true);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            startActivity(intent);
            overridePendingTransition(C25738R.anim.f8401db, C25738R.anim.f8404dg);
            AppMethodBeat.m2505o(51526);
            return;
        }
        C4990ab.m7416i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
        AppMethodBeat.m2505o(51526);
    }

    /* renamed from: HC */
    private void m22597HC(int i) {
        AppMethodBeat.m2504i(51527);
        Intent intent = new Intent();
        if (i == 1) {
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.touchlock_verify_by_paypwd");
        } else if (i == 2) {
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.touchlock_need_verify_paypwd");
            intent.putExtra("key_wallet_lock_input_new_fp_tips", getString(C25738R.string.fhi));
        }
        intent.putExtra("key_wallet_lock_type", 2);
        C25985d.m41468b((Context) this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i);
        AppMethodBeat.m2505o(51527);
    }

    private void aDw() {
        AppMethodBeat.m2504i(51528);
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
        }
        AppMethodBeat.m2505o(51528);
    }

    /* renamed from: JN */
    private void m22598JN(String str) {
        AppMethodBeat.m2504i(51529);
        if (C5046bo.isNullOrNil(str)) {
            str = getString(C25738R.string.fhc);
        }
        dismissDialog();
        this.hSs = C30379h.m48438a((Context) this, str, "", new C143814());
        this.hSs.setCanceledOnTouchOutside(false);
        AppMethodBeat.m2505o(51529);
    }

    /* renamed from: Dv */
    private void m22596Dv(String str) {
        AppMethodBeat.m2504i(51530);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - this.msy > 1) {
            this.msy = currentTimeMillis;
            dismissDialog();
            if (this.tVl != null) {
                this.tVl.setText(str);
                this.tVl.setTextColor(getResources().getColor(C25738R.color.f12266xy));
                this.tVl.setVisibility(4);
                if (this.tVo == null) {
                    this.tVo = AnimationUtils.loadAnimation(this.mController.ylL, C25738R.anim.f8335b8);
                }
                this.tVl.startAnimation(this.tVo);
                C5004al.m7442n(new C143845(), this.tVo.getDuration());
            }
            AppMethodBeat.m2505o(51530);
            return;
        }
        AppMethodBeat.m2505o(51530);
    }

    private void release() {
        AppMethodBeat.m2504i(51531);
        C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", Boolean.valueOf(this.isCancelled));
        if (this.isCancelled) {
            AppMethodBeat.m2505o(51531);
            return;
        }
        this.isCancelled = true;
        if (this.tVs != null) {
            this.tVs.release();
        }
        if (this.tVr != null) {
            this.tVr.release();
        }
        C40994f.dRn().dRo();
        AppMethodBeat.m2505o(51531);
    }

    /* renamed from: bv */
    private void m22605bv(int i, String str) {
        AppMethodBeat.m2504i(51532);
        C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", Integer.valueOf(-1), Integer.valueOf(i), str);
        release();
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i);
        intent.putExtra("key_err_msg", str);
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(51532);
    }

    public void finish() {
        AppMethodBeat.m2504i(51533);
        super.finish();
        release();
        AppMethodBeat.m2505o(51533);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(51534);
        C4990ab.m7419v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
            AppMethodBeat.m2505o(51534);
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", -1);
        C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", Integer.valueOf(intExtra));
        if (i == 1) {
            if (intExtra == 0) {
                cTv();
                C46388h.cUa();
                AppMethodBeat.m2505o(51534);
                return;
            } else if (intExtra == -1) {
                this.ozH = false;
                m22598JN(getString(C25738R.string.fhs));
                AppMethodBeat.m2505o(51534);
                return;
            }
        } else if (i == 2) {
            if (intExtra == 0) {
                C14373a.ado(this.tVu);
                C14373a.m22586lK(SystemClock.elapsedRealtime());
                cTv();
                AppMethodBeat.m2505o(51534);
                return;
            } else if (intExtra == -1) {
                this.ozH = false;
                m22598JN(getString(C25738R.string.fhs));
                AppMethodBeat.m2505o(51534);
                return;
            }
        } else if (i == 3) {
            if (intExtra == 0) {
                cTv();
                AppMethodBeat.m2505o(51534);
                return;
            }
            finish();
            C40172i.tXc.cUg();
            AppMethodBeat.m2505o(51534);
            return;
        } else if (i == 4) {
            if (intExtra == 0) {
                cTv();
                AppMethodBeat.m2505o(51534);
                return;
            } else if (intExtra == -1) {
                this.ozH = false;
                m22598JN(getString(C25738R.string.fhg));
                AppMethodBeat.m2505o(51534);
                return;
            } else {
                finish();
                C40172i.tXc.cUg();
                AppMethodBeat.m2505o(51534);
                return;
            }
        } else if (i == 5) {
            if (intExtra == 0) {
                ((C40167b) C1720g.m3528K(C40167b.class)).mo38285HB(0);
                C40171g c40171g = C40171g.tWY;
                C40171g.cTq();
                Toast.makeText(this, getString(C25738R.string.fgz), 0).show();
                cTv();
                AppMethodBeat.m2505o(51534);
                return;
            } else if (intExtra == -1) {
                this.ozH = false;
                m22598JN(getString(C25738R.string.fh0));
                AppMethodBeat.m2505o(51534);
                return;
            } else if (intExtra == 4) {
                finish();
                C40172i.tXc.cUg();
            }
        }
        AppMethodBeat.m2505o(51534);
    }

    /* renamed from: f */
    static /* synthetic */ void m22609f(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.m2504i(51537);
        C46388h.m87250am(fingerprintWalletLockUI.tVw, 2, 0);
        C30973j c30973j = C40171g.tWY.tXa;
        if (c30973j != null) {
            fingerprintWalletLockUI.tVu = c30973j.Avq;
            C4990ab.m7419v("MicroMsg.FingerprintWalletLockUI", "alvinluo authSuccess and mFid: %s", fingerprintWalletLockUI.tVu);
            if (fingerprintWalletLockUI.tVq.equals("action.switch_on_pattern")) {
                fingerprintWalletLockUI.tVq = fingerprintWalletLockUI.tVp;
                fingerprintWalletLockUI.cTu();
                AppMethodBeat.m2505o(51537);
                return;
            } else if (fingerprintWalletLockUI.tVq.equals("action.verify_pattern")) {
                if (C14373a.adp(fingerprintWalletLockUI.tVu)) {
                    fingerprintWalletLockUI.tVq = fingerprintWalletLockUI.tVp;
                    fingerprintWalletLockUI.cTu();
                    AppMethodBeat.m2505o(51537);
                    return;
                }
                fingerprintWalletLockUI.m22597HC(2);
            }
        }
        AppMethodBeat.m2505o(51537);
    }

    /* renamed from: a */
    static /* synthetic */ void m22600a(FingerprintWalletLockUI fingerprintWalletLockUI, int i, String str) {
        AppMethodBeat.m2504i(51538);
        C4990ab.m7417i("MicroMsg.FingerprintWalletLockUI", "alvinluo onAuthenFailed errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        C46388h.m87250am(fingerprintWalletLockUI.tVw, 2, 1);
        fingerprintWalletLockUI.m22596Dv(str);
        AppMethodBeat.m2505o(51538);
    }

    /* renamed from: b */
    static /* synthetic */ void m22603b(FingerprintWalletLockUI fingerprintWalletLockUI, int i, String str) {
        AppMethodBeat.m2504i(51539);
        C4990ab.m7413e("MicroMsg.FingerprintWalletLockUI", "alvinluo onAuthenError errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        C14373a.cTq();
        fingerprintWalletLockUI.dismissDialog();
        if (i == 3) {
            C46388h.m87250am(fingerprintWalletLockUI.tVw, 2, 2);
            C14373a.m22585ac(System.currentTimeMillis(), 0);
            fingerprintWalletLockUI.tVl.setText(C25738R.string.fha);
            fingerprintWalletLockUI.tVl.setTextColor(fingerprintWalletLockUI.getResources().getColor(C25738R.color.f12266xy));
            AppMethodBeat.m2505o(51539);
        } else if (i == 8) {
            fingerprintWalletLockUI.cTt();
            AppMethodBeat.m2505o(51539);
        } else {
            fingerprintWalletLockUI.m22596Dv(str);
            AppMethodBeat.m2505o(51539);
        }
    }

    static /* synthetic */ void cTw() {
        AppMethodBeat.m2504i(51541);
        C40172i.tXc.cUg();
        AppMethodBeat.m2505o(51541);
    }

    /* renamed from: i */
    static /* synthetic */ void m22612i(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.m2504i(51545);
        Intent intent = new Intent();
        intent.putExtra("key_wallet_lock_setting_scene", 1);
        ((C40167b) C1720g.m3528K(C40167b.class)).mo38291b((Activity) fingerprintWalletLockUI, intent, 3);
        AppMethodBeat.m2505o(51545);
    }

    /* renamed from: k */
    static /* synthetic */ void m22614k(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.m2504i(51546);
        fingerprintWalletLockUI.dismissDialog();
        C5004al.m7441d(new C143907());
        Toast.makeText(fingerprintWalletLockUI, C25738R.string.fh6, 0).show();
        ((C40167b) C1720g.m3528K(C40167b.class)).mo38285HB(2);
        C40172i.tXc.cUf();
        fingerprintWalletLockUI.m22605bv(0, "open fingerprint lock ok");
        AppMethodBeat.m2505o(51546);
    }
}
