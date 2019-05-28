package com.tencent.p177mm.kiss.widget.textview.p857b;

import android.text.Layout;
import android.text.NoCopySpan.Concrete;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kiss.widget.textview.C18526a;

/* renamed from: com.tencent.mm.kiss.widget.textview.b.b */
public final class C9563b {
    private static C9563b eOk;
    private static Object eOl = new Concrete();

    /* renamed from: a */
    public static boolean m17031a(View view, Layout layout, Spannable spannable, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(105820);
        int action = motionEvent.getAction();
        if (view instanceof C18526a) {
            C18526a c18526a = (C18526a) view;
            if (action == 1 || action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < c18526a.getHorizontalDrawOffset() || x > layout.getWidth() + c18526a.getHorizontalDrawOffset()) {
                    AppMethodBeat.m2505o(105820);
                    return false;
                } else if (y < c18526a.getVerticalDrawOffset() || y > layout.getHeight() + c18526a.getVerticalDrawOffset()) {
                    AppMethodBeat.m2505o(105820);
                    return false;
                } else {
                    x = layout.getOffsetForHorizontal(layout.getLineForVertical((y - c18526a.getVerticalDrawOffset()) + c18526a.getScrollY()), (float) ((x - c18526a.getHorizontalDrawOffset()) + c18526a.getScrollX()));
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(x, x, ClickableSpan.class);
                    if (clickableSpanArr.length == 0) {
                        Selection.removeSelection(spannable);
                    } else if (action == 1) {
                        AppMethodBeat.m2505o(105820);
                        return true;
                    } else {
                        Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                        AppMethodBeat.m2505o(105820);
                        return true;
                    }
                }
            }
            AppMethodBeat.m2505o(105820);
            return false;
        }
        AppMethodBeat.m2505o(105820);
        return false;
    }

    /* renamed from: a */
    public static void m17030a(Spannable spannable) {
        AppMethodBeat.m2504i(105821);
        Selection.removeSelection(spannable);
        spannable.removeSpan(eOl);
        AppMethodBeat.m2505o(105821);
    }

    /* renamed from: SV */
    public static C9563b m17029SV() {
        AppMethodBeat.m2504i(105822);
        if (eOk == null) {
            eOk = new C9563b();
        }
        C9563b c9563b = eOk;
        AppMethodBeat.m2505o(105822);
        return c9563b;
    }

    static {
        AppMethodBeat.m2504i(105823);
        AppMethodBeat.m2505o(105823);
    }
}
