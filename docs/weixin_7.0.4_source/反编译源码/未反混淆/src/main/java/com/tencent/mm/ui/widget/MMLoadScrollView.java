package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMLoadScrollView extends ScrollView {
    private a zMq;

    public interface a {
        void bmh();
    }

    public MMLoadScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMLoadScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(107884);
        if (z2 && i2 > 0 && this.zMq != null) {
            this.zMq.bmh();
        }
        super.onOverScrolled(i, i2, z, z2);
        AppMethodBeat.o(107884);
    }

    public void setOnTopOrBottomListerner(a aVar) {
        this.zMq = aVar;
    }
}
