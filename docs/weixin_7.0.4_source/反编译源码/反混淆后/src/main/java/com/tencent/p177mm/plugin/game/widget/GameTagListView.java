package com.tencent.p177mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.widget.GameTagListView */
public class GameTagListView extends LinearLayout {
    private int textColor;
    private int textSize;

    public GameTagListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(112411);
        super.onFinishInflate();
        this.textColor = getResources().getColor(C25738R.color.f12042qd);
        this.textSize = getResources().getDimensionPixelSize(C25738R.dimen.f9917k3);
        AppMethodBeat.m2505o(112411);
    }

    /* renamed from: f */
    public final void mo46170f(LinkedList<String> linkedList, int i) {
        AppMethodBeat.m2504i(112412);
        if (C5046bo.m7548ek(linkedList)) {
            setVisibility(8);
            AppMethodBeat.m2505o(112412);
            return;
        }
        setVisibility(0);
        while (getChildCount() < linkedList.size()) {
            TextView textView = new TextView(getContext());
            textView.setBackgroundResource(C25738R.drawable.f6759pl);
            textView.setMaxLines(1);
            textView.setTextColor(this.textColor);
            textView.setTextSize(0, (float) this.textSize);
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(C25738R.dimen.f9915k1), 0);
            textView.setLayoutParams(layoutParams);
            addView(textView);
        }
        int i2 = 0;
        float f = 0.0f;
        while (i2 < linkedList.size()) {
            String str = (String) linkedList.get(i2);
            C4990ab.m7410d("MicroMsg.GameTagListView", str);
            TextView textView2 = (TextView) getChildAt(i2);
            textView2.setVisibility(0);
            textView2.setText(str);
            f = ((float) getResources().getDimensionPixelSize(C25738R.dimen.f9915k1)) + (((textView2.getPaint().measureText(str) + ((float) textView2.getPaddingLeft())) + ((float) textView2.getPaddingRight())) + f);
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
        AppMethodBeat.m2505o(112412);
    }
}
