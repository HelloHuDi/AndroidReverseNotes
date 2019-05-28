package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends a implements g {
    int huR = 0;
    private Intent mIntent;

    static /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(132067);
        cVar.aHP();
        AppMethodBeat.o(132067);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean c(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        Class cls;
        AppMethodBeat.i(132059);
        try {
            cls = Class.forName(bo.nullAsNil(this.mIntent.getStringExtra("extra_launch_source_context")));
        } catch (Exception e) {
            cls = null;
        }
        if (cls == null || !AppBrandUI.class.isAssignableFrom(cls)) {
            boolean c = super.c(appBrandInitConfigWC, appBrandStatObject);
            AppMethodBeat.o(132059);
            return c;
        }
        AppMethodBeat.o(132059);
        return false;
    }

    public c(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        AppMethodBeat.i(132060);
        setBaseContext(appBrandLaunchProxyUI);
        this.ijC = false;
        AppMethodBeat.o(132060);
    }

    public final void E(Intent intent) {
        AppMethodBeat.i(132061);
        if (getBaseContext() != null && (getBaseContext() instanceof Activity)) {
            Activity activity = (Activity) getBaseContext();
            n.a(activity.getWindow());
            n.a(activity.getWindow(), true);
        }
        this.mIntent = intent;
        LaunchParcel launchParcel = (LaunchParcel) intent.getParcelableExtra("extra_launch_parcel");
        if (launchParcel == null) {
            finish();
            AppMethodBeat.o(132061);
            return;
        }
        a(launchParcel, g.a(launchParcel));
        AppMethodBeat.o(132061);
    }

    public final void onResume() {
        AppMethodBeat.i(132062);
        int i = this.huR + 1;
        this.huR = i;
        if (i > 1) {
            aHP();
        }
        AppMethodBeat.o(132062);
    }

    public final void onPause() {
        AppMethodBeat.i(132063);
        aHP();
        AppMethodBeat.o(132063);
    }

    public final void onDestroy() {
    }

    public final boolean aHO() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aHK() {
        AppMethodBeat.i(132064);
        String stringExtra = this.mIntent.getStringExtra("extra_launch_source_context");
        AppMethodBeat.o(132064);
        return stringExtra;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(132065);
        super.b(appBrandInitConfigWC, appBrandStatObject);
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(132058);
                new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(132057);
                        ab.i("MicroMsg.AppBrand.Precondition.FromClientPreconditionProcess", "finish(), before send result, ui finishing %b, ui destroyed %b", Boolean.valueOf(c.this.isFinishing()), Boolean.valueOf(c.this.aHN()));
                        ResultReceiver resultReceiver = (ResultReceiver) c.this.mIntent.getParcelableExtra("extra_result_receiver");
                        if (resultReceiver != null) {
                            resultReceiver.send(-1, Bundle.EMPTY);
                        }
                        c.b(c.this);
                        AppMethodBeat.o(132057);
                    }
                }.run();
                AppMethodBeat.o(132058);
            }
        };
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            al.d(anonymousClass1);
            AppMethodBeat.o(132065);
            return;
        }
        this.ijD.offer(anonymousClass1);
        AppMethodBeat.o(132065);
    }

    private void aHP() {
        AppMethodBeat.i(132066);
        if (isFinishing() || aHN()) {
            AppMethodBeat.o(132066);
            return;
        }
        super.aHL();
        AppMethodBeat.o(132066);
    }
}
