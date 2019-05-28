package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.support.v4.view.c;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class FoldableChatTextItemView extends LinearLayout {
    private c avD;
    private int maxHeight;
    private a zaM;

    public interface a {
    }

    public FoldableChatTextItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FoldableChatTextItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(32757);
        setTagObject(motionEvent);
        if (this.avD != null) {
            this.avD.onTouchEvent(motionEvent);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(32757);
        return onTouchEvent;
    }

    private void setTagObject(MotionEvent motionEvent) {
        AppMethodBeat.i(32758);
        setTag(R.id.cy, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        AppMethodBeat.o(32758);
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void setOnGestureListener(OnGestureListener onGestureListener) {
        AppMethodBeat.i(32759);
        this.avD = new c(getContext(), onGestureListener);
        AppMethodBeat.o(32759);
    }

    public void setFoldTextListener(a aVar) {
        this.zaM = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(32760);
        super.onMeasure(i, i2);
        AppMethodBeat.o(32760);
    }
}
