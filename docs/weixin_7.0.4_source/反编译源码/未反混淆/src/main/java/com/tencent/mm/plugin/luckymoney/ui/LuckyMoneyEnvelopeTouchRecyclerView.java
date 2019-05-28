package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LuckyMoneyEnvelopeTouchRecyclerView extends RecyclerView {
    public a oeF;

    public interface a {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public LuckyMoneyEnvelopeTouchRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LuckyMoneyEnvelopeTouchRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(42720);
        if (this.oeF != null) {
            this.oeF.onInterceptTouchEvent(motionEvent);
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(42720);
        return onInterceptTouchEvent;
    }
}
