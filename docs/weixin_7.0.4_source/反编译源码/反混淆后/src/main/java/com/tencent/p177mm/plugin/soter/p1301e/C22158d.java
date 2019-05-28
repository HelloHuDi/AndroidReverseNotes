package com.tencent.p177mm.plugin.soter.p1301e;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.soter.p528d.C13720d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C30972i;
import com.tencent.soter.p663a.C30954a;

/* renamed from: com.tencent.mm.plugin.soter.e.d */
public final class C22158d implements C5681a<Boolean, Boolean> {
    private C5688b glt = null;

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.m2504i(59360);
        Boolean bool = (Boolean) obj;
        this.glt = C5698f.dMj();
        C4990ab.m7419v("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo isNeedSaveDeviceInfo: %b", bool);
        if (!C30954a.dRc()) {
            C4990ab.m7420w("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo not support soter");
            this.glt.mo11582cR(C5698f.m8552E(Integer.valueOf(2), "not support soter"));
        } else if (bool.booleanValue()) {
            SharedPreferences doB = C4996ah.doB();
            if (doB != null) {
                String string = doB.getString("cpu_id", null);
                String string2 = doB.getString("uid", null);
                C4990ab.m7417i("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo old cpuId: %s, old uid: %s", string, string2);
                C30972i dQS = C40997a.dQS();
                if (dQS != null) {
                    string = dQS.rOh;
                    string2 = String.valueOf(dQS.uid);
                    if (!(C5046bo.isNullOrNil(string) || C5046bo.isNullOrNil(string2))) {
                        C13720d.m21910gu(string, string2);
                    }
                }
            }
        }
        Boolean bool2 = Boolean.TRUE;
        AppMethodBeat.m2505o(59360);
        return bool2;
    }
}
