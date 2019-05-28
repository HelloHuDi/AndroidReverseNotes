package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout */
public class FavourLayout extends LinearLayout {
    public FavourLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FavourLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setWording(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(47879);
        removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setTextColor(Color.parseColor("#ff891e"));
            textView.setTextSize(0, (float) C1338a.m2856al(getContext(), C25738R.dimen.f10012nd));
            addView(textView);
        }
        AppMethodBeat.m2505o(47879);
    }
}
