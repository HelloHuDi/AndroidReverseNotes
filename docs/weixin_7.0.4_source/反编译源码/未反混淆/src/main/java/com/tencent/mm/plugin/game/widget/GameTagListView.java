package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameTagListView extends LinearLayout {
    private int textColor;
    private int textSize;

    public GameTagListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(112411);
        super.onFinishInflate();
        this.textColor = getResources().getColor(R.color.qd);
        this.textSize = getResources().getDimensionPixelSize(R.dimen.k3);
        AppMethodBeat.o(112411);
    }

    public final void f(LinkedList<String> linkedList, int i) {
        AppMethodBeat.i(112412);
        if (bo.ek(linkedList)) {
            setVisibility(8);
            AppMethodBeat.o(112412);
            return;
        }
        setVisibility(0);
        while (getChildCount() < linkedList.size()) {
            TextView textView = new TextView(getContext());
            textView.setBackgroundResource(R.drawable.pl);
            textView.setMaxLines(1);
            textView.setTextColor(this.textColor);
            textView.setTextSize(0, (float) this.textSize);
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.k1), 0);
            textView.setLayoutParams(layoutParams);
            addView(textView);
        }
        int i2 = 0;
        float f = 0.0f;
        while (i2 < linkedList.size()) {
            String str = (String) linkedList.get(i2);
            ab.d("MicroMsg.GameTagListView", str);
            TextView textView2 = (TextView) getChildAt(i2);
            textView2.setVisibility(0);
            textView2.setText(str);
            f = ((float) getResources().getDimensionPixelSize(R.dimen.k1)) + (((textView2.getPaint().measureText(str) + ((float) textView2.getPaddingLeft())) + ((float) textView2.getPaddingRight())) + f);
            if (f > ((float) i)) {
                textView2.setVisibility(8);
                break;
            }
            i2++;
        }
        while (i2 < getChildCount()) {
            int i3 = i2 + 1;
            getChildAt(i2).setVisibility(8);
            i2 = i3;
        }
        AppMethodBeat.o(112412);
    }
}
