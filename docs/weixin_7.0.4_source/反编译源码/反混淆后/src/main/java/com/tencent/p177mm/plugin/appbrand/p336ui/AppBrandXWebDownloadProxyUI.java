package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.xweb.C16395k;
import com.tencent.xweb.C16403w;
import com.tencent.xweb.xwalk.C6060b;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI */
public final class AppBrandXWebDownloadProxyUI extends MMActivity {
    private static boolean iII = false;
    private Runnable iIH;
    private C6060b iJA = null;
    private Handler mHandler;
    C44275p tipDialog;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI$1 */
    class C108031 implements OnCancelListener {
        C108031() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(133170);
            C4990ab.m7416i("MicroMsg.AppBrandXWebDownloadProxyUI", "cancle loading download background");
            AppBrandXWebDownloadProxyUI.this.setResult(2, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133170);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI$2 */
    class C108042 implements Runnable {
        C108042() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133171);
            AppBrandXWebDownloadProxyUI.iII = true;
            AppBrandXWebDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133171);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI$3 */
    class C197593 implements OnCancelListener {
        C197593() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(133172);
            C4990ab.m7416i("MicroMsg.AppBrandXWebDownloadProxyUI", "cancle loading download background");
            AppBrandXWebDownloadProxyUI.this.setResult(2, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133172);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI$4 */
    class C197604 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI$4$1 */
        class C197611 implements OnCancelListener {
            C197611() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(133173);
                C4990ab.m7416i("MicroMsg.AppBrandXWebDownloadProxyUI", "cancel loading download background");
                AppBrandXWebDownloadProxyUI.this.setResult(2, new Intent());
                AppBrandXWebDownloadProxyUI.this.finish();
                AppMethodBeat.m2505o(133173);
            }
        }

        C197604() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(133174);
            C7060h.pYm.mo8378a(366, 2, 1, false);
            if (AppBrandXWebDownloadProxyUI.this.isFinishing() || AppBrandXWebDownloadProxyUI.this.uiu) {
                AppMethodBeat.m2505o(133174);
                return;
            }
            AppBrandXWebDownloadProxyUI appBrandXWebDownloadProxyUI = AppBrandXWebDownloadProxyUI.this;
            Context context = AppBrandXWebDownloadProxyUI.this.mController.ylL;
            AppBrandXWebDownloadProxyUI.this.mController.ylL.getString(C25738R.string.f9238tz);
            appBrandXWebDownloadProxyUI.tipDialog = C30379h.m48458b(context, AppBrandXWebDownloadProxyUI.this.mController.ylL.getString(C25738R.string.f9074op), true, null);
            AppBrandXWebDownloadProxyUI.this.tipDialog.setOnCancelListener(new C197611());
            C16395k.dTY();
            AppBrandXWebDownloadProxyUI.m30584a(AppBrandXWebDownloadProxyUI.this);
            AppMethodBeat.m2505o(133174);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI$a */
    final class C19762a implements C6060b {
        boolean iJD;

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI$a$1 */
        class C197631 implements Runnable {
            C197631() {
            }

            public final void run() {
                AppMethodBeat.m2504i(133176);
                C4990ab.m7416i("MicroMsg.AppBrandXWebDownloadProxyUI", "start download : showDialog");
                AppBrandXWebDownloadProxyUI.m30585b(AppBrandXWebDownloadProxyUI.this);
                AppMethodBeat.m2505o(133176);
            }
        }

        private C19762a() {
            this.iJD = false;
        }

        /* synthetic */ C19762a(AppBrandXWebDownloadProxyUI appBrandXWebDownloadProxyUI, byte b) {
            this();
        }

        public final boolean aMy() {
            AppMethodBeat.m2504i(133178);
            this.iJD = true;
            C5004al.m7441d(new C197631());
            AppMethodBeat.m2505o(133178);
            return true;
        }

