package com.tencent.p177mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.quality.C2453g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.c */
public final class C46895c extends C45640a implements C19583g {
    int huR = 0;
    private Intent mIntent;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.c$1 */
    class C426121 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.c$1$1 */
        class C384251 implements Runnable {
            C384251() {
            }

            public final void run() {
                AppMethodBeat.m2504i(132057);
                C4990ab.m7417i("MicroMsg.AppBrand.Precondition.FromClientPreconditionProcess", "finish(), before send result, ui finishing %b, ui destroyed %b", Boolean.valueOf(C46895c.this.isFinishing()), Boolean.valueOf(C46895c.this.aHN()));
                ResultReceiver resultReceiver = (ResultReceiver) C46895c.this.mIntent.getParcelableExtra("extra_result_receiver");
                if (resultReceiver != null) {
                    resultReceiver.send(-1, Bundle.EMPTY);
                }
                C46895c.m89253b(C46895c.this);
                AppMethodBeat.m2505o(132057);
            }
        }

        C426121() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132058);
            new C384251().run();
            AppMethodBeat.m2505o(132058);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m89253b(C46895c c46895c) {
        AppMethodBeat.m2504i(132067);
        c46895c.aHP();
        AppMethodBeat.m2505o(132067);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final boolean mo73417c(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        Class cls;
        AppMethodBeat.m2504i(132059);
        try {
            cls = Class.forName(C5046bo.nullAsNil(this.mIntent.getStringExtra("extra_launch_source_context")));
        } catch (Exception e) {
            cls = null;
        }
        if (cls == null || !AppBrandUI.class.isAssignableFrom(cls)) {
            boolean c = super.mo73417c(appBrandInitConfigWC, appBrandStatObject);
            AppMethodBeat.m2505o(132059);
            return c;
        }
        AppMethodBeat.m2505o(132059);
        return false;
    }

    public C46895c(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        AppMethodBeat.m2504i(132060);
        setBaseContext(appBrandLaunchProxyUI);
        this.ijC = false;
        AppMethodBeat.m2505o(132060);
    }

    /* renamed from: E */
    public final void mo34794E(Intent intent) {
        AppMethodBeat.m2504i(132061);
        if (getBaseContext() != null && (getBaseContext() instanceof Activity)) {
            Activity activity = (Activity) getBaseContext();
            C42696n.m75615a(activity.getWindow());
            C42696n.m75616a(activity.getWindow(), true);
        }
        this.mIntent = intent;
        LaunchParcel launchParcel = (LaunchParcel) intent.getParcelableExtra("extra_launch_parcel");
        if (launchParcel == null) {
            finish();
            AppMethodBeat.m2505o(132061);
            return;
        }
        mo73413a(launchParcel, C2453g.m4694a(launchParcel));
        AppMethodBeat.m2505o(132061);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(132062);
        int i = this.huR + 1;
        this.huR = i;
        if (i > 1) {
            aHP();
        }
        AppMethodBeat.m2505o(132062);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(132063);
        aHP();
        AppMethodBeat.m2505o(132063);
    }

    public final void onDestroy() {
    }

    public final boolean aHO() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aHK() {
        AppMethodBeat.m2504i(132064);
        String stringExtra = this.mIntent.getStringExtra("extra_launch_source_context");
        AppMethodBeat.m2505o(132064);
        return stringExtra;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo73416b(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(132065);
        super.mo73416b(appBrandInitConfigWC, appBrandStatObject);
        C426121 c426121 = new C426121();
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            C5004al.m7441d(c426121);
            AppMethodBeat.m2505o(132065);
            return;
        }
        this.ijD.offer(c426121);
        AppMethodBeat.m2505o(132065);
    }

    private void aHP() {
        AppMethodBeat.m2504i(132066);
        if (isFinishing() || aHN()) {
            AppMethodBeat.m2505o(132066);
            return;
        }
        super.aHL();
        AppMethodBeat.m2505o(132066);
    }
}
