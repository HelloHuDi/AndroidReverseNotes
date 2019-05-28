package com.tencent.p177mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.DragRecyclerView */
public abstract class DragRecyclerView extends RecyclerView implements OnGestureListener {
    private boolean iYA = false;
    DragFeatureView iYz;
    private GestureDetector iay;

    public DragRecyclerView(Context context) {
        super(context);
        init(context);
    }

    public DragRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DragRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.iay = new GestureDetector(context, this);
    }

    /* renamed from: h */
    public final void mo61306h(DragFeatureView dragFeatureView) {
        this.iYz = dragFeatureView;
    }

    public DragFeatureView getDragRubbishView() {
        return this.iYz;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.iay.onTouchEvent(motionEvent);
        if (this.iYA) {
            if (this.iYz != null) {
                this.iYz.onTouch(this, motionEvent);
            }
            int action = motionEvent.getAction();
            motionEvent.setAction(3);
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).dispatchTouchEvent(motionEvent);
            }
            motionEvent.setAction(action);
        }
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.iYA = false;
        }
        if (this.iYA || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (this.iYz != null) {
            this.iYz.onLongPress(motionEvent);
            this.iYA = this.iYz.getVisibility() == 0;
        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }
}
