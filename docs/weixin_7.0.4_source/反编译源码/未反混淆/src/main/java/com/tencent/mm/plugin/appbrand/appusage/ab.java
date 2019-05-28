package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.s;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class ab extends s<LocalUsageInfo> {
    public ab(List<LocalUsageInfo> list, List<LocalUsageInfo> list2) {
        super(aD(list), aD(list2));
        AppMethodBeat.i(129710);
        AppMethodBeat.o(129710);
    }

    private static <T> ArrayList<T> aD(List<T> list) {
        AppMethodBeat.i(129711);
        if (list instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) list;
            AppMethodBeat.o(129711);
            return arrayList;
        } else if (bo.ek(list)) {
            ArrayList<T> arrayList2 = new ArrayList(0);
            AppMethodBeat.o(129711);
            return arrayList2;
        } else {
            ArrayList<T> arrayList3 = new ArrayList(list.size());
            arrayList3.addAll(list);
            AppMethodBeat.o(129711);
            return arrayList3;
        }
    }

    public final boolean J(int i, int i2) {
        AppMethodBeat.i(129712);
        LocalUsageInfo localUsageInfo = (LocalUsageInfo) this.iPo.get(i);
        LocalUsageInfo localUsageInfo2 = (LocalUsageInfo) this.iPp.get(i2);
        if (bo.nullAsNil(localUsageInfo.username).equals(localUsageInfo2.username) && localUsageInfo.har == localUsageInfo2.har) {
            AppMethodBeat.o(129712);
            return true;
        }
        AppMethodBeat.o(129712);
        return false;
    }

    public final boolean K(int i, int i2) {
        AppMethodBeat.i(129713);
        boolean equals = bo.nullAsNil(((LocalUsageInfo) this.iPo.get(i)).haO).equals(((LocalUsageInfo) this.iPp.get(i2)).haO);
        AppMethodBeat.o(129713);
        return equals;
    }

    public final Object L(int i, int i2) {
        AppMethodBeat.i(129714);
        if (i >= this.iPo.size()) {
            AppMethodBeat.o(129714);
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            LocalUsageInfo localUsageInfo = (LocalUsageInfo) this.iPo.get(i);
            LocalUsageInfo localUsageInfo2 = (LocalUsageInfo) this.iPp.get(i2);
            if (!bo.nullAsNil(localUsageInfo.haO).equals(localUsageInfo2.haO)) {
                bundle.putString("icon", localUsageInfo2.haO);
            }
            if (!bo.nullAsNil(localUsageInfo.nickname).equals(localUsageInfo2.nickname)) {
                bundle.putString("nick_name", localUsageInfo2.nickname);
            }
        } catch (Exception e) {
            bundle.clear();
        }
        if (bundle.size() <= 0) {
            AppMethodBeat.o(129714);
            return null;
        }
        AppMethodBeat.o(129714);
        return bundle;
    }
}
