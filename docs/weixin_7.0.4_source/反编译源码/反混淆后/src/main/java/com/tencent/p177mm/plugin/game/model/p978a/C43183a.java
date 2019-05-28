package com.tencent.p177mm.plugin.game.model.p978a;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.ttpic.model.WMElement;

/* renamed from: com.tencent.mm.plugin.game.model.a.a */
public final class C43183a {

    /* renamed from: com.tencent.mm.plugin.game.model.a.a$a */
    public static class C20983a {
        boolean iSd = false;
        float mYY = 0.0f;
    }

    public static C20983a bEX() {
        AppMethodBeat.m2504i(111496);
        Intent registerReceiver = C4996ah.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        C20983a c20983a = new C20983a();
        if (registerReceiver != null) {
            try {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                boolean z = intExtra == 2 || intExtra == 5;
                c20983a.iSd = z;
                c20983a.mYY = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra(WMElement.ANIMATE_TYPE_SCALE, -1));
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.BatteryHelper", "err:%s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(111496);
        return c20983a;
    }
}
