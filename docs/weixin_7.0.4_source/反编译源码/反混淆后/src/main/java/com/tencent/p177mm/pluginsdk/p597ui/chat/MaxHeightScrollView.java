package com.tencent.p177mm.pluginsdk.p597ui.chat;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.pluginsdk.ui.chat.MaxHeightScrollView */
public class MaxHeightScrollView extends ScrollView {
    /* renamed from: dj */
    private int f2974dj;

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(27951);
        init(context, attributeSet);
        AppMethodBeat.m2505o(27951);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(27952);
        init(context, attributeSet);
        AppMethodBeat.m2505o(27952);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int i = 0;
        AppMethodBeat.m2504i(27953);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C25738R.C8899a.MaxHeightScrollView, 0, 0);
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            while (i < indexCount) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                }
                i++;
            }
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.m2505o(27953);
        }
    }

    public void setMaxHeight(int i) {
        this.f2974dj = i;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(27954);
        if (this.f2974dj > 0) {
            i2 = MeasureSpec.makeMeasureSpec(this.f2974dj, C8415j.INVALID_ID);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(27954);
    }
}
