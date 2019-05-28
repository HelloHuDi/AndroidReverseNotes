package com.tencent.mm.app;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.splash.SplashFallbackActivity;

public class WeChatSplashFallbackActivity extends SplashFallbackActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(137977);
        super.onCreate(bundle);
        setContentView(R.layout.b7l);
        AppMethodBeat.o(137977);
    }
}
