package com.tencent.mm.ui.base.sortview;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c extends BaseAdapter {
    private Map<String, Integer> yDC;
    private a yDD;
    List<d> yDx = null;

    public interface a {
        View a(d dVar, View view, int i, boolean z, boolean z2);
    }

    static /* synthetic */ void a(c cVar, List list) {
        AppMethodBeat.i(107320);
        cVar.eN(list);
        AppMethodBeat.o(107320);
    }

    public c(a aVar) {
        AppMethodBeat.i(107310);
        if (aVar == null) {
            RuntimeException runtimeException = new RuntimeException("ViewCreator can not be null.");
            AppMethodBeat.o(107310);
            throw runtimeException;
        }
        this.yDD = aVar;
        this.yDx = new ArrayList();
        this.yDC = new HashMap();
        AppMethodBeat.o(107310);
    }

    public final void refresh() {
        AppMethodBeat.i(107311);
        dJ(this.yDx);
        AppMethodBeat.o(107311);
    }

    public final void dJ(final List<d> list) {
        AppMethodBeat.i(107312);
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(107309);
                    c.a(c.this, list);
                    AppMethodBeat.o(107309);
                }
            });
            AppMethodBeat.o(107312);
            return;
        }
        eN(list);
        AppMethodBeat.o(107312);
    }

    private void eN(List<d> list) {
        AppMethodBeat.i(107313);
        if (this.yDx != list) {
            this.yDx.clear();
            if (list != null) {
                this.yDx.addAll(list);
            }
        }
        dAI();
        notifyDataSetChanged();
        AppMethodBeat.o(107313);
    }

    private void dAI() {
        AppMethodBeat.i(107314);
        this.yDC.clear();
        String str = null;
        int i = 0;
        while (i < this.yDx.size()) {
            String a = a((d) this.yDx.get(i));
            if (a == null || a.equalsIgnoreCase(str)) {
                a = str;
            } else {
                this.yDC.put(a, Integer.valueOf(i));
            }
            i++;
            str = a;
        }
        AppMethodBeat.o(107314);
    }

    private static String a(d dVar) {
        if (dVar == null || dVar.yDG == null) {
            return null;
        }
        return dVar.yDG;
    }

    public final int getCount() {
        AppMethodBeat.i(107315);
        int size = this.yDx.size();
        AppMethodBeat.o(107315);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(107316);
        Object obj = this.yDx.get(i);
        AppMethodBeat.o(107316);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        AppMethodBeat.i(107317);
        d dVar = (d) getItem(i);
        String NX = NX(i);
        String NX2 = NX(i + 1);
        boolean z2 = i == aqT(NX);
        if (NX == null || NX.equalsIgnoreCase(NX2)) {
            z = false;
        }
        a aVar = this.yDD;
        getCount();
        View a = aVar.a(dVar, view, i, z2, z);
        AppMethodBeat.o(107317);
        return a;
    }

    private String NX(int i) {
        AppMethodBeat.i(107318);
        if (i < 0 || i >= this.yDx.size()) {
            AppMethodBeat.o(107318);
            return null;
        }
        String str = ((d) this.yDx.get(i)).yDG;
        AppMethodBeat.o(107318);
        return str;
    }

    public final int aqT(String str) {
        AppMethodBeat.i(107319);
        int a = bo.a((Integer) this.yDC.get(str), -1);
        AppMethodBeat.o(107319);
        return a;
    }
}
