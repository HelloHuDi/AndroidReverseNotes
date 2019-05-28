package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.base.HorizontalListView;

/* renamed from: com.tencent.mm.plugin.account.ui.p */
public final class C18969p {
    /* renamed from: a */
    public static C46633o m29542a(Context context, View view, String[] strArr, OnItemClickListener onItemClickListener) {
        AppMethodBeat.m2504i(125300);
        View inflate = View.inflate(context, 2130970370, null);
        HorizontalListView horizontalListView = (HorizontalListView) inflate.findViewById(2131826562);
        ListAdapter c2034a = new C2034a(context, strArr);
        horizontalListView.setAdapter(c2034a);
        horizontalListView.setOnItemClickListener(onItemClickListener);
        horizontalListView.setBackgroundResource(C25738R.drawable.aol);
        C46633o c46633o = new C46633o(inflate);
        c46633o.setHeight(C1338a.fromDPToPix(context, 120));
        int i = 0;
        for (int i2 = 0; i2 < c2034a.getCount(); i2++) {
            View view2 = c2034a.getView(i2, null, horizontalListView);
            view2.measure(0, 0);
            i += view2.getMeasuredWidth();
        }
        c46633o.setWidth(C1338a.fromDPToPix(context, 20) + i);
        c46633o.showAsDropDown(view, (view.getWidth() - (C1338a.fromDPToPix(context, 20) + i)) / 2, 0);
        AppMethodBeat.m2505o(125300);
        return c46633o;
    }
}
