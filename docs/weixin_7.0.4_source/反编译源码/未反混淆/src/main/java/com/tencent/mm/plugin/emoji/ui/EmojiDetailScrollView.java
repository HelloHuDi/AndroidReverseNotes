package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmojiDetailScrollView extends ScrollView {
    private boolean lae;

    public EmojiDetailScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiDetailScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(53369);
        this.lae = true;
        setFadingEdgeLength(0);
        AppMethodBeat.o(53369);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
    }

    public void requestLayout() {
        AppMethodBeat.i(53370);
        this.lae = false;
        super.requestLayout();
        AppMethodBeat.o(53370);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(53371);
        this.lae = false;
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(53371);
    }

    public void scrollTo(int i, int i2) {
        this.lae = true;
    }

    public void scrollBy(int i, int i2) {
    }

    public void requestChildFocus(View view, View view2) {
    }

    public void setScrollEnable(boolean z) {
        this.lae = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(53372);
        if (this.lae) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(53372);
            return onInterceptTouchEvent;
        }
        AppMethodBeat.o(53372);
        return false;
    }
}
