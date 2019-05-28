package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

final class n extends s<Object> {
    n(ArrayList<?> arrayList, ArrayList<?> arrayList2) {
        super(arrayList, arrayList2);
    }

    public final boolean J(int i, int i2) {
        AppMethodBeat.i(133497);
        if (!this.iPo.get(i).getClass().equals(this.iPp.get(i2).getClass())) {
            AppMethodBeat.o(133497);
            return false;
        } else if (this.iPo.get(i) instanceof AppBrandRecentTaskInfo) {
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iPo.get(i);
            AppBrandRecentTaskInfo appBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo) this.iPp.get(i2);
            if (appBrandRecentTaskInfo.gVs == appBrandRecentTaskInfo2.gVs && appBrandRecentTaskInfo.csl.equals(appBrandRecentTaskInfo2.csl)) {
                AppMethodBeat.o(133497);
                return true;
            }
            AppMethodBeat.o(133497);
            return false;
        } else {
            AppMethodBeat.o(133497);
            return false;
        }
    }

    public final boolean K(int i, int i2) {
        AppMethodBeat.i(133498);
        if (this.iPo.get(i) instanceof AppBrandRecentTaskInfo) {
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iPo.get(i);
            AppBrandRecentTaskInfo appBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo) this.iPp.get(i2);
            if (appBrandRecentTaskInfo.had == appBrandRecentTaskInfo2.had && bo.nullAsNil(appBrandRecentTaskInfo.hac).equals(appBrandRecentTaskInfo2.hac) && bo.nullAsNil(appBrandRecentTaskInfo.appName).equals(appBrandRecentTaskInfo2.appName)) {
                AppMethodBeat.o(133498);
                return true;
            }
            AppMethodBeat.o(133498);
            return false;
        }
        AppMethodBeat.o(133498);
        return true;
    }

    public final Object L(int i, int i2) {
        AppMethodBeat.i(133499);
        if (i >= this.iPo.size()) {
            AppMethodBeat.o(133499);
            return null;
        }
        Bundle bundle = new Bundle();
        if (this.iPo.get(i) instanceof AppBrandRecentTaskInfo) {
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iPo.get(i);
            AppBrandRecentTaskInfo appBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo) this.iPp.get(i2);
            if (appBrandRecentTaskInfo.had != appBrandRecentTaskInfo2.had) {
                bundle.putBoolean("star", appBrandRecentTaskInfo2.had);
            }
            if (!bo.nullAsNil(appBrandRecentTaskInfo.hac).equals(appBrandRecentTaskInfo2.hac)) {
                bundle.putString("icon", appBrandRecentTaskInfo2.hac);
            }
            if (!bo.nullAsNil(appBrandRecentTaskInfo.appName).equals(appBrandRecentTaskInfo2.appName)) {
                bundle.putString("nick_name", appBrandRecentTaskInfo2.appName);
            }
        }
        if (bundle.size() <= 0) {
            AppMethodBeat.o(133499);
            return null;
        }
        AppMethodBeat.o(133499);
        return bundle;
    }
}
