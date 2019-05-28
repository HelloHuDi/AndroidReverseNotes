package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.n */
final class C33568n extends C27340s<Object> {
    C33568n(ArrayList<?> arrayList, ArrayList<?> arrayList2) {
        super(arrayList, arrayList2);
    }

    /* renamed from: J */
    public final boolean mo1474J(int i, int i2) {
        AppMethodBeat.m2504i(133497);
        if (!this.iPo.get(i).getClass().equals(this.iPp.get(i2).getClass())) {
            AppMethodBeat.m2505o(133497);
            return false;
        } else if (this.iPo.get(i) instanceof AppBrandRecentTaskInfo) {
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iPo.get(i);
            AppBrandRecentTaskInfo appBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo) this.iPp.get(i2);
            if (appBrandRecentTaskInfo.gVs == appBrandRecentTaskInfo2.gVs && appBrandRecentTaskInfo.csl.equals(appBrandRecentTaskInfo2.csl)) {
                AppMethodBeat.m2505o(133497);
                return true;
            }
            AppMethodBeat.m2505o(133497);
            return false;
        } else {
            AppMethodBeat.m2505o(133497);
            return false;
        }
    }

    /* renamed from: K */
    public final boolean mo1475K(int i, int i2) {
        AppMethodBeat.m2504i(133498);
        if (this.iPo.get(i) instanceof AppBrandRecentTaskInfo) {
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iPo.get(i);
            AppBrandRecentTaskInfo appBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo) this.iPp.get(i2);
            if (appBrandRecentTaskInfo.had == appBrandRecentTaskInfo2.had && C5046bo.nullAsNil(appBrandRecentTaskInfo.hac).equals(appBrandRecentTaskInfo2.hac) && C5046bo.nullAsNil(appBrandRecentTaskInfo.appName).equals(appBrandRecentTaskInfo2.appName)) {
                AppMethodBeat.m2505o(133498);
                return true;
            }
            AppMethodBeat.m2505o(133498);
            return false;
        }
        AppMethodBeat.m2505o(133498);
        return true;
    }

    /* renamed from: L */
    public final Object mo1476L(int i, int i2) {
        AppMethodBeat.m2504i(133499);
        if (i >= this.iPo.size()) {
            AppMethodBeat.m2505o(133499);
            return null;
        }
        Bundle bundle = new Bundle();
        if (this.iPo.get(i) instanceof AppBrandRecentTaskInfo) {
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iPo.get(i);
            AppBrandRecentTaskInfo appBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo) this.iPp.get(i2);
            if (appBrandRecentTaskInfo.had != appBrandRecentTaskInfo2.had) {
                bundle.putBoolean("star", appBrandRecentTaskInfo2.had);
            }
            if (!C5046bo.nullAsNil(appBrandRecentTaskInfo.hac).equals(appBrandRecentTaskInfo2.hac)) {
                bundle.putString("icon", appBrandRecentTaskInfo2.hac);
            }
            if (!C5046bo.nullAsNil(appBrandRecentTaskInfo.appName).equals(appBrandRecentTaskInfo2.appName)) {
                bundle.putString("nick_name", appBrandRecentTaskInfo2.appName);
            }
        }
        if (bundle.size() <= 0) {
            AppMethodBeat.m2505o(133499);
            return null;
        }
        AppMethodBeat.m2505o(133499);
        return bundle;
    }
}
