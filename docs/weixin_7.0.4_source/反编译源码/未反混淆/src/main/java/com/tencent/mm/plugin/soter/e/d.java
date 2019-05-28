package com.tencent.mm.plugin.soter.e;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;
import com.tencent.soter.core.c.i;

public final class d implements a<Boolean, Boolean> {
    private b glt = null;

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.i(59360);
        Boolean bool = (Boolean) obj;
        this.glt = f.dMj();
        ab.v("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo isNeedSaveDeviceInfo: %b", bool);
        if (!com.tencent.soter.a.a.dRc()) {
            ab.w("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo not support soter");
            this.glt.cR(f.E(Integer.valueOf(2), "not support soter"));
        } else if (bool.booleanValue()) {
            SharedPreferences doB = ah.doB();
            if (doB != null) {
                String string = doB.getString("cpu_id", null);
                String string2 = doB.getString("uid", null);
                ab.i("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo old cpuId: %s, old uid: %s", string, string2);
                i dQS = com.tencent.soter.core.a.dQS();
                if (dQS != null) {
                    string = dQS.rOh;
                    string2 = String.valueOf(dQS.uid);
                    if (!(bo.isNullOrNil(string) || bo.isNullOrNil(string2))) {
                        com.tencent.mm.plugin.soter.d.d.gu(string, string2);
                    }
                }
            }
        }
        Boolean bool2 = Boolean.TRUE;
        AppMethodBeat.o(59360);
        return bool2;
    }
}
