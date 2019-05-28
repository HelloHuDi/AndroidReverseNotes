package com.tencent.mm.plugin.sns.ui.e;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a {
    private static SparseArray<HashMap> rMe = new SparseArray();
    private static l rMf = new l() {
        public final void br(final String str, final boolean z) {
            AppMethodBeat.i(40415);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(40414);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < a.rMe.size()) {
                            Set<WeakReference> set = (Set) ((HashMap) a.rMe.valueAt(i2)).get(str);
                            if (set == null || set.size() == 0) {
                                AppMethodBeat.o(40414);
                            } else {
                                for (WeakReference weakReference : set) {
                                    l lVar = (l) weakReference.get();
                                    if (lVar != null) {
                                        lVar.br(str, z);
                                    }
                                }
                                i = i2 + 1;
                            }
                        } else {
                            AppMethodBeat.o(40414);
                            return;
                        }
                    }
                    AppMethodBeat.o(40414);
                }
            });
            AppMethodBeat.o(40415);
        }
    };

    static {
        AppMethodBeat.i(40419);
        ((e) g.M(e.class)).addStoryStatusNotifyListener(rMf);
        AppMethodBeat.o(40419);
    }

    public static void a(int i, String str, l lVar) {
        AppMethodBeat.i(40416);
        if (TextUtils.isEmpty(str) || lVar == null) {
            AppMethodBeat.o(40416);
            return;
        }
        HashMap hashMap;
        HashMap hashMap2 = (HashMap) rMe.get(i);
        if (hashMap2 == null) {
            hashMap = new HashMap();
        } else {
            hashMap = hashMap2;
        }
        Set set = (Set) hashMap.get(str);
        if (set == null) {
            set = new HashSet();
        }
        set.add(new WeakReference(lVar));
        hashMap.put(str, set);
        rMe.put(i, hashMap);
        AppMethodBeat.o(40416);
    }

    public static void b(int i, String str, l lVar) {
        AppMethodBeat.i(40417);
        if (TextUtils.isEmpty(str) || lVar == null) {
            AppMethodBeat.o(40417);
            return;
        }
        HashMap hashMap = (HashMap) rMe.get(i);
        if (hashMap == null) {
            AppMethodBeat.o(40417);
            return;
        }
        Set set = (Set) hashMap.get(str);
        if (set == null) {
            AppMethodBeat.o(40417);
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            l lVar2 = (l) ((WeakReference) it.next()).get();
            if (lVar2 == null || lVar2.equals(lVar)) {
                it.remove();
            }
        }
        AppMethodBeat.o(40417);
    }

    public static void cvo() {
        AppMethodBeat.i(40418);
        rMe.remove(4);
        AppMethodBeat.o(40418);
    }
}
