package com.tencent.mm.plugin.sns.ui;

import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLSysTextView;
import com.tencent.mm.kiss.widget.textview.SysTextView;
import com.tencent.mm.pluginsdk.ui.e.e;
import com.tencent.mm.pluginsdk.ui.e.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class aa implements OnTouchListener {
    private static o rkp;
    private static TextView rkq;

    /* JADX WARNING: Missing block: B:32:0x0099, code skipped:
            if (r6 > (((com.tencent.mm.kiss.widget.textview.PLSysTextView) r11).getVerticalDrawOffset() + r2.getHeight())) goto L_0x009b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(38305);
        TextView textView = (TextView) view;
        textView.getTag();
        CharSequence text = textView.getText();
        Layout layout = textView.getLayout();
        if (layout == null && (textView instanceof SysTextView)) {
            layout = ((SysTextView) textView).getTvLayout();
        }
        if (!(text instanceof Spannable) || layout == null) {
            AppMethodBeat.o(38305);
            return false;
        }
        Layout tvLayout;
        Spannable spannable = (Spannable) text;
        int action = motionEvent.getAction();
        Layout layout2 = textView.getLayout();
        if (layout2 == null && (textView instanceof SysTextView)) {
            tvLayout = ((SysTextView) textView).getTvLayout();
        } else {
            tvLayout = layout2;
        }
        textView.invalidate();
        if (textView == null || spannable == null || !e.a(textView, spannable)) {
            if (action == 1 || action == 0 || action == 2) {
                int verticalDrawOffset;
                boolean z;
                action = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (textView instanceof PLSysTextView) {
                    if (action >= ((PLSysTextView) textView).getHorizontalDrawOffset()) {
                        if (action <= ((PLSysTextView) textView).getHorizontalDrawOffset() + tvLayout.getWidth()) {
                            if (y >= ((PLSysTextView) textView).getVerticalDrawOffset()) {
                            }
                            AppMethodBeat.o(38305);
                            return false;
                        }
                    }
                    AppMethodBeat.o(38305);
                    return false;
                } else if (textView instanceof TextView) {
                    if (action < textView.getTotalPaddingLeft() || action > tvLayout.getWidth() + textView.getTotalPaddingLeft()) {
                        AppMethodBeat.o(38305);
                        return false;
                    } else if (y < textView.getTotalPaddingTop() || y > tvLayout.getHeight() + textView.getTotalPaddingTop()) {
                        AppMethodBeat.o(38305);
                        return false;
                    }
                }
                if (textView instanceof PLSysTextView) {
                    action -= ((PLSysTextView) textView).getHorizontalDrawOffset();
                    verticalDrawOffset = y - ((PLSysTextView) textView).getVerticalDrawOffset();
                } else if (textView instanceof TextView) {
                    action -= textView.getTotalPaddingLeft();
                    verticalDrawOffset = y - textView.getTotalPaddingTop();
                } else {
                    action -= textView.getPaddingLeft();
                    verticalDrawOffset = y - textView.getPaddingTop();
                }
                verticalDrawOffset = tvLayout.getOffsetForHorizontal(tvLayout.getLineForVertical(verticalDrawOffset + textView.getScrollY()), (float) (action + textView.getScrollX()));
                int action2 = motionEvent.getAction();
                o[] oVarArr = (o[]) spannable.getSpans(verticalDrawOffset, verticalDrawOffset, o.class);
                action = oVarArr.length - 1;
                ab.d("MicroMsg.MMOnTouchListener", " action span Len: " + oVarArr.length);
                if (textView.getLayout() == null && (textView instanceof SysTextView)) {
                    ((SysTextView) textView).getTvLayout();
                }
                if (oVarArr.length == 0) {
                    crX();
                    z = false;
                } else if (action2 == 1) {
                    oVarArr[action].onClick(textView);
                    new ak().postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(38304);
                            aa.crX();
                            AppMethodBeat.o(38304);
                        }
                    }, 300);
                    z = true;
                } else {
                    if (action2 == 0 || action2 == 2 || action2 == 3) {
                        crX();
                        rkp = oVarArr[action];
                        rkq = textView;
                        oVarArr[action].ozq = true;
                        textView.invalidate();
                        z = true;
                    }
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(38305);
                    return true;
                }
            }
            crX();
            AppMethodBeat.o(38305);
            return false;
        }
        AppMethodBeat.o(38305);
        return false;
    }

    public static void crX() {
        AppMethodBeat.i(38306);
        if (rkp != null) {
            rkp.ozq = false;
            rkq.invalidate();
            rkq = null;
            rkp = null;
        }
        AppMethodBeat.o(38306);
    }
}
