package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomScrollView extends ScrollView {
    private a yso;

    public interface a {
        void a(ScrollView scrollView, int i, int i2);
    }

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnScrollChangeListener(a aVar) {
        this.yso = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(112504);
        super.onScrollChanged(i, i2, i3, i4);
        if (this.yso != null) {
            this.yso.a(this, i2, i4);
        }
        AppMethodBeat.o(112504);
    }
}
