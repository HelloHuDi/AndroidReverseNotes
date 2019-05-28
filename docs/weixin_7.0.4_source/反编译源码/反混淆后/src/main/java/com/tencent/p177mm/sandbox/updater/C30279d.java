package com.tencent.p177mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.p057v4.app.C0363v.C0358c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.cdndownloader.p1544i.C44726a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C4782m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p1634b.C44831d;
import com.tencent.xweb.p685x5.sdk.C24544d;
import com.tencent.xweb.p685x5.sdk.C24548f;
import com.tencent.xweb.p685x5.sdk.C24548f.C24549a;
import com.tencent.xweb.p685x5.sdk.C46837h;

/* renamed from: com.tencent.mm.sandbox.updater.d */
public final class C30279d implements C40606a {
    Intent intent;
    private Notification oHJ;
    private C30280a xwl;
    private int xwm;
    private boolean xwn;
    private boolean xwo;
    private boolean xwp;

    /* renamed from: com.tencent.mm.sandbox.updater.d$1 */
    class C234841 implements C24549a {

        /* renamed from: com.tencent.mm.sandbox.updater.d$1$1 */
        class C234851 implements Runnable {
            C234851() {
            }

            public final void run() {
                AppMethodBeat.m2504i(28879);
                UpdaterService.m48156ev();
                AppMethodBeat.m2505o(28879);
            }
        }

        C234841() {
        }

        public final void onNeedDownloadFinish(boolean z, int i) {
            AppMethodBeat.m2504i(28880);
            C4990ab.m7417i("MicroMsg.TBSDownloadMgr", "TBS download onNeedDownloadFinish, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(C5023at.isWifi(C4996ah.getContext())), Boolean.valueOf(C30279d.this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false)));
            if ((C5023at.isWifi(C4996ah.getContext()) || r1) && z) {
                C30279d.m48160a(C30279d.this);
                AppMethodBeat.m2505o(28880);
                return;
            }
            C5004al.m7442n(new C234851(), 500);
            AppMethodBeat.m2505o(28880);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.d$b */
    static final class C23486b {
        public static final C30279d xws = new C30279d();

        static {
            AppMethodBeat.m2504i(28883);
            AppMethodBeat.m2505o(28883);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.d$a */
    final class C30280a implements C46837h {
        private C30280a() {
        }

        /* synthetic */ C30280a(C30279d c30279d, byte b) {
            this();
        }

        public final void onDownloadFinish(int i) {
            AppMethodBeat.m2504i(28881);
            C4990ab.m7417i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", Integer.valueOf(i));
            C4782m.m7140gu(5, i);
            if (i != 110) {
                if (i == 100) {
                    C7060h.pYm.mo8375a(64, 64, 4, 3, 1, 1, false);
                } else {
                    C7060h.pYm.mo8378a(64, 3, 1, false);
                }
            }
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                C4990ab.m7416i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
                Editor edit = sharedPreferences.edit();
                edit.putBoolean("tbs_download_finished", true);
                edit.apply();
            }
            AppMethodBeat.m2505o(28881);
        }

        public final void onInstallFinish(int i) {
            AppMethodBeat.m2504i(28882);
            C4990ab.m7417i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", Integer.valueOf(i));
            C4782m.m7140gu(6, i);
            if (i == 200 || i == 220) {
                C7060h.pYm.mo8375a(64, 64, 7, 6, 1, 1, false);
                C30279d.m48161b(C30279d.this);
                AppMethodBeat.m2505o(28882);
                return;
            }
            C7060h.pYm.mo8378a(64, 6, 1, false);
            AppMethodBeat.m2505o(28882);
        }

        public final void onDownloadProgress(int i) {
        }
    }

    /* synthetic */ C30279d(byte b) {
        this();
    }

    /* renamed from: a */
    static /* synthetic */ void m48160a(C30279d c30279d) {
        AppMethodBeat.m2504i(28891);
        c30279d.bGl();
        AppMethodBeat.m2505o(28891);
    }

    static {
        AppMethodBeat.m2504i(28893);
        C45287c.m83506iw(C4996ah.getContext());
        C44831d.m82031a(C44726a.bfd());
        AppMethodBeat.m2505o(28893);
    }

    public static C30279d dnn() {
        return C23486b.xws;
    }

    private C30279d() {
        AppMethodBeat.m2504i(28884);
        this.xwl = null;
        this.intent = new Intent();
        this.oHJ = null;
        this.xwm = 999;
        this.xwn = false;
        this.xwo = false;
        this.xwp = false;
        AppMethodBeat.m2505o(28884);
    }

    private void bGl() {
        AppMethodBeat.m2504i(28885);
        if (this.xwp) {
            C4990ab.m7416i("MicroMsg.TBSDownloadMgr", "TBS already downloaded, ignore duplicated request");
            AppMethodBeat.m2505o(28885);
            return;
        }
        this.xwp = true;
        if (this.xwl == null) {
            this.xwl = new C30280a(this, (byte) 0);
            C24544d.m38198a(this.xwl);
            C4782m.m7141kT(2);
        }
        dno();
        C4782m.m7141kT(3);
        AppMethodBeat.m2505o(28885);
    }

    /* renamed from: pc */
    public final void mo48469pc(boolean z) {
        AppMethodBeat.m2504i(28886);
        if (this.xwl == null) {
            C4990ab.m7420w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
            AppMethodBeat.m2505o(28886);
            return;
        }
        Context context = C4996ah.getContext();
        boolean isDownloading = C24548f.isDownloading();
        boolean needDownload = C24548f.needDownload(context, this.xwn | this.xwo);
        boolean booleanExtra = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        boolean isDownloadForeground = C24548f.isDownloadForeground();
        C4990ab.m7417i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", Boolean.valueOf(z), Boolean.valueOf(isDownloading), Boolean.valueOf(needDownload), Boolean.valueOf(booleanExtra));
        if ((z || booleanExtra) && !isDownloading && needDownload) {
            dno();
            C4782m.m7141kT(3);
            AppMethodBeat.m2505o(28886);
            return;
        }
        if (!(z || booleanExtra || !isDownloading || isDownloadForeground)) {
            C24548f.stopDownload();
            C4782m.m7141kT(4);
        }
        AppMethodBeat.m2505o(28886);
    }

    private void dno() {
        AppMethodBeat.m2504i(28887);
        C24548f.startDownload(C4996ah.getContext());
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            C4990ab.m7417i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", Boolean.valueOf(this.xwo), Boolean.valueOf(this.xwn));
            if (this.xwo || this.xwn) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
            }
        }
        AppMethodBeat.m2505o(28887);
    }

    /* renamed from: aJ */
    public final boolean mo48466aJ(Intent intent) {
        AppMethodBeat.m2504i(28888);
        this.intent = intent;
        this.xwn = this.intent.getIntExtra("intent_extra_download_type", 1) == 2;
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            this.xwo = sharedPreferences.getBoolean("tbs_download_oversea", false);
        }
        C4990ab.m7417i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", Boolean.valueOf(this.xwn), Boolean.valueOf(this.xwo));
        boolean isDownloading = C24548f.isDownloading();
        C24544d.setUploadCode(C4996ah.getContext(), C19394e.CTRL_INDEX);
        if (isDownloading) {
            C4990ab.m7416i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
            C24544d.setUploadCode(C4996ah.getContext(), C19392d.CTRL_INDEX);
            AppMethodBeat.m2505o(28888);
            return true;
        }
        this.xwp = false;
        Context context = C4996ah.getContext();
        int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(context);
        boolean a = C24548f.m38205a(context, this.xwn | this.xwo, false, new C234841());
        isDownloading = C5023at.isWifi(context);
        boolean booleanExtra = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        C4990ab.m7417i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", Integer.valueOf(installedTbsCoreVersion), Boolean.valueOf(a), Boolean.valueOf(isDownloading), Boolean.valueOf(booleanExtra));
        if ((isDownloading || booleanExtra) && a) {
            bGl();
            AppMethodBeat.m2505o(28888);
            return true;
        } else if (isDownloading || booleanExtra) {
            AppMethodBeat.m2505o(28888);
            return true;
        } else {
            AppMethodBeat.m2505o(28888);
            return false;
        }
    }

