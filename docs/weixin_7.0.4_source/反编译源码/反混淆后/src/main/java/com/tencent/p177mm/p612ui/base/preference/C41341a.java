package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.preference.a */
public final class C41341a extends C40675h {
    private SparseArray<View> yBo = new SparseArray();

    public C41341a(Context context, ListView listView, SharedPreferences sharedPreferences) {
        super(context, listView, sharedPreferences);
        AppMethodBeat.m2504i(107131);
        AppMethodBeat.m2505o(107131);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107132);
        View view2 = super.getView(i, view, viewGroup);
        this.yBo.put(i, view2);
        AppMethodBeat.m2505o(107132);
        return view2;
    }

    /* renamed from: a */
    public final View mo65995a(int i, ListView listView) {
        AppMethodBeat.m2504i(107133);
        if (i > listView.getLastVisiblePosition() || i < listView.getFirstVisiblePosition()) {
            AppMethodBeat.m2505o(107133);
            return null;
        }
        View view = (View) this.yBo.get(i);
        AppMethodBeat.m2505o(107133);
        return view;
    }
}
