package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.o;

public final class p {
    public static o a(Context context, View view, String[] strArr, OnItemClickListener onItemClickListener) {
        AppMethodBeat.i(125300);
        View inflate = View.inflate(context, R.layout.akn, null);
        HorizontalListView horizontalListView = (HorizontalListView) inflate.findViewById(R.id.dno);
        ListAdapter aVar = new a(context, strArr);
        horizontalListView.setAdapter(aVar);
        horizontalListView.setOnItemClickListener(onItemClickListener);
        horizontalListView.setBackgroundResource(R.drawable.aol);
        o oVar = new o(inflate);
        oVar.setHeight(a.fromDPToPix(context, 120));
        int i = 0;
        for (int i2 = 0; i2 < aVar.getCount(); i2++) {
            View view2 = aVar.getView(i2, null, horizontalListView);
            view2.measure(0, 0);
            i += view2.getMeasuredWidth();
        }
        oVar.setWidth(a.fromDPToPix(context, 20) + i);
        oVar.showAsDropDown(view, (view.getWidth() - (a.fromDPToPix(context, 20) + i)) / 2, 0);
        AppMethodBeat.o(125300);
        return oVar;
    }
}
