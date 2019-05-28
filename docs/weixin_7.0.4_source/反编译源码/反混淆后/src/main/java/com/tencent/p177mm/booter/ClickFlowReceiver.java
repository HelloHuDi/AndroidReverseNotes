package com.tencent.p177mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelstat.C37957c;

/* renamed from: com.tencent.mm.booter.ClickFlowReceiver */
public class ClickFlowReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(15838);
        C37957c.akc().mo60731v(intent);
        AppMethodBeat.m2505o(15838);
    }
}
