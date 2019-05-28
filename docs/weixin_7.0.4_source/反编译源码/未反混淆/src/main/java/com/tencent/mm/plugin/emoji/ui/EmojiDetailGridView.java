package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.SmileySubGrid;

public class EmojiDetailGridView extends SmileySubGrid {
    private String kWz;
    private EmojiDetailScrollView lac;
    private volatile boolean lad = true;

    public EmojiDetailGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(53367);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, j.INVALID_ID));
        AppMethodBeat.o(53367);
    }

    public void setScrollEnable(boolean z) {
        AppMethodBeat.i(53368);
        if (this.lac != null) {
            this.lac.setScrollEnable(z);
        }
        AppMethodBeat.o(53368);
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
