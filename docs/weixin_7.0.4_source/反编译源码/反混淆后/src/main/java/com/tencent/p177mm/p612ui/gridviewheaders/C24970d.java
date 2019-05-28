package com.tencent.p177mm.p612ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.gridviewheaders.d */
public final class C24970d extends BaseAdapter implements C24009b {
    /* renamed from: PL */
    private DataSetObserver f4958PL = new C249711();
    private ListAdapter zyV;

    /* renamed from: com.tencent.mm.ui.gridviewheaders.d$1 */
    class C249711 extends DataSetObserver {
        C249711() {
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(107405);
            C24970d.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(107405);
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(107406);
            C24970d.this.notifyDataSetInvalidated();
            AppMethodBeat.m2505o(107406);
        }
    }

    public C24970d(ListAdapter listAdapter) {
        AppMethodBeat.m2504i(107407);
        this.zyV = listAdapter;
        listAdapter.registerDataSetObserver(this.f4958PL);
        AppMethodBeat.m2505o(107407);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(107408);
        int count = this.zyV.getCount();
        AppMethodBeat.m2505o(107408);
        return count;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(107409);
        Object item = this.zyV.getItem(i);
        AppMethodBeat.m2505o(107409);
        return item;
    }

    public final long getItemId(int i) {
        AppMethodBeat.m2504i(107410);
        long itemId = this.zyV.getItemId(i);
        AppMethodBeat.m2505o(107410);
        return itemId;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107411);
        View view2 = this.zyV.getView(i, view, viewGroup);
        AppMethodBeat.m2505o(107411);
        return view2;
    }

    /* renamed from: PA */
    public final int mo39816PA(int i) {
        return 0;
    }

    public final int dJh() {
        return 0;
    }

    /* renamed from: a */
    public final View mo39817a(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
