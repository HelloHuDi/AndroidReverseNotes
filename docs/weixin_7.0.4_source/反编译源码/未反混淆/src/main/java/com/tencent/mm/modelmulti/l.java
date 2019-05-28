package com.tencent.mm.modelmulti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l {
    Boolean fIW = null;

    public interface a {
        void cO(boolean z);
    }

    public l(Context context, final a aVar) {
        AppMethodBeat.i(78415);
        this.fIW = ca(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(new BroadcastReceiver() {
            final /* synthetic */ boolean fIY = false;

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(78414);
                ab.i("MicroMsg.ScreenState", "ScreenReceiver action [%s] ", intent == null ? "" : intent.getAction());
                if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                    l.this.fIW = Boolean.FALSE;
                } else {
                    l.this.fIW = Boolean.TRUE;
                }
                if (aVar != null) {
                    aVar.cO(l.this.fIW.booleanValue());
                }
                if (this.fIY) {
                    context.unregisterReceiver(this);
                }
                AppMethodBeat.o(78414);
            }
        }, intentFilter);
        AppMethodBeat.o(78415);
    }

    private Boolean ca(Context context) {
        AppMethodBeat.i(78416);
        try {
            ab.i("MicroMsg.ScreenState", "reflectScreenOn: byReflect:%s isScreenOn:%s", (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]), this.fIW);
            AppMethodBeat.o(78416);
            return r0;
        } catch (Exception e) {
            h.pYm.a(99, 154, 1, false);
            ab.e("MicroMsg.ScreenState", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", this.fIW, bo.l(e));
            AppMethodBeat.o(78416);
            return null;
        }
    }
}
