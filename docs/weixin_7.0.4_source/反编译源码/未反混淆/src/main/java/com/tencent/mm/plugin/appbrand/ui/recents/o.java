package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.l;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.a.a;
import com.tencent.mm.ui.MMActivity;

public final class o extends a {
    private int huR = 0;
    private int iOK;
    private String iOL;

    public o(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final void eE(boolean z) {
        AppMethodBeat.i(133500);
        Class cls;
        if (z) {
            cls = AppBrandLauncherRecentsList.class;
        } else {
            cls = AppBrandLauncherBlankPage.class;
        }
        Fragment findFragmentById = ((MMActivity) getBaseContext()).getSupportFragmentManager().findFragmentById(16908290);
        if (findFragmentById != null && cls.isInstance(findFragmentById)) {
            AppMethodBeat.o(133500);
        } else if (((MMActivity) getBaseContext()).isFinishing() || ((MMActivity) getBaseContext()).uiu) {
            AppMethodBeat.o(133500);
        } else {
            AppBrandLauncherUI.Fragment appBrandLauncherRecentsList;
            m beginTransaction = ((MMActivity) getBaseContext()).getSupportFragmentManager().beginTransaction();
            if (z) {
                appBrandLauncherRecentsList = new AppBrandLauncherRecentsList(((MMActivity) getBaseContext()) instanceof AppBrandLauncherUI);
            } else {
                appBrandLauncherRecentsList = AppBrandLauncherBlankPage.cO(getString(R.string.i9), getString(R.string.kj));
            }
            appBrandLauncherRecentsList.setScene(this.iOK);
            appBrandLauncherRecentsList.iGQ = this.iOL;
            beginTransaction.b(16908290, appBrandLauncherRecentsList);
            beginTransaction.commit();
            AppMethodBeat.o(133500);
        }
    }

    public final void N(Intent intent) {
        AppMethodBeat.i(133501);
        this.iOK = intent.getIntExtra("extra_enter_scene", 1);
        this.iOL = intent.getStringExtra("extra_enter_scene_note");
        AppMethodBeat.o(133501);
    }

    public final void onActivityDidResume() {
        AppMethodBeat.i(133502);
        if (((MMActivity) getBaseContext()) instanceof AppBrandLauncherUI) {
            boolean z;
            if (!(i.axe() || i.axf() || q.axm())) {
                l.axj();
                if (!l.enabled()) {
                    z = false;
                    eE(z);
                    AppMethodBeat.o(133502);
                    return;
                }
            }
            z = true;
            eE(z);
            AppMethodBeat.o(133502);
            return;
        }
        ((MMActivity) getBaseContext()).setMMTitle((int) R.string.ki);
        int i = this.huR + 1;
        this.huR = i;
        if (i == 1) {
            eE(true);
        }
        AppMethodBeat.o(133502);
    }
}
