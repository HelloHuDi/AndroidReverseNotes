package com.tencent.mm.plugin.exdevice.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class j {
    private static j ltw;
    private SparseArray<List<a>> ltx = new SparseArray();

    public interface a {
        void g(int i, Object... objArr);
    }

    private j() {
        AppMethodBeat.i(19306);
        AppMethodBeat.o(19306);
    }

    public static j boN() {
        AppMethodBeat.i(19307);
        if (ltw == null) {
            ltw = new j();
        }
        j jVar = ltw;
        AppMethodBeat.o(19307);
        return jVar;
    }

    public final boolean a(int i, a aVar) {
        AppMethodBeat.i(19308);
        if (aVar == null) {
            AppMethodBeat.o(19308);
            return false;
        }
        List list = (List) this.ltx.get(i);
        if (list == null) {
            list = new LinkedList();
            this.ltx.put(i, list);
        } else if (list.contains(aVar)) {
            AppMethodBeat.o(19308);
            return false;
        }
        boolean add = list.add(aVar);
        AppMethodBeat.o(19308);
        return add;
    }

    public final boolean b(int i, a aVar) {
        AppMethodBeat.i(19309);
        List list = (List) this.ltx.get(i);
        if (list != null) {
            list.remove(aVar);
            if (list.size() == 0) {
                this.ltx.remove(i);
            }
        }
        AppMethodBeat.o(19309);
        return false;
    }

    public final void h(int i, Object... objArr) {
        AppMethodBeat.i(19310);
        List list = (List) this.ltx.get(i);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(19310);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                ((a) list.get(i3)).g(i, objArr);
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(19310);
                return;
            }
        }
    }
}
