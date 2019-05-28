package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.t;
import com.tencent.mm.plugin.appbrand.ui.u;
import com.tencent.mm.ui.base.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public final class l extends a {
    boolean gOF = false;
    boolean gOG = false;
    private boolean gOQ = false;

    static /* synthetic */ void a(l lVar, i iVar, i iVar2, Runnable runnable) {
        AppMethodBeat.i(128972);
        super.b(iVar, iVar2, runnable);
        AppMethodBeat.o(128972);
    }

    public l(i iVar) {
        super(iVar, o.class);
        AppMethodBeat.i(128961);
        this.gNy.getApplication().registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.r.a() {
            public final void onActivityResumed(Activity activity) {
                if (l.this.gNy == activity) {
                    l.this.gOF = true;
                    l.this.gOG = false;
                }
            }

            public final void onActivityPaused(Activity activity) {
                if (l.this.gNy == activity) {
                    l.this.gOF = false;
                    l.this.gOG = true;
                }
            }

            public final void onActivityDestroyed(Activity activity) {
                AppMethodBeat.i(128959);
                l.this.gNy.getApplication().unregisterActivityLifecycleCallbacks(this);
                AppMethodBeat.o(128959);
            }
        });
        AppMethodBeat.o(128961);
    }

    public final Activity getContext() {
        return this.gNy;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(i iVar, i iVar2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(128962);
        if (iVar != null) {
            g.a(iVar.mAppId, d.LAUNCH_MINI_PROGRAM);
        }
        if (iVar == null || !j.a((o) iVar, (o) iVar2, (AppBrandInitConfigWC) appBrandInitConfig)) {
            if (p.f(appBrandInitConfig)) {
                atB();
            }
            this.gOQ = true;
            if (p.f(appBrandInitConfig)) {
                a.asC();
            }
            super.a(iVar, iVar2, appBrandInitConfig);
            this.gOQ = false;
            if (iVar != null) {
                ((u) e.B(u.class)).a(iVar2, iVar);
            }
            AppMethodBeat.o(128962);
            return;
        }
        AppMethodBeat.o(128962);
    }

    /* Access modifiers changed, original: protected|final */
    public final i e(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(128963);
        o a = f.a((AppBrandInitConfigWC) appBrandInitConfig, this);
        if (a != null) {
            AppMethodBeat.o(128963);
            return a;
        }
        i e = super.e(appBrandInitConfig);
        AppMethodBeat.o(128963);
        return e;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(i iVar, i iVar2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(128964);
        if (iVar != null) {
            g.a(iVar.mAppId, d.LAUNCH_MINI_PROGRAM);
        }
        if (p.f(appBrandInitConfig)) {
            atB();
        }
        int indexOf = aty().indexOf(iVar2);
        if (indexOf > 0) {
            i iVar3;
            LinkedList linkedList = new LinkedList();
            ListIterator listIterator = aty().listIterator(indexOf);
            while (listIterator.hasPrevious()) {
                iVar3 = (i) listIterator.previous();
                if (!(iVar3 == iVar2 || iVar3 == iVar || !p.l(iVar3))) {
                    linkedList.add(iVar3);
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                iVar3 = (i) it.next();
                iVar3.gNT = false;
                super.j(iVar3);
                super.f(iVar3);
            }
        }
        super.b(iVar, iVar2, appBrandInitConfig);
        if (iVar != null) {
            ((u) e.B(u.class)).a(iVar2, iVar);
        }
        AppMethodBeat.o(128964);
    }

    public final void a(i iVar, MiniProgramNavigationBackResult miniProgramNavigationBackResult) {
        AppMethodBeat.i(128965);
        if (miniProgramNavigationBackResult != null) {
            try {
                if (this.gNy instanceof AppBrandEmbedUI) {
                    Intent intent = new Intent();
                    intent.putExtra("result_key_mini_program_navigate_back_result", miniProgramNavigationBackResult);
                    this.gNy.setResult(-1, intent);
                    this.gNy.finish();
                    AppMethodBeat.o(128965);
                    return;
                }
            } catch (Exception e) {
                com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.AppBrandRuntimeContainerWC", e, "close runtime %s", iVar.mAppId);
            }
        }
        super.a(iVar, miniProgramNavigationBackResult);
        AppMethodBeat.o(128965);
    }

    private void du(boolean z) {
        AppMethodBeat.i(128966);
        if (!(this.gOQ || this.gNy.isFinishing())) {
            boolean z2 = (this.gNy instanceof t) && ((t) this.gNy).aLZ();
            if (z2 && z) {
                this.gNy.moveTaskToBack(true);
            } else {
                this.gNy.finish();
            }
            if (this.gOB.size() <= 0) {
                this.gNy.overridePendingTransition(0, 0);
            }
        }
        AppMethodBeat.o(128966);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(final i iVar, final i iVar2, final Runnable runnable) {
        String str;
        AppMethodBeat.i(128967);
        String str2 = "MicroMsg.AppBrandRuntimeContainerWC";
        String str3 = "onRuntimeClose entered, in.appId[%s], out.appId[%s], out.isFinishing[%b], out.canDoCloseAnimation[%b], mIsActivityPaused[%b], stackSize[%d]";
        Object[] objArr = new Object[6];
        if (iVar == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = iVar.mAppId;
        }
        objArr[0] = str;
        objArr[1] = iVar2.mAppId;
        objArr[2] = Boolean.valueOf(iVar2.Pf);
        objArr[3] = Boolean.valueOf(iVar2.ato());
        objArr[4] = Boolean.valueOf(this.gOG);
        objArr[5] = Integer.valueOf(this.gOB.size());
        com.tencent.luggage.g.d.i(str2, str3, objArr);
        AnonymousClass2 anonymousClass2 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(128960);
                l.a(l.this, iVar, iVar2, runnable);
                AppMethodBeat.o(128960);
            }
        };
        if (this.gOG) {
            iVar2.gNT = false;
        }
        if (iVar2.Pf) {
            if (!e(iVar2)) {
                anonymousClass2.run();
                AppMethodBeat.o(128967);
                return;
            } else if (this.gOB.size() > 1) {
                if (iVar2.ato()) {
                    ((u) e.B(u.class)).a(iVar, iVar2, anonymousClass2);
                } else {
                    anonymousClass2.run();
                }
                if (iVar != null) {
                    atA();
                    AppMethodBeat.o(128967);
                    return;
                }
            } else {
                du(false);
            }
        } else if (this.gOB.size() > 1) {
            if (iVar2.ato()) {
                ((u) e.B(u.class)).a(iVar, iVar2, anonymousClass2);
            } else {
                anonymousClass2.run();
            }
            if (iVar != null) {
                atA();
                AppMethodBeat.o(128967);
                return;
            }
        } else {
            du(true);
            AppMethodBeat.o(128967);
            return;
        }
        AppMethodBeat.o(128967);
    }

    public final void onBackPressed() {
        AppMethodBeat.i(128971);
        if (atC()) {
            AppMethodBeat.o(128971);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(128971);
    }

    private void atA() {
        AppMethodBeat.i(128968);
        if (this.gNy instanceof AppBrandPluginUI) {
            b.a(this.gNy, null);
        }
        AppMethodBeat.o(128968);
    }

    private void atB() {
        AppMethodBeat.i(128969);
        if (this.gNy instanceof AppBrandPluginUI) {
            b.au(this.gNy);
        }
        AppMethodBeat.o(128969);
    }

    public final boolean atC() {
        AppMethodBeat.i(128970);
        if (this.gOB.size() <= 0) {
            du(false);
            AppMethodBeat.o(128970);
            return true;
        }
        AppMethodBeat.o(128970);
        return false;
    }
}
