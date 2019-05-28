package com.tencent.mm.plugin.appbrand.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.cj.c;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.f;
import com.tencent.xweb.x5.sdk.h;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandTBSDownloadProxyUI extends MMActivity {
    private static boolean iII = false;
    private a iIG = null;
    private Runnable iIH;
    private Handler mHandler;
    p tipDialog;

    final class a implements h {
        private a() {
        }

        /* synthetic */ a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI, byte b) {
            this();
        }

        public final void onDownloadFinish(int i) {
            AppMethodBeat.i(133107);
            ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadFinish, result = %d", Integer.valueOf(i));
            m.gu(5, i);
            if (i == 100 || i == 120 || i == 122) {
                com.tencent.mm.plugin.report.service.h.pYm.a(366, 4, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.a(366, 5, 1, false);
            }
            SharedPreferences sharedPreferences;
            Editor edit;
            if (i != 110) {
                if (i == 100 || i == 120 || i == 122) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(64, 64, 4, 3, 1, 1, false);
                } else {
                    AppBrandTBSDownloadProxyUI.this.iIG = null;
                    d.a(AppBrandTBSDownloadProxyUI.this.iIG);
                    com.tencent.mm.plugin.report.service.h.pYm.a(64, 3, 1, false);
                    AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
                    AppBrandTBSDownloadProxyUI.this.finish();
                }
                sharedPreferences = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                if (sharedPreferences != null) {
                    ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                    edit = sharedPreferences.edit();
                    edit.putBoolean("tbs_download_finished", true);
                    edit.apply();
                }
                AppMethodBeat.o(133107);
                return;
            }
            sharedPreferences = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                edit = sharedPreferences.edit();
                edit.putBoolean("tbs_download_finished", true);
                edit.apply();
            }
            AppBrandTBSDownloadProxyUI.this.iIG = null;
            d.a(AppBrandTBSDownloadProxyUI.this.iIG);
            AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandTBSDownloadProxyUI.this.finish();
            AppMethodBeat.o(133107);
        }

        public final void onInstallFinish(int i) {
            AppMethodBeat.i(133108);
            ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, result = %d", Integer.valueOf(i));
            if (AppBrandTBSDownloadProxyUI.this.tipDialog != null) {
                AppBrandTBSDownloadProxyUI.this.tipDialog.dismiss();
                AppBrandTBSDownloadProxyUI.this.tipDialog = null;
            }
            m.gu(6, i);
            if (i == 200 || i == 220) {
                com.tencent.mm.plugin.report.service.h.pYm.a(64, 64, 7, 6, 1, 1, false);
                com.tencent.mm.plugin.report.service.h.pYm.a(366, 6, 1, false);
                ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, restart tool");
                c.aNX();
                AppBrandTBSDownloadProxyUI.this.iIG = null;
                d.a(AppBrandTBSDownloadProxyUI.this.iIG);
                AppBrandTBSDownloadProxyUI.this.setResult(-1, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
                AppMethodBeat.o(133108);
                return;
            }
            com.tencent.mm.plugin.report.service.h.pYm.a(64, 6, 1, false);
            com.tencent.mm.plugin.report.service.h.pYm.a(366, 7, 1, false);
            AppBrandTBSDownloadProxyUI.this.iIG = null;
            d.a(AppBrandTBSDownloadProxyUI.this.iIG);
            AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandTBSDownloadProxyUI.this.finish();
            AppMethodBeat.o(133108);
        }

        public final void onDownloadProgress(final int i) {
            AppMethodBeat.i(133109);
            ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadProgress, percent = %d", Integer.valueOf(i));
            if (AppBrandTBSDownloadProxyUI.this.tipDialog != null) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(133106);
                        AppBrandTBSDownloadProxyUI.this.tipDialog.setMessage(AppBrandTBSDownloadProxyUI.this.mController.ylL.getString(R.string.oq, new Object[]{String.valueOf(i)}));
                        AppMethodBeat.o(133106);
                    }
                });
            }
            AppMethodBeat.o(133109);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        AppMethodBeat.i(133115);
        appBrandTBSDownloadProxyUI.startTimer();
        AppMethodBeat.o(133115);
    }

    static {
        AppMethodBeat.i(133116);
        c.iw(ah.getContext());
        AppMethodBeat.o(133116);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(133110);
        super.onCreate(bundle);
        ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate");
        this.tipDialog = com.tencent.mm.ui.base.h.b(this.mController.ylL, null, true, null);
        this.tipDialog.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(133102);
                ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
                AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
                AppMethodBeat.o(133102);
            }
        });
        n.a(getWindow());
        ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate, kill tool");
        c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        boolean isDownloading = f.isDownloading();
        boolean tBSInstalling = d.getTBSInstalling();
        boolean isDownloadForeground = f.isDownloadForeground();
        ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "now status, downloading = %b, installing = %b", Boolean.valueOf(isDownloading), Boolean.valueOf(tBSInstalling));
        if (isDownloading || tBSInstalling) {
            if (isDownloadForeground) {
                ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download");
                if (iII) {
                    setResult(0, new Intent());
                    finish();
                    AppMethodBeat.o(133110);
                    return;
                }
                if (this.iIG == null) {
                    this.iIG = new a(this, (byte) 0);
                }
                d.a(this.iIG);
                ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download TBS already downloading, ignore duplicated request");
                Context context = this.mController.ylL;
                this.mController.ylL.getString(R.string.tz);
                this.tipDialog = com.tencent.mm.ui.base.h.b(context, this.mController.ylL.getString(R.string.op), true, null);
                if (this.tipDialog.getWindow() != null) {
                    LayoutParams attributes = this.tipDialog.getWindow().getAttributes();
                    attributes.dimAmount = 0.0f;
                    this.tipDialog.getWindow().setAttributes(attributes);
                }
                this.tipDialog.setOnCancelListener(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(133098);
                        ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
                        AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                        AppBrandTBSDownloadProxyUI.this.finish();
                        AppMethodBeat.o(133098);
                    }
                });
                startTimer();
                AppMethodBeat.o(133110);
                return;
            }
            ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "isBackGroundDownload reset download");
            f.stopDownload();
        }
        ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download");
        f.a(this.mController.ylL, false, true, new com.tencent.xweb.x5.sdk.f.a() {
            public final void onNeedDownloadFinish(boolean z, int i) {
                AppMethodBeat.i(133100);
                if (!z || i < 36824) {
                    ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download fail result %s version %d", Boolean.valueOf(z), Integer.valueOf(i));
                    AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
                    AppBrandTBSDownloadProxyUI.this.finish();
                    AppMethodBeat.o(133100);
                    return;
                }
                ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download success result %s version %d", Boolean.valueOf(z), Integer.valueOf(i));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(133099);
                        ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onNeedDownloadFinish : showDialog");
                        AppBrandTBSDownloadProxyUI.a(AppBrandTBSDownloadProxyUI.this);
                        AppMethodBeat.o(133099);
                    }
                });
                AppMethodBeat.o(133100);
            }
        });
        AppMethodBeat.o(133110);
    }

    private void startTimer() {
        AppMethodBeat.i(133111);
        this.mHandler = new Handler();
        this.iIH = new Runnable() {
            public final void run() {
                AppMethodBeat.i(133101);
                AppBrandTBSDownloadProxyUI.iII = true;
                AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
                AppMethodBeat.o(133101);
            }
        };
        this.mHandler.postDelayed(this.iIH, 20000);
        AppMethodBeat.o(133111);
    }

    public final void onDestroy() {
        AppMethodBeat.i(133112);
        ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDestroy");
        if (!(this.mHandler == null || this.iIH == null)) {
            this.mHandler.removeCallbacks(this.iIH);
        }
        super.onDestroy();
        AppMethodBeat.o(133112);
    }

    static /* synthetic */ void a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        AppMethodBeat.i(133113);
        if (appBrandTBSDownloadProxyUI.isFinishing() || appBrandTBSDownloadProxyUI.uiu) {
            AppMethodBeat.o(133113);
            return;
        }
        OnClickListener anonymousClass5 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(133104);
                com.tencent.mm.plugin.report.service.h.pYm.a(366, 2, 1, false);
                com.tencent.mm.pluginsdk.model.v.a.ov(false);
                m.kT(2);
                if (AppBrandTBSDownloadProxyUI.this.isFinishing() || AppBrandTBSDownloadProxyUI.this.uiu) {
                    AppMethodBeat.o(133104);
                    return;
                }
                AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI = AppBrandTBSDownloadProxyUI.this;
                Context context = AppBrandTBSDownloadProxyUI.this.mController.ylL;
                AppBrandTBSDownloadProxyUI.this.mController.ylL.getString(R.string.tz);
                appBrandTBSDownloadProxyUI.tipDialog = com.tencent.mm.ui.base.h.b(context, AppBrandTBSDownloadProxyUI.this.mController.ylL.getString(R.string.op), true, null);
                AppBrandTBSDownloadProxyUI.this.tipDialog.setOnCancelListener(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(133103);
                        ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancel loading download background");
                        AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                        AppBrandTBSDownloadProxyUI.this.finish();
                        AppMethodBeat.o(133103);
                    }
                });
                AppBrandTBSDownloadProxyUI.b(AppBrandTBSDownloadProxyUI.this);
                AppBrandTBSDownloadProxyUI.c(AppBrandTBSDownloadProxyUI.this);
                AppMethodBeat.o(133104);
            }
        };
        if (DebuggerShell.ayT()) {
            anonymousClass5.onClick(null, 0);
            AppMethodBeat.o(133113);
            return;
        }
        OnClickListener anonymousClass6 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(133105);
                com.tencent.mm.plugin.report.service.h.pYm.a(366, 3, 1, false);
                ab.i("MicroMsg.AppBrandTBSDownloadProxyUI", "user cancel");
                com.tencent.mm.pluginsdk.model.v.a.ov(false);
                AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
                AppMethodBeat.o(133105);
            }
        };
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(appBrandTBSDownloadProxyUI.mController.ylL);
        aVar.asE(appBrandTBSDownloadProxyUI.mController.ylL.getString(R.string.oo));
        aVar.rc(false);
        aVar.Qc(R.string.on).a(anonymousClass5);
        aVar.Qd(R.string.om).b(anonymousClass6);
        aVar.aMb().show();
        com.tencent.mm.pluginsdk.model.v.a.ov(true);
        com.tencent.mm.plugin.report.service.h.pYm.a(366, 1, 1, false);
        AppMethodBeat.o(133113);
    }

    static /* synthetic */ void b(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        AppMethodBeat.i(133114);
        if (appBrandTBSDownloadProxyUI.iIG == null) {
            appBrandTBSDownloadProxyUI.iIG = new a(appBrandTBSDownloadProxyUI, (byte) 0);
        }
        d.a(appBrandTBSDownloadProxyUI.iIG);
        m.kT(3);
        f.startDownload(ah.getContext(), true);
        AppMethodBeat.o(133114);
    }
}
