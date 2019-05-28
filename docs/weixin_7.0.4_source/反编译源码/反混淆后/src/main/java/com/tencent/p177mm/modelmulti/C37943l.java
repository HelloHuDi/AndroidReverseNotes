package com.tencent.p177mm.modelmulti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelmulti.l */
public final class C37943l {
    Boolean fIW = null;

    /* renamed from: com.tencent.mm.modelmulti.l$a */
    public interface C26455a {
        /* renamed from: cO */
        void mo7663cO(boolean z);
    }

    public C37943l(Context context, final C26455a c26455a) {
        AppMethodBeat.m2504i(78415);
        this.fIW = m64133ca(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(new BroadcastReceiver() {
            final /* synthetic */ boolean fIY = false;

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.m2504i(78414);
                C4990ab.m7417i("MicroMsg.ScreenState", "ScreenReceiver action [%s] ", intent == null ? "" : intent.getAction());
                if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
                    C37943l.this.fIW = Boolean.FALSE;
                } else {
                    C37943l.this.fIW = Boolean.TRUE;
                }
                if (c26455a != null) {
                    c26455a.mo7663cO(C37943l.this.fIW.booleanValue());
                }
                if (this.fIY) {
                    context.unregisterReceiver(this);
                }
                AppMethodBeat.m2505o(78414);
            }
        }, intentFilter);
        AppMethodBeat.m2505o(78415);
    }

    /* renamed from: ca */
    private Boolean m64133ca(Context context) {
        AppMethodBeat.m2504i(78416);
        try {
            C4990ab.m7417i("MicroMsg.ScreenState", "reflectScreenOn: byReflect:%s isScreenOn:%s", (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]), this.fIW);
            AppMethodBeat.m2505o(78416);
            return r0;
        } catch (Exception e) {
            C7060h.pYm.mo8378a(99, 154, 1, false);
            C4990ab.m7413e("MicroMsg.ScreenState", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", this.fIW, C5046bo.m7574l(e));
            AppMethodBeat.m2505o(78416);
            return null;
        }
    }
}
