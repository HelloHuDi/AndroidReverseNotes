package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cj.c;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.xweb.k;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.b;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandXWebDownloadProxyUI extends MMActivity {
    private static boolean iII = false;
    private Runnable iIH;
    private b iJA = null;
    private Handler mHandler;
    p tipDialog;

    final class a implements b {
        boolean iJD;

        private a() {
            this.iJD = false;
        }

        /* synthetic */ a(AppBrandXWebDownloadProxyUI appBrandXWebDownloadProxyUI, byte b) {
            this();
        }

        public final boolean aMy() {
            AppMethodBeat.i(133178);
            this.iJD = true;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133176);
                    ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "start download : showDialog");
                    AppBrandXWebDownloadProxyUI.b(AppBrandXWebDownloadProxyUI.this);
                    AppMethodBeat.o(133176);
                }
            });
            AppMethodBeat.o(133178);
            return true;
        }

        public final void pP(final int i) {
            AppMethodBeat.i(133179);
            if (this.iJD) {
                ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDownloadProgress, percent = %d", Integer.valueOf(i));
                if (AppBrandXWebDownloadProxyUI.this.tipDialog != null) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(133177);
                            AppBrandXWebDownloadProxyUI.this.tipDialog.setMessage(AppBrandXWebDownloadProxyUI.this.mController.ylL.getString(R.string.oq, new Object[]{String.valueOf(i)}));
                            AppMethodBeat.o(133177);
                        }
                    });
                }
                AppMethodBeat.o(133179);
                return;
            }
            AppMethodBeat.o(133179);
        }

        public final void aMz() {
            AppMethodBeat.i(133180);
            AppBrandXWebDownloadProxyUI.this.iJA = null;
            w.a(AppBrandXWebDownloadProxyUI.this.iJA);
            AppBrandXWebDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.o(133180);
        }

        public final void aMA() {
            AppMethodBeat.i(133181);
            AppBrandXWebDownloadProxyUI.this.iJA = null;
            w.a(AppBrandXWebDownloadProxyUI.this.iJA);
            AppBrandXWebDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.o(133181);
        }

        public final void aMB() {
            AppMethodBeat.i(133182);
            AppBrandXWebDownloadProxyUI.this.iJA = null;
            w.a(AppBrandXWebDownloadProxyUI.this.iJA);
            AppBrandXWebDownloadProxyUI.this.setResult(-1, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.o(133182);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(AppBrandXWebDownloadProxyUI appBrandXWebDownloadProxyUI) {
        AppMethodBeat.i(133186);
        appBrandXWebDownloadProxyUI.startTimer();
        AppMethodBeat.o(133186);
    }

    static {
        AppMethodBeat.i(133188);
        c.iw(ah.getContext());
        AppMethodBeat.o(133188);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(133183);
        super.onCreate(bundle);
        ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate");
        this.tipDialog = h.b(this.mController.ylL, null, true, null);
        this.tipDialog.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(133172);
                ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "cancle loading download background");
                AppBrandXWebDownloadProxyUI.this.setResult(2, new Intent());
                AppBrandXWebDownloadProxyUI.this.finish();
                AppMethodBeat.o(133172);
            }
        });
        n.a(getWindow());
        ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate, kill tool");
        c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "now status, downloading = %b", Boolean.valueOf(k.isBusy()));
        if (k.isBusy()) {
            ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download");
            if (iII) {
                setResult(0, new Intent());
                finish();
                AppMethodBeat.o(133183);
                return;
            }
            if (this.iJA == null) {
                this.iJA = new a(this, (byte) 0);
            }
            w.a(this.iJA);
            ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download xweb already downloading, ignore duplicated request");
            Context context = this.mController.ylL;
            this.mController.ylL.getString(R.string.tz);
            this.tipDialog = h.b(context, this.mController.ylL.getString(R.string.op), true, null);
            if (this.tipDialog.getWindow() != null) {
                LayoutParams attributes = this.tipDialog.getWindow().getAttributes();
                attributes.dimAmount = 0.0f;
                this.tipDialog.getWindow().setAttributes(attributes);
            }
            this.tipDialog.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(133170);
                    ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "cancle loading download background");
                    AppBrandXWebDownloadProxyUI.this.setResult(2, new Intent());
                    AppBrandXWebDownloadProxyUI.this.finish();
                    AppMethodBeat.o(133170);
                }
            });
            startTimer();
            AppMethodBeat.o(133183);
            return;
        }
        if (this.iJA == null) {
            this.iJA = new a(this, (byte) 0);
        }
        w.a(this.iJA);
        k.dTX();
        AppMethodBeat.o(133183);
    }

    private void startTimer() {
        AppMethodBeat.i(133184);
        this.mHandler = new Handler();
        this.iIH = new Runnable() {
            public final void run() {
                AppMethodBeat.i(133171);
                AppBrandXWebDownloadProxyUI.iII = true;
                AppBrandXWebDownloadProxyUI.this.setResult(0, new Intent());
                AppBrandXWebDownloadProxyUI.this.finish();
                AppMethodBeat.o(133171);
            }
        };
        this.mHandler.postDelayed(this.iIH, 20000);
        AppMethodBeat.o(133184);
    }

    public final void onDestroy() {
        AppMethodBeat.i(133185);
        ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDestroy");
        this.iJA = null;
        w.a(this.iJA);
        if (!(this.mHandler == null || this.iIH == null)) {
            this.mHandler.removeCallbacks(this.iIH);
        }
        super.onDestroy();
        AppMethodBeat.o(133185);
    }

    static /* synthetic */ void b(AppBrandXWebDownloadProxyUI appBrandXWebDownloadProxyUI) {
        AppMethodBeat.i(133187);
        if (appBrandXWebDownloadProxyUI.isFinishing() || appBrandXWebDownloadProxyUI.uiu) {
            AppMethodBeat.o(133187);
            return;
        }
        OnClickListener anonymousClass4 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(133174);
                com.tencent.mm.plugin.report.service.h.pYm.a(366, 2, 1, false);
                if (AppBrandXWebDownloadProxyUI.this.isFinishing() || AppBrandXWebDownloadProxyUI.this.uiu) {
                    AppMethodBeat.o(133174);
                    return;
                }
                AppBrandXWebDownloadProxyUI appBrandXWebDownloadProxyUI = AppBrandXWebDownloadProxyUI.this;
                Context context = AppBrandXWebDownloadProxyUI.this.mController.ylL;
                AppBrandXWebDownloadProxyUI.this.mController.ylL.getString(R.string.tz);
                appBrandXWebDownloadProxyUI.tipDialog = h.b(context, AppBrandXWebDownloadProxyUI.this.mController.ylL.getString(R.string.op), true, null);
                AppBrandXWebDownloadProxyUI.this.tipDialog.setOnCancelListener(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(133173);
                        ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "cancel loading download background");
                        AppBrandXWebDownloadProxyUI.this.setResult(2, new Intent());
                        AppBrandXWebDownloadProxyUI.this.finish();
                        AppMethodBeat.o(133173);
                    }
                });
                k.dTY();
                AppBrandXWebDownloadProxyUI.a(AppBrandXWebDownloadProxyUI.this);
                AppMethodBeat.o(133174);
            }
        };
        if (DebuggerShell.ayT()) {
            anonymousClass4.onClick(null, 0);
            AppMethodBeat.o(133187);
            return;
        }
        OnClickListener anonymousClass5 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(133175);
                com.tencent.mm.plugin.report.service.h.pYm.a(366, 3, 1, false);
                ab.i("MicroMsg.AppBrandXWebDownloadProxyUI", "user cancel");
                AppBrandXWebDownloadProxyUI.this.setResult(2, new Intent());
                AppBrandXWebDownloadProxyUI.this.finish();
                AppMethodBeat.o(133175);
            }
        };
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(appBrandXWebDownloadProxyUI.mController.ylL);
        aVar.asE(appBrandXWebDownloadProxyUI.mController.ylL.getString(R.string.oo));
        aVar.rc(false);
        aVar.Qc(R.string.on).a(anonymousClass4);
        aVar.Qd(R.string.om).b(anonymousClass5);
        aVar.aMb().show();
        com.tencent.mm.plugin.report.service.h.pYm.a(366, 1, 1, false);
        AppMethodBeat.o(133187);
    }
}
