package com.tencent.p177mm.plugin.exdevice.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.exdevice.model.j */
public final class C38956j {
    private static C38956j ltw;
    private SparseArray<List<C34038a>> ltx = new SparseArray();

    /* renamed from: com.tencent.mm.plugin.exdevice.model.j$a */
    public interface C34038a {
        /* renamed from: g */
        void mo7189g(int i, Object... objArr);
    }

    private C38956j() {
        AppMethodBeat.m2504i(19306);
        AppMethodBeat.m2505o(19306);
    }

    public static C38956j boN() {
        AppMethodBeat.m2504i(19307);
        if (ltw == null) {
            ltw = new C38956j();
        }
        C38956j c38956j = ltw;
        AppMethodBeat.m2505o(19307);
        return c38956j;
    }

    /* renamed from: a */
    public final boolean mo61836a(int i, C34038a c34038a) {
        AppMethodBeat.m2504i(19308);
        if (c34038a == null) {
            AppMethodBeat.m2505o(19308);
            return false;
        }
        List list = (List) this.ltx.get(i);
        if (list == null) {
            list = new LinkedList();
            this.ltx.put(i, list);
        } else if (list.contains(c34038a)) {
            AppMethodBeat.m2505o(19308);
            return false;
        }
        boolean add = list.add(c34038a);
        AppMethodBeat.m2505o(19308);
        return add;
    }

    /* renamed from: b */
    public final boolean mo61837b(int i, C34038a c34038a) {
        AppMethodBeat.m2504i(19309);
        List list = (List) this.ltx.get(i);
        if (list != null) {
            list.remove(c34038a);
            if (list.size() == 0) {
                this.ltx.remove(i);
            }
        }
        AppMethodBeat.m2505o(19309);
        return false;
    }

    /* renamed from: h */
    public final void mo61838h(int i, Object... objArr) {
        AppMethodBeat.m2504i(19310);
        List list = (List) this.ltx.get(i);
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(19310);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                ((C34038a) list.get(i3)).mo7189g(i, objArr);
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(19310);
                return;
            }
        }
    }
}
