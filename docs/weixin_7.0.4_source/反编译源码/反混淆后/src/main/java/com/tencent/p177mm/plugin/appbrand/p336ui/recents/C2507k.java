package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.k */
final class C2507k {
    final boolean enable;

    C2507k(boolean z) {
        this.enable = z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: q */
    public final ArrayList<AppBrandRecentTaskInfo> mo6448q(ArrayList<AppBrandRecentTaskInfo> arrayList) {
        AppMethodBeat.m2504i(133482);
        if (!this.enable || C5046bo.m7548ek(arrayList)) {
            AppMethodBeat.m2505o(133482);
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
        AppMethodBeat.m2505o(133482);
        return arrayList2;
    }
}
