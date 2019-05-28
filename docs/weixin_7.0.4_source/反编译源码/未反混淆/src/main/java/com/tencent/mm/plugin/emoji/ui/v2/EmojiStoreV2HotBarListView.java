package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmojiStoreV2HotBarListView extends ListView {
    public EmojiStoreV2HotBarListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public EmojiStoreV2HotBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(53626);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, j.INVALID_ID));
        AppMethodBeat.o(53626);
    }
}
