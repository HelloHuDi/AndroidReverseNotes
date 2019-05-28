package com.tencent.mm.bn;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public static boolean dgL() {
        AppMethodBeat.i(55524);
        Object value = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("EnableStrangerChat");
        String str = "1";
        if (bo.isNullOrNil(value)) {
            value = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        boolean equals = str.equals(value);
        AppMethodBeat.o(55524);
        return equals;
    }

    public static void fy(Context context) {
        AppMethodBeat.i(55525);
        if (!dgL()) {
            g.RN().QU();
            if (((j) g.K(j.class)).bOo().baS() > 0) {
                d.H(context, "nearby", ".ui.NearbyFriendShowSayHiUI");
                AppMethodBeat.o(55525);
                return;
            }
        }
        d.H(context, "nearby", ".ui.NearbyFriendsUI");
        AppMethodBeat.o(55525);
    }
}
