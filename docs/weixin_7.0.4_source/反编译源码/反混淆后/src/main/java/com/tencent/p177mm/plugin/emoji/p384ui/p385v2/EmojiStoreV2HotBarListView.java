package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarListView */
public class EmojiStoreV2HotBarListView extends ListView {
    public EmojiStoreV2HotBarListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public EmojiStoreV2HotBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(53626);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, C8415j.INVALID_ID));
        AppMethodBeat.m2505o(53626);
    }
}
