package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.C5782a;
import com.tencent.neattextview.textview.p658b.C7376c;
import com.tencent.neattextview.textview.view.NeatTextView.C5788c;

/* renamed from: com.tencent.neattextview.textview.view.b */
public class C7380b implements OnDoubleTapListener, OnGestureListener, C5788c {
    private C5791a Aln;
    private C5782a Alo;
    protected C7376c Alp;
    private GestureDetector iay;
    protected View mView;

    public C7380b(Context context, C5791a c5791a) {
        AppMethodBeat.m2504i(3320);
        this.Aln = c5791a;
        this.iay = new GestureDetector(context, this);
        this.iay.setOnDoubleTapListener(this);
        AppMethodBeat.m2505o(3320);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3321);
        if (this.Aln.getLayout() == null) {
            AppMethodBeat.m2505o(3321);
            return false;
        }
        this.Alo = this.Aln.getLayout();
        this.mView = view;
        boolean onTouchEvent = this.iay.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            cancel(2);
        }
        AppMethodBeat.m2505o(3321);
        return onTouchEvent;
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3322);
        if (this.Aln.dPq()) {
            AppMethodBeat.m2505o(3322);
            return false;
        }
        for (C7376c c7376c : this.Alo.dPf()) {
            if (c7376c.mo11830ak(motionEvent.getX() - this.Aln.getHorizontalOffset(), motionEvent.getY() - this.Aln.getVerticalOffset())) {
                this.Alp = c7376c;
                c7376c.ozq = true;
                this.mView.postInvalidate();
                AppMethodBeat.m2505o(3322);
                return true;
            }
        }
        AppMethodBeat.m2505o(3322);
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3323);
        if (this.Aln.dPq()) {
            AppMethodBeat.m2505o(3323);
        } else {
            if (this.Alp != null) {
                C7376c c7376c = this.Alp;
                View view = this.mView;
                if (c7376c.AjW != null) {
                    ((ClickableSpan) c7376c.AjW).onClick(view);
                }
            }
            AppMethodBeat.m2505o(3323);
        }
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3324);
        cancel(1);
        AppMethodBeat.m2505o(3324);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.m2504i(3325);
        cancel(3);
        AppMethodBeat.m2505o(3325);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void cancel(int i) {
        AppMethodBeat.m2504i(3326);
        if (this.Alp != null) {
            this.Alp.ozq = false;
            this.mView.invalidate();
            this.Alp = null;
        }
        AppMethodBeat.m2505o(3326);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3327);
        if (this.Aln.getOnDoubleClickListener() != null) {
            this.Aln.getOnDoubleClickListener().mo11868fi(this.mView);
            AppMethodBeat.m2505o(3327);
            return true;
        }
        AppMethodBeat.m2505o(3327);
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}
