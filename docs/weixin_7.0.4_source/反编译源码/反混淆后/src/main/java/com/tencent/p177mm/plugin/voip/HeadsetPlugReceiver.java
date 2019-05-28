package com.tencent.p177mm.plugin.voip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voip.HeadsetPlugReceiver */
public class HeadsetPlugReceiver extends BroadcastReceiver {
    private C14032a sMY = null;

    /* renamed from: com.tencent.mm.plugin.voip.HeadsetPlugReceiver$a */
    public interface C14032a {
        /* renamed from: fS */
        void mo9263fS(boolean z);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(4302);
        C4990ab.m7411d("MicroMsg.HeadsetPlugReceiver", "headset onReceive %s  %d", intent.getAction(), Integer.valueOf(intent.getIntExtra("state", 0)));
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            if (intent.getIntExtra("state", 0) == 0) {
                if (this.sMY != null) {
                    this.sMY.mo9263fS(false);
                    AppMethodBeat.m2505o(4302);
                    return;
                }
            } else if (intent.getIntExtra("state", 0) == 1 && this.sMY != null) {
                this.sMY.mo9263fS(true);
            }
        }
        AppMethodBeat.m2505o(4302);
    }

    /* renamed from: a */
    public final void mo26276a(Context context, C14032a c14032a) {
        AppMethodBeat.m2504i(4303);
        this.sMY = c14032a;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(this, intentFilter);
        AppMethodBeat.m2505o(4303);
    }

    /* renamed from: fa */
    public final void mo26277fa(Context context) {
        AppMethodBeat.m2504i(4304);
        try {
            context.unregisterReceiver(this);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.HeadsetPlugReceiver", "unregisterReceiver(HeadsetPlugReceiver.this) error:%s", e.getMessage());
        }
        this.sMY = null;
        AppMethodBeat.m2505o(4304);
    }
}
