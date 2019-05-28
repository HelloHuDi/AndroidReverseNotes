package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;

public final class i extends ArrowKeyMovementMethod {
    private static i uRX;

    public static i dfD() {
        AppMethodBeat.i(26943);
        if (uRX == null) {
            uRX = new i();
        }
        i iVar = uRX;
        AppMethodBeat.o(26943);
        return iVar;
    }

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        AppMethodBeat.i(26944);
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int scrollX = textView.getScrollX() + (((int) motionEvent.getX()) - textView.getTotalPaddingLeft());
            int scrollY = textView.getScrollY() + (((int) motionEvent.getY()) - textView.getTotalPaddingTop());
            Layout layout = textView.getLayout();
            scrollY = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            k[] kVarArr = (k[]) spannable.getSpans(scrollY, scrollY + 1, k.class);
            if (scrollX < b.del() && kVarArr.length != 0) {
                if (action == 0) {
                    kVarArr[0].a(textView, spannable, motionEvent, kVarArr[0]);
                }
                AppMethodBeat.o(26944);
                return false;
            }
        }
        AppMethodBeat.o(26944);
        return false;
    }
}
