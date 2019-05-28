package com.tencent.p177mm.plugin.sns.p520ui.p1413e;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.story.api.C13736l;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.sns.ui.e.a */
public final class C29210a {
    private static SparseArray<HashMap> rMe = new SparseArray();
    private static C13736l rMf = new C292111();

    /* renamed from: com.tencent.mm.plugin.sns.ui.e.a$1 */
    static class C292111 implements C13736l {
        C292111() {
        }

        /* renamed from: br */
        public final void mo25937br(final String str, final boolean z) {
            AppMethodBeat.m2504i(40415);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(40414);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < C29210a.rMe.size()) {
                            Set<WeakReference> set = (Set) ((HashMap) C29210a.rMe.valueAt(i2)).get(str);
                            if (set == null || set.size() == 0) {
                                AppMethodBeat.m2505o(40414);
                            } else {
                                for (WeakReference weakReference : set) {
                                    C13736l c13736l = (C13736l) weakReference.get();
                                    if (c13736l != null) {
                                        c13736l.mo25937br(str, z);
                                    }
                                }
                                i = i2 + 1;
                            }
                        } else {
                            AppMethodBeat.m2505o(40414);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(40414);
                }
            });
            AppMethodBeat.m2505o(40415);
        }
    }

    static {
        AppMethodBeat.m2504i(40419);
        ((C35168e) C1720g.m3530M(C35168e.class)).addStoryStatusNotifyListener(rMf);
        AppMethodBeat.m2505o(40419);
    }

    /* renamed from: a */
    public static void m46385a(int i, String str, C13736l c13736l) {
        AppMethodBeat.m2504i(40416);
        if (TextUtils.isEmpty(str) || c13736l == null) {
            AppMethodBeat.m2505o(40416);
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
        set.add(new WeakReference(c13736l));
        hashMap.put(str, set);
        rMe.put(i, hashMap);
        AppMethodBeat.m2505o(40416);
    }

    /* renamed from: b */
    public static void m46386b(int i, String str, C13736l c13736l) {
        AppMethodBeat.m2504i(40417);
        if (TextUtils.isEmpty(str) || c13736l == null) {
            AppMethodBeat.m2505o(40417);
            return;
        }
        HashMap hashMap = (HashMap) rMe.get(i);
        if (hashMap == null) {
            AppMethodBeat.m2505o(40417);
            return;
        }
        Set set = (Set) hashMap.get(str);
        if (set == null) {
            AppMethodBeat.m2505o(40417);
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            C13736l c13736l2 = (C13736l) ((WeakReference) it.next()).get();
            if (c13736l2 == null || c13736l2.equals(c13736l)) {
                it.remove();
            }
        }
        AppMethodBeat.m2505o(40417);
    }

    public static void cvo() {
        AppMethodBeat.m2504i(40418);
        rMe.remove(4);
        AppMethodBeat.m2505o(40418);
    }
}
