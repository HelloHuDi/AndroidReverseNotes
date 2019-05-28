package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.QFadeImageView;

public class TagImageView extends QFadeImageView {
    private int position = -1;

    public void setPosition(int i) {
        this.position = i;
    }

    public int getPosition() {
        return this.position;
    }

    public TagImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(39840);
        super.onMeasure(i, i2);
        AppMethodBeat.o(39840);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(39841);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(39841);
    }
}
