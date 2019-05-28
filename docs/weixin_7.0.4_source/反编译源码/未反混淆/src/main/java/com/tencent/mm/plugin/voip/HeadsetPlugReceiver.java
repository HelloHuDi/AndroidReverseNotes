package com.tencent.mm.plugin.voip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class HeadsetPlugReceiver extends BroadcastReceiver {
    private a sMY = null;

    public interface a {
        void fS(boolean z);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(4302);
        ab.d("MicroMsg.HeadsetPlugReceiver", "headset onReceive %s  %d", intent.getAction(), Integer.valueOf(intent.getIntExtra("state", 0)));
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            if (intent.getIntExtra("state", 0) == 0) {
                if (this.sMY != null) {
                    this.sMY.fS(false);
                    AppMethodBeat.o(4302);
                    return;
                }
            } else if (intent.getIntExtra("state", 0) == 1 && this.sMY != null) {
                this.sMY.fS(true);
            }
        }
        AppMethodBeat.o(4302);
    }

    public final void a(Context context, a aVar) {
        AppMethodBeat.i(4303);
        this.sMY = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(this, intentFilter);
        AppMethodBeat.o(4303);
    }

    public final void fa(Context context) {
        AppMethodBeat.i(4304);
        try {
            context.unregisterReceiver(this);
        } catch (Exception e) {
            ab.e("MicroMsg.HeadsetPlugReceiver", "unregisterReceiver(HeadsetPlugReceiver.this) error:%s", e.getMessage());
        }
        this.sMY = null;
        AppMethodBeat.o(4304);
    }
}
