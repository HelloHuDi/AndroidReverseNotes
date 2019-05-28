package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyEnvelopeTouchRecyclerView */
public class LuckyMoneyEnvelopeTouchRecyclerView extends RecyclerView {
    public C21222a oeF;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyEnvelopeTouchRecyclerView$a */
    public interface C21222a {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public LuckyMoneyEnvelopeTouchRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LuckyMoneyEnvelopeTouchRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(42720);
        if (this.oeF != null) {
            this.oeF.onInterceptTouchEvent(motionEvent);
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.m2505o(42720);
        return onInterceptTouchEvent;
    }
}
