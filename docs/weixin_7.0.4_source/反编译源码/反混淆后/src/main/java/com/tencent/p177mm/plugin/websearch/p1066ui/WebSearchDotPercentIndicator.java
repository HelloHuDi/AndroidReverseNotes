package com.tencent.p177mm.plugin.websearch.p1066ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.websearch.ui.WebSearchDotPercentIndicator */
public class WebSearchDotPercentIndicator extends LinearLayout {
    private int hYk;
    private LayoutInflater mInflater;

    public WebSearchDotPercentIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(73806);
        init(context);
        AppMethodBeat.m2505o(73806);
    }

    public WebSearchDotPercentIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(73807);
        init(context);
        AppMethodBeat.m2505o(73807);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(73808);
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.m2505o(73808);
    }

    public void setDotsNum(int i) {
        AppMethodBeat.m2504i(73809);
        if (i <= 1) {
            i = 8;
        }
        this.hYk = i;
        removeAllViews();
        for (int i2 = 0; i2 < this.hYk; i2++) {
            addView((ImageView) this.mInflater.inflate(2130969641, this, false));
        }
        AppMethodBeat.m2505o(73809);
    }

    public void setPercent(float f) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        AppMethodBeat.m2504i(73810);
        if (f >= 0.0f) {
            f3 = f;
        }
        if (f3 <= 1.0f) {
            f2 = f3;
        }
        C4990ab.m7419v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", Float.valueOf(f2), Integer.valueOf((int) Math.rint((double) (((float) this.hYk) * f2))));
        int i = 0;
        while (i < r3 && i < getChildCount()) {
            ((ImageView) getChildAt(i)).setImageResource(C25738R.drawable.f6741ow);
            i++;
        }
        while (i < getChildCount()) {
            ((ImageView) getChildAt(i)).setImageResource(C25738R.drawable.f6740ov);
            i++;
        }
        AppMethodBeat.m2505o(73810);
    }
}
