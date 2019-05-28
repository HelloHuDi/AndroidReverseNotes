package com.tencent.p177mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p336ui.recents.C27340s;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.ab */
public final class C33107ab extends C27340s<LocalUsageInfo> {
    public C33107ab(List<LocalUsageInfo> list, List<LocalUsageInfo> list2) {
        super(C33107ab.m54122aD(list), C33107ab.m54122aD(list2));
        AppMethodBeat.m2504i(129710);
        AppMethodBeat.m2505o(129710);
    }

    /* renamed from: aD */
    private static <T> ArrayList<T> m54122aD(List<T> list) {
        AppMethodBeat.m2504i(129711);
        if (list instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) list;
            AppMethodBeat.m2505o(129711);
            return arrayList;
        } else if (C5046bo.m7548ek(list)) {
            ArrayList<T> arrayList2 = new ArrayList(0);
            AppMethodBeat.m2505o(129711);
            return arrayList2;
        } else {
            ArrayList<T> arrayList3 = new ArrayList(list.size());
            arrayList3.addAll(list);
            AppMethodBeat.m2505o(129711);
            return arrayList3;
        }
    }

    /* renamed from: J */
    public final boolean mo1474J(int i, int i2) {
        AppMethodBeat.m2504i(129712);
        LocalUsageInfo localUsageInfo = (LocalUsageInfo) this.iPo.get(i);
        LocalUsageInfo localUsageInfo2 = (LocalUsageInfo) this.iPp.get(i2);
        if (C5046bo.nullAsNil(localUsageInfo.username).equals(localUsageInfo2.username) && localUsageInfo.har == localUsageInfo2.har) {
            AppMethodBeat.m2505o(129712);
            return true;
        }
        AppMethodBeat.m2505o(129712);
        return false;
    }

    /* renamed from: K */
    public final boolean mo1475K(int i, int i2) {
        AppMethodBeat.m2504i(129713);
        boolean equals = C5046bo.nullAsNil(((LocalUsageInfo) this.iPo.get(i)).haO).equals(((LocalUsageInfo) this.iPp.get(i2)).haO);
        AppMethodBeat.m2505o(129713);
        return equals;
    }

    /* renamed from: L */
    public final Object mo1476L(int i, int i2) {
        AppMethodBeat.m2504i(129714);
        if (i >= this.iPo.size()) {
            AppMethodBeat.m2505o(129714);
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            LocalUsageInfo localUsageInfo = (LocalUsageInfo) this.iPo.get(i);
            LocalUsageInfo localUsageInfo2 = (LocalUsageInfo) this.iPp.get(i2);
            if (!C5046bo.nullAsNil(localUsageInfo.haO).equals(localUsageInfo2.haO)) {
                bundle.putString("icon", localUsageInfo2.haO);
            }
            if (!C5046bo.nullAsNil(localUsageInfo.nickname).equals(localUsageInfo2.nickname)) {
                bundle.putString("nick_name", localUsageInfo2.nickname);
            }
        } catch (Exception e) {
            bundle.clear();
        }
        if (bundle.size() <= 0) {
            AppMethodBeat.m2505o(129714);
            return null;
        }
        AppMethodBeat.m2505o(129714);
        return bundle;
    }
}
