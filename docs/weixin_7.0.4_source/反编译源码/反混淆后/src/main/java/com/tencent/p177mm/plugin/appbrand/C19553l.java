package com.tencent.p177mm.plugin.appbrand;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.sdk.p148b.C0993a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C10489j;
import com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage.C38435f;
import com.tencent.p177mm.plugin.appbrand.p328r.C27276a;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandEmbedUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandPluginUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.C27350t;
import com.tencent.p177mm.plugin.appbrand.p336ui.C38565u;
import com.tencent.p177mm.plugin.appbrand.task.C38520i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* renamed from: com.tencent.mm.plugin.appbrand.l */
public final class C19553l extends C0993a {
    boolean gOF = false;
    boolean gOG = false;
    private boolean gOQ = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.l$1 */
    class C195541 extends C27276a {
        C195541() {
        }

        public final void onActivityResumed(Activity activity) {
            if (C19553l.this.gNy == activity) {
                C19553l.this.gOF = true;
                C19553l.this.gOG = false;
            }
        }

        public final void onActivityPaused(Activity activity) {
            if (C19553l.this.gNy == activity) {
                C19553l.this.gOF = false;
                C19553l.this.gOG = true;
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            AppMethodBeat.m2504i(128959);
            C19553l.this.gNy.getApplication().unregisterActivityLifecycleCallbacks(this);
            AppMethodBeat.m2505o(128959);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m30323a(C19553l c19553l, C6750i c6750i, C6750i c6750i2, Runnable runnable) {
        AppMethodBeat.m2504i(128972);
        super.mo34756b(c6750i, c6750i2, runnable);
        AppMethodBeat.m2505o(128972);
    }

    public C19553l(C38520i c38520i) {
        super(c38520i, C41243o.class);
        AppMethodBeat.m2504i(128961);
        this.gNy.getApplication().registerActivityLifecycleCallbacks(new C195541());
        AppMethodBeat.m2505o(128961);
    }

    public final Activity getContext() {
        return this.gNy;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo34753a(C6750i c6750i, C6750i c6750i2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(128962);
        if (c6750i != null) {
            C33183g.m54275a(c6750i.mAppId, C33184d.LAUNCH_MINI_PROGRAM);
        }
        if (c6750i == null || !C10489j.m18204a((C41243o) c6750i, (C41243o) c6750i2, (AppBrandInitConfigWC) appBrandInitConfig)) {
            if (C42641p.m75511f(appBrandInitConfig)) {
                atB();
            }
            this.gOQ = true;
            if (C42641p.m75511f(appBrandInitConfig)) {
                C10048a.asC();
            }
            super.mo34753a(c6750i, c6750i2, appBrandInitConfig);
            this.gOQ = false;
            if (c6750i != null) {
                ((C38565u) C37384e.m62985B(C38565u.class)).mo32997a(c6750i2, c6750i);
            }
            AppMethodBeat.m2505o(128962);
            return;
        }
        AppMethodBeat.m2505o(128962);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: e */
    public final C6750i mo34757e(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(128963);
        C41243o a = C38435f.m65030a((AppBrandInitConfigWC) appBrandInitConfig, this);
        if (a != null) {
            AppMethodBeat.m2505o(128963);
            return a;
        }
        C6750i e = super.mo34757e(appBrandInitConfig);
        AppMethodBeat.m2505o(128963);
        return e;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo34755b(C6750i c6750i, C6750i c6750i2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(128964);
        if (c6750i != null) {
            C33183g.m54275a(c6750i.mAppId, C33184d.LAUNCH_MINI_PROGRAM);
        }
        if (C42641p.m75511f(appBrandInitConfig)) {
            atB();
        }
        int indexOf = aty().indexOf(c6750i2);
        if (indexOf > 0) {
            C6750i c6750i3;
            LinkedList linkedList = new LinkedList();
            ListIterator listIterator = aty().listIterator(indexOf);
            while (listIterator.hasPrevious()) {
                c6750i3 = (C6750i) listIterator.previous();
                if (!(c6750i3 == c6750i2 || c6750i3 == c6750i || !C42641p.m75513l(c6750i3))) {
                    linkedList.add(c6750i3);
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                c6750i3 = (C6750i) it.next();
                c6750i3.gNT = false;
                super.mo44515j(c6750i3);
                super.mo44514f(c6750i3);
            }
        }
        super.mo34755b(c6750i, c6750i2, appBrandInitConfig);
        if (c6750i != null) {
            ((C38565u) C37384e.m62985B(C38565u.class)).mo32997a(c6750i2, c6750i);
        }
        AppMethodBeat.m2505o(128964);
    }

    /* renamed from: a */
    public final void mo34752a(C6750i c6750i, MiniProgramNavigationBackResult miniProgramNavigationBackResult) {
        AppMethodBeat.m2504i(128965);
        if (miniProgramNavigationBackResult != null) {
            try {
                if (this.gNy instanceof AppBrandEmbedUI) {
                    Intent intent = new Intent();
                    intent.putExtra("result_key_mini_program_navigate_back_result", miniProgramNavigationBackResult);
                    this.gNy.setResult(-1, intent);
                    this.gNy.finish();
                    AppMethodBeat.m2505o(128965);
                    return;
                }
            } catch (Exception e) {
                C45124d.printErrStackTrace("MicroMsg.AppBrandRuntimeContainerWC", e, "close runtime %s", c6750i.mAppId);
            }
        }
        super.mo34752a(c6750i, miniProgramNavigationBackResult);
        AppMethodBeat.m2505o(128965);
    }

    /* renamed from: du */
    private void m30324du(boolean z) {
        AppMethodBeat.m2504i(128966);
        if (!(this.gOQ || this.gNy.isFinishing())) {
            boolean z2 = (this.gNy instanceof C27350t) && ((C27350t) this.gNy).aLZ();
            if (z2 && z) {
                this.gNy.moveTaskToBack(true);
            } else {
                this.gNy.finish();
            }
            if (this.gOB.size() <= 0) {
                this.gNy.overridePendingTransition(0, 0);
            }
        }
        AppMethodBeat.m2505o(128966);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo34756b(final C6750i c6750i, final C6750i c6750i2, final Runnable runnable) {
        String str;
        AppMethodBeat.m2504i(128967);
        String str2 = "MicroMsg.AppBrandRuntimeContainerWC";
        String str3 = "onRuntimeClose entered, in.appId[%s], out.appId[%s], out.isFinishing[%b], out.canDoCloseAnimation[%b], mIsActivityPaused[%b], stackSize[%d]";
        Object[] objArr = new Object[6];
        if (c6750i == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = c6750i.mAppId;
        }
        objArr[0] = str;
        objArr[1] = c6750i2.mAppId;
        objArr[2] = Boolean.valueOf(c6750i2.f1966Pf);
        objArr[3] = Boolean.valueOf(c6750i2.ato());
        objArr[4] = Boolean.valueOf(this.gOG);
        objArr[5] = Integer.valueOf(this.gOB.size());
        C45124d.m82930i(str2, str3, objArr);
        C195362 c195362 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(128960);
                C19553l.m30323a(C19553l.this, c6750i, c6750i2, runnable);
                AppMethodBeat.m2505o(128960);
            }
        };
        if (this.gOG) {
            c6750i2.gNT = false;
        }
        if (c6750i2.f1966Pf) {
            if (!mo51269e(c6750i2)) {
                c195362.run();
                AppMethodBeat.m2505o(128967);
                return;
            } else if (this.gOB.size() > 1) {
                if (c6750i2.ato()) {
                    ((C38565u) C37384e.m62985B(C38565u.class)).mo32998a(c6750i, c6750i2, c195362);
                } else {
                    c195362.run();
                }
                if (c6750i != null) {
                    atA();
                    AppMethodBeat.m2505o(128967);
                    return;
                }
            } else {
                m30324du(false);
            }
        } else if (this.gOB.size() > 1) {
            if (c6750i2.ato()) {
                ((C38565u) C37384e.m62985B(C38565u.class)).mo32998a(c6750i, c6750i2, c195362);
            } else {
                c195362.run();
            }
            if (c6750i != null) {
                atA();
                AppMethodBeat.m2505o(128967);
                return;
            }
        } else {
            m30324du(true);
            AppMethodBeat.m2505o(128967);
            return;
        }
        AppMethodBeat.m2505o(128967);
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(128971);
        if (atC()) {
            AppMethodBeat.m2505o(128971);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.m2505o(128971);
    }

    private void atA() {
        AppMethodBeat.m2504i(128968);
        if (this.gNy instanceof AppBrandPluginUI) {
            C5274b.m8045a(this.gNy, null);
        }
        AppMethodBeat.m2505o(128968);
    }

    private void atB() {
        AppMethodBeat.m2504i(128969);
        if (this.gNy instanceof AppBrandPluginUI) {
            C5274b.m8050au(this.gNy);
        }
        AppMethodBeat.m2505o(128969);
    }

    public final boolean atC() {
        AppMethodBeat.m2504i(128970);
        if (this.gOB.size() <= 0) {
            m30324du(false);
            AppMethodBeat.m2505o(128970);
            return true;
        }
        AppMethodBeat.m2505o(128970);
        return false;
    }
}
