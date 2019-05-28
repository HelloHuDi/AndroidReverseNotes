package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class a implements c {
    private Map<Object, Set<View>> hmb = new HashMap();

    public a() {
        AppMethodBeat.i(10726);
        AppMethodBeat.o(10726);
    }

    public final boolean d(Object obj, View view) {
        AppMethodBeat.i(10727);
        if (obj == null || view == null) {
            AppMethodBeat.o(10727);
            return false;
        }
        Set set = (Set) this.hmb.get(obj);
        if (set == null) {
            set = new HashSet();
            this.hmb.put(obj, set);
        }
        boolean add = set.add(view);
        AppMethodBeat.o(10727);
        return add;
    }

    public final boolean e(Object obj, View view) {
        AppMethodBeat.i(10728);
        if (obj == null || view == null) {
            AppMethodBeat.o(10728);
            return false;
        }
        Set set = (Set) this.hmb.get(obj);
        if (set != null) {
            boolean remove = set.remove(view);
            AppMethodBeat.o(10728);
            return remove;
        }
        AppMethodBeat.o(10728);
        return false;
    }

    public final Set<View> bd(Object obj) {
        AppMethodBeat.i(10729);
        if (obj == null) {
            AppMethodBeat.o(10729);
            return null;
        }
        Set<View> set = (Set) this.hmb.get(obj);
        AppMethodBeat.o(10729);
        return set;
    }

    public final Set<View> be(Object obj) {
        AppMethodBeat.i(10730);
        if (obj == null) {
            AppMethodBeat.o(10730);
            return null;
        }
        Set<View> set = (Set) this.hmb.remove(obj);
        AppMethodBeat.o(10730);
        return set;
    }

    public final Map<Object, Set<View>> abx() {
        return this.hmb;
    }
}
