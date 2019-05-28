package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public class AppUpdaterUI extends MMBaseActivity {
    private static AppUpdaterUI xvH = null;
    private c gud = null;
    private Button jAH;
    private OnClickListener xvD = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(28825);
            ab.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
            if (AppUpdaterUI.this.xvI.rlf == 1) {
                i.aq(AppUpdaterUI.this, 6);
            }
            if (!h.getExternalStorageState().equals("mounted")) {
                ab.e("MicroMsg.AppUpdaterUI", "no sdcard.");
                AppUpdaterUI.this.gud.dismiss();
                AppUpdaterUI.c(AppUpdaterUI.this);
                AppMethodBeat.o(28825);
            } else if ((AppUpdaterUI.this.xvI.cdh & 1) != 0) {
                ab.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
                Uri parse = Uri.parse(AppUpdaterUI.this.xvI.cdj);
                Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(268435456);
                if (parse == null || addFlags == null || !bo.k(AppUpdaterUI.this, addFlags)) {
                    ab.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
                    AppUpdaterUI.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
                } else {
                    ab.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
                    AppUpdaterUI.this.startActivity(addFlags);
                }
                AppUpdaterUI.f(AppUpdaterUI.this);
                AppMethodBeat.o(28825);
            } else {
                String bY = com.tencent.mm.sandbox.monitor.c.bY(AppUpdaterUI.this.xvI.cvZ, AppUpdaterUI.this.xvI.xwY);
                if (bo.isNullOrNil(bY) && AppUpdaterUI.this.xvI.xwT != null) {
                    bY = com.tencent.mm.sandbox.monitor.c.ama(AppUpdaterUI.this.xvI.xwT.cdx);
                }
                ab.d("MicroMsg.AppUpdaterUI", bY);
                if (bY != null) {
                    ab.i("MicroMsg.AppUpdaterUI", "update package already exist.");
                    AppUpdaterUI.a(AppUpdaterUI.this, 8);
                    if (AppUpdaterUI.this.xvI.xwU) {
                        AppUpdaterUI.a(AppUpdaterUI.this, 0);
                    } else {
                        AppUpdaterUI.a(AppUpdaterUI.this, 9);
                    }
                    AppUpdaterUI.this.xvI.aB(1, true);
                    AppUpdaterUI.this.xvJ.YJ(bY);
                    AppMethodBeat.o(28825);
                    return;
                }
                ab.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", Integer.valueOf(AppUpdaterUI.this.xvI.rlf));
                ab.d("MicroMsg.AppUpdaterUI", "current updateType : %s", Integer.valueOf(AppUpdaterUI.this.xvI.xvw));
                if (AppUpdaterUI.this.xvI.rlf == 0) {
                    AppUpdaterUI.this.xvI.dnC();
                    AppMethodBeat.o(28825);
                } else if (AppUpdaterUI.this.xvI.rlf == 1) {
                    ab.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
                    AppUpdaterUI.f(AppUpdaterUI.this);
                    Intent intent = new Intent(AppUpdaterUI.this.getIntent());
                    intent.setClass(AppUpdaterUI.this, UpdaterService.class);
                    intent.putExtra("intent_extra_run_in_foreground", true);
                    d.j(intent, "sandbox");
                    if (AppUpdaterUI.this.xvI.xwY) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(614, 56, 1, false);
                        ab.d("MicroMsg.AppUpdaterUI", "boots download start.");
                    }
                    AppMethodBeat.o(28825);
                } else {
                    ab.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
                    AppMethodBeat.o(28825);
                }
            }
        }
    };
    private Button xvG;
    private j xvI;
    private g xvJ = new g() {
        public final void dN(int i, int i2) {
            AppMethodBeat.i(28809);
            int i3 = (int) (i <= 0 ? 0 : (((long) i2) * 100) / ((long) i));
            if (i3 == 100) {
                AppUpdaterUI.this.xvG.setText(AppUpdaterUI.this.getString(R.string.eyy));
                AppMethodBeat.o(28809);
                return;
            }
            AppUpdaterUI.this.xvG.setText(AppUpdaterUI.this.getString(R.string.eyw) + i3 + "%");
            AppMethodBeat.o(28809);
        }

        public final void dnk() {
            AppMethodBeat.i(28810);
            ab.e("MicroMsg.AppUpdaterUI", "no sdcard.");
            if (AppUpdaterUI.this.gud != null) {
                AppUpdaterUI.this.gud.dismiss();
            }
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.o(28810);
                return;
            }
            AppUpdaterUI.c(AppUpdaterUI.this);
            AppMethodBeat.o(28810);
        }

        public final void dnl() {
            AppMethodBeat.i(28811);
            if (AppUpdaterUI.this.gud != null) {
                AppUpdaterUI.this.gud.dismiss();
            }
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.o(28811);
                return;
            }
            AppUpdaterUI.d(AppUpdaterUI.this);
            AppMethodBeat.o(28811);
        }

        public final void cpu() {
            AppMethodBeat.i(28812);
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.o(28812);
                return;
            }
            AppUpdaterUI.this.xvG.setText(R.string.eyw);
            AppUpdaterUI.this.xvG.setEnabled(false);
            AppMethodBeat.o(28812);
        }

        public final void YJ(String str) {
            AppMethodBeat.i(28813);
            if (AppUpdaterUI.this.gud != null) {
                AppUpdaterUI.this.gud.dismiss();
            }
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.o(28813);
                return;
            }
            ab.d("MicroMsg.AppUpdaterUI", str);
            if (str != null) {
                AppUpdaterUI.a(AppUpdaterUI.this, str);
                AppUpdaterUI.this.xvG.setEnabled(false);
            }
            AppMethodBeat.o(28813);
        }

        public final void a(com.tencent.mm.sandbox.monitor.c cVar) {
            AppMethodBeat.i(28814);
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.o(28814);
            } else if (cVar instanceof c) {
                com.tencent.mm.plugin.report.service.h.pYm.a(405, 67, 1, true);
                ab.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
                if (AppUpdaterUI.this.gud != null) {
                    AppUpdaterUI.this.gud.setMessage(AppUpdaterUI.this.getString(R.string.byx, new Object[]{AppUpdaterUI.this.xvI.desc, AppUpdaterUI.this.getString(R.string.eyt), bo.ga((long) AppUpdaterUI.this.xvI.size)}));
                }
                if (AppUpdaterUI.this.xvI.xwU) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(405, 68, 1, true);
                    AppUpdaterUI.a(AppUpdaterUI.this, cVar);
                }
                AppMethodBeat.o(28814);
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.a(405, 69, 1, true);
                com.tencent.mm.ui.base.h.a(AppUpdaterUI.this, (int) R.string.eyu, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(28808);
                        ab.d("MicroMsg.AppUpdaterUI", "go to WebView");
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
                        intent.addFlags(268435456);
                        AppUpdaterUI.this.startActivity(intent);
                        AppMethodBeat.o(28808);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(28814);
            }
        }
    };
    private OnClickListener xvK = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(28824);
            AppUpdaterUI.g(AppUpdaterUI.this);
            AppMethodBeat.o(28824);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppUpdaterUI() {
        AppMethodBeat.i(28830);
        AppMethodBeat.o(28830);
    }

    static /* synthetic */ void f(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.i(28839);
        appUpdaterUI.dnj();
        AppMethodBeat.o(28839);
    }

    public static AppUpdaterUI dnh() {
        return xvH;
    }

    public static void dni() {
        AppMethodBeat.i(28831);
        if (xvH != null) {
            xvH.dnj();
        }
        AppMethodBeat.o(28831);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28832);
        super.onCreate(bundle);
        ab.d("MicroMsg.AppUpdaterUI", "onCreate");
        com.tencent.mm.sandbox.c.l(hashCode(), this);
        MMActivity.initLanguage(this);
        if (AppInstallerUI.dng() != null && !AppInstallerUI.dng().isFinishing()) {
            ab.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
            finish();
            AppMethodBeat.o(28832);
        } else if (xvH == null || xvH.isFinishing() || xvH == this) {
            xvH = this;
            setContentView(R.layout.v8);
            this.xvI = a.xxg;
            if (!this.xvI.aK(getIntent())) {
                ab.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
                dnj();
                AppMethodBeat.o(28832);
            } else if (this.xvI.xvw != 999 || this.xvI.xvX == null || this.xvI.xvX.length <= 0) {
                String string;
                int i;
                ab.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.xvI.xvX);
                a aVar = new a(this);
                aVar.PV(R.string.byv);
                aVar.rc(true);
                aVar.f(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(28823);
                        AppUpdaterUI.g(AppUpdaterUI.this);
                        AppMethodBeat.o(28823);
                    }
                });
                if (!this.xvI.xwU || this.xvI.xwT == null) {
                    ab.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
                    string = getString(R.string.byx, new Object[]{this.xvI.desc, getString(R.string.eyt), bo.ga((long) this.xvI.size)});
                } else {
                    string = getString(R.string.byx, new Object[]{this.xvI.desc, getString(R.string.eyx), bo.ga((long) this.xvI.xwT.size)});
                }
                if (this.xvI.xvw != 1) {
                    i = R.string.eyp;
                } else {
                    i = R.string.eys;
                }
                aVar.asE(string);
                aVar.Qc(R.string.ez1).a(false, this.xvD);
                aVar.Qd(i);
                this.gud = aVar.aMb();
                this.gud.setCanceledOnTouchOutside(false);
                this.xvG = this.gud.getButton(-1);
                this.jAH = this.gud.getButton(-2);
                this.gud.show();
                if (this.xvI.rlf == 1) {
                    i.aq(this, 5);
                }
                if (this.xvI.xwY) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(614, 60, 1, false);
                }
                j jVar = this.xvI;
                g gVar = this.xvJ;
                if (!(gVar == null || jVar.xwP.contains(gVar))) {
                    jVar.xwP.add(gVar);
                }
                AppMethodBeat.o(28832);
            } else {
                ab.d("MicroMsg.AppUpdaterUI", "into emergency status");
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(28822);
                        com.tencent.mm.ui.base.h.a(AppUpdaterUI.this, AppUpdaterUI.this.xvI.desc, AppUpdaterUI.this.getString(R.string.tz), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(28820);
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(AppUpdaterUI.this.xvI.xvX[0]));
                                intent.addFlags(268435456);
                                ah.getContext().startActivity(intent);
                                AppUpdaterUI.f(AppUpdaterUI.this);
                                AppMethodBeat.o(28820);
                            }
                        }).setOnCancelListener(new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(28821);
                                AppUpdaterUI.f(AppUpdaterUI.this);
                                AppMethodBeat.o(28821);
                            }
                        });
                        AppMethodBeat.o(28822);
                    }
                }, 100);
                AppMethodBeat.o(28832);
            }
        } else {
            ab.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
            ab.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
            finish();
            AppMethodBeat.o(28832);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(28833);
        ab.d("MicroMsg.AppUpdaterUI", "onDestroy");
        com.tencent.mm.sandbox.c.m(hashCode(), this);
        if (this.xvI != null) {
            j jVar = this.xvI;
            jVar.xwP.remove(this.xvJ);
        }
        if (xvH == this) {
            xvH = null;
        }
        super.onDestroy();
        AppMethodBeat.o(28833);
    }

    private void dnj() {
        AppMethodBeat.i(28834);
        if (this.gud != null && this.gud.isShowing()) {
            this.gud.dismiss();
        }
        finish();
        AppMethodBeat.o(28834);
    }

    static /* synthetic */ void c(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.i(28835);
        ab.d("MicroMsg.AppUpdaterUI", "showNoSDCardAlert");
        com.tencent.mm.plugin.report.service.h.pYm.a(405, 65, 1, true);
        com.tencent.mm.ui.base.h.a((Context) appUpdaterUI, appUpdaterUI.getString(R.string.eyz), appUpdaterUI.getString(R.string.tz), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(28816);
                AppUpdaterUI.i(AppUpdaterUI.this);
                AppMethodBeat.o(28816);
            }
        }).setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(28817);
                AppUpdaterUI.i(AppUpdaterUI.this);
                AppMethodBeat.o(28817);
            }
        });
        AppMethodBeat.o(28835);
    }

    static /* synthetic */ void d(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.i(28836);
        ab.d("MicroMsg.AppUpdaterUI", "showSDCardFullAlert");
        com.tencent.mm.plugin.report.service.h.pYm.a(405, 66, 1, true);
        com.tencent.mm.ui.base.h.a((Context) appUpdaterUI, appUpdaterUI.getString(R.string.ez2), appUpdaterUI.getString(R.string.tz), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(28829);
                AppUpdaterUI.i(AppUpdaterUI.this);
                AppMethodBeat.o(28829);
            }
        }).setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(28815);
                AppUpdaterUI.i(AppUpdaterUI.this);
                AppMethodBeat.o(28815);
            }
        });
        AppMethodBeat.o(28836);
    }

    static /* synthetic */ void g(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.i(28840);
        ab.d("MicroMsg.AppUpdaterUI", "showDownloadCancelAlert");
        if (appUpdaterUI.xvI.xwZ) {
            com.tencent.mm.ui.base.h.b((Context) appUpdaterUI, (int) R.string.abz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(28818);
                    ab.d("MicroMsg.AppUpdaterUI", "update dialog had been canceled");
                    if (AppUpdaterUI.this.gud != null && AppUpdaterUI.this.gud.isShowing()) {
                        AppUpdaterUI.this.gud.dismiss();
                    }
                    AppUpdaterUI.a(AppUpdaterUI.this, 6);
                    if (AppUpdaterUI.this.xvI.xwY) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(614, 59, 1, true);
                        ab.d("MicroMsg.AppUpdaterUI", "boots download cancel when downloading.");
                    }
                    AppUpdaterUI.this.xvI.cancel();
                    AppUpdaterUI.this.xvI.aB(2, true);
                    AppUpdaterUI.f(AppUpdaterUI.this);
                    AppMethodBeat.o(28818);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(28819);
                    if (!(AppUpdaterUI.this.gud == null || AppUpdaterUI.this.gud.isShowing())) {
                        AppUpdaterUI.this.gud.show();
                    }
                    AppMethodBeat.o(28819);
                }
            });
            AppMethodBeat.o(28840);
            return;
        }
        if (appUpdaterUI.xvI.rlf == 1) {
            i.aq(appUpdaterUI, 7);
            if (appUpdaterUI.xvI.xwY) {
                com.tencent.mm.plugin.report.service.h.pYm.a(614, 57, 1, true);
                ab.d("MicroMsg.AppUpdaterUI", "boots download cancel.");
            }
        }
        i.ap(appUpdaterUI, 6);
        appUpdaterUI.xvI.aB(2, true);
        appUpdaterUI.dnj();
        AppMethodBeat.o(28840);
    }

    static /* synthetic */ void i(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.i(28842);
        appUpdaterUI.xvI.cancel();
        appUpdaterUI.xvI.aB(2, true);
        appUpdaterUI.dnj();
        AppMethodBeat.o(28842);
    }
}
