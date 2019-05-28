package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C35746b;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.i */
public final class C44009i extends ArrowKeyMovementMethod {
    private static C44009i uRX;

    public static C44009i dfD() {
        AppMethodBeat.m2504i(26943);
        if (uRX == null) {
            uRX = new C44009i();
        }
        C44009i c44009i = uRX;
        AppMethodBeat.m2505o(26943);
        return c44009i;
    }

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(26944);
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int scrollX = textView.getScrollX() + (((int) motionEvent.getX()) - textView.getTotalPaddingLeft());
            int scrollY = textView.getScrollY() + (((int) motionEvent.getY()) - textView.getTotalPaddingTop());
            Layout layout = textView.getLayout();
            scrollY = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            C40387k[] c40387kArr = (C40387k[]) spannable.getSpans(scrollY, scrollY + 1, C40387k.class);
            if (scrollX < C35746b.del() && c40387kArr.length != 0) {
                if (action == 0) {
                    c40387kArr[0].mo63784a(textView, spannable, motionEvent, c40387kArr[0]);
                }
                AppMethodBeat.m2505o(26944);
                return false;
            }
        }
        AppMethodBeat.m2505o(26944);
        return false;
    }
}
