package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public class AppInstallerUI extends MMBaseActivity {
    private static AppInstallerUI xvC = null;
    private String cvZ;
    private String desc;
    private c gud = null;
    private int rlf;
    private c xvB = null;
    private OnClickListener xvD = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(28798);
            ab.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
            if (AppInstallerUI.this.rlf == 2) {
                i.aq(AppInstallerUI.this, 3);
            }
            String RP = com.tencent.mm.sandbox.monitor.c.RP(AppInstallerUI.this.cvZ);
            ab.d("MicroMsg.AppInstallerUI", RP);
            if (RP != null) {
                a.xxg.aB(1, true);
                h.pYm.a(405, 72, 1, true);
                AppInstallerUI.a(AppInstallerUI.this, RP);
                AppMethodBeat.o(28798);
                return;
            }
            h.pYm.a(405, 73, 1, true);
            ab.e("MicroMsg.AppInstallerUI", "pack not found!");
            com.tencent.mm.ui.base.h.bQ(AppInstallerUI.this, AppInstallerUI.this.getString(R.string.eyr));
            i.dnB();
            AppInstallerUI.this.finish();
            AppMethodBeat.o(28798);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppInstallerUI() {
        AppMethodBeat.i(28802);
        AppMethodBeat.o(28802);
    }

    public static AppInstallerUI dng() {
        return xvC;
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28803);
        super.onCreate(bundle);
        ab.d("MicroMsg.AppInstallerUI", "onCreate");
        com.tencent.mm.sandbox.c.l(hashCode(), this);
        MMActivity.initLanguage(this);
        if (AppUpdaterUI.dnh() != null && !AppUpdaterUI.dnh().isFinishing()) {
            ab.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
            finish();
            AppMethodBeat.o(28803);
        } else if (xvC == null || xvC.isFinishing() || xvC == this) {
            xvC = this;
            this.cvZ = i.dhU();
            if (bo.isNullOrNil(this.cvZ) || com.tencent.mm.sandbox.monitor.c.RP(this.cvZ) == null) {
                finish();
                AppMethodBeat.o(28803);
                return;
            }
            this.desc = i.dnt();
            this.rlf = i.dnu();
            setContentView(R.layout.v8);
            a aVar = new a(this);
            aVar.PV(R.string.byv);
            aVar.rc(true);
            aVar.f(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(28797);
                    AppInstallerUI.a(AppInstallerUI.this);
                    AppMethodBeat.o(28797);
                }
            });
            aVar.asE(getString(R.string.byy, new Object[]{this.desc}));
            aVar.Qc(R.string.cdx).a(false, this.xvD);
            aVar.Qd(R.string.eyp).b(null);
            this.gud = aVar.aMb();
            this.gud.setCanceledOnTouchOutside(false);
            this.gud.show();
            h.pYm.a(405, 71, 1, true);
            if (this.rlf == 2) {
                i.d(this, 2, i.dnv() + 1);
            }
            AppMethodBeat.o(28803);
        } else {
            ab.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
            finish();
            AppMethodBeat.o(28803);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(28804);
        ab.d("MicroMsg.AppInstallerUI", "onDestroy");
        if (this.gud != null && this.gud.isShowing()) {
            this.gud.dismiss();
        }
        if (this.xvB != null && this.xvB.isShowing()) {
            this.xvB.dismiss();
        }
        if (xvC == this) {
            xvC = null;
        }
        com.tencent.mm.sandbox.c.m(hashCode(), this);
        super.onDestroy();
        AppMethodBeat.o(28804);
    }

    static /* synthetic */ void a(AppInstallerUI appInstallerUI) {
        AppMethodBeat.i(28805);
        ab.d("MicroMsg.AppInstallerUI", "showInstallCancelAlert");
        if (appInstallerUI.gud != null && appInstallerUI.gud.isShowing()) {
            appInstallerUI.gud.dismiss();
        }
        if (appInstallerUI.xvB == null || !appInstallerUI.xvB.isShowing()) {
            appInstallerUI.xvB = com.tencent.mm.ui.base.h.a((Context) appInstallerUI, (int) R.string.ac0, (int) R.string.tz, (int) R.string.ac1, (int) R.string.b33, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(28800);
                    ab.d("MicroMsg.AppInstallerUI", "install dialog had been canceled");
                    if (AppInstallerUI.this.gud != null && AppInstallerUI.this.gud.isShowing()) {
                        AppInstallerUI.this.gud.dismiss();
                    }
                    a.xxg.aB(2, true);
                    if (AppInstallerUI.this.rlf == 2) {
                        i.aq(AppInstallerUI.this, 4);
                    }
                    h.pYm.a(405, 74, 1, true);
                    i.dnw();
                    AppInstallerUI.d(AppInstallerUI.this);
                    AppMethodBeat.o(28800);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(28801);
                    h.pYm.a(405, 75, 1, true);
                    if (!(AppInstallerUI.this.gud == null || AppInstallerUI.this.gud.isShowing())) {
                        AppInstallerUI.this.gud.show();
                    }
                    AppMethodBeat.o(28801);
                }
            });
            AppMethodBeat.o(28805);
            return;
        }
        ab.d("MicroMsg.AppInstallerUI", "cancelDialog already shown");
        AppMethodBeat.o(28805);
    }

    static /* synthetic */ void a(AppInstallerUI appInstallerUI, final String str) {
        AppMethodBeat.i(28806);
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(28799);
                i.aC(AppInstallerUI.this, str);
                AppInstallerUI.d(AppInstallerUI.this);
                AppMethodBeat.o(28799);
            }
        }, 300);
        AppMethodBeat.o(28806);
    }

    static /* synthetic */ void d(AppInstallerUI appInstallerUI) {
        AppMethodBeat.i(28807);
        appInstallerUI.finish();
        AppMethodBeat.o(28807);
    }
}