        /* renamed from: pP */
        public final void mo13347pP(final int i) {
            AppMethodBeat.m2504i(133179);
            if (this.iJD) {
                C4990ab.m7417i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDownloadProgress, percent = %d", Integer.valueOf(i));
                if (AppBrandXWebDownloadProxyUI.this.tipDialog != null) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(133177);
                            AppBrandXWebDownloadProxyUI.this.tipDialog.setMessage(AppBrandXWebDownloadProxyUI.this.mController.ylL.getString(C25738R.string.f9075oq, new Object[]{String.valueOf(i)}));
                            AppMethodBeat.m2505o(133177);
                        }
                    });
                }
                AppMethodBeat.m2505o(133179);
                return;
            }
            AppMethodBeat.m2505o(133179);
        }

        public final void aMz() {
            AppMethodBeat.m2504i(133180);
            AppBrandXWebDownloadProxyUI.this.iJA = null;
            C16403w.m25218a(AppBrandXWebDownloadProxyUI.this.iJA);
            AppBrandXWebDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133180);
        }

        public final void aMA() {
            AppMethodBeat.m2504i(133181);
            AppBrandXWebDownloadProxyUI.this.iJA = null;
            C16403w.m25218a(AppBrandXWebDownloadProxyUI.this.iJA);
            AppBrandXWebDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133181);
        }

        public final void aMB() {
            AppMethodBeat.m2504i(133182);
            AppBrandXWebDownloadProxyUI.this.iJA = null;
            C16403w.m25218a(AppBrandXWebDownloadProxyUI.this.iJA);
            AppBrandXWebDownloadProxyUI.this.setResult(-1, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133182);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI$5 */
    class C197645 implements OnClickListener {
        C197645() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(133175);
            C7060h.pYm.mo8378a(366, 3, 1, false);
            C4990ab.m7416i("MicroMsg.AppBrandXWebDownloadProxyUI", "user cancel");
            AppBrandXWebDownloadProxyUI.this.setResult(2, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133175);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m30584a(AppBrandXWebDownloadProxyUI appBrandXWebDownloadProxyUI) {
        AppMethodBeat.m2504i(133186);
        appBrandXWebDownloadProxyUI.startTimer();
        AppMethodBeat.m2505o(133186);
    }

    static {
        AppMethodBeat.m2504i(133188);
        C45287c.m83506iw(C4996ah.getContext());
        AppMethodBeat.m2505o(133188);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(133183);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate");
        this.tipDialog = C30379h.m48458b(this.mController.ylL, null, true, null);
        this.tipDialog.setOnCancelListener(new C197593());
        C42696n.m75615a(getWindow());
        C4990ab.m7416i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate, kill tool");
        C45287c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        C4990ab.m7417i("MicroMsg.AppBrandXWebDownloadProxyUI", "now status, downloading = %b", Boolean.valueOf(C16395k.isBusy()));
        if (C16395k.isBusy()) {
            C4990ab.m7416i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download");
            if (iII) {
                setResult(0, new Intent());
                finish();
                AppMethodBeat.m2505o(133183);
                return;
            }
            if (this.iJA == null) {
                this.iJA = new C19762a(this, (byte) 0);
            }
            C16403w.m25218a(this.iJA);
            C4990ab.m7416i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download xweb already downloading, ignore duplicated request");
            Context context = this.mController.ylL;
            this.mController.ylL.getString(C25738R.string.f9238tz);
            this.tipDialog = C30379h.m48458b(context, this.mController.ylL.getString(C25738R.string.f9074op), true, null);
            if (this.tipDialog.getWindow() != null) {
                LayoutParams attributes = this.tipDialog.getWindow().getAttributes();
                attributes.dimAmount = 0.0f;
                this.tipDialog.getWindow().setAttributes(attributes);
            }
            this.tipDialog.setOnCancelListener(new C108031());
            startTimer();
            AppMethodBeat.m2505o(133183);
            return;
        }
        if (this.iJA == null) {
            this.iJA = new C19762a(this, (byte) 0);
        }
        C16403w.m25218a(this.iJA);
        C16395k.dTX();
        AppMethodBeat.m2505o(133183);
    }

    private void startTimer() {
        AppMethodBeat.m2504i(133184);
        this.mHandler = new Handler();
        this.iIH = new C108042();
        this.mHandler.postDelayed(this.iIH, 20000);
        AppMethodBeat.m2505o(133184);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(133185);
        C4990ab.m7416i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDestroy");
        this.iJA = null;
        C16403w.m25218a(this.iJA);
        if (!(this.mHandler == null || this.iIH == null)) {
            this.mHandler.removeCallbacks(this.iIH);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(133185);
    }

    /* renamed from: b */
    static /* synthetic */ void m30585b(AppBrandXWebDownloadProxyUI appBrandXWebDownloadProxyUI) {
        AppMethodBeat.m2504i(133187);
        if (appBrandXWebDownloadProxyUI.isFinishing() || appBrandXWebDownloadProxyUI.uiu) {
            AppMethodBeat.m2505o(133187);
            return;
        }
        OnClickListener c197604 = new C197604();
        if (DebuggerShell.ayT()) {
            c197604.onClick(null, 0);
            AppMethodBeat.m2505o(133187);
            return;
        }
        OnClickListener c197645 = new C197645();
        C5652a c5652a = new C5652a(appBrandXWebDownloadProxyUI.mController.ylL);
        c5652a.asE(appBrandXWebDownloadProxyUI.mController.ylL.getString(C25738R.string.f9073oo));
        c5652a.mo11482rc(false);
        c5652a.mo11453Qc(C25738R.string.f9072on).mo11457a(c197604);
        c5652a.mo11454Qd(C25738R.string.f9071om).mo11476b(c197645);
        c5652a.aMb().show();
        C7060h.pYm.mo8378a(366, 1, 1, false);
        AppMethodBeat.m2505o(133187);
    }
}
