package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;

class RecentsRecyclerView extends LoadMoreRecyclerView {
    private View iPn;

    public RecentsRecyclerView(Context context) {
        super(context);
        AppMethodBeat.i(133544);
        setChildrenDrawingOrderEnabled(true);
        AppMethodBeat.o(133544);
    }

    public RecentsRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(133545);
        setChildrenDrawingOrderEnabled(true);
        AppMethodBeat.o(133545);
    }

    public RecentsRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(133546);
        setChildrenDrawingOrderEnabled(true);
        AppMethodBeat.o(133546);
    }

    public int getChildDrawingOrder(int i, int i2) {
        AppMethodBeat.i(133547);
        int childDrawingOrder;
        if (this.iPn == null) {
            childDrawingOrder = super.getChildDrawingOrder(i, i2);
            AppMethodBeat.o(133547);
            return childDrawingOrder;
        }
        childDrawingOrder = indexOfChild(this.iPn);
        if (childDrawingOrder < 0) {
            childDrawingOrder = super.getChildDrawingOrder(i, i2);
            AppMethodBeat.o(133547);
            return childDrawingOrder;
        } else if (i2 == i - 1) {
            AppMethodBeat.o(133547);
            return childDrawingOrder;
        } else if (i2 == childDrawingOrder) {
            childDrawingOrder = i - 1;
            AppMethodBeat.o(133547);
            return childDrawingOrder;
        } else {
            childDrawingOrder = super.getChildDrawingOrder(i, i2);
            AppMethodBeat.o(133547);
            return childDrawingOrder;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(133548);
        if (getItemAnimator() == null || !getItemAnimator().isRunning()) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(133548);
            return onInterceptTouchEvent;
        }
        AppMethodBeat.o(133548);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(133549);
        if (getItemAnimator() == null || !getItemAnimator().isRunning()) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(133549);
            return dispatchTouchEvent;
        }
        AppMethodBeat.o(133549);
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(133550);
        if (getItemAnimator() == null || !getItemAnimator().isRunning()) {
            boolean onTouchEvent;
            try {
                onTouchEvent = super.onTouchEvent(motionEvent);
                AppMethodBeat.o(133550);
                return onTouchEvent;
            } catch (IndexOutOfBoundsException e) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                onTouchEvent = super.onTouchEvent(obtain);
                AppMethodBeat.o(133550);
                return onTouchEvent;
            }
        }
        AppMethodBeat.o(133550);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void cy(View view) {
        AppMethodBeat.i(133551);
        if (view.getParent() != this) {
            AppMethodBeat.o(133551);
        } else if (VERSION.SDK_INT >= 21) {
            view.setZ(1.0f);
            AppMethodBeat.o(133551);
        } else {
            this.iPn = view;
            AppMethodBeat.o(133551);
        }
    }

    /* Access modifiers changed, original: final */
    public final void cz(View view) {
        AppMethodBeat.i(133552);
        if (view.getParent() != this) {
            AppMethodBeat.o(133552);
        } else if (VERSION.SDK_INT >= 21) {
            view.setZ(0.0f);
            AppMethodBeat.o(133552);
        } else {
            if (this.iPn == view) {
                this.iPn = null;
            }
            AppMethodBeat.o(133552);
        }
    }
}
