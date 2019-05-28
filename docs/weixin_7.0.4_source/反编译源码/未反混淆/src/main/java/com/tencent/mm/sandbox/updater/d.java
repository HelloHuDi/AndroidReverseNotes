package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cj.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x5.sdk.f;
import com.tencent.xweb.x5.sdk.h;

public final class d implements a {
    Intent intent;
    private Notification oHJ;
    private a xwl;
    private int xwm;
    private boolean xwn;
    private boolean xwo;
    private boolean xwp;

    static final class b {
        public static final d xws = new d();

        static {
            AppMethodBeat.i(28883);
            AppMethodBeat.o(28883);
        }
    }

    final class a implements h {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        public final void onDownloadFinish(int i) {
            AppMethodBeat.i(28881);
            ab.i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", Integer.valueOf(i));
            m.gu(5, i);
            if (i != 110) {
                if (i == 100) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(64, 64, 4, 3, 1, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.h.pYm.a(64, 3, 1, false);
                }
            }
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                ab.i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
                Editor edit = sharedPreferences.edit();
                edit.putBoolean("tbs_download_finished", true);
                edit.apply();
            }
            AppMethodBeat.o(28881);
        }

        public final void onInstallFinish(int i) {
            AppMethodBeat.i(28882);
            ab.i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", Integer.valueOf(i));
            m.gu(6, i);
            if (i == 200 || i == 220) {
                com.tencent.mm.plugin.report.service.h.pYm.a(64, 64, 7, 6, 1, 1, false);
                d.b(d.this);
                AppMethodBeat.o(28882);
                return;
            }
            com.tencent.mm.plugin.report.service.h.pYm.a(64, 6, 1, false);
            AppMethodBeat.o(28882);
        }

