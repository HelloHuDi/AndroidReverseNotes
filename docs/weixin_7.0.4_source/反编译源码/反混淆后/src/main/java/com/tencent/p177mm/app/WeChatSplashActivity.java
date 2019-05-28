package com.tencent.p177mm.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.pluginsdk.C4736u;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.splash.SplashActivity;

/* renamed from: com.tencent.mm.app.WeChatSplashActivity */
public class WeChatSplashActivity extends SplashActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(137987);
        super.onCreate(bundle);
        MMActivity.initLanguage(getBaseContext());
        setContentView(2130971222);
        AppMethodBeat.m2505o(137987);
    }

    public Resources getResources() {
        AppMethodBeat.m2504i(137988);
        Resources resources;
        if (getAssets() == null || C4996ah.getResources() == null) {
            resources = super.getResources();
            AppMethodBeat.m2505o(137988);
            return resources;
        }
        resources = C4996ah.getResources();
        AppMethodBeat.m2505o(137988);
        return resources;
    }

    public Object getSystemService(String str) {
        AppMethodBeat.m2504i(137989);
        Object systemService = super.getSystemService(str);
        if ("layout_inflater".equals(str)) {
            LayoutInflater a = C5616v.m8408a((LayoutInflater) systemService);
            AppMethodBeat.m2505o(137989);
            return a;
        }
        AppMethodBeat.m2505o(137989);
        return systemService;
    }

    public void onPause() {
        AppMethodBeat.m2504i(137990);
        C4736u.dgS();
        super.onPause();
        AppMethodBeat.m2505o(137990);
    }
}
