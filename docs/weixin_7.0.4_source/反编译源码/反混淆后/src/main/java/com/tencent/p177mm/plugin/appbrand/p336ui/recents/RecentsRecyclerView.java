package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.RecentsRecyclerView */
class RecentsRecyclerView extends LoadMoreRecyclerView {
    private View iPn;

    public RecentsRecyclerView(Context context) {
        super(context);
        AppMethodBeat.m2504i(133544);
        setChildrenDrawingOrderEnabled(true);
        AppMethodBeat.m2505o(133544);
    }

    public RecentsRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(133545);
        setChildrenDrawingOrderEnabled(true);
        AppMethodBeat.m2505o(133545);
    }

    public RecentsRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(133546);
        setChildrenDrawingOrderEnabled(true);
        AppMethodBeat.m2505o(133546);
    }

    public int getChildDrawingOrder(int i, int i2) {
        AppMethodBeat.m2504i(133547);
        int childDrawingOrder;
        if (this.iPn == null) {
            childDrawingOrder = super.getChildDrawingOrder(i, i2);
            AppMethodBeat.m2505o(133547);
            return childDrawingOrder;
        }
        childDrawingOrder = indexOfChild(this.iPn);
        if (childDrawingOrder < 0) {
            childDrawingOrder = super.getChildDrawingOrder(i, i2);
            AppMethodBeat.m2505o(133547);
            return childDrawingOrder;
        } else if (i2 == i - 1) {
            AppMethodBeat.m2505o(133547);
            return childDrawingOrder;
        } else if (i2 == childDrawingOrder) {
            childDrawingOrder = i - 1;
            AppMethodBeat.m2505o(133547);
            return childDrawingOrder;
        } else {
            childDrawingOrder = super.getChildDrawingOrder(i, i2);
            AppMethodBeat.m2505o(133547);
            return childDrawingOrder;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(133548);
        if (getItemAnimator() == null || !getItemAnimator().isRunning()) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.m2505o(133548);
            return onInterceptTouchEvent;
        }
        AppMethodBeat.m2505o(133548);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(133549);
        if (getItemAnimator() == null || !getItemAnimator().isRunning()) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.m2505o(133549);
            return dispatchTouchEvent;
        }
        AppMethodBeat.m2505o(133549);
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(133550);
        if (getItemAnimator() == null || !getItemAnimator().isRunning()) {
            boolean onTouchEvent;
            try {
                onTouchEvent = super.onTouchEvent(motionEvent);
                AppMethodBeat.m2505o(133550);
                return onTouchEvent;
            } catch (IndexOutOfBoundsException e) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                onTouchEvent = super.onTouchEvent(obtain);
                AppMethodBeat.m2505o(133550);
                return onTouchEvent;
            }
        }
        AppMethodBeat.m2505o(133550);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cy */
    public final void mo35023cy(View view) {
        AppMethodBeat.m2504i(133551);
        if (view.getParent() != this) {
            AppMethodBeat.m2505o(133551);
        } else if (VERSION.SDK_INT >= 21) {
            view.setZ(1.0f);
            AppMethodBeat.m2505o(133551);
        } else {
            this.iPn = view;
            AppMethodBeat.m2505o(133551);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cz */
    public final void mo35024cz(View view) {
        AppMethodBeat.m2504i(133552);
        if (view.getParent() != this) {
            AppMethodBeat.m2505o(133552);
        } else if (VERSION.SDK_INT >= 21) {
            view.setZ(0.0f);
            AppMethodBeat.m2505o(133552);
        } else {
            if (this.iPn == view) {
                this.iPn = null;
            }
            AppMethodBeat.m2505o(133552);
        }
    }
}
