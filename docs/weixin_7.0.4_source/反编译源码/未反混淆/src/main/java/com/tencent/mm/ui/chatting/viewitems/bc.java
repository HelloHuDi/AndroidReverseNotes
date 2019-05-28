package com.tencent.mm.ui.chatting.viewitems;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.a.a;

final class bc extends LinkMovementMethod {
    private a ziJ;

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        AppMethodBeat.i(33452);
        if (motionEvent.getAction() == 0) {
            this.ziJ = a(textView, spannable, motionEvent);
            if (this.ziJ != null) {
                this.ziJ.oT(true);
                Selection.setSelection(spannable, spannable.getSpanStart(this.ziJ), spannable.getSpanEnd(this.ziJ));
            }
        } else if (motionEvent.getAction() == 2) {
            a a = a(textView, spannable, motionEvent);
            if (!(this.ziJ == null || a == this.ziJ)) {
                this.ziJ.oT(false);
                this.ziJ = null;
                Selection.removeSelection(spannable);
            }
        } else {
            if (this.ziJ != null) {
                this.ziJ.oT(false);
                super.onTouchEvent(textView, spannable, motionEvent);
            }
            this.ziJ = null;
            Selection.removeSelection(spannable);
        }
        AppMethodBeat.o(33452);
        return true;
    }

    private static a a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        a aVar;
        AppMethodBeat.i(33453);
        int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
        a[] aVarArr = (a[]) spannable.getSpans(x, x, a.class);
        if (aVarArr.length > 0) {
            aVar = aVarArr[0];
        } else {
            aVar = null;
        }
        AppMethodBeat.o(33453);
        return aVar;
    }
}
