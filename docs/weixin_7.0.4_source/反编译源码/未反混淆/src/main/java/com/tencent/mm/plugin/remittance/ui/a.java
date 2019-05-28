package com.tencent.mm.plugin.remittance.ui;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements OnTouchListener {
    private a pQE;

    static class a implements Runnable {
        private View view;

        a(View view) {
            this.view = view;
        }

        public final void run() {
            AppMethodBeat.i(44801);
            View view = this.view;
            boolean performLongClick = view.performLongClick();
            while (!performLongClick) {
                View view2 = (View) view.getParent();
                if (view2 == null) {
                    break;
                }
                performLongClick = view2.performLongClick();
                view = view2;
            }
            AppMethodBeat.o(44801);
        }
    }

    public static a cfs() {
        AppMethodBeat.i(44802);
        a aVar = new a();
        AppMethodBeat.o(44802);
        return aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(44803);
        if (this.pQE == null) {
            this.pQE = new a(view);
        }
        TextView textView = (TextView) view;
        textView.setMovementMethod(null);
        Spannable newSpannable = Factory.getInstance().newSpannable(textView.getText());
        int action = motionEvent.getAction();
        if (action == 0 || action == 1) {
            int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
            int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
            Layout layout = textView.getLayout();
            x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(x, x, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                if (action == 0) {
                    view.postDelayed(this.pQE, (long) ViewConfiguration.getLongPressTimeout());
                } else {
                    view.removeCallbacks(this.pQE);
                    clickableSpanArr[0].onClick(textView);
                }
                AppMethodBeat.o(44803);
                return true;
            }
        } else if (action == 3) {
            view.removeCallbacks(this.pQE);
        }
        AppMethodBeat.o(44803);
        return false;
    }
}
