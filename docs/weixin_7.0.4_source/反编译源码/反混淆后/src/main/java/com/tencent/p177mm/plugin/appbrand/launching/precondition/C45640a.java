package com.tencent.p177mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.gdpr.C32791a;
import com.tencent.p177mm.model.gdpr.C32792b;
import com.tencent.p177mm.model.gdpr.C37918c;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.ipc.C26907a;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C10486i;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.launching.C27164d.C27163a;
import com.tencent.p177mm.plugin.appbrand.launching.C31317e;
import com.tencent.p177mm.plugin.appbrand.launching.C45635ae;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage.C38435f;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandXWebDownloadProxyUI;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.LinkedList;
import java.util.Queue;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.a */
public abstract class C45640a extends MutableContextWrapper {
    protected boolean ijC = true;
    final Queue<Runnable> ijD = new LinkedList();
    private C5004al ijE;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.a$1 */
    class C271771 implements Runnable {
        C271771() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132046);
            ((AppBrandLaunchProxyUI) C45640a.this.getBaseContext()).finish();
            C45640a.this.setBaseContext(C4996ah.getContext());
            AppMethodBeat.m2505o(132046);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.a$4 */
    class C384234 implements Runnable {
        C384234() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132054);
            Looper.myLooper().quit();
            AppMethodBeat.m2505o(132054);
        }
    }

    public abstract String aHK();

    public C45640a() {
        super(C4996ah.getContext());
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
        m84270J(new C271771());
    }

    /* Access modifiers changed, original: protected|final */
    public final void finish() {
        mo73416b(null, null);
    }

    /* Access modifiers changed, original: protected */
    public Context aHM() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo73416b(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfigWC != null) {
            Context aHM = aHM();
            if (aHM == null) {
                aHM = getBaseContext();
            }
            C42615j.m75457b(aHM, appBrandInitConfigWC, appBrandStatObject);
        } else {
            this.ijC = true;
        }
        if (this.ijC) {
            aHL();
        }
        if (this.ijE != null) {
            this.ijE.mo10302aa(new C384234());
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public boolean mo73417c(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        int i;
        if (appBrandInitConfigWC.hgI || C45694h.m84416DS(appBrandInitConfigWC.appId) || appBrandInitConfigWC.mo32992xy() || appBrandInitConfigWC.hgJ) {
            i = 1;
        } else {
            i = 0;
        }
        return (i | C38435f.m65032d(appBrandInitConfigWC, appBrandStatObject)) == 0;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo73413a(final LaunchParcel launchParcel, final String str) {
        C5004al c5004al = new C5004al("AppBrandLaunchProxyUI-PrepareThread");
        this.ijE = c5004al;
        c5004al.mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.a$3$1 */
            class C313181 implements C27163a<AppBrandInitConfigWC> {
                C313181() {
                }

                /* renamed from: a */
                public final /* synthetic */ void mo44834a(AppBrandInitConfigLU appBrandInitConfigLU, AppBrandStatObject appBrandStatObject, int i) {
                    AppMethodBeat.m2504i(138136);
                    final AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) appBrandInitConfigLU;
                    if (!C45640a.this.isFinishing()) {
                        if (appBrandInitConfigWC == null) {
                            C10486i.m18201b(launchParcel.appId, launchParcel.hgC, launchParcel.ijy);
                            C45640a.this.finish();
                            AppMethodBeat.m2505o(138136);
                            return;
                        }
                        launchParcel.mo34789c(appBrandInitConfigWC);
                        C45640a.m84271a(C45640a.this, appBrandInitConfigWC);
                        final Runnable c23811 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(132050);
                                C45640a.this.mo73416b(appBrandInitConfigWC, launchParcel.ijy);
                                AppMethodBeat.m2505o(132050);
                            }
                        };
                        if (C37918c.aaZ()) {
                            C37918c.m64041a(C45640a.this.getBaseContext(), C32791a.MINI_PROGRAM, appBrandInitConfigWC.appId, new C32792b() {
                                /* renamed from: kL */
                                public final void mo8219kL(int i) {
                                    AppMethodBeat.m2504i(132051);
                                    if (i == 0) {
                                        c23811.run();
                                        AppMethodBeat.m2505o(132051);
                                        return;
                                    }
                                    C26907a.m42842a(C45640a.this.getBaseContext(), C45640a.this.getBaseContext().getString(C25738R.string.f9282vg), C45640a.this.getBaseContext().getString(C25738R.string.f9283vh), C45640a.this.getBaseContext().getString(C25738R.string.f9187s6), null, null, null, null);
                                    C45640a.this.finish();
                                    AppMethodBeat.m2505o(132051);
                                }
                            });
                            AppMethodBeat.m2505o(138136);
                            return;
                        } else if (C45640a.this.mo73417c(appBrandInitConfigWC, launchParcel.ijy)) {
                            C45640a.this.m84270J(new Runnable(c23811) {

                                /* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.a$2$1 */
                                class C23801 extends C45635ae {
                                    C23801() {
                                    }

                                    public final void aHw() {
                                        AppMethodBeat.m2504i(132047);
                                        C45640a.this.finish();
                                        AppMethodBeat.m2505o(132047);
                                    }

                                    public final void onReady() {
                                        AppMethodBeat.m2504i(132048);
                                        r2.run();
                                        AppMethodBeat.m2505o(132048);
                                    }
                                }

                                public final void run() {
                                    AppMethodBeat.m2504i(132049);
                                    C23801 c23801 = new C23801();
                                    AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) C45640a.this.getBaseContext();
                                    if (C5059g.dnY()) {
                                        C4990ab.m7416i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, gp version, just return");
                                        c23801.aHx();
                                        AppMethodBeat.m2505o(132049);
                                        return;
                                    }
                                    if (XWalkEnvironment.getInstalledNewstVersion(C4996ah.getContext()) > 400) {
                                        C4990ab.m7416i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "have available version , no need check");
                                        c23801.onReady();
                                        AppMethodBeat.m2505o(132049);
                                        return;
                                    }
                                    if (Math.abs(C5046bo.anT() - C1720g.m3536RP().mo5239Ry().mo16814a(C5127a.APPBRAND_TBS_CHECK_INSTALL_LAST_TIME_IN_SECOND_LONG, 0)) < 7200) {
                                        C4990ab.m7416i("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, not exceed interval, just return");
                                        c23801.aHx();
                                        AppMethodBeat.m2505o(132049);
                                        return;
                                    }
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.APPBRAND_TBS_CHECK_INSTALL_LAST_TIME_IN_SECOND_LONG, Long.valueOf(C5046bo.anT()));
                                    long anU = C5046bo.anU();
                                    C4990ab.m7411d("MicroMsg.AppBrand.PreLaunchCheckForXWEB", "check xweb download, cost = %d, xweb core ver = %d", Long.valueOf(C5046bo.anU() - anU), Integer.valueOf(r2));
                                    if (appBrandLaunchProxyUI == null || !appBrandLaunchProxyUI.aHa()) {
                                        c23801.aHx();
                                        AppMethodBeat.m2505o(132049);
                                        return;
                                    }
                                    appBrandLaunchProxyUI.mo30646a(c23801, new Intent().setClass(appBrandLaunchProxyUI.getBaseContext(), AppBrandXWebDownloadProxyUI.class).putExtra("intent_extra_download_ignore_network_type", true), c23801.requestCode);
                                    AppMethodBeat.m2505o(132049);
                                }
                            });
                        } else {
                            c23811.run();
                            AppMethodBeat.m2505o(138136);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(138136);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(132053);
                C42677e.aNX();
                new C31317e(launchParcel, str, new C313181()).run();
                AppMethodBeat.m2505o(132053);
            }
        });
    }

    /* renamed from: J */
    private void m84270J(Runnable runnable) {
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
