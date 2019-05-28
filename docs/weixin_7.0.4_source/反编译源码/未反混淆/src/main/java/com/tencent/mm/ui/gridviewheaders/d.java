package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends BaseAdapter implements b {
    private DataSetObserver PL = new DataSetObserver() {
        public final void onChanged() {
            AppMethodBeat.i(107405);
            d.this.notifyDataSetChanged();
            AppMethodBeat.o(107405);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(107406);
            d.this.notifyDataSetInvalidated();
            AppMethodBeat.o(107406);
        }
    };
    private ListAdapter zyV;

    public d(ListAdapter listAdapter) {
        AppMethodBeat.i(107407);
        this.zyV = listAdapter;
        listAdapter.registerDataSetObserver(this.PL);
        AppMethodBeat.o(107407);
    }

    public final int getCount() {
        AppMethodBeat.i(107408);
        int count = this.zyV.getCount();
        AppMethodBeat.o(107408);
        return count;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(107409);
        Object item = this.zyV.getItem(i);
        AppMethodBeat.o(107409);
        return item;
    }

    public final long getItemId(int i) {
        AppMethodBeat.i(107410);
        long itemId = this.zyV.getItemId(i);
        AppMethodBeat.o(107410);
        return itemId;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(107411);
        View view2 = this.zyV.getView(i, view, viewGroup);
        AppMethodBeat.o(107411);
        return view2;
    }

    public final int PA(int i) {
        return 0;
    }

    public final int dJh() {
        return 0;
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
