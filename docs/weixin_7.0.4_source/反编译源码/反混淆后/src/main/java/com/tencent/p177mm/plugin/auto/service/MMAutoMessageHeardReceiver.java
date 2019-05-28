package com.tencent.p177mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5068w;

/* renamed from: com.tencent.mm.plugin.auto.service.MMAutoMessageHeardReceiver */
public class MMAutoMessageHeardReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(17109);
        String n = C5068w.m7689n(intent, "key_username");
        if (n == null) {
            AppMethodBeat.m2505o(17109);
            return;
        }
        C4990ab.m7417i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", n);
        C9638aw.m17190ZK();
        C18628c.m29083XR().apb(n);
        AppMethodBeat.m2505o(17109);
    }
}
