package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AutoBottomScrollView extends ScrollView {
    public AutoBottomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoBottomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(13331);
        super.onSizeChanged(i, i2, i3, i4);
        postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(13330);
                AutoBottomScrollView.this.smoothScrollTo(0, AutoBottomScrollView.this.getBottom());
                AppMethodBeat.o(13330);
            }
        }, 100);
        AppMethodBeat.o(13331);
    }
}
