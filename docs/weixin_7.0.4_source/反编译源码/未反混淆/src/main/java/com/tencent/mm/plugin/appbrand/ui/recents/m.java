package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.luggage.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.Assert;

final class m extends ArrayList<AppBrandRecentTaskInfo> {
    private final ArrayList<AppBrandRecentTaskInfo> iOH = new ArrayList(50);
    private final ArrayList<AppBrandRecentTaskInfo> iOI = new ArrayList(Downloads.MIN_WAIT_FOR_NETWORK);

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(133496);
        m aNy = aNy();
        AppMethodBeat.o(133496);
        return aNy;
    }

    public final /* synthetic */ Object get(int i) {
        AppMethodBeat.i(133495);
        AppBrandRecentTaskInfo pU = pU(i);
        AppMethodBeat.o(133495);
        return pU;
    }

    public final /* synthetic */ Object remove(int i) {
        AppMethodBeat.i(133494);
        AppBrandRecentTaskInfo pV = pV(i);
        AppMethodBeat.o(133494);
        return pV;
    }

    m() {
        AppMethodBeat.i(133483);
        AppMethodBeat.o(133483);
    }

    static m d(ArrayList<AppBrandRecentTaskInfo> arrayList, ArrayList<AppBrandRecentTaskInfo> arrayList2) {
        AppMethodBeat.i(133484);
        m mVar = new m();
        c.c(mVar.iOH, arrayList);
        c.c(mVar.iOI, arrayList2);
        AppMethodBeat.o(133484);
        return mVar;
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
    public final synchronized m e(ArrayList<AppBrandRecentTaskInfo> arrayList, ArrayList<AppBrandRecentTaskInfo> arrayList2) {
        AppMethodBeat.i(133485);
        this.iOH.clear();
        if (!bo.ek(arrayList)) {
            this.iOH.addAll(arrayList);
        }
        this.iOI.clear();
        if (!bo.ek(arrayList2)) {
            this.iOI.addAll(arrayList2);
        }
        AppMethodBeat.o(133485);
        return this;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized m a(m mVar) {
        m e;
        AppMethodBeat.i(133486);
        e = e(mVar.iOH, mVar.iOI);
        AppMethodBeat.o(133486);
        return e;
    }

    public final boolean addAll(Collection<? extends AppBrandRecentTaskInfo> collection) {
        boolean z = false;
        AppMethodBeat.i(133487);
        if (m.class.isInstance(collection)) {
            synchronized (this) {
                try {
                    m mVar = (m) collection;
                    this.iOH.addAll(mVar.iOH);
                    this.iOI.addAll(mVar.iOI);
                    z = true;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(133487);
                }
            }
        } else {
            Assert.assertTrue("collection type mismatch!!", false);
            AppMethodBeat.o(133487);
        }
        return z;
    }

    public final synchronized m aNy() {
        m mVar;
        AppMethodBeat.i(133488);
        mVar = new m();
        mVar.iOH.addAll(this.iOH);
        mVar.iOI.addAll(this.iOI);
        AppMethodBeat.o(133488);
        return mVar;
    }

    public final synchronized int size() {
        int size;
        AppMethodBeat.i(133489);
        size = this.iOH.size() + this.iOI.size();
        AppMethodBeat.o(133489);
        return size;
    }

    private synchronized AppBrandRecentTaskInfo pU(int i) {
        AppBrandRecentTaskInfo appBrandRecentTaskInfo;
        AppMethodBeat.i(133490);
        if (i < this.iOH.size()) {
            appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iOH.get(i);
            AppMethodBeat.o(133490);
        } else {
            appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iOI.get(i - this.iOH.size());
            AppMethodBeat.o(133490);
        }
        return appBrandRecentTaskInfo;
    }

    public final synchronized AppBrandRecentTaskInfo pV(int i) {
        AppBrandRecentTaskInfo appBrandRecentTaskInfo;
        AppMethodBeat.i(133491);
        if (i < this.iOH.size()) {
            appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iOH.remove(i);
            AppMethodBeat.o(133491);
        } else {
            appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) this.iOI.remove(i - this.iOH.size());
            AppMethodBeat.o(133491);
        }
        return appBrandRecentTaskInfo;
    }

    public final synchronized void clear() {
        AppMethodBeat.i(133492);
        this.iOH.clear();
        this.iOI.clear();
        AppMethodBeat.o(133492);
    }

    public final Iterator<AppBrandRecentTaskInfo> iterator() {
        AppMethodBeat.i(133493);
        Assert.assertTrue("Why you need this?? call @smoothieli fix it", false);
        AnonymousClass1 anonymousClass1 = new Iterator<AppBrandRecentTaskInfo>() {
            public final /* bridge */ /* synthetic */ Object next() {
                return null;
            }

            public final boolean hasNext() {
                return false;
            }

            public final void remove() {
            }
        };
        AppMethodBeat.o(133493);
        return anonymousClass1;
    }
}
