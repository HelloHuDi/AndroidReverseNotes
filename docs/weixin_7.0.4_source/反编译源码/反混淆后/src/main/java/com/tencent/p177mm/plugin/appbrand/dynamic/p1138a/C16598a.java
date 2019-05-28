package com.tencent.p177mm.plugin.appbrand.dynamic.p1138a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.C9686c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a.a */
final class C16598a implements C9686c {
    private Map<Object, Set<View>> hmb = new HashMap();

    public C16598a() {
        AppMethodBeat.m2504i(10726);
        AppMethodBeat.m2505o(10726);
    }

    /* renamed from: d */
    public final boolean mo21012d(Object obj, View view) {
        AppMethodBeat.m2504i(10727);
        if (obj == null || view == null) {
            AppMethodBeat.m2505o(10727);
            return false;
        }
        Set set = (Set) this.hmb.get(obj);
        if (set == null) {
            set = new HashSet();
            this.hmb.put(obj, set);
        }
        boolean add = set.add(view);
        AppMethodBeat.m2505o(10727);
        return add;
    }

    /* renamed from: e */
    public final boolean mo21013e(Object obj, View view) {
        AppMethodBeat.m2504i(10728);
        if (obj == null || view == null) {
            AppMethodBeat.m2505o(10728);
            return false;
        }
        Set set = (Set) this.hmb.get(obj);
        if (set != null) {
            boolean remove = set.remove(view);
            AppMethodBeat.m2505o(10728);
            return remove;
        }
        AppMethodBeat.m2505o(10728);
        return false;
    }

    /* renamed from: bd */
    public final Set<View> mo21010bd(Object obj) {
        AppMethodBeat.m2504i(10729);
        if (obj == null) {
            AppMethodBeat.m2505o(10729);
            return null;
        }
        Set<View> set = (Set) this.hmb.get(obj);
        AppMethodBeat.m2505o(10729);
        return set;
    }

    /* renamed from: be */
    public final Set<View> mo21011be(Object obj) {
        AppMethodBeat.m2504i(10730);
        if (obj == null) {
            AppMethodBeat.m2505o(10730);
            return null;
        }
        Set<View> set = (Set) this.hmb.remove(obj);
        AppMethodBeat.m2505o(10730);
        return set;
    }

    public final Map<Object, Set<View>> abx() {
        return this.hmb;
    }
}
