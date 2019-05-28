package com.tencent.p177mm.app;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.splash.SplashFallbackActivity;

/* renamed from: com.tencent.mm.app.WeChatSplashFallbackActivity */
public class WeChatSplashFallbackActivity extends SplashFallbackActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(137977);
        super.onCreate(bundle);
        setContentView(2130971222);
        AppMethodBeat.m2505o(137977);
    }
}
