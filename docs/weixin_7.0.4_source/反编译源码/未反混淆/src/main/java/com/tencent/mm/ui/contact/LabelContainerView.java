package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMTagPanelScrollView;

public class LabelContainerView extends MMTagPanelScrollView {
    private int LJ;
    boolean LW = true;
    float Mb;
    float Mc;
    float Md;
    float Me;
    boolean zmM = false;
    boolean zmN = true;
    boolean zmO = false;
    float zmP;
    float zmQ;
    float zmR;
    float zmS;
    private a zmT;

    public interface a {
        void bmk();

        void bml();
    }

    public LabelContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(105208);
        dHU();
        AppMethodBeat.o(105208);
    }

    public LabelContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(105209);
        dHU();
        AppMethodBeat.o(105209);
    }

    public void setOnLabelContainerListener(a aVar) {
        this.zmT = aVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(105210);
        int action = motionEvent.getAction();
        boolean z = (action & 255) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                f2 += motionEvent.getX(i);
                f += motionEvent.getY(i);
            }
        }
        actionIndex = z ? pointerCount - 1 : pointerCount;
        f2 /= (float) actionIndex;
        float f3 = f / ((float) actionIndex);
        switch (action) {
            case 0:
                this.zmN = true;
                this.zmQ = f2;
                this.zmP = f2;
                this.zmS = f3;
                this.zmR = f3;
                this.zmO = true;
                break;
            case 1:
            case 3:
                this.zmN = true;
                this.zmO = false;
                break;
            case 2:
                int i2 = (int) (f2 - this.zmP);
                actionIndex = (int) (f3 - this.zmR);
                if ((actionIndex * actionIndex) + (i2 * i2) > this.LJ) {
                    this.zmN = false;
                    AppMethodBeat.o(105210);
                    return true;
                }
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(105210);
        return onInterceptTouchEvent;
    }

    private void dHU() {
        AppMethodBeat.i(105211);
        int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.LJ = scaledTouchSlop * scaledTouchSlop;
        AppMethodBeat.o(105211);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(105212);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(105212);
        return dispatchTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(105213);
        int action = motionEvent.getAction();
        boolean z = (action & 255) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                f2 += motionEvent.getX(i);
                f += motionEvent.getY(i);
            }
        }
        actionIndex = z ? pointerCount - 1 : pointerCount;
        f2 /= (float) actionIndex;
        float f3 = f / ((float) actionIndex);
        switch (action) {
            case 0:
                this.LW = true;
                this.Mb = f2;
                this.Md = f2;
                this.Mc = f3;
                this.Me = f3;
                this.zmM = true;
                break;
            case 1:
            case 3:
                if ((this.LW || !this.zmM) && this.zmT != null) {
                    this.zmT.bmk();
                }
                this.LW = true;
                this.zmM = false;
                break;
            case 2:
                if (!this.zmM) {
                    this.LW = true;
                    this.Mb = f2;
                    this.Md = f2;
                    this.Mc = f3;
                    this.Me = f3;
                    this.zmM = true;
                }
                if (this.zmT != null) {
                    this.zmT.bml();
                }
                int i2 = (int) (f2 - this.Md);
                actionIndex = (int) (f3 - this.Me);
                if ((actionIndex * actionIndex) + (i2 * i2) > this.LJ) {
                    this.LW = false;
                    break;
                }
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(105213);
        return onTouchEvent;
    }
}
