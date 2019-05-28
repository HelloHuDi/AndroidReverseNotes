package com.tencent.p177mm.p612ui.chatting.view;

import android.content.Context;
import android.support.p057v4.view.C37130c;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.chatting.view.FoldableChatTextItemView */
public class FoldableChatTextItemView extends LinearLayout {
    private C37130c avD;
    private int maxHeight;
    private C36203a zaM;

    /* renamed from: com.tencent.mm.ui.chatting.view.FoldableChatTextItemView$a */
    public interface C36203a {
    }

    public FoldableChatTextItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FoldableChatTextItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(32757);
        setTagObject(motionEvent);
        if (this.avD != null) {
            this.avD.onTouchEvent(motionEvent);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(32757);
        return onTouchEvent;
    }

    private void setTagObject(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(32758);
        setTag(2131820679, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        AppMethodBeat.m2505o(32758);
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void setOnGestureListener(OnGestureListener onGestureListener) {
        AppMethodBeat.m2504i(32759);
        this.avD = new C37130c(getContext(), onGestureListener);
        AppMethodBeat.m2505o(32759);
    }

    public void setFoldTextListener(C36203a c36203a) {
        this.zaM = c36203a;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(32760);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(32760);
    }
}
