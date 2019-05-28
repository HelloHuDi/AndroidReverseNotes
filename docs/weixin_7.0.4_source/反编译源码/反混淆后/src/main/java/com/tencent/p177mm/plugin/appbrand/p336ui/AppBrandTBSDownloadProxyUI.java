package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import com.tencent.p177mm.pluginsdk.model.C46499v.C30086a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C4782m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.xweb.p685x5.sdk.C24544d;
import com.tencent.xweb.p685x5.sdk.C24548f;
import com.tencent.xweb.p685x5.sdk.C24548f.C24549a;
import com.tencent.xweb.p685x5.sdk.C46837h;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI */
public final class AppBrandTBSDownloadProxyUI extends MMActivity {
    private static boolean iII = false;
    private C10801a iIG = null;
    private Runnable iIH;
    private Handler mHandler;
    C44275p tipDialog;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI$5 */
    class C108005 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI$5$1 */
        class C24771 implements OnCancelListener {
            C24771() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(133103);
                C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancel loading download background");
                AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
                AppMethodBeat.m2505o(133103);
            }
        }

        C108005() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(133104);
            C7060h.pYm.mo8378a(366, 2, 1, false);
            C30086a.m47652ov(false);
            C4782m.m7141kT(2);
            if (AppBrandTBSDownloadProxyUI.this.isFinishing() || AppBrandTBSDownloadProxyUI.this.uiu) {
                AppMethodBeat.m2505o(133104);
                return;
            }
            AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI = AppBrandTBSDownloadProxyUI.this;
            Context context = AppBrandTBSDownloadProxyUI.this.mController.ylL;
            AppBrandTBSDownloadProxyUI.this.mController.ylL.getString(C25738R.string.f9238tz);
            appBrandTBSDownloadProxyUI.tipDialog = C30379h.m48458b(context, AppBrandTBSDownloadProxyUI.this.mController.ylL.getString(C25738R.string.f9074op), true, null);
            AppBrandTBSDownloadProxyUI.this.tipDialog.setOnCancelListener(new C24771());
            AppBrandTBSDownloadProxyUI.m30580b(AppBrandTBSDownloadProxyUI.this);
            AppBrandTBSDownloadProxyUI.m30581c(AppBrandTBSDownloadProxyUI.this);
            AppMethodBeat.m2505o(133104);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI$a */
    final class C10801a implements C46837h {
        private C10801a() {
        }

        /* synthetic */ C10801a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI, byte b) {
            this();
        }

        public final void onDownloadFinish(int i) {
            AppMethodBeat.m2504i(133107);
            C4990ab.m7417i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadFinish, result = %d", Integer.valueOf(i));
            C4782m.m7140gu(5, i);
            if (i == 100 || i == 120 || i == 122) {
                C7060h.pYm.mo8378a(366, 4, 1, false);
            } else {
                C7060h.pYm.mo8378a(366, 5, 1, false);
            }
            SharedPreferences sharedPreferences;
            Editor edit;
            if (i != 110) {
                if (i == 100 || i == 120 || i == 122) {
                    C7060h.pYm.mo8375a(64, 64, 4, 3, 1, 1, false);
                } else {
                    AppBrandTBSDownloadProxyUI.this.iIG = null;
                    C24544d.m38198a(AppBrandTBSDownloadProxyUI.this.iIG);
                    C7060h.pYm.mo8378a(64, 3, 1, false);
                    AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
                    AppBrandTBSDownloadProxyUI.this.finish();
                }
                sharedPreferences = C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                if (sharedPreferences != null) {
                    C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                    edit = sharedPreferences.edit();
                    edit.putBoolean("tbs_download_finished", true);
                    edit.apply();
                }
                AppMethodBeat.m2505o(133107);
                return;
            }
            sharedPreferences = C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                edit = sharedPreferences.edit();
                edit.putBoolean("tbs_download_finished", true);
                edit.apply();
            }
            AppBrandTBSDownloadProxyUI.this.iIG = null;
            C24544d.m38198a(AppBrandTBSDownloadProxyUI.this.iIG);
            AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandTBSDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133107);
        }

        public final void onInstallFinish(int i) {
            AppMethodBeat.m2504i(133108);
            C4990ab.m7417i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, result = %d", Integer.valueOf(i));
            if (AppBrandTBSDownloadProxyUI.this.tipDialog != null) {
                AppBrandTBSDownloadProxyUI.this.tipDialog.dismiss();
                AppBrandTBSDownloadProxyUI.this.tipDialog = null;
            }
            C4782m.m7140gu(6, i);
            if (i == 200 || i == 220) {
                C7060h.pYm.mo8375a(64, 64, 7, 6, 1, 1, false);
                C7060h.pYm.mo8378a(366, 6, 1, false);
                C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, restart tool");
                C45287c.aNX();
                AppBrandTBSDownloadProxyUI.this.iIG = null;
                C24544d.m38198a(AppBrandTBSDownloadProxyUI.this.iIG);
                AppBrandTBSDownloadProxyUI.this.setResult(-1, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
                AppMethodBeat.m2505o(133108);
                return;
            }
            C7060h.pYm.mo8378a(64, 6, 1, false);
            C7060h.pYm.mo8378a(366, 7, 1, false);
            AppBrandTBSDownloadProxyUI.this.iIG = null;
            C24544d.m38198a(AppBrandTBSDownloadProxyUI.this.iIG);
            AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandTBSDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133108);
        }

        public final void onDownloadProgress(final int i) {
            AppMethodBeat.m2504i(133109);
            C4990ab.m7417i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadProgress, percent = %d", Integer.valueOf(i));
            if (AppBrandTBSDownloadProxyUI.this.tipDialog != null) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(133106);
                        AppBrandTBSDownloadProxyUI.this.tipDialog.setMessage(AppBrandTBSDownloadProxyUI.this.mController.ylL.getString(C25738R.string.f9075oq, new Object[]{String.valueOf(i)}));
                        AppMethodBeat.m2505o(133106);
                    }
                });
            }
            AppMethodBeat.m2505o(133109);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI$6 */
    class C197516 implements OnClickListener {
        C197516() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(133105);
            C7060h.pYm.mo8378a(366, 3, 1, false);
            C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "user cancel");
            C30086a.m47652ov(false);
            AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
            AppBrandTBSDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133105);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI$1 */
    class C197521 implements OnCancelListener {
        C197521() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(133098);
            C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
            AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
            AppBrandTBSDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133098);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI$2 */
    class C197532 implements C24549a {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI$2$1 */
        class C197541 implements Runnable {
            C197541() {
            }

            public final void run() {
                AppMethodBeat.m2504i(133099);
                C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "onNeedDownloadFinish : showDialog");
                AppBrandTBSDownloadProxyUI.m30579a(AppBrandTBSDownloadProxyUI.this);
                AppMethodBeat.m2505o(133099);
            }
        }

        C197532() {
        }

        public final void onNeedDownloadFinish(boolean z, int i) {
            AppMethodBeat.m2504i(133100);
            if (!z || i < 36824) {
                C4990ab.m7417i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download fail result %s version %d", Boolean.valueOf(z), Integer.valueOf(i));
                AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
                AppMethodBeat.m2505o(133100);
                return;
            }
            C4990ab.m7417i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download success result %s version %d", Boolean.valueOf(z), Integer.valueOf(i));
            C5004al.m7441d(new C197541());
            AppMethodBeat.m2505o(133100);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI$3 */
    class C197553 implements Runnable {
        C197553() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133101);
            AppBrandTBSDownloadProxyUI.iII = true;
            AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandTBSDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133101);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI$4 */
    class C197564 implements OnCancelListener {
        C197564() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(133102);
            C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
            AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
            AppBrandTBSDownloadProxyUI.this.finish();
            AppMethodBeat.m2505o(133102);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    static /* synthetic */ void m30581c(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        AppMethodBeat.m2504i(133115);
        appBrandTBSDownloadProxyUI.startTimer();
        AppMethodBeat.m2505o(133115);
    }

    static {
        AppMethodBeat.m2504i(133116);
        C45287c.m83506iw(C4996ah.getContext());
        AppMethodBeat.m2505o(133116);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(133110);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate");
        this.tipDialog = C30379h.m48458b(this.mController.ylL, null, true, null);
        this.tipDialog.setOnCancelListener(new C197564());
        C42696n.m75615a(getWindow());
        C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate, kill tool");
        C45287c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        boolean isDownloading = C24548f.isDownloading();
        boolean tBSInstalling = C24544d.getTBSInstalling();
        boolean isDownloadForeground = C24548f.isDownloadForeground();
        C4990ab.m7417i("MicroMsg.AppBrandTBSDownloadProxyUI", "now status, downloading = %b, installing = %b", Boolean.valueOf(isDownloading), Boolean.valueOf(tBSInstalling));
        if (isDownloading || tBSInstalling) {
            if (isDownloadForeground) {
                C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download");
                if (iII) {
                    setResult(0, new Intent());
                    finish();
                    AppMethodBeat.m2505o(133110);
                    return;
                }
                if (this.iIG == null) {
                    this.iIG = new C10801a(this, (byte) 0);
                }
                C24544d.m38198a(this.iIG);
                C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download TBS already downloading, ignore duplicated request");
                Context context = this.mController.ylL;
                this.mController.ylL.getString(C25738R.string.f9238tz);
                this.tipDialog = C30379h.m48458b(context, this.mController.ylL.getString(C25738R.string.f9074op), true, null);
                if (this.tipDialog.getWindow() != null) {
                    LayoutParams attributes = this.tipDialog.getWindow().getAttributes();
                    attributes.dimAmount = 0.0f;
                    this.tipDialog.getWindow().setAttributes(attributes);
                }
                this.tipDialog.setOnCancelListener(new C197521());
                startTimer();
                AppMethodBeat.m2505o(133110);
                return;
            }
            C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "isBackGroundDownload reset download");
            C24548f.stopDownload();
        }
        C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download");
        C24548f.m38205a(this.mController.ylL, false, true, new C197532());
        AppMethodBeat.m2505o(133110);
    }

    private void startTimer() {
        AppMethodBeat.m2504i(133111);
        this.mHandler = new Handler();
        this.iIH = new C197553();
        this.mHandler.postDelayed(this.iIH, 20000);
        AppMethodBeat.m2505o(133111);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(133112);
        C4990ab.m7416i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDestroy");
        if (!(this.mHandler == null || this.iIH == null)) {
            this.mHandler.removeCallbacks(this.iIH);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(133112);
    }

    /* renamed from: a */
    static /* synthetic */ void m30579a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        AppMethodBeat.m2504i(133113);
        if (appBrandTBSDownloadProxyUI.isFinishing() || appBrandTBSDownloadProxyUI.uiu) {
            AppMethodBeat.m2505o(133113);
            return;
        }
        OnClickListener c108005 = new C108005();
        if (DebuggerShell.ayT()) {
            c108005.onClick(null, 0);
            AppMethodBeat.m2505o(133113);
            return;
        }
        OnClickListener c197516 = new C197516();
        C5652a c5652a = new C5652a(appBrandTBSDownloadProxyUI.mController.ylL);
        c5652a.asE(appBrandTBSDownloadProxyUI.mController.ylL.getString(C25738R.string.f9073oo));
        c5652a.mo11482rc(false);
        c5652a.mo11453Qc(C25738R.string.f9072on).mo11457a(c108005);
        c5652a.mo11454Qd(C25738R.string.f9071om).mo11476b(c197516);
        c5652a.aMb().show();
        C30086a.m47652ov(true);
        C7060h.pYm.mo8378a(366, 1, 1, false);
        AppMethodBeat.m2505o(133113);
    }

    /* renamed from: b */
    static /* synthetic */ void m30580b(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        AppMethodBeat.m2504i(133114);
        if (appBrandTBSDownloadProxyUI.iIG == null) {
            appBrandTBSDownloadProxyUI.iIG = new C10801a(appBrandTBSDownloadProxyUI, (byte) 0);
        }
        C24544d.m38198a(appBrandTBSDownloadProxyUI.iIG);
        C4782m.m7141kT(3);
        C24548f.startDownload(C4996ah.getContext(), true);
        AppMethodBeat.m2505o(133114);
    }
}
