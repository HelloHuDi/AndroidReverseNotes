package com.tencent.p177mm.plugin.p369d.p370a.p375d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.d.a.d.a */
public final class C38837a {
    final C33895a jIS;
    public final BroadcastReceiver jIT = new C28751();

    /* renamed from: com.tencent.mm.plugin.d.a.d.a$1 */
    class C28751 extends BroadcastReceiver {
        C28751() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(18496);
            if (intent == null) {
                C4990ab.m7412e("McroMsg.exdevice.BluetoohtStateMonitor", "null == intent");
                AppMethodBeat.m2505o(18496);
                return;
            }
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                C4990ab.m7416i("McroMsg.exdevice.BluetoohtStateMonitor", "onReceive, action = " + intent.getAction());
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (10 == intExtra || 12 == intExtra) {
                    C38837a.this.jIS.mo54454rS(intExtra);
                }
            }
            AppMethodBeat.m2505o(18496);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.d.a$a */
    public interface C33895a {
        /* renamed from: rS */
        void mo54454rS(int i);
    }

    public C38837a(C33895a c33895a) {
        AppMethodBeat.m2504i(18497);
        C4990ab.m7416i("McroMsg.exdevice.BluetoohtStateMonitor", "register BluetoothState receiver");
        this.jIS = c33895a;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        C4996ah.getContext().registerReceiver(this.jIT, intentFilter);
        AppMethodBeat.m2505o(18497);
    }
}
