package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.ae;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import java.util.LinkedList;
import java.util.Queue;
import org.xwalk.core.XWalkEnvironment;

public abstract class a extends MutableContextWrapper {
    protected boolean ijC = true;
    final Queue<Runnable> ijD = new LinkedList();
    private al ijE;

    public abstract String aHK();

    public a() {
        super(ah.getContext());
    }

    public final void setBaseContext(Context context) {
        super.setBaseContext(context);
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            while (!this.ijD.isEmpty()) {
                ((Runnable) this.ijD.poll()).run();
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void aHL() {
        J(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132046);
                ((AppBrandLaunchProxyUI) a.this.getBaseContext()).finish();
                a.this.setBaseContext(ah.getContext());
                AppMethodBeat.o(132046);
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final void finish() {
        b(null, null);
    }

    /* Access modifiers changed, original: protected */
    public Context aHM() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void b(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfigWC != null) {
            Context aHM = aHM();
            if (aHM == null) {
                aHM = getBaseContext();
            }
            j.b(aHM, appBrandInitConfigWC, appBrandStatObject);
        } else {
            this.ijC = true;
        }
        if (this.ijC) {
            aHL();
        }
        if (this.ijE != null) {
            this.ijE.aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132054);
                    Looper.myLooper().quit();
                    AppMethodBeat.o(132054);
                }
            });
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean c(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        int i;
        if (appBrandInitConfigWC.hgI || h.DS(appBrandInitConfigWC.appId) || appBrandInitConfigWC.xy() || appBrandInitConfigWC.hgJ) {
            i = 1;
        } else {
            i = 0;
        }
        return (i | f.d(appBrandInitConfigWC, appBrandStatObject)) == 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(final LaunchParcel launchParcel, final String str) {
        al alVar = new al("AppBrandLaunchProxyUI-PrepareThread");
        this.ijE = alVar;
        alVar.aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132053);
                e.aNX();
                new com.tencent.mm.plugin.appbrand.launching.e(launchParcel, str, new com.tencent.mm.plugin.appbrand.launching.d.a<AppBrandInitConfigWC>() {
                    public final /* synthetic */ void a(AppBrandInitConfigLU appBrandInitConfigLU, AppBrandStatObject appBrandStatObject, int i) {
                        AppMethodBeat.i(138136);
                        final AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) appBrandInitConfigLU;
                        if (!a.this.isFinishing()) {
                            if (appBrandInitConfigWC == null) {
                                i.b(launchParcel.appId, launchParcel.hgC, launchParcel.ijy);
                                a.this.finish();
                                AppMethodBeat.o(138136);
                                return;
                            }
                            launchParcel.c(appBrandInitConfigWC);
                            a.a(a.this, appBrandInitConfigWC);
                            final Runnable anonymousClass1 = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(132050);
                                    a.this.b(appBrandInitConfigWC, launchParcel.ijy);
                                    AppMethodBeat.o(132050);
                                }
                            };
                            if (c.aaZ()) {
                                c.a(a.this.getBaseContext(), com.tencent.mm.model.gdpr.a.MINI_PROGRAM, appBrandInitConfigWC.appId, new b() {
                                    public final void kL(int i) {
                                        AppMethodBeat.i(132051);
                                        if (i == 0) {
                                            anonymousClass1.run();
                                            AppMethodBeat.o(132051);
                                            return;
                                        }
                                        com.tencent.mm.plugin.appbrand.ipc.a.a(a.this.getBaseContext(), a.this.getBaseContext().getString(R.string.vg), a.this.getBaseContext().getString(R.string.vh), a.this.getBaseContext().getString(R.string.s6), null, null, null, null);
                                        a.this.finish();
                                        AppMethodBeat.o(132051);
                                    }
                                });
                                AppMethodBeat.o(138136);
                                return;
                            } else if (a.this.c(appBrandInitConfigWC, launchParcel.ijy)) {
                                a.this.J(new Runnable(anonymousClass1) {
                                    public final void run() {
                                        AppMethodBeat.i(132049);
                                        AnonymousClass1 anonymousClass1 = new ae() {
                                            public final void aHw() {
                                                AppMethodBeat.i(132047);
                                                a.this.finish();
                                                AppMethodBeat.o(132047);
                                            }

                                            public final void onReady() {
                                                AppMethodBeat.i(132048);
                                                r2.run();
                                                AppMethodBeat.o(132048);
                                            }
                                        };
                                        AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) a.this.getBaseContext();
                                        if (g.dnY()) {
                                            ab.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, gp version, just return");
                                            anonymousClass1.aHx();
                                            AppMethodBeat.o(132049);
                                            return;
                                        }
                                        if (XWalkEnvironment.getInstalledNewstVersion(ah.getContext()) > 400) {
                                            ab.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "have available version , no need check");
                                            anonymousClass1.onReady();
                                            AppMethodBeat.o(132049);
                                            return;
                                        }
                                        if (Math.abs(bo.anT() - com.tencent.mm.kernel.g.RP().Ry().a(com.tencent.mm.storage.ac.a.APPBRAND_TBS_CHECK_INSTALL_LAST_TIME_IN_SECOND_LONG, 0)) < 7200) {
                                            ab.i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, not exceed interval, just return");
                                            anonymousClass1.aHx();
                                            AppMethodBeat.o(132049);
                                            return;
                                        }
                                        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.APPBRAND_TBS_CHECK_INSTALL_LAST_TIME_IN_SECOND_LONG, Long.valueOf(bo.anT()));
                                        long anU = bo.anU();
                                        ab.d("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, cost = %d, xweb core ver = %d", Long.valueOf(bo.anU() - anU), Integer.valueOf(r2));
                                        if (appBrandLaunchProxyUI == null || !appBrandLaunchProxyUI.aHa()) {
                                            anonymousClass1.aHx();
                                            AppMethodBeat.o(132049);
                                            return;
                                        }
                                        appBrandLaunchProxyUI.a(anonymousClass1, new Intent().setClass(appBrandLaunchProxyUI.getBaseContext(), AppBrandXWebDownloadProxyUI.class).putExtra("intent_extra_download_ignore_network_type", true), anonymousClass1.requestCode);
                                        AppMethodBeat.o(132049);
                                    }
                                });
                            } else {
                                anonymousClass1.run();
                                AppMethodBeat.o(138136);
                                return;
                            }
                        }
                        AppMethodBeat.o(138136);
                    }
                }).run();
                AppMethodBeat.o(132053);
            }
        });
    }

    private void J(Runnable runnable) {
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            runnable.run();
        } else {
            this.ijD.offer(runnable);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean isFinishing() {
        return (getBaseContext() instanceof AppBrandLaunchProxyUI) && ((AppBrandLaunchProxyUI) getBaseContext()).isFinishing();
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aHN() {
        return (getBaseContext() instanceof AppBrandLaunchProxyUI) && ((AppBrandLaunchProxyUI) getBaseContext()).isDestroyed();
    }
}
