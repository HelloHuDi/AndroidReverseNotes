package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import com.tencent.luggage.p147g.C37400c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.m */
final class C33566m extends ArrayList<AppBrandRecentTaskInfo> {
    private final ArrayList<AppBrandRecentTaskInfo> iOH = new ArrayList(50);
    private final ArrayList<AppBrandRecentTaskInfo> iOI = new ArrayList(Downloads.MIN_WAIT_FOR_NETWORK);

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.m$1 */
    class C335671 implements Iterator<AppBrandRecentTaskInfo> {
        C335671() {
        }

        public final /* bridge */ /* synthetic */ Object next() {
            return null;
        }

        public final boolean hasNext() {
            return false;
        }

        public final void remove() {
        }
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(133496);
        C33566m aNy = aNy();
        AppMethodBeat.m2505o(133496);
        return aNy;
    }

    public final /* synthetic */ Object get(int i) {
        AppMethodBeat.m2504i(133495);
        AppBrandRecentTaskInfo pU = m54811pU(i);
        AppMethodBeat.m2505o(133495);
        return pU;
    }

    public final /* synthetic */ Object remove(int i) {
        AppMethodBeat.m2504i(133494);
        AppBrandRecentTaskInfo pV = mo54063pV(i);
        AppMethodBeat.m2505o(133494);
        return pV;
    }

    C33566m() {
        AppMethodBeat.m2504i(133483);
        AppMethodBeat.m2505o(133483);
    }

    /* renamed from: d */
    static C33566m m54810d(ArrayList<AppBrandRecentTaskInfo> arrayList, ArrayList<AppBrandRecentTaskInfo> arrayList2) {
        AppMethodBeat.m2504i(133484);
        C33566m c33566m = new C33566m();
        C37400c.m63005c(c33566m.iOH, arrayList);
        C37400c.m63005c(c33566m.iOI, arrayList2);
        AppMethodBeat.m2505o(133484);
        return c33566m;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized ArrayList<AppBrandRecentTaskInfo> aNw() {
        return this.iOH;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized ArrayList<AppBrandRecentTaskInfo> aNx() {
        return this.iOI;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: e */
    public final synchronized C33566m mo54060e(ArrayList<AppBrandRecentTaskInfo> arrayList, ArrayList<AppBrandRecentTaskInfo> arrayList2) {
        AppMethodBeat.m2504i(133485);
        this.iOH.clear();
        if (!C5046bo.m7548ek(arrayList)) {
            this.iOH.addAll(arrayList);
        }
        this.iOI.clear();
        if (!C5046bo.m7548ek(arrayList2)) {
            this.iOI.addAll(arrayList2);
        }
        AppMethodBeat.m2505o(133485);
        return this;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: a */
    public final synchronized C33566m mo54053a(C33566m c33566m) {
        C33566m e;
        AppMethodBeat.m2504i(133486);
        e = mo54060e(c33566m.iOH, c33566m.iOI);
        AppMethodBeat.m2505o(133486);
        return e;
    }

    public final boolean addAll(Collection<? extends AppBrandRecentTaskInfo> collection) {
        boolean z = false;
        AppMethodBeat.m2504i(133487);
        if (C33566m.class.isInstance(collection)) {
            synchronized (this) {
                try {
                    C33566m c33566m = (C33566m) collection;
                    this.iOH.addAll(c33566m.iOH);
                    this.iOI.addAll(c33566m.iOI);
                    z = true;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(133487);
                }
            }
        } else {
            Assert.assertTrue("collection type mismatch!!", false);
            AppMethodBeat.m2505o(133487);
        }
        return z;
    }

    public final synchronized C33566m aNy() {
        C33566m c33566m;
        AppMethodBeat.m2504i(133488);
        c33566m = new C33566m();
        c33566m.iOH.addAll(this.iOH);
        c33566m.iOI.addAll(this.iOI);
        AppMethodBeat.m2505o(133488);
        return c33566m;
    }

    public final synchronized int size() {
        int size;
        AppMethodBeat.m2504i(133489);
        size = this.iOH.size() + this.iOI.size();
        AppMethodBeat.m2505o(133489);
        return size;
    }

    /* renamed from: pU */
    private synchronized AppBrandRecentTaskInfo m54811pU(int i) {
        AppBrandRecentTaskInfo appBrandRecentTaskInfo;
        AppMethodBeat.m2504i(133490);
        if (i < this.iOH.size()) {
            appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iOH.get(i);
            AppMethodBeat.m2505o(133490);
        } else {
            appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iOI.get(i - this.iOH.size());
            AppMethodBeat.m2505o(133490);
        }
        return appBrandRecentTaskInfo;
    }

    /* renamed from: pV */
    public final synchronized AppBrandRecentTaskInfo mo54063pV(int i) {
        AppBrandRecentTaskInfo appBrandRecentTaskInfo;
        AppMethodBeat.m2504i(133491);
        if (i < this.iOH.size()) {
            appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iOH.remove(i);
            AppMethodBeat.m2505o(133491);
        } else {
            appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iOI.remove(i - this.iOH.size());
            AppMethodBeat.m2505o(133491);
        }
        return appBrandRecentTaskInfo;
    }

    public final synchronized void clear() {
        AppMethodBeat.m2504i(133492);
        this.iOH.clear();
        this.iOI.clear();
        AppMethodBeat.m2505o(133492);
    }

    public final Iterator<AppBrandRecentTaskInfo> iterator() {
        AppMethodBeat.m2504i(133493);
        Assert.assertTrue("Why you need this?? call @smoothieli fix it", false);
        C335671 c335671 = new C335671();
        AppMethodBeat.m2505o(133493);
        return c335671;
    }
}
