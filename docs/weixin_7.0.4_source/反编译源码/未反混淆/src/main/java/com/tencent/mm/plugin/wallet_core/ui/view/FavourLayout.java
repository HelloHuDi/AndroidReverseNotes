package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import java.util.Iterator;
import java.util.LinkedList;

public class FavourLayout extends LinearLayout {
    public FavourLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FavourLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setWording(LinkedList<String> linkedList) {
        AppMethodBeat.i(47879);
        removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setTextColor(Color.parseColor("#ff891e"));
            textView.setTextSize(0, (float) a.al(getContext(), R.dimen.nd));
            addView(textView);
        }
        AppMethodBeat.o(47879);
    }
}
