package com.tencent.p177mm.p840bn;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.bn.a */
public final class C9089a {
    public static boolean dgL() {
        AppMethodBeat.m2504i(55524);
        Object value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("EnableStrangerChat");
        String str = "1";
        if (C5046bo.isNullOrNil(value)) {
            value = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        boolean equals = str.equals(value);
        AppMethodBeat.m2505o(55524);
        return equals;
    }

    /* renamed from: fy */
    public static void m16479fy(Context context) {
        AppMethodBeat.m2504i(55525);
        if (!C9089a.dgL()) {
            C1720g.m3534RN().mo5159QU();
            if (((C6982j) C1720g.m3528K(C6982j.class)).bOo().baS() > 0) {
                C25985d.m41448H(context, "nearby", ".ui.NearbyFriendShowSayHiUI");
                AppMethodBeat.m2505o(55525);
                return;
            }
        }
        C25985d.m41448H(context, "nearby", ".ui.NearbyFriendsUI");
        AppMethodBeat.m2505o(55525);
    }
}
