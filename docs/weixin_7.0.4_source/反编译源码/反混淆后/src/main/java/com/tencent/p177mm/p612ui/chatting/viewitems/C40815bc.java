package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.p1421a.C30375a;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.bc */
final class C40815bc extends LinkMovementMethod {
    private C30375a ziJ;

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(33452);
        if (motionEvent.getAction() == 0) {
            this.ziJ = C40815bc.m70731a(textView, spannable, motionEvent);
            if (this.ziJ != null) {
                this.ziJ.mo39047oT(true);
                Selection.setSelection(spannable, spannable.getSpanStart(this.ziJ), spannable.getSpanEnd(this.ziJ));
            }
        } else if (motionEvent.getAction() == 2) {
            C30375a a = C40815bc.m70731a(textView, spannable, motionEvent);
            if (!(this.ziJ == null || a == this.ziJ)) {
                this.ziJ.mo39047oT(false);
                this.ziJ = null;
                Selection.removeSelection(spannable);
            }
        } else {
            if (this.ziJ != null) {
                this.ziJ.mo39047oT(false);
                super.onTouchEvent(textView, spannable, motionEvent);
            }
            this.ziJ = null;
            Selection.removeSelection(spannable);
        }
        AppMethodBeat.m2505o(33452);
        return true;
    }

    /* renamed from: a */
    private static C30375a m70731a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        C30375a c30375a;
        AppMethodBeat.m2504i(33453);
        int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
        C30375a[] c30375aArr = (C30375a[]) spannable.getSpans(x, x, C30375a.class);
        if (c30375aArr.length > 0) {
            c30375a = c30375aArr[0];
        } else {
            c30375a = null;
        }
        AppMethodBeat.m2505o(33453);
        return c30375a;
    }
}
