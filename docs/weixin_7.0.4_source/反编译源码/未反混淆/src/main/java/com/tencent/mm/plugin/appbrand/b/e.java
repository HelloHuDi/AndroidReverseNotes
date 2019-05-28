package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public abstract class e {
    private final WeakReference<Activity> gWO;
    public final BroadcastReceiver receiver = new BroadcastReceiver() {
        final String gWP = "reason";
        final String gWQ = "homekey";
        final String gWR = "recentapps";

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(114317);
            if (intent == null) {
                AppMethodBeat.o(114317);
                return;
            }
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("reason");
                if (stringExtra != null) {
                    ab.i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", intent.getAction(), stringExtra);
                    if (stringExtra.equals("homekey")) {
                        e.this.awC();
                        AppMethodBeat.o(114317);
                        return;
                    } else if (stringExtra.equals("recentapps")) {
                        e.this.awD();
                    }
                }
            }
            AppMethodBeat.o(114317);
        }
    };

    public abstract void awC();

    public abstract void awD();

    public e(Activity activity) {
        this.gWO = new WeakReference(activity);
    }
}
