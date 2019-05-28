package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;

public class BannerEmojiView extends MMAnimateView {
    public BannerEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BannerEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(62469);
        int right = ((getRight() - getLeft()) - getPaddingRight()) - getPaddingLeft();
        int i3 = right / 2;
        if (right == 0 || i3 == 0) {
            right = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        float f = 0.53333336f;
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) {
            f = (1.0f * ((float) drawable.getIntrinsicHeight())) / ((float) drawable.getIntrinsicWidth());
        }
        setMeasuredDimension(right, (int) (f * ((float) right)));
        AppMethodBeat.o(62469);
    }
}
