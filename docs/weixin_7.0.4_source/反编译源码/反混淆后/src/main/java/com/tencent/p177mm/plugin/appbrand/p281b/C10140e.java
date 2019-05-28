package com.tencent.p177mm.plugin.appbrand.p281b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.appbrand.b.e */
public abstract class C10140e {
    private final WeakReference<Activity> gWO;
    public final BroadcastReceiver receiver = new C101411();

    /* renamed from: com.tencent.mm.plugin.appbrand.b.e$1 */
    class C101411 extends BroadcastReceiver {
        final String gWP = "reason";
        final String gWQ = "homekey";
        final String gWR = "recentapps";

        C101411() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(114317);
            if (intent == null) {
                AppMethodBeat.m2505o(114317);
                return;
            }
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("reason");
                if (stringExtra != null) {
                    C4990ab.m7417i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", intent.getAction(), stringExtra);
                    if (stringExtra.equals("homekey")) {
                        C10140e.this.awC();
                        AppMethodBeat.m2505o(114317);
                        return;
                    } else if (stringExtra.equals("recentapps")) {
                        C10140e.this.awD();
                    }
                }
            }
            AppMethodBeat.m2505o(114317);
        }
    }

    public abstract void awC();

    public abstract void awD();

    public C10140e(Activity activity) {
        this.gWO = new WeakReference(activity);
    }
}
