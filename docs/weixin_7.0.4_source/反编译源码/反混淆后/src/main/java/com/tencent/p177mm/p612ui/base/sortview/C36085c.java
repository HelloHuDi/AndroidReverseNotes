package com.tencent.p177mm.p612ui.base.sortview;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.base.sortview.c */
public final class C36085c extends BaseAdapter {
    private Map<String, Integer> yDC;
    private C15543a yDD;
    List<C36087d> yDx = null;

    /* renamed from: com.tencent.mm.ui.base.sortview.c$a */
    public interface C15543a {
        /* renamed from: a */
        View mo22902a(C36087d c36087d, View view, int i, boolean z, boolean z2);
    }

    /* renamed from: a */
    static /* synthetic */ void m59388a(C36085c c36085c, List list) {
        AppMethodBeat.m2504i(107320);
        c36085c.m59389eN(list);
        AppMethodBeat.m2505o(107320);
    }

    public C36085c(C15543a c15543a) {
        AppMethodBeat.m2504i(107310);
        if (c15543a == null) {
            RuntimeException runtimeException = new RuntimeException("ViewCreator can not be null.");
            AppMethodBeat.m2505o(107310);
            throw runtimeException;
        }
        this.yDD = c15543a;
        this.yDx = new ArrayList();
        this.yDC = new HashMap();
        AppMethodBeat.m2505o(107310);
    }

    public final void refresh() {
        AppMethodBeat.m2504i(107311);
        mo56931dJ(this.yDx);
        AppMethodBeat.m2505o(107311);
    }

    /* renamed from: dJ */
    public final void mo56931dJ(final List<C36087d> list) {
        AppMethodBeat.m2504i(107312);
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(107309);
                    C36085c.m59388a(C36085c.this, list);
                    AppMethodBeat.m2505o(107309);
                }
            });
            AppMethodBeat.m2505o(107312);
            return;
        }
        m59389eN(list);
        AppMethodBeat.m2505o(107312);
    }

    /* renamed from: eN */
    private void m59389eN(List<C36087d> list) {
        AppMethodBeat.m2504i(107313);
        if (this.yDx != list) {
            this.yDx.clear();
            if (list != null) {
                this.yDx.addAll(list);
            }
        }
        dAI();
        notifyDataSetChanged();
        AppMethodBeat.m2505o(107313);
    }

    private void dAI() {
        AppMethodBeat.m2504i(107314);
        this.yDC.clear();
        String str = null;
        int i = 0;
        while (i < this.yDx.size()) {
            String a = C36085c.m59387a((C36087d) this.yDx.get(i));
            if (a == null || a.equalsIgnoreCase(str)) {
                a = str;
            } else {
                this.yDC.put(a, Integer.valueOf(i));
            }
            i++;
            str = a;
        }
        AppMethodBeat.m2505o(107314);
    }

    /* renamed from: a */
    private static String m59387a(C36087d c36087d) {
        if (c36087d == null || c36087d.yDG == null) {
            return null;
        }
        return c36087d.yDG;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(107315);
        int size = this.yDx.size();
        AppMethodBeat.m2505o(107315);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(107316);
        Object obj = this.yDx.get(i);
        AppMethodBeat.m2505o(107316);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        AppMethodBeat.m2504i(107317);
        C36087d c36087d = (C36087d) getItem(i);
        String NX = m59386NX(i);
        String NX2 = m59386NX(i + 1);
        boolean z2 = i == aqT(NX);
        if (NX == null || NX.equalsIgnoreCase(NX2)) {
            z = false;
        }
        C15543a c15543a = this.yDD;
        getCount();
        View a = c15543a.mo22902a(c36087d, view, i, z2, z);
        AppMethodBeat.m2505o(107317);
        return a;
    }

    /* renamed from: NX */
    private String m59386NX(int i) {
        AppMethodBeat.m2504i(107318);
        if (i < 0 || i >= this.yDx.size()) {
            AppMethodBeat.m2505o(107318);
            return null;
        }
        String str = ((C36087d) this.yDx.get(i)).yDG;
        AppMethodBeat.m2505o(107318);
        return str;
    }

    public final int aqT(String str) {
        AppMethodBeat.m2504i(107319);
        int a = C5046bo.m7512a((Integer) this.yDC.get(str), -1);
        AppMethodBeat.m2505o(107319);
        return a;
    }
}