    public final boolean isBusy() {
        AppMethodBeat.m2504i(28889);
        C4990ab.m7417i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", Boolean.valueOf(C24548f.isDownloading()), Boolean.valueOf(C24544d.getTBSInstalling()));
        if (C24548f.isDownloading() || r3) {
            AppMethodBeat.m2505o(28889);
            return true;
        }
        AppMethodBeat.m2505o(28889);
        return false;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(28890);
        C4990ab.m7416i("MicroMsg.TBSDownloadMgr", "onDestroy");
        AppMethodBeat.m2505o(28890);
    }

    /* renamed from: b */
    static /* synthetic */ void m48161b(C30279d c30279d) {
        AppMethodBeat.m2504i(28892);
        if (c30279d.xwn) {
            String cc = C5046bo.m7542cc(C4996ah.getContext());
            C4990ab.m7417i("MicroMsg.TBSDownloadMgr", "topActivityName = %s", cc);
            if (C5046bo.isNullOrNil(cc) || !cc.equalsIgnoreCase("com.tencent.mm.plugin.webview.ui.tools.WebViewUI")) {
                C45287c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                Context context = C4996ah.getContext();
                C0358c bt = C45186a.m83262bt(context, "reminder_channel_id");
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                bt.mo616as(C45186a.bWV());
                bt.mo621d(context.getString(C25738R.string.fzj));
                bt.mo623e(context.getString(C25738R.string.fzi));
                bt.mo627k(2, false);
                bt.mo628z(true);
                bt.f362EI = PendingIntent.getActivity(C4996ah.getContext(), 0, new Intent(), 0);
                c30279d.oHJ = bt.build();
                notificationManager.notify(c30279d.xwm, c30279d.oHJ);
                C45287c.aNX();
            }
        }
        AppMethodBeat.m2505o(28892);
    }
}
