package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

final class k {
    final boolean enable;

    k(boolean z) {
        this.enable = z;
    }

    /* Access modifiers changed, original: final */
    public final ArrayList<AppBrandRecentTaskInfo> q(ArrayList<AppBrandRecentTaskInfo> arrayList) {
        AppMethodBeat.i(133482);
        if (!this.enable || bo.ek(arrayList)) {
            AppMethodBeat.o(133482);
            return arrayList;
        }
        ArrayList<AppBrandRecentTaskInfo> arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) it.next();
            if (!appBrandRecentTaskInfo.had) {
                arrayList2.add(appBrandRecentTaskInfo);
            }
        }
        AppMethodBeat.o(133482);
        return arrayList2;
    }
}
