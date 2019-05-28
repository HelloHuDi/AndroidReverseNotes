package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends h {
    private SparseArray<View> yBo = new SparseArray();

    public a(Context context, ListView listView, SharedPreferences sharedPreferences) {
        super(context, listView, sharedPreferences);
        AppMethodBeat.i(107131);
        AppMethodBeat.o(107131);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(107132);
        View view2 = super.getView(i, view, viewGroup);
        this.yBo.put(i, view2);
        AppMethodBeat.o(107132);
        return view2;
    }

    public final View a(int i, ListView listView) {
        AppMethodBeat.i(107133);
        if (i > listView.getLastVisiblePosition() || i < listView.getFirstVisiblePosition()) {
            AppMethodBeat.o(107133);
            return null;
        }
        View view = (View) this.yBo.get(i);
        AppMethodBeat.o(107133);
        return view;
    }
}
