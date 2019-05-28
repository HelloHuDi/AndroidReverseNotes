package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMTagPanelScrollView;

/* renamed from: com.tencent.mm.ui.contact.LabelContainerView */
public class LabelContainerView extends MMTagPanelScrollView {
    /* renamed from: LJ */
    private int f13744LJ;
    /* renamed from: LW */
    boolean f13745LW = true;
    /* renamed from: Mb */
    float f13746Mb;
    /* renamed from: Mc */
    float f13747Mc;
    /* renamed from: Md */
    float f13748Md;
    /* renamed from: Me */
    float f13749Me;
    boolean zmM = false;
    boolean zmN = true;
    boolean zmO = false;
    float zmP;
    float zmQ;
    float zmR;
    float zmS;
    private C30632a zmT;

    /* renamed from: com.tencent.mm.ui.contact.LabelContainerView$a */
    public interface C30632a {
        void bmk();

        void bml();
    }

    public LabelContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(105208);
        dHU();
        AppMethodBeat.m2505o(105208);
    }

    public LabelContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(105209);
        dHU();
        AppMethodBeat.m2505o(105209);
    }

    public void setOnLabelContainerListener(C30632a c30632a) {
        this.zmT = c30632a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(105210);
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
                if ((actionIndex * actionIndex) + (i2 * i2) > this.f13744LJ) {
                    this.zmN = false;
                    AppMethodBeat.m2505o(105210);
                    return true;
                }
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.m2505o(105210);
        return onInterceptTouchEvent;
    }

    private void dHU() {
        AppMethodBeat.m2504i(105211);
        int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f13744LJ = scaledTouchSlop * scaledTouchSlop;
        AppMethodBeat.m2505o(105211);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(105212);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(105212);
        return dispatchTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(105213);
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
                this.f13745LW = true;
                this.f13746Mb = f2;
                this.f13748Md = f2;
                this.f13747Mc = f3;
                this.f13749Me = f3;
                this.zmM = true;
                break;
            case 1:
            case 3:
                if ((this.f13745LW || !this.zmM) && this.zmT != null) {
                    this.zmT.bmk();
                }
                this.f13745LW = true;
                this.zmM = false;
                break;
            case 2:
                if (!this.zmM) {
                    this.f13745LW = true;
                    this.f13746Mb = f2;
                    this.f13748Md = f2;
                    this.f13747Mc = f3;
                    this.f13749Me = f3;
                    this.zmM = true;
                }
                if (this.zmT != null) {
                    this.zmT.bml();
                }
                int i2 = (int) (f2 - this.f13748Md);
                actionIndex = (int) (f3 - this.f13749Me);
                if ((actionIndex * actionIndex) + (i2 * i2) > this.f13744LJ) {
                    this.f13745LW = false;
                    break;
                }
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(105213);
        return onTouchEvent;
    }
}
