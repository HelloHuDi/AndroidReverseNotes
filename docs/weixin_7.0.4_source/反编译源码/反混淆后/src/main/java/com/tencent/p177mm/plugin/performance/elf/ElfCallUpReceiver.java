package com.tencent.p177mm.plugin.performance.elf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.performance.elf.ElfCallUpReceiver */
public class ElfCallUpReceiver extends BroadcastReceiver {
    public static int pfn = -1;

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(111046);
        C4990ab.m7416i("MicroMsg.ElfCallUpReceiver", "[onReceive] call up! ");
        if (getClass().getName().equals(intent.getAction())) {
            pfn = intent.getIntExtra("processId", 0);
        }
        AppMethodBeat.m2505o(111046);
    }
}
