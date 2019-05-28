package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.a;
import com.tencent.neattextview.textview.view.NeatTextView.c;

public class b implements OnDoubleTapListener, OnGestureListener, c {
    private a Aln;
    private a Alo;
    protected com.tencent.neattextview.textview.b.c Alp;
    private GestureDetector iay;
    protected View mView;

    public b(Context context, a aVar) {
        AppMethodBeat.i(3320);
        this.Aln = aVar;
        this.iay = new GestureDetector(context, this);
        this.iay.setOnDoubleTapListener(this);
        AppMethodBeat.o(3320);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(3321);
        if (this.Aln.getLayout() == null) {
            AppMethodBeat.o(3321);
            return false;
        }
        this.Alo = this.Aln.getLayout();
        this.mView = view;
        boolean onTouchEvent = this.iay.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            cancel(2);
        }
        AppMethodBeat.o(3321);
        return onTouchEvent;
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(3322);
        if (this.Aln.dPq()) {
            AppMethodBeat.o(3322);
            return false;
        }
        for (com.tencent.neattextview.textview.b.c cVar : this.Alo.dPf()) {
            if (cVar.ak(motionEvent.getX() - this.Aln.getHorizontalOffset(), motionEvent.getY() - this.Aln.getVerticalOffset())) {
                this.Alp = cVar;
                cVar.ozq = true;
                this.mView.postInvalidate();
                AppMethodBeat.o(3322);
                return true;
            }
        }
        AppMethodBeat.o(3322);
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(3323);
        if (this.Aln.dPq()) {
            AppMethodBeat.o(3323);
        } else {
            if (this.Alp != null) {
                com.tencent.neattextview.textview.b.c cVar = this.Alp;
                View view = this.mView;
                if (cVar.AjW != null) {
                    ((ClickableSpan) cVar.AjW).onClick(view);
                }
            }
            AppMethodBeat.o(3323);
        }
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(3324);
        cancel(1);
        AppMethodBeat.o(3324);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.i(3325);
        cancel(3);
        AppMethodBeat.o(3325);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void cancel(int i) {
        AppMethodBeat.i(3326);
        if (this.Alp != null) {
            this.Alp.ozq = false;
            this.mView.invalidate();
            this.Alp = null;
        }
        AppMethodBeat.o(3326);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(3327);
        if (this.Aln.getOnDoubleClickListener() != null) {
            this.Aln.getOnDoubleClickListener().fi(this.mView);
            AppMethodBeat.o(3327);
            return true;
        }
        AppMethodBeat.o(3327);
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}
