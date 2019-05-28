package com.tencent.mm.kiss.widget.textview.b;

import android.text.Layout;
import android.text.NoCopySpan.Concrete;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a;

public final class b {
    private static b eOk;
    private static Object eOl = new Concrete();

    public static boolean a(View view, Layout layout, Spannable spannable, MotionEvent motionEvent) {
        AppMethodBeat.i(105820);
        int action = motionEvent.getAction();
        if (view instanceof a) {
            a aVar = (a) view;
            if (action == 1 || action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < aVar.getHorizontalDrawOffset() || x > layout.getWidth() + aVar.getHorizontalDrawOffset()) {
                    AppMethodBeat.o(105820);
                    return false;
                } else if (y < aVar.getVerticalDrawOffset() || y > layout.getHeight() + aVar.getVerticalDrawOffset()) {
                    AppMethodBeat.o(105820);
                    return false;
                } else {
                    x = layout.getOffsetForHorizontal(layout.getLineForVertical((y - aVar.getVerticalDrawOffset()) + aVar.getScrollY()), (float) ((x - aVar.getHorizontalDrawOffset()) + aVar.getScrollX()));
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(x, x, ClickableSpan.class);
                    if (clickableSpanArr.length == 0) {
                        Selection.removeSelection(spannable);
                    } else if (action == 1) {
                        AppMethodBeat.o(105820);
                        return true;
                    } else {
                        Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                        AppMethodBeat.o(105820);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(105820);
            return false;
        }
        AppMethodBeat.o(105820);
        return false;
    }

    public static void a(Spannable spannable) {
        AppMethodBeat.i(105821);
        Selection.removeSelection(spannable);
        spannable.removeSpan(eOl);
        AppMethodBeat.o(105821);
    }

    public static b SV() {
        AppMethodBeat.i(105822);
        if (eOk == null) {
            eOk = new b();
        }
        b bVar = eOk;
        AppMethodBeat.o(105822);
        return bVar;
    }

    static {
        AppMethodBeat.i(105823);
        AppMethodBeat.o(105823);
    }
}
