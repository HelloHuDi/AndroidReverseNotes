package com.tencent.mm.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.u;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.splash.SplashActivity;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;

public class WeChatSplashActivity extends SplashActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(137987);
        super.onCreate(bundle);
        MMActivity.initLanguage(getBaseContext());
        setContentView(R.layout.b7l);
        AppMethodBeat.o(137987);
    }

    public Resources getResources() {
        AppMethodBeat.i(137988);
        Resources resources;
        if (getAssets() == null || ah.getResources() == null) {
            resources = super.getResources();
            AppMethodBeat.o(137988);
            return resources;
        }
        resources = ah.getResources();
        AppMethodBeat.o(137988);
        return resources;
    }

    public Object getSystemService(String str) {
        AppMethodBeat.i(137989);
        Object systemService = super.getSystemService(str);
        if ("layout_inflater".equals(str)) {
            LayoutInflater a = v.a((LayoutInflater) systemService);
            AppMethodBeat.o(137989);
            return a;
        }
        AppMethodBeat.o(137989);
        return systemService;
    }

    public void onPause() {
        AppMethodBeat.i(137990);
        u.dgS();
        super.onPause();
        AppMethodBeat.o(137990);
    }
}
