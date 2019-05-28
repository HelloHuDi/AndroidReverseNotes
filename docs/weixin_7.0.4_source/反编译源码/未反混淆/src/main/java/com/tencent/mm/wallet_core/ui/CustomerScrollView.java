package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomerScrollView extends ScrollView {
    private float AgR;
    private float AgS;
    private float AgT;
    private float AgU;

    public CustomerScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomerScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(49180);
        switch (motionEvent.getAction()) {
            case 0:
                this.AgS = 0.0f;
                this.AgR = 0.0f;
                this.AgT = motionEvent.getX();
                this.AgU = motionEvent.getY();
                break;
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.AgR += Math.abs(x - this.AgT);
                this.AgS += Math.abs(y - this.AgU);
                this.AgT = x;
                this.AgU = y;
                if (this.AgR > this.AgS) {
                    AppMethodBeat.o(49180);
                    return false;
                }
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(49180);
        return onInterceptTouchEvent;
    }
}