        public final void onDownloadProgress(int i) {
        }
    }

    /* synthetic */ d(byte b) {
        this();
    }

    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(28891);
        dVar.bGl();
        AppMethodBeat.o(28891);
    }

    static {
        AppMethodBeat.i(28893);
        c.iw(ah.getContext());
        com.tencent.xweb.b.d.a(com.tencent.mm.plugin.cdndownloader.i.a.bfd());
        AppMethodBeat.o(28893);
    }

    public static d dnn() {
        return b.xws;
    }

    private d() {
        AppMethodBeat.i(28884);
        this.xwl = null;
        this.intent = new Intent();
        this.oHJ = null;
        this.xwm = 999;
        this.xwn = false;
        this.xwo = false;
        this.xwp = false;
        AppMethodBeat.o(28884);
    }

    private void bGl() {
        AppMethodBeat.i(28885);
        if (this.xwp) {
            ab.i("MicroMsg.TBSDownloadMgr", "TBS already downloaded, ignore duplicated request");
            AppMethodBeat.o(28885);
            return;
        }
        this.xwp = true;
        if (this.xwl == null) {
            this.xwl = new a(this, (byte) 0);
            com.tencent.xweb.x5.sdk.d.a(this.xwl);
            m.kT(2);
        }
        dno();
        m.kT(3);
        AppMethodBeat.o(28885);
    }

    public final void pc(boolean z) {
        AppMethodBeat.i(28886);
        if (this.xwl == null) {
            ab.w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
            AppMethodBeat.o(28886);
            return;
        }
        Context context = ah.getContext();
        boolean isDownloading = f.isDownloading();
        boolean needDownload = f.needDownload(context, this.xwn | this.xwo);
        boolean booleanExtra = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        boolean isDownloadForeground = f.isDownloadForeground();
        ab.i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", Boolean.valueOf(z), Boolean.valueOf(isDownloading), Boolean.valueOf(needDownload), Boolean.valueOf(booleanExtra));
        if ((z || booleanExtra) && !isDownloading && needDownload) {
            dno();
            m.kT(3);
            AppMethodBeat.o(28886);
            return;
        }
        if (!(z || booleanExtra || !isDownloading || isDownloadForeground)) {
            f.stopDownload();
            m.kT(4);
        }
        AppMethodBeat.o(28886);
    }

    private void dno() {
        AppMethodBeat.i(28887);
        f.startDownload(ah.getContext());
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            ab.i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", Boolean.valueOf(this.xwo), Boolean.valueOf(this.xwn));
            if (this.xwo || this.xwn) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
            }
        }
        AppMethodBeat.o(28887);
    }

    public final boolean aJ(Intent intent) {
        AppMethodBeat.i(28888);
        this.intent = intent;
        this.xwn = this.intent.getIntExtra("intent_extra_download_type", 1) == 2;
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            this.xwo = sharedPreferences.getBoolean("tbs_download_oversea", false);
        }
        ab.i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", Boolean.valueOf(this.xwn), Boolean.valueOf(this.xwo));
        boolean isDownloading = f.isDownloading();
        com.tencent.xweb.x5.sdk.d.setUploadCode(ah.getContext(), e.CTRL_INDEX);
        if (isDownloading) {
            ab.i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
            com.tencent.xweb.x5.sdk.d.setUploadCode(ah.getContext(), com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX);
            AppMethodBeat.o(28888);
            return true;
        }
        this.xwp = false;
        Context context = ah.getContext();
        int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(context);
        boolean a = f.a(context, this.xwn | this.xwo, false, new com.tencent.xweb.x5.sdk.f.a() {
            public final void onNeedDownloadFinish(boolean z, int i) {
                AppMethodBeat.i(28880);
                ab.i("MicroMsg.TBSDownloadMgr", "TBS download onNeedDownloadFinish, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(at.isWifi(ah.getContext())), Boolean.valueOf(d.this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false)));
                if ((at.isWifi(ah.getContext()) || r1) && z) {
                    d.a(d.this);
                    AppMethodBeat.o(28880);
                    return;
                }
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(28879);
                        UpdaterService.ev();
                        AppMethodBeat.o(28879);
                    }
                }, 500);
                AppMethodBeat.o(28880);
            }
        });
        isDownloading = at.isWifi(context);
        boolean booleanExtra = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        ab.i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", Integer.valueOf(installedTbsCoreVersion), Boolean.valueOf(a), Boolean.valueOf(isDownloading), Boolean.valueOf(booleanExtra));
        if ((isDownloading || booleanExtra) && a) {
            bGl();
            AppMethodBeat.o(28888);
            return true;
        } else if (isDownloading || booleanExtra) {
            AppMethodBeat.o(28888);
            return true;
        } else {
            AppMethodBeat.o(28888);
            return false;
        }
    }

    public final boolean isBusy() {
        AppMethodBeat.i(28889);
        ab.i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", Boolean.valueOf(f.isDownloading()), Boolean.valueOf(com.tencent.xweb.x5.sdk.d.getTBSInstalling()));
        if (f.isDownloading() || r3) {
            AppMethodBeat.o(28889);
            return true;
        }
        AppMethodBeat.o(28889);
        return false;
    }

    public final void onDestroy() {
        AppMethodBeat.i(28890);
        ab.i("MicroMsg.TBSDownloadMgr", "onDestroy");
        AppMethodBeat.o(28890);
    }

    static /* synthetic */ void b(d dVar) {
        AppMethodBeat.i(28892);
        if (dVar.xwn) {
            String cc = bo.cc(ah.getContext());
            ab.i("MicroMsg.TBSDownloadMgr", "topActivityName = %s", cc);
            if (bo.isNullOrNil(cc) || !cc.equalsIgnoreCase("com.tencent.mm.plugin.webview.ui.tools.WebViewUI")) {
                c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                Context context = ah.getContext();
                v.c bt = com.tencent.mm.bo.a.bt(context, "reminder_channel_id");
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                bt.as(com.tencent.mm.bo.a.bWV());
                bt.d(context.getString(R.string.fzj));
                bt.e(context.getString(R.string.fzi));
                bt.k(2, false);
                bt.z(true);
                bt.EI = PendingIntent.getActivity(ah.getContext(), 0, new Intent(), 0);
                dVar.oHJ = bt.build();
                notificationManager.notify(dVar.xwm, dVar.oHJ);
                c.aNX();
            }
        }
        AppMethodBeat.o(28892);
    }
}
