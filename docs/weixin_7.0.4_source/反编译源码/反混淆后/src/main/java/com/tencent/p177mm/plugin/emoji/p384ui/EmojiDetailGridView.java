package com.tencent.p177mm.plugin.emoji.p384ui;

import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.view.SmileySubGrid;

/* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiDetailGridView */
public class EmojiDetailGridView extends SmileySubGrid {
    private String kWz;
    private EmojiDetailScrollView lac;
    private volatile boolean lad = true;

    public EmojiDetailGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(53367);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, C8415j.INVALID_ID));
        AppMethodBeat.m2505o(53367);
    }

    public void setScrollEnable(boolean z) {
        AppMethodBeat.m2504i(53368);
        if (this.lac != null) {
            this.lac.setScrollEnable(z);
        }
        AppMethodBeat.m2505o(53368);
    }

    public void setEmojiDetailScrollView(EmojiDetailScrollView emojiDetailScrollView) {
        this.lac = emojiDetailScrollView;
    }

    public int getLongTouchTime() {
        return 200;
    }

    public String getProductId() {
        return this.kWz;
    }

    public void setProductId(String str) {
        this.kWz = str;
    }
}
