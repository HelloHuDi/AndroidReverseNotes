package com.tencent.mm.plugin.game.model.a;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.ttpic.model.WMElement;

public final class a {

    public static class a {
        boolean iSd = false;
        float mYY = 0.0f;
    }

    public static a bEX() {
        AppMethodBeat.i(111496);
        Intent registerReceiver = ah.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        a aVar = new a();
        if (registerReceiver != null) {
            try {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                boolean z = intExtra == 2 || intExtra == 5;
                aVar.iSd = z;
                aVar.mYY = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra(WMElement.ANIMATE_TYPE_SCALE, -1));
            } catch (Exception e) {
                ab.e("MicroMsg.BatteryHelper", "err:%s", e.getMessage());
            }
        }
        AppMethodBeat.o(111496);
        return aVar;
    }
}
