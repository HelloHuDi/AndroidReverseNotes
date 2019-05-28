package com.tencent.mm.plugin.performance.elf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class ElfCallUpReceiver extends BroadcastReceiver {
    public static int pfn = -1;

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(111046);
        ab.i("MicroMsg.ElfCallUpReceiver", "[onReceive] call up! ");
        if (getClass().getName().equals(intent.getAction())) {
            pfn = intent.getIntExtra("processId", 0);
        }
        AppMethodBeat.o(111046);
    }
}
