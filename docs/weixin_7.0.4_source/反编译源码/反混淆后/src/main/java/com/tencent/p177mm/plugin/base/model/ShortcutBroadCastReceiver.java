package com.tencent.p177mm.plugin.base.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.base.model.ShortcutBroadCastReceiver */
public class ShortcutBroadCastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(79060);
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.ShortcutBroadCastReceiver", "alvinluo shortcut receiver intent is null");
            AppMethodBeat.m2505o(79060);
            return;
        }
        C30379h.m48465bQ(context, context.getString(C25738R.string.f8817fv));
        AppMethodBeat.m2505o(79060);
    }
}
