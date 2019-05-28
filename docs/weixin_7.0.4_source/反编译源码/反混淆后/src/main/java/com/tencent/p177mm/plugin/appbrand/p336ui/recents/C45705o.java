package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.content.Intent;
import android.support.p057v4.app.C0338m;
import android.support.p057v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.appusage.C19104i;
import com.tencent.p177mm.plugin.appbrand.appusage.C19109l;
import com.tencent.p177mm.plugin.appbrand.appusage.C42382q;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherBlankPage;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.p1233a.C24709a;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.o */
public final class C45705o extends C24709a {
    private int huR = 0;
    private int iOK;
    private String iOL;

    public C45705o(MMActivity mMActivity) {
        super(mMActivity);
    }

    /* renamed from: eE */
    public final void mo17538eE(boolean z) {
        AppMethodBeat.m2504i(133500);
        Class cls;
        if (z) {
            cls = AppBrandLauncherRecentsList.class;
        } else {
            cls = AppBrandLauncherBlankPage.class;
        }
        Fragment findFragmentById = ((MMActivity) getBaseContext()).getSupportFragmentManager().findFragmentById(16908290);
        if (findFragmentById != null && cls.isInstance(findFragmentById)) {
            AppMethodBeat.m2505o(133500);
        } else if (((MMActivity) getBaseContext()).isFinishing() || ((MMActivity) getBaseContext()).uiu) {
            AppMethodBeat.m2505o(133500);
        } else {
            AppBrandLauncherUI.Fragment appBrandLauncherRecentsList;
            C0338m beginTransaction = ((MMActivity) getBaseContext()).getSupportFragmentManager().beginTransaction();
            if (z) {
                appBrandLauncherRecentsList = new AppBrandLauncherRecentsList(((MMActivity) getBaseContext()) instanceof AppBrandLauncherUI);
            } else {
                appBrandLauncherRecentsList = AppBrandLauncherBlankPage.m65231cO(getString(C25738R.string.f8887i9), getString(C25738R.string.f8950kj));
            }
            appBrandLauncherRecentsList.setScene(this.iOK);
            appBrandLauncherRecentsList.iGQ = this.iOL;
            beginTransaction.mo556b(16908290, appBrandLauncherRecentsList);
            beginTransaction.commit();
            AppMethodBeat.m2505o(133500);
        }
    }

    /* renamed from: N */
    public final void mo41600N(Intent intent) {
        AppMethodBeat.m2504i(133501);
        this.iOK = intent.getIntExtra("extra_enter_scene", 1);
        this.iOL = intent.getStringExtra("extra_enter_scene_note");
        AppMethodBeat.m2505o(133501);
    }

    public final void onActivityDidResume() {
        AppMethodBeat.m2504i(133502);
        if (((MMActivity) getBaseContext()) instanceof AppBrandLauncherUI) {
            boolean z;
            if (!(C19104i.axe() || C19104i.axf() || C42382q.axm())) {
                C19109l.axj();
                if (!C19109l.enabled()) {
                    z = false;
                    mo17538eE(z);
                    AppMethodBeat.m2505o(133502);
                    return;
                }
            }
            z = true;
            mo17538eE(z);
            AppMethodBeat.m2505o(133502);
            return;
        }
        ((MMActivity) getBaseContext()).setMMTitle((int) C25738R.string.f8949ki);
        int i = this.huR + 1;
        this.huR = i;
        if (i == 1) {
            mo17538eE(true);
        }
        AppMethodBeat.m2505o(133502);
    }
}
